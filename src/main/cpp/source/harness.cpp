
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
#include "conf.hpp"

#define TIME_EACH_OP

#ifdef TIME_EACH_OP

#define TIME_START ( time_start = gettime_us() )
#define TIME_END ( time_delta = gettime_us() - time_start )

#else

#define TIME_START
#define TIME_END

#endif

#ifdef STORAGE_SQLITE

#include "sqlite3.h"

#define STMT_BUFLEN 2048

#endif

#ifdef STORAGE_JITD

#define STORAGE_HANDLE struct storage_jitd_struct*

#endif

#ifdef STORAGE_MAP

#include <map>

#define MAP_TYPE long, int
#define STORAGE_HANDLE struct storage_map_struct*

#endif

#ifdef STORAGE_UOM

#include <unordered_map>

#define UOM_TYPE long, int
#define STORAGE_HANDLE struct storage_uom_struct*

#endif

#include "harness.hpp"

using namespace harness;


long gettime_us() {

	timeval now;

	gettimeofday(&now, NULL);

	return now.tv_sec * 1000000 + now.tv_usec;

}


double total_time(timeval &start, timeval &end) {

	return (end.tv_sec - start.tv_sec) * 1000000.0 + (end.tv_usec - start.tv_usec);

}



#define errtrap(error) (__errtrap(result, error, __LINE__))
void __errtrap(int result, const char* error, int line) {

	if (result == -1) {
		printf("Error in %s() on line %d:  %s\n", error, line, strerror(errno));
		_exit(errno);
	}
	return;

}


STORAGE_HANDLE create_storage() {

	struct operation_node node;
	int i = 0;

int k = 0;
int kmax = 3;

	#ifdef STORAGE_SQLITE

	sqlite3* ppDb;
	char stmt_buffer[STMT_BUFLEN];
	int result;
	char filename[] = ":memory:"; // "testfile.db";  // TODO:  parameterize this
	sqlite3_stmt* statement;
	char create_table[] = "CREATE TABLE kvstore (key INTEGER PRIMARY KEY, FIELD0 varchar(100), FIELD1 varchar(100), FIELD2 varchar(100), FIELD3 varchar(100), FIELD4 varchar(100), FIELD5 varchar(100), FIELD6 varchar(100), FIELD7 varchar(100), FIELD8 varchar(100), FIELD9 varchar(100);";

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

	return (void*)ppDb;

	#endif

	#ifdef STORAGE_JITD

	STORAGE_HANDLE storage = new storage_jitd_struct();
	bool not_done = true;

	while (true) {

if (k == kmax) {
	break;
}
k++;

		node = initialize_array[i];
		if (node.type == STOP) {
			break;
		}
		if (node.type != harness::INSERT) {
			printf("Error:  expected Insert\n");
			_exit(1);
		}
		storage->r.key = node.key;
		storage->r.value = new int(node.value);
		storage->element.push_back(storage->r);
		i++;
	}
	storage->jitd = std::shared_ptr<JITD>(new JITD(std::shared_ptr<std::shared_ptr<JITDNode>>(new std::shared_ptr<JITDNode>(new ArrayNode(storage->element)))));

printf("Val k:  %d\n", k);

	// Organize initial jitd structure until it reaches a stable state:
	i = 0;
	while (not_done == true) {
		not_done = storage->jitd->do_organize();
		i++;
	}
	printf("Initial Organization Steps:  %d\n", i);

	return storage;

	#endif

	#ifdef STORAGE_MAP

	STORAGE_HANDLE storage = new storage_map_struct();

	while (true) {

if (k == kmax) {
	break;
}
k++;

		node = initialize_array[i];
		if (node.type == STOP) {
			break;
		}
		if (node.type != harness::INSERT) {
			printf("Error:  expected Insert\n");
			_exit(1);
		}
		storage->data_pair.first = node.key;
		storage->data_pair.second = node.value;
		storage->map.insert(storage->data_pair);
		i++;
	}

printf("Val k:  %d\n", k);

	return storage;

	#endif

	#ifdef STORAGE_UOM

	STORAGE_HANDLE storage = new storage_uom_struct();

	while (true) {

if (k == kmax) {
	break;
}
k++;

		node = initialize_array[i];
		if (node.type == STOP) {
			break;
		}
		if (node.type != harness::INSERT) {
			printf("Error:  expected Insert\n");
			_exit(1);
		}
		storage->data_pair.first = node.key;
		storage->data_pair.second = node.value;
		storage->uom.insert(storage->data_pair);
		i++;
	}

printf("Val k:  %d\n", k);

	return storage;

	#endif

}


int get_data(STORAGE_HANDLE storage, int nkeys, unsigned long* key_array) {

	unsigned long key;
	unsigned long value = 0;

	#ifdef STORAGE_SQLITE

	sqlite3* ppDb = (sqlite3*)storage;
	char stmt_buffer[STMT_BUFLEN];
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

	// TODO:  switch to running sum
	return rowcount;

	#endif

	#ifdef STORAGE_JITD

	for (int i = 0; i < nkeys; i++) {
		key = key_array[i];
		if (storage->jitd->get(key, storage->r) == true) {
			value += *(unsigned long*)storage->r.value;
		}
	}

	#endif

	#ifdef STORAGE_MAP

	storage->end_iter = storage->map.end();
	for (int i = 0; i < nkeys; i++) {
		key = key_array[i];
		storage->key_iter = storage->map.find(key);
		if (storage->key_iter != storage->end_iter) {
			value += storage->key_iter->second;
		}
	}

	#endif

	#ifdef STORAGE_UOM

	storage->end_iter = storage->uom.end();
	for (int i = 0; i < nkeys; i++) {
		key = key_array[i];
		storage->key_iter = storage->uom.find(key);
		if (storage->key_iter != storage->end_iter) {
			value += storage->key_iter->second;
		}
	}

	#endif

	return value;

}


// NOTE:  For now, we leave undefined the issue of inserting duplicate keys
int put_data(STORAGE_HANDLE storage, unsigned long key, unsigned long value) {

	#ifdef STORAGE_SQLITE

	sqlite3* ppDb = (sqlite3*)storage;
	char stmt_buffer[STMT_BUFLEN];
	int result;
	sqlite3_stmt* statement;

	std::string* & fa = field_array;

	snprintf(stmt_buffer, STMT_BUFLEN, "INSERT INTO kvstore (key, FIELD0, FIELD1, FIELD2, FIELD3, FIELD4, FIELD5, FIELD6, FIELD7, FIELD8, FIELD9) VALUES (%ld);", key, );
	result = sqlite3_prepare(ppDb, stmt_buffer, STMT_BUFLEN, &statement, NULL);
	if (result != SQLITE_OK) {
		printf("Error:  prepare insert\n");
		_exit(1);
	}
	result = sqlite3_step(statement);
	if (result != SQLITE_DONE) {
		printf("Error:  step insert\n");
		_exit(1);
	}
	result = sqlite3_finalize(statement);

	#endif

	#ifdef STORAGE_JITD

	storage->r.key = key;
	storage->jitd->insert_singleton(storage->r);

	#endif

	#ifdef STORAGE_MAP

	storage->data_pair.first = key;
	storage->data_pair.second = value;

	storage->map.insert(storage->data_pair);

	#endif

	#ifdef STORAGE_UOM

	storage->data_pair.first = key;
	storage->data_pair.second = value;

	storage->uom.insert(storage->data_pair);

	#endif

	return 0;

}


int remove_data(STORAGE_HANDLE storage, int nkeys, unsigned long* key_array) {

	unsigned long key;

	#ifdef STORAGE_SQLITE

	sqlite3* ppDb = (sqlite3*)storage;
	char stmt_buffer[STMT_BUFLEN];
	int result;
	sqlite3_stmt* statement;

	snprintf(stmt_buffer, STMT_BUFLEN, "DELETE FROM kvstore WHERE key = %ld;", key);
	result = sqlite3_prepare(ppDb, stmt_buffer, STMT_BUFLEN, &statement, NULL);
	if (result != SQLITE_OK) {
		printf("Error:  prepare delete\n");
		_exit(1);
	}
	result = sqlite3_step(statement);
	if (result != SQLITE_DONE) {
		printf("Error:  step delete\n");
		_exit(1);
	}
	result = sqlite3_finalize(statement);

	#endif

	#ifdef STORAGE_JITD

	for (int i = 0; i < nkeys; i++) {
		key = key_array[i];
		storage->jitd->remove_singleton(key);
	}

	#endif

	#ifdef STORAGE_MAP

	for (int i = 0; i < nkeys; i++) {
		key = key_array[i];
		storage->map.erase(key);
	}

	#endif

	#ifdef STORAGE_UOM

	for (int i = 0; i < nkeys; i++) {
		key = key_array[i];
		storage->uom.erase(key);
	}

	#endif

	return 0;

}


#ifdef STORAGE_JITD
int remove_data(STORAGE_HANDLE storage, std::vector<long> data) {

	storage->jitd->remove_elements(data);

	return 0;

}
#endif


int update_data(STORAGE_HANDLE storage, unsigned long key, unsigned long value) {

	#ifdef STORAGE_JITD

	bool result;

	result = storage->jitd->get(key, storage->r);
	if (result == true) {
		storage->jitd->remove_singleton(key);
		storage->r.key = key;
		storage->jitd->insert_singleton(storage->r);
	}

	#endif

	#ifdef STORAGE_MAP

	storage->key_iter = storage->map.find(key);
	storage->end_iter = storage->map.end();
	if (storage->key_iter != storage->end_iter) {
		storage->key_iter->second = value;
	}

	#endif

	#ifdef STORAGE_UOM

	storage->key_iter = storage->uom.find(key);
	storage->end_iter = storage->uom.end();
	if (storage->key_iter != storage->end_iter) {
		storage->key_iter->second = value;
	}

	#endif

	return 0;

}


int upsert_data(STORAGE_HANDLE storage, unsigned long key, unsigned long value) {

	#ifdef STORAGE_JITD

	bool result;

	result = storage->jitd->get(key, storage->r);
	if (result == true) {
		storage->jitd->remove_singleton(key);
		storage->r.key = key;
		storage->jitd->insert_singleton(storage->r);
	} else {
		storage->r.key = key;
		storage->jitd->insert_singleton(storage->r);
	}

	#endif

	#ifdef STORAGE_MAP

	storage->map[key] = value;

	#endif

	#ifdef STORAGE_UOM

	storage->uom[key] = value;

	#endif

	return 0;

}


int test_struct(STORAGE_HANDLE storage) {

	struct operation_node node;
	int i;
	int j;
	Key key;
	Key minkey = 999999;
	Key maxkey = 0;
	bool expected;
	bool observed;

	printf("Verifying inserted data\n");

	// Get search range:
	i = 0;
	while (true) {
		node = initialize_array[i];
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
	// Verify that presence / absence of keys from initialize array matches structure population:
	for (i = minkey; i < maxkey; i++) {
		// Check whether target value _was_ inserted:
		expected = false;
		j = 0;
		while (true) {
			node = initialize_array[j];
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
		observed = get_data(storage, 1, &node.key);
		if (expected != observed) {
			printf("structure test failure:  expected = %d; observed = %d on item %d\n", expected, observed, i);
			_exit(1);
		}
	}

	printf("Passed basic integrity check\n");
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
		snprintf(output_buffer, BUFFER_SIZE, "%ld\t%ld\t%d\t%ld\t%d\t%d\t%d\n", output_array[i].time_start, output_array[i].time_delta, output_array[i].type, output_array[i].key, output_array[i].rows, output_array[i].nkeys, output_array[i].depth);
		result = write(output_fd, output_buffer, strnlen(output_buffer, BUFFER_SIZE));
		errtrap("write");
	}

	close(output_fd);
	printf("Finished\n");
	return 0;

}


#ifdef STORAGE_JITD
void run_worker_thread(STORAGE_HANDLE storage) {

	int steps_taken;
	uintptr_t tid;

	tid = pthread_self();
	printf("Worker thread starting:  TID = %p\n", (void*)tid);
	steps_taken = storage->jitd->organize_wait();
	printf("Worker thread exiting.  Steps taken:  %d\n", steps_taken);

	return;

}
#endif


int main() {

	STORAGE_HANDLE storage;
	timeval start;
	timeval end;
	int ms;
	enum operation optype;
	int rows = 0;
	int nkeys;
	unsigned long key;
	unsigned long* key_array;
	unsigned long value;
	int depth;
	int i;
	int j;
	bool result;
	long time_base;
	long time_next;
	long time_delta;
	long time_now;
	long time_start;

	#ifdef STORAGE_SQLITE
	printf("Using SQLite storage\n");
	#endif
	#ifdef STORAGE_JITD
	printf("Using JITD storage\n");
	#endif
	#ifdef STORAGE_MAP
	printf("Using Map storage\n");
	#endif
	#ifdef STORAGE_UOM
	printf("Using UOMap storage\n");
	#endif
	// Initialize and populate structure:
	printf("Creating and initializing data structure\n");
	storage = create_storage();
	printf("Finished\n");
	// Basic structural integrity check:
//	test_struct(storage);
	// Block :30 to stabilize system:
	printf("Waiting -- stabilize system\n");
//	std::this_thread::sleep_for(std::chrono::milliseconds(30 * 1000));

	#ifdef STORAGE_JITD
	// Kick off background worker thread:
	std::thread worker_thread(run_worker_thread, storage);
	#endif

	printf("Starting operations\n");
	gettimeofday(&start, NULL);

	time_base = gettime_us();
	printf("Start base time:  %ld\n", time_base);

	i = 0;
	j = 0;
	while (true) {

		if ((i % 1000) == 0) {
			printf("Iteration:  %d\n", i);
			depth = 0;
			#ifdef STORAGE_JITD
//			storage->jitd->get_depth(1, depth);
			#endif
		} else {
			depth = -1;
		}

/*
		if (i == 300) {
			break;
		}
*/

		// Get next operation:
		optype = benchmark_array[i].type;
		key = benchmark_array[i].key;
		value = benchmark_array[i].value;
		nkeys = benchmark_array[i].nkeys;

		// Benchmark next operation:
		if (optype == STOP) {
			break;
		} else if (optype == harness::INSERT) {
			TIME_START;
			put_data(storage, key, value);
			TIME_END;
		} else if (optype == SELECT) {
			if (nkeys == 1) {
				key_array = &benchmark_array[i].key;
			} else if (nkeys > 1) {
				key_array = benchmark_array[i].key_array;
			} else if (nkeys == -1) {
				// TODO:  Return all rows (iterator)
				//printf("Return all\n");
			}
			TIME_START;
			result += get_data(storage, nkeys, key_array);
			TIME_END;
		} else if (optype == DELETE) {
			if (nkeys == 1) {
				key_array = &benchmark_array[i].key;
				TIME_START;
				result += remove_data(storage, 1, key_array);
				TIME_END;
			} else if (nkeys > 1) {
				key_array = benchmark_array[i].key_array;
				#ifdef STORAGE_JITD
				std::vector<long> data;
				for (int k = 0; k < nkeys; k++) {
					key = key_array[k];
					data.push_back(key);
				}
				#endif
				TIME_START;
				#ifdef STORAGE_JITD
				result += remove_data(storage, data);
				#else
				result += remove_data(storage, nkeys, key_array);
				#endif
				TIME_END;
			}
		} else if (optype == UPDATE) {
			TIME_START;
			result += update_data(storage, key, value);
			TIME_END;
		} else if (optype == UPSERT) {
			TIME_START;
			result += upsert_data(storage, key, value);
			TIME_END;
		} else {
			printf("Error:  Unexpected operation\n");
			_exit(1);
		}

		// Save out operation time:
		if (i >= output_size) {
			printf("Error:  output overflow\n");
			_exit(1);
		}

		output_array[i].time_start = time_start;
		output_array[i].time_delta = time_delta;
		output_array[i].type = optype;
		output_array[i].key = key;
		output_array[i].rows = rows;
		output_array[i].nkeys = nkeys;
		output_array[i].depth = depth;
		// Advance to next frame
		i++;
		optype = benchmark_array[i].type;
		if (optype == STOP) {
			break;
		}

		#ifdef TIME_EACH_OP

		// Get start time of the next operation:
		time_next = time_base + (benchmark_array[i].time * 1000000);
		time_now = gettime_us();

		// If we have not yet reached the next start time, block until then:
//		if (time_now < time_next) {
//			ms = (time_next - time_now) / 1000;
//			std::this_thread::sleep_for(std::chrono::milliseconds(ms));
//		}

		// Fixed sleep for now:
		ms = 1;
		std::this_thread::sleep_for(std::chrono::milliseconds(ms));

		#endif

	}

	gettimeofday(&end, NULL);
	std::cout << "Total runtime: " << total_time(start, end) << " us" << std::endl;
	std::cout << "In seconds:  " << total_time(start, end) / 1000000.0 << std::endl;

	// Failsafe:  if input < output:
	if (i < output_size) {
		output_size = i;
	}
	save_output();
	#ifdef STORAGE_SQLITE
	sqlite3_close((sqlite3*)storage);
	#endif

	#ifdef STORAGE_JITD
	// Wakeup worker thread and get thread metadata:
//printf("Blocking for worker to finish\n");
//std::this_thread::sleep_for(std::chrono::milliseconds(1000 * 10));

	printf("Waking worker thread\n");

	mutatorCqElement mce;

	mce.flag = EXIT;
	mce.element = std::make_pair(nullptr,nullptr);
	pthread_mutex_lock(&storage->jitd->lock);
	storage->jitd->work_queue.push(mce);
	pthread_mutex_unlock(&storage->jitd->lock);

	printf("Blocking on worker thread exit\n");
	worker_thread.join();
/*
	printf("Starting cleanup.  Main thread TID:  %d\n", getpid());
	long start_time = gettime_us();
	long diff_time;
	bool not_done;
	i = 0;
	while (true) {
		not_done = storage->jitd->do_organize();
		if (not_done == false) {
			break;
		}
		if ((i % 1000) == 0) {
			printf("Cleanup iteration:  %d\n", i);
		}
		i++;
	}
	diff_time = gettime_us() - start_time;
	printf("Finished cleanup.  Steps:  %d  Time (s):  %f\n", i, (double)diff_time / 1000000.0);
*/
//	storage->jitd->print_debug();

	printf("Worker thread exited\n");
	#endif

	printf("Result:  %d\n", result);
	printf("End base time:  %ld\n", time_base);
	printf("End\n");
	return 0;

}


