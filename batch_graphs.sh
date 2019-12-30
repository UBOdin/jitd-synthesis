
echo "Running graphscript batch"

runs="0 1 2 3" # runs

filetype="png"

for e in $runs; do

	echo "\nRunning instance $e\n"
	python jitd_latency.py output/jitd_$e.txt script $filetype
	mv latency_frequency.$filetype graphs/latency_frequency_jitd_$e.$filetype
	mv latency_walltime.$filetype graphs/latency_walltime_jitd_$e.$filetype
	mv latency_rowcount.$filetype graphs/latency_rowcount_jitd_$e.$filetype
	mv latency_key.$filetype graphs/latency_key_jitd_$e.$filetype
	mv walltime_key.$filetype graphs/walltime_key_jitd_$e.$filetype
	# (skip cdf)

	python jitd_latency.py output/sqlite_$e.txt script $filetype
	mv latency_frequency.$filetype graphs/latency_frequency_sqlite_$e.$filetype
	mv latency_walltime.$filetype graphs/latency_walltime_sqlite_$e.$filetype
	mv latency_rowcount.$filetype graphs/latency_rowcount_sqlite_$e.$filetype
	mv latency_key.$filetype graphs/latency_key_sqlite_$e.$filetype
	mv walltime_key.$filetype graphs/walltime_key_sqlite_$e.$filetype

	python jitd_diff.py output/jitd_$e.txt output/sqlite_$e.txt script $filetype
	mv latency_difference.$filetype graphs/latency_difference_$e.$filetype

done

cp graphs/* ../../paper-mobisys2020/figures/assorted/latency/

echo "\nDone"

