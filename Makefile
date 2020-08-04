
# General variables:

CC = g++
#CC = export LD_LIBRARY_PATH=/opt/intel/compilers_and_libraries_2020.0.166/linux/tbb/lib/intel64/gcc4.8; g++

#CFLAGS  = -g -Wall -std=c++14
#CFLAGS = -g -std=c++14 -pthread #-fwhole-program -flto -O2 # use -pthread, not -lpthread
CFLAGS = -g -std=c++11 -pthread -O2 #-fwhole-program -flto -O2 -DTBB_USE_THREADING_TOOLS

MAIN = jitd_harness.exe  # name of executable
TOASTER_INCLUDES = -I ../dbtoaster/lib/dbt_c++
INCLUDES = -I src/main/cpp/include -I target -I /opt/intel/compilers_and_libraries_2020.0.166/linux/tbb/include
TBB_LIBRARY = -L /opt/intel/compilers_and_libraries_2020.0.166/linux/tbb/lib/intel64/gcc4.8

SOURCE = src/main/cpp/source
HEADER = src/main/cpp/include

JITD_TEST_C = target/jitd_test.cpp
HARNESS_C = $(SOURCE)/harness.cpp
DATA_C = $(SOURCE)/data.cpp

JITD_TEST_H = target/jitd_test.hpp
RUNTIME_H = $(HEADER)/runtime.hpp
HARNESS_H = $(HEADER)/harness.hpp
CONF_H = $(HEADER)/conf.hpp

.PHONY:  clean

# Default parameters:
alloc = aligned
atomic = asal
delay = spin
thread = intel

ifeq (${alloc}, default)
shared_defines := -D DEFAULT_ALLOCATOR
endif
ifeq (${alloc}, aligned)
shared_defines := -D CACHE_ALIGNED_ALLOCATOR
endif

#shared_defines += -D TRANSFORM_COUNT  # Hardcoded
shared_defines += -D RDTSC  # Hardcoded

ifeq (${atomic}, asal)
jitd_defines := ${shared_defines} -D ATOMIC_STORE -D ATOMIC_LOAD
endif
ifeq (${atomic}, asralc)
jitd_defines := ${shared_defines} -D ATOMIC_STORE_RELEASE -D ATOMIC_LOAD_CONSUME
endif

ifeq (${delay}, block)
jitd_defines += -D BLOCK
endif
ifeq (${delay}, spin)
jitd_defines += -D SPIN
endif

ifeq (${thread}, pthread)
harness_defines := ${shared_defines} -D THREAD_PTHREAD
endif
ifeq (${thread}, intel)
harness_defines := ${shared_defines} -D THREAD_INTEL
endif


help:
	@echo alloc= thread= delay=
	@echo jitd defines:  [${jitd_defines}]
	@echo harness defines:  [${harness_defines}]

default: $(MAIN)
	@echo Build successful

jitd_storage_jitd:  jitd_${atomic}_${alloc}_${delay}.o harness_jitd_${alloc}_${thread}.o replay_jitd_${atomic}_${alloc}_${delay}.o harness_replay_jitd_${alloc}_${thread}.o replay_dbt_${atomic}_${alloc}_${delay}.o harness_replay_dbt_${alloc}_${thread}.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_${atomic}_${alloc}_${delay}.o harness_jitd_${alloc}_${thread}.o data.o $(TBB_LIBRARY) -ltbb
	$(CC) $(CFLAGS) -o replay_jitd.exe replay_jitd_${atomic}_${alloc}_${delay}.o harness_replay_jitd_${alloc}_${thread}.o data.o $(TBB_LIBRARY) -ltbb -D REPLAY_JITD
	$(CC) $(CFLAGS) -o replay_dbt.exe replay_dbt_${atomic}_${alloc}_${delay}.o harness_replay_dbt_${alloc}_${thread}.o data.o $(TBB_LIBRARY) -ltbb -D REPLAY_DBT
	@echo built with jitd storage with ${atomic} atomic, ${alloc} allocator, ${thread} thread, and ${delay} delay

jitd_storage_sqlite:  jitd_test.o harness_sqlite.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) jitd_test.o harness_sqlite.o data.o -lsqlite3
	@echo built with sqlite storage

jitd_storage_map:  harness_map.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) harness_map.o data.o
	@echo built with map storage

jitd_storage_uom:  harness_uom.o data.o
	$(CC) $(CFLAGS) -o $(MAIN) harness_uom.o data.o
	@echo built with unordered map storage


jitd_${atomic}_${alloc}_${delay}.o:  $(JITD_TEST_C) $(RUNTIME_H) $(JITD_TEST_H) $(HARNESS_H)
	$(CC) $(CFLAGS) -o jitd_${atomic}_${alloc}_${delay}.o -c $(JITD_TEST_C) $(INCLUDES) ${jitd_defines}

replay_jitd_${atomic}_${alloc}_${delay}.o:  $(JITD_TEST_C) $(RUNTIME_H) $(JITD_TEST_H) $(HARNESS_H)
	$(CC) $(CFLAGS) -o replay_jitd_${atomic}_${alloc}_${delay}.o -c $(JITD_TEST_C) $(INCLUDES) ${jitd_defines} -D REPLAY_JITD

replay_dbt_${atomic}_${alloc}_${delay}.o:  $(JITD_TEST_C) $(RUNTIME_H) $(JITD_TEST_H) $(HARNESS_H)
	$(CC) $(CFLAGS) -o replay_dbt_${atomic}_${alloc}_${delay}.o -c $(JITD_TEST_C) $(INCLUDES) $(TOASTER_INCLUDES) ${jitd_defines} -D REPLAY_DBT


harness_jitd_${alloc}_${thread}.o:  $(HARNESS_C) $(JITD_TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	$(CC) $(CFLAGS) -o harness_jitd_${alloc}_${thread}.o -c $(HARNESS_C) $(INCLUDES) ${harness_defines}

harness_replay_jitd_${alloc}_${thread}.o:  $(HARNESS_C) $(JITD_TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	$(CC) $(CFLAGS) -o harness_replay_jitd_${alloc}_${thread}.o -c $(HARNESS_C) $(INCLUDES) ${harness_defines} -D REPLAY_JITD

harness_replay_dbt_${alloc}_${thread}.o:  $(HARNESS_C) $(JITD_TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	$(CC) $(CFLAGS) -o harness_replay_dbt_${alloc}_${thread}.o -c $(HARNESS_C) $(INCLUDES) $(TOASTER_INCLUDES) ${harness_defines} -D REPLAY_DBT

harness_sqlite.o:  $(HARNESS_C) $(JITD_TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_SQLITE" > $(CONF_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_sqlite.o $(INCLUDES) -D THREAD_PTHREAD

harness_map.o:  $(HARNESS_C) $(JITD_TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_MAP" > $(CONF_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_map.o $(INCLUDES) -D THREAD_PTHREAD

harness_uom.o:  $(HARNESS_C) $(JITD_TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_UOM" > $(CONF_H)
	$(CC) $(CFLAGS) -c $(HARNESS_C) -o harness_uom.o $(INCLUDES) -D THREAD_PTHREAD


data.o:  $(DATA_C) $(HARNESS_H)
	$(CC) $(CFLAGS) -c $(DATA_C) $(INCLUDES)

clean: 
	$(RM) jitd_harness *.o *~ $(MAIN)

