
echo "Running batch"

storage_list="asal map uom"
keymax_list="30000 3"

#make clean

for storage in $storage_list; do

	if [ ${storage:0:1} = "a" ]; then
		threshhold_list="2 2000"
		alloc_list="default aligned"
		thread_list="pthread intel"
	else
		# Dummy values for non-jitd:
		threshhold_list="X"
		alloc_list="Y"
		thread_list="Z"
	fi

	for alloc in $alloc_list; do

		for thread in $thread_list; do

			# Rebuild for each new storage type (where the binary changes) for paranoia
			make clean
			make jitd_storage_${storage} alloc=${alloc} thread=${thread}  # N.b. alloc and thread parameters N/A for jitd -- probably should pull
			if [ "$?" != "0" ]; then
				echo "Error on build"
				exit 1
			fi
			echo "Clean build on ${storage}"

			for keymax in $keymax_list; do

				for threshhold in $threshhold_list; do

					printf "\nRunning ${storage} instance with ${alloc} allocator, ${thread} threading, ${keymax} keys and crack threshhold of ${threshhold}\n"
					sleep 10
					./jitd_harness.exe $threshhold $keymax
					if [ "$?" != "0" ]; then
						echo "Error on JITD"
						exit 1
					fi
					mv output_data.txt ${storage}_${thread}_${threshhold}_${keymax}_output_data.txt

				done

			done

		done

	done

done

echo "\nDone"

