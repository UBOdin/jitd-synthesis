
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

};

struct output_node {

	long time_start;
	long time_delta;
	harness::operation type;
	long key;
	int rows;
	int nkeys;
	int depth;

};

#ifdef STORAGE_JITD

struct storage_jitd_struct {
	Record r;
	std::vector<Record> element;
	std::shared_ptr<JITD> jitd;
};

#endif

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

