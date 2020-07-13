
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "toaster_maintenance.hpp"

#include "program_base.cpp"
#include "event.cpp"
#include "runtime.cpp"
#include "streams.cpp"
#include "iprogram.cpp"
#include "standard_adaptors.cpp"
#include "smhasher/MurmurHash2.cpp"

#include "harness.hpp"


// Copied from jitd_test.hpp:
typedef enum {

    JITD_NODE_DeleteSingleton,

    JITD_NODE_DeleteElements,

    JITD_NODE_BTree,

    JITD_NODE_Concat,

    JITD_NODE_SortedArray,

    JITD_NODE_Array,

    JITD_NODE_Singleton,

} JITDNodeType;


int ticks_count = 0;
struct ticks_node ticks_array[TICKS_SIZE];



// Copied from jitd_test.cpp:
inline uint64_t rdtsc() {

	unsigned int lo;
	unsigned int hi;

	__asm__ __volatile__ ("rdtsc" : "=a" (lo), "=d" (hi));

	return ((uint64_t)hi << 32) | lo;

}


// Copied from harness.cpp:
#define errtrap(error) (__errtrap(result, error, __LINE__))
void __errtrap(int result, const char* error, int line) {

	if (result == -1) {
		printf("Error in %s() on line %d:  %s\n", error, line, strerror(errno));
		_exit(errno);
	}

	return;

}


// Copied from harness.cpp:
int save_output() {

	#define BUFFER_SIZE 256

	int result;
	char output_buffer[BUFFER_SIZE];
	int charcount;

	// Save out view performance data:
	int view_fd;
	char view_filename[] = "toaster_view_performance.txt";

	// failsafe:
	if (ticks_count > TICKS_SIZE) {
		printf("Error:  view output overflow:  %d > %d\n", ticks_count, TICKS_SIZE);
		_exit(1);
	}

	result = open(view_filename, O_CREAT | O_RDWR | O_TRUNC, 0666);
	errtrap("open");
	view_fd = result;

	for (int i = 0; i < ticks_count; i++) {
		charcount = 0;
		result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "%d\t%d", ticks_array[i].id, ticks_array[i].maint_type);
		charcount += result;
		for (int j = 0; j < 3; j++) {
			result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "\t%d", ticks_array[i].delta[j]);
			charcount += result;
		}
		result = snprintf(output_buffer + charcount, BUFFER_SIZE - charcount, "\n");
		charcount += result;
		result = write(view_fd, output_buffer, strnlen(output_buffer, BUFFER_SIZE));
		errtrap("write");
	}

	close(view_fd);
	return 0;

}


inline void populate_node(char* line, size_t buffer, struct maint_node* node) {

	char* token;
	char* save;
	const char delim[] = ",";

	// Basic sanity:  are we using the correct delimiter?
	token = strstr(line, delim);
	if (token == NULL) {
		printf("Error:  invalid delimiter\n");
		_exit(1);
	}

	token = strtok_r(line, delim, &save);
	node->maint_id = atoi(token);
	token = strtok_r(NULL, delim, &save);
	node->ticks_id = atoi(token);
	token = strtok_r(NULL, delim, &save);
	node->rw = atoi(token);
	token = strtok_r(NULL, delim, &save);
	node->maint_type = atoi(token);
	token = strtok_r(NULL, delim, &save);
	node->node_type = atoi(token);
	token = strtok_r(NULL, delim, &save);
	node->node_self = strtoul(token, NULL, 0);
	token = strtok_r(NULL, delim, &save);
	node->node_parent = strtoul(token, NULL, 0);
	token = strtok_r(NULL, delim, &save);
	node->node_child = strtoul(token, NULL, 0);
	token = strtok_r(NULL, delim, &save);
	node->node_left = strtoul(token, NULL, 0);
	token = strtok_r(NULL, delim, &save);
	node->node_right = strtoul(token, NULL, 0);
	token = strtok_r(NULL, delim, &save);
	node->value = strtol(token, NULL, 0);

	return;

}


namespace dbtoaster { class Custom_toaster : public Program {


	public:

	Custom_toaster(int argc = 0, char* argv[] = 0) : Program(argc, argv) { }


	//void (*ptr_array[])(void) = { on_insert_BTREE };
//	void (data_t::*bletch)(const long, const long, const long) = &data_t::on_insert_SINGLETON;
	void (data_t::*bletch)(void) = (void (data_t::*)(void))&data_t::on_insert_SINGLETON;

	void foo() {

		data.on_insert_SINGLETON(1, 2, 3);

		this->init();

	}


int maintain_view_block(struct maint_node* node_array, int node_array_size) {

	int rw;
	int type;
	unsigned long id;
	unsigned long self;
	unsigned long time_start;
	unsigned long time_delta;

	time_start = rdtsc();

	for (int i = 0; i < node_array_size; i++) {

		rw = node_array[i].rw;
		type = node_array[i].node_type;
		id = 0; // node_array[i].maint_id;
		self = node_array[i].node_self;

//printf("Node rw %d type %d\n", rw, type);


		if (rw == 1) {

			if (type == JITD_NODE_DeleteSingleton) {
				data.on_insert_DELETESINGLETON(id, self, node_array[i].node_child, node_array[i].value);
			} else if (type == JITD_NODE_DeleteElements) {
				goto err_missing_node;
			} else if (type == JITD_NODE_BTree) {
				data.on_insert_BTREE(id, self, node_array[i].node_left, node_array[i].node_right, node_array[i].value);
			} else if (type == JITD_NODE_Concat) {
				data.on_insert_CONCAT(id, self, node_array[i].node_left, node_array[i].node_right);
			} else if (type == JITD_NODE_SortedArray) {
				goto err_missing_node;
			} else if (type == JITD_NODE_Array) {
				data.on_insert_ARRAY(id, self, node_array[i].value);
			} else if (type == JITD_NODE_Singleton) {
				data.on_insert_SINGLETON(id, self, node_array[i].value);
			}

		} else if (rw == 0) {

			if (type == JITD_NODE_DeleteSingleton) {
				data.on_delete_DELETESINGLETON(id, self, node_array[i].node_child, node_array[i].value);
			} else if (type == JITD_NODE_DeleteElements) {
				goto err_missing_node;
			} else if (type == JITD_NODE_BTree) {
				data.on_delete_BTREE(id, self, node_array[i].node_left, node_array[i].node_right, node_array[i].value);
			} else if (type == JITD_NODE_Concat) {
				data.on_delete_CONCAT(id, self, node_array[i].node_left, node_array[i].node_right);
			} else if (type == JITD_NODE_SortedArray) {
				goto err_missing_node;
			} else if (type == JITD_NODE_Array) {
				data.on_delete_ARRAY(id, self, node_array[i].value);
			} else if (type == JITD_NODE_Singleton) {
				data.on_delete_SINGLETON(id, self, node_array[i].value);
			}

		}


	}

	time_delta = rdtsc() - time_start;

	if (ticks_count >= TICKS_SIZE) {
		printf("Error:  view overflow\n");
		_exit(1);
	}
	ticks_array[ticks_count].id = ticks_count;
	ticks_array[ticks_count].maint_type = node_array[0].maint_type;  // maintenance type should be the same for the entire block
	ticks_array[ticks_count].delta[0] = time_delta;  // Sum of both erase / add
	ticks_array[ticks_count].delta[1] = 0;
	ticks_array[ticks_count].delta[2] = 0;
	ticks_count++;

	return 0;

    err_missing_node:
	printf("Error:  unsupported node type\n");
	_exit(1);

}


int process_input() {

	FILE* input_stream;
	char input_file[] = "maintenance_input.csv";
	int result;
	ssize_t chars_read;
	char* line_buffer = NULL;
	size_t buffer_size = 0;
	int i = 0;
	struct maint_node node_array[16];
	int node_index = 0;
	int ticks_id_curr = 0;

	input_stream = fopen(input_file, "r");
	if (input_stream == NULL) {
		printf("Error:  opening input file\n");
		_exit(1);
	}

	line_buffer = NULL;
	buffer_size = 0;
	i = -1;
	// Skip first line (jitd structure creation):
	chars_read = getline(&line_buffer, &buffer_size, input_stream);

	while (1) {
		i++;

/*
if (i == 300) {
	break;
}
*/

		chars_read = getline(&line_buffer, &buffer_size, input_stream);
		if (chars_read == -1) {
			break;
		}

		populate_node(line_buffer, buffer_size, &node_array[node_index]);

		// Check whether the last line read is part of the current or a new maintenance operation block:
		if (node_array[node_index].ticks_id == ticks_id_curr) {
//printf("Increment from %d on maint_id %d\n", node_index, node_array[node_index].maint_id);
			node_index++;
			if (node_index >= 16) {
				printf("Error:  node overflow\n");
				_exit(1);
			}
		} else {
//printf("Block size %d at iter %d and maint_id %d\n", node_index, i, node_array[node_index].maint_id);

			maintain_view_block(node_array, node_index);

			// We have read the first line in a new block.  Save the id of the new block:
			ticks_id_curr = node_array[node_index].ticks_id;
			// The last node that was saved is actually the first node in the next block.
			// Move it to the first node (i.e. 0) and reset index to 1 (i.e. the next vacant spot in array):
			node_array[0] = node_array[node_index];
			node_index = 1;
		}

	}
	maintain_view_block(node_array, node_index);


	free(line_buffer);
	fclose(input_stream);

printf("Lines read:  %d\n", i);

	save_output();

	return 0;

}



};  }


int main(int argc, char** argv) {

	printf("Hello world\n");

	dbtoaster::Custom_toaster ct(argc, argv);

	ct.init();

	ct.process_input();

	return 0;

}

