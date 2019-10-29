
# General variables:

CC = g++
#CFLAGS  = -g -Wall -std=c++14
CFLAGS = -g -std=c++14
MAIN = jitd_harness  # name of executable
INCLUDES = -I src/main/cpp/include -I target

.PHONY:  clean

# N.b make sans arguments runs first target, i.e. below:

default: $(MAIN)
	@echo Build successful

jitd_harness:  jitd_tester.o jitd_test.o harness.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_tester.o jitd_test.o harness.o

jitd_tester.o:  src/main/cpp/source/jitd_tester.cpp
	$(CC) $(CFLAGS) -c src/main/cpp/source/jitd_tester.cpp $(INCLUDES)

jitd_test.o:  target/jitd_test.cpp
	$(CC) $(CFLAGS) -c target/jitd_test.cpp $(INCLUDES)

harness.o:  src/main/cpp/source/harness.cpp
	$(CC) $(CFLAGS) -c src/main/cpp/source/harness.cpp $(INCLUDES)

clean: 
	$(RM) jitd_harness *.o *~ $(MAIN)

foobar:
	@echo THis is s atest
