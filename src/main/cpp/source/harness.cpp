
#include <errno.h>
#include <linux/perf_event.h>
#include <linux/hw_breakpoint.h>
#include <math.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ioctl.h>
#include <sys/time.h>
#include <sys/types.h>
#include <thread>
#include <unistd.h>

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
#define STORAGE_STRUCT storage->map

#endif

#ifdef STORAGE_UOM

#include <unordered_map>

#define UOM_TYPE long, int
#define STORAGE_HANDLE struct storage_uom_struct*
#define STORAGE_STRUCT storage->uom

#endif

#include "harness.hpp"

using namespace harness;

// jitd debug globals:
int __array_size;
int __kmax;


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
		// Debug:  Populate structure with only a subset of keys:
		if (k == __kmax) {
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
	printf("Keys prepopulated:  %d\n", k);

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

	#endif

	#ifdef STORAGE_UOM

	STORAGE_HANDLE storage = new storage_uom_struct();

	#endif

	#if defined STORAGE_MAP || defined STORAGE_UOM

	while (true) {
		// Debug:  Populate structure with only a subset of keys:
		if (k == __kmax) {
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
		STORAGE_STRUCT.insert(storage->data_pair);
		i++;
	}
	printf("Keys prepopulated:  %d\n", k);

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

	#if defined STORAGE_MAP || defined STORAGE_UOM

	storage->end_iter = STORAGE_STRUCT.end();
	for (int i = 0; i < nkeys; i++) {
		key = key_array[i];
		storage->key_iter = STORAGE_STRUCT.find(key);
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

	#if defined STORAGE_MAP || defined STORAGE_UOM

	storage->data_pair.first = key;
	storage->data_pair.second = value;

	STORAGE_STRUCT.insert(storage->data_pair);

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

	#if defined STORAGE_MAP || defined STORAGE_UOM

	for (int i = 0; i < nkeys; i++) {
		key = key_array[i];
		STORAGE_STRUCT.erase(key);
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

	#if defined STORAGE_MAP || defined STORAGE_UOM

	storage->key_iter = STORAGE_STRUCT.find(key);
	storage->end_iter = STORAGE_STRUCT.end();
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

	#if defined STORAGE_MAP || defined STORAGE_UOM

	STORAGE_STRUCT[key] = value;

	#endif

	return 0;

}


int test_struct(STORAGE_HANDLE storage) {

	#define ARRSIZE 100
	int* key_array = new(int[ARRSIZE]);
	int* val_array = new(int[ARRSIZE]);
	int* ref_array = new(int[ARRSIZE]);
	int key;
	int val;

	std::srand(time(NULL));  // Seed random number generator
	// Initialize refcount array:
	for (int i = 0; i < ARRSIZE; i++) {
		ref_array[i] = 0;
	}

	// Populate arrays with pre-set keys and vals:
	for (int i = 0; i < ARRSIZE; i++) {
	    regenerate:
		key = std::rand();
		// Ensure non-duplication of keys (treat as a set):
		for (int j = 0; j < i; j++) {
			if (key == key_array[j]) {
				goto regenerate;  // Yes Virginia, gotos are great.  Try this in Java or Python.
			}
		}
		val = std::rand();
		// Save k-v pair for later reference:
		key_array[i] = key;
		val_array[i] = val;
		// Plop k-v into storage structure:
		put_data(storage, key, val);
	}

	// Use an iterator to return the current contents of the structure.  Compare versus the reference arrays.
	// We could also test this with set equivalence:  check that every element in the structure is also in
	// the reference array(s) and vice-verce.  That would also use the get() functionality.  Pros and cons.

	#if defined STORAGE_MAP || defined STORAGE_UOM

	if (STORAGE_STRUCT.size() != ARRSIZE) {
		printf("Unexpected storage structure size.  Was structure pre-seeded by mistake?\n");
		_exit(1);
	}

	storage->key_iter = STORAGE_STRUCT.begin();
	storage->end_iter = STORAGE_STRUCT.end();

	while (storage->key_iter != storage->end_iter) {

		key = storage->key_iter->first;
		// Search for the expected key in the key reference array:
		int i;
		for (i = 0; i < ARRSIZE; i++) {
			if (key == key_array[i]) {
				break;
			}
		}
		if (i == ARRSIZE) {
			printf("Failed to find expected key\n");
			_exit(1);
		}
		// Verify the value matches also:
		val = storage->key_iter->second;
		if (val != val_array[i]) {
			printf("Value mismatch\n");
			_exit(1);
		}
		// Record the reference count to this k-v pair found:
		ref_array[i]++;
		storage->key_iter++;
	}

	// Now check:  there should be 1, and only 1, reference for each key:
	for (int i = 0; i < ARRSIZE; i++) {
		if (ref_array[i] != 1) {
			printf("Unexpected reference count\n");
			_exit(1);
		}
	}

	printf("Passed basic integrity test\n");
	#endif

	// TODO:  Need iterator for jitd storage itegrity check

	delete [] key_array;
	delete [] val_array;
	delete [] ref_array;

	return 0;

}


int save_output() {

	#define BUFFER_SIZE 256

	int result;
	int output_fd;
	char output_filename[] = "output_data.txt";
	char output_buffer[BUFFER_SIZE];

	printf("Saving results\n");
	result = open(output_filename, O_CREAT | O_RDWR | O_TRUNC, 0666);
	errtrap("open");
	output_fd = result;

	for (int i = 0; i < output_size; i++) {
//		snprintf(output_buffer, BUFFER_SIZE, "%ld\t%ld\t%d\t%ld\t%d\t%d\t%d\n", output_array[i].time_start, output_array[i].time_delta, output_array[i].type, output_array[i].key, output_array[i].rows, output_array[i].nkeys, output_array[i].depth);

		snprintf(output_buffer, BUFFER_SIZE, "%ld\t%ld\t%d\t%ld\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\n", output_array[i].time_start, output_array[i].time_delta, output_array[i].type, output_array[i].key, output_array[i].rows, output_array[i].nkeys, output_array[i].depth, output_array[i].count_array[0], output_array[i].count_array[1], output_array[i].count_array[2], output_array[i].count_array[3], output_array[i].count_array[4], output_array[i].count_array[5], output_array[i].count_array[6], output_array[i].count_array[7]);

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


int main(int argc, char** argv) {

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
	int result;
	long time_base;
	long time_next;
	long time_delta;
	long time_now;
	long time_start;
	double sum = 0;  // dummy variable -- to prevent structure val's from being optimized out
	// Linux perf debug variables:
	#define PERFBUFF_SIZE 64
	int perf_ref_fd;
	int perf_miss_fd;
	struct perf_event_attr pea_struct;
	char perf_buff[PERFBUFF_SIZE];

	// Extract debug parameters:  max keycount with which to populate structure and jitd crack threshhold:
	if (argc != 3) {
		printf("Unexpected parameter count\n");
		_exit(1);
	}
	__kmax = atoi(argv[1]);
	__array_size = atoi(argv[2]);
	printf("crack threshhold:  %d\n", __array_size);

	// Initialize HW performance monitoring structure:
	memset(&pea_struct, 0, sizeof(pea_struct));
	pea_struct.type = PERF_TYPE_HARDWARE;
	pea_struct.size = sizeof(struct perf_event_attr);
	pea_struct.config = PERF_COUNT_HW_CACHE_REFERENCES;  // Track cache references with this monitor
	pea_struct.sample_period = 0;  // Not using sample periods; will do manual collection
	pea_struct.sample_type = 0;  // ditto above
	pea_struct.read_format = PERF_FORMAT_GROUP;  // | PERF_FORMAT_TOTAL_TIME_ENABLED | PERF_FORMAT_TOTAL_TIME_RUNNING;
	// Some bitfields:
	pea_struct.disabled = 1;  // Disabled for now -- will start collection later
	pea_struct.inherit = 1;  // Yes, track both client and worker (n.b. documentation says this = 1 is incompatible with PERF_FORMAT_GROUP -- it is _not_; bug?)
	pea_struct.pinned = 0;  // N.b. pinned = 1 _is_ incompatible with PERF_FORMAT_GROUP -- either a bug in kernel or documentation?
	pea_struct.exclusive = 0;
	pea_struct.exclude_user = 0;  // Track userspace
	pea_struct.exclude_kernel = 1;  // But not kernel
	pea_struct.exclude_hv = 1;  // And not hv (if any)

	// Group leader for first of 2 events (cache references):
	result = syscall(__NR_perf_event_open, &pea_struct, 0, -1, -1, 0);
	errtrap("perf_event_open");
	perf_ref_fd = result;
	// Configure second event to monitor cache misses:
	pea_struct.config = PERF_COUNT_HW_CACHE_MISSES;
	pea_struct.disabled = 0;  // N.b. -- enabled, but dependent on status of leader event (initially disabled)
	// Include in monitoring group:
	result = syscall(__NR_perf_event_open, &pea_struct, 0, -1, perf_ref_fd, 0);
	errtrap("perf_event_open");
	perf_miss_fd = result;

	#ifdef STORAGE_SQLITE
	printf("Using SQLite storage\n");
	#endif
	#ifdef STORAGE_JITD
	printf("Using JITD storage\n");
	#endif
	#ifdef STORAGE_MAP
	printf("Using (Ordered) Map storage\n");
	#endif
	#ifdef STORAGE_UOM
	printf("Using Unordered Map storage\n");
	#endif
	// Initialize and populate structure:
	printf("Creating and initializing data structure\n");
	storage = create_storage();
	memset(output_array, 0, sizeof(struct output_node) * output_size);
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

	// Enable HW event monitoring:
	ioctl(perf_ref_fd, PERF_EVENT_IOC_RESET, 0);
	ioctl(perf_ref_fd, PERF_EVENT_IOC_ENABLE, 0);

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

		// Fetch performance data:
		result = read(perf_ref_fd, perf_buff, PERFBUFF_SIZE);
		errtrap("read");
		output_array[i].cache_refs = ((unsigned long*)perf_buff)[1];
		output_array[i].cache_refs = ((unsigned long*)perf_buff)[2];

		#ifdef STORAGE_JITD
		output_array[i].depth = depth;
		#ifdef TRANSFORM_COUNT
		output_array[i].count_array[0] = storage->jitd->PushDownDontDeleteSingletonConcat_count;
		output_array[i].count_array[1] = storage->jitd->PushDownDontDeleteSingletonBtreeRight_count;
		output_array[i].count_array[2] = storage->jitd->PushDownDontDeleteSingletonBtreeLeft_count;
		output_array[i].count_array[3] = storage->jitd->PushDownDontDeleteElemConcat_count;
		output_array[i].count_array[4] = storage->jitd->PushDownDontDeleteElemBtree_count;
		output_array[i].count_array[5] = storage->jitd->PushDownSingletonRight_count;
		output_array[i].count_array[6] = storage->jitd->PushDownSingletonLeft_count;
		output_array[i].count_array[7] = storage->jitd->CrackArray_count;
		#endif
		#endif

		// Advance to next frame
		i++;
		optype = benchmark_array[i].type;
		if (optype == STOP) {
			break;
		}

		#ifdef TIME_EACH_OP


		// Fixed sleep for now:
		ms = 1;
		std::this_thread::sleep_for(std::chrono::milliseconds(ms));

/*
		// Spin for desired time:
		k = 0;
		TIME_START;
		while (true) {
			sum += sin(k);
			k++;
			TIME_END;
			if (time_delta > 1000) {
				break;
			}
		}
*/

		#endif

	}

	// Disable HW event monitoring:
	ioctl(perf_ref_fd, PERF_EVENT_IOC_DISABLE, 0);

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

result = read(perf_ref_fd, perf_buff, PERFBUFF_SIZE);
errtrap("read");

printf("Bytes read:  %d\n", result);
unsigned long perfval;
for (int i = 0; i < 3; i++) {
	perfval = ((unsigned long*)perf_buff)[i];
	printf("Val %d:  %lu\n", i, perfval);
}

	// Clean up HW performance monitoring:
	close(perf_ref_fd);
	close(perf_miss_fd);

	printf("Dummy sum:  %f\n", sum);

	printf("Result:  %d\n", result);
	printf("End base time:  %ld\n", time_base);
	printf("End\n");
	return 0;

}


