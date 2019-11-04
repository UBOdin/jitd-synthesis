
#include <memory>
#include <thread>

#include <stdio.h>
#include <string.h>
#include <sys/time.h>
#include <unistd.h>

#include "jitd_test.hpp"
#include "test.hpp"
#include "harness.hpp"

double gettime_ms() {

	timeval now;

	gettimeofday(&now, NULL);

	return (now.tv_sec * 1000000.0 + now.tv_sec) / 1000.0;

}

int jitd_harness() {

	timeval start;
	timeval end;
	std::shared_ptr<JITD> jitd;
	std::vector<Record> data;
	Record r;
	int ms;
	int i;
	struct operation_node node;
	bool results;
	double time_base;
	double time_this;
	double time_next;
	double time_delta;

	printf("Starting\n");
	gettimeofday(&start, NULL);

	// Initialize bare jitds structure:
	jitd = std::shared_ptr<JITD>(new JITD(new ArrayNode(data)));

	// Init data template to push:
	r.key = -9999999;  // dummy init key; will be popped later
	r.value = (Value)0xDEADBEEF;
	data.push_back(r);

	time_base = gettime_ms();

	i = 0;
	while (true) {
//		printf("iteration %d\n", i);
		node = operation_array[i];
		if (node.type == STOP) {
			break;
		}
		if (node.type == INSERT) {
			r.key = node.data.key;
			data.pop_back();
			data.push_back(r);
			jitd->insert(data);
		}
		if (node.type == SELECT) {
			results = jitd->get(node.data.key, r);
		}

//		i++; // Advance to time frame  TODO:  failsafe this is the case
		time_next = time_base + node.data.time;

/*
		while (true) {
			results = jitd->do_organize();
			if (results == false) {
				break;
			}
			if (gettime_ms() >= time_next) {
				break;
			}
		}
		if (gettime_ms() < time_next) {
			ms = time_next - gettime_ms();
			std::this_thread::sleep_for(std::chrono::milliseconds(ms));
		}
*/

/*
		if (node.type == TIME) {
			time_this = node.data.time;
			time_delta = time_this - time_base;
			printf("Time:  %f, %f\n", time_this, time_delta);
			ms = (node.data.time - time_base) * 1000;  // Adjust delay to taste
//			std::this_thread::sleep_for(std::chrono::milliseconds(ms));
			time_base = time_this;
		}
*/

		i++;
	}

	gettimeofday(&end, NULL);

	std::cout << "Init JITD: " << total_time(start, end) << " us" << std::endl;
	printf("End\n");
	return 0;

}

