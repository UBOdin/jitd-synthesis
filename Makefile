
# General variables:

CC = g++
#CFLAGS  = -g -Wall -std=c++14
CFLAGS = -g -std=c++14

# N.b make sans arguments runs first target, i.e. below:

default: jitd_harness

jitd_harness:  jitd_tester.o jitd_test.o input.o
	$(CC) $(CFLAGS) -o jitd_harness jitd_tester.o jitd_test.o input.o

jitd_tester.o:  src/main/cpp/source/jitd_tester.cpp src/main/cpp/include/test.hpp target/jitd_test.hpp
	$(CC) $(CFLAGS) -c src/main/cpp/source/jitd_tester.cpp -I src/main/cpp/include -I target

jitd_test.o:  target/jitd_test.cpp src/main/cpp/include/runtime.hpp target/jitd_test.hpp
	$(CC) $(CFLAGS) -c target/jitd_test.cpp -I src/main/cpp/include -I target

input.o:  src/main/cpp/source/input.cpp
	$(CC) $(CFLAGS) -c src/main/cpp/source/input.cpp -I src/main/cpp/include

clean: 
	$(RM) jitd_harness *.o *~

