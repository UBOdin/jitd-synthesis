
# General variables:

CC = g++
#CFLAGS  = -g -Wall -std=c++14
CFLAGS = -g -std=c++14

# N.b make sans arguments runs first target, i.e. below:

default: jitd_standalone

jitd_standalone:  jitd_tester.o jitd_test.o
	$(CC) $(CFLAGS) -o jitd_standalone jitd_tester.o jitd_test.o

jitd_tester.o:  src/main/cpp/source/jitd_tester.cpp src/main/cpp/include/test.hpp target/jitd_test.hpp
	$(CC) $(CFLAGS) -c src/main/cpp/source/jitd_tester.cpp -I src/main/cpp/include -I target

jitd_test.o:  target/jitd_test.cpp src/main/cpp/include/runtime.hpp target/jitd_test.hpp
	$(CC) $(CFLAGS) -c target/jitd_test.cpp -I src/main/cpp/include -I target

clean: 
	$(RM) jitd_harness *.o *~

