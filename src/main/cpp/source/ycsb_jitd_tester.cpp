
#include <iostream>
#include <sstream>
#include <fstream>
#include <memory>
#include <string>
#include <stack>
#include <cstdlib>
#include <algorithm>
#include <thread>
#include <random>
#include <sys/time.h>
#include <queue>
#include <string.h>

#include "test.hpp"
#include "jitd_test.hpp"
#define SEED_MAX 638645
typedef std::vector<old_Record> old_RecordBuffer;
typedef std::vector<Record> ycsbrecordBuffer;

//double worker_sleep_time =0.0;
struct ycsb_operation
{

  char operation;
  Key key;
  Fields fields;
  //Record ycsb_rec;
  ycsb_operation():operation('\0'),key(0){
    
  }
  ycsb_operation(char op, Key k, Fields f):operation(op),key(k){fields = f;}
  ycsb_operation(char op,Key k):operation(op),key(k){}
  //ycsb_operation(char op,Record r):operation(op),ycsb_rec(r){}


};
double total_time(timeval &start, timeval &end)
{
  return (end.tv_sec - start.tv_sec) * 1000000.0 +
         (end.tv_usec - start.tv_usec); 
}
int jitd_test(
  std::shared_ptr<JITD> &jitd,
  std::istream &input, 
  bool interactive, 
  int per_op_sleep_ms
);
// void run_update_thread(
//   JITD<Record,JITD_TEST_POLICY> *jitd, 
//   Key max_key,
//   int size, 
//   long int low_mark, 
//   long int high_mark, 
//   int seed, 
//   int per_op_sleep_ms,
//   int runtime_ms
// ){
//   timeval global_start, start, end;
//   long int del_step = 0;
//   mt19937 ins_rand(seed);
//   mt19937 del_rand(seed);
//   int i;
//   long int tot_cnt = 0;
//   long int delta_mark = high_mark - low_mark;
    
//   gettimeofday(&global_start, NULL);
//   std::cout << "Start Updates [" << low_mark << "--" << high_mark << "] by " << size
//        << "; every " << per_op_sleep_ms << " ms for " << runtime_ms << "ms" << std::endl;
//   do {
    
//     gettimeofday(&start, NULL);
//     if((rand() % delta_mark) > (tot_cnt - low_mark)){
//       // insert
//       RecordBuffer buff = RecordBuffer(new vector<Record>);
//       for(i = 0; i < size; i++){
//         buff->emplace_back(ins_rand() % max_key);
//       }
//       jitd->insert(buff);
//       tot_cnt += size;
      
//     } else {
//       // delete
//       RecordBuffer buff = RecordBuffer(new vector<Record>);
//       for(i = 0; i < size; i++){
//         buff->emplace_back(del_rand() % max_key);
//       }
//       jitd->remove(buff);
//       tot_cnt -= size;
      
//     }
    
//     gettimeofday(&end, NULL);
//     this_thread::sleep_for(chrono::milliseconds(
//       per_op_sleep_ms - int(total_time(start, end) / 1000)
//     ));
//   } while(total_time(global_start, end) < 1000 * runtime_ms);
//   std::cout << "End Updates" << std::endl;
  
  
// }

void run_test_thread(std::shared_ptr<JITD> jitd, std::string file, int per_op_sleep_ms)
{
  std::ifstream in(file);
  timeval start, end;
  gettimeofday(&start, NULL);
  std::cout << "Start[" << file << "]" << std::endl;
  int t = jitd_test(jitd, in, false, per_op_sleep_ms);
  gettimeofday(&end, NULL);
  std::cout << "Time[" << file << "]: " << t << " s" << std::endl;
}




int jitd_test(
  std::shared_ptr<JITD> &jitd,
  std::istream &input, 
  bool interactive, 
  int per_op_sleep_ms
) {
  std::string line;
  std::vector<std::thread> threads;
  //std::shared_ptr<JITD> jitd;
  std::vector<std::pair<ycsbrecordBuffer,ycsbrecordBuffer>> update_vector;
  int columns;
  timeval global_start, global_end;
  gettimeofday(&global_start, NULL);
  
  if(interactive) { std::cout << "jitd> "; std::cout.flush(); }
  while(getline(input, line)){
    std::istringstream toks(line);
    std::string op;
    
    CASE_1("--") {
      // comment, ignore
      
    ///////////////// MUTATOR OPERATIONS /////////////////
    }CASE("init_data_ycsb")
    {
      timeval start, end;
      ycsbrecordBuffer data;
      toks >> columns;
      //std::cout<<"Data SIZE"<<(data).values.size()<<std::endl;
      load_records_from_file_ycsb(data, toks,columns);
      //std::cout<<"DATA SIZE:"<<data.size()<<std::endl;
      gettimeofday(&start, NULL);
      //jitd = std::shared_ptr<JITD>(new JITD(new ArrayNode(data)));
      jitd = std::shared_ptr<JITD>(new JITD(std::shared_ptr<std::shared_ptr<JITDNode>>(new std::shared_ptr<JITDNode>(new ArrayNode(data)))));
      gettimeofday(&end, NULL);
      std::cout << "Init JITD in: " << total_time(start, end) << " us" << std::endl;
      //jitd->print_debug();

    }
    CASE("init_data_ycsb_single")
    {
      timeval start, end;
      ycsbrecordBuffer data;
      ycsbrecordBuffer element;
      toks >> columns;
      load_records_from_file_ycsb(data,toks,columns);
      element.push_back(*(data.begin()));
      jitd = std::shared_ptr<JITD>(new JITD(std::shared_ptr<std::shared_ptr<JITDNode>>(new std::shared_ptr<JITDNode>(new ArrayNode(element)))));
      ycsbrecordBuffer::iterator it;
      for(it = data.begin()+1;it != data.end();it++)
      {
        jitd->insert_singleton(*it);
        jitd->after_insert_singleton(*it);
      }

    }
    CASE("spawn") {
      std::string file;
      //double worker_sleep_time;
      toks >> file;
      //toks >> worker_sleep_time;
      threads.emplace_back(run_test_thread, std::ref(jitd), file, 0);

    }
    CASE("operation_data_ycsb")
    {
      //std::cout<<"populating"<<std::endl;
      std::string file;
      std::string op;
      std::string path;
      std::vector<ycsb_operation> benchmark_vector;
      std::istream *src;
      std::ifstream initFile;
      std::string line;
      

      double total_time_read= 0;
      double total_time_update= 0;
      toks >> op;  
      if(op == "file")
      {
        
        toks >> path;
        initFile.open(path,std::ios_base::in);

        src = &initFile;
        while(getline(*src, line))
        {
          *src >> op;
          
          if(op == "READ")
          {
              ycsb_operation ycsb_op_elem;
              //std::cout<<"OP R"<<std::endl;
            
              std::string key_string;
              Key key;
              
              //std::cout<<"RET SIZE"<<ret.values.size()<<std::endl;
              *src >> key_string;
              //std::cout<<"KEY_STR : "<<key_string<<std::endl;
              key = std::stol(key_string);
              ycsb_op_elem.operation = 'R';
              //r.key = key;
              //ycsb_op_elem.ycsb_rec = r;
              ycsb_op_elem.key = key;
              benchmark_vector.push_back(ycsb_op_elem);
              
             
              
          }
          else if(op == "UPDATE")
          {
            std::string field_no_string;
            std::string key_string;
            std::string value_string;
            int field_no;
            ycsb_operation ycsb_op_elem;
            Key key;
            
         
            std::vector<std::string> ycsbvector(columns);
            //std::cout<<"OP U"<<std::endl;
            *src >> key_string;
            key = std::stol(key_string);
            ycsb_op_elem.operation = 'U';
            ycsb_op_elem.key = key;
            //ycsb_op_elem.ycsb_rec.key = key;
            *src >> field_no_string;
            field_no = std::stoi(field_no_string);
            *src >> value_string;
            
            if(ycsb_op_elem.fields != nullptr)
            {
              
              ycsb_op_elem.fields = new std::array<std::string,10>();
              
              (*(ycsb_op_elem.fields))[field_no] = value_string;
              
            }
            
            benchmark_vector.push_back(ycsb_op_elem);
            
          
          }
          else
          {
            std::cerr<<"Not an operation value"<<std::endl;
            
          }

        }
       
        initFile.close();
        //std::cout<<"HERE"<<std::endl;
        //std::cout<<"total number of operations "<<benchmark_vector.size();
        timeval start_scan, end_scan;
        double time;
        Record ret;
        
        int size = benchmark_vector.size();
        
        auto begin = benchmark_vector.begin();
        auto end = benchmark_vector.end();
        gettimeofday(&start_scan,NULL);
        
        for(auto it = begin;it!=end;it++)
        {
          
          switch((*it).operation)
          {
            case('R'):
            {
              
              if(jitd->get((*it).key, ret))
              {
              
                //std::cout<<"SUCCESS"<<std::endl;
                
              }
              else
              {
               //std::cout<<"FAILED: "<<(*it).key<<std::endl; 
              }
              
              break;
            }
            case('U'):
            {
              
              if(jitd->get((*it).key, ret))
              {
                
                ycsbrecordBuffer old_data;
                old_data.push_back(ret);

                jitd->remove_elements(old_data);
                
                //std::cout<<"UPDATE:"<<std::endl;
                for(int j = 0; j<10;j++)
                {
                  //std::string to_update = elem.fields[j];
                  if((*it).fields != nullptr && !((*((*it).fields))[j].empty()))
                  {
                    //std::cout<<"RET :"<<(*((*it).fields))[j]<<std::endl;
                    (*(ret.values))[j] = (*((*it).fields))[j];
                  }
                  
                  
                }
                ycsbrecordBuffer new_data;
                new_data.push_back(ret);
                
                jitd->insert(new_data);
                

                
              }
              else
              {
                std::cerr<<"Invalid Update Key"<<std::endl;
              }
              break;
            }
          }
        
        }
        gettimeofday(&end_scan,NULL);  
        time = total_time(start_scan, end_scan);
        
        std::cout<<"Total Benchmark Time for "<<benchmark_vector.size()<<" operations = " << time << " us" <<std::endl;
        //key = read_from_file_ycsb(*src);
      } 
      else
      {
        std::cerr<<"Invalid file for benchmarking"<<std::endl;
      }
      
    }
    CASE("thread_operation_data_ycsb")
    {
      std::string file;
      std::string op;
      std::string path;
      std::vector<ycsb_operation> benchmark_vector;
      std::istream *src;
      std::ifstream initFile;
      std::string line;
      
      double worker_sleep_time = 0.0;
      double total_time_read= 0;
      double total_time_update= 0;
      toks >> op;
      
      if(op == "file")
      {
        
        toks >> path;
        toks >> worker_sleep_time;  
        initFile.open(path,std::ios_base::in);

        src = &initFile;
        while(getline(*src, line))
        {
          *src >> op;
          
          if(op == "READ")
          {
              ycsb_operation ycsb_op_elem;
              
            
              std::string key_string;
              Key key;
              
              //std::cout<<"RET SIZE"<<ret.values.size()<<std::endl;
              *src >> key_string;
              //std::cout<<"KEY_STR : "<<key_string<<std::endl;
              key = std::stol(key_string);
              ycsb_op_elem.operation = 'R';
              //r.key = key;
              //ycsb_op_elem.ycsb_rec = r;
              ycsb_op_elem.key = key;
              benchmark_vector.push_back(ycsb_op_elem);
              
             
              
          }
          else if(op == "UPDATE")
          {
            std::string field_no_string;
            std::string key_string;
            std::string value_string;
            int field_no;
            ycsb_operation ycsb_op_elem;
            Key key;
            
         
            std::vector<std::string> ycsbvector(columns);

            *src >> key_string;
            key = std::stol(key_string);
            ycsb_op_elem.operation = 'U';
            ycsb_op_elem.key = key;
            //ycsb_op_elem.ycsb_rec.key = key;
            *src >> field_no_string;
            field_no = std::stoi(field_no_string);
            *src >> value_string;
            //std::cout<<"KEY  : "<< key <<std::endl;
            //std::cout<<"VALUE STRING : "<< value_string <<std::endl;
            if(ycsb_op_elem.fields != nullptr)
            {
              //std::cout<<"NULL PTR"<<std::endl;
              //ycsb_op_elem.ycsb_rec.values = new std::array<std::string,10>();
              ycsb_op_elem.fields = new std::array<std::string,10>();
              // for(int i=0;i<10;i++)
              // {
              //   std::cout<<"LOOP OVER HEAP ARRAY "<<(*(ycsb_op_elem.fields))[i];
              // }
              //(*((ycsb_op_elem.ycsb_rec).values))[field_no] = value_string;
              (*(ycsb_op_elem.fields))[field_no] = value_string;
              //std::cout<<"VALUE STRING AFTER : "<< ycsb_op_elem.ycsb_rec <<std::endl;
              //std::cout<<"VALUE STRING AFTER : "<< ycsb_op_elem.ycsb_rec <<std::endl;
            }
            //(*((ycsb_op_elem.ycsb_rec).values))[field_no] = value_string;
            //std::cout<<"VALUE STRING AFTER : "<< ycsb_op_elem.ycsb_rec <<std::endl;
            //*(ycsb_op_elem.fields+field_no) = &value_string;
            benchmark_vector.push_back(ycsb_op_elem);
            
            
           

          }
          else
          {
            std::cerr<<"Not an operation value"<<std::endl;
            
          }

        }
        //initFile.close();
        //std::cout<<"total number of operations"<<benchmark_vector.size();
        timeval start_scan, end_scan,loop_start,one_op_time;
        //timeval time;
        Record ret;
        double running_op_time;
        int size = benchmark_vector.size();
        auto begin = benchmark_vector.begin();
        auto end = benchmark_vector.end();
        bool action_done = false;
        int operation_count =0;

        gettimeofday(&start_scan,NULL);
        
        for(auto it = begin;it!=end;it++)
        {
           
          gettimeofday(&loop_start,NULL);
          switch((*it).operation)
          {
            case('R'):
            {
              
              if(jitd->get((*it).key, ret))
              {
              
                //std::cout<<"SUCCESS"<<std::endl;
                
              }
              else
              {
               //std::cout<<"FAILED: "<<benchmark_vector[i].key<<std::endl; 
              }
              gettimeofday(&one_op_time,NULL);
              double loop_time = total_time(loop_start,one_op_time); 
              running_op_time += loop_time;
              std::this_thread::sleep_for(std::chrono::duration<double,std::micro>(worker_sleep_time-loop_time));
              break;
            }
            case('U'):
            {

              if(jitd->get((*it).key, ret))
              {
                ycsbrecordBuffer old_data;
                old_data.push_back(ret);
                std::cout<<"HERE";
                jitd->remove_elements(old_data);
                
                for(int j = 0; j<10;j++)
                {
                  //std::string to_update = elem.fields[j];
                  if((*it).fields != nullptr && !((*((*it).fields))[j].empty()))
                  {
                    //std::cout<<"RET :"<<(*((*it).fields))[j]<<std::endl;
                    (*(ret.values))[j] = (*((*it).fields))[j];
                  }
                  
                  
                }
                ycsbrecordBuffer new_data;
                new_data.push_back(ret);
                //std::cout<<"PUSHED TO UPDATE VECTOR"<<std::endl;
                //update_vector.push_back(std::make_pair(old_data,new_data));
                jitd->insert(new_data);
                
                //std::cout<<"SIZE of update_vector after push_back"<<update_vector.size()<<std::endl;

                
              }
              else
              {
                std::cerr<<"Invalid Update Key"<<std::endl;
              }

              gettimeofday(&one_op_time,NULL);
              double loop_time = total_time(loop_start,one_op_time);
              running_op_time += loop_time;
              if(worker_sleep_time ==0)
              {

              }
              else
              {
                std::this_thread::sleep_for(std::chrono::duration<double,std::micro>(worker_sleep_time-loop_time));
              }
              
              break;
            }
          }
        
        }
        gettimeofday(&end_scan,NULL);  
        double time = total_time(start_scan,end_scan);
        //std::cout<<"Total operation Time for "<<benchmark_vector.size()<<" operations = " << running_op_time << " us" <<std::endl;
        //std::cout<<"Total Benchmark Time for "<<benchmark_vector.size()<<" operations with sleep = " << time << " us" <<std::endl;
        //key = read_from_file_ycsb(*src);
        //std::cout<<"SIZE of update vector IMMEDIATE"<<update_vector.size()<<std::endl;
      } 
      else
      {
        std::cerr<<"Invalid file for benchmarking"<<std::endl;
      }
      
    }
    //   CASE("init") {
    //   timeval start, end;
    //   old_RecordBuffer data;
    //   load_records(data, toks);
    //   gettimeofday(&start, NULL);
    //   //jitd = std::shared_ptr<JITD>(new JITD(new ArrayNode(data)));
    //   gettimeofday(&end, NULL);
    //   std::cout << "Init JITD: " << total_time(start, end) << " us" << std::endl;
    // } CASE("build") {
    //   timeval start, end;
    //   gettimeofday(&start, NULL);
    //   jitd = assemble_jitd(input);
    //   gettimeofday(&end, NULL);
    //   std::cout << "Assemble JITD: " << total_time(start, end) << " us" << std::endl;
    // } CASE("insert") {
    //   timeval start, end;
    //   old_RecordBuffer data;
    //   load_records(data, toks);
    //   gettimeofday(&start, NULL);
    //   //jitd->insert(data);
    //   gettimeofday(&end, NULL);
    //   std::cout << "Insert into JITD: " << total_time(start, end) << " us" << std::endl;
    // }CASE("insert-singleton") {
    //   timeval start, end;
    //   old_Record r;
    //   std::string op;
    //   toks >> op;
    //   int count, min, max;
    //   if(op == "random")
    //   {
        
    //     std::cout<<"OP FOUND RANDOM"<<std::endl;
    //     toks >> count >> min >> max;
    //     std::cout<<"count"<<count<<"max"<<max<<"min"<<min<<std::endl;
    //     int max_minus_min = max - min;
    //     gettimeofday(&start, NULL);
    //     for(int i = 0; i < count; i++){
    //       r.key = (rand() % max_minus_min)+min;
    //       r.value = (Value)0xDEADBEEF;
    //       //jitd->insert_singleton(r);
    //     } 
    //     gettimeofday(&end, NULL);
    //   }
    //   //load_records_singleton(data, toks);
    //   //gettimeofday(&start, NULL);
    //   //jitd->insert_singleton(data);
    //   //gettimeofday(&end, NULL);
    //   std::cout << "Insert into JITD: " << total_time(start, end) << " us" << std::endl;
    // } 
    // CASE("remove_elements")
    // {
    //   timeval start, end;
    //   old_RecordBuffer data;
    //   load_records(data, toks);
    //   gettimeofday(&start, NULL);
    //   //jitd->remove_elements(data);
    //   gettimeofday(&end, NULL);
    //   std::cout << "Delete from JITD: " << total_time(start, end) << " us" << std::endl;
    // }
    //   CASE("remove") {
    //   timeval start, end;
    //   old_RecordBuffer data;
    //   load_records(data, toks);
    //   gettimeofday(&start, NULL);
    //   //jitd->remove(data);
    //   gettimeofday(&end, NULL);
    //   std::cout << "Delete from JITD: " << total_time(start, end) << " us" << std::endl;

    ///////////////// POLICY OPERATIONS /////////////////    

   
    CASE("policy_act_until_done")
    {
      //std::cout<<"policy_act_until_done...."<<std::endl;
      int target_steps;
      timeval start, end;
      bool not_done = true;
      int steps_taken = 0;
      gettimeofday(&start, NULL);
      steps_taken = jitd->background_process();
      gettimeofday(&end, NULL);
      std::cout << "Policy " << steps_taken << " Actions: " << total_time(start, end) << (not_done ? "" : " [done]") << " us" <<  std::endl;
    }
    

    // ///////////////// ACCESS OPERATIONS ///////////////// 
     
    
    // CASE("get") {
    //   Key key;
    //   old_Record ret;
    //   old_RecordBuffer data;
    //   std::string op;
    //   toks >> op;
    //    if(op == "random")
    //    {
    //   //   toks >> key;
    //   //   //std::cout<<"KEY BEFORE: "<<key<<std::endl;
    //   //   if(jitd->get(key, ret)){
    //   //   // std::cout<<"BEFORE: "<<ret<<std::endl;
    //   //   // ret.value = (Value)30;
    //   //   // std::cout<<"AFTER: "<<ret<<std::endl;
    //   //   std::cout << "Get "<<key<<": Success" << std::endl;
    //   //   }
    //   //   else {
    //   //   std::cout << "Get "<<key<<": Failed" << std::endl;
    //   //   }
    //    }
    //   else
    //   {
    //     std::cerr<<"Invalid get operation"<<std::endl;
    //   }
       

    // } CASE("scan") {
    //   Iterator<Record> iter = jitd.iterator();
    //   timeval start, end;
    //   int idx = 0;
      
    //   while(!toks.eof() && !iter->atEnd()){
    //     CASE_1("flush") { // no argument
    //       int startidx = idx;
    //       gettimeofday(&start, NULL);
    //       while(!iter->atEnd()){ iter->next(); idx++; }
    //       gettimeofday(&end, NULL);
    //       std::cout << "Records Flushed: " << (idx - startidx) << std::endl;
    //       std::cout << "Flush Time: " << total_time(start, end) << " us" << std::endl;
    //     } CASE("full") { // no argument
    //       while(!iter->atEnd()){ 
    //         std::cout << idx << " -> " << iter->get()->key << std::endl;
    //         iter->next(); 
    //         idx++; 
    //       }
    //     } CASE("step") { // no argument
    //       std::cout << idx << " -> " << iter->get()->key << std::endl;
    //       idx++;
    //       iter->next();
    //     } CASE("next") { // [CNT]
    //       int cnt;
    //       for(toks >> cnt; (cnt > 0) && !iter->atEnd(); cnt--){
    //         std::cout << idx << " -> " << iter->get()->key << std::endl;
    //         idx++;
    //         iter->next();
    //       }
    //     } CASE("quiet_next") { // [CNT]
    //       int cnt, startidx = idx;
    //       for(toks >> cnt; (cnt > 0) && !iter->atEnd(); cnt--){ 
    //         idx++;
    //         iter->next();
    //       }
    //     } CASE("seek") { // [TARGET]
    //       Record target;
    //       toks >> target.key;
    //       target.value = NULL;
    //       gettimeofday(&start, NULL);
    //       iter->seek(target);
    //       gettimeofday(&end, NULL);
    //       std::cout << "Seek Time: " << total_time(start, end) << " us" << std::endl;
    //     } CASE("quiet_seek") { // [TARGET]
    //       Record target;
    //       toks >> target.key;
    //       target.value = NULL;
    //       iter->seek(target);
    //     }
    //   }
    // } CASE("random_scan") {
    //   int time_in_ms, max_key, key_cnt;
    //   long int scan_count = 0;
    //   timeval start, end;
    //   Record target;
    //   target.value = NULL;
    //   toks >> time_in_ms >> max_key >> key_cnt;
    //   gettimeofday(&start, NULL);
    //   gettimeofday(&end, NULL);
      
    //   std::cout << "Scanning for " << time_in_ms << " s in [0,"
    //        << max_key << ") -> " << key_cnt << " keys/read" << std::endl;
    //   while(total_time(start, end) < time_in_ms*1000){
    //     Iterator<Record> iter = jitd.iterator();
    //     target.key = rand() % max_key;
    //     iter->seek(target);
    //     for(; key_cnt > 0; key_cnt--) { iter->next(); }
    //     scan_count++;
        
    //     gettimeofday(&end, NULL);
    //   }
    //   std::cout << "Random Scan: " << scan_count << " scans over "
    //        << total_time(start, end)/(1000*1000) << " s" << std::endl 
    //        << "Rate: " 
    //          << ((1000*1000*scan_count) / total_time(start, end))
    //          << " scans/sec" << std::endl;
    
    // }
    //  CASE("spawn") {
    //   string file;
    //   toks >> file;
    //   threads.emplace_back(run_test_thread, &jitd, file, 0);

    // }
    // CASE("spawn_slow") {
    //   int delay_ms;
    //   string file;
    //   toks >> delay_ms >> file;
    //   threads.emplace_back(run_test_thread, &jitd, file, delay_ms);
    
    // } CASE("spawn_updates") {
    //   Key max_key;
    //   int size;
    //   long int low_mark;
    //   long int high_mark;
    //   int seed = 42;
    //   int per_op_sleep_ms;
    //   int runtime_ms;
      
    //   toks >> max_key >> size >> low_mark >> high_mark >> per_op_sleep_ms >> runtime_ms;
      
    //   threads.emplace_back(run_update_thread, &jitd, max_key, size, low_mark, high_mark, seed, per_op_sleep_ms, runtime_ms);

    // } CASE("run") {
    //   string file;
    //   toks >> file;
    //   run_test_thread(&jitd, file, per_op_sleep_ms);

    //} 
    CASE("time") {
      timeval end; 
      gettimeofday(&end, NULL);
      std::cout << "Time now: " << total_time(global_start, end)/(1000*1000) << std::endl;
    
    } CASE("sleep") {
      int ms;
      toks >> ms;
      std::this_thread::sleep_for(std::chrono::milliseconds(ms));
      
    } CASE("size") {
      std::cout << jitd->size() << " records" << std::endl;
    } CASE("dump") {
      jitd->print_debug();
      
    ///////////////// OOOPS /////////////////
    }
    // CASE("dump_with_set")
    // {
    //   jitd->print_nodes_with_ref();
    // }
    CASE("print_time_log")
    {
      jitd->print_time_vec();
    }
    CASE("print_search_time_log")
    {
      jitd->print_search_time_vec();
    }
    // CASE("print_timing")
    // {
    //   jitd->print_timing();
    // } 
    // CASE("print_set")
    // {
    //   std::cout<<"Printing Set:-"<<std::endl;
    //   jitd->print_set_size();
    // }
    
    // CASE("check_set")
    // {
    //   std::cout<<"Checking set integrity: "<<std::endl;
    //   jitd->check_set_intergrity();
    // }
    CASE("check_pq")
    {
      std::cout<<"Checking PQ integrity: "<<std::endl;
      jitd->check_pq_intergrity();
    }
    CASE("print_pq")
    {
      std::cout<<"Printing PQ:-"<<std::endl;
      jitd->print_pq_size();
    }
    // CASE("make_set")
    // {
    //   //std::cout<<"calling make_set"<<std::endl;
    //   jitd->make_set();

    // }
    // CASE("make_pq")
    // {
    //   //std::cout<<"calling make_set"<<std::endl;
    //   jitd->make_pq();

    // }
    else {
      std::cerr << "Invalid Test Operation: " << op << std::endl;
      exit(-1);
    }
    if(interactive) { std::cout << "jitd> "; std::cout.flush(); }
    if(per_op_sleep_ms > 0){ 
      std::this_thread::sleep_for(std::chrono::milliseconds(per_op_sleep_ms));
    }
  }
  gettimeofday(&global_end, NULL);
  
  std::vector<std::thread>::iterator th;
  for(th = threads.begin(); th < threads.end(); ++th){
    th->join();
  }
  pthread_mutex_destroy(&(jitd->lock)); 
  return total_time(global_start, global_end) / (1000*1000);
}




int main(int argc, char **argv)
{
  std::istream *src;
  std::shared_ptr<JITD> jitd;
  int i, t = 0;
  bool interactive = false;
  srand(SEED_MAX);
  //srand(time(NULL));
  for(i = 1; i < argc; i++){
    std::ifstream srcF;
    if((strlen(argv[i]) > 1) && (argv[i][0] == '-')){
      std::string flag(argv[i]);
      if(std::string("-i") == flag){ interactive = true; }
      else if(std::string("-ni") == flag){ interactive = false; }
      else {
        std::cerr << "Invalid command line switch: " << flag << std::endl;
        exit(-1);
      }
    } else {
      if(std::string("-") == std::string(argv[i])){
        src = &std::cin;
      } else {
        srcF.open(argv[i], std::ios_base::in);
        src = &srcF;
        interactive = false;
      }
      t = jitd_test(std::ref(jitd),*src, interactive, 0);
      std::cout << "Time[" << argv[i] << "]: " << t << " s" << std::endl;
      break;
    }
  }
//  sleep(60);
}
