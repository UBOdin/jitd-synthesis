
# General variables:

CC = g++

CFLAGS = -g -std=c++11 -O3

MAIN = toaster_harness.exe  # name of executable
TOASTER_PATH = ../../dbtoaster/lib/dbt_c++
HARNESS_H_PATH = ../src/main/cpp/include
INCLUDES = -I $(TOASTER_PATH) -I $(HARNESS_H_PATH)

#SOURCE = .
#HEADER = .

.PHONY:  clean


default:  toaster_harness
	@echo Build successful

toaster_harness:  toaster_maintenance.cpp toaster_maintenance.hpp $(HARNESS_H_PATH)/harness.hpp
	$(CC) $(CFLAGS) -o $(MAIN) toaster_maintenance.cpp $(INCLUDES) 

clean: 
	$(RM) jitd_harness *.o *~ $(MAIN)

