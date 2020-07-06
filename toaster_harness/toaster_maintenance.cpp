
#include <stdio.h>
#include <stdlib.h>

#include "toaster_maintenance.hpp"

#include "program_base.cpp"
#include "event.cpp"
#include "runtime.cpp"
#include "streams.cpp"
#include "iprogram.cpp"
#include "standard_adaptors.cpp"
#include "smhasher/MurmurHash2.cpp"


int process_input() {

	FILE* input_stream;
	char input_file[] = "maintenance_input.csv";
	int result;
	ssize_t chars_read;
	char* line_buffer = NULL;
	size_t buffer_size = 0;
	int i = 0;

	input_stream = fopen(input_file, "r");
	if (input_stream == NULL) {
		printf("Error:  opening input file\n");
		_exit(1);
	}

	line_buffer = NULL;
	buffer_size = 0;
	i = 0;
	while (1) {

		chars_read = getline(&line_buffer, &buffer_size, input_stream);
		if (chars_read == -1) {
			break;
		}

		i++;

	}

	free(line_buffer);
	fclose(input_stream);

printf("Lines read:  %d\n", i);

	return 0;

}


int main(int argc, char** argv) {

	printf("Hello world\n");

	dbtoaster::Program p(argc, argv);

	p.init();

	process_input();

	return 0;

}

