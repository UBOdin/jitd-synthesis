
#include <algorithm>
#include <vector>
#include <fstream>
#include <string>
#include <array>

typedef long Key;
typedef int *Value;
typedef std::string ycsbField;
typedef std::vector<ycsbField> Values;
typedef std::array<std::string,10>* Fields;
//typedef std::shared_ptr<int> int_Value;

struct Record{
  Key key;
  //ycsbField field;
  Fields values;
  //ycsb_record(Key key, ycsbField _field) : key(key) { field = _field; }
  Record(Key key, std::array<std::string,10> &_values) : key(key){values = &_values; }
  Record(Key key):key(key){values = nullptr;}
  Record() : key(0) {values = nullptr;}

  inline bool operator>(const Record &other) const {
    return key > other.key;
  }
  inline bool operator<(const Record &other) const {
    return key < other.key;
  }
  inline bool operator==(const Record &other) const {
    return key == other.key;
  }
  inline bool operator>(const Key &other) const {
    return key > other;
  }
  inline bool operator<(const Key &other) const {
    return key < other;
  }
  inline bool operator==(const Key &other) const {
    return key == other;
  }
};

struct old_Record {
  Key   key;
  Value  value;
  //Values values;
  old_Record(Key key, Value _value) : key(key) { std::cout<<"ACCEPTED"<<std::endl;value = _value; }
  old_Record(Key key) : key(key) { value = (int *)0xdeadbeef; }
  old_Record() : key(0) { value = NULL; }
  
  inline bool operator>(const old_Record &other) const {
    return key > other.key;
  }
  inline bool operator<(const old_Record &other) const {
    return key < other.key;
  }
  inline bool operator==(const old_Record &other) const {
    return key == other.key;
  }
  inline bool operator>(const Key &other) const {
    return key > other;
  }
  inline bool operator<(const Key &other) const {
    return key < other;
  }
  inline bool operator==(const Key &other) const {
    return key == other;
  }
};

inline bool operator ==(const Key &a, const Record &b) {
  return a == b.key;
}
inline bool operator >(const Key &a, const Record &b) {
  return a > b.key;
}
inline bool operator <(const Key &a, const Record &b) {
  return a < b.key;
}

inline std::ostream &operator<<(std::ostream &o, const Record &r){
  o << "(" << r.key << " -> no. of values " << r.values->size()<< ")\n"; 
  return o;
};

inline bool record_scan(const std::vector<Record> &data, const Key &key, Record &result){

  auto last = std::end(data);
  for(auto curr = std::begin(data); curr != last; ++curr){
    if(*curr == key){ result = *curr; return true; }
  }
  return false;
}
inline bool key_scan(const std::vector<Key> &data, const Key &key, Record &result){
  auto last = std::end(data);
  for(auto curr = std::begin(data); curr != last; ++curr){
    if(*curr == key){ result = *curr; return true; }
  }
  return false;
}
  
inline bool singleton_scan(const Record &data, const Key &key, Record &result){
  // auto last = std::end(data);
  // for(auto curr = std::begin(data); curr != last; ++curr){
    if(data == key){ result = data; return true; }
  //}
  return false;
}
inline bool key_cmp(const Record &data, const Key &key){
  // auto last = std::end(data);
  // for(auto curr = std::begin(data); curr != last; ++curr){
    if(data.key < key){ return true; }
  //}
  return false;
}
inline bool keys_cmp(const Key &k1, const Key &k2){
  // auto last = std::end(data);
  // for(auto curr = std::begin(data); curr != last; ++curr){
    if(k1 < k2){ return true; }
  //}
  return false;
}
inline bool record_binary_search(const std::vector<Record> &data, const Key &key, Record &result){
  auto it = std::lower_bound(std::begin(data), std::end(data), key);
  if(it == std::end(data) || !(*it == key)){ return false; }
  else { result = *it; return true; }
}

inline void append(std::vector<Record> &to, std::vector<Record> &from){
  to.insert(std::end(to), std::begin(from), std::end(from));
}
inline void append_singleton(Record &to, Record &from,std::vector<Record> &merged){
  merged.push_back(to);
  merged.push_back(from);
}

inline void build_buffer(std::vector<old_Record> &to, int count, int min, int max)
{
  int max_minus_min = max - min;
  int temp = 0;
  int i=0;
 
  old_Record r;
  // while(temp <= max)
  // {
   
  //   r.key = temp;
    
  //   r.value = (Value)0xDEADBEEF;
    
  //   temp++;
  //   to.push_back(r);
    
  // }
  
  for(int i = 0; i < count; i++){
     
    r.key = (rand() % max_minus_min)+min;
    r.value = (Value)0xDEADBEEF;
    to.push_back(r);
  }
}
inline void load_keys(std::vector<Key> &to, std::istream &input)
{
  std::string op;
  input >> op;
  if(op == "random"){
    int count, min, max;
    //std::cout<<"in random"<<std::endl;
    input >> count >> min >> max;
    int max_minus_min = max - min;
    for(int i = 0; i < count; i++){
     
      Key k = (rand() % max_minus_min)+min;
      
      to.push_back(k);
    }
    //std::cout<<"built buffer"<<std::endl;
  } else if(op == "explicit"){
    Key k;

    while(!input.eof()){
      input >> k;
      std::cout<<","<<k;
      to.push_back(k);
    }
  }
  else if(op == "sorted"){
    int count, min, max;
    input >> count >> min >> max;
    int max_minus_min = max - min;
    for(int i = 0; i < count; i++){
     
      Key k = (rand() % max_minus_min)+min;
      
      to.push_back(k);
    }
    std::sort(std::begin(to), std::end(to));
  } else {
    std::cerr << "Invalid Key array build command: " << op << std::endl;
    exit(-1);
  }
}
// inline void load_array_to_read(std::istream &input,std::vector<Record> &read)
// {
//   std::string line;
//   std::istringstream toks(line);
//   std::string op;
//   long key;
//   std::string key_string;
//   Record r;
//   while(getline(input, line))
//   {
    
    
//     input >> op;
//     if(op == "READ")i
//     {
//         input >> key_string;
//         r.key = std::stol(key_string);
//         //std::cout<<r.key<<std::endl;
//         r.value = (Value)0xDEADBEEF;
//         read.push_back(r);
//     }
//     else
//     {
//       std::cerr<<"Not an init value"<<std::endl;
//     }
//   }
// }

inline void load_from_file_ycsb(std::istream &input,std::vector<Record> &to,int columns)
{
  std::string line;
  std::istringstream stream(line);
  std::string op;
  int key;
  std::string key_string;
  int line_count = 0;
  int value;
  std::string field_string;
  //Record r;
  int field;
  //for workload e
  std::string table_name; 

  while(getline(input, line))
  {
    
    
    input >> op;
    //for workload e
    input >> table_name;

    //line_count++;
    
    if(op == "INSERT")
    {

        input >> key_string;

        //for workload e
        std::string s = "user";
        std::string::size_type si = key_string.find(s);
        if (si != std::string::npos)
           key_string.erase(si, s.length());
        //std::cout<<"KEY STRING : "<<key_string<<std::endl; 


        
        std::array<std::string,10>* ycsbvector = new std::array<std::string,10>();
        //std::cout<<"YCSBRECORED SIZE"<<ycsbvector.size()<<std::endl;

        for(int i=0;i<columns;i++)
        {
          // std::string value_string;
          // std::string field_no_string;
          // int field_no;
          // input >> field_no_string;
          // std::cout<<"FN STRING : "<<field_no_string<<std::endl;
          
          

          // field_no = std::stoi(field_no_string);
          // input >> value_string;
          // //std::cout<<"VALUE STRING : "<<value_string<<std::endl;
          // (*ycsbvector)[field_no] = value_string;
          
          
        }
        Record r(std::stol(key_string),*ycsbvector);
        //std::cout<<"KEY :"<<r.key<<std::endl;
        //r.values = &ycsbvector;
        // if(r.values.size() > columns)
        // {
        //   std::cout<<"INSERTED VALUES "<<r.values.size()<<std::endl;
        // }
        
        to.push_back(r);
        //std::cout<<"LINE_COUNT: "<<line_count<<std::endl;
       
        
    }
    else
    {
      std::cerr<<"Not an init value"<<std::endl;
    }
  }
  //std::cout<<"LINE_COUNT: "<<line_count<<std::endl;

}
inline void load_records_from_file_ycsb(std::vector<Record> &to, std::istream &input, int columns)
{
  std::string op;
  input >> op;
  if(op == "file")
  {
    std::cout<<"A file to be opened"<<std::endl;
    std::istream *src;
    std::ifstream initFile;
    std::string STRING;
    std::string path;
    input >> path;
    std::cout<<"PATH:"<<path<<std::endl; 
    initFile.open(path,std::ios_base::in);
    src = &initFile;
    load_from_file_ycsb(*src,to,columns);
    //initFile.close();
    //std::sort(std::begin(to), std::end(to));
    //std::cout<<"SIZE of INIT:"<<to.size()<<std::endl;
  }
  else {
    std::cerr << "Invalid init_data command: " << op << std::endl;
    exit(-1);
  }
}
inline void load_records(std::vector<old_Record> &to, std::istream &input)
{
  std::string op;
  input >> op;
  // if(op == "file")
  // {
  //  // std::cout<<"A file to be opened"<<std::endl;
  //   std::istream *src;
  //   std::ifstream initFile;
  //   std::string STRING;
  //   std::string path;
  //   input >> path;
  //   //std::cout<<"PATH:"<<path<<std::endl; 
  //   initFile.open(path,std::ios_base::in);
  //   src = &initFile;
  //   load_from_file(*src,to);
  //   //std::sort(std::begin(to), std::end(to));
  //   //std::cout<<"SIZE of INIT:"<<to.size()<<std::endl;
  // }
  // else 
  if(op == "random"){
    int count, min, max;
    //std::cout<<"in random"<<std::endl;
    input >> count >> min >> max;
    //std::cout<<"got all prams"<<std::endl;
    build_buffer(to, count, min, max);
    //std::cout<<"built buffer"<<std::endl;
  } else if(op == "explicit"){
    old_Record r;
    r.value = (Value)0xDEADBEEF;
    while(!input.eof()){
      input >> r.key;
      to.push_back(r);
    }
  }
  else if(op == "sorted"){
    int count, min, max;
    input >> count >> min >> max;
    build_buffer(to, count, min, max);
    std::sort(std::begin(to), std::end(to));
  } else {
    std::cerr << "Invalid array build command: " << op << std::endl;
    exit(-1);
  }
}

inline Key load_key(std::istream &input)
{
  int ret;
  input >> ret;
  return ret;
}

inline void do_crack(
  const std::vector<Record> &source, 
  Key sep, 
  std::vector<Record> &lhs, 
  std::vector<Record> &rhs
){
  //std::cout << "Crack(" << sep << ") ->" << source[0].key << ", " <<  source[1].key << " ... " << (source.size()-2) << " more" << std::endl;
  auto end = std::end(source);
  for(auto curr = std::begin(source); curr != end; ++curr)
  {
    //std::cout << "  Check: " << curr->key;
    if(*curr < sep){ lhs.push_back(*curr); }
    else           { rhs.push_back(*curr); }
  }
}
inline void do_crack_singleton(
  const Record &source, 
  Key sep, 
  Record &lhs, 
  Record &rhs
){
  //std::cout << "Crack(" << sep << ") ->" << source[0].key << ", " <<  source[1].key << " ... " << (source.size()-2) << " more" << std::endl;
  
    //std::cout << "  Check: " << curr->key;
  lhs.key = -1;
  rhs.key = -1;
    if(source < sep){ lhs = source; }
    else           { rhs = source; }
}
inline void do_crack_singleton_one(
  const Record &source, 
  Key sep, 
  Record &data
){
  //std::cout << "Crack(" << sep << ") ->" << source[0].key << ", " <<  source[1].key << " ... " << (source.size()-2) << " more" << std::endl;
  
    //std::cout << "  Check: " << curr->key;
    data = source; 
}
inline void array_copy(

  const std::vector<Record> &source,  
  std::vector<Record> &lhs, 
  std::vector<Record> &rhs
){
  //std::cout<<"Doing copy"<<std::endl;
  // std::cout << "Crack(" << sep << ") ->" << source[0].key << ", " <<  source[1].key << " ... " << (source.size()-2) << " more" << std::endl;

  auto end = std::end(source);
  for(auto curr = std::begin(source); curr != end; ++curr)
  {
    // std::cout << "  Check: " << curr->key << std::endl;
    lhs.push_back(*curr); 
    rhs.push_back(*curr); 
  }

} 
// inline void copy_delete_array_btree(

//   const std::vector<Record> &source, 
//   Key sep, 
//   std::vector<Record> &lhs, 
//   std::vector<Record> &rhs
// ){
//   //std::cout<<"Doing copy"<<std::endl;
//   // std::cout << "Crack(" << sep << ") ->" << source[0].key << ", " <<  source[1].key << " ... " << (source.size()-2) << " more" << std::endl;
  
//   for(auto curr = std::begin(source); curr < std::end(source); ++curr)
//   {
//     // std::cout << "  Check: " << curr->key << std::endl;
//     if(*curr<sep)
//     {
//       lhs.emplace_back(*curr);
//     }
//     else
//     {
//       rhs.emplace_back(*curr); 
//     }
  
//   }

// } 
// inline void delete_from_sorted_array(std::vector<Record> &to_delete,std::vector<Record> &from_delete)
// {
//   //std::cout<<"in deleting";
//   if(to_delete.size()!=0 && from_delete.size()!=0)
//   {
//     for(int i = 0; i < from_delete.size(); i++)
//     {
//       auto iter = std::find(std::begin(to_delete),std::end(to_delete),from_delete[i]);
//       if(iter != std::end(to_delete))
//       {
//         to_delete.erase(iter);
     
//       }
//     } 

//   }
//   else
//   {
//     std::cout<<"size 0 encountered"<<std::endl;
//   }
  

// }
inline void delete_from_leaf(std::vector<Record> &to_delete,std::vector<Key> &from_delete)
{
  //std::cout<<"in deleting";
  //TODO: optimize begin and end
  if(to_delete.size()!=0 && from_delete.size()!=0)
  {
    for(int i = 0; i < from_delete.size(); i++)
    {
      auto iter = std::find(std::begin(to_delete),std::end(to_delete),from_delete[i]);
      if(iter != std::end(to_delete))
      {
        to_delete.erase(iter);
     
      }
    } 

  }
  else
  {
    //std::cout<<"size 0 encountered"<<std::endl;
  }
  

}
inline void delete_singleton_from_leaf(std::vector<Record> &to_delete,Key &from_delete)
{
  //std::cout<<"in deleting";
  //TODO: optimize begin and end
  if(to_delete.size()!=0)
  {
      auto iter = std::find(std::begin(to_delete),std::end(to_delete),from_delete);
      if(iter != std::end(to_delete))
      {
        to_delete.erase(iter);
     
      }
  }
  else
  {
    //std::cout<<"Delete:size 0 encountered"<<std::endl;
  }
  

}
inline void delete_keys_from_singleton(Record &r,std::vector<Key> &to_delete)
{
  //std::cout<<"in deleting";
  //TODO: optimize begin and end
  if(to_delete.size()!=0)
  {
      auto iter = std::find(std::begin(to_delete),std::end(to_delete),r);
      if(iter != std::end(to_delete))
      {
        r.key = -1;
     
      }
  }
  else
  {
    //std::cout<<"Delete:size 0 encountered"<<std::endl;
  }
  

}
inline void delete_singleton_key(Record &r1,Key &k2)
{
  //std::cout<<"in deleting";
  //TODO: optimize begin and end
  Record r;
  r.key = -1;
  if(r1.key == k2)
  {
    r1 = r;

  }
  else
  {
    //std::cout<<"Delete:size 0 encountered"<<std::endl;
  }
  

}
inline Key pick_separator(const std::vector<Record> &source)
{
  if(source.empty()) { return 0; }
  else { 
    //std::cout<<"SIZE :"<<source.size()<<std::endl;
    long index_to_pick = rand()%source.size();
    //std::cout<<"INDEXX_TO_PICK :"<<index_to_pick<<" Key at index is :"<<source[index_to_pick].key<<std::endl;
    return source[index_to_pick].key; }
}