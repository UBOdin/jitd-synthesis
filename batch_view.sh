
echo "Starting view batch"

keyspace_list="4 5 6"
#keyspace_list="5 6"
#keyspace_list="4 5"

operations="3"
#operations="4"

#workload_list="a b c d e f"
workload_list="a b c d f"
#workload_list="a f"

run_list="0 1 2 3 4 5 6 7 8 9"

crack_size="1000"  # Will change
prepopulate="30000000"  # A very big number; ensure all keys are pre-populated

sleep_time="100"
crack_ratio="10"
keycount="1"  # will change

#machine="SPINNERS"
machine="MJOLNIR"

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

	echo "\nRunning with CRACKSIZE ${crack_size}\n"

	cp YCSB_RAW_10e${keyspace}k_10e${operations}o/* ycsb_benchmark

	for workload in $workload_list; do

		echo "\nRunning workload ${workload} and cracksize ${crack_size}\n"

		cp ycsb_benchmark/ycsb_tab_initialize_${workload}.tsv initialize_data.txt
		cp ycsb_benchmark/ycsb_tab_benchmark_${workload}.tsv benchmark_data.txt

		for run in $run_list; do

			# Per-node runs (set, view, dbt):
			echo "\nRunning per-node run ${run}\n"

			sleep 2
			./replay_node_set.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on node set replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/set_node_performance_${workload}_${run}.txt
			mv output_data.txt view_results/set_data_performance_${workload}_${run}.txt

			sleep 2
			./replay_node_view.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on node view replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/jitd_node_performance_${workload}_${run}.txt
			mv output_data.txt view_results/jitd_data_performance_${workload}_${run}.txt

			sleep 2
			./replay_node_dbt.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on node dbt replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/dbt_node_performance_${workload}_${run}.txt
			mv output_data.txt view_results/dbt_data_performance_${workload}_${run}.txt

			# Per-transform runs (set, view, dbt):
			echo "\nRunning per-transform run ${run}\n"

			sleep 2
			./replay_trans_set.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on transform set replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/set_trans_performance_${workload}_${run}.txt
			#mv output_data.txt view_results/set_data_performance_${workload}_${run}.txt

			sleep 2
			./replay_trans_view.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on transform view replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/jitd_trans_performance_${workload}_${run}.txt
			#mv output_data.txt view_results/jitd_data_performance_${workload}_${run}.txt

			sleep 2
			./replay_trans_dbt.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on transform dbt replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/dbt_trans_performance_${workload}_${run}.txt
			#mv output_data.txt view_results/dbt_data_performance_${workload}_${run}.txt

		done

	done

	rm -rf ${machine}_view_results_10e${keyspace}k_10e${operations}o
	mkdir ${machine}_view_results_10e${keyspace}k_10e${operations}o
	mv view_results/* ${machine}_view_results_10e${keyspace}k_10e${operations}o

done

#echo "\nRunning with CRACKSIZE ${crack_size}"

echo "\nFinished"

