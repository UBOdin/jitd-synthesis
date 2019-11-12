
# General variables:

CC = g++
#CFLAGS  = -g -Wall -std=c++14
CFLAGS = -g -std=c++14
MAIN = jitd_harness  # name of executable
INCLUDES = -I src/main/cpp/include -I target

SOURCE = src/main/cpp/source
HEADER = src/main/cpp/include

JITD_TEST_C = target/jitd_test.cpp
JITD_TESTER_C = $(SOURCE)/jitd_tester.cpp
HARNESS_C = $(SOURCE)/harness.cpp
DATA_C = $(SOURCE)/data.cpp

JITD_TEST_H = target/jitd_test.hpp
RUNTIME_H = $(HEADER)/runtime.hpp
TEST_H = $(HEADER)/test.hpp
HARNESS_H = $(HEADER)/harness.hpp
CONF_H = $(HEADER)/conf.hpp

.PHONY:  clean

# N.b make sans arguments runs first target, i.e. below:

default: $(MAIN)
	@echo Build successful

jitd_harness:  jitd_tester.o jitd_test.o harness.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_tester.o jitd_test.o harness.o data.o -lsqlite3

jitd_storage_jitd:  jitd_tester.o jitd_test.o harness_jitd.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_tester.o jitd_test.o harness_jitd.o data.o
	@echo built with jitd storage

jitd_storage_sqlite:  jitd_tester.o jitd_test.o harness_sqlite.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_tester.o jitd_test.o harness_sqlite.o data.o -lsqlite3
	@echo built with sqlite storage

jitd_test.o:  $(JITD_TEST_C) $(RUNTIME_H) $(JITD_TEST_H)
	$(CC) $(CFLAGS) -c $(JITD_TEST_C) $(INCLUDES)

jitd_tester.o:  $(JITD_TESTER_C) $(TEST_H) $(JITD_TEST_H) $(HARNESS_H)
	$(CC) $(CFLAGS) -c $(JITD_TESTER_C) $(INCLUDES)

harness.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) $(INCLUDES)

harness_jitd.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_jitd.o $(INCLUDES)

harness_sqlite.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_SQLITE" > $(CONF_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_sqlite.o $(INCLUDES)

data.o:  $(DATA_C) $(HARNESS_H)
	$(CC) $(CFLAGS) -c $(DATA_C) $(INCLUDES)

clean: 
	$(RM) jitd_harness *.o *~ $(MAIN)

