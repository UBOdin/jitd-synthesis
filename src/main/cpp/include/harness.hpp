
enum operation_type {

	INSERT,
	SELECT,
	TIME,
	STOP,

};

struct operation_node {

	enum operation_type optype;
	double data;

};


double total_time(timeval &start, timeval &end);
int jitd_harness();

