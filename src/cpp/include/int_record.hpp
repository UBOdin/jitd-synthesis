
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

inline bool record_scan(const std::vector<Record> &data, Key key, Record &result){
  auto it = std::find(std::begin(data), std::end(data), key);
  if(it == std::end(data)){ return false; }
  else { result = *it; return true; }
}
inline bool record_binary_search(const std::vector<Record> &data, Key key, Record &result){
  auto it = std::lower_bound(std::begin(data), std::end(data), key);
  if(it == std::end(data) || !(*it == key)){ return false; }
  else { result = *it; return true; }
}

inline void append(std::vector<Record> &to, std::vector<Record> &from){
  to.insert(std::end(to), std::begin(from), std::end(from));
}