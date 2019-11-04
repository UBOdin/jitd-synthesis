
#include <memory>
#include <thread>

#include <stdio.h>
#include <string.h>
#include <sys/time.h>
#include <unistd.h>

#include "jitd_test.hpp"
#include "test.hpp"
#include "harness.hpp"


static std::shared_ptr<JITD> jitd;
static std::vector<Record> data;
static Record r;
static struct operation_node node;
static int i;

// N.b. struct Record.key -- long int; Record.value -- void*


double gettime_ms() {

	timeval now;

	gettimeofday(&now, NULL);

	return (now.tv_sec * 1000000.0 + now.tv_usec) / 1000.0;

}


int seed_jitds() {

	printf("Initializing data structure\n");
	i = 0;
	while (true) {
		node = seed_array[i];
		if (node.type == STOP) {
			break;
		}
		if (node.type != INSERT) {
			printf("Error:  expected Insert\n");
			_exit(1);
		}
		r.key = node.data.key;
		data.pop_back();
		data.push_back(r);
		jitd->insert(data);
		i++;
	}
	printf("Finished\n");
	return 0;

}


int test_jitds() {

	Key key;
	Key minkey = 999999;
	Key maxkey = 0;
	bool expected;
	bool observed;
	int j;

	printf("Verifying inserted data\n");

	// Get search range:
	i = 0;
	while (true) {
		node = seed_array[i];
		if (node.type == STOP) {
			break;
		}
		key = node.data.key;
		if (key > maxkey) {
			maxkey = key;
		}
		if (key < minkey) {
			minkey = key;
		}
		i++;
	}

	// TODO:  probably should use hashes here -- N^2 loop...
	// Verify that presence / absence of keys from seed array matches jitds population:
	for (i = minkey; i < maxkey; i++) {
		// Check whether target value _was_ inserted:
		expected = false;
		j = 0;
		while (true) {
			node = seed_array[j];
			if (node.type == STOP) {
				break;
			}
			if (node.data.key == i) {
				expected = true;
				break;
			}
			j++;
		}
		// Check whether target value is reported by jitds:
		observed = jitd->get(i, r);
		if (expected != observed) {
			printf("jitds test failure:  expected = %d; observed = %d on item %d\n", expected, observed, i);
			_exit(1);
		}
	}

	printf("Passed basic integrity check\n");
	return 0;

}


int jitd_harness() {

	timeval start;
	timeval end;
	int ms;
	bool results;
	double time_base;
	double time_this;
	double time_prev;
	double time_next;
	double time_delta;

	// Initialize bare jitds structure:
	jitd = std::shared_ptr<JITD>(new JITD(new ArrayNode(data)));

	// Init data template to push:
	r.key = -9999999;  // dummy init key; will be popped later
	r.value = (Value)0xDEADBEEF;
	data.push_back(r);

	// Pre-populate structure with existing keys:
	seed_jitds();
	// Basic structural integrity check:
	test_jitds();

	printf("Starting operations\n");
	gettimeofday(&start, NULL);

	time_prev = 0;
	time_base = gettime_ms();

	i = 0;
	while (true) {

/*
		printf("Iteration:  %d\n", i);
		if (i == 20) {
			printf("Reached end\n");
			break;
		}
*/
//		printf("iteration %d\n", i);

		// Get next operation:
		node = operation_array[i];

		if (node.type == STOP) {
			break;
		}
		else if (node.type == INSERT) {
			r.key = node.data.key;
			data.pop_back();
			data.push_back(r);
			jitd->insert(data);
		}
		else if (node.type == SELECT) {
			results = jitd->get(node.data.key, r);
		}
		else if (node.type == TIME) {
			time_this = node.data.time;
			time_delta = time_this - time_prev;
			ms = (node.data.time - time_prev) * 1000;  // Adjust delay to taste
//			printf("Time:  base:  %f, delta:  %f, ms:  %d\n", time_this, time_delta, ms);
//			std::this_thread::sleep_for(std::chrono::milliseconds(ms));
			time_prev = time_this;
		} else {
			printf("Error:  Unexpected operation\n");
			_exit(1);
		}

/*
		// Advance to time frame
		i++;
		node = operation_array[i];
		// Sanity check
		if (node.type != TIME) {
			printf("Error:  Expected time field\n");
			_exit(1);
		}
*/

/*
		while (true) {
			results = jitd->do_organize();
			if (results == false) {
				break;
			}
			if (gettime_ms() >= time_next) {
				break;
			}
		}
		if (gettime_ms() < time_next) {
			ms = time_next - gettime_ms();
			std::this_thread::sleep_for(std::chrono::milliseconds(ms));
		}
*/

		i++;
	}

	gettimeofday(&end, NULL);

	std::cout << "Init JITD: " << total_time(start, end) << " us" << std::endl;
	printf("End\n");
	return 0;

}

