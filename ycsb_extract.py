
import sys
import os
import json


def get_data(file_name):

	input_file = "" # file obj
	iteration = -1
	header_flag = True
	logline_list = []
	subline_list = []
	operation = ""
	operation_list = []
	key = ""
	key_list = []


	input_file = open(file_name, "r")

	while (True):

		iteration += 1

		# Keep reading until finished:
		logline = input_file.readline().decode("ascii")
		if (logline == ""):
			print("No data")
			sys.exit(1)
		#end_if

		# Skip headers and footers:
		if (header_flag == True):
			if (logline[0:20] == "********************"):
				header_flag = False
			#end_if
			continue
		#end_if
		if (logline[0:9] == "[OVERALL]"):
			break
		#end_if

		logline_list = logline.split(" [")
		subline_list = logline_list[0].split(" ")

		if (len(subline_list) != 3):
			print("Unexpected length")
			sys.exit(1)
		#end_if

		operation = subline_list[0]
		operation_list.append(operation)
		key = subline_list[2]
		if (key[0:4] != "user"):
			print("Unexpected key")
			print(iteration)
			print(logline)
			sys.exit(1)
		#end_if
		key_list.append(key[4:])

	#end_while

	input_file.close()

	return operation_list, key_list

#end_def


def main():

	print("Hello World")

	workload = ""
	input_file_name = ""
	path = "ycsb_benchmark/"
	operation_list = []
	key_list = []
	output_file_name = ""
	output_file = "" # File obj
	output_line = ""

	workload = sys.argv[1]

	input_file_name = path + "ycsb_raw_" + workload + ".txt"

	operation_list, key_list = get_data(input_file_name)

	if (len(operation_list) != len(key_list)):
		print("Mismatch lengths")
		sys.exit(1)
	#end_if

	output_file_name = path + "ycsb_tsv_" + workload + ".tsv"

	output_file = open(output_file_name, "w")

	for e, f in zip(operation_list, key_list):
		output_line = e + "\t" + f + "\n"
		output_file.write(output_line)
	#end_for

	output_file.close()

	return

#end_def


main()

