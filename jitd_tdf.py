
import json
import sys
import gzip
import json

import os
import datetime

import matplotlib as mpl
import matplotlib.pyplot as plt
import numpy as np
import matplotlib.patches as mpatches

import math

def sort_key(input_list):

	return input_list[0]

#end_def

def process_loglines(file_name):

	#print("Hello world %s, %d" % ("bye", 20))

	logline = ""
	logline_list = []
	iteration = 0
	time_start = 0.0
	time_start_list = []
	optime = 0.0
	optime_list = []
	rowcount = 0
	rowcount_list = []

	input_file = open(file_name, "r")

	while (True):

		# Keep reading until finished:
		logline = input_file.readline().decode("ascii")

		if (logline == ""):
			break
		#end_if

		iteration += 1
		if (iteration % 1000 == 0):
			#break
			#print("Iteration:  ", iteration)
			pass
		#end_if

		logline_list = logline.split("\t")

		time_start = float(logline_list[0])
		time_start_list.append(time_start)

		optime = float(logline_list[1]) * 1000.0
		optime_list.append(optime)

		rowcount = int(logline_list[4])
		rowcount_list.append(rowcount)

	#end_while

	input_file.close()

	#print(optime_list)

	return time_start_list, optime_list, rowcount_list

#end_def


def main():

	filename = ""
	interactive = True
	minlatency = 999999.0
	maxlatency = 0.0
	time_start_list = []
	optime_list = []
	optime_null_list = []
	optime_bucket_list = []
	optime_cdf_list = []
	cumsum = 0
	bucket = 0
	maxbucket = 0
	rowcount_list = []
	optime_row_list = []
	row_dict = {}
	rowcount_frequency_list = []
	maxrows = 0

	filename = sys.argv[1]
	if (len(sys.argv) > 2):
		if (sys.argv[2] == "script"):
			interactive = False
		#end_if
	#end_if

	time_start_list, optime_list, rowcount_list = process_loglines(filename)

	for e in optime_list:
		if (e < minlatency):
			minlatency = e
		#end_if
		if (e > maxlatency):
			maxlatency = e
		#end_if
	#end_for

	print(minlatency, maxlatency)

	for i in range(int(maxlatency) * 10 + 10):
		optime_null_list.append(float(i / 10.0))
		optime_bucket_list.append(0)
		optime_cdf_list.append(0)
		optime_row_list.append({})
	#end_for

	for e, f in zip(optime_list, rowcount_list):
		bucket = int(e * 10.0)
		optime_bucket_list[bucket] += 1

		row_dict = optime_row_list[bucket]
		if (f in row_dict):
			row_dict[f] += 1
		else:
			row_dict[f] = 1
		#end_if

		if (f > maxrows):
			maxrows = f
		#end_if

		if (optime_bucket_list[bucket] > maxbucket):
			maxbucket = optime_bucket_list[bucket]
		#end_if

	#end_for

	for i in range(len(optime_bucket_list)):
		cumsum += optime_bucket_list[i]
		optime_cdf_list[i] = cumsum
	#end_for

	fig0, ax0 = plt.subplots()

	ax0.plot(optime_null_list, optime_bucket_list)

	ax0.set_xlabel("Operation latency (ms) (.1ms buckets)", fontsize = 10, fontweight = "bold")
	ax0.set_ylabel("Number of operations taking this long", fontsize = 10, fontweight = "bold")
	ax0.axis([0, maxlatency, 0, maxbucket])
	print(maxlatency, maxbucket)

	fig0.tight_layout()
	fig0.savefig("latency_frequency.pdf")

	fig1, ax1 = plt.subplots()

	ax1.plot(optime_null_list, optime_cdf_list)

	ax1.set_xlabel("Operation latency (ms) (.1ms buckets)", fontsize = 10, fontweight = "bold")
	ax1.set_ylabel("Number of operations taking this long", fontsize = 10, fontweight = "bold")
	ax1.axis([0, maxlatency, 0, cumsum])
	print(maxlatency, cumsum)

	fig1.tight_layout()
	fig1.savefig("latency_cdf.pdf")

	fig2, ax2 = plt.subplots()

	time_start_list = [ e - time_start_list[0] for e in time_start_list ]

	ax2.scatter(time_start_list, optime_list, s = 1)

	ax2.set_xlabel("Operation start time (ms)", fontsize = 10, fontweight = "bold")
	ax2.set_ylabel("Operation latency (ms)", fontsize = 10, fontweight = "bold")
	ax2.axis([0, time_start_list[-1], 0, maxlatency])
	print(time_start_list[-1], maxlatency)

	fig2.tight_layout()
	fig2.savefig("latency_walltime.pdf")

	fig3, ax3 = plt.subplots()

	for e, f_dict in zip(optime_null_list, optime_row_list):
		for g in f_dict:
			ax3.scatter(e, g, s = f_dict[g] ) #int(math.log(float(f[g]))))
		#end_for
	#end_for

	ax3.set_xlabel("Operation latency (ms) (.1ms buckets)", fontsize = 10, fontweight = "bold")
	ax3.set_ylabel("Number of rows returned", fontsize = 10, fontweight = "bold")
	ax3.axis([0, maxlatency, 0, maxrows + 1])

	fig3.tight_layout()
	fig3.savefig("latency_rowcount.pdf")

	if (interactive == True):
		plt.show()
	#end_if

#end_def



main()




