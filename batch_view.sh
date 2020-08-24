
echo "Starting view batch"

#workload_list="a b c d e f"
workload_list="a b c d f"


for workload in $workload_list; do

	echo "Running workload ${workload}"
	make clean
	cp data_${workload}.x data.o
	make jitd_storage_jitd
	if [ "$?" != "0" ]; then
		echo "Error on build"
		exit 1
	fi
	echo "Clean build"
	./jitd_harness.exe 100 30000 100
	if [ "$?" != "0" ]; then
		echo "Error on harness"
		exit 1
	fi

	# WAIT?
	./replay_jitd.exe 100 30000 100
	mv output_view_performance.txt view_results/jitd_view_performance_${workload}.txt

	# WAIT?
	./replay_dbt.exe 100 30000 100
	mv output_view_performance.txt view_results/dbt_view_performance_${workload}.txt

	mv output_view_maintenance.txt view_results/output_view_maintenance_${workload}.txt

	# N.b. benchmark latency is per-VM structure
	#mv output_data.txt output_data_${workload}.txt

done

echo "Finished"

