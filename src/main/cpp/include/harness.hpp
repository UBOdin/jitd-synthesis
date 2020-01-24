
#include <string>

enum operation {

	INSERT,
	SELECT,
	DELETE,
	UPDATE,
	BULK,
	STOP,

};

// N.b. initializer field order must match that of structure declaration in C++

struct operation_node {

	enum operation type;
	double time;
	long key;
	int rows;			// Sanity check for select:  actual number of rows returned in ground truth
	int field;			// in YCSB:  which non-key column to modify
	std::string field_array[10];

};

struct output_node {

	double time_start;
	double time_delta;
	enum operation type;
	long key;
	int rows;

};

int jitd_harness();

// Machine-generated static data:
extern struct operation_node initialize_array[];
extern struct operation_node benchmark_array[];
extern struct output_node output_array[];
extern long output_size;

