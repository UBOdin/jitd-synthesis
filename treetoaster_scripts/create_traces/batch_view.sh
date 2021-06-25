
echo "Starting view batch"

#keyspace_list="4 5 6"
#keyspace_list="5 6 7"
keyspace_list="7"

operations="3"
#operations="4"

#workload_list="a b c d e f"
workload_list="a b c d f"
#workload_list="a f"

run_list="0 1 2 3 4 5 6 7 8 9"
#run_list="0 1 2"

method_list="naive set view toaster classic"  # Search method

#class_list="node trans"  # Data classification method
class_list="trans"

crack_size="1000"  # Will change
prepopulate="30000000"  # A very big number; ensure all keys are pre-populated

sleep_time="100"
crack_ratio="10"
keycount="1"  # will change

export LD_LIBRARY_PATH=/opt/intel/compilers_and_libraries_2020.0.166/linux/tbb/lib/intel64/gcc4.8

#make build_replay_dbop
if [ "$?" != "0" ]; then
	echo "Error on dbop build"
	exit 1
fi
#make build_replay_node
if [ "$?" != "0" ]; then
	echo "Error on node build"
	exit 1
fi
make build_replay_trans
if [ "$?" != "0" ]; then
	echo "Error on transform build"
	exit 1
fi

for keyspace in $keyspace_list; do

	# The following kludge is necessary because not all shells support **:
	keycount="1"
	for i in $(seq 1 $keyspace); do
		keycount=$(($keycount * 10))
	done
	crack_size=$(( $keycount / $crack_ratio ))
	#echo "keyspace:  ${keyspace}  keycount:  ${keycount}  crack_size:  ${crack_size}"

	# 10e7 keyspace is 3M (memory issues) -- kludge
	if [ "${keyspace}" = "7" ]; then
		crack_size="300000"
	fi

	echo "\nRunning with CRACKSIZE ${crack_size}\n"

	for workload in $workload_list; do

		echo "\nRunning workload ${workload} and cracksize ${crack_size}\n"

		cp ycsb_benchmark/ycsb_tab_initialize_${workload}.tsv initialize_data.txt
		cp ycsb_benchmark/ycsb_tab_benchmark_${workload}.tsv benchmark_data.txt

		for run in $run_list; do

			for class in $class_list; do

			# Per-{node / trans} runs (naive, set, view, toaster, classic):
			echo "\nRunning per-${class} run ${run}\n"

				for method in $method_list; do

					sleep 2

					echo $class $method $crack_size $prepopulate $sleep_time

					./replay_${class}_${method}.exe $crack_size $prepopulate $sleep_time
					if [ "$?" != "0" ]; then
						echo "Error on ${class} ${method} replay"
						exit 1
					fi
					mv output_view_performance.txt view_results/${method}_${class}_performance_${workload}_${run}.txt
					#if [ "${class}" = "node" ]; then
					if [ "${class}" = "trans" ]; then
						mv output_data.txt view_results/${method}_data_performance_${workload}_${run}.txt
					fi

				done

			done

		done

	done

#	rm ycsb_benchmark/*

done

# Cleanup:
rm initialize_data.txt
rm benchmark_data.txt
rm output_data.txt

echo "\nFinished"

