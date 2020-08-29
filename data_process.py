
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


def process_loglines(input_file_name, results_list_list):

	# input_file_name = ""
	# results_list_list = []
	# type_dict = {}
	input_file_obj = "" # file obj
	iteration = -1
	logline = ""
	logline_list = []
	latency = 0
	latency_total = 0

	id_list = []
	latency_list = []

	input_file_obj = open(input_file_name, "r")
	#input_file_obj = open(input_file_name, "r")

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

		id_list.append(iteration)
		latency_list.append(latency)

	#end_while

	results_list_list.append(id_list)
	results_list_list.append(latency_list)
	results_list_list.append(latency_total)

	return

#end_def


def graph_boxplot(workload):

	# workload = ""
	input_file_prefix = ""
	input_file_name = ""
	results_list_list = []

	fig_list, ax_list = plt.subplots(1, 2, sharex = True)
	ax2_list = [ax_list[0].twinx(), ax_list[1].twinx()]

	fig_list.set_size_inches(22, 12)

	index_list = []
	jitd_latency_list = []
	jitd_total_list = []
	dbt_latency_list = []
	dbt_total_list = []

	for i in range(10):

		print(i)
		index_list.append(i + 1)
	
		input_file_name = "view_results/jitd_data_performance_" + workload + "_" + str(i) + ".txt"
		results_list_list = []
		process_loglines(input_file_name, results_list_list)
		jitd_latency_list.append(results_list_list[1])
		jitd_total_list.append(results_list_list[2])

		input_file_name = "view_results/dbt_data_performance_" + workload + "_" + str(i) + ".txt"
		results_list_list = []
		process_loglines(input_file_name, results_list_list)
		dbt_latency_list.append(results_list_list[1])
		dbt_total_list.append(results_list_list[2])

	#end_for

	bp = ax_list[0].boxplot(jitd_latency_list)

	for flier in bp['fliers']:
		flier.set(marker='.', color='#e7298a', alpha=0.5)
	#end_for

	ax_list[0].set_title("Database Operation Latency (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax_list[0].set_xlabel("JITD Run #", fontsize = 14, fontweight = "bold")
	ax_list[0].set_ylabel("Database Operation Latency ($ms$)", fontsize = 14, fontweight = "bold")
	ax_list[0].axis([0, 11, 0, 30])

	ax2_list[0].plot(index_list, jitd_total_list, marker = "o", color = "blue", label = "JITD Total time (right axis)")
	ax2_list[0].axis([0, 11, 0, 3000])
	ax2_list[0].legend(loc = "upper right")

	#'''
	# Remove RH Y tick labels on LH subplot:
	y_labels = ax2_list[0].get_yticklabels()
	y_labels = [ "" for e in y_labels]
	ax2_list[0].set_yticklabels(y_labels)
	#'''


	bp = ax_list[1].boxplot(dbt_latency_list)

	for flier in bp['fliers']:
		flier.set(marker='.', color='#e7298a', alpha=0.5)
	#end_for

	ax_list[1].set_title("Database Operation Latency (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax_list[1].set_xlabel("DBT Run #", fontsize = 14, fontweight = "bold")
	ax_list[1].axis([0, 11, 0, 30])

	#'''
	# Remove LH Y tick labels on RH subplot:
	y_labels = ax_list[1].get_yticklabels()
	y_labels = [ "" for e in y_labels]
	ax_list[1].set_yticklabels(y_labels)
	#'''

	ax2_list[1].plot(index_list, dbt_total_list, marker = "o", color = "red", label = "DBT Total time (right axis)")
	ax2_list[1].set_ylabel("Total Database Operation Latency ($ms$)", fontsize = 14, fontweight = "bold")
	ax2_list[1].axis([0, 11, 0, 3000])
	ax2_list[1].legend(loc = "upper right")


	fig_list.savefig("view_graphs/data_boxplot_" + workload + ".png");


	#plt.show()

#end_def


def main():

	#workload_list = ["a", "b", "c", "d", "e", "f"]
	workload_list = ["a", "b", "c", "d", "f"]
	#workload_list = ["f"]

	for workload in workload_list:
		print("Processing workload " + workload)
		#graph_latency_timeline_pair(workload)
		graph_boxplot(workload)
	#end_for

#end_def


main()


