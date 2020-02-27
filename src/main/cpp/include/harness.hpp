
enum operation {

	INSERT,
	SELECT,
	DELETE,
	UPDATE,
	UPSERT,
	STOP,

};

union key_type {

	long key;
	long* key_array;

};

// N.b. initializer field order must match that of structure declaration in C++

struct operation_node {

	int id;
	enum operation type;
	double time;
	int rows;			// For select:  actual number of rows returned in ground truth
	int nkeys;			// For select:  the number of keys requested
	union key_type key_union;

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

