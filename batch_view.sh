
echo "Starting view batch"

#keyspace_list="4 5 6"
keyspace_list="5 6 7"

operations="3"
#operations="4"

#workload_list="a b c d e f"
workload_list="a b c d f"
#workload_list="a f"

run_list="0 1 2 3 4 5 6 7 8 9"
#run_list="0 1 2"


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

	# 10e7 keyspace is 3M (memory issues) -- kludge
	if [ "${keyspace}" = "7" ]; then
		crack_size="300000"
	fi

	echo "\nRunning with CRACKSIZE ${crack_size}\n"

	# Make links in working directory to source files (avoid file copy):
	sourcepath="YCSB_RAW_10e${keyspace}k_10e${operations}o"
	destpath="ycsb_benchmark"
	file_list=$( ls -1 ${sourcepath} )
	for file in $file_list; do
		#echo "$sourcepath/$file"
		ln $sourcepath/$file $destpath/$file
		if [ "$?" != "0" ]; then
			echo "Error"
			exit 1
		fi
	done

	for workload in $workload_list; do

		echo "\nRunning workload ${workload} and cracksize ${crack_size}\n"

		cp ycsb_benchmark/ycsb_tab_initialize_${workload}.tsv initialize_data.txt
		cp ycsb_benchmark/ycsb_tab_benchmark_${workload}.tsv benchmark_data.txt

		for run in $run_list; do

			# Per-node runs (naive, set, view, toaster, classic):
			echo "\nRunning per-node run ${run}\n"

			sleep 2
			./replay_node_naive.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on node naive replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/naive_node_performance_${workload}_${run}.txt
			mv output_data.txt view_results/naive_data_performance_${workload}_${run}.txt

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
			./replay_node_toaster.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on node toaster replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/toaster_node_performance_${workload}_${run}.txt
			mv output_data.txt view_results/toaster_data_performance_${workload}_${run}.txt

			sleep 2
			./replay_node_classic.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on node classic replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/classic_node_performance_${workload}_${run}.txt
			mv output_data.txt view_results/classic_data_performance_${workload}_${run}.txt

			# Per-transform runs (naive, set, view, toaster, classic):
			echo "\nRunning per-transform run ${run}\n"

			sleep 2
			./replay_trans_naive.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on transform naive replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/naive_trans_performance_${workload}_${run}.txt
			#mv output_data.txt view_results/naive_data_performance_${workload}_${run}.txt

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
			./replay_trans_toaster.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on transform toaster replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/toaster_trans_performance_${workload}_${run}.txt
			#mv output_data.txt view_results/toaster_data_performance_${workload}_${run}.txt

			sleep 2
			./replay_trans_classic.exe $crack_size $prepopulate $sleep_time
			if [ "$?" != "0" ]; then
				echo "Error on transform classic replay"
				exit 1
			fi
			mv output_view_performance.txt view_results/classic_trans_performance_${workload}_${run}.txt
			#mv output_data.txt view_results/classic_data_performance_${workload}_${run}.txt

		done

	done

	rm ycsb_benchmark/*

	rm -rf ${machine}_view_results_10e${keyspace}k_10e${operations}o
	mkdir ${machine}_view_results_10e${keyspace}k_10e${operations}o
	mv view_results/* ${machine}_view_results_10e${keyspace}k_10e${operations}o

done

#echo "\nRunning with CRACKSIZE ${crack_size}"

echo "\nFinished"

