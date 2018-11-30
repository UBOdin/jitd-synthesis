

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

