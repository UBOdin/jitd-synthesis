
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

	fig_list, ax_list = plt.subplots(1, 3, sharex = True)
	ax2_list = [ax_list[0].twinx(), ax_list[1].twinx(), ax_list[2].twinx()]

	fig_list.set_size_inches(22, 12)

	index_list = []
	set_latency_list = []
	set_total_list = []
	jitd_latency_list = []
	jitd_total_list = []
	dbt_latency_list = []
	dbt_total_list = []

	for i in range(10):

		print(i)
		index_list.append(i + 1)

		input_file_name = "view_results/set_data_performance_" + workload + "_" + str(i) + ".txt"
		results_list_list = []
		process_loglines(input_file_name, results_list_list)
		set_latency_list.append(results_list_list[1])
		set_total_list.append(results_list_list[2])

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


	bp = ax_list[0].boxplot(set_latency_list)

	for flier in bp['fliers']:
		flier.set(marker='.', color='#e7298a', alpha=0.5)
	#end_for

	ax_list[0].set_title("Database Operation Latency (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax_list[0].set_xlabel("JITD Set Run #", fontsize = 14, fontweight = "bold")
	ax_list[0].set_ylabel("Database Operation Latency ($ms$)", fontsize = 14, fontweight = "bold")
	ax_list[0].axis([0, 11, 0, 30])

	ax2_list[0].plot(index_list, set_total_list, marker = "o", color = "blue", label = "Set Total time (right axis)")
	ax2_list[0].axis([0, 11, 0, 3000])
	ax2_list[0].legend(loc = "upper right")

	# Remove RH Y tick labels on LH subplot:
	y_labels = ax2_list[0].get_yticklabels()
	y_labels = [ "" for e in y_labels]
	ax2_list[0].set_yticklabels(y_labels)


	bp = ax_list[1].boxplot(jitd_latency_list)

	for flier in bp['fliers']:
		flier.set(marker='.', color='#e7298a', alpha=0.5)
	#end_for

	ax_list[1].set_title("Database Operation Latency (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax_list[1].set_xlabel("JITD View Run #", fontsize = 14, fontweight = "bold")
	ax_list[1].axis([0, 11, 0, 30])

	ax2_list[1].plot(index_list, jitd_total_list, marker = "o", color = "red", label = "JITD View Total time (right axis)")
	ax2_list[1].axis([0, 11, 0, 3000])
	ax2_list[1].legend(loc = "upper right")

	# Remove both LH and RH labels from middle subplot:
	y_labels = ax_list[1].get_yticklabels()
	y_labels = [ "" for e in y_labels]
	ax_list[1].set_yticklabels(y_labels)
	y_labels = ax2_list[1].get_yticklabels()
	y_labels = [ "" for e in y_labels]
	ax2_list[1].set_yticklabels(y_labels)


	bp = ax_list[2].boxplot(dbt_latency_list)

	ax2_list[2].plot(index_list, dbt_total_list, marker = "o", color = "green", label = "DBT View Total time (right axis)")
	ax2_list[2].set_ylabel("Total View Operation Latency", fontsize = 14, fontweight = "bold")
	ax2_list[2].axis([0, 11, 0, 30])
	ax2_list[2].legend(loc = "upper right")

	ax_list[2].set_title("Database Operation Latency (YCSB " + workload.upper() + ")", fontsize = 14, fontweight = "bold")
	ax_list[2].set_xlabel("DBT View Run #", fontsize = 14, fontweight = "bold")
	ax_list[2].axis([0, 11, 0, 3000])

	# Remove LH Y tick labels on RH subplot:
	y_labels = ax_list[2].get_yticklabels()
	y_labels = [ "" for e in y_labels]
	ax_list[2].set_yticklabels(y_labels)



	fig_list.savefig("view_graphs/data_boxplot_" + workload + ".png");


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


