
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

// void run_test_thread(JITD<Record, JITD_TEST_POLICY> *jitd, string file, int per_op_sleep_ms)
// {
//   ifstream in(file);
//   timeval start, end;
//   gettimeofday(&start, NULL);
//   std::cout << "Start[" << file << "]" << std::endl;
//   int t = jitd_test(*jitd, in, false, per_op_sleep_ms);
//   gettimeofday(&end, NULL);
//   std::cout << "Time[" << file << "]: " << t << " s" << std::endl;
// }


typedef std::vector<Record> RecordBuffer;


int jitd_test(
  std::istream &input, 
  bool interactive, 
  int per_op_sleep_ms
) {
  std::string line;
  std::vector<std::thread> threads;
  std::shared_ptr<JITD> jitd;
  
  timeval global_start, global_end;
  gettimeofday(&global_start, NULL);
  
  if(interactive) { std::cout << "jitd> "; std::cout.flush(); }
  while(getline(input, line)){
    std::istringstream toks(line);
    std::string op;
    
    CASE_1("--") {
      // comment, ignore
      
    ///////////////// MUTATOR OPERATIONS /////////////////
    } CASE("init") {
      timeval start, end;
      RecordBuffer data;
      load_records(data, toks);
      gettimeofday(&start, NULL);
      jitd = std::shared_ptr<JITD>(new JITD(new ArrayNode(data)));
      gettimeofday(&end, NULL);
      std::cout << "Init JITD: " << total_time(start, end) << " us" << std::endl;
    } CASE("build") {
      timeval start, end;
      gettimeofday(&start, NULL);
      jitd = assemble_jitd(input);
      gettimeofday(&end, NULL);
      std::cout << "Assemble JITD: " << total_time(start, end) << " us" << std::endl;
    } CASE("insert") {
      timeval start, end;
      RecordBuffer data;
      load_records(data, toks);
      gettimeofday(&start, NULL);
      jitd->insert(data);
      gettimeofday(&end, NULL);
      std::cout << "Insert into JITD: " << total_time(start, end) << " us" << std::endl;
    // } CASE("remove") {
    //   timeval start, end;
    //   RecordBuffer data;
    //   load_records(data, toks);
    //   gettimeofday(&start, NULL);
    //   jitd.remove(data);
    //   gettimeofday(&end, NULL);
    //   std::cout << "Delete from JITD: " << total_time(start, end) << " us" << std::endl;

    ///////////////// POLICY OPERATIONS /////////////////    
    // } CASE("policy_set") {
      
    //   CASE_1("cracksort"){
    //     int threshold;
    //     toks >> threshold;
    //     std::cout << "Switching to Crack/Sort Policy with Threshold of " << threshold << std::endl;
    //     jitd.getPolicy()->setScoreFunction(
    //       std::bind(CrackOrSortArraysBigFirst<Record>, threshold, std::placeholders::_1)
    //     );
    //     jitd.reinitPolicy();
    //   } else {
    //     std::cerr << "Invalid Policy " << op << std::endl;
    //     exit(-1);
    //   }

    // } CASE("policy_act_once") {
    //   timeval start, end;
    //   jitd.getPolicy()->describeNext();
    //   JITD_TEST_POLICY *policy = jitd.getPolicy();
    //   gettimeofday(&start, NULL);
    //   policy->act();
    //   gettimeofday(&end, NULL);
    //   std::cout << "Policy Action: " << total_time(start, end) << " us" << std::endl;

    // } CASE("policy_act_for") {
    //   int target_steps;
    //   double used_microseconds = 0;
    //   timeval start, end;
    //   JITD_TEST_POLICY *policy = jitd.getPolicy();

    //   toks >> target_steps;

    //   for(int x = 0; x < target_steps; x++){
    //     gettimeofday(&start, NULL);
    //     policy->act();
    //     gettimeofday(&end, NULL);
    //     used_microseconds += total_time(start, end);
    //   }

    //   std::cout << "Policy " << target_steps << " Actions: " << used_microseconds << " us" << std::endl;

    // } CASE("policy_act_until_done") {
    //   bool more_work_to_do = true;
    //   int steps_taken;
    //   timeval start, end;
    //   JITD_TEST_POLICY *policy = jitd.getPolicy();

    //   gettimeofday(&start, NULL);
    //   while(more_work_to_do){
    //     steps_taken++;
    //     more_work_to_do = policy->act();
    //   }
    //   gettimeofday(&end, NULL);
    //   std::cout << "Policy " << steps_taken << " Actions: " << total_time(start, end) << " us" << std::endl;


    // ///////////////// ACCESS OPERATIONS ///////////////// 
    } CASE("get") {
      Key key;
      Record ret;
      toks >> key;
      if(jitd->get(key, ret)){
        std::cout << "Get "<<key<<": Success" << std::endl;
      } else {
        std::cout << "Get "<<key<<": Failed" << std::endl;
      }

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
    
    // } CASE("spawn") {
    //   string file;
    //   toks >> file;
    //   threads.emplace_back(run_test_thread, &jitd, file, 0);

    // } CASE("spawn_slow") {
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

    } CASE("time") {
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
      jitd->printDebug();
      
    ///////////////// OOOPS /////////////////
    } else {
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
  return total_time(global_start, global_end) / (1000*1000);
}




int main(int argc, char **argv)
{
  std::istream *src;
  int i, t = 0;
  bool interactive = true;
  
  srand(time(NULL));
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
      t = jitd_test(*src, interactive, 0);
      std::cout << "Time[" << argv[i] << "]: " << t << " s" << std::endl;
      break;
    }
  }
//  sleep(60);
}