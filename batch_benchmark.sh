
echo "Running batch"

storage_list="asal_default asal_aligned map uom"
keymax_list="30000 3"

#make clean

for storage in $storage_list; do

	# Paranoid:  Force rebuilds of jitd (source may not have changed, but preprocessor -D may have):
	rm jitd_*.o

	make clean
	make jitd_storage_${storage}
	if [ "$?" != "0" ]; then
		echo "Error on build"
		exit 1
	fi
	echo "Clean build on ${storage}"

	for keymax in $keymax_list; do

		if [ ${storage:0:1} = "a" ]; then
			threshhold_list="2 2000"
		else
			threshhold_list="X"  # dummy -- N/A for non-jitd
		fi

		for threshhold in $threshhold_list; do

			printf "\nRunning ${storage} instance with ${keymax} keys and crack threshhold of ${threshhold}\n"
			sleep 10
			./jitd_harness.exe $threshhold $keymax
			if [ "$?" != "0" ]; then
				echo "Error on JITD"
				exit 1
			fi
			mv output_data.txt ${storage}_${threshhold}_${keymax}_output_data.txt

		done

	done

done

echo "\nDone"

