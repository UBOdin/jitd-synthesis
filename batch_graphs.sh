
echo "Running graphscript batch"

runs="0 1 2 3" # runs

for e in $runs; do

	echo "\nRunning instance $e\n"
	python jitd_tdf.py output/jitd_$e.txt script
	mv latency_frequency.pdf graphs/latency_frequency_jitd_$e.pdf
	mv latency_walltime.pdf graphs/latency_walltime_jitd_$e.pdf
	mv latency_rowcount.pdf graphs/latency_rowcount_jitd_$e.pdf
	# (skip cdf)

	python jitd_tdf.py output/sqlite_$e.txt script
	mv latency_frequency.pdf graphs/latency_frequency_sqlite_$e.pdf
	mv latency_walltime.pdf graphs/latency_walltime_sqlite_$e.pdf
	mv latency_rowcount.pdf graphs/latency_rowcount_sqlite_$e.pdf

	python jitd_diff.py output/jitd_$e.txt output/sqlite_$e.txt script
	mv latency_difference.pdf graphs/latency_difference_$e.pdf

done

cp graphs/* ../../paper-mobisys2020/figures/assorted/latency/

echo "\nDone"

