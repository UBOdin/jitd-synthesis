
enum operation {

	INSERT,
	SELECT,
	DELETE,
	UPDATE,
	BULK,
	STOP,

};

// N.b. initializer field order must match that of structure declaration in C++
// N.b. array initializers must _exactly_ fit declared size (less 1 for nullterm) in C++14

struct operation_node {

	enum operation type;
	double time;
	long key;
	int rows;			// Sanity check for select:  actual number of rows returned in ground truth
	int field;			// in YCSB:  which non-key column to modify
	char val[100 * 10 + 1];		// in YCSB:  10 non-key columns of equal-sized ASCII blobs (plus nullterm)

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

