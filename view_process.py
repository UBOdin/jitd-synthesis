
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

'''
name_dict = {0:"DeleteElemFromSingleton", 1:"DeleteKeyFromSingleton", 2:"DeleteSingletonFromArray", \
	3:"DeleteElemFromArray", 4:"PushDownDontDeleteSingletonBtreeRight", 5:"PushDownDontDeleteSingletonBtreeLeft", \
	6:"PushDownDontDeleteElemBtree", 7:"PushDownSingletonRight", 8:"PushDownSingletonLeft", 9:"CrackArray", \
	10:"SortArray", 11:"after_remove_singleton", 12:"after_remove_elements", 13:"after_insert", \
	14:"after_insert_singleton", 15:"PushDownAndCrack"}
'''
name_dict = {0:"DeleteElemFromSingleton", 1:"DeleteKeyFromSingleton", 2:"DeleteSingletonFromArray", \
	3:"DeleteElemFromArray", 4:"PushDownDontDeleteSingletonBtreeRight", 5:"PushDownDontDeleteSingletonBtreeLeft", \
	6:"PushDownDontDeleteElemBtree", 7:"PushDownSingletonRight", 8:"PushDownSingletonLeft", 9:"CrackArray", \
	10:"SortArray", 11:"after_remove_singleton", 12:"after_remove_elements", 13:"after_insert", \
	14:"after_insert_singleton", 15:"PushDownAndCrack", 100:"searchFor"}


runcount = 3  # Number of runs in each dimension type
#xdim = 22 #10
#ydim =  12 #6

xdim = 14
ydim = 9
savepdf = True
setbox = True

n_naive = "Nai"
n_set = "Set"
n_classic = "Clas"
n_dbt = "DBT"
n_tt = "TT"


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



def process_loglines(input_file_name, results_list_list, datatype):

	# input_file_name = ""
	# results_list_list = []
	# datatype = 0  # Node or transform + search collection
	input_file_obj = "" # file obj
	iteration = 0
	logline = ""
	logline_list = []
	trans_type = 0
	delta0 = 0
	delta1 = 0
	delta2 = 0
	delta_total = 0

	trans_list_list = results_list_list[0]
	node_list_list = results_list_list[1]
	search_list_list = results_list_list[2]

	node_type = 0  # table node 0-6

	id_list = []
	total_list = []

	uber_total = 0

	input_file_obj = open(input_file_name, "r")
	#input_file_obj = open(input_file_name, "r")

	logline = input_file_obj.readline()  # Skip first line

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
		if (len(logline_list) != 8):
			print("Unexpected length")
			sys.exit(1)
		#end_if

		if (int(logline_list[0]) != iteration):
			print("Unexpected ID")
			sys.exit(1)
		#end_if

		trans_type = int(logline_list[1])
		delta0 = int(logline_list[2])
		delta1 = int(logline_list[3])
		delta2 = int(logline_list[4])

		delta_total = delta0 + delta1 + delta2

		if (delta_total > 100000):
			print("Long latency:  %d on %d" % (iteration, delta_total))
		#end_if

		if (datatype == 1):  # Collect node data
			node_type = int(logline_list[7])
			# Read operations (>= 100) are not node table maintenance operations.  Skip:
			if (trans_type < 100):
				node_list_list[node_type].append(delta_total)
			#end_if
		#end_if
		elif (datatype == 2):  # Collect transform + search data:
			if (trans_type < 100):
				trans_list_list[trans_type].append(delta_total)
			else:
				search_list_list[trans_type - 100].append(delta_total)
			#end_if
		else:
			print("Invalid data type")
			exit(1)
		#end_if


		#uber_total += delta_total

	#end_while

	#'''
	print("\nIteration\n")
	node_list = []
	for i in range(len(node_list_list)):
		node_list = node_list_list[i]
		print(i)
		print(len(node_list))
		#print(node_list)
	#end_for
	#'''

	return

#end_def


def graph_node_boxplots(workload):

	# workload = ""
	input_file_prefix = ""
	input_file_name = ""
	set_results_list_list = [[], [], []]
	jitd_results_list_list = [[], [], []]
	toaster_results_list_list = [[], [], []]
	classic_results_list_list = [[], [], []]

	for i in range(7):
		set_results_list_list[1].append([])
		jitd_results_list_list[1].append([])
		toaster_results_list_list[1].append([])
		classic_results_list_list[1].append([])
	#end_for

	fig_list, ax_list = plt.subplots()  #1, 3, sharex = True)
	if (setbox == True):
		fig_list.set_size_inches(14, 4)
	#endif

	for i in range(runcount):

		print(i)

		input_file_name = "view_results/set_node_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, set_results_list_list, 1)

		input_file_name = "view_results/view_node_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, jitd_results_list_list, 1)

		input_file_name = "view_results/toaster_node_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, toaster_results_list_list, 1)

		input_file_name = "view_results/classic_node_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, classic_results_list_list, 1)

	#end_for


	boxplot_list = []
	boxplot_list.append([])
	#for i in range(7):
	# Skip node type 1 (DeleteElements) and 4 (SortedArray):
	for i in [0, 2, 3, 5, 6]:

		boxplot_list.append(set_results_list_list[1][i])
		boxplot_list.append(classic_results_list_list[1][i])
		boxplot_list.append(toaster_results_list_list[1][i])
		boxplot_list.append(jitd_results_list_list[1][i])
		boxplot_list.append([])

	#end_for

	bp = ax_list.boxplot(boxplot_list)

	ax_list.set_title("Node (Table) Operation Latency (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax_list.set_xlabel("Node Operation Type", fontsize = 14, fontweight = "bold")
	ax_list.set_ylabel("Operation Latency", fontsize = 14, fontweight = "bold")
	ax_list.axis([1, 26, 0, 1250])

	x_labels = ax_list.get_xticklabels()
	x_labels = ["", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, ""]
	x_labels[0] = "\n                                               Delete Singleton"
	x_labels[5] = "\n                                                 B-Tree"
	x_labels[10] = "\n                                                Concat"
	x_labels[15] = "\n                                                Array"
	x_labels[20] = "\n                                                Singleton"

	ax_list.set_xticklabels(x_labels)

	if (savepdf == True):
		#fig_list.tight_layout()
		fig_list.savefig("view_graphs/view_node_boxplot_" + workload + ".pdf", bbox_inches = "tight");
	else:
		fig_list.savefig("view_graphs/view_node_boxplot_" + workload + ".png");
	#endif

	#plt.show()

#end_def


def graph_transform_boxplots(workload):

	# workload = ""
	input_file_prefix = ""
	input_file_name = ""
	naive_results_list_list = [[], [], []]
	set_results_list_list = [[], [], []]
	jitd_results_list_list = [[], [], []]
	toaster_results_list_list = [[], [], []]
	classic_results_list_list = [[], [], []]


	for i in range(20):
		naive_results_list_list[0].append([])
		set_results_list_list[0].append([])
		jitd_results_list_list[0].append([])
		toaster_results_list_list[0].append([])
		classic_results_list_list[0].append([])
		naive_results_list_list[2].append([])
		set_results_list_list[2].append([])
		jitd_results_list_list[2].append([])
		toaster_results_list_list[2].append([])
		classic_results_list_list[2].append([])
	#end_for


	for i in range(runcount):

		print(i)

		input_file_name = "view_results/naive_trans_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, naive_results_list_list, 2)

		input_file_name = "view_results/set_trans_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, set_results_list_list, 2)

		input_file_name = "view_results/view_trans_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, jitd_results_list_list, 2)

		input_file_name = "view_results/toaster_trans_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, toaster_results_list_list, 2)

		input_file_name = "view_results/classic_trans_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, classic_results_list_list, 2)

	#end_for


	boxplot_trans_list = []
	boxplot_search_list = []
	#boxplot_list.append([])
	#for i in range(20):
	# Skip node type 1 (DeleteElements) and 4 (SortedArray):
	#for i in [2, 4, 5, 7, 8, 9, 11, 14]:
	for i in [4, 5, 7, 8, 9, 11, 14]:
		boxplot_trans_list.append([])
		# N.b. No transform view maintenance for naive -- naive_results_list_list[0][i]
		boxplot_trans_list.append(set_results_list_list[0][i])
		boxplot_trans_list.append(classic_results_list_list[0][i])
		boxplot_trans_list.append(toaster_results_list_list[0][i])
		boxplot_trans_list.append(jitd_results_list_list[0][i])
		boxplot_search_list.append([])
		boxplot_search_list.append(naive_results_list_list[2][i])
		boxplot_search_list.append(set_results_list_list[2][i])
		boxplot_search_list.append(classic_results_list_list[2][i])
		boxplot_search_list.append(toaster_results_list_list[2][i])
		boxplot_search_list.append(jitd_results_list_list[2][i])
	#end_for


	naive_uber_list = []
	set_uber_list = []
	jitd_uber_list = []
	toaster_uber_list = []
	classic_uber_list = []
	#for i in [2, 4, 5, 7, 8, 9, 11, 14]:
	for i in [4, 5, 7, 8, 9, 11, 14]:

		# N.b. No transform view maintenance for naive -- naive_results_list_list[0][i]
		for e in naive_results_list_list[2][i]:
			naive_uber_list.append(e)
		#end_for

		for e in set_results_list_list[0][i]:
			set_uber_list.append(e)
		#end_for
		for e in set_results_list_list[2][i]:
			set_uber_list.append(e)
		#end_for

		for e in jitd_results_list_list[0][i]:
			jitd_uber_list.append(e)
		#end_for
		for e in jitd_results_list_list[2][i]:
			jitd_uber_list.append(e)
		#end_for

		for e in toaster_results_list_list[0][i]:
			toaster_uber_list.append(e)
		#end_for

		for e in toaster_results_list_list[2][i]:
			toaster_uber_list.append(e)
		#end_for

		for e in classic_results_list_list[0][i]:
			classic_uber_list.append(e)
		#end_for

		for e in classic_results_list_list[2][i]:
			classic_uber_list.append(e)
		#end_for

	#end_for


	fig_list, ax_list = plt.subplots()
	if (setbox == True):
		fig_list.set_size_inches(14, 8)
	#end_if

	bp_trans = ax_list.boxplot(boxplot_trans_list)

	ax_list.set_title("Transform Operation Latency (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax_list.set_xlabel("Transform Operation Type", fontsize = 14, fontweight = "bold")
	ax_list.set_ylabel("Operation Latency", fontsize = 14, fontweight = "bold")
	#ax_list.axis([1, (4 * 8 + 1), 0, 20000])

	x_labels = ax_list.get_xticklabels()
	#  N.b. No data/plots for naive -- no view maintenance structures to update
	x_labels = ["", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, ""]
	#x_labels[0] = "\n                                                 DeleteSingletonFromArray"
	x_labels[0] = "\n\n                                        PushDownDontDelete\n                                          SingletonBtreeRight"
	x_labels[5] = "\n\n                                        PushDownDontDelete\n                                          SingeltonBtreeLeft"
	x_labels[10] = "\n\n                                          PushDown\n                                        SingletonRight"
	x_labels[15] = "\n\n                                          PushDown\n                                        SingletonLeft"
	x_labels[20] = "\n\n                                     CrackArray"
	x_labels[25] = "\n\n                                    remove_singleton"
	x_labels[30] = "\n\n                                    insert_singleton"
	ax_list.axis([1, 36, 0, 17000])
	ax_list.set_xticklabels(x_labels)

	tick_list = ax_list.get_xticklabels()
	for i in range(len(tick_list)):
		if (i % 5 != 0):
			tick_list[i].set_rotation(-45)
			tick_list[i].set_ha("left")
		#end_if
	#end_for

	if (savepdf == True):
		fig_list.savefig("view_graphs/view_trans_boxplot_" + workload + ".pdf", bbox_inches = "tight");
	else:
		fig_list.savefig("view_graphs/view_trans_boxplot_" + workload + ".png");
	#endif


	fig2_list, ax2_list = plt.subplots()
	if (setbox == True):
		fig2_list.set_size_inches(14, 4)
	#end_if

	bp_search = ax2_list.boxplot(boxplot_search_list, showmeans = False)

	ax2_list.set_title("Transform Search Latency (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax2_list.set_xlabel("Transform Operation Type", fontsize = 14, fontweight = "bold")
	ax2_list.set_ylabel("Search Latency", fontsize = 14, fontweight = "bold")
	ax2_list.axis([1, 31, 0, 50000])

	x_labels = ax2_list.get_xticklabels()
	x_labels = ["", n_naive, n_set, n_classic, n_dbt, n_tt, "", n_naive, n_set, n_classic, n_dbt, n_tt, "", n_naive, n_set, n_classic, n_dbt, n_tt, "", n_naive, n_set, n_classic, n_dbt, n_tt, "", n_naive, n_set, n_classic, n_dbt, n_tt, ""]
	#x_labels[0] = "\n\n                                              DeleteSingletonFromArray"
	x_labels[0] = "\n\n                                               PushDownDontDelete\n                                              SingletonBtreeRight"
	x_labels[6] = "\n\n                                              PushDownDontDelete\n                                              SingeltonBtreeLeft"
	x_labels[12] = "\n\n                                                PushDownSingletonRight"
	x_labels[18] = "\n\n                                                PushDownSingletonLeft"
	x_labels[24] = "\n\n                                                CrackArray"
	#  N.b. No data/plots for insert_singleton or remove_singleton -- these are mutate only
	ax2_list.set_xticklabels(x_labels)

	tick_list = ax2_list.get_xticklabels()
	for i in range(len(tick_list)):
		if (i % 6 != 0):
			tick_list[i].set_rotation(-45)
			tick_list[i].set_ha("left")
		#end_if
	#end_for

	if (savepdf == True):
		fig2_list.savefig("view_graphs/view_search_boxplot_" + workload + ".pdf", bbox_inches = "tight");
	else:
		fig2_list.savefig("view_graphs/view_search_boxplot_" + workload + ".png");
	#endif


	fig3_list, ax3_list = plt.subplots()
	if (setbox == True):
		fig3_list.set_size_inches(xdim, ydim)
	#end_if

	bp_total = ax3_list.boxplot([naive_uber_list, set_uber_list, classic_uber_list, toaster_uber_list, jitd_uber_list], showmeans = True)

	ax3_list.set_title("Average View Operation Latency by Type (Search + Maintenance) (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax3_list.set_xlabel("Maintenance Method", fontsize = 14, fontweight = "bold")
	ax3_list.set_ylabel("Average View Operation Latency (Search + Maintnenace)", fontsize = 14, fontweight = "bold")
	ax3_list.axis([0, 6, 0, 120000])
	x_labels = ax3_list.get_xticklabels()
	x_labels = ["Naive", "Set", "Classic", "DBT", "TT"]
	ax3_list.set_xticklabels(x_labels)

	if (savepdf == True):
		fig3_list.savefig("view_graphs/view_total_boxplot_" + workload + ".pdf", bbox_inches = "tight");
	else:
		fig3_list.savefig("view_graphs/view_total_boxplot_" + workload + ".png");
	#endif


	#plt.show()

#end_def


def main():

	#workload_list = ["a", "b", "c", "d", "e", "f"]
	#workload_list = ["a", "b", "c", "d", "f"]
	workload_list = ["a", "f"]

	for workload in workload_list:
		print("Processing maintenance " + workload)
		graph_node_boxplots(workload)
		graph_transform_boxplots(workload)
	#end_for

#end_def


main()


