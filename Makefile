CC = g++ 
#CFLAGS  = -g -Wall -std=c++14
INCLUDES = /home/csgrad/dbalakri/tbbsrc/tbb-tbb_2020/include
TBB_REF_LIB = /home/csgrad/dbalakri/tbbsrc/tbb-tbb_2020/build/linux_intel64_gcc_cc5.4.0_libc2.23_kernel4.4.0_release
#CTBBFLAGS = -g -I$INCLUDES -Wl,-rpath,$TBB_REF_LIB -L$TBB_REF_LIB -ltbb -pthread -std=c++11
CFLAGS = -g -ltbb -pthread -std=c++11 -DDEBUG
#"-ltbb","-std=c++11"

# N.b make sans arguments runs first target, i.e. below:

default: jitd_standalone

jitd_standalone:  jitd_tester.o jitd_test.o
	$(CC) $(CFLAGS) -o jitd_standalone jitd_tester.o jitd_test.o #-I${INCLUDES} -Wl,-rpath,${TBB_REF_LIB} -L${TBB_REF_LIB} -ltbb

jitd_tester.o:  src/main/cpp/source/jitd_tester.cpp src/main/cpp/include/test.hpp target/jitd_test.hpp
	$(CC) $(CFLAGS) -c src/main/cpp/source/jitd_tester.cpp -I src/main/cpp/include -I target #-I${INCLUDES}

jitd_test.o:  target/jitd_test.cpp src/main/cpp/include/runtime.hpp target/jitd_test.hpp
	$(CC) $(CFLAGS) -c target/jitd_test.cpp -I src/main/cpp/include -I target #-I${INCLUDES}

clean: 
	$(RM) jitd_harness *.o *~
