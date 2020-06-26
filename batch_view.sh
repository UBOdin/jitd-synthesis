
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
	./jitd_harness.exe 100 1000 100
	if [ "$?" != "0" ]; then
		echo "Error on harness"
		exit 1
	fi
	mv output_view.txt view_results/output_view_${workload}.txt

done

echo "Finished"

