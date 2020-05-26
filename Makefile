
# General variables:

CC = g++
#CC = export LD_LIBRARY_PATH=/opt/intel/compilers_and_libraries_2020.0.166/linux/tbb/lib/intel64/gcc4.8; g++

#CFLAGS  = -g -Wall -std=c++14
#CFLAGS = -g -std=c++14 -pthread #-fwhole-program -flto -O2 # use -pthread, not -lpthread
CFLAGS = -g -std=c++14 -pthread #-fwhole-program -flto -O2 -DTBB_USE_THREADING_TOOLS

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

quick:  jitd_test.o
	$(CC) $(CFLAGS) -o quick.exe $(SOURCE)/quick.cpp $(JITD_TEST_C) $(INCLUDES) $(TBB_LIBRARY) -ltbb
	@echo quick build

jitd_allatonce:
	@echo "#define STORAGE_JITD" > $(CONF_H)
	$(CC) $(CFLAGS) -o $(MAIN) $(JITD_TEST_C) $(HARNESS_C) $(DATA_C) $(INCLUDES) $(TBB_LIBRARY) -ltbb
	
jitd_storage_jitd:  jitd_test.o harness_jitd.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_test.o harness_jitd.o data.o $(TBB_LIBRARY) -ltbb
	@echo built with jitd storage

jitd_storage_asal_aligned_pthread:  jitd_asal_aligned.o harness_jitd_aligned_pthread.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_asal_aligned.o harness_jitd_aligned_pthread.o data.o $(TBB_LIBRARY) -ltbb
	@echo built with jitd storage with asal allocator and pthread threading

jitd_storage_asal_aligned_intel:  jitd_asal_aligned.o harness_jitd_aligned_intel.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_asal_aligned.o harness_jitd_aligned_intel.o data.o $(TBB_LIBRARY) -ltbb
	@echo built with jitd storage with asal allocator and intel threading

jitd_storage_asal_default_pthread:  jitd_asal_default.o harness_jitd_default_pthread.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_asal_default.o harness_jitd_default_pthread.o data.o $(TBB_LIBRARY) -ltbb
	@echo built with jitd storage with default allocator and pthread threading

jitd_storage_asal_default_intel:  jitd_asal_default.o harness_jitd_default_intel.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_asal_default.o harness_jitd_default_intel.o data.o $(TBB_LIBRARY) -ltbb
	@echo built with jitd storage with default allocator and intel thread


jitd_storage_sqlite:  jitd_test.o harness_sqlite.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_test.o harness_sqlite.o data.o -lsqlite3
	@echo built with sqlite storage

jitd_storage_map:  harness_map.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) harness_map.o data.o
	@echo built with map storage

jitd_storage_uom:  harness_uom.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) harness_uom.o data.o
	@echo built with unordered map storage

jitd_test.o:  $(JITD_TEST_C) $(RUNTIME_H) $(JITD_TEST_H)
	$(CC) $(CFLAGS) -c $(JITD_TEST_C) $(INCLUDES)


jitd_asal_aligned.o:  $(JITD_TEST_C) $(RUNTIME_H) $(JITD_TEST_H)
	#$(CC) $(CFLAGS) -o jitd_asal_aligned.o -c $(JITD_TEST_C) $(INCLUDES) -D ATOMIC_STORE -D ATOMIC_LOAD -D CACHE_ALIGNED_ALLOCATOR
	$(CC) $(CFLAGS) -o jitd_asal_aligned.o -c $(JITD_TEST_C) $(INCLUDES) -D ATOMIC_STORE -D ATOMIC_LOAD -D CACHE_ALIGNED_ALLOCATOR -D TRANSFORM_COUNT

jitd_asal_default.o:  $(JITD_TEST_C) $(RUNTIME_H) $(JITD_TEST_H)
	#$(CC) $(CFLAGS) -o jitd_asal_default.o -c $(JITD_TEST_C) $(INCLUDES) -D ATOMIC_STORE -D ATOMIC_LOAD -D DEFAULT_ALLOCATOR
	$(CC) $(CFLAGS) -o jitd_asal_default.o -c $(JITD_TEST_C) $(INCLUDES) -D ATOMIC_STORE -D ATOMIC_LOAD -D DEFAULT_ALLOCATOR -D TRANSFORM_COUNT


harness_jitd.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	#$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_jitd.o $(INCLUDES)

harness_jitd_aligned_pthread.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	#$(CC) $(CFLAGS) -o harness_jitd_aligned_pthread.o -c $(HARNESS_C) $(INCLUDES) -D CACHE_ALIGNED_ALLOCATOR -D THREAD_PTHREAD
	$(CC) $(CFLAGS) -o harness_jitd_aligned_pthread.o -c $(HARNESS_C) $(INCLUDES) -D CACHE_ALIGNED_ALLOCATOR -D THREAD_PTHREAD -D TRANSFORM_COUNT

harness_jitd_aligned_intel.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	#$(CC) $(CFLAGS) -o harness_jitd_aligned_intel.o -c $(HARNESS_C) $(INCLUDES) -D CACHE_ALIGNED_ALLOCATOR -D THREAD_INTEL
	$(CC) $(CFLAGS) -o harness_jitd_aligned_intel.o -c $(HARNESS_C) $(INCLUDES) -D CACHE_ALIGNED_ALLOCATOR -D THREAD_INTEL -D TRANSFORM_COUNT

harness_jitd_default_pthread.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	#$(CC) $(CFLAGS) -o harness_jitd_default_pthread.o -c $(HARNESS_C) $(INCLUDES) -D DEFAULT_ALLOCATOR -D THREAD_PTHREAD
	$(CC) $(CFLAGS) -o harness_jitd_default_pthread.o -c $(HARNESS_C) $(INCLUDES) -D DEFAULT_ALLOCATOR -D THREAD_PTHREAD -D TRANSFORM_COUNT

harness_jitd_default_intel.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	#$(CC) $(CFLAGS) -o harness_jitd_default_intel.o -c $(HARNESS_C) $(INCLUDES) -D DEFAULT_ALLOCATOR -D THREAD_INTEL
	$(CC) $(CFLAGS) -o harness_jitd_default_intel.o -c $(HARNESS_C) $(INCLUDES) -D DEFAULT_ALLOCATOR -D THREAD_INTEL -D TRANSFORM_COUNT


harness_sqlite.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_SQLITE" > $(CONF_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_sqlite.o $(INCLUDES)

harness_map.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_MAP" > $(CONF_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_map.o $(INCLUDES)

harness_uom.o:  $(HARNESS_C) $(JITD_TEST_H) $(TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_UOM" > $(CONF_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_uom.o $(INCLUDES)

data.o:  $(DATA_C) $(HARNESS_H)
	$(CC) $(CFLAGS) -c $(DATA_C) $(INCLUDES)

clean: 
	$(RM) jitd_harness *.o *~ $(MAIN)

