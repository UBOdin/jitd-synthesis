
#include <memory>

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
	RecordBuffer data;
	Record r;
	int ms;

	int testarray[] = {41, 6, 7, 19, 51, 95, 94, 93, 88, 5};
	bool observed;
	bool expected;

	printf("Starting\n");

	gettimeofday(&start, NULL);
	r.key = 888; //value_array[0];
	r.value = (Value)0xDEADBEEF;

	data.push_back(r);
	jitd = std::shared_ptr<JITD>(new JITD(new ArrayNode(data)));

/*
	bool result;

	printf("debug 0\n");
	jitd->print_debug();
	//jitd->insert(data);
	Record r2;
	printf("debug 1\n");
	jitd->print_debug();
	result = jitd->get(878, r2);
	printf("Result:  %d\n", result);
	return 0;
*/

/*
	for (int i = 0; i < 300; i++) {
		printf("%d\n", i);
		r.key = value_array[i + 1];
		jitd->insert(data);
		// Delay
		ms = delay_array[i]; // * 1000;
//		std::this_thread::sleep_for(std::chrono::milliseconds(ms));
	}
*/

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

	gettimeofday(&end, NULL);

	std::cout << "Init JITD: " << total_time(start, end) << " us" << std::endl;
	printf("End\n");
	return 0;

/*
	opnode foo;
	foo = operation_array[4];
	if (foo.optype == QUERY) {
		printf("Query value:  %lld\n", *(long*)foo.data);
	}
	if (foo.optype == DELAY) {
		printf("Delay value:  %f\n", *(float*)foo.data);
	}
	if (foo.optype == STOP) {
		printf("Stop\n");
	}
	printf("Addr2:  %p\n", foo.data);


	printf("addr:  %p\n", value_array[0]);
	printf("addr:  %p\n", value_array[1]);
	printf("addr:  %p\n", value_array[2]);
	printf("addr:  %p\n", value_array[3]);

	printf("value:  %d\n", value_array[0]);
	printf("value:  %d\n", value_array[1]);
	printf("value:  %d\n", value_array[2]);
	printf("value:  %d\n", value_array[3]);

	printf("end test\n");
	return 0;
*/

}

