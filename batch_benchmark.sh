
echo "Running batch"

storage_list="map uom asal_default asal_aligned asralc_default asralc_aligned"
keymax_list="30000 3"

make clean

for storage in $storage_list; do

	# Paranoid:  Force rebuilds of jitd (source may not have changed, but preprocessor -D may have):
	rm jitd_*.o

	make jitd_storage_${storage}
	if [ "$?" != "0" ]; then
		echo "Error on build"
		exit 1
	fi
	echo "Clean build on ${storage}"

	for keymax in $keymax_list; do

		if [ "$keymax" = "30000" ]; then
			threshhold="2000"
			echo "30000 keys"
		fi
		if [ "$keymax" = "3" ];then
			threshhold="1"
			echo "3 keys"
		fi

		echo "\nRunning instance with ${keymax} keys and crack threshhold of ${threshhold}\n"
		sleep 5
		./jitd_harness.exe $keymax $threshhold
		if [ "$?" != "0" ]; then
			echo "Error on JITD"
			exit 1
		fi
		mv output_data.txt ${storage}_${keymax}_output_data.txt

	done

done

echo "\nDone"

