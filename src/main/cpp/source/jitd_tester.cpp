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

      std::cout << "Switching to random point scan"<<std::endl;
      long noofscans,max_scan_val;
      toks >> noofscans >> max_scan_val;
      std::cout<<"In gen_scan"<<std::endl;
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
      //std::cout<<"Here"<<std::endl;
      load_records(data, toks);
      //std::cout<<"Loaded data"<<std::endl;
      gettimeofday(&start, NULL);
      
      jitd->insert(data);
      
      //std::cout<<"size of crack_array"<<jitd->CrackArray_PQ.size()<<std::endl;
      gettimeofday(&end, NULL);
      std::cout << "Insert into JITD: " << total_time(start, end) << " us" << std::endl;
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
    
    else {
      std::cerr << "Invalid Test Operation: " << op << std::endl;
      exit(-1);
    }


  }
  gettimeofday(&global_end, NULL);
   
  return total_time(global_start, global_end) / (1000*1000);
}

void run_client_thread(std::shared_ptr<JITD> jitd, std::string file, int per_op_sleep_ms)
{
  std::ifstream in(file);
  timeval start, end;
  int t = 0;
  std::cout << "Start[" << file << "]" << std::endl;
  gettimeofday(&start, NULL);
  t = jitd_client_op(jitd, in, false, per_op_sleep_ms);
  gettimeofday(&end, NULL);
  std::cout << "Time[" << file << "]: " << t << " s" << std::endl;

  //Test: do_organize gets called until exit_flag is set.
  std::this_thread::sleep_for(std::chrono::milliseconds(100));
  jitd->exit_cv.notify_all();
  std::cout<<"Notified dont exit"<<std::endl;
  std::this_thread::sleep_for(std::chrono::milliseconds(100));
  std::unique_lock<std::mutex> lck(jitd->exit_mtx);
  jitd->exit_flag = true;
  jitd->exit_cv.notify_all();
  std::cout<<"Notified exit"<<std::endl;
  //jitd->print_debug();
  
}
void background_thread(std::shared_ptr<JITD> jitd)
{
   
       int steps_taken = 0;
       timeval start, end;
       // std::unique_lock<std::mutex> lck(jitd->exit_mtx);
       std::cout<<"Starting Background Organizer thread"<<std::endl;
       gettimeofday(&start, NULL);
       // while(jitd->exit_flag != true)
       // {
       //  steps_taken = jitd->organize_wait();
       //  jitd->cv.wait(lck);
        
       // } 
       steps_taken = jitd->organize_wait();
       gettimeofday(&end, NULL);
       //jitd->print_debug();
       std::cout << "Policy " << steps_taken << " Actions: " << total_time(start, end)  << " us" <<  std::endl; 
       // while(jitd->exit_flag != true)
       // {
       //  jitd->cv.wait(lck);

       // } 
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
    CASE("spawn") {
      std::string file;
      toks >> file; 
      threads.emplace_back(run_client_thread, std::ref(jitd), file, 0);

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
      // std::thread jitd_organizer(background_thread,std::ref(jitd));
      // jitd_organizer.join();
      // jitd->print_debug();
     
    }
    // CASE("insert") {
    //   timeval start, end;
    //   RecordBuffer data;
    //   //std::cout<<"Here"<<std::endl;
    //   load_records(data, toks);
    //   //std::cout<<"Loaded data"<<std::endl;
    //   gettimeofday(&start, NULL);
      
    //   jitd->insert(data);
      
    //   //std::cout<<"size of crack_array"<<jitd->CrackArray_PQ.size()<<std::endl;
    //   gettimeofday(&end, NULL);
    //   std::cout << "Insert into JITD: " << total_time(start, end) << " us" << std::endl;
    // }
     // CASE("insert-singleton") {
    //   timeval start, end;
    //   Record r;
    //   std::string op;
    //   toks >> op;
    //   int count, min, max;
    //   std::vector<Record> vect_record;
    //   if(op == "random")
    //   {
        
    //     //std::cout<<"OP FOUND RANDOM"<<std::endl;
    //     toks >> count >> min >> max;
    //     //std::cout<<"count"<<count<<"min"<<min<<"max"<<max<<std::endl;
    //     int max_minus_min = std::abs(max - min);
        
    //     for(int i = 0; i < count; i++){
    //       r.key = (rand() % max_minus_min)+min;
    //       r.value = (Value)0xDEADBEEF;
    //       vect_record.push_back(r);
          
    //     }
    //     RecordBuffer element;
    //     element.push_back(*(vect_record.begin()));
    //     std::vector<Record>::iterator it;
        
    //     gettimeofday(&start, NULL);
    //     //std::shared_ptr<JITD>(new JITD(std::shared_ptr<std::shared_ptr<JITDNode>>(new std::shared_ptr<JITDNode>(node_stack.top()))));
    //     jitd = std::shared_ptr<JITD>(new JITD(std::shared_ptr<std::shared_ptr<JITDNode>>(new std::shared_ptr<JITDNode>(new ArrayNode(element)))));
        
    //     //for(int i=0;i<vect_record.size();i++)
    //     for(it = vect_record.begin()+1;it!=vect_record.end();it++)
    //     {
    //       jitd->insert_singleton(*it);
          
    //     } 
    //     gettimeofday(&end, NULL);
    //   }
      
    //   std::cout << "Insert_Singleton into JITD: " << total_time(start, end) << " us" << std::endl;
    // } 
    // CASE("remove_elements")
    // {
    //   timeval start, end;
    //   RecordBuffer data;
    //   load_records(data, toks);
    //   gettimeofday(&start, NULL);
      
    //   jitd->remove_elements(data);
      
    //   gettimeofday(&end, NULL);
    //   std::cout << "Delete from JITD: " << total_time(start, end) << " us" << std::endl;
    // }
    
    ///////////////// POLICY OPERATIONS /////////////////    

    

    // ///////////////// ACCESS OPERATIONS ///////////////// 
    
    // CASE("random_scan")
    // {

    //   std::cout << "Switching to random point scan"<<std::endl;
    //   long noofscans,max_scan_val;
    //   toks >> noofscans >> max_scan_val;
    //   std::cout<<"In gen_scan"<<std::endl;
    //   for(int i=0;i<noofscans;i++)
    //   {
    //     //cout<<i<<endl;
    //     scan_buff.emplace_back(rand()%max_scan_val);
    //     // scan_buff[i].key = rand()%1000000000;
    //     // scan_buff[i].value = NULL;
    //     //cout<<scan_buff[i].key<<",";
        
    //   }
    //   Record ret;
      
    //   timeval start_scan, end_scan;
    //   double running_scan_time = 0;
    //   double scan_time;
      
    //   long scan_buff_size = scan_buff.size();
    //   gettimeofday(&start_scan, NULL);
    //   for(int i=0;i<scan_buff_size;i++)
    //   {
       
    //     if(jitd->get(scan_buff[i].key,ret))
    //     {
    //       //std::cout<<"FOUND KEY"<<std::endl;

    //     }
    //     else
    //     {
    //       //std::cout<<"NOT FOUND KEY"<<std::endl;
    //     }
       
    //   }
    //   gettimeofday(&end_scan, NULL);
    //   scan_time = total_time(start_scan, end_scan); 
    //   //gettimeofday(&end_scan, NULL);
       
    //   std::cout << scan_buff_size <<" Scans JITD time in Random Mode: " << scan_time << " us" << std::endl;
      
    // }
    // CASE("get") {
    //   Key key;
    //   Record ret;
    //   toks >> key;
    //   if(jitd->get(key, ret)){
    //     std::cout << "Get "<<key<<": Success" << std::endl;
    //   } else {
    //     std::cout << "Get "<<key<<": Failed" << std::endl;
    //   }

    // } 
    //CASE("scan") {
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
    // CASE("spawn") {
    //   std::string file;
    //   toks >> file;
    //   std::thread t1(run_test_thread,&&jitd,file,0);
    //   //threads.emplace_back(run_test_thread, &jitd, file, 0);

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
      //std::cout<<"the MCQ SIZE "<<jitd->common_cq.size()<<std::endl;
      jitd->print_debug();
      
    ///////////////// OOOPS /////////////////
    }
    
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