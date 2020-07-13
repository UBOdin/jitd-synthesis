
import gzip
import json
import sys
import os
import io
import copy

import matplotlib as mpl
import matplotlib.pyplot as plt
import numpy as np
import matplotlib.patches as mpatches
import math


name_dict = {0:"DeleteElemFromSingleton", 1:"DeleteKeyFromSingleton", 2:"DeleteSingletonFromArray", \
	3:"DeleteElemFromArray", 4:"PushDownDontDeleteSingletonBtreeRight", 5:"PushDownDontDeleteSingletonBtreeLeft", \
	6:"PushDownDontDeleteElemBtree", 7:"PushDownSingletonRight", 8:"PushDownSingletonLeft", 9:"CrackArray", \
	10:"SortArray", 11:"after_remove_singleton", 12:"after_remove_elements", 13:"after_insert", \
	14:"after_insert_singleton", 15:"PushDownAndCrack"}


def create_cdf(input_list, maxitem = None, scale = 1.0):

	# input_list = []
	index_list = []
	bucket_list = []
	partial_bucket_sum = 0
	cum_bucket_list = []

	# Get maximum, modulo capped at a specified parameter (if any):
	if (maxitem == None):
		maxitem = max(input_list)
	else:
		maxitem = min(maxitem, max(input_list))
	#endif

	# Create index, buckets:
	for i in range(int(maxitem * scale) + 1):
		index_list.append(i)
		bucket_list.append(0)
	#end_for

	# Populate buckets:
	for e in input_list:
		if (e >= maxitem):
			continue
		#end_if
		bucket_list[int(e * scale)] += 1
	#end_for

	# Create Cumulative list:
	for i, e in zip(range(int(maxitem * scale) + 1), bucket_list):
		partial_bucket_sum += e
		cum_bucket_list.append(partial_bucket_sum)
	#end_for

	return index_list, cum_bucket_list, maxitem

#end_def



def process_loglines(input_file_name, results_list_list, type_dict):

	# input_file_name = ""
	# results_list_list = []
	# type_dict = {}
	input_file_obj = "" # file obj
	iteration = -1
	logline = ""
	logline_list = []
	view_type = 0
	delta0 = 0
	delta1 = 0
	delta2 = 0
	delta_total = 0

	id_list = []
	total_list = []

	uber_total = 0

	input_file_obj = open(input_file_name, "r")
	#input_file_obj = open(input_file_name, "r")

	while (True):

		iteration += 1

		# Keep reading until finished:
		try:
			logline = input_file_obj.readline() #.decode("ascii")
		except:
			print("File read error")
			sys.exit(1)
		#end_try

		if (logline == ""):
			break
		#end_if

		logline_list = logline.split("\t")
		if (len(logline_list) != 5):
			print("Unexpected length")
			sys.exit(1)
		#end_if

		if (int(logline_list[0]) != iteration):
			print("Unexpected ID")
			sys.exit(1)
		#end_if

		view_type = int(logline_list[1])
		delta0 = int(logline_list[2])
		delta1 = int(logline_list[3])
		delta2 = int(logline_list[4])

		delta_total = delta0 + delta1 + delta2

		if (delta_total > 100000):
			print("100k")
			print(iteration)
		#end_if

		id_list.append(iteration)
		total_list.append(delta_total)

		uber_total += delta_total

		if (view_type not in type_dict):
			type_dict[view_type] = [1, [iteration], [delta_total]]
		else:
			type_dict[view_type][0] += 1
			type_dict[view_type][1].append(iteration)
			type_dict[view_type][2].append(delta_total)
		#end_if

	#end_while

	print("Uber total:  " + str(uber_total))

	results_list_list.append(id_list)
	results_list_list.append(total_list)

	return

#end_def


def make_graph(workload, maintenance):

	# workload = ""
	# maintenance = ""
	input_file_name = ""
	results_list_list = []
	type_dict = {}

	if (maintenance == "jitd"):
		input_file_name = "view_results/output_view_performance_" + workload + ".txt"
	#end_if
	if (maintenance == "dbt"):
		input_file_name = "view_results/toaster_view_performance_" + workload + ".txt"
	#end_if

	process_loglines(input_file_name, results_list_list, type_dict)

	'''
	print(len(type_dict))
	for e in type_dict:
		print(type_dict[e][0])
		print(len(type_dict[e][1]))
		print(len(type_dict[e][2]))
	#end_for
	'''

	fig, ax = plt.subplots()
	fig2, ax2 = plt.subplots()

	fig.set_size_inches(16,8)
	fig2.set_size_inches(16,8)

	index_list = []
	cdf_list = []
	cdf_max_x = 0
	cdf_max_y = 0
	#ax.scatter(results_list_list[0], results_list_list[1], s = 1)
	for view_type in type_dict:
		# Plot maintenance time over maintenance operation number:
		ax.scatter(type_dict[view_type][1], type_dict[view_type][2], s = 1, label = name_dict[view_type] + " " + str(type_dict[view_type][0]))
		# Generate and plot CDF of maintenance time:
		index_list, cdf_list, _ = create_cdf(type_dict[view_type][2], maxitem = 100000)
		ax2.scatter(index_list, cdf_list, s = 1, label = name_dict[view_type] + " " + str(type_dict[view_type][0]))
		cdf_max_x = max(cdf_max_x, max(index_list))
		cdf_max_y = max(cdf_max_y, max(cdf_list))
	#end_for

	ax.set_title("JITD View Maintenance Time:  YCSB " + workload + "\n(Crack size 100)", fontsize = 14, fontweight = "bold")
	ax.set_xlabel("View maintenance set number", fontsize = 14, fontweight = "bold")
	ax.set_ylabel("Time (CPU ticks)", fontsize = 14, fontweight = "bold")
	ax.axis([0, len(results_list_list[0]), 0, max(results_list_list[1]) * 1.05])
	#ax.axis([0, len(results_list_list[0]), 0, 100000]) #max(results_list_list[1]) * 1.05])
	ax.legend(loc = "upper right", markerscale = 8)

	print(len(results_list_list[0]))
	print(max(results_list_list[1]))

	ax2.set_title(maintenance.upper() + " View Maintenance CDF:  YCSB " + workload + "\n(Crack size 100)", fontsize = 14, fontweight = "bold")
	ax2.set_xlabel("View maintenance time (CPU ticks) (Max 100k)", fontsize = 14, fontweight = "bold")
	ax2.set_ylabel("Number of view maintenance sets\ntaking a given time (cumulative)", fontsize = 14, fontweight = "bold")
	ax2.axis([0, cdf_max_x * 1.05, 0, cdf_max_y * 1.05])
	ax2.legend(loc = "center right", markerscale = 8)

	fig.savefig("view_graphs/view_time_" + workload + "_" + maintenance + ".png")
	fig2.savefig("view_graphs/view_cdf_" + workload + "_" + maintenance + ".png")
	#plt.show()

#end_def


def script():

	#workload_list = ["a", "b", "c", "d", "e", "f"]
	workload_list = ["a", "b", "c", "d", "f"]

	maintenance_list = ["jitd", "dbt"]

	for maintenance in maintenance_list:
		for workload in workload_list:
			print("Processing maintenance " + maintenance + " and workload " + workload)
			make_graph(workload, maintenance)
		#end_for
	#end_for

#end_def


def specific():

	make_graph(sys.argv[1])

#end_def


script()

