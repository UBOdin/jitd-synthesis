
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

		rowcount = logline_list[4]
		rowcount_list.append(rowcount)

	#end_while

	input_file.close()

	#print(optime_list)

	return time_start_list, optime_list, rowcount_list

#end_def


def main():

	time_start_list = []
	optime_list = []
	optime_null_list = []
	optime_bucket_list = []
	optime_cdf_list = []
	cumsum = 0
	bucket = 0
	rowcount_list = []
	optime_row_list = []
	row_dict = {}

	#filename = "15.out.gz"
	filename = sys.argv[1]

	time_start_list, optime_list, rowcount_list = process_loglines(filename)

	minval = 999999.0
	maxval = 0.0

	for e in optime_list:
		if (e < minval):
			minval = e
		#end_if
		if (e > maxval):
			maxval = e
		#end_if
	#end_for

	print(minval, maxval)

	for i in range(int(maxval) * 10 + 10):
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

	#end_for

	for i in range(len(optime_bucket_list)):
		cumsum += optime_bucket_list[i]
		optime_cdf_list[i] = cumsum
	#end_for

	'''
	print(optime_bucket_list)
	print("\n")
	print(optime_cdf_list)
	'''

	fig0, ax0 = plt.subplots()

	ax0.plot(optime_null_list, optime_bucket_list)

	ax0.set_xlabel("Operation latency (ms)", fontsize = 10, fontweight = "bold")
	ax0.set_ylabel("Number of operations taking this long", fontsize = 10, fontweight = "bold")

	fig0.tight_layout()
	fig0.savefig("latency_frequency.pdf")

	fig1, ax1 = plt.subplots()

	ax1.plot(optime_null_list, optime_cdf_list)

	ax1.set_xlabel("Operation latency (ms)", fontsize = 10, fontweight = "bold")
	ax1.set_ylabel("Number of operations taking this long", fontsize = 10, fontweight = "bold")

	fig1.tight_layout()
	fig1.savefig("latency_cdf.pdf")

	fig2, ax2 = plt.subplots()

	time_start_list = [ e - time_start_list[0] for e in time_start_list ]

	ax2.scatter(time_start_list, optime_list, s = 1)

	ax2.set_xlabel("Operation start time (ms)", fontsize = 10, fontweight = "bold")
	ax2.set_ylabel("Operation latency (ms)", fontsize = 10, fontweight = "bold")

	fig2.tight_layout()
	fig2.savefig("latency_walltime.pdf")

	fig3, ax3 = plt.subplots()

	#ax3.scatter(optime_null_list, , optime_list, s = 1)
	for e, f in zip(optime_null_list, optime_row_list):
		#row_dict = optime_row_list[f]
		for g in f: #row_dict:
			ax3.scatter(optime_null_list[int(e)], g, s = f[g] ) #int(math.log(float(f[g]))))
		#end_for

	#end_for

	ax3.set_xlabel("Operation latency (ms)", fontsize = 10, fontweight = "bold")
	ax3.set_ylabel("Number of rows returned", fontsize = 10, fontweight = "bold")

	fig3.tight_layout()
	fig3.savefig("latency_rowcount.pdf")

	#plt.show()
	

#end_def



main()




