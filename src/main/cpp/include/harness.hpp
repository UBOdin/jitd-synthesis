
#include <string>
#include <mutex>

// N.b. using namespace to resolve enum collision (INSERT)

namespace harness {

enum operation {

	INSERT,
	SELECT,
	DELETE,
	UPDATE,
	UPSERT,
	STOP,

};

}

// N.b. initializer field order must match that of structure declaration in C++

struct operation_node {

	int id;
	harness::operation type;
	double time;
	int rows;			// For select:  actual number of rows returned in ground truth
	int nkeys;			// For select:  the number of keys requested
	unsigned long value;		// For Insert / Upsert:  the value to be inserted
	unsigned long key;
	unsigned long* key_array;
	int field;			// in YCSB:  which non-key column to modify
	std::string field_array[10];

};

struct output_node {

	long time_start;
	long time_delta;
	harness::operation type;
	long key;
	int rows;
	int nkeys;
	// Debug fields (HW monitors):
	unsigned long cache_refs;
	unsigned long cache_misses;
	// Debug fields for Jitd:
	int depth;			// jitd depth
	int count_array[8];		// transform counts
	unsigned long size_array[8];	// data structure sizes
	int long work_queue;		// work queue (signed)

	int long event_time_delta;
	unsigned long event_refs_delta;
	unsigned long event_miss_delta;

};

#ifdef STORAGE_JITD

struct storage_jitd_struct {
	Record r;
	std::vector<Record> element;
	std::shared_ptr<JITD> jitd;
};

#endif

#define TICKS_SIZE 100000
#define MAINT_SIZE 100000

struct ticks_node {

	int id;
	int maint_type;
	int delta[3];

};

struct maint_node {

	int maint_id;
	int ticks_id;
	int rw;
	int maint_type;
	int node_type;
	unsigned long node_self;
	unsigned long node_parent;
	unsigned long node_child;
	unsigned long node_left;
	unsigned long node_right;
	long value;  // Singleton => data; DeleteSingleton => key; BTree => sep; [Sorted]Array => size
	long time_start;

};

extern struct ticks_node ticks_array[];
extern struct maint_node maint_array[];
extern int ticks_count;
extern int maint_count;
extern std::mutex trace_lock;

#ifdef STORAGE_MAP

struct storage_map_struct {
	std::map<MAP_TYPE>::iterator key_iter;
	std::map<MAP_TYPE>::iterator end_iter;
	std::pair<MAP_TYPE> data_pair;
	std::map<MAP_TYPE> map;
};

#endif

#ifdef STORAGE_UOM

struct storage_uom_struct {
	std::unordered_map<UOM_TYPE>::iterator key_iter;
	std::unordered_map<UOM_TYPE>::iterator end_iter;
	std::pair<UOM_TYPE> data_pair;
	std::unordered_map<UOM_TYPE> uom;
};

#endif

// Machine-generated static data:

extern struct operation_node initialize_array[];
extern struct operation_node benchmark_array[];
extern struct output_node output_array[];
extern long output_size;

// Benchmark use:

#define PERFBUFF_SIZE 64

#define errtrap(error) (__errtrap(result, error, __LINE__))

long gettime_us();
void __errtrap(int result, const char* error, int line);
void record_mutator(int, int, unsigned long, unsigned long);

