#!/bin/bash

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

echo "SUCCESS.  All graphs in ../graph directory"

