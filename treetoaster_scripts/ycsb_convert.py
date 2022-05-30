
import sys
import os
import json


op_dict = { "INSERT":"0", "READ":"1", "DELETE":"2", "UPDATE":"3", "UPSERT":"4" }


def sort_key(input_list):

	return input_list[0]

#end_def


def get_data(workload):

	# workload = ""
	# -----
	path = "ycsb_benchmark/"
	input_file_name = ""
	output_file_name = ""
	input_file = "" # file obj
	output_file = "" # file obj
	iteration = -1
	header_flag = True
	offset = 0
	logline = ""
	index = 0
	logline_header_list = []
	operation = ""
	#operation_list = []
	key = ""
	#key_list = []

	field_header = ""
	field_key = ""
	field_value = ""
	presort_list = []
	input_line = ""

	input_file_name = path + "ycsb_raw_" + workload + ".txt"
	output_file_name = path + "ycsb_tab_" + workload + ".tsv"

	input_file = open(input_file_name, "r")
	output_file = open(output_file_name, "w")

	while (True):

		iteration += 1

		# Keep reading until finished:
		logline = input_file.readline() #.decode("ascii")
		if (logline == ""):
			print("No data")
			sys.exit(1)
		#end_if

		# Skip headers and footers:
		if (header_flag == True):
			if (logline[0:20] == "********************"):
				header_flag = False
				offset = iteration + 1
			#end_if
			continue
		#end_if
		if (logline[0:9] == "[OVERALL]"):
			break
		#end_if

		parseline_list = []

		index = logline.find(" [ ", 0, 50)
		if (index == -1):
			print("Delimiter not found")
			sys.exit(1)
		#end_if
		logline_header_list = logline[:index].split(" ")

		if (len(logline_header_list) != 3):
			print("Unexpected length")
			#sys.exit(1)  TODO:  Extra SCAN parameter?
		#end_if

		operation = logline_header_list[0]
		key = logline_header_list[2]
		if (key[0:4] != "user"):
			print("Unexpected key")
			print(iteration)
			print(logline)
			sys.exit(1)
		#end_if
		#parseline_list.append(key[4:])

		index += 3 # skip over " ] "

		presort_list = []

		while (True):

			field_header = logline[index:index + 5]
			if (field_header == "]\n"):
				break
			elif (field_header == "<all "):
				break
			elif (field_header != "field"):
				print("Unexpected k-v delimiter")
				sys.exit(1)
			#end_if

			field_key = logline[index + 5:index + 6]
			field_value = logline[index + 7:index + 107]

			#'''
			# Escape backslash and quote characters (magic meaning in C strings):
			field_value = field_value.replace("\\", "\\\\")
			field_value = field_value.replace("\"", "\\\"")
			# Escape question marks (double ?? is preprocessor trigraph alert):
			field_value = field_value.replace("?", "\\?")
			#field_value = field_value.replace("\'", "\\\'")
			# SQLite issues with single quote:
			field_value = field_value.replace("'", "_")
			#'''

			presort_list.append([field_key, field_value])

			if (logline[index + 107:index + 108] != " "):
				print("Unexpected intrafield delimiter")
				sys.exit(1)
			#end_if

			index += 108

		#end_while

		presort_list = sorted(presort_list, key = sort_key)

		output_line = str(iteration - offset) + "\t" + op_dict[operation] + "\t" + key[4:]

		for e in presort_list:
			output_line += "\t" + e[0] + "\t" + e[1]
		#end_for

		output_line += "\n"

		output_file.write(output_line)

	#end_while

	input_file.close()
	output_file.close()

#end_def


def main():

	print("Hello World")

	workload = ""
	datatype = ""

	#workload = sys.argv[1]
	workload_list = ["a", "b", "c", "d", "e", "f"]
	workload_list = ["a", "b", "c", "d", "f"]
	#workload_list = ["b"]

	datatype_list = ["initialize", "benchmark"]

	#process_initialize_benchmark_pair(workload)
	#'''
	for workload in workload_list:
		print("Processing workload %s" % (workload))
		for datatype in datatype_list:
			get_data(datatype + "_" + workload)
		#end_for
	#end_for
	#'''

#end_def


main()

