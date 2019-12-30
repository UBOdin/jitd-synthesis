
echo "Running batch"

runs="0 1 2 3" # runs

# Build executables for each storage type:
echo "Building executables:"
make clean
make jitd_storage_jitd
mv jitd_harness jitd_harness_jitd.exe
make clean
make jitd_storage_sqlite
mv jitd_harness jitd_harness_sqlite.exe
make clean
make jitd_storage_uomap
mv jitd_harness jitd_harness_uomap.exe
echo "Done building"

for e in $runs; do

	echo "\nRunning instance $e\n"
	sleep 5
	./jitd_harness_jitd.exe
	if [ "$?" != "0" ]; then
		echo "Error on JITD"
		exit 1
	fi
	mv output_data.txt output/jitd_$e.txt

	echo
	sleep 5
	./jitd_harness_sqlite.exe
	if [ "$?" != "0" ]; then
		echo "Error on SQLite"
		exit 1
	fi
	mv output_data.txt output/sqlite_$e.txt

	echo
	sleep 5
	./jitd_harness_uomap.exe
	if [ "$?" != "0" ]; then
		echo "Error on UOMap"
		exit 1
	fi
	mv output_data.txt output/uomap_$e.txt

done

echo "\nDone"

