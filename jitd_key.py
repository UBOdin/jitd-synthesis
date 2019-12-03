
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
	key = 0
	key_list = []

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

		key = int(logline_list[3])
		key_list.append(key)

	#end_while

	input_file.close()

	#print(optime_list)

	return time_start_list, optime_list, rowcount_list, key_list

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
	key_list = []
	minkey = 999999
	maxkey = 0

	filename = sys.argv[1]
	if (len(sys.argv) > 2):
		if (sys.argv[2] == "script"):
			interactive = False
		#end_if
	#end_if

	time_start_list, optime_list, rowcount_list, key_list = process_loglines(filename)

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

	fig4, ax4 = plt.subplots()

	# For pyplot optimization, generate vector parameters for scatter():
	blue_x_list = []
	blue_y_list = []
	red_x_list = []
	red_y_list = []
	for e, f, g in zip(key_list, optime_list, rowcount_list):
		if (e < minkey):
			minkey = e
		#end_if
		if (e > maxkey):
			maxkey = e
		#end_if
		if (g == 0):
			blue_x_list.append(e)
			blue_y_list.append(f)
		else:
			red_x_list.append(e)
			red_y_list.append(f)
		#end_if
	#end_for
	ax4.scatter(blue_x_list, blue_y_list, s = 10, c = "blue")
	ax4.scatter(red_x_list, red_y_list, s = 10, c = "red")

	ax4.set_xlabel("Key", fontsize = 10, fontweight = "bold")
	ax4.set_ylabel("Operation latency (ms)", fontsize = 10, fontweight = "bold")
	ax4.axis([minkey, maxkey, 0, maxlatency])

	red_patch = mpatches.Patch(color = "blue", label = "miss (rows returned = 0)")
	blue_patch = mpatches.Patch(color = "red", label = "hit (rows returned > 0")

	ax4.legend(handles = [blue_patch, red_patch])

	print(minlatency)
	print(maxlatency)
	print(minkey)
	print(maxkey)

	fig4.tight_layout()
	fig4.savefig("latency_key.pdf")



	if (interactive == True):
		plt.show()
	#end_if

#end_def



main()




