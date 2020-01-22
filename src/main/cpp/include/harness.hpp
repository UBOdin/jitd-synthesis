
enum operation {

	INSERT,
	SELECT,
	DELETE,
	UPDATE,
	BULK,
	STOP,

};

struct operation_node {

	enum operation type;
	double time;
	long key;
	int rows;

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

