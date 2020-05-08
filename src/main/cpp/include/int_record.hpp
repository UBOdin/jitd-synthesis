#include <algorithm>
#include <vector>

typedef long int Key;
typedef void *Value;
//pthread_mutex_t lock; 
struct Record {
  Key   key;
  Value value;
  
  Record(Key key, Value _value) : key(key) { value = _value; }
  Record(Key key) : key(key) { value = (void *)0xdeadbeef; }
  Record() : key(0) { value = NULL; }
  
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
inline bool record_binary_search(const std::vector<Record> &data, const Key &key, Record &result){
  auto it = std::lower_bound(std::begin(data), std::end(data), key);
  if(it == std::end(data) || !(*it == key)){ return false; }
  else { result = *it; return true; }
}

inline void append(std::vector<Record> &to, std::vector<Record> &from){
  to.insert(std::end(to), std::begin(from), std::end(from));
}

inline void append_singleton_to_array(std::vector<Record> &to, Record &from){
  if(from.key!=-1)
  {
    to.emplace_back(from);
  }
}

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
inline void delete_from_leaf(std::vector<Record> &to_delete,std::vector<Key> &from_delete)
{
  //std::cout<<"in deleting";
  //TODO: optimize begin and end
  if(to_delete.size()!=0 && from_delete.size()!=0)
  {
    for(int i = 0; i < from_delete.size(); ++i)
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
    //std::cout<<"Delete:size 0 encountered"<<std::endl;
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
    //std::cout<<"SIZE"<<source.size();
    int index_to_pick = rand()%source.size();
    //std::cout<<"INDEXX_TO_PICK"<<index_to_pick;
    return source[index_to_pick].key; }
}