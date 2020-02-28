
enum operation {

	INSERT,
	SELECT,
	DELETE,
	UPDATE,
	UPSERT,
	STOP,

};

// N.b. initializer field order must match that of structure declaration in C++

struct operation_node {

	int id;
	enum operation type;
	double time;
	int rows;			// For select:  actual number of rows returned in ground truth
	int nkeys;			// For select:  the number of keys requested
	unsigned long key;
	unsigned long* key_array;

};

struct output_node {

	long time_start;
	long time_delta;
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

