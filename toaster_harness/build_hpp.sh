
#/../../dbtoaster/bin/dbtoaster toaster_maintenance.sql -l cpp -o toaster_maintenance.hpp
#/../../dbtoaster/bin/dbtoaster toaster_maintenance.sql -l cpp -o toaster_maintenance.hpp -O3 --FEXPRESSIVE-TLQS --batch
../../dbtoaster/bin/dbtoaster toaster_maintenance.sql -l cpp -o toaster_maintenance.hpp -O3 --FEXPRESSIVE-TLQS #--batch
../../dbtoaster/bin/dbtoaster toaster_maintenance.sql -l cpp -o classic_maintenance.hpp -O3 --depth 1 --FEXPRESSIVE-TLQS #--batch
#/../../dbtoaster/bin/dbtoaster toaster_maintenance.sql -l m3 -o toaster_maintenance.m3 -O3 --FEXPRESSIVE-TLQS #--batch

