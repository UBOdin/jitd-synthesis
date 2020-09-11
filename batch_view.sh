
echo "Starting view batch"

#keyspace_list="4 5 6"
keyspace_list="5 6"

#workload_list="a b c d e f"
workload_list="a b c d f"
#workload_list="a f"

run_list="0 1 2 3 4 5 6 7 8 9"

crack_size="1000"  # Will change
prepopulate="30000000"  # A very big number; ensure all keys are pre-populated

sleep_time="100"

make build_replay_dbop
if [ "$?" != "0" ]; then
	echo "Error on dbop build"
	exit 1
fi
make build_replay_node
if [ "$?" != "0" ]; then
	echo "Error on node build"
	exit 1
fi
	
for keyspace in $keyspace_list; do

	if [ "$keyspace" = "4" ];then
		crack_size="1000"
	elif [ "$keyspace" = "5" ]; then
		crack_size="10000"
	elif [ "$keyspace" = "6" ]; then
		crack_size="100000"
	else
		printf "Unrecognized keyspace\n"
		exit 1
	fi

	echo "\nRunning with CRACKSIZE ${crack_size}\n"

	cp YCSB_RAW_10e${keyspace}/* ycsb_benchmark

	for workload in $workload_list; do

		echo "\nRunning workload ${workload}\n"

		cp ycsb_benchmark/ycsb_tab_initialize_${workload}.tsv initialize_data.txt
		cp ycsb_benchmark/ycsb_tab_benchmark_${workload}.tsv benchmark_data.txt

		for run in $run_list; do

			echo "Running run ${run}"

			sleep 2
			./replay_node_set.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on set replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/set_view_performance_${workload}_${run}.txt
			mv output_data.txt view_results/set_data_performance_${workload}_${run}.txt
			sleep 2
			./replay_node_view.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on view replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/jitd_view_performance_${workload}_${run}.txt
			mv output_data.txt view_results/jitd_data_performance_${workload}_${run}.txt
			sleep 2
			./replay_node_dbt.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on dbt replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/dbt_view_performance_${workload}_${run}.txt
			mv output_data.txt view_results/dbt_data_performance_${workload}_${run}.txt

		done

	done

	rm -rf view_results_10e${keyspace}
	mkdir view_results_10e${keyspace}
	mv view_results/* view_results_10e${keyspace}

done

#echo "\nRunning with CRACKSIZE ${crack_size}"

echo "\nFinished"

