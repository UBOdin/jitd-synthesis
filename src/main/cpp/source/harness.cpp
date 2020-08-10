
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

#define TIME_START \
	if (optype != SELECT) { \
		trace_lock.lock(); \
		record_mutator(benchmark_array[i].id, optype, key, value); \
	} \
	time_start = gettime_us();
#define TIME_END \
	time_delta = gettime_us() - time_start; \
	if (optype != SELECT) { \
		trace_lock.unlock(); \
	}

#define REPLAY_START \
	time_start = gettime_us();
#define REPLAY_END \
	time_delta = gettime_us() - time_start;

#else

#define TIME_START
#define TIME_END
#define REPLAY_START
#define REPLAY_END

#endif

#ifdef REPLAY_DBT

#include "../../../../toaster_harness/toaster_maintenance.hpp"

#include "program_base.cpp"
#include "event.cpp"
#include "runtime.cpp"
#include "streams.cpp"
#include "iprogram.cpp"
#include "standard_adaptors.cpp"
#include "smhasher/MurmurHash2.cpp"

#endif


#ifdef STORAGE_SQLITE

#include "sqlite3.h"

#define STMT_BUFLEN 2048

#endif

#ifdef STORAGE_JITD

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

	//storage->element.clear();
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
		storage->r.key = node.key;
//		storage->r.value = new int(node.value);
// TODO:  support for YCSB struct
		data.push_back(storage->r);
		i++;
	}
	storage->jitd = std::shared_ptr<JITD>(new JITD(std::shared_ptr<std::shared_ptr<JITDNode>>(std::make_shared<std::shared_ptr<JITDNode>>(new ArrayNode(data)))));

	printf("Keys prepopulated:  %d\n", k);

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

	#define BUFFER_SIZE 256

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
			printf("Error:  output format overflow\n");
			_exit(1);
		}
		result = write(output_fd, output_buffer, strnlen(output_buffer, BUFFER_SIZE));
		errtrap("write");
	}

	close(output_fd);
	printf("Finished writing operation data\n");

	#if defined REPLAY_JITD || defined REPLAY_DBT

	// Save out view performance data:
	int view_fd;
	char view_filename[] = "output_view_performance.txt";

	// failsafe:
	if (ticks_index > TICKS_SIZE) {
		printf("View output overflow:  %d > %d\n", ticks_index, TICKS_SIZE);
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
		result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "\n");
		charcount += result;
		result = write(view_fd, output_buffer, strnlen(output_buffer, BUFFER_SIZE));
		errtrap("write");
	}

	close(view_fd);
	printf("Finished writing view timing data\n");

	#else

	// Save out view maintenance data:
	int maint_fd;
	char maint_filename[] = "output_view_maintenance.txt";

	// failsafe:
	if (maint_index > MAINT_SIZE) {
		printf("Maintenance output overflow:  %d > %d\n", maint_index, MAINT_SIZE);
		_exit(1);
	}

	result = open(maint_filename, O_CREAT | O_RDWR | O_TRUNC, 0666);
	errtrap("open");
	maint_fd = result;

	for (int i = 0; i < maint_index; i++) {
		charcount = 0;
//		result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "%d\t%d\t%d\t%d\t%d\t%lu\t%lu\t%lu\t%lu\t%lu\t%ld\t%ld\n", maint_array[i].maint_id, maint_array[i].ticks_id, maint_array[i].rw, maint_array[i].maint_type, maint_array[i].node_type, maint_array[i].node_self, maint_array[i].node_parent, maint_array[i].node_child, maint_array[i].node_left, maint_array[i].node_right, maint_array[i].value, maint_array[i].time_start);
		result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "%d,%d,%d,%d,%d,%lu,%lu,%lu,%lu,%lu,%ld,%ld\n", maint_array[i].maint_id, maint_array[i].ticks_id, maint_array[i].rw, maint_array[i].maint_type, maint_array[i].node_type, maint_array[i].node_self, maint_array[i].node_parent, maint_array[i].node_child, maint_array[i].node_left, maint_array[i].node_right, maint_array[i].value, maint_array[i].time_start);

		charcount += result;
		result = write(maint_fd, output_buffer, strnlen(output_buffer, BUFFER_SIZE));
		errtrap("write");
	}

	close(maint_fd);

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


inline void populate_node(char* line, struct maint_node* node) {

	char* token;
	char* save;
	const char delim[] = ",";

	// Basic sanity:  are we using the correct delimiter?
	token = strstr(line, delim);
	if (token == NULL) {
		printf("Error:  invalid delimiter\n");
		_exit(1);
	}

	token = strtok_r(line, delim, &save);
	node->maint_id = atoi(token);
	token = strtok_r(NULL, delim, &save);
	node->ticks_id = atoi(token);
	token = strtok_r(NULL, delim, &save);
	node->rw = atoi(token);
	token = strtok_r(NULL, delim, &save);
	node->maint_type = atoi(token);
	token = strtok_r(NULL, delim, &save);
	node->node_type = atoi(token);
	token = strtok_r(NULL, delim, &save);
	node->node_self = strtoul(token, NULL, 0);
	token = strtok_r(NULL, delim, &save);
	node->node_parent = strtoul(token, NULL, 0);
	token = strtok_r(NULL, delim, &save);
	node->node_child = strtoul(token, NULL, 0);
	token = strtok_r(NULL, delim, &save);
	node->node_left = strtoul(token, NULL, 0);
	token = strtok_r(NULL, delim, &save);
	node->node_right = strtoul(token, NULL, 0);
	token = strtok_r(NULL, delim, &save);
	node->value = strtol(token, NULL, 0);

	return;

}


#ifdef REPLAY_DBT

namespace dbtoaster { class Custom_toaster : public Program {

	public:

	Custom_toaster(int argc = 0, char* argv[] = 0) : Program(argc, argv) { }


	void foo() {

		data.on_insert_BTREE(0, 0, 0, 0, 0);

	}


int init_data() {

	assert(maint_array[0].node_type == JITD_NODE_Array);

	data.on_insert_ARRAY(0, maint_array[0].node_self, maint_array[0].value);

	return 0;

}


int replay_dbt_block(int start_node, int end_node) {

	int rw;
	int type;
	unsigned long id;
	unsigned long self;
	unsigned long time_start;
	unsigned long time_delta;


	time_start = rdtsc();

	for (int i = start_node; i < end_node; i++) {

		rw = maint_array[i].rw;
		type = maint_array[i].node_type;
		id = 0; // maint_array[i].maint_id;
		self = maint_array[i].node_self;

//printf("Node rw %d type %d\n", rw, type);


		if (rw == 1) {

			if (type == JITD_NODE_DeleteSingleton) {
				data.on_insert_DELETESINGLETON(id, self, maint_array[i].node_child, maint_array[i].value);
			} else if (type == JITD_NODE_DeleteElements) {
				goto err_missing_node;
			} else if (type == JITD_NODE_BTree) {
				data.on_insert_BTREE(id, self, maint_array[i].node_left, maint_array[i].node_right, maint_array[i].value);
			} else if (type == JITD_NODE_Concat) {
				data.on_insert_CONCAT(id, self, maint_array[i].node_left, maint_array[i].node_right);
			} else if (type == JITD_NODE_SortedArray) {
				goto err_missing_node;
			} else if (type == JITD_NODE_Array) {
				data.on_insert_ARRAY(id, self, maint_array[i].value);
			} else if (type == JITD_NODE_Singleton) {
				data.on_insert_SINGLETON(id, self, maint_array[i].value);
			}

		} else if (rw == 0) {

			if (type == JITD_NODE_DeleteSingleton) {
				data.on_delete_DELETESINGLETON(id, self, maint_array[i].node_child, maint_array[i].value);
			} else if (type == JITD_NODE_DeleteElements) {
				goto err_missing_node;
			} else if (type == JITD_NODE_BTree) {
				data.on_delete_BTREE(id, self, maint_array[i].node_left, maint_array[i].node_right, maint_array[i].value);
			} else if (type == JITD_NODE_Concat) {
				data.on_delete_CONCAT(id, self, maint_array[i].node_left, maint_array[i].node_right);
			} else if (type == JITD_NODE_SortedArray) {
				goto err_missing_node;
			} else if (type == JITD_NODE_Array) {
				data.on_delete_ARRAY(id, self, maint_array[i].value);
			} else if (type == JITD_NODE_Singleton) {
				data.on_delete_SINGLETON(id, self, maint_array[i].value);
			}

		}


	}

	time_delta = rdtsc() - time_start;

	// The maintenance performance framework in JITD has already advanced the ticks_indexer index
	// to the next available (free) slot.  Back up and overwrite with equivalent data from dbt:
	ticks_index--;

	if (ticks_index >= TICKS_SIZE) {
		printf("Error:  view overflow\n");
		_exit(1);
	}
	ticks_array[ticks_index].id = ticks_index;
	ticks_array[ticks_index].maint_type = maint_array[start_node].maint_type;  // maintenance type should be the same for the entire block
	ticks_array[ticks_index].delta[0] = time_delta;  // Sum of both erase / add
	ticks_array[ticks_index].delta[1] = 0;
	ticks_array[ticks_index].delta[2] = 0;
	ticks_index++;

	return 0;

    err_missing_node:
	printf("Error:  unsupported node type\n");
	_exit(1);



}


}; }

#endif


int replay_trace(STORAGE_HANDLE storage) {

// TODO:  For DBT, need to do on_insert() for initial array

	FILE* input_stream;
	char input_file[] = "output_view_maintenance.txt";
	int result;
	ssize_t chars_read;
	char* line_buffer = NULL;
	size_t buffer_size = 0;
	int i = 0;  // maintenance iterator
	int j = 0;  // benchmark iterator
	long time_start;
	long time_delta;
	enum operation optype;
	unsigned long key;
	unsigned long value;

	// Step 1:  Read-in previously recorded maintenance tracefile

	input_stream = fopen(input_file, "r");
	if (input_stream == NULL) {
		printf("Error:  opening input file\n");
		_exit(1);
	}

	line_buffer = NULL;
	buffer_size = 0;
	i = -1;

	while (1) {
		i++;

		chars_read = getline(&line_buffer, &buffer_size, input_stream);
		if (chars_read == -1) {
			maint_index = i;  // Save linecount
			break;
		}

		if (i >= MAINT_SIZE) {
			printf("Error:  maintenance overflow\n");
			_exit(1);
		}

		populate_node(line_buffer, &maint_array[i]);

	}

	printf("Read in %d maintenance tracelines\n", maint_index);

	free(line_buffer);
	fclose(input_stream);

	// Step 2:  Replay trace (now in memory) on maintenance framework:

	int rw;
	int maint_type;
	mutatorCqElement pop_mce;

	#ifdef REPLAY_DBT

	char foo_str[] = {"foobar\0"};
	char* argv[] = {foo_str, NULL};

	dbtoaster::Custom_toaster ct(1, argv);

	ct.init();
	ct.init_data();

	#endif

// TODO:  TIME each searchFor operation and record that, too

	i = 0;  // Skip first line (the initial prepopulation)
	j = 0;

	while (1) {
		i++;

/*
printf("i:  %d  ticks count:  %d\n", i, ticks_index);

if (i > 300) {
	break;
}
*/

		if (i == maint_index) {
			break;
		}

		rw = maint_array[i].rw;
		if (rw == 0) {

			maint_type = maint_array[i].maint_type;

			// For JITD, need to spell out which (if any) after mutator operations:
			if (maint_type == 11) {
				storage->jitd->work_queue.pop(pop_mce);
				assert(pop_mce.flag == FLAG_remove_singleton);
				storage->jitd->after_remove_singleton(pop_mce.element);
			} else if (maint_type == 14) {
				storage->jitd->work_queue.pop(pop_mce);
				assert(pop_mce.flag == FLAG_insert_singleton);
				storage->jitd->after_insert_singleton(pop_mce.element);
			} else {
				// For all other transforms, call into do_organize():
				storage->jitd->do_organize();
			}

			//  Sanity check:  Replay operation originally recorded should match the one just selected:
			if (maint_type != ticks_array[ticks_index - 1].maint_type) {
				printf("Unexpected maintenance type:  %d %d %d %d\n", i, maint_type, ticks_array[ticks_index - 1].maint_type, ticks_index - 1);
				_exit(1);
			}

			// Get end of current block:
			int k = i;
			while (1) {
				if (maint_array[i].ticks_id != maint_array[k].ticks_id) {
					break;
				}
				k++;
			}

//printf("DBT start/stop:  %d, %d\n", i, k);

			#ifdef REPLAY_DBT
			ct.replay_dbt_block(i, k);
			#endif

			i = k - 1;

//			#endif

// TODO:  Possibly split-up processing of Add and Erase subblocks for DBT

		} else if (rw == 1) {

			printf("Error:  Unexpected Add on %d\n", i);
			_exit(1);

		} else if (rw == 2) {

			// node_type, node_left and node_right fields repurposed for mutators:
			optype = (enum operation)maint_array[i].node_type;
			key = maint_array[i].node_left;
			value = maint_array[i].node_right;

			// Replay mutator operation:
			if (optype == harness::INSERT) {
				REPLAY_START;
				put_data(storage, key, value);
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
			if (j >= output_size) {
				printf("Error:  output replay overflow\n");
				_exit(1);
			}

			output_array[j].time_start = time_start;
			output_array[j].time_delta = time_delta;
			output_array[j].type = optype;
			output_array[j].key = key;
			output_array[j].nkeys = 1;

			j++;

		} else {
			printf("Invalid operation\n");
			_exit(1);
		}

	}

	printf("Maintenance lines replayed:  %d\n", i);
	printf("Benchmark operations replayed:  %d\n", j);

	save_output();

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
	#ifdef TRACK_CACHING
//	#define PERFBUFF_SIZE 64
	int perf_ref_fd;
	int perf_miss_fd;
	struct perf_event_attr pea_struct;
	char perf_buff[PERFBUFF_SIZE];

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
	pea_struct.inherit = 0;  // Yes, track both client and worker (n.b. documentation says this = 1 is incompatible with PERF_FORMAT_GROUP -- it is _not_; bug?)
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
	#endif

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
	#ifdef REPLAY_DBT
	printf("Running REPLAY_DBT trace harness\n");
	#endif
	#if not defined REPLAY_JITD && not defined REPLAY_DBT
	printf("Running COLLECT trace harness\n");
	#endif

	// Extract debug parameters:  max keycount with which to populate structure and jitd crack threshhold:
	if (argc != 4) {
		printf("Unexpected parameter count\n");
		_exit(1);
	}
	maxkeys = atoi(argv[2]);

	// Initialize and populate structure:

extern int maint_size;
memset(maint_array, 0, maint_size);

	printf("Creating and initializing data structure\n");
	storage = create_storage(maxkeys);
	memset(output_array, 0, sizeof(struct output_node) * output_size);
	printf("Finished\n");
	// Basic structural integrity check:
//	test_struct(storage);
	#ifdef STORAGE_JITD
	// Populate jitd specific parameters:
	storage->jitd->__array_size = atoi(argv[1]);
	storage->jitd->__sleep_time = atoi(argv[3]);
	#ifdef TRACK_CACHING
	#endif

#if defined REPLAY_JITD || defined REPLAY_DBT
replay_trace(storage);
_exit(0);
#endif

	// Organize initial jitd structure until it reaches a stable state:
	bool not_done = true;
	i = 0;
	while (not_done == true) {
		not_done = storage->jitd->do_organize();
		i++;
	}

	printf("Initial Organization Steps:  %d\n", i);
	printf("crack threshhold:  %d\n", storage->jitd->__array_size);
	printf("worker sleeptime:  %d\n", storage->jitd->__sleep_time);
	storage->jitd->get_node_count();

	#if defined PIN_SAME || defined PIN_DIFF
	pin_thread(CORE_CLIENT);
	#endif

	// Kick off background worker thread:
	std::thread worker_thread(run_worker_thread, storage);
	#endif

	// Block :30 to stabilize system:
	printf("Waiting -- stabilize system\n");
//	std::this_thread::sleep_for(std::chrono::milliseconds(30 * 1000));

	printf("Starting operations\n");
	gettimeofday(&start, NULL);

	time_base = gettime_us();
	printf("Start base time:  %ld\n", time_base);

	#ifdef TRACK_CACHING
	ioctl(perf_ref_fd, PERF_EVENT_IOC_RESET, 0);
	ioctl(perf_ref_fd, PERF_EVENT_IOC_ENABLE, 0);
	#endif

	i = 0;
	j = 0;
	while (true) {

		if ((i % 100) == 0) {
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
				// TODO create pre-existing vector<long> in storage struct and use clear() on storage->element?
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

		#ifdef TRACK_CACHING
		result = read(perf_ref_fd, perf_buff, PERFBUFF_SIZE);
		errtrap("read");
		output_array[i].cache_refs = ((unsigned long*)perf_buff)[1];
		output_array[i].cache_misses = ((unsigned long*)perf_buff)[2];
		#endif

		#ifdef STORAGE_JITD
		output_array[i].depth = depth;
		#ifdef TRANSFORM_COUNT
		output_array[i].count_array[0] = storage->jitd->PushDownSingletonLeft_count;
		output_array[i].count_array[1] = storage->jitd->PushDownSingletonRight_count;
		output_array[i].count_array[2] = storage->jitd->PushDownDontDeleteSingletonBtreeLeft_count;
		output_array[i].count_array[3] = storage->jitd->PushDownDontDeleteSingletonBtreeRight_count;
		output_array[i].count_array[5] = storage->jitd->PushDownDontDeleteElemBtree_count;
		output_array[i].count_array[7] = storage->jitd->CrackArray_count;
		output_array[i].size_array[0] = storage->jitd->PushDownSingletonLeft_View.size();
		output_array[i].size_array[1] = storage->jitd->PushDownSingletonRight_View.size();
		output_array[i].size_array[2] = storage->jitd->PushDownDontDeleteSingletonBtreeLeft_View.size();
		output_array[i].size_array[3] = storage->jitd->PushDownDontDeleteSingletonBtreeRight_View.size();
//		output_array[i].size_array[5] = storage->jitd->PushDownDontDeleteElemBtree_View.size();
		output_array[i].size_array[7] = storage->jitd->CrackArray_View.size();
		output_array[i].work_queue = storage->jitd->work_queue.size();
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

	#ifdef TRACK_CACHING
	ioctl(perf_ref_fd, PERF_EVENT_IOC_DISABLE, 0);
	#endif

	gettimeofday(&end, NULL);
	printf("Total runtime:  %f us\n", total_time(start, end));
	printf("In seconds:  %f us\n", total_time(start, end) / 1000000.0);

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
	storage->jitd->work_queue.emplace(EXIT, nullptr, nullptr);
	printf("Blocking on worker thread exit\n");
	worker_thread.join();

	storage->jitd->get_node_count();
	storage->jitd->get_depth(1, depth);
	printf("jitd depth:  %d\n", depth);
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

//	jitd_debug(storage, "debug_jitd_final.txt");

	printf("Worker thread exited\n");
	#endif

	#ifdef TRACK_CACHING
	close(perf_ref_fd);
	close(perf_miss_fd);
	#endif

	printf("Dummy sum:  %f\n", sum);

	printf("Result:  %d\n", result);
	printf("End base time:  %ld\n", time_base);
	printf("End\n");
	return 0;

}


