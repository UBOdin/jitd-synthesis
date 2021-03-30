import numpy as np
import re
import pathlib
import os
# When generating for mjolnir
# Change
# csv_file
# scala_write_file
# output_command
# scala_file_path
# shell_file


# Generate all create table commands from schema.sql.
createtablefile = "../tpch/schema.sql"
createcount = 0
create_table_commands = []
with open(createtablefile) as fp:
	lines = fp.readlines()
	for line in lines:
		if "CREATE TABLE" in line:
			line = line.rstrip()
			table_line = line
			table = table_line.split('CREATE TABLE', maxsplit=1)[-1].split(maxsplit=1)[0]
			# csv_file = "/Users/darshanabalakrishnan/Desktop/Spark_Scratch/tpch/tpch_table/"+table+".tbl"
			csv_file = "/home/csgrad/dbalakri/Spark_scratch/tpch/tpch_table/"+table+".csv"
			csv_path = " USING csv OPTIONS(path \'"+csv_file+"\', delimiter \'|\')"
			create_table_commands.append("spark.sql(\""+line+csv_path+ "\")\n")
			createcount += 1
print(len(create_table_commands))
print(create_table_commands[0])

# Generate proper sql commands for spark
sqlcount = 0
file_names = []
sql_commands = []
for path in pathlib.Path("../tpch/tpch_queries").iterdir():
    if path.is_file():
        current_file = open(path, "r")
        file_name = current_file.name
        file_name = file_name.replace("../tpch/tpch_queries/","")
        file_name = file_name.replace(".sql","")
        file_names.append(file_name)
        lines = current_file.readlines()
        final_sql = ""
        # print("SQL Command:")
        for line in lines:
        	# line = line.strip("       ")
        	line = line.strip(';')
        	line = line.replace('\n'," ")
        	final_sql += line
        sql_commands.append("spark.sql(\""+final_sql+"\").explain(extended=true)\n")
        sqlcount += 1
        current_file.close()
print(len(sql_commands))
print(sql_commands[0])
print(len(file_names))


# Generate files with spark sql commands that spark can run
for i in range(0,22):
	# scala_write_file = open(r"./sql_queries/spark_command_"+file_names[i]+".scala","w")
	scala_write_file = open(r"../tpch/tpch_spark/spark_command_"+file_names[i]+".scala","w")
	scala_write_file.writelines("println(\"Running SQL Query "+file_names[i]+" \")\n")
	for j in range(0,8):
		scala_write_file.writelines(create_table_commands[j])
	scala_write_file.writelines(sql_commands[i] + "\nSystem.exit(0)")
	scala_write_file.close

#Generate shell script file

generic_command = "./bin/spark-shell --driver-memory 12g -i "
# output_command = ".scala > /Users/darshanabalakrishnan/Desktop/Spark_Scratch/imdb_dataset/imdb_output/output_"
output_command = ".scala > /home/csgrad/dbalakri/Spark_scratch/tpch/tpch_output_5/output_"
# scala_file_path = "/Users/darshanabalakrishnan/Desktop/Spark_Scratch/imdb_dataset/sql_queries/"
scala_file_path = "/home/csgrad/dbalakri/Spark_scratch/tpch/tpch_spark/"
# shell_file = open(r"./dbalakri_spark_shell_script.sh","w")
shell_file = open(r"../tpch/tpch_spark_shell_script_5.sh","w")


# command = "./bin/spark-shell --driver-memory 12g -i /Users/darshanabalakrishnan/Desktop/Spark_Scratch/imdb_dataset/sql_queries/spark_command_1a.scala"
for file in file_names:
	shell_file.writelines(generic_command+scala_file_path+"spark_command_"+file+output_command+file+".txt\n")
shell_file.close