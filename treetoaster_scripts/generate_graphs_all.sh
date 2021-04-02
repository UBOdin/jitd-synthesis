#!/bin/bash

echo "Downloading tracefiles"

wget http://data.vizierdb.info/JITD/treetoaster_files/treetoaster_tracefiles.tgz
result=$?
if [ "$result" != "0" ]; then
	echo "Error retrieving tracefiles"
	exit 1
fi

tar -xzf treetoaster_tracefiles.tgz
mv view_results tracefiles

echo "Tracefiles downloaded"
echo "Starting graph generation"

python generate_graphs_9_10_12.py
result=$?
if [ "$result" != "0" ]; then
	echo "Error generating graphs 9-10-12"
	exit 1
fi

python generate_graphs_11_13.py
result=$?
if [ "$result" != "0" ]; then
	echo "Error generating graphs 11-13"
	exit 1
fi

echo "\nSUCCESS.  All graphs in treetoaster_scripts/graphs directory"

