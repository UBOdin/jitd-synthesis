
import sys
import os
import json


def get_data(file_name):

	# file_name = ""
	# -----
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


def process_workload(workload):

	# workload = ""
	# -----
	input_file_name = ""
	path = "ycsb_benchmark/"
	operation_list = []
	key_list = []
	output_file_name = ""
	output_file = "" # File obj
	output_line = ""


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

	return operation_list, key_list

#end_def


def main():

	print("Hello World")

	workload = ""
	workload_operation_list = []
	workload_key_list = []
	initialize_operation_list = []
	initialize_key_list = []
	benchmark_file_name = ""
	benchmark_file = "" # file obj
	output_line = ""
	operation = ""
	rows = ""

	workload = sys.argv[1]

	initialize_operation_list, initialize_key_list = process_workload("initialize_" + workload)
	workload_operation_list, workload_key_list = process_workload("workload_" + workload)

	benchmark_file = open("ycsb_benchmark/workload_" + workload + "_data.cpp", "w")
	benchmark_file.write("\n")
	benchmark_file.write("#include \"harness.hpp\"\n")
	benchmark_file.write("\n")
	benchmark_file.write("struct operation_node seed_array[] {\n")
	rows = ""
	for e, f in zip(initialize_operation_list, initialize_key_list):
		if (e != "INSERT"):
			print("Unsupported operation")
			sys.exit(1)
		#end_if
		benchmark_file.write("\t{ .type = INSERT, .time = 0.0, .key = " + f + "},\n")
	#end_for
	benchmark_file.write("\t{ .type = STOP },\n")
	benchmark_file.write("};\n")
	benchmark_file.write("\n")
	benchmark_file.write("struct operation_node operation_array[] {\n")
	for e, f in zip(workload_operation_list, workload_key_list):
		if (e == "READ"):
			operation = "SELECT"
			rows = ", .rows = 0"
		elif ((e == "UPDATE") or (e == "INSERT")):
			operation = e
			rows = ""
		else:
			print("Unsupported operation")
			sys.exit(1)
		#end_if
		benchmark_file.write("\t{ .type = " + operation + ", .time = 0.0, .key = " + f + rows + "},\n")
	#end_for
	benchmark_file.write("\t{ .type = STOP },\n")
	benchmark_file.write("};\n")
	benchmark_file.write("\n")
	benchmark_file.close()

#end_def


main()

