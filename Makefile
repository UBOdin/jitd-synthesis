
# General variables:

CC = g++
#CC = export LD_LIBRARY_PATH=/opt/intel/compilers_and_libraries_2020.0.166/linux/tbb/lib/intel64/gcc4.8; g++

#CFLAGS  = -g -Wall -std=c++14
CFLAGS = -g -std=c++14 -pthread #-fwhole-program -flto -O2 # use -pthread, not -lpthread

MAIN = jitd_harness.exe  # name of executable
INCLUDES = -I src/main/cpp/include -I target -I /opt/intel/compilers_and_libraries_2020.0.166/linux/tbb/include
TBB_LIBRARY = -L /opt/intel/compilers_and_libraries_2020.0.166/linux/tbb/lib/intel64/gcc4.8

SOURCE = src/main/cpp/source
HEADER = src/main/cpp/include

JITD_TEST_C = target/jitd_test.cpp
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

jitd_allatonce:
	@echo "#define STORAGE_JITD" > $(CONF_H)
	$(CC) $(CFLAGS) -o $(MAIN) $(JITD_TEST_C) $(HARNESS_C) $(DATA_C) $(INCLUDES) $(TBB_LIBRARY) -ltbb
	
jitd_harness:  jitd_test.o harness.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_test.o harness.o data.o -lsqlite3

jitd_storage_jitd:  jitd_test.o harness_jitd.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_test.o harness_jitd.o data.o $(TBB_LIBRARY) -ltbb
	@echo built with jitd storage

jitd_storage_sqlite:  jitd_test.o harness_sqlite.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_test.o harness_sqlite.o data.o -lsqlite3
	@echo built with sqlite storage

jitd_storage_uomap:  harness_uomap.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) harness_uomap.o data.o
	@echo built with uomap storage

jitd_test.o:  $(JITD_TEST_C) $(RUNTIME_H) $(JITD_TEST_H)
	$(CC) $(CFLAGS) -c $(JITD_TEST_C) $(INCLUDES)

harness.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) $(INCLUDES)

harness_jitd.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_jitd.o $(INCLUDES)

harness_sqlite.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_SQLITE" > $(CONF_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_sqlite.o $(INCLUDES)

harness_uomap.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_UOMAP" > $(CONF_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_uomap.o $(INCLUDES)

data.o:  $(DATA_C) $(HARNESS_H)
	$(CC) $(CFLAGS) -c $(DATA_C) $(INCLUDES)

clean: 
	$(RM) jitd_harness *.o *~ $(MAIN)

