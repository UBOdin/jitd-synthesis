
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

jitd_storage_jitd:  replay_set_${atomic}_${alloc}_${delay}.o replay_view_${atomic}_${alloc}_${delay}.o replay_dbt_${atomic}_${alloc}_${delay}.o harness_replay_set_${alloc}_${thread}.o harness_replay_view_${alloc}_${thread}.o harness_replay_dbt_${alloc}_${thread}.o
	$(CC) $(CFLAGS) -o replay_set.exe replay_set_${atomic}_${alloc}_${delay}.o harness_replay_set_${alloc}_${thread}.o $(TBB_LIBRARY) -ltbb -D REPLAY_JITD -D REPLAY_SET
	$(CC) $(CFLAGS) -o replay_view.exe replay_view_${atomic}_${alloc}_${delay}.o harness_replay_view_${alloc}_${thread}.o $(TBB_LIBRARY) -ltbb -D REPLAY_JITD -D REPLAY_VIEW
	$(CC) $(CFLAGS) -o replay_dbt.exe replay_dbt_${atomic}_${alloc}_${delay}.o harness_replay_dbt_${alloc}_${thread}.o $(TBB_LIBRARY) -ltbb -D REPLAY_DBT -D REPLAY_VIEW
	@echo built with jitd storage with ${atomic} atomic, ${alloc} allocator, ${thread} thread, and ${delay} delay


replay_set_${atomic}_${alloc}_${delay}.o:  $(JITD_TEST_C) $(RUNTIME_H) $(JITD_TEST_H) $(HARNESS_H)
	$(CC) $(CFLAGS) -o replay_set_${atomic}_${alloc}_${delay}.o -c $(JITD_TEST_C) $(INCLUDES) ${jitd_defines} -D REPLAY_JITD -D REPLAY_SET

replay_view_${atomic}_${alloc}_${delay}.o:  $(JITD_TEST_C) $(RUNTIME_H) $(JITD_TEST_H) $(HARNESS_H)
	$(CC) $(CFLAGS) -o replay_view_${atomic}_${alloc}_${delay}.o -c $(JITD_TEST_C) $(INCLUDES) ${jitd_defines} -D REPLAY_JITD -D REPLAY_VIEW

replay_dbt_${atomic}_${alloc}_${delay}.o:  $(JITD_TEST_C) $(RUNTIME_H) $(JITD_TEST_H) $(HARNESS_H) toaster_harness/toaster_maintenance.hpp
	$(CC) $(CFLAGS) -o replay_dbt_${atomic}_${alloc}_${delay}.o -c $(JITD_TEST_C) $(INCLUDES) $(TOASTER_INCLUDES) ${jitd_defines} -D REPLAY_DBT -D REPLAY_VIEW


harness_replay_set_${alloc}_${thread}.o:  $(HARNESS_C) $(JITD_TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	$(CC) $(CFLAGS) -o harness_replay_set_${alloc}_${thread}.o -c $(HARNESS_C) $(INCLUDES) ${harness_defines} -D REPLAY_JITD -D REPLAY_SET

harness_replay_view_${alloc}_${thread}.o:  $(HARNESS_C) $(JITD_TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	$(CC) $(CFLAGS) -o harness_replay_view_${alloc}_${thread}.o -c $(HARNESS_C) $(INCLUDES) ${harness_defines} -D REPLAY_JITD -D REPLAY_VIEW

harness_replay_dbt_${alloc}_${thread}.o:  $(HARNESS_C) $(JITD_TEST_H) $(HARNESS_H)
	@echo "#define STORAGE_JITD" > $(CONF_H)
	$(CC) $(CFLAGS) -o harness_replay_dbt_${alloc}_${thread}.o -c $(HARNESS_C) $(INCLUDES) $(TOASTER_INCLUDES) ${harness_defines} -D REPLAY_DBT -D REPLAY_VIEW


clean: 
	$(RM) jitd_harness *.o *~ $(MAIN)

