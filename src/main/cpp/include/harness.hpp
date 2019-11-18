
enum operation {

	INSERT,
	SELECT,
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

};

int jitd_harness();

// Machine-generated static data:
extern struct operation_node operation_array[];
extern struct operation_node seed_array[];

