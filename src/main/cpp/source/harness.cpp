
#include <memory>
#include <thread>

#include <stdio.h>
#include <string.h>
#include <sys/time.h>
#include <unistd.h>

#include "jitd_test.hpp"
#include "harness.hpp"
#include "data.hpp"


int jitd_harness() {

	timeval start;
	timeval end;
	std::shared_ptr<JITD> jitd;
	std::vector<Record> data;
	Record r;
	int ms;
	int i;
	struct operation_node opnode;

/*
	int testarray[] = {41, 6, 7, 19, 51, 95, 94, 93, 88, 5};
	bool observed;
	bool expected;
*/

	printf("Starting\n");
	gettimeofday(&start, NULL);

	jitd = std::shared_ptr<JITD>(new JITD(new ArrayNode(data)));

	r.key = -9999999;  // dummy init key; will be popped later
	r.value = (Value)0xDEADBEEF;
	data.push_back(r);

	i = 0;
	while (true) {
		printf("iteration %d\n", i);
		opnode = operation_array[i];
		if (opnode.optype == STOP) {
			break;
		}
		if (opnode.optype == DELAY) {
			ms = *(float*)opnode.data / 100;  // * 1000;
//			std::this_thread::sleep_for(std::chrono::milliseconds(ms));
		}
		if (opnode.optype == QUERY) {
			r.key = *(long*)opnode.data;
			data.pop_back();
			data.push_back(r);
			jitd->insert(data);
		}
		i++;
	}



/*
	printf("Inserting 10 data into jitds\n");
	for (int i = 0; i < 10; i++) {
		r.key = testarray[i];
		data.pop_back();
		data.push_back(r);
		jitd->insert(data);
	}

	printf("Verifying inserted data\n");
	for (int i = 0; i < 100; i++) {
		// Check whether target value _was_ inserted:
		expected = false;
		for (int j = 0; j < 10; j++) {
			if (testarray[j] == i) {
				expected = true;
				break;
			}
		}
		// Check whether target value is reported by jitds:
		observed = jitd->get(i, r);
		if (expected != observed) {
			printf("jitds test failure:  expected = %d; observed = %d on item %d\n", expected, observed, i);
			_exit(1);
		}

	}
	printf("Passed jitds harness basic test\n");
*/

	gettimeofday(&end, NULL);

	std::cout << "Init JITD: " << total_time(start, end) << " us" << std::endl;
	printf("End\n");
	return 0;

}

