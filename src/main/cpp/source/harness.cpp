
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
#include <math.h>

#include "jitd_test.hpp"
#include "test.hpp"
#include "harness.hpp"
#include "conf.hpp"

#ifdef STORAGE_SQLITE
#include "sqlite3.h"
#endif

static std::shared_ptr<JITD> jitd;
static std::vector<Record> data;
static Record r;
static struct operation_node node;
static struct output_node* output_array;
static int output_size;

#ifdef STORAGE_SQLITE
#define STMT_BUFLEN 256
static sqlite3* ppDb;
static char stmt_buffer[STMT_BUFLEN];
#endif

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


	#ifdef STORAGE_SQLITE

	int result;
	char filename[] = ":memory:"; // "testfile.db";  // TODO:  parameterize this
	sqlite3_stmt* statement;
	char create_table[] = "CREATE TABLE kvstore (key INTEGER PRIMARY KEY);";

	// Remove any preexisting datafile:
	if (strcmp(filename, ":memory:") != 0) {
		result = unlink(filename);
		errtrap("unlink");
	}

	// Create new SQLite db:  TODO:  deal with existing file issue
	result = sqlite3_open(filename, &ppDb);
	if (result != SQLITE_OK) {
		printf("Error:  initializing SQLite db\n");
		_exit(1);
	}
	// Create a simple K-V table:
	result = sqlite3_prepare(ppDb, create_table, strlen(create_table), &statement, NULL);
	if (result != SQLITE_OK) {
		printf("Error:  prepare create table\n");
		_exit(1);
	}
	result = sqlite3_step(statement);
	if (result != SQLITE_DONE) {
		printf("Error:  step create table\n");
		_exit(1);
	}
	result = sqlite3_finalize(statement);

	#endif

	#ifdef STORAGE_JITD

	// Init data template to push:
	r.key = -9999999;  // dummy init key; will be popped later
//	r.value = (Value)0xDEADBEEF;
	data.push_back(r);

	jitd = std::shared_ptr<JITD>(new JITD(new ArrayNode(data)));

	#endif

	return 0;

}


bool get_data(long key) {


	#ifdef STORAGE_SQLITE

	int result;
	sqlite3_stmt* statement;
	int rowcount;
	int colcount;
	int type;

	snprintf(stmt_buffer, STMT_BUFLEN, "SELECT key FROM kvstore WHERE key=%ld;", key);
	result = sqlite3_prepare(ppDb, stmt_buffer, STMT_BUFLEN, &statement, NULL);
	if (result != SQLITE_OK) {
		printf("Error:  prepare select\n");
		_exit(1);
	}
	rowcount = 0;
	while (true) {
		result = sqlite3_step(statement);
		if (result == SQLITE_DONE) {
			break;
		}
		if (result != SQLITE_ROW) {
			printf("Error:  step select\n");
			_exit(1);
		}
		rowcount++;
	}
	result = sqlite3_finalize(statement);

	return (bool)rowcount;

	#endif

	#ifdef STORAGE_JITD

	bool result;

	result = jitd->get(key, r);

	return result;

	#endif

}


int put_data(long key) {

	#ifdef STORAGE_SQLITE

	int result;
	sqlite3_stmt* statement;

	snprintf(stmt_buffer, STMT_BUFLEN, "INSERT INTO kvstore (key) VALUES (%ld);", key);
	result = sqlite3_prepare(ppDb, stmt_buffer, STMT_BUFLEN, &statement, NULL);
	if (result != SQLITE_OK) {
		printf("Error:  prepare insert\n");
		_exit(1);
	}
	result = sqlite3_step(statement);
	if (result != SQLITE_DONE) {
//		printf("Error:  step insert\n");
//		_exit(1);
	}
	result = sqlite3_finalize(statement);

	#endif

	#ifdef STORAGE_JITD

	r.key = key;
	data.pop_back();
	data.push_back(r);
	jitd->insert(data);

	#endif

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
		put_data(node.key);
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
		key = node.key;
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
			if (node.key == i) {
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

	printf("Setting up output structure\n");
	i = 0;
	while (true) {
		node = operation_array[i];
		if (node.type == STOP) {
			break;
		}
		i++;
	}
	output_array = (struct output_node*)malloc(sizeof(struct output_node) * i);
	output_size = i;

	printf("Allocated for %d operation results\n", i);
	return 0;

}


int save_output() {

	#define BUFFER_SIZE 64

	int result;
	int output_fd;
	char output_filename[] = "output_data.txt";
	char output_buffer[BUFFER_SIZE];

	printf("Saving results\n");
	result = open(output_filename, O_CREAT | O_RDWR | O_TRUNC, 0666);
	errtrap("open");
	output_fd = result;

	for (int i = 0; i < output_size; i++) {
		snprintf(output_buffer, BUFFER_SIZE, "%f\t%f\t%d\t%ld\t%d\n", output_array[i].time_start, output_array[i].time_delta, output_array[i].type, output_array[i].key, output_array[i].rows);
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

	#ifdef STORAGE_SQLITE
	printf("Using SQLite storage\n");
	#endif
	#ifdef STORAGE_JITD
	printf("Using JITD storage\n");
	#endif

	// Initialize bare jitds structure:
	init_struct();
	// Pre-populate structure with existing keys:
	seed_struct();
	// Basic structural integrity check:
//	test_struct();
	// Allocate output structure:
	init_output();
	// Block :30 to stabilize system:
	printf("Waiting -- stabilize system\n");
//	std::this_thread::sleep_for(std::chrono::milliseconds(30 * 1000));
/*
	double sum;
	for (double k = 0; k < 1000 * 1000 * 1000; k++) {
			sum += sin(k);
	}
	printf("wait sum:  %f\n", sum);
*/

	printf("Starting operations\n");
	gettimeofday(&start, NULL);

	time_prev = 0;
	time_base = gettime_ms();
	printf("Start base time:  %f\n", time_base);

	i = 0;
	j = 0;
	while (true) {

/*
		if ((i % 100) == 0) {
			printf("Iteration:  %d\n", i);
			//break;
		}
*/

		// Get next operation:
		node = operation_array[i];

		// Benchmark next operation:
		time_start = gettime_ms();
		if (node.type == STOP) {
			break;
		}
		else if (node.type == INSERT) {
			put_data(node.key);
		}
		else if (node.type == SELECT) {
			result = get_data(node.key);
			// Basic sanity check
			if (result != (bool)node.rows) {
//				printf("Unexpected get result\n");
//				_exit(1);
			}
			// Re-fetch if original data returned multiple rows:
/*
			if (node.rows > 1) {
				for (int j = 1; j < node.rows; j++) {
					result = get_data(node.key);
				}
			}
*/
		} else {
			printf("Error:  Unexpected operation\n");
			_exit(1);
		}
		time_delta = gettime_ms() - time_start;

		// Save out operation time:
		if (i >= output_size) {
			printf("Error:  output overflow\n");
			_exit(1);
		}

		output_array[i].time_start = time_start;
		output_array[i].time_delta = time_delta;
		output_array[i].type = node.type;
		output_array[i].key = node.key;
		output_array[i].rows = node.rows;
		// Advance to next frame
		i++;
		node = operation_array[i];
		if (node.type == STOP) {
			break;
		}

		// Get start time of the next operation:
		time_next = time_base + (node.time * 1000.0);
		time_now = gettime_ms();

		#ifdef STORAGE_JITD

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

		#endif

		// If we have not yet reached the next start time, block until then:
		// (i.e. no more housecleaning left)
		if (time_now < time_next) {

			ms = 0; //(time_next - time_now) / 10000.0;  // Adjust to taste  TODO:  parameterize this
//			std::this_thread::sleep_for(std::chrono::milliseconds(ms));

//			time_base -= (time_next - time_now);
		}

	}

	gettimeofday(&end, NULL);
	std::cout << "Total runtime: " << total_time(start, end) << " us" << std::endl;

	save_output();
	#ifdef STORAGE_SQLITE
	sqlite3_close(ppDb);
	#endif

	printf("End base time:  %f\n", time_base);
	printf("Overrun:  %d -- Ran out of work:  %d\n", break_overrun, break_no_work);
	printf("End\n");
	return 0;

}

