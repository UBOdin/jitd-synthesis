
echo "Running batch"

storage_list="jitd map uom"
keymax_list="30000 3"

#make clean

for storage in $storage_list; do

	if [ ${storage} = "jitd" ]; then
		threshhold_list="2 2000"
		alloc_list="default aligned"
		#thread_list="pthread intel"
		thread_list="intel"
		delay_list="block spin"
	else
		# Dummy values for non-jitd:
		threshhold_list="X"
		alloc_list="X"
		thread_list="X"
		delay_list="X"
	fi

	# Iterate over compiletime parameters:
	for alloc in $alloc_list; do
		for thread in $thread_list; do
			for delay in $delay_list; do

				# Rebuild for each new storage type (where the binary changes) for paranoia
				make clean
				make jitd_storage_${storage} alloc=${alloc} thread=${thread} delay=${delay}
				if [ "$?" != "0" ]; then
					echo "Error on build"
					exit 1
				fi
				echo "Clean build on ${storage}"

				# Iterate over runtime parameters:
				for keymax in $keymax_list; do
					for threshhold in $threshhold_list; do

						printf "\nRunning ${storage} instance with ${alloc} allocator, ${thread} threading, ${delay} delay, ${keymax} keys and ${threshhold} crack threshhold\n"
						sleep 10
						./jitd_harness.exe $threshhold $keymax
						if [ "$?" != "0" ]; then
							echo "Error on JITD"
							exit 1
						fi
						mv output_data.txt ${storage}_${alloc}_${thread}_${delay}_${threshhold}_${keymax}_output_data.txt

					done
				done

			done
		done
	done

done

echo "\nDone"

