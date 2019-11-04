
enum operation {

	INSERT,
	SELECT,
	TIME,
	STOP,

};

union datatype {

	double time;
	long key;
	int null;

};

struct operation_node {

	enum operation type;
	union datatype data;

};

int jitd_harness();

extern struct operation_node operation_array[];

