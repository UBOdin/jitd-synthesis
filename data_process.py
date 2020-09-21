
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


runcount = 10

#xdim = 22
#ydim = 12

#xdim = 10
#ydim = 6

savepdf = True
setbox = False

n_naive = "Naive"
n_set = "Set"
n_classic = "Clas"
n_dbt = "DBT"
n_tt = "TT"


def process_loglines(input_file_name, results_list_list_list):

	# input_file_name = ""
	# results_list_list_list = []
	# type_dict = {}
	input_file_obj = "" # file obj
	iteration = -1
	logline = ""
	logline_list = []
	latency = 0
	latency_total = 0
	optype = 0
	vmsize = 0

	latency_list = results_list_list_list[0]
	operation_list_list = results_list_list_list[1]
	vmsize_list = results_list_list_list[2]

	input_file_obj = open(input_file_name, "r")

	# Skip first line (schema info):
	logline = input_file_obj.readline() #.decode("ascii")
	
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
		if (len(logline_list) != 29):
			print("Unexpected length")
			sys.exit(1)
		#end_if

		latency = int(logline_list[1])
		latency_total += latency

		#id_list.append(iteration)
		#latency_list.append(latency)

		optype = int(logline_list[2])
		vmsize = int(logline_list[6])  # repurposed jitd depth field (kludge)

		latency_list.append(latency)
		operation_list_list[optype].append(latency)  # per-operation type
		vmsize_list.append(vmsize)

	#end_while

	return

#end_def


def graph_boxplot(workload):

	# workload = ""
	input_file_prefix = ""
	input_file_name = ""

	naive_results_list_list_list = [[], [], []]
	set_results_list_list_list = [[], [], []]
	jitd_results_list_list_list = [[], [], []]
	toaster_results_list_list_list = [[], [], []]
	classic_results_list_list_list = [[], [], []]

	for i in range(5):  # 5 DB operations
		naive_results_list_list_list[1].append([])
		set_results_list_list_list[1].append([])
		jitd_results_list_list_list[1].append([])
		toaster_results_list_list_list[1].append([])
		classic_results_list_list_list[1].append([])
	#end_if


	fig1, ax1 = plt.subplots()
	if (setbox == True):
		fig1.set_size_inches(xdim, ydim)
	#end_if

	for i in range(runcount):

		print(i)
		#index_list.append(i + 1)

		input_file_name = "view_results/naive_data_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, naive_results_list_list_list)

		input_file_name = "view_results/set_data_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, set_results_list_list_list)

		input_file_name = "view_results/view_data_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, jitd_results_list_list_list)

		input_file_name = "view_results/toaster_data_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, toaster_results_list_list_list)

		input_file_name = "view_results/classic_data_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, classic_results_list_list_list)

	#end_for


	boxplot_dbop_list = []
	#for i in range(5):
	for i in [0, 1, 3]:  # Delete (2) and Upsert (4) never used in YCSB
		boxplot_dbop_list.append([])
		boxplot_dbop_list.append(naive_results_list_list_list[1][i])
		boxplot_dbop_list.append(set_results_list_list_list[1][i])
		boxplot_dbop_list.append(classic_results_list_list_list[1][i])
		boxplot_dbop_list.append(toaster_results_list_list_list[1][i])
		boxplot_dbop_list.append(jitd_results_list_list_list[1][i])
	#end_for

	bp_operations = ax1.boxplot(boxplot_dbop_list)

	ax1.set_title("Database Per-Operation Latency (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax1.set_xlabel("Transform Selection and Database Operation Type", fontsize = 14, fontweight = "bold")
	ax1.set_ylabel("Database Operation Latency", fontsize = 14, fontweight = "bold")
	ax1.axis([1, 19, 0, 300])

	x_labels = ax1.get_xticklabels()
	x_labels = ["", n_naive, n_set, n_classic, n_dbt, n_tt, "", n_naive, n_set, n_classic, n_dbt, n_tt, "", n_naive, n_set, n_classic, n_dbt, n_tt, ""]
	x_labels[0] = "\n                                                                                                                           Insert"
	x_labels[6] = "\n                                                                                                                           Select"
	#x_labels[12] = "\n                                                                                                                         Delete"
	x_labels[12] = "\n                                                                                                                          Update"
	#x_labels[20] = "\n                                                                                                                         Upsert"
	ax1.set_xticklabels(x_labels)

	if (savepdf == True):
		fig1.savefig("view_graphs/data_dbop_boxplot_" + workload + ".pdf");
	else:
		fig1.savefig("view_graphs/data_dbop_boxplot_" + workload + ".png");
	#endif


	fig2_list, ax2_list = plt.subplots(1, 2)
	if (setbox == True):
		fig2_list.set_size_inches(xdim, ydim)
	#end_if

	bp_latency = ax2_list[0].boxplot([naive_results_list_list_list[0], set_results_list_list_list[0], classic_results_list_list_list[0], toaster_results_list_list_list[0], jitd_results_list_list_list[0]])

	ax2_list[0].set_title("Database Operation Latency (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax2_list[0].set_xlabel("Transform Selection Type", fontsize = 14, fontweight = "bold")
	ax2_list[0].set_ylabel("Database Operation Latency", fontsize = 14, fontweight = "bold")
	ax2_list[0].axis([0, 6, 0, 300])

	x_labels = ax2_list[0].get_xticklabels()
	x_labels = ["Naive", "Set", "Classic", "DBT", "TT"]
	ax2_list[0].set_xticklabels(x_labels)

	#fig2_list[0].savefig("view_graphs/data_latency_boxplot_" + workload + ".png");


	bp_latency = ax2_list[1].boxplot([naive_results_list_list_list[2], set_results_list_list_list[2], classic_results_list_list_list[2], toaster_results_list_list_list[2], jitd_results_list_list_list[2]])

	ax2_list[1].set_title("Per-Operation Process Memory Usage (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax2_list[1].set_xlabel("Transform Selection Type", fontsize = 14, fontweight = "bold")
	ax2_list[1].set_ylabel("Virtual Memory Pages Allocated", fontsize = 14, fontweight = "bold")
	ax2_list[1].axis([0, 6, 0, 100000])

	x_labels = ax2_list[1].get_xticklabels()
	x_labels = ["Naive", "Set", "Classic", "DBT", "TT"]
	ax2_list[1].set_xticklabels(x_labels)

	if (savepdf == True):
		fig2_list.savefig("view_graphs/data_memory_boxplot_" + workload + ".pdf");
	else:
		fig2_list.savefig("view_graphs/data_memory_boxplot_" + workload + ".png");
	#endif


	#plt.show()

#end_def


def main():

	#workload_list = ["a", "b", "c", "d", "e", "f"]
	#workload_list = ["a", "b", "c", "d", "f"]
	workload_list = ["a", "f"]

	for workload in workload_list:
		print("Processing workload " + workload)
		#graph_latency_timeline_pair(workload)
		graph_boxplot(workload)
	#end_for

#end_def


main()


