
enum operation_type {

	INSERT,
	SELECT,
	DELAY,
	STOP,

};

struct operation_node {

	enum operation_type optype;
	float data;

};


double total_time(timeval &start, timeval &end);
int jitd_harness();

