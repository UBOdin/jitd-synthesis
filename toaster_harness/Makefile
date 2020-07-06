
# General variables:

CC = g++

CFLAGS = -g -std=c++11 -O2

MAIN = toaster_harness.exe  # name of executable
INCLUDES = -I ../../../dbtoaster/lib/dbt_c++

#SOURCE = .
#HEADER = .

.PHONY:  clean


default:  toaster_harness
	@echo Build successful

toaster_harness:  toaster_maintenance.cpp toaster_maintenance.hpp
	$(CC) $(CFLAGS) -o $(MAIN) toaster_maintenance.cpp $(INCLUDES) 

clean: 
	$(RM) jitd_harness *.o *~ $(MAIN)

