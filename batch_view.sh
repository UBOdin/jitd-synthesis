
echo "Starting view batch"

#workload_list="a b c d e f"
workload_list="a b c d f"
#workload_list="f"

run_list="0 1 2 3 4 5 6 7 8 9"

crack_size="100"
prepopulate="30000000"

echo "Running with CRACKSIZE ${crack_size}"

for workload in $workload_list; do

	echo "\nRunning workload ${workload}"

	cp ycsb_benchmark/ycsb_tab_initialize_${workload}.tsv initialize_data.txt
	cp ycsb_benchmark/ycsb_tab_benchmark_${workload}.tsv benchmark_data.txt

	for run in $run_list; do

		echo "Running run ${run}"

		sleep 2
		./replay_jitd.exe $crack_size $prepopulate 100
		if [ "$?" != "0" ]; then
			echo "Error on jitd replay"
			exit 1
		fi
		mv output_view_performance.txt view_results/jitd_view_performance_${workload}_${run}.txt
		mv output_data.txt view_results/jitd_data_performance_${workload}_${run}.txt
		sleep 2
		./replay_dbt.exe $crack_size $prepopulate 100
		if [ "$?" != "0" ]; then
			echo "Error on dbt replay"
			exit 1
		fi
		mv output_view_performance.txt view_results/dbt_view_performance_${workload}_${run}.txt
		mv output_data.txt view_results/dbt_data_performance_${workload}_${run}.txt

	done

done

echo "\nRunning with CRACKSIZE ${crack_size}"

echo "\nFinished"

