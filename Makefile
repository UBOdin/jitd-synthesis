
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

JITD_TEST_H = target/jitd_test.hpp
RUNTIME_H = $(HEADER)/runtime.hpp
TEST_H = $(HEADER)/test.hpp
HARNESS_H = $(HEADER)/harness.hpp

.PHONY:  clean

# N.b make sans arguments runs first target, i.e. below:

default: $(MAIN)
	@echo Build successful

jitd_harness:  jitd_tester.o jitd_test.o harness.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_tester.o jitd_test.o harness.o

jitd_test.o:  $(JITD_TEST_C) $(JITD_TEST_H) $(RUNTIME_H)
	$(CC) $(CFLAGS) -c $(JITD_TEST_C) $(INCLUDES)

jitd_tester.o:  $(JITD_TESTER_C) $(JITD_TEST_H) $(HARNESS_H) $(JITD_TEST_H)
	$(CC) $(CFLAGS) -c $(JITD_TESTER_C) $(INCLUDES)

harness.o:  $(HARNESS_C) $(HARNESS_H) $(JITD_TEST_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) $(INCLUDES)

clean: 
	$(RM) jitd_harness *.o *~ $(MAIN)

foobar:
	@echo THis is s atest
