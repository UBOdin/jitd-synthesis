
import sys
import os
import json


def get_data(file_name):

	input_file = "" # file obj
	iteration = -1
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

		if (iteration <= 11):
			continue
		elif (iteration == 12):
			if (logline[0:5] != "*****"):
				print("Bad header")
				sys.exit(1)
			#end_if
			continue
		elif (iteration == 1013):
			if (logline[0:9] != "[OVERALL]"):
				print("Bad footer")
				sys.exit(1)
			#end_if
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

	file_name = ""
	operation_list = []
	key_list = []

	file_name = sys.argv[1]

	operation_list, key_list = get_data(file_name)

	print(operation_list)
	print(key_list)
	
	return

#end_def


main()

