
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


runcount = 10  # Number of runs in each dimension type
#xdim = 22 #10
#ydim =  12 #6

xdim = 14
ydim = 2
savepdf = True
setbox = True

n_naive = "Naive"
n_set = "Index"
n_classic = "Classic"
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
	# datatype = 0  # Collect per-node information (1), or per-transform information (2-3-4)
	input_file_obj = "" # file obj
	iteration = -1
	logline = ""
	logline_list = []
	trans_type = 0
	delta0 = 0
	delta1 = 0
	delta2 = 0
	delta_total = 0
	search_total = 0

	trans_list_list = results_list_list[0]
	node_list_list = results_list_list[1]
	search_list_list = results_list_list[2]

	node_type = 0  # table node 0-6

	id_list = []
	total_list = []

	uber_total = 0

	input_file_obj = open(input_file_name, "r")
	#input_file_obj = open(input_file_name, "r")

	#logline = input_file_obj.readline()  # Skip first line

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

		'''
		if (delta_total > 100000):
			print("Long latency:  %d on %d" % (iteration, delta_total))
		#end_if
		'''

		if (datatype == 1):  # Collect node data
			node_type = int(logline_list[7])
			# Read operations (>= 100) are not node table maintenance operations.  Skip:
			if (node_type == 7):
				node_type = 3
			elif (node_type == 8):
				node_type = 0
			elif (node_type == 9):
				node_type = 5
			#end_if

			if (trans_type < 100):
				node_list_list[node_type].append(delta_total)
			#end_if
		elif (datatype >= 2):  # Collect transform + search data:
			if (trans_type >= 100):
				search_list_list[trans_type - 100].append(delta_total)
				search_total += delta_total
			elif ((trans_type == 11) or (trans_type == 14)):
				search_total = 0  # Clear previous search latency
			else:
				if (datatype == 2):
					trans_list_list[trans_type].append(search_total)
				elif (datatype == 3):
					trans_list_list[trans_type].append(delta_total)
				elif (datatype == 4):
					trans_list_list[trans_type].append(search_total + delta_total)
				else:
					print("Invalid data type  != 2-3-4")
					sys.exit(1)
				#end_if
				search_total = 0  # Reset sum
			#end_if
		else:
			print("Invalid data type")
			exit(1)
		#end_if


		#uber_total += delta_total

	#end_while

	'''
	print("\nIteration\n")
	node_list = []
	for i in range(len(node_list_list)):
		node_list = node_list_list[i]
		print(i)
		print(len(node_list))
		#print(node_list)
	#end_for
	'''

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

	for i in range(10):
		set_results_list_list[1].append([])
		jitd_results_list_list[1].append([])
		toaster_results_list_list[1].append([])
		classic_results_list_list[1].append([])
	#end_for

	for i in range(runcount):

		print(i)

		input_file_name = "tracefiles/set_node_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, set_results_list_list, 1)

		input_file_name = "tracefiles/view_node_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, jitd_results_list_list, 1)

		input_file_name = "tracefiles/toaster_node_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, toaster_results_list_list, 1)

		input_file_name = "tracefiles/classic_node_performance_" + workload + "_" + str(i) + ".txt"
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


	fig_list, ax_list = plt.subplots()
	if (setbox == True):
		fig_list.set_size_inches(xdim, ydim)
	#endif

	bp = ax_list.boxplot(boxplot_list)

	#ax_list.set_title("Node (Table) Operation Latency (Workload " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	#ax_list.set_xlabel("Node operation type", fontsize = 14, fontweight = "bold")
	ax_list.set_ylabel("Operation latency\n(CPU ticks)", fontsize = 14, fontweight = "bold")
	ax_list.axis([1, 26, 0, 1250])

	x_labels = ax_list.get_xticklabels()
	x_labels = ["", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, ""]
	x_labels[0] = "\n\n                                               Delete Singleton"
	x_labels[5] = "\n\n                                                 B-Tree"
	x_labels[10] = "\n\n                                                Concat"
	x_labels[15] = "\n\n                                                Array"
	x_labels[20] = "\n\n                                                Singleton"
	ax_list.set_xticklabels(x_labels)

	tick_list = ax_list.get_xticklabels()
	for i in range(len(tick_list)):
		if (i % 5 != 0):
			tick_list[i].set_rotation(-15)
			tick_list[i].set_ha("left")
		#end_if
	#end_for

	if (workload == "d"):
		ax_list.annotate("  N/A -- Workload D has\nno delete operations", xy = (1.8, 550))
	#end_if

	if (savepdf == True):
		#fig_list.tight_layout()
		fig_list.savefig("graphs/view_node_boxplot_" + workload + ".pdf", bbox_inches = "tight");
	else:
		fig_list.savefig("graphs/view_node_boxplot_" + workload + ".png");
	#endif

	#endif

	#plt.show()

#end_def


def graph_transform_boxplots(workload, datatype):

	# workload = ""
	# datatype = 0  # Collect per-transform latency on search (2), maintenance (3), or both (4)
	input_file_prefix = ""
	input_file_name = ""
	naive_results_list_list = [[], [], []]
	set_results_list_list = [[], [], []]
	jitd_results_list_list = [[], [], []]
	toaster_results_list_list = [[], [], []]
	classic_results_list_list = [[], [], []]
	subgraph = ""


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

		input_file_name = "tracefiles/naive_trans_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, naive_results_list_list, datatype)

		input_file_name = "tracefiles/set_trans_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, set_results_list_list, datatype)

		input_file_name = "tracefiles/view_trans_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, jitd_results_list_list, datatype)

		input_file_name = "tracefiles/toaster_trans_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, toaster_results_list_list, datatype)

		input_file_name = "tracefiles/classic_trans_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, classic_results_list_list, datatype)

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


	fig_list, ax_list = plt.subplots()
	if (setbox == True):
		fig_list.set_size_inches(xdim, ydim)
	#end_if

	bp_trans = ax_list.boxplot(boxplot_trans_list)

	height_dict = {"a":80000, "b":50000, "c":50000, "d":50000, "f":80000}
	height = height_dict[workload]

	#ax_list.set_title("Transform Operation Latency (Workload " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	#ax_list.set_xlabel("Target transform operation (Node) Type (View)", fontsize = 14, fontweight = "bold")
	ax_list.set_ylabel("Operation latency\n(CPU ticks)", fontsize = 14, fontweight = "bold")
	ax_list.axis([1, 26, 0, height])  # SIZE PARAMETERS:  TRANSFORM GRAPHS

	x_labels = ax_list.get_xticklabels()
	#  N.b. No data/plots for naive -- no view maintenance structures to update

	x_subname_list = ["", n_set, n_classic, n_dbt, n_tt]
	x_labels = []
	for i in range(7):
		for e in x_subname_list:
			x_labels.append(e)
		#end_for
	#end_for
	x_labels[0] = "\n\n                                                PushDownDontDelete\n                                              SingletonBtreeRight"
	x_labels[5] = "\n\n                                                PushDownDontDelete\n                                              SingeltonBtreeLeft"
	x_labels[10] = "\n\n                                                  PushDown\n                                                    SingletonRight"
	x_labels[15] = "\n\n                                                  PushDown\n                                                    SingletonLeft"
	x_labels[20] = "\n\n                                             CrackArray"
	#x_labels[25] = "\n\n                                    remove_singleton"
	#x_labels[30] = "\n\n                                    insert_singleton"
	ax_list.set_xticklabels(x_labels)

	tick_list = ax_list.get_xticklabels()
	for i in range(len(tick_list)):
		if (i % 5 != 0):
			tick_list[i].set_rotation(-15)
			tick_list[i].set_ha("left")
		#end_if
	#end_for

	if (workload == "c"):
		ax_list.annotate("N/A -- Workload C has no delete or singleton operations", xy = (7, 22500))
	#end_if

	if (workload == "d"):
		ax_list.annotate("N/A -- Workload D has no delete operations", xy = (3, 22500))
	#end_if

	# We use YCSB workloads ABCDF (no E).  Used as subgraphs abcde.
	if (workload == "f"):
		subgraph = "e"
	else:
		subgraph = workload
	#end_if

	if (datatype == 4):

		if (savepdf == True):
			fig_list.savefig("graphs/figure_10_" + subgraph + ".pdf", bbox_inches = "tight");
		else:
			fig_list.savefig("graphs/figure_10_" + subgraph + ".png");
		#endif

	#end_if

	fig2_list, ax2_list = plt.subplots()
	if (setbox == True):
		fig2_list.set_size_inches(xdim, ydim)
	#end_if

	bp_search = ax2_list.boxplot(boxplot_search_list, showmeans = False)

	height_dict = {"a":350000, "b":60000, "c":20000, "d":50000, "f":400000}
	height = height_dict[workload]

	#ax2_list.set_title("Target Node Search Latency (Workload " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	#ax2_list.set_xlabel("Target Transform Operation (Node) Type (View)", fontsize = 14, fontweight = "bold")
	ax2_list.set_ylabel("Search Latency\n(CPU ticks)", fontsize = 14, fontweight = "bold")
	ax2_list.axis([1, 31, 0, height])  # SIZE PARAMETERS:  SEARCH GRAPHS

	#x_labels = ax2_list.get_xticklabels()

	x_subname_list = ["", n_naive, n_set, n_classic, n_dbt, n_tt]
	x_labels = []
	for i in range(7):
		for e in x_subname_list:
			x_labels.append(e)
		#end_for
	#end_for
	x_labels[0] = "\n\n                                                   PushDownDontDelete\n                                                    SingletonBtreeRight"
	x_labels[6] = "\n\n                                                  PushDownDontDelete\n                                                  SingeltonBtreeLeft"
	x_labels[12] = "\n\n                                                    PushDownSingletonRight"
	x_labels[18] = "\n\n                                                    PushDownSingletonLeft"
	x_labels[24] = "\n\n                                                    CrackArray"
	#  N.b. No data/plots for insert_singleton or remove_singleton -- these are mutate only
	ax2_list.set_xticklabels(x_labels)

	tick_list = ax2_list.get_xticklabels()
	for i in range(len(tick_list)):
		if (i % 6 != 0):
			tick_list[i].set_rotation(-15)
			tick_list[i].set_ha("left")
		#end_if
	#end_for

	if (datatype == 2):

		if (savepdf == True):
			fig2_list.savefig("graphs/figure_9_" + subgraph + ".pdf", bbox_inches = "tight");
		else:
			fig2_list.savefig("graphs/figure_9_" + subgraph + ".png");
		#endif

	#end_if

	#plt.show()
	plt.close("all")

	return

#end_def


def get_uber_lists(workload):

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

		input_file_name = "tracefiles/naive_trans_performance_" + workload + "_" + str(i) + ".txt"
		#process_loglines(input_file_name, naive_results_list_list, 4)
		process_loglines(input_file_name, naive_results_list_list, 2)

		input_file_name = "tracefiles/set_trans_performance_" + workload + "_" + str(i) + ".txt"
		#process_loglines(input_file_name, set_results_list_list, 4)
		process_loglines(input_file_name, set_results_list_list, 2)

		input_file_name = "tracefiles/view_trans_performance_" + workload + "_" + str(i) + ".txt"
		#process_loglines(input_file_name, jitd_results_list_list, 4)
		process_loglines(input_file_name, jitd_results_list_list, 2)

		input_file_name = "tracefiles/toaster_trans_performance_" + workload + "_" + str(i) + ".txt"
		#process_loglines(input_file_name, toaster_results_list_list, 4)
		process_loglines(input_file_name, toaster_results_list_list, 2)

		input_file_name = "tracefiles/classic_trans_performance_" + workload + "_" + str(i) + ".txt"
		#process_loglines(input_file_name, classic_results_list_list, 4)
		process_loglines(input_file_name, classic_results_list_list, 2)

	#end_for


	naive_uber_list = []
	set_uber_list = []
	jitd_uber_list = []
	toaster_uber_list = []
	classic_uber_list = []
	#for i in [2, 4, 5, 7, 8, 9, 11, 14]:
	for i in [4, 5, 7, 8, 9, 11, 14]:

		#'''
		for e in naive_results_list_list[2][i]:
			naive_uber_list.append(e)
		#end_for
		for e in set_results_list_list[2][i]:
			set_uber_list.append(e)
		#end_for
		for e in jitd_results_list_list[2][i]:
			jitd_uber_list.append(e)
		#end_for
		for e in toaster_results_list_list[2][i]:
			toaster_uber_list.append(e)
		#end_for
		for e in classic_results_list_list[2][i]:
			classic_uber_list.append(e)
		#end_for
		#'''

		# N.b. No transform view maintenance for naive -- naive_results_list_list[0][i]
		for e in set_results_list_list[0][i]:
			set_uber_list.append(e)
		#end_for
		for e in jitd_results_list_list[0][i]:
			jitd_uber_list.append(e)
		#end_for
		for e in toaster_results_list_list[0][i]:
			toaster_uber_list.append(e)
		#end_for
		for e in classic_results_list_list[0][i]:
			classic_uber_list.append(e)
		#end_for

	#end_for

	return naive_uber_list, set_uber_list, classic_uber_list, toaster_uber_list, jitd_uber_list

#end_def


#def graph_summary_boxplots(usenaive):
def graph_summary_boxplots(workloadlen):

	# usenaive = False  # Whether to include naive search in summary results
	# workloadlen -- whether to calculate search loads for all workloads or only for workload A

	#workload_list = ["a", "b", "c", "d", "f"]
	if (workloadlen == 5):
		workload_list = ["a", "b", "c", "d", "f"]
	else:
		workload_list = ["a"]
	#end_if

	naive_uber_list = []
	set_uber_list = []
	classic_uber_list = []
	toaster_uber_list = []
	jitd_uber_list = []

	summary_list = []
	summary_list.append([])

	for workload in workload_list:
		print("Processing maintenance " + workload)
		naive_uber_list, set_uber_list, classic_uber_list, toaster_uber_list, jitd_uber_list = get_uber_lists(workload)

		'''
		if (usenaive == True):
			summary_list.append(naive_uber_list)
		#end_if
		summary_list.append(set_uber_list)
		'''
		summary_list.append(naive_uber_list)
		summary_list.append(classic_uber_list)
		summary_list.append(toaster_uber_list)
		summary_list.append(jitd_uber_list)
		summary_list.append([])

	#end_for


	#fig3_list, ax3_list = plt.subplots(2, 1)
	#fig3_list, ax3_list = plt.subplots(2, 1, gridspec_kw = {"height_ratios": [5, 3]})
	fig3_list, ax3_list = plt.subplots()


	# TOP GRAPH

	#bp_total_top = ax3_list[0].boxplot(summary_list)
	bp_total_top = ax3_list.boxplot(summary_list)

	#ax3_list[0].set_title("Average View Operation Latency By Workload", fontsize = 14, fontweight = "bold")
	#ax3_list[0].set_ylabel("Average latency\n(CPU ticks)", fontsize = 14, fontweight = "bold")
	#ax3_list[0].axis([1, len(workload_list) * 5 + 1, 0, 200000])  # SIZE PARAMETER:  SUMMARY TOTAL GRAPH
	ax3_list.axis([1, len(workload_list) * 5 + 1, 0, 200000])  # SIZE PARAMETER:  SUMMARY TOTAL GRAPH
	#ax3_list[0].set_xticks([])


	# BOTTOM GRAPH

	#bp_total_bottom = ax3_list[1].boxplot(summary_list)

	#ax3_list[1].set_xlabel("Maintenance type and workload", fontsize = 14, fontweight = "bold")
	ax3_list.set_xlabel("Maintenance type and workload", fontsize = 14, fontweight = "bold")
	#ax3_list[1].set_ylabel("Average latency\n(CPU ticks)", fontsize = 14, fontweight = "bold")
	#ax3_list[1].axis([1, len(workload_list) * 5 + 1, 0, 10000])  # SIZE PARAMETER:  SUMMARY TOTAL GRAPH

	'''
	if (usenaive == True):
		x_subname_list = [n_naive, n_set, n_classic, n_dbt, n_tt, ""]
	else:
		#x_subname_list = [n_set, n_classic, n_dbt, n_tt, ""]
	#end_if
	'''
	x_subname_list = [n_naive, n_classic, n_dbt, n_tt, ""]

	x_labels = [""]
	#for i in range(5):
	for i in range(workloadlen):
		for e in x_subname_list:
			x_labels.append(e)
		#end_for
	#end_for
	if (workloadlen == 5):
		x_labels[0] = "\n\n\n                                Workload A"
		x_labels[5] = "\n\n\n                                Workload B"
		x_labels[10] = "\n\n\n                               Workload C"
		x_labels[15] = "\n\n\n                               Workload D"
		x_labels[20] = "\n\n\n                               Workload F"
	else:
		x_labels[0] = "\n\n\n                                                                                                                  Workload A"
	#end_if
	#  N.b. No data/plots for insert_singleton or remove_singleton -- these are mutate only
	#ax3_list[1].set_xticklabels(x_labels)
	ax3_list.set_xticklabels(x_labels)

	#tick_list = ax3_list[1].get_xticklabels()
	tick_list = ax3_list.get_xticklabels()
	for i in range(len(tick_list)):
		if (i % 5 != 0):
			tick_list[i].set_rotation(-45)
			tick_list[i].set_ha("left")
		#end_if
	#end_for

	fig3_list.text(0, .2, "Average latency (CPU ticks)", fontsize = 14, fontweight = "bold", rotation = "vertical")

	if (workloadlen == 5):
		fig3_list.savefig("graphs/supplement_1_combined_search_a-f.pdf", bbox_inches = "tight");
	else:
		fig3_list.savefig("graphs/supplement_2_combined_search_a_only.pdf", bbox_inches = "tight");
	#end_if

	'''
	#fig3_list.show()

	# Do not include naive search in summary boxplot:
	if (usenaive == False):
		if (savepdf == True):
			fig3_list.savefig("graphs/figure_12.pdf", bbox_inches = "tight");
		else:
			fig3_list.savefig("graphs/figure_12.png");
		#endif
		return  # Do not save out results that do not include naive search data
	#end_if

	# Save out latency summary -- including naive search results -- for use in crossplot:

	line_list = []
	median = 0
	boxplot_output_file_obj = open("graphdata_summary.txt", "w")
	output_line = ""

	line_list = bp_total_bottom["medians"]  # boxplot return value is a dictionary -- get medians

	for line in line_list:
		# line is a pyplot line2d object
		# get_ydata() returns a 2-tuple of redundant values
		# so, get_ydata()[0] returns a float (or a "nan")
		median = line.get_ydata()[0]
		if (math.isnan(median) == True):
			output_line = "0\n"
		else:
			output_line = str(median) + "\n"
		#end_if
		boxplot_output_file_obj.write(output_line)
	#end_for

	boxplot_output_file_obj.close()
	'''

	plt.close("all")

	return

#end_def


def main():

	# Sanity check versions (backcompatibility and formtting):
	if (sys.version_info[0] < 3):
		print("Please run with python 3")
		sys.exit(1)
	#end_if
	if (mpl.__version__[0] != "3"):
		print("Please install Matplotlib 3")
		sys.exit(1)
	#end_if

	workload_list = ["a", "b", "c", "d", "f"]

	print("Generating supplementary #1")
	graph_summary_boxplots(5)
	print("Generating supplementary #2")
	graph_summary_boxplots(1)
	print("Done")
	sys.exit(0)

	for workload in workload_list:
		print("Processing boxplot graphs (Figures 9-10) for workload " + workload)
		#graph_node_boxplots(workload)
		graph_transform_boxplots(workload, 2)
		graph_transform_boxplots(workload, 4)
	#end_for

	print("Processing summary boxplot graph (Figure 12)")
	graph_summary_boxplots(True)  # Saveout summary data for crossplot (including naive search data)
	print("Creating latency data for scatter crossplot (Figure 11)")
	graph_summary_boxplots(False)  # Create stacked summary graph (without naive search data)
	print("Success.  Graphs in ../graph directory")

#end_def


main()


