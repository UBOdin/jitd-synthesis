
#include <memory>
#include <thread>

#include <errno.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>
#include <sys/types.h>
#include <unistd.h>

#include "jitd_test.hpp"
#include "test.hpp"
#include "harness.hpp"


static std::shared_ptr<JITD> jitd;
static std::vector<Record> data;
static Record r;
static struct operation_node node;
static double* output_array;
static int output_size;

// N.b. struct Record.key -- long int; Record.value -- void*


double gettime_ms() {

	timeval now;

	gettimeofday(&now, NULL);

	return (now.tv_sec * 1000000.0 + now.tv_usec) / 1000.0;

}


#define errtrap(error) (__errtrap(result, error, __LINE__))
void __errtrap(int result, const char* error, int line) {

	if (result == -1) {
		printf("Error in %s() on line %d:  %s\n", error, line, strerror(errno));
		_exit(errno);
	}
	return;

}


int init_struct() {

	jitd = std::shared_ptr<JITD>(new JITD(new ArrayNode(data)));

	return 0;

}


bool get_data(double key) {

	bool result;

	result = jitd->get(key, r);

	return result;

}


int put_data(double key) {

	r.key = key;
	data.pop_back();
	data.push_back(r);
	jitd->insert(data);

	return 0;

}


int zap_data() {

	return 0;

}



int seed_struct() {

	int i;

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
		put_data(node.data.key);
		i++;
	}
	printf("Finished\n");
	return 0;

}


int test_struct() {

	Key key;
	Key minkey = 999999;
	Key maxkey = 0;
	bool expected;
	bool observed;
	int i;
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
	// Verify that presence / absence of keys from seed array matches structure population:
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
		// Check whether target value is reported by the structure:
		observed = get_data(i);
		if (expected != observed) {
			printf("structure test failure:  expected = %d; observed = %d on item %d\n", expected, observed, i);
			_exit(1);
		}
	}

	printf("Passed basic integrity check\n");
	return 0;

}


int init_output() {

	int i;
	int j;

	printf("Setting up output structure\n");
	i = 0;
	j = 0;
	while (true) {
		node = operation_array[i];
		if (node.type == STOP) {
			break;
		}
		i++;
		if (node.type == TIME) {
			continue;
		}
		j++;
	}
	output_array = (double*)malloc(sizeof(double) * j);
	output_size = j;

	printf("Allocated for %d operation results\n", j);
	return 0;

}


int save_output() {

	#define BUFFER_SIZE 64

	double time_delta;
	int result;
	int output_fd;
	char output_filename[] = "output_data.txt";
	char output_buffer[BUFFER_SIZE];

	printf("Saving results\n");
	result = open(output_filename, O_CREAT | O_RDWR | O_TRUNC, 0666);
	errtrap("open");
	output_fd = result;

	for (int i = 0; i < output_size; i++) {
		time_delta = output_array[i];
		snprintf(output_buffer, BUFFER_SIZE, "%f\n", time_delta);
		result = write(output_fd, output_buffer, strnlen(output_buffer, BUFFER_SIZE));
		errtrap("write");
	}

	close(output_fd);
	printf("Finished\n");
	return 0;

}


int jitd_harness() {

	timeval start;
	timeval end;
	int ms;
	int i;
	int j;
	bool result;
	double time_base;
	double time_this;
	double time_prev;
	double time_next;
	double time_delta;
	double time_now;
	double time_start;
	double time_end;
	int break_overrun = 0;
	int break_no_work = 0;

	// Initialize bare jitds structure:
	init_struct();

	// Init data template to push:
	r.key = -9999999;  // dummy init key; will be popped later
	r.value = (Value)0xDEADBEEF;
	data.push_back(r);

	// Pre-populate structure with existing keys:
	seed_struct();
	// Basic structural integrity check:
	test_struct();
	// Allocate output structure:
	init_output();

	printf("Starting operations\n");
	gettimeofday(&start, NULL);

	time_prev = 0;
	time_base = gettime_ms();
	printf("Start base time:  %f\n", time_base);

	i = 0;
	j = 0;
	while (true) {

/*
		printf("Iteration:  %d\n", i);
		if (i == 20) {
			printf("Reached end\n");
			break;
		}
*/
//		printf("iteration %d\n", i);

		time_start = gettime_ms();

		// Get next operation:
		node = operation_array[i];

		if (node.type == STOP) {
			break;
		}
		else if (node.type == INSERT) {
			put_data(node.data.key);
		}
		else if (node.type == SELECT) {
			result = get_data(node.data.key);
/*
		}
		else if (node.type == TIME) {
			time_this = node.data.time;
			time_delta = time_this - time_prev;
			ms = (node.data.time - time_prev) * 1000;  // Adjust delay to taste
//			printf("Time:  base:  %f, delta:  %f, ms:  %d\n", time_this, time_delta, ms);
			std::this_thread::sleep_for(std::chrono::milliseconds(ms));
			time_prev = time_this;
*/
		} else {
			printf("Error:  Unexpected operation\n");
			_exit(1);
		}

		if (j >= output_size) {
			printf("Error:  output overflow\n");
			_exit(1);
		}
		// Save out operation time:
		time_delta = gettime_ms() - time_start;
		output_array[j] = time_delta;
		j++;

		// Advance to time frame
		i++;
		node = operation_array[i];
		if (node.type == STOP) {
			break;
		} else if (node.type != TIME) {
			printf("Error:  Expected time field\n");
			_exit(1);
		}

		// Get start time of the next operation:
		time_next = time_base + (node.data.time * 1000.0);
		time_now = gettime_ms();
		// Until we reach the next start time, do any jitds housecleaning remaining:
		while (true) {
			// Break if we have reached the next start time:
			if (time_now >= time_next) {
				break_overrun++;
				break;
			}
			// Else, do more housecleaning:
			result = jitd->do_organize();
			time_now = gettime_ms();
			// Break if no more cleanup:
			if (result == false) {
				break_no_work++;
				break;
			}
		}
		// If we have not yet reached the next start time, block until then:
		// (i.e. no more housecleaning left)
		if (time_now < time_next) {
/*
			ms = 0; //time_next - time_now;  // Adjust to taste  TODO:  parameterize this
			std::this_thread::sleep_for(std::chrono::milliseconds(ms));
*/
			time_base -= (time_next - time_now);
		}

		i++;
	}

	printf("End base time:  %f\n", time_base);
	printf("Overrun:  %d -- Ran out of work:  %d\n", break_overrun, break_no_work);

	save_output();

	gettimeofday(&end, NULL);

	std::cout << "Total runtime: " << total_time(start, end) << " us" << std::endl;
	printf("End\n");
	return 0;

}

