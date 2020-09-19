
#include <asm/unistd.h>
#include <errno.h>
#include <math.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ioctl.h>
#include <sys/time.h>
#include <sys/types.h>
#include <unistd.h>

#ifdef THREAD_PTHREAD
#include <thread>
#endif
#ifdef THREAD_INTEL
#include <tbb/compat/thread>
#endif

#define BUFFER_SIZE 512

//#define PIN_DIFF

#ifdef PIN_SAME
#define CORE_CLIENT 2
#define CORE_WORKER 2
#endif
#ifdef PIN_DIFF
#define CORE_CLIENT 2
#define CORE_WORKER 4
#endif

#include "conf.hpp"

//#define TRACK_CACHING

#ifdef TRACK_CACHING
#include <linux/perf_event.h>
#include <linux/hw_breakpoint.h>
#endif

#define TIME_EACH_OP

#ifdef TIME_EACH_OP

#define REPLAY_START \
	time_start = gettime_us();
#define REPLAY_END \
	time_delta = gettime_us() - time_start;

#else

#define REPLAY_START
#define REPLAY_END

#endif

#ifdef STORAGE_SQLITE

#include "sqlite3.h"

#define STMT_BUFLEN 2048

#endif

#ifdef STORAGE_JITD

#include <map>
#include <sstream>
#include "jitd_test.hpp"
#include "IteratorDefinition.hpp"
#include "TopKIteratorDefinition.hpp"

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


int __array_size;
int __sleep_time;
struct output_node* output_array;
long output_size;
int ticks_size;
struct ticks_node* ticks_array;


long gettime_us() {

	timeval now;

	gettimeofday(&now, NULL);

	return now.tv_sec * 1000000 + now.tv_usec;

}


double total_time(timeval &start, timeval &end) {

	return (end.tv_sec - start.tv_sec) * 1000000.0 + (end.tv_usec - start.tv_usec);

}


// Copied from jitd_test.cpp:
inline uint64_t rdtsc() {

	unsigned int lo;
	unsigned int hi;

	__asm__ __volatile__ ("rdtsc" : "=a" (lo), "=d" (hi));

	return ((uint64_t)hi << 32) | lo;

}


//#define errtrap(error) (__errtrap(result, error, __LINE__))
void __errtrap(int result, const char* error, int line) {

	if (result == -1) {
		printf("Error in %s() on line %d:  %s\n", error, line, strerror(errno));
		_exit(errno);
	}
	return;

}


STORAGE_HANDLE create_storage(int maxkeys) {

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
	std::vector<Record> data;  // TODO switch to pre-existing struct

	FILE* input_stream;
	char input_file[] = "initialize_data.txt";
	int result;
	ssize_t chars_read;
	char* line_buffer = NULL;
	size_t buffer_size = 0;
	int input_index;
	int input_count;

	char* token;
	char* save;
	const char delim[] = "\t";

	int id;
	enum operation optype;
	unsigned long key;
	unsigned long value;

	input_stream = fopen(input_file, "r");
	if (input_stream == NULL) {
		printf("Error:  opening benchmark input file\n");
		_exit(1);
	}

	line_buffer = NULL;
	buffer_size = 0;
	input_index = 0;

	//storage->element.clear();
	while (true) {
/*
		// Debug:  Populate structure with only a subset of keys:
		if (k == maxkeys) {
			break;
		}
		k++;
		node = initialize_array[input_index];
		if (node.type == STOP) {
			break;
		}
*/
		chars_read = getline(&line_buffer, &buffer_size, input_stream);
		if ((chars_read == -1) || (input_index == maxkeys)) {
			input_count = input_index;  // Save linecount
			break;
		}

		// Basic sanity:  are we using the correct delimiter?
		token = strstr(line_buffer, delim);
		if (token == NULL) {
			printf("Error:  invalid delimiter\n");
			_exit(1);
		}

		token = strtok_r(line_buffer, delim, &save);
		id = atoi(token);
		assert(id == input_index);  // Sanity
		token = strtok_r(NULL, delim, &save);
		optype = (harness::operation)atoi(token);
		token = strtok_r(NULL, delim, &save);
		key = strtoul(token, NULL, 0);

		if (optype != harness::INSERT) {
			printf("Error:  expected Insert\n");
			_exit(1);
		}
		storage->r.key = key;
		data.push_back(storage->r);
		input_index++;
	}
	storage->jitd = std::shared_ptr<JITD>(new JITD(std::shared_ptr<std::shared_ptr<JITDNode>>(std::make_shared<std::shared_ptr<JITDNode>>(new ArrayNode(data)))));

	fclose(input_stream);

	printf("Keys prepopulated:  %d\n", input_index);

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
		if (k == maxkeys) {
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
//			value += *(unsigned long*)storage->r.value;
// TODO:  support for YCSB struct
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

	int result;
	int output_fd;
	char output_filename[] = "output_data.txt";
	char output_buffer[BUFFER_SIZE];
	int charcount;

	printf("Saving results\n");
	result = open(output_filename, O_CREAT | O_RDWR | O_TRUNC, 0666);
	errtrap("open");
	output_fd = result;

	// Save schema version:
	snprintf(output_buffer, BUFFER_SIZE, "Schema version 8fea69...\n");
	result = write(output_fd, output_buffer, strnlen(output_buffer, BUFFER_SIZE));
	errtrap("write");

	for (int i = 0; i < output_size; i++) {
		// Basic information (latency, operation info):
		charcount = 0;
		result = snprintf(output_buffer + charcount, BUFFER_SIZE, "%ld\t%ld\t%d\t%ld\t%d\t%d\t%d", output_array[i].time_start, output_array[i].time_delta, output_array[i].type, output_array[i].key, output_array[i].rows, output_array[i].nkeys, output_array[i].depth);
		charcount += result;
		// jitd transform count data:
		for (int j = 0; j < 8; j++) {
			result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "\t%d", output_array[i].count_array[j]);
			charcount += result;
		}
		// Cache activity information:
		result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "\t%ld\t%ld", output_array[i].cache_refs, output_array[i].cache_misses);
		charcount += result;
		// jitd view data structure sizes:
		for (int j = 0; j < 8; j++) {
			result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "\t%lu", output_array[i].size_array[j]);
			charcount += result;
		}
		// jitd work queue size (signed number):
		result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "\t%ld", output_array[i].work_queue);
		charcount += result;

		result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "\t%ld\t%lu\t%lu", output_array[i].event_time_delta, output_array[i].event_refs_delta, output_array[i].event_miss_delta);
		charcount += result;

		// Append EOL LF:
		result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "\n");
		charcount += result;
		// Sanity check (overflow):
		if (charcount >= BUFFER_SIZE) {
			printf("Error:  output format overflow:  %d >= %d\n", charcount, BUFFER_SIZE);
			_exit(1);
		}
		result = write(output_fd, output_buffer, strnlen(output_buffer, BUFFER_SIZE));
		errtrap("write");
	}

	close(output_fd);
	printf("Finished writing operation data\n");

	#if defined PER_NODE || defined PER_TRANS || defined REPLAY_NAIVE

	// Save out view performance data:
	int view_fd;
	char view_filename[] = "output_view_performance.txt";

	// failsafe:
	if (ticks_index > ticks_size) {
		printf("View output overflow:  %d > %d\n", ticks_index, ticks_size);
		_exit(1);
	}

	result = open(view_filename, O_CREAT | O_RDWR | O_TRUNC, 0666);
	errtrap("open");
	view_fd = result;

	for (int i = 0; i < ticks_index; i++) {
		charcount = 0;
		result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "%d\t%d", ticks_array[i].id, ticks_array[i].maint_type);
		charcount += result;
		for (int j = 0; j < 3; j++) {
			result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "\t%d", ticks_array[i].delta[j]);
			charcount += result;
		}
		result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "\t%d\t%d\t%d\n", ticks_array[i].trans_id, ticks_array[i].node_rw, ticks_array[i].node_type);
		charcount += result;
		result = write(view_fd, output_buffer, strnlen(output_buffer, BUFFER_SIZE));
		errtrap("write");
	}

	close(view_fd);
	printf("Finished writing view timing data\n");
	printf("Maintenance loglines written:  %d\n", ticks_index);

	#endif

	printf("Finished\n");
	return 0;

}


#ifdef STORAGE_JITD
int jitd_debug(STORAGE_HANDLE storage, const char* debug_filename) {

	int result;
	int fd_stdout;
	int fd_debug;

	// Save stdout:
	result = dup(1);
	errtrap("dup");
	fd_stdout = result;
	// Open debug file:
	result = open(debug_filename, O_CREAT | O_RDWR | O_TRUNC, 0666);
	errtrap("open");
	fd_debug = result;
	result = dup2(fd_debug, 1);
	errtrap("dup2");
	storage->jitd->print_debug();
	// Restore stdout:
	result = dup2(fd_stdout, 1);
	errtrap("dup2");
	// Cleanup:
	close(fd_debug);
	close(fd_stdout);

	return 0;

}


int pin_thread(int core) {

	long tid;
	cpu_set_t set;
	int result;

	// Pin client thread to core(s):
	tid = syscall(__NR_gettid);
	CPU_ZERO(&set);
	CPU_SET(core, &set);
	result = sched_setaffinity(tid, sizeof(set), &set);
	errtrap("sched_setaffinity");
	printf("Thread tid %ld pinned to core %d\n", tid, core);

	return 0;

}


void run_worker_thread(STORAGE_HANDLE storage) {

	int steps_taken;

	#if defined PIN_SAME || defined PIN_DIFF
	pin_thread(CORE_WORKER);
	#endif

	printf("Worker thread starting.\n");
	steps_taken = storage->jitd->organize_wait();
	printf("Worker thread exiting.  Steps taken:  %d\n", steps_taken);
	printf("View steps:  %d\n", ticks_index);

	return;

}
#endif


int replay_trace(STORAGE_HANDLE storage) {

// TODO:  For DBT, need to do on_insert() for initial array

	FILE* benchmark_stream;
	char benchmark_file[] = "benchmark_data.txt";
	int statm_fd;
	char statm_filename[] = "/proc/self/statm";  // Linux virtual fs path to memory statistics summary
	char statm_buffer[BUFFER_SIZE];
	int result;
	ssize_t chars_read;
	char* line_buffer = NULL;
	size_t buffer_size = 0;
	long time_start;
	long time_delta;
	enum operation optype;
	unsigned long key;
	unsigned long value;
	int benchmark_index;
	int benchmark_count;
	char* token;
	char* input_save;
	const char input_delim[] = "\t";
	char* statm_save;
	const char statm_delim[] = " ";
	int vmsize;
	int id;
	bool not_done;
	mutatorCqElement pop_mce;

	benchmark_stream = fopen(benchmark_file, "r");
	if (benchmark_stream == NULL) {
		printf("Error:  opening benchmark operation file\n");
		_exit(1);
	}

	// Need to use a raw kernel file handle -- bufferd fstream collection is not realtime
	result = open(statm_filename, O_RDONLY);
	errtrap("open");
	statm_fd = result;

	benchmark_index = 0;
	while (1) {

		chars_read = getline(&line_buffer, &buffer_size, benchmark_stream);
		if (chars_read == -1) {
			benchmark_count = benchmark_index;  // Save linecount
			break;
		}

		token = strtok_r(line_buffer, input_delim, &input_save);
		id = atoi(token);
		assert(id == benchmark_index);  // Sanity
		token = strtok_r(NULL, input_delim, &input_save);
		optype = (harness::operation)atoi(token);
		token = strtok_r(NULL, input_delim, &input_save);
		key = strtoul(token, NULL, 0);
		value = 0;

		// Replay mutator operation:
		if (optype == harness::INSERT) {
			REPLAY_START;
			put_data(storage, key, value);
			REPLAY_END;
		} else if (optype == SELECT) {
			REPLAY_START;
			result += get_data(storage, 1, &key);
			REPLAY_END;
		} else if (optype == DELETE) {
			REPLAY_START;
			result += remove_data(storage, 1, &key);
			REPLAY_END;
		} else if (optype == UPDATE) {
			REPLAY_START;
			result += update_data(storage, key, value);
			REPLAY_END;
		} else if (optype == UPSERT) {
			REPLAY_START;
			result += upsert_data(storage, key, value);
			REPLAY_END;
		} else {
			printf("Error:  Unexpected operation\n");
			_exit(1);
		}

		// Save out operation time:
		if (benchmark_index >= output_size) {
			printf("Error:  benchmark output overflow\n");
			_exit(1);
		}
		output_array[benchmark_index].time_start = time_start;
		output_array[benchmark_index].time_delta = time_delta;
		output_array[benchmark_index].type = optype;
		output_array[benchmark_index].key = key;
		output_array[benchmark_index].nkeys = 1;

		// Save out current process memory usage:
		result = read(statm_fd, statm_buffer, BUFFER_SIZE);
		errtrap("read");
		token = strtok_r(statm_buffer, statm_delim, &statm_save);
		vmsize = atoi(token);
		output_array[benchmark_index].depth = vmsize;  // Kludge -- repurpose field

		// For selects (non-writes), skip maintenance.  I.e. continue
		// replaying DB operations until there is a write operation:
		if (optype == SELECT) {
			benchmark_index++;
			continue;
		}

		time_start = gettime_us();

		while (1) {

			if (gettime_us() > time_start + 1000) {
				break;
			}

			if (storage->jitd->work_queue.empty() == false) {
				storage->jitd->work_queue.pop(pop_mce);
				if (pop_mce.flag == FLAG_remove_singleton) {
					storage->jitd->after_remove_singleton(pop_mce.element);
				} else if(pop_mce.flag == FLAG_insert_singleton) {
					storage->jitd->after_insert_singleton(pop_mce.element);
				} else {
					printf("Unexpected mutator\n");
					_exit(1);
				}
				not_done = true;
			} else {
				not_done = storage->jitd->do_organize();
			}

			if (not_done == false) {

break;
// OR -- SLEEP?  TODO

			}

		}

		benchmark_index++;
	}

	close(statm_fd);

	fclose(benchmark_stream);

	printf("Benchmark operations replayed:  %d\n", benchmark_count);

	int i = 0;
	while (1) {
		if (storage->jitd->do_organize() == false) {
			break;
		}
		i++;
	}
	printf("Post replay organization steps:  %d\n", i);

	save_output();

//	storage->jitd->print_debug();

	return 0;

}


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
	int maxkeys;  // debug -- the keycount with which the structure will be initially populated

	#ifdef STORAGE_SQLITE
	printf("Using SQLite storage\n");
	#endif
	#ifdef STORAGE_JITD
	#ifdef THREAD_PTHREAD
	printf("Using JITD storage with pthread threads\n");
	#endif
	#ifdef THREAD_INTEL
	printf("Using JITD storage with intel threads\n");
	#endif
	#endif
	#ifdef STORAGE_MAP
	printf("Using (Ordered) Map storage\n");
	#endif
	#ifdef STORAGE_UOM
	printf("Using Unordered Map storage\n");
	#endif

	#ifdef REPLAY_JITD
	printf("Running REPLAY_JITD trace harness\n");
	#endif
	#ifdef REPLAY_TOASTER
	printf("Running REPLAY_TOASTER trace harness\n");
	#endif
	#ifdef REPLAY_CLASSIC
	printf("Running REPLAY_CLASSIC trace harness\n");
	#endif
	#if not defined REPLAY_JITD && not defined REPLAY_TOASTER && not defined REPLAY_CLASSIC
	printf("Running COLLECT trace harness\n");
	#endif

	// Extract debug parameters:  max keycount with which to populate structure and jitd crack threshhold:
	if (argc != 4) {
		printf("Unexpected parameter count\n");
		_exit(1);
	}
	maxkeys = atoi(argv[2]);

	srand(time(NULL));

	// Populate jitd specific parameters (must be done *before* JITD() constructor call):
	__array_size = atoi(argv[1]);
	__sleep_time = atoi(argv[3]);

	FILE* benchmark_stream;
	char benchmark_file[] = "benchmark_data.txt";
	ssize_t chars_read;
	char* line_buffer = NULL;
	size_t buffer_size = 0;

	benchmark_stream = fopen(benchmark_file, "r");
	if (benchmark_stream == NULL) {
		printf("Error:  opening benchmark operation file\n");
		_exit(1);
	}
	// Get output array size from linecount of benchmark workload:
	while (1) {
		chars_read = getline(&line_buffer, &buffer_size, benchmark_stream);
		if (chars_read == -1) {
			break;
		}
		output_size++;
	}
	fclose(benchmark_stream);

	output_array = new output_node[output_size]();
	#if defined PER_NODE || defined PER_TRANS || defined REPLAY_NAIVE
	ticks_size = output_size * 200;  // Adjust to taste; estimation based on workloads A, F
	ticks_array = new ticks_node[ticks_size]();
	#endif
	printf("Output size:  %ld  Ticks size:  %d\n", output_size, ticks_size);

	printf("Creating and initializing data structure\n");
	storage = create_storage(maxkeys);
	printf("Finished\n");
	// Basic structural integrity check:
//	test_struct(storage);

	// Organize initial jitd structure until it reaches a stable state:
	bool not_done = true;
	i = 0;
	while (not_done == true) {
		not_done = storage->jitd->do_organize();
		i++;
	}

	printf("Initial Organization Steps:  %d\n", i);
	printf("crack threshhold:  %d\n", __array_size);
	printf("worker sleeptime:  %d\n", __sleep_time);
	storage->jitd->get_node_count();

	#if defined REPLAY_JITD || defined REPLAY_TOASTER || defined REPLAY_CLASSIC || defined REPLAY_NAIVE
	replay_trace(storage);
	_exit(0);
	#endif
	printf("Unexpected path\n");
	_exit(1);

	return 0;

}


