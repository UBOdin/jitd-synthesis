
import sys


def get_data(file_name):

	# file_name = ""
	# -----
	input_file = "" # file obj
	iteration = -1
	logline = ""
	logline_list = []
	key = ""
	key_dict = {}
	keycount = 0

	#file_name = sys.argv[1]

	input_file = open(file_name, "r")

	while (True):

		iteration += 1

		# Keep reading until finished:
		logline = input_file.readline().decode("ascii")
		if (logline == ""):
			break
		#end_if

		logline_list = logline.split("\t")
		key = logline_list[1]

		key_dict[key] = ""

	#end_while

	#print(key_dict)
	keycount = len(key_dict)

	input_file.close()

	return keycount

#end_def


def main():

	print("Hello World")

	filename = ""
	keycount = 0
	workload_list = ["a", "b", "c", "d", "e", "f"]
	middlefix = ""

	middlefix = "initialize_"
	for e in workload_list:
		file_name = "ycsb_benchmark/ycsb_tsv_" + middlefix + e + ".tsv"
		keycount = get_data(file_name)
		print("%s unique keycount:  %d" % (file_name, keycount))
	#end_for

	middlefix = "benchmark_"
	for e in workload_list:
		file_name = "ycsb_benchmark/ycsb_tsv_" + middlefix + e + ".tsv"
		keycount = get_data(file_name)
		print("%s unique keycount:  %d" % (file_name, keycount))
	#end_for

	return

#end_def


main()


