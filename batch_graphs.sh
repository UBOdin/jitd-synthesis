
#run_list="3 4 5 6"
run_list="4 5 6"

echo "Generating graphs"

for run in $run_list; do

	echo "\nDoing run with 10e${run} keys\n"

	cp MJOLNIR_view_results_10e${run}/* view_results
	python data_process.py
	if [ "$?" != "0" ];then
		echo "Error on python data graph script"
		exit 1
	fi
	python view_process.py
	if [ "$?" != "0" ];then
		echo "Error on python view graph script"
		exit 1
	fi
	cp view_graphs/* MJOLNIR_view_graphs_10e${run}
	if [ "$?" != "0" ];then
		echo "Error on exporting data"
		exit 1
	fi

done

echo "Done"
