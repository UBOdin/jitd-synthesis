
enum operation_type {

	QUERY,
	DELAY,
	STOP,

};

struct operation_node {

	enum operation_type optype;
	void* data;

};


typedef enum operation_type optype;


double total_time(timeval &start, timeval &end);
int jitd_harness();

