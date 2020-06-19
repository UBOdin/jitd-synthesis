
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
			field_value = logline[index + 7:index + 107]

			# Escape backslash and quote characters (magic meaning in C strings):
			field_value = field_value.replace("\\", "\\\\")
			field_value = field_value.replace("\"", "\\\"")
			# Escape question marks (double ?? is preprocessor trigraph alert):
			field_value = field_value.replace("?", "\\?")
			#field_value = field_value.replace("\'", "\\\'")
			# SQLite issues with single quote:
			field_value = field_value.replace("'", "_")

			presort_list.append([field_key, field_value])

			if (logline[index + 107:index + 108] != " "):
				print("Unexpected intrafield delimiter")
				sys.exit(1)
			#end_if

			index += 108

		#end_while

		presort_list = sorted(presort_list, key = sort_key)

		for e in presort_list:
			parseline_list.append(e[0])
			parseline_list.append(e[1])
		#end_for

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
	benchmark_file = "" # file obj
	initialize_list_list = []
	initialize_list = []
	benchmark_list_list = []
	benchmark_list = []
	listlen = 0
	output_line = ""
	operation = ""
	key = ""
	rows = ""
	field = ""
	field_array = ""

	quit = 0

	initialize_list_list = process_workload("initialize_" + workload)
	benchmark_list_list = process_workload("benchmark_" + workload)

	benchmark_file = open("sourcefiles/workload_" + workload + "_data.cpp", "w")
	benchmark_file.write("\n")
	benchmark_file.write("#include \"harness.hpp\"\n")
	benchmark_file.write("\n")
	benchmark_file.write("using namespace harness;\n")
	benchmark_file.write("\n")
	benchmark_file.write("struct operation_node initialize_array[] = {\n")

	i = 0
	for initialize_list in initialize_list_list:
		if (i == 10):
			pass #break
		#end_if
		operation = initialize_list[0]
		assert (len(initialize_list) == 22), "Unexpected initialize field length"
		if (operation != "INSERT"):
			print("Unsupported initialize operation")
			sys.exit(1)
		#end_if
		key = initialize_list[1]
		field_array = "{ "
		for j in range(2, 22, 2):
			# Fields should be 0, 1, ... 9:
			assert(int(initialize_list[j]) == (j - 2) / 2), "val:  %s" % (initialize_list[j])
			field_array += "\"" + initialize_list[j + 1] + "\", "
		#end_for
		field_array += "}, "
		benchmark_file.write("\t{ .id = " + str(i) + ", .type = INSERT, .time = 0.0, .rows = 0, .nkeys = 1, .value = 0, .key = " + key + ", .key_array = NULL, .field = 0, .field_array = " + field_array + " },\n")
		i += 1
	#end_for
	benchmark_file.write("\t{ .id = " + str(i) + ", .type = STOP },\n")
	benchmark_file.write("};\n")
	benchmark_file.write("\n")
	benchmark_file.write("struct operation_node benchmark_array[] = {\n")

	quit = 0

	i = 0
	for benchmark_list in benchmark_list_list:
		if (i == 10):
			pass #break
		#end_if
		operation = benchmark_list[0]
		key = benchmark_list[1]
		listlen = len(benchmark_list)
		if (operation == "READ"):
			assert (listlen == 2), "Unexpected read field length"
			operation = "SELECT"
			field = "-1" # Magic value:  field is N/A
			field_array = "{\"\", \"\", \"\", \"\", \"\", \"\", \"\", \"\", \"\", \"\"}"
		elif (operation == "UPDATE"):
			assert (listlen == 4), "Unexpected update field length"
			field = benchmark_list[2]
			#val = benchmark_list[3] + fill900 # As above match size...

			field_array = "{\"" + benchmark_list[3] + "\", \"\", \"\", \"\", \"\", \"\", \"\", \"\", \"\", \"\"}"

		elif (operation == "INSERT"):
			assert (listlen == 22), "Unexpected insert field length"
			field = "10" # Magic value:  all 10 (0-9), not #10
			field_array = "{ "
			for j in range(2, 22, 2):
				# Fields should be 0, 1, ... 9:
				assert(int(initialize_list[j]) == (j - 2) / 2), "val:  %s" % (initialize_list[j])
				field_array += "\"" + initialize_list[j + 1] + "\", "
			#end_for
			field_array += "}, "
		elif (operation == "SCAN"):
			assert (listlen == 2), "Unexpected scan field length"
			field = "-1" # Magic value:  field is N/A
			field_array = "{\"\", \"\", \"\", \"\", \"\", \"\", \"\", \"\", \"\", \"\"}"
		else:
			print("Unsupported benchmark operation")
			sys.exit(1)
		#end_if
		benchmark_file.write("\t{ .id = " + str(i) + ", .type = " + operation + ", .time = 0.0, .rows = 0, .nkeys = 1, .value = 0, .key = " + key + ", .key_array = NULL, .field = " + field + ", .field_array = " + field_array + " },\n")
		i += 1
	#end_for
	benchmark_file.write("\t{ .id = " + str(i) + ", .type = STOP },\n")
	benchmark_file.write("};\n")
	benchmark_file.write("\n")
	benchmark_file.write("struct output_node output_array[sizeof(benchmark_array) / sizeof(operation_node)];\n")
	benchmark_file.write("long output_size = sizeof(benchmark_array) / sizeof(operation_node);\n")
	benchmark_file.write("\n")
	benchmark_file.close()

	return

#end_def


def main():

	print("Hello World")

	workload = ""

	#workload = sys.argv[1]
	#workload_list = ["a", "b", "c", "d", "e", "f"]
	workload_list = ["b"]

	#process_initialize_benchmark_pair(workload)
	#'''
	for workload in workload_list:
		print("Processing workload %s" % (workload))
		process_initialize_benchmark_pair(workload)
	#end_for
	#'''

#end_def


main()

