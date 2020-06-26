
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
	# maxitem = 0
	index_list = []
	bucket_list = []
	partial_bucket_sum = 0
	cum_bucket_list = []

	# Get maximum, if none specified:
	if (maxitem == None):
		maxitem = input_list[0]
		for e in input_list:
			if (e > maxitem):
				maxitem = e
			#end_if
		#end_for
	#end_if

	# Create index, buckets:
	for i in range(int(maxitem * scale) + 1):
		index_list.append(i)
		bucket_list.append(0)
	#end_for

	# Populate buckets:
	for e in input_list:
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

		id_list.append(iteration)
		total_list.append(delta_total)

		if (view_type not in type_dict):
			type_dict[view_type] = [1, [iteration], [delta_total]]
		else:
			type_dict[view_type][0] += 1
			type_dict[view_type][1].append(iteration)
			type_dict[view_type][2].append(delta_total)
		#end_if

	#end_while

	results_list_list.append(id_list)
	results_list_list.append(total_list)

	return

#end_def


def make_graph(workload):

	#workload = ""
	input_file_name = ""
	results_list_list = []
	type_dict = {}

	input_file_name = "view_results/output_view_" + workload + ".txt"

	process_loglines(input_file_name, results_list_list, type_dict)

	print(len(type_dict))
	for e in type_dict:
		print(type_dict[e][0])
		print(len(type_dict[e][1]))
		print(len(type_dict[e][2]))
	#end_for

	fig, ax = plt.subplots()

	fig.set_size_inches(16,8)

	#ax.scatter(results_list_list[0], results_list_list[1], s = 1)
	for view_type in type_dict:
		ax.scatter(type_dict[view_type][1], type_dict[view_type][2], s = 1, label = name_dict[view_type] + " " + str(type_dict[view_type][0]))
	#end_for

	ax.set_title("JITD View Operation Time:  YCSB " + workload + "\n(Crack size 100)", fontsize = 14, fontweight = "bold")
	ax.set_xlabel("View operation number", fontsize = 14, fontweight = "bold")
	ax.set_ylabel("Time (CPU ticks)", fontsize = 14, fontweight = "bold")
	ax.axis([0, len(results_list_list[0]), 0, max(results_list_list[1]) * 1.05])
	#ax.axis([0, len(results_list_list[0]), 0, 100000]) #max(results_list_list[1]) * 1.05])
	ax.legend(loc = "upper right", markerscale = 8)

	print(len(results_list_list[0]))
	print(max(results_list_list[1]))

	fig.savefig("view_graphs/view_graph_" + workload + ".png")
	#plt.show()

#end_def


def script():

	#workload_list = ["a", "b", "c", "d", "e", "f"]
	workload_list = ["a", "b", "c", "d", "f"]

	for workload in workload_list:
		make_graph(workload)
	#end_for

#end_def


def specific():

	make_graph(sys.argv[1])

#end_def


script()


