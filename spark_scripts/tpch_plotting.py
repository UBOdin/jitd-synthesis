import numpy as np
import pathlib
import matplotlib.pyplot as plt 
import pandas as pd
import matplotlib
import matplotlib.cm



search_line = "DARSHANA: Explain : Total Time in Search Phase that has an exec"
noExecSearchLine = "DARSHANA: Explain : Total Time in Search Phase that doesn't have an exec"
effective_line = "DARSHANA: Explain : Total Time in Rewrite Phase Effective"
ineffective_line = "DARSHANA: Explain : Total Time in Rewrite Phase InEffective"
noExecRewrite_line = "DARSHANA: Explain : Total Time in Rewrite Phase that doesn't have an exec"
execute_line = "DARSHANA: Explain : Total Time in Execution Phase"
optimiedAstline = "DARSHANA: Explain : Optimized Plan Size :"


folders = ["1","2","3","4","5"]

Total_Search = np.array([])
Total_No_Exec_Search = np.array([])
Total_Effective_Rewrite = np.array([])
Total_Ineffective_Rewrite = np.array([])
Total_noExec_Rewrite = np.array([])
file_names = np.array([])
Total_Execution = np.array([])

for i in folders:
	Total_Search_list = []
	Total_No_Exec_Search_list = []
	Total_Effective_Rewrite_list = []
	Total_Ineffective_Rewrite_list = []
	Total_noExec_Rewrite_list = []
	Total_Ast_Size_list = []
	file_names = []
	Total_Execution_list = []
	for path in pathlib.Path("./tpch_output_"+i).iterdir():
		if path.is_file():
			current_file = open(path, "r")
			file_name = current_file.name
			# print(file_name)
			file_name = file_name.replace("tpch_output_"+i+"/output_","")
			file_name = file_name.replace(".txt","")
			print(file_name)
			file_names.append(int(file_name))
			lines = current_file.readlines()
			for line in lines:
				if noExecSearchLine in line:
					noexecsearch_time = line.split(noExecSearchLine, maxsplit=1)[-1].split(maxsplit=1)[0]
					Total_No_Exec_Search_list.append(float(noexecsearch_time))
				if search_line in line:
					search_time = line.split(search_line, maxsplit=1)[-1].split(maxsplit=1)[0]
					# if search_time != "that":
						# print("SearchTime: ",search_time)
					Total_Search_list.append(float(search_time))
				if effective_line in line:
					effective_time = line.split(effective_line, maxsplit=1)[-1].split(maxsplit=1)[0]
					Total_Effective_Rewrite_list.append(float(effective_time))
					# print("EffectiveTime: ",effective_time)
				if ineffective_line in line:
					ineffective_time = line.split(ineffective_line, maxsplit=1)[-1].split(maxsplit=1)[0]
					Total_Ineffective_Rewrite_list.append(float(ineffective_time))
					# print(ineffective_time)
				if optimiedAstline in line:
					ast_size = line.split(optimiedAstline, maxsplit=1)[-1].split(maxsplit=1)[0]
					Total_Ast_Size_list.append(int(ast_size))
				if execute_line in line:
					execution_time = line.split(execute_line, maxsplit=1)[-1].split(maxsplit=1)[0]
					Total_Execution_list.append(float(execution_time))
				if noExecRewrite_line in line:
					noexecrewrite_time = line.split(noExecRewrite_line, maxsplit=1)[-1].split(maxsplit=1)[0]
					Total_noExec_Rewrite_list.append(float(noexecrewrite_time))
	file_names_numpy = np.array(file_names)
	Total_Search_list_numpy = np.array(Total_Search_list)
	Total_Effective_Rewrite_list_numpy = np.array(Total_Effective_Rewrite_list)
	Total_Ineffective_Rewrite_list_numpy = np.array(Total_Ineffective_Rewrite_list)
	Total_Execution_list_numpy = np.array(Total_Execution_list)
	Total_noExec_Rewrite_list_numpy = np.array(Total_noExec_Rewrite_list)
	Total_noExec_Search_list_numpy = np.array(Total_No_Exec_Search_list)
	if(Total_Search.size == 0):
		# print("Size is empty")
		Total_Search = Total_Search_list_numpy
		# print(Total_Search.shape)
	else:
		# print("Size is not empty")
		Total_Search = np.column_stack((Total_Search,Total_Search_list_numpy))
	if(Total_Effective_Rewrite.size == 0):
		# print("Size is empty")
		Total_Effective_Rewrite = Total_Effective_Rewrite_list_numpy
		# print(Total_Search.shape)
	else:
		# print("Size is not empty")
		Total_Effective_Rewrite = np.column_stack((Total_Effective_Rewrite,Total_Effective_Rewrite_list_numpy))
	if(Total_Ineffective_Rewrite.size == 0):
		# print("Size is empty")
		Total_Ineffective_Rewrite = Total_Ineffective_Rewrite_list_numpy
		# print(Total_Search.shape)
	else:
		# print("Size is not empty")
		Total_Ineffective_Rewrite = np.column_stack((Total_Ineffective_Rewrite,Total_Ineffective_Rewrite_list_numpy))
	if(Total_Execution.size == 0):
		# print("Size is empty")
		Total_Execution = Total_Execution_list_numpy
		# print(Total_Search.shape)
	else:
		# print("Size is not empty")
		Total_Execution = np.column_stack((Total_Execution,Total_Execution_list_numpy))
	if(Total_noExec_Rewrite.size == 0):
		# print("Size is empty")
		Total_noExec_Rewrite = Total_noExec_Rewrite_list_numpy
		# print(Total_Search.shape)
	else:
		# print("Size is not empty")
		Total_noExec_Rewrite = np.column_stack((Total_noExec_Rewrite,Total_noExec_Rewrite_list_numpy))
	if(Total_No_Exec_Search.size == 0):
		# print("Size is empty")
		Total_No_Exec_Search = Total_noExec_Search_list_numpy
		# print(Total_Search.shape)
	else:
		# print("Size is not empty")
		Total_No_Exec_Search = np.column_stack((Total_No_Exec_Search,Total_noExec_Search_list_numpy))

Total_Search_avg = np.sum(Total_Search, axis = 1)/5.0
Total_Ineffective_Rewrite_avg = np.sum(Total_Ineffective_Rewrite, axis =1)/5.0
Total_Effective_Rewrite_avg = np.sum(Total_Effective_Rewrite, axis =1)/5.0
Total_Execution_avg = np.sum(Total_Execution, axis =1)/5.0
Total_noExec_Rewrite_avg = np.sum(Total_noExec_Rewrite, axis =1)/5.0
Total_No_Exec_Search_avg = np.sum(Total_No_Exec_Search, axis =1)/5.0



# Total_Execution_With_No_Exec_avg = (Total_Execution_avg + Total_No_Exec_Search_avg + Total_noExec_Rewrite_avg)

Total_Time_avg = (Total_Execution_avg + Total_Search_avg + Total_Effective_Rewrite_avg + Total_Ineffective_Rewrite_avg)

print(Total_Time_avg.shape)
print(file_names_numpy.shape)
ft = np.column_stack((file_names_numpy,Total_Time_avg))
fte = np.column_stack((ft,Total_Execution_avg))
ftes = np.column_stack((fte,Total_Search_avg))
ftese = np.column_stack((ftes,Total_Effective_Rewrite_avg))
ftesei = np.column_stack((ftese,Total_Ineffective_Rewrite_avg))


print("SORTING.....")
vsorted_ftesei_ns = np.sort(ftesei.view('i8,f8,f8,f8,f8,f8'), order=['f0'], axis=0).view(np.float)


print(vsorted_ftesei_ns)
print("The X axis will be")
x_axis = []
for i in vsorted_ftesei_ns[:,0]:
	string = "Q"+(str(i).replace(".0",""))
	x_axis.append(string)
print(x_axis)
print(len(x_axis))

CB_color_cycle = ['#377eb8', '#ff7f00', '#4daf4a',
                  '#f781bf', '#a65628', '#984ea3',
                  '#999999', '#e41a1c', '#dede00']

# For Plotting
print("Completed Sort")
execution = vsorted_ftesei_ns[:,2]/1000000000.0
search = vsorted_ftesei_ns[:,3]/1000000000.0 # to convet to sec from ns
print(search)
ineffective = vsorted_ftesei_ns[:,5]/1000000000.0
effective = vsorted_ftesei_ns[:,4]/1000000000.0
# plt.bar(x_axis,search,label='Search',color = CB_color_cycle[0])
# plt.bar(x_axis,ineffective,label='Ineffective Rewrites',color = CB_color_cycle[5],bottom = search)
# plt.bar(x_axis,effective,label='Effective Rewrites',color = CB_color_cycle[1],bottom = search + ineffective)
# plt.bar(x_axis,execution,label='Fixpoint Loop',color = CB_color_cycle[8],bottom = search + ineffective + effective)
plt.figure(figsize=(10, 6))
plt.rcParams.update({'font.size': 18})
plt.bar(x_axis,search,label='Search',color = '#00263E')
plt.bar(x_axis,ineffective,label='Ineffective Rewrites',color = '#0062A0',bottom = search)
plt.bar(x_axis,effective,label='Effective Rewrites',color = '#409EDA',bottom = search + ineffective)
plt.bar(x_axis,execution,label='Fixpoint Loop',color = '#76C8FC',bottom = search + ineffective + effective)
plt.xticks(rotation = 90,label ="")
plt.tick_params(axis='x', which='major', labelsize= 15.0)
plt.xlabel('TPC-H Query #')
# plt.set_xticklabels(x_axis)
plt.ylabel('Total Time Spent Optimizing (sec)') 
plt.ylim(ymin=0)
plt.ylim(ymax=3)
plt.legend(loc="upper left")
plt.savefig('/Users/darshanabalakrishnan/Desktop/final_graphs/StackedTimeTpchAvg_New.pdf',bbox_inches='tight')
plt.show()


plt.scatter(x_axis,((vsorted_ftesei_ns[:,3])/(vsorted_ftesei_ns[:,2] + vsorted_ftesei_ns[:,3] + vsorted_ftesei_ns[:,4] +vsorted_ftesei_ns[:,5]))*100,marker = 'x',color = 'g') 
# naming the x axis 
plt.xlabel('Queries') 
plt.xticks(rotation = 90)
plt.tick_params(axis='x', which='major', labelsize=3.5)
# naming the y axis 
plt.ylabel('Percentage Time Spent in Search') 
plt.ylim(ymin=0)
plt.ylim(ymax=100) 
plt.savefig('/Users/darshanabalakrishnan/Desktop/final_graphs/PercentTimeTpchAvg_New.pdf',bbox_inches='tight') 
plt.show() 

plt.scatter(x_axis,((vsorted_ftesei_ns[:,2])/(vsorted_ftesei_ns[:,2] + vsorted_ftesei_ns[:,3] + vsorted_ftesei_ns[:,4] +vsorted_ftesei_ns[:,5]))*100,marker = 'x',color = 'g') 
# naming the x axis 
plt.xlabel('Queries') 
plt.xticks(rotation = 90)
plt.tick_params(axis='x', which='major', labelsize=3.5)
# naming the y axis 
plt.ylabel('Percentage Time Spent in FixedPoint') 
plt.ylim(ymin=0)
plt.ylim(ymax=100) 
plt.savefig('/Users/darshanabalakrishnan/Desktop/final_graphs/PercentTimeTpchExecuteAvg_New.pdf',bbox_inches='tight') 
plt.show() 

# print(Total_Search.shape)
# print(Total_Search)