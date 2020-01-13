
import sys
import os
import json


def sort_key(input_list):

	return input_list[0]

#end_def


def get_data(file_name):

	# file_name = ""
	# -----
	input_file = "" # file obj
	iteration = -1
	header_flag = True
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

	parseline_list = []
	parseline_list_list = []


	input_file = open(file_name, "r")

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
		#operation_list.append(operation)
		parseline_list.append(operation)
		key = logline_header_list[2]
		if (key[0:4] != "user"):
			print("Unexpected key")
			print(iteration)
			print(logline)
			sys.exit(1)
		#end_if
		#key_list.append(key[4:])
		parseline_list.append(key[4:])

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
			#parseline_list.append(field_key)

			field_value = logline[index + 7:index + 107]
			field_value = field_value.replace(" ", "_")
			#parseline_list.append(field_value)

			presort_list.append([field_key, field_value])

			if (logline[index + 107:index + 108] != " "):
				print("Unexpected intrafield delimiter")
				sys.exit(1)
			#end_if

			index += 108

		#end_while

		#print("start sort")

		presort_list = sorted(presort_list, key = sort_key)

		#print("end sort")

		for e in presort_list:
			parseline_list.append(e[0])
			parseline_list.append(e[1])
		#end_for

		#print("end append")

		parseline_list_list.append(parseline_list)

	#end_while

	input_file.close()

	return parseline_list_list

#end_def


def process_workload(workload):

	# workload = ""
	# -----
	input_file_name = ""
	path = "ycsb_benchmark/"
	parseline_list_list = []
	parseline_list = []
	listlen = 0
	output_file_name = ""
	output_file = "" # File obj
	output_line = ""


	input_file_name = path + "ycsb_raw_" + workload + ".txt"

	parseline_list_list = get_data(input_file_name)

	output_file_name = path + "ycsb_tsv_" + workload + ".tsv"

	output_file = open(output_file_name, "w")

	for parseline_list in parseline_list_list:
		#output_line = parseline_list[0] + "\t" + parseline_list[1] + "\n"

		output_line = ""

		listlen = len(parseline_list)
		for i in range(listlen):
			if (i < listlen - 1):
				output_line += parseline_list[i] + "\t"
			else:
				output_line += parseline_list[i] + "\n"
			#end_if
		#end_for
		output_file.write(output_line)

	#end_for

	output_file.close()

	return parseline_list_list

#end_def


def process_initialize_benchmark_pair(workload):

	# workload = ""
	# -----
	benchmark_operation_list = []
	benchmark_key_list = []
	initialize_operation_list = []
	initialize_key_list = []
	benchmark_file_name = ""
	benchmark_file = "" # file obj
	output_line = ""
	operation = ""
	rows = ""

	#workload = sys.argv[1]

	process_workload("initialize_" + workload)
	process_workload("benchmark_" + workload)

	return

	initialize_operation_list, initialize_key_list = process_workload("initialize_" + workload)
	benchmark_operation_list, benchmark_key_list = process_workload("benchmark_" + workload)

	benchmark_file = open("ycsb_benchmark/workload_" + workload + "_data.cpp", "w")
	benchmark_file.write("\n")
	benchmark_file.write("#include \"harness.hpp\"\n")
	benchmark_file.write("\n")
	benchmark_file.write("struct operation_node seed_array[] {\n")
	rows = ""
	for e, f in zip(initialize_operation_list, initialize_key_list):
		if (e != "INSERT"):
			print("Unsupported initialize operation")
			sys.exit(1)
		#end_if
		benchmark_file.write("\t{ .type = INSERT, .time = 0.0, .key = " + f + "},\n")
	#end_for
	benchmark_file.write("\t{ .type = STOP },\n")
	benchmark_file.write("};\n")
	benchmark_file.write("\n")
	benchmark_file.write("struct operation_node operation_array[] {\n")
	for e, f in zip(benchmark_operation_list, benchmark_key_list):
		if (e == "READ"):
			operation = "SELECT"
			rows = ", .rows = 0"
		elif ((e == "UPDATE") or (e == "INSERT") or (e == "SCAN")):
			operation = e
			rows = ""
		else:
			print("Unsupported benchmark operation")
			sys.exit(1)
		#end_if
		benchmark_file.write("\t{ .type = " + operation + ", .time = 0.0, .key = " + f + rows + "},\n")
	#end_for
	benchmark_file.write("\t{ .type = STOP },\n")
	benchmark_file.write("};\n")
	benchmark_file.write("\n")
	benchmark_file.close()

#end_def


def main():

	print("Hello World")

	workload = ""
	workload_list = ["a", "b", "c", "d", "e", "f"]

	'''
	workload = sys.argv[1]

	process_workload(workload)
	'''

	for workload in workload_list:
		print("Processing workload %s" % (workload))
		process_initialize_benchmark_pair(workload)
	#end_for

#end_def


main()

