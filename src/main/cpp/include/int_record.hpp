#include <algorithm>
#include <vector>

typedef long int Key;
typedef long int Value;
//pthread_mutex_t lock; 
struct Record {
  Key   key;
  Value value;
  
  Record(Key key, Value _value) : key(key) { value = _value; }
  Record(Key key) : key(key) { value = 0; }
  Record() : key(0) { value = 0; }
  
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
  o << "(" << r.key << " -> " << r.value << ")"; 
  return o;
};

inline bool record_scan(const std::vector<Record> &data, const Key &key, Record &result){
  auto last = std::end(data);
  for(auto curr = std::begin(data); curr != last; ++curr){
    if(*curr == key){ result = *curr; return true; }
  }
  return false;
}
// inline bool record_scan(const std::vector<Record> &data,const Key &key){
//   Record dummy;
//   return record_scan(data,key,dummy);
// }
  
inline bool singleton_scan(const Record &data, const Key &key, Record &result){
  // auto last = std::end(data);
  // for(auto curr = std::begin(data); curr != last; ++curr){
    if(data == key){ result = data; return true; }
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
inline void append_singleton_to_array(std::vector<Record> &to, Record &from){
  to.insert(std::end(to),from);
}
// inline void appendConcat(std::vector<Record> &to, std::vector<Record> &from)
// { 
//   to.insert(std::end(to), std::begin(from), std::end(from));
//   std::sort(std::begin(to),std::end(to));
// }
// inline void remove(std::vector<Record> &to_delete, std::vector<Record> &from_delete)
// {
//   for(int i = 0; i < from_delete.size(); i++)
//   {
//     auto iter = std::find(to_delete.begin(),to_delete.end(),from_delete[i]);
//     if(iter != to_delete.end())
//     {
//       to_delete.erase(iter);
//     }
//   } 
// }
inline void build_buffer(std::vector<Record> &to, int count, int min, int max)
{
  int max_minus_min = max - min;
  int temp = 0;
  int i=0;
 
  Record r;
  // while(temp <= max)
  // {
   
  //   r.key = temp;
    
  //   r.value = (Value)0xDEADBEEF;
    
  //   temp++;
  //   to.push_back(r);
    
  // }
  
  for(int i = 0; i < count; i++){
     
    r.key = (rand() % max_minus_min)+min;
    r.value = 0;
    to.push_back(r);
  }
}

inline void load_records(std::vector<Record> &to, std::istream &input)
{
  std::string op;
  input >> op;
  if(op == "random"){
    int count, min, max;
    //std::cout<<"in random"<<std::endl;
    input >> count >> min >> max;
    //std::cout<<"got all prams"<<std::endl;
    build_buffer(to, count, min, max);
    //std::cout<<"built buffer"<<std::endl;
  } else if(op == "explicit"){
    Record r;
    r.value = 0;
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
inline void delete_from_leaf(std::vector<Record> &to_delete,std::vector<Record> &from_delete)
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
    std::cout<<"size 0 encountered"<<std::endl;
  }
  

}
inline Key pick_separator(const std::vector<Record> &source)
{
  if(source.empty()) { return 0; }
  else { 
    //std::cout<<"SIZE"<<source.size();
    int index_to_pick = rand()%source.size();
    //std::cout<<"INDEXX_TO_PICK"<<index_to_pick;
    return source[index_to_pick].key; }
}
