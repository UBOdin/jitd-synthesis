
echo "Running batch"

keymax="30000"
atomic_list="asal asralc"
threshhold_list="2 7 20 70 200"


for atomic in $atomic_list; do

	make clean
	make jitd_storage_${atomic}
	if [ "$?" != "0" ]; then
		echo "Error on build"
		exit 1
	fi
	echo "Clean build on ${atomic}"

	for threshhold in $threshhold_list; do

		echo "\nRunning instance $e\n"
		sleep 5
		./jitd_harness.exe $keymax $threshhold
		if [ "$?" != "0" ]; then
			echo "Error on JITD"
			exit 1
		fi
		mv output_data.txt ${atomic}_full_${threshhold}_output_data.txt

	done

done

echo "\nDone"

