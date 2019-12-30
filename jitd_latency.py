
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
	latency = 0.0
	latency_list = []
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

		latency = float(logline_list[1]) * 1000.0
		latency_list.append(latency)

		rowcount = int(logline_list[4])
		rowcount_list.append(rowcount)

		key = int(logline_list[3])
		key_list.append(key)

	#end_while

	input_file.close()

	#print(latency_list)

	return time_start_list, latency_list, rowcount_list, key_list

#end_def


def main():

	filename = ""
	interactive = True
	minlatency = 999999.0
	maxlatency = 0.0
	time_start_list = []
	latency_list = []
	latency_null_list = []
	latency_bucket_list = []
	latency_cdf_list = []
	cumsum = 0
	bucket = 0
	maxbucket = 0
	rowcount_list = []
	latency_row_list = []
	row_dict = {}
	rowcount_frequency_list = []
	maxrows = 0
	key_list = []
	minkey = 999999
	maxkey = 0
	filetype = ".pdf"

	filename = sys.argv[1]
	if (len(sys.argv) > 2):
		if (sys.argv[2] == "script"):
			interactive = False
		#end_if
	#end_if
	if (len(sys.argv) > 3):
		if (sys.argv[3] == "png"):
			filetype = ".png"
		#end_if
	#end_if

	time_start_list, latency_list, rowcount_list, key_list = process_loglines(filename)

	for e in latency_list:
		if (e < minlatency):
			minlatency = e
		#end_if
		if (e > maxlatency):
			maxlatency = e
		#end_if
	#end_for

	print(minlatency, maxlatency)

	for i in range(int(maxlatency) * 10 + 10):
		latency_null_list.append(float(i / 10.0))
		latency_bucket_list.append(0)
		latency_cdf_list.append(0)
		latency_row_list.append({})
	#end_for

	for e, f in zip(latency_list, rowcount_list):
		bucket = int(e * 10.0)
		latency_bucket_list[bucket] += 1

		row_dict = latency_row_list[bucket]
		if (f in row_dict):
			row_dict[f] += 1
		else:
			row_dict[f] = 1
		#end_if

		if (f > maxrows):
			maxrows = f
		#end_if

		if (latency_bucket_list[bucket] > maxbucket):
			maxbucket = latency_bucket_list[bucket]
		#end_if

	#end_for

	for i in range(len(latency_bucket_list)):
		cumsum += latency_bucket_list[i]
		latency_cdf_list[i] = cumsum
	#end_for

	fig0, ax0 = plt.subplots()

	ax0.plot(latency_null_list, latency_bucket_list)

	ax0.set_xlabel("Operation latency (ms) (.1ms buckets)", fontsize = 10, fontweight = "bold")
	ax0.set_ylabel("Number of operations taking this long", fontsize = 10, fontweight = "bold")
	ax0.axis([0, maxlatency, 0, maxbucket])
	print(maxlatency, maxbucket)

	fig0.tight_layout()
	fig0.savefig("latency_frequency" + filetype)

	fig1, ax1 = plt.subplots()

	ax1.plot(latency_null_list, latency_cdf_list)

	ax1.set_xlabel("Operation latency (ms) (.1ms buckets)", fontsize = 10, fontweight = "bold")
	ax1.set_ylabel("Number of operations taking this long", fontsize = 10, fontweight = "bold")
	ax1.axis([0, maxlatency, 0, cumsum])
	print(maxlatency, cumsum)

	fig1.tight_layout()
	fig1.savefig("latency_cdf" + filetype)

	fig2, ax2 = plt.subplots()

	time_start_list = [ e - time_start_list[0] for e in time_start_list ]

	ax2.scatter(time_start_list, latency_list, s = 1)

	ax2.set_xlabel("Operation start time (ms)", fontsize = 10, fontweight = "bold")
	ax2.set_ylabel("Operation latency (ms)", fontsize = 10, fontweight = "bold")
	ax2.axis([0, time_start_list[-1], 0, maxlatency])
	print(time_start_list[-1], maxlatency)

	fig2.tight_layout()
	fig2.savefig("latency_walltime" + filetype)

	fig3, ax3 = plt.subplots()

	for e, f_dict in zip(latency_null_list, latency_row_list):
		for g in f_dict:
			ax3.scatter(e, g, s = f_dict[g] ) #int(math.log(float(f[g]))))
		#end_for
	#end_for

	ax3.set_xlabel("Operation latency (ms) (.1ms buckets)", fontsize = 10, fontweight = "bold")
	ax3.set_ylabel("Number of rows returned", fontsize = 10, fontweight = "bold")
	ax3.axis([0, maxlatency, 0, maxrows + 1])

	fig3.tight_layout()
	fig3.savefig("latency_rowcount" + filetype)

	fig4, ax4 = plt.subplots()

	# For pyplot optimization, generate vector parameters for scatter():
	blue_x_list = []
	blue_y_list = []
	red_x_list = []
	red_y_list = []
	for e, f, g in zip(key_list, latency_list, rowcount_list):
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
	print(minkey, maxkey)

	red_patch = mpatches.Patch(color = "blue", label = "miss (rows returned = 0)")
	blue_patch = mpatches.Patch(color = "red", label = "hit (rows returned > 0")
	ax4.legend(handles = [blue_patch, red_patch])

	fig4.tight_layout()
	fig4.savefig("latency_key" + filetype)

	fig5, ax5 = plt.subplots()

	ax5.scatter(time_start_list, key_list, s = 1)

	ax5.set_xlabel("Operation start time (ms)", fontsize = 10, fontweight = "bold")
	ax5.set_ylabel("Key", fontsize = 10, fontweight = "bold")
	ax5.axis([0, maxlatency, minkey, maxkey])

	fig5.tight_layout()
	fig5.savefig("walltime_key" + filetype)


	if (interactive == True):
		plt.show()
	#end_if

#end_def



main()




