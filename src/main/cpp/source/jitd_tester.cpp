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
#include "tbb/concurrent_queue.h" 
#define SEED_MAX 364785
//pthread_mutex_t lock; 
// std::mutex global_exit_mtx;
// std::condition_variable global_cv;
// bool global_exit_flag = false;

typedef std::vector<Record> RecordBuffer;
int jitd_test(
  std::shared_ptr<JITD> &jitd,
  std::istream &input, 
  bool interactive, 
  int per_op_sleep_ms
);
double total_time(timeval &start, timeval &end)
{
  return (end.tv_sec - start.tv_sec) * 1000000.0 +
         (end.tv_usec - start.tv_usec); 
}


int jitd_client_op(
  std::shared_ptr<JITD> &jitd,
  std::istream &input, 
  bool interactive, 
  int per_op_sleep_ms
) {
  std::string line;
  std::vector<std::thread> threads;
  std::shared_ptr<std::shared_ptr<JITD>> jitd_root;
  std::vector<Record> scan_buff;
  timeval global_start, global_end;
  gettimeofday(&global_start, NULL);
  while(getline(input, line)){
    std::istringstream toks(line);
    std::string op;
    CASE_1("--") {
     
    } 
    CASE("random_scan")
    {

      //std::cout << "Switching to random point scan"<<std::endl;
      long noofscans,max_scan_val;
      toks >> noofscans >> max_scan_val;
      //std::cout<<"In gen_scan"<<std::endl;
      for(int i=0;i<noofscans;i++)
      {
        //cout<<i<<endl;
        scan_buff.emplace_back(rand()%max_scan_val);
        // scan_buff[i].key = rand()%1000000000;
        // scan_buff[i].value = NULL;
        //cout<<scan_buff[i].key<<",";
        
      }
      Record ret;
      
      timeval start_scan, end_scan;
      double running_scan_time = 0;
      double scan_time;
      
      long scan_buff_size = scan_buff.size();
      gettimeofday(&start_scan, NULL);
      for(int i=0;i<scan_buff_size;i++)
      {
       
        if(jitd->get(scan_buff[i].key,ret))
        {
          //std::cout<<"FOUND KEY"<<std::endl;

        }
        else
        {
          //std::cout<<"NOT FOUND KEY"<<std::endl;
        }
       
      }
      gettimeofday(&end_scan, NULL);
      scan_time = total_time(start_scan, end_scan); 
      //gettimeofday(&end_scan, NULL);
       
      std::cout << scan_buff_size <<" Scans JITD time in Random Mode: " << scan_time << " us" << std::endl;
      
    }
    CASE("bulk_insert")
    {
      int operation_count;
      toks >> operation_count;
      RecordBuffer data;
      load_records(data, toks);
      for(int i=0;i<operation_count;i++)
      {

        jitd->insert(data);
      }
      //jitd->print_debug();
    }
    CASE("get") {
      Key key;
      Record ret;
      toks >> key;
      if(jitd->get(key, ret)){
        std::cout << "Get "<<key<<": Success" << std::endl;
      } else {
        std::cout << "Get "<<key<<": Failed" << std::endl;
      }

    } 
    CASE("insert") {
      timeval start, end;
      RecordBuffer data;
      
      load_records(data, toks);
      //std::cout<<"Loaded data"<<std::endl;
      gettimeofday(&start, NULL);
      //std::cout<<"Starting Insert in JITD"<<std::endl;
      jitd->insert(data);
      
      //std::cout<<"size of crack_array"<<jitd->CrackArray_PQ.size()<<std::endl;
      gettimeofday(&end, NULL);
     //std::cout<<"INSERTED..."<<std::endl;
      std::cout << "Insert into JITD: " << total_time(start, end) << " us" << std::endl;
    }
    CASE("insert_singleton") {
      timeval start, end;
      int value;
      Record data;
      
      toks >> value;
      data.key = value;
      data.value = (Value)0xDEADBEEF;
      
      gettimeofday(&start, NULL);
      //std::cout<<"Starting Insert in JITD"<<std::endl;
      jitd->insert_singleton(data);
      
      //std::cout<<"size of crack_array"<<jitd->CrackArray_PQ.size()<<std::endl;
      gettimeofday(&end, NULL);
     //std::cout<<"INSERTED..."<<std::endl;
      std::cout << "Insert_singleton into JITD: " << total_time(start, end) << " us" << std::endl;
      std::this_thread::sleep_for(std::chrono::microseconds(1000));
      //std::cout<<"Loaded data"<<std::endl;
      //jitd->print_debug();
      //jitd->print_map();
      //jitd->check_view();
      //std::cout<<"Concat set size"<<jitd->JITD_NODE_Concat_set.size()<<std::endl;
    }
    CASE("remove_singleton") {
      timeval start, end;
      long value;
      Record data;
      
      toks >> value;
      data.key = value;
      data.value = (Value)0xDEADBEEF;
      
      //std::cout<<"Loaded data"<<std::endl;
      gettimeofday(&start, NULL);
      //std::cout<<"Starting Insert in JITD"<<std::endl;
      jitd->remove_singleton(value);
      
      //std::cout<<"size of crack_array"<<jitd->CrackArray_PQ.size()<<std::endl;
      gettimeofday(&end, NULL);
     //std::cout<<"INSERTED..."<<std::endl;
      std::cout << "Remove_singleton into JITD: " << total_time(start, end) << " us" << std::endl;
      std::this_thread::sleep_for(std::chrono::microseconds(1000));
      //std::cout<<"Loaded data"<<std::endl;
      //jitd->print_debug();
      //jitd->print_map();
      //jitd->check_view();
      //std::cout<<"Concat set size"<<jitd->JITD_NODE_Concat_set.size()<<std::endl;
    }
    CASE("remove_elements")
    {
      timeval start, end;
      RecordBuffer data;
      load_records(data, toks);
      gettimeofday(&start, NULL);
      
      jitd->remove_elements(data);
      
      gettimeofday(&end, NULL);
      std::cout << "Delete from JITD: " << total_time(start, end) << " us" << std::endl;
    }
    CASE("policy_act_until_done")
    {
      int steps_taken =0;
      timeval start, end;
      bool not_done = true;
      gettimeofday(&start, NULL);
      while(not_done)
      {
       not_done = jitd->organize_wait(); 
       steps_taken++;
      }
       gettimeofday(&end, NULL);
       
       std::cout << "Policy_act_until_done " << steps_taken << " Actions: " << total_time(start, end)  << " us" <<  std::endl;
    }
    CASE("sleep") {
      int ms;
      toks >> ms;
      std::this_thread::sleep_for(std::chrono::microseconds(ms));
      
    }
    CASE("dump") {
      
      jitd->print_debug();
      
    }
    CASE("depth")
    {
      int depth =1;
      int maxdepth = 0;
      jitd->get_depth(depth,maxdepth);
      std::cout<<"Maxdepth is of JITD structure: "<<maxdepth<<std::endl;
    }
    else {
      std::cerr << "Invalid Test Operation: " << op << std::endl;
      exit(-1);
    }


  }
  gettimeofday(&global_end, NULL);
   
  return total_time(global_start, global_end) / (1000*1000);
}

void client_thread(std::shared_ptr<JITD> jitd, std::string file, int per_op_sleep_ms)
{

  //std::this_thread::sleep_for(std::chrono::milliseconds(1));
  std::ifstream in(file);
  timeval start, end;
  int t = 0;
  std::cout << "Start:"<< std::this_thread::get_id()<<"[" << file << "]" << std::endl;
  //std::cout <<"client_thread ID:"<<std::this_thread::get_id()<<std::endl;
  gettimeofday(&start, NULL);
  t = jitd_client_op(jitd, in, false, per_op_sleep_ms);
  gettimeofday(&end, NULL);
  std::cout << "Time[" << file << "]: " << t << " s" << std::endl;
  
  
  //EXIT SIGNAL IS PASSED FROM CLIENT TO WORKER 
  mutatorCqElement mce;
  mce.flag = EXIT;
  std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> element; //= std::make_pair(nullptr,nullptr);
  mce.element = element;
  pthread_mutex_lock(&jitd->lock);
  jitd->work_queue.push(mce);
  pthread_mutex_unlock(&jitd->lock);
 
  

  
}
void background_thread(std::shared_ptr<JITD> jitd)
{
   
       int steps_taken = 0;
       timeval start, end;
       std::cout<<"Starting Background Organizer thread"<<std::endl;
       gettimeofday(&start, NULL);
      
       steps_taken = jitd->organize_wait();
       gettimeofday(&end, NULL);
       
       std::cout << "Policy " << steps_taken << " Actions: " << total_time(start, end)  << " us" <<  std::endl; 
       jitd->print_debug();

       
       
       
}




int jitd_test(
  std::shared_ptr<JITD> &jitd,
  std::istream &input, 
  bool interactive, 
  int per_op_sleep_ms
) {
  std::string line;
  std::vector<std::thread> threads;
  std::shared_ptr<std::shared_ptr<JITD>> jitd_root;
  std::vector<Record> scan_buff;
  timeval global_start, global_end;
  gettimeofday(&global_start, NULL);
  
  if(interactive) { std::cout << "jitd> "; std::cout.flush(); }
  while(getline(input, line)){
    std::istringstream toks(line);
    std::string op;
    
    CASE_1("--") {
      // comment, ignore
      
    ///////////////// MUTATOR OPERATIONS /////////////////
    } 
    CASE("build") {
      timeval start, end;
      gettimeofday(&start, NULL);
      jitd = assemble_jitd(input);
      gettimeofday(&end, NULL);
      std::cout << "Assemble JITD: " << total_time(start, end) << " us" << std::endl;
    } 
    // CASE("insert") {
    //   timeval start, end;
    //   RecordBuffer data;
    //   //std::cout<<"Here"<<std::endl;
    //   load_records(data, toks);
    //   //std::cout<<"Loaded data"<<std::endl;
    //   gettimeofday(&start, NULL);
    //   //std::cout<<"Starting Insert in JITD"<<std::endl;
    //   jitd->insert(data);
      
    //   //std::cout<<"size of crack_array"<<jitd->CrackArray_PQ.size()<<std::endl;
    //   gettimeofday(&end, NULL);
    //   std::cout << "Insert into JITD: " << total_time(start, end) << " us" << std::endl;
    // }
    // CASE("exit")
    // {
    //   //EXIT SIGNAL IS PASSED FROM CLIENT TO WORKER 
    //   mutatorCqElement mce;
    //   mce.flag = EXIT;
    //   std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> element = std::make_pair(nullptr,nullptr);
    //   mce.element = element;
    //   pthread_mutex_lock(&jitd->lock);
    //   jitd->work_queue.push(mce);
    //   pthread_mutex_unlock(&jitd->lock);
    // }
    CASE("spawn") {
      std::string file;
      toks >> file; 
      threads.emplace_back(client_thread, std::ref(jitd), file, 0);

    }
    CASE("run_threads")
    {
      std::vector<std::thread>::iterator th;
      for(th = threads.begin(); th < threads.end(); ++th){
        th->join();
      }
      pthread_mutex_destroy(&(jitd->lock)); 
    }
    CASE("run_background_organize")
    {
    
      threads.emplace_back(background_thread,std::ref(jitd));

      
    
     
    }

    
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

    }
    // CASE("dump_viz") {
      
    //   jitd->print_debug_viz();
      
   
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
