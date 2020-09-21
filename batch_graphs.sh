
#run_list="3 4 5 6"
#run_list="4 5 6"
run_list="5 6 7"
#run_list="7"

operations="3"

#machine="SPINNERS"
machine="MJOLNIR"

echo "Generating graphs"

for run in $run_list; do

	echo "\nDoing run with 10e${run} keys\n"

	cp ${machine}_view_results_10e${run}k_10e${operations}o/* view_results
	if [ "$?" != "0" ];then
		echo "Error on importing data"
		exit 1
	fi
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

	rm -rf ${machine}_view_graphs_10e${run}k_10e${operations}o
	mkdir ${machine}_view_graphs_10e${run}k_10e${operations}o
	mv view_graphs/* ${machine}_view_graphs_10e${run}k_10e${operations}o
	if [ "$?" != "0" ];then
		echo "Error on exporting data"
		exit 1
	fi

done

echo "Done"
