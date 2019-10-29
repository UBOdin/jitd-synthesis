
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
	bool results;

	printf("Starting\n");
	gettimeofday(&start, NULL);

	// Initialize bare jitds structure:
	jitd = std::shared_ptr<JITD>(new JITD(new ArrayNode(data)));

	// Init data template to push:
	r.key = -9999999;  // dummy init key; will be popped later
	r.value = (Value)0xDEADBEEF;
	data.push_back(r);

	i = 0;
	while (true) {
//		printf("iteration %d\n", i);
		opnode = operation_array[i];
		if (opnode.optype == STOP) {
			break;
		}
		if (opnode.optype == DELAY) {
			ms = opnode.data / 100;  // Adjust delay to taste
//			std::this_thread::sleep_for(std::chrono::milliseconds(ms));
		}
		if (opnode.optype == INSERT) {
			r.key = (long)opnode.data;
			data.pop_back();
			data.push_back(r);
			jitd->insert(data);
		}
		if (opnode.optype == SELECT) {
			results = jitd->get((long)opnode.data, r);
		}
		i++;
	}

	gettimeofday(&end, NULL);

	std::cout << "Init JITD: " << total_time(start, end) << " us" << std::endl;
	printf("End\n");
	return 0;

}

