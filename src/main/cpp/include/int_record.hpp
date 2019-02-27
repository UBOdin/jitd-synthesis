
#include <algorithm>

typedef long int Key;
typedef void *Value;

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

std::ostream &operator<<(std::ostream &o, const Record &r);

inline bool record_scan(const std::vector<Record> &data, const Key &key, Record &result){
  auto last = std::end(data);
  for(auto curr = std::begin(data); curr != last; ++curr){
    if(*curr == key){ result = *curr; return true; }
  }
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
inline void remove(std::vector<Record> &to_delete, std::vector<Record> &from_delete)
{
  for(int i = 0; i < from_delete.size(); i++)
  {
    auto iter = std::find(to_delete.begin(),to_delete.end(),from_delete[i]);
    if(iter != to_delete.end())
    {
      to_delete.erase(iter);
    }
  } 
}
inline void build_buffer(std::vector<Record> &to, int count, int min, int max)
{
  int max_minus_min = max - min;

  for(int i = 0; i < count; i++){
    to[i].key = (rand() % max_minus_min)+min;
    to[i].value = (Value)0xDEADBEEF;
  }
}

inline void load_records(std::vector<Record> &to, std::istream &input)
{
  std::string op;
  input >> op;
  if(op == "random"){
    int count, min, max;
    input >> count >> min >> max;
    build_buffer(to, count, min, max);
  } else if(op == "explicit"){
    Record r;
    r.value = (Value)0xDEADBEEF;
    while(!input.eof()){
      input >> r.key;
      to.push_back(r);
    }
  } else if(op == "sorted"){
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
  // std::cout << "Crack(" << sep << ") ->" << source[0].key << ", " <<  source[1].key << " ... " << (source.size()-2) << " more" << std::endl;
  for(auto curr = std::begin(source); curr < std::end(source); ++curr)
  {
    // std::cout << "  Check: " << curr->key << std::endl;
    if(*curr < sep){ lhs.emplace_back(*curr); }
    else           { rhs.emplace_back(*curr); }
  }
}
inline void copy_delete_array(
  const std::vector<Record> &source,  
  std::vector<Record> &lhs, 
  std::vector<Record> &rhs
){
  // std::cout << "Crack(" << sep << ") ->" << source[0].key << ", " <<  source[1].key << " ... " << (source.size()-2) << " more" << std::endl;
  for(auto curr = std::begin(source); curr < std::end(source); ++curr)
  {
    // std::cout << "  Check: " << curr->key << std::endl;
    lhs.emplace_back(*curr); 
    rhs.emplace_back(*curr); 
  }
} 
inline Key pick_separator(const std::vector<Record> &source)
{
  if(source.empty()) { return 0; }
  else { return source[(source.size() / 2)].key; }
}