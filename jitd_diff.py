
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




def process_loglines(file_name):

	#print("Hello world %s, %d" % ("bye", 20))

	logline = ""
	logline_list = []
	iteration = 0
	time_start = 0.0
	time_start_list = []
	optime = 0.0
	optime_list = []

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

	#end_while

	input_file.close()

	#print(optime_list)

	return time_start_list, optime_list

#end_def


def main():

	filename_1 = ""
	filename_2 = ""
	interactive = True
	starttime_list_1 = []
	starttime_list_2 = []
	optime_list_1 = []
	optime_list_2 = []
	null_list = []
	difftime_list = []
	filetype = ".pdf"

	filename_1 = sys.argv[1]
	filename_2 = sys.argv[2]
	if (len(sys.argv) > 3):
		if (sys.argv[3] == "script"):
			interactive = False
		#end_if
	#end_if
	if (len(sys.argv) > 4):
		if (sys.argv[4] == "png"):
			filetype = ".png"
		#end_if
	#end_if

	starttime_list_1, optime_list_1 = process_loglines(filename_1)
	starttime_list_2, optime_list_2 = process_loglines(filename_2)

	for i in range(len(starttime_list_1)):
		null_list.append(i)
	#end_for

	difftime_list = [ (e - f) for e, f in zip(optime_list_1, optime_list_2) ]

	fig0, ax0 = plt.subplots()

	#ax0.plot(optime_null_list, difftime_list)
	ax0.scatter(null_list, difftime_list, s = 1)

	ax0.set_xlabel("Operation number", fontsize = 10, fontweight = "bold")
	ax0.set_ylabel("Operation time difference (JITD - SQLite) (ms)", fontsize = 10, fontweight = "bold")

	fig0.tight_layout()
	fig0.savefig("latency_difference" + filetype)


	if (interactive == True):
		plt.show()
	#end_if

#end_def


main()


