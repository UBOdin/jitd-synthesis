
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

from matplotlib.patches import Patch
from matplotlib.lines import Line2D

runcount = 10

#xdim = 22
#ydim = 12

#xdim = 10
#ydim = 6

savepdf = True
setbox = True

n_naive = "Naive"
n_set = "Index"
n_classic = "Classic"
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


def get_memory_lists(workload):

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

	for i in range(runcount):

		#index_list.append(i + 1)

		input_file_name = "tracefiles/naive_data_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, naive_results_list_list_list)

		input_file_name = "tracefiles/set_data_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, set_results_list_list_list)

		input_file_name = "tracefiles/view_data_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, jitd_results_list_list_list)

		input_file_name = "tracefiles/toaster_data_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, toaster_results_list_list_list)

		input_file_name = "tracefiles/classic_data_performance_" + workload + "_" + str(i) + ".txt"
		process_loglines(input_file_name, classic_results_list_list_list)

	#end_for

	return naive_results_list_list_list, set_results_list_list_list, classic_results_list_list_list, toaster_results_list_list_list, jitd_results_list_list_list

#end_def


def graph_boxplot(usenaive):

	# usenaive = False  # Whether to use naive search data in processing graphs

	workload_list = ["a", "b", "c", "d", "f"]

	naive_uber_list = []
	set_uber_list = []
	classic_uber_list = []
	toaster_uber_list = []
	jitd_uber_list = []

	summary_list = []
	summary_list.append([])

	for workload in workload_list:
		print("Processing maintenance " + workload)
		naive_uber_list, set_uber_list, classic_uber_list, toaster_uber_list, jitd_uber_list = get_memory_lists(workload)

		if (usenaive == True):
			summary_list.append(naive_uber_list[2])
		#end_if
		summary_list.append(set_uber_list[2])
		summary_list.append(classic_uber_list[2])
		summary_list.append(toaster_uber_list[2])
		summary_list.append(jitd_uber_list[2])
		summary_list.append([])

	#end_for


	fig2_list, ax2_list = plt.subplots()

	bp_latency = ax2_list.boxplot(summary_list)

	#ax2_list.set_title("Average Process Memory Usage By Workload", fontsize = 14, fontweight = "bold")
	ax2_list.set_xlabel("Maintenance type and workload", fontsize = 14, fontweight = "bold")
	ax2_list.set_ylabel("Average memory\npages allocated", fontsize = 14, fontweight = "bold")
	ax2_list.axis([1, len(workload_list) * 5 + 1, 0, 100000])
	x_labels = ax2_list.get_xticklabels()
	x_labels = ["", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, "", n_set, n_classic, n_dbt, n_tt, ""]
	x_labels[0] = "\n\n\n                            Workload A"
	x_labels[5] = "\n\n\n                            Workload B"
	x_labels[10] = "\n\n\n                           Workload C"
	x_labels[15] = "\n\n\n                           Workload D"
	x_labels[20] = "\n\n\n                           Workload F"
	#  N.b. No data/plots for insert_singleton or remove_singleton -- these are mutate only
	ax2_list.set_xticklabels(x_labels)

	tick_list = ax2_list.get_xticklabels()
	for i in range(len(tick_list)):
		if (i % 5 != 0):
			tick_list[i].set_rotation(-45)
			tick_list[i].set_ha("left")
		#end_if
	#end_for

	# Do not include naive search in memory usage boxplot:
	if (usenaive == False):
		if (savepdf == True):
			fig2_list.savefig("graphs/figure_13.pdf", bbox_inches = "tight");
		else:
			fig2_list.savefig("graphs/figure_13.png");
		#endif
		return  # Done; do not process scatter crossplot with naive search data
	#end_if


	line_list = []
	median = 0
	memory_list = []
	view_cost_list = []
	try:
		boxplot_input_file_obj = open("graphdata_summary.txt")
	except:
		print("ERROR:  Missing data file.  Please run script to create graphs 9-10-12 first.")
		sys.exit(1)
	#end_try
	input_line = ""

	while (True):
		input_line =  boxplot_input_file_obj.readline()
		if (input_line == ""):
			break
		#end_if
		view_cost_list.append(float(input_line))
	#end_while

	line_list = bp_latency["medians"]  # boxplot return value is a dictionary -- get medians

	for line in line_list:
		# line is a pyplot line2d object
		# get_ydata() returns a 2-tuple of redundant values
		# so, get_ydata()[0] returns a float (or a "nan")
		median = line.get_ydata()[0]
		if (math.isnan(median) == True):
			memory_list.append(0.0)
		else:
			memory_list.append(float(median))
		#end_if
	#end_for

	'''
	print(view_cost_list)
	print("")
	print(memory_list)
	'''


	fig3, ax3 = plt.subplots()

	hadj = .07
	vadj = 0.1
	fig3.subplots_adjust(left = 0.125 + hadj, right = 0.90 + hadj, top = 0.88 + vadj, bottom = 0.115 + vadj)

	color_list = ["brown", "orange", "black", "blue", "red", "green"]
	#color_list = ["brown", "black", "blue", "red", "green"]
	color = ""
	marker_list = ["o", "s", "<", ">", "P", "*"]
	marker = ""

	if (len(view_cost_list) != len(memory_list)):
		print("Error:  Mismatched lists")
		exit(1)
	#end_if

	for e, f, g in zip(range(len(view_cost_list)), view_cost_list, memory_list):
		color = color_list[e % 6]
		marker = marker_list[int(e / 6)]
		if (f == 0):
			continue
		#end_if
		ax3.scatter(f, g, s = 40, color = color, marker = marker)
	#end_for

	#ax3.set_title("Latency / Memory Crossplot", fontsize = 14, fontweight = "bold")
	ax3.set_xlabel("Average total latency (search + maintenance)", fontsize = 14, fontweight = "bold")
	ax3.set_ylabel("Average memory\npages allocated", fontsize = 14, fontweight = "bold")
	ax3.axis([0, 15000, 0, 80000])

	handle_list = []

	handle_list.append(Patch(color = "orange", label = "Naive"))
	handle_list.append(Patch(color = "black", label = "Index"))
	handle_list.append(Patch(color = "blue", label = "Classic"))
	handle_list.append(Patch(color = "red", label = "DBT"))
	handle_list.append(Patch(color = "green", label = "TT"))

	handle_list.append(Line2D([], [], marker = "o", color = "black", label = "Workload A", linewidth = 0))
	handle_list.append(Line2D([], [], marker = "s", color = "black", label = "Workload B", linewidth = 0))
	handle_list.append(Line2D([], [], marker = "<", color = "black", label = "Workload C", linewidth = 0))
	handle_list.append(Line2D([], [], marker = ">", color = "black", label = "Workload D", linewidth = 0))
	handle_list.append(Line2D([], [], marker = "P", color = "black", label = "Workload F", linewidth = 0))

	ax3.legend(handles = handle_list, loc = "upper right", ncol = 2)

	fig3.savefig("graphs/figure_11.pdf")

	return

#end_def


def main():

	print("Processing scatter crossplot (Figure 12)")
	graph_boxplot(True)
	print("Processing memory boxplot graph (Figure 13)")
	graph_boxplot(False)
	print("Success.  Graphs in ../graph directory")

#end_def


main()


