
enum operation {

	INSERT,
	SELECT,
	TIME,
	STOP,

};

// N.b. time and key fields are mutually exclusive, so union:
union datatype {

	double time;
	long key;
	int null;

};

struct operation_node {

	enum operation type;
	union datatype data;
	int rows;

};

int jitd_harness();

// Machine-generated static data:
extern struct operation_node operation_array[];
extern struct operation_node seed_array[];

