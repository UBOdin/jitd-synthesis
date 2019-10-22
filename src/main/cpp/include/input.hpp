
enum operation_type {

	QUERY,
	DELAY,
	STOP,

};

typedef enum operation_type optype;

struct operation_node {

	enum operation_type optype;
	void* data;

};

typedef struct operation_node opnode;

int jitd_harness();

