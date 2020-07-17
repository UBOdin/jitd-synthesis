#define USE_OLD_MAP
#include "program_base.hpp"
#include "hpds/KDouble.hpp"
#include "hash.hpp"
#include "mmap/mmap.hpp"
#include "hpds/pstring.hpp"
#include "hpds/pstringops.hpp"



#define RELATION_DELETESINGLETON_DYNAMIC
#define RELATION_BTREE_DYNAMIC
#define RELATION_CONCAT_DYNAMIC
#define RELATION_ARRAY_DYNAMIC
#define RELATION_SINGLETON_DYNAMIC

namespace dbtoaster {

  /* Definitions of maps used for storing materialized views. */
  struct QUERY_1_COUNT_entry {
    long ARRAY_NODE_SELF; long __av; QUERY_1_COUNT_entry* nxt; QUERY_1_COUNT_entry* prv;
  
    explicit QUERY_1_COUNT_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_1_COUNT_entry(const long c0, const long c1) { ARRAY_NODE_SELF = c0; __av = c1;  }
    QUERY_1_COUNT_entry(const QUERY_1_COUNT_entry& other) : ARRAY_NODE_SELF(other.ARRAY_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_1_COUNT_entry& modify(const long c0) { ARRAY_NODE_SELF = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, ARRAY_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_1_COUNT_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_1_COUNT_entry& e) {
      size_t h = 0;
      hash_combine(h, e.ARRAY_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_1_COUNT_entry& x, const QUERY_1_COUNT_entry& y) {
      return x.ARRAY_NODE_SELF == y.ARRAY_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_1_COUNT_entry, long,
    HashIndex<QUERY_1_COUNT_entry, long, QUERY_1_COUNT_mapkey0_idxfn, true>
  > QUERY_1_COUNT_map;
  typedef HashIndex<QUERY_1_COUNT_entry, long, QUERY_1_COUNT_mapkey0_idxfn, true> HashIndex_QUERY_1_COUNT_map_0;
  
  
  struct QUERY_2_COUNT_entry {
    long CONCAT_NODE_SELF; long __av; QUERY_2_COUNT_entry* nxt; QUERY_2_COUNT_entry* prv;
  
    explicit QUERY_2_COUNT_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_2_COUNT_entry(const long c0, const long c1) { CONCAT_NODE_SELF = c0; __av = c1;  }
    QUERY_2_COUNT_entry(const QUERY_2_COUNT_entry& other) : CONCAT_NODE_SELF(other.CONCAT_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_2_COUNT_entry& modify(const long c0) { CONCAT_NODE_SELF = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, CONCAT_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_2_COUNT_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_entry& e) {
      size_t h = 0;
      hash_combine(h, e.CONCAT_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_entry& x, const QUERY_2_COUNT_entry& y) {
      return x.CONCAT_NODE_SELF == y.CONCAT_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_2_COUNT_entry, long,
    HashIndex<QUERY_2_COUNT_entry, long, QUERY_2_COUNT_mapkey0_idxfn, true>
  > QUERY_2_COUNT_map;
  typedef HashIndex<QUERY_2_COUNT_entry, long, QUERY_2_COUNT_mapkey0_idxfn, true> HashIndex_QUERY_2_COUNT_map_0;
  
  
  struct QUERY_2_COUNT_mARRAY1_entry {
    long CONCAT_NODE_SELF; long QUERY_2_COUNT_mARRAYARRAY_NODE_SELF; long __av; QUERY_2_COUNT_mARRAY1_entry* nxt; QUERY_2_COUNT_mARRAY1_entry* prv;
  
    explicit QUERY_2_COUNT_mARRAY1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_2_COUNT_mARRAY1_entry(const long c0, const long c1, const long c2) { CONCAT_NODE_SELF = c0; QUERY_2_COUNT_mARRAYARRAY_NODE_SELF = c1; __av = c2;  }
    QUERY_2_COUNT_mARRAY1_entry(const QUERY_2_COUNT_mARRAY1_entry& other) : CONCAT_NODE_SELF(other.CONCAT_NODE_SELF), QUERY_2_COUNT_mARRAYARRAY_NODE_SELF(other.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_2_COUNT_mARRAY1_entry& modify(const long c0, const long c1) { CONCAT_NODE_SELF = c0; QUERY_2_COUNT_mARRAYARRAY_NODE_SELF = c1;  return *this; }
    FORCE_INLINE QUERY_2_COUNT_mARRAY1_entry& modify1(const long c1) { QUERY_2_COUNT_mARRAYARRAY_NODE_SELF = c1;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, CONCAT_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_2_COUNT_mARRAYARRAY_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_2_COUNT_mARRAY1_mapkey01_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mARRAY1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.CONCAT_NODE_SELF);
      hash_combine(h, e.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mARRAY1_entry& x, const QUERY_2_COUNT_mARRAY1_entry& y) {
      return x.CONCAT_NODE_SELF == y.CONCAT_NODE_SELF && x.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF == y.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF;
    }
  };
  
  struct QUERY_2_COUNT_mARRAY1_mapkey1_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mARRAY1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mARRAY1_entry& x, const QUERY_2_COUNT_mARRAY1_entry& y) {
      return x.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF == y.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_2_COUNT_mARRAY1_entry, long,
    HashIndex<QUERY_2_COUNT_mARRAY1_entry, long, QUERY_2_COUNT_mARRAY1_mapkey01_idxfn, true>,
    HashIndex<QUERY_2_COUNT_mARRAY1_entry, long, QUERY_2_COUNT_mARRAY1_mapkey1_idxfn, false>
  > QUERY_2_COUNT_mARRAY1_map;
  typedef HashIndex<QUERY_2_COUNT_mARRAY1_entry, long, QUERY_2_COUNT_mARRAY1_mapkey01_idxfn, true> HashIndex_QUERY_2_COUNT_mARRAY1_map_01;
  typedef HashIndex<QUERY_2_COUNT_mARRAY1_entry, long, QUERY_2_COUNT_mARRAY1_mapkey1_idxfn, false> HashIndex_QUERY_2_COUNT_mARRAY1_map_1;
  
  
  struct QUERY_2_COUNT_mARRAY1_mBTREE1_entry {
    long CONCAT_NODE_SELF; long QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF; long QUERY_2_COUNT_mARRAYARRAY_NODE_SELF; long __av; QUERY_2_COUNT_mARRAY1_mBTREE1_entry* nxt; QUERY_2_COUNT_mARRAY1_mBTREE1_entry* prv;
  
    explicit QUERY_2_COUNT_mARRAY1_mBTREE1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_2_COUNT_mARRAY1_mBTREE1_entry(const long c0, const long c1, const long c2, const long c3) { CONCAT_NODE_SELF = c0; QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF = c1; QUERY_2_COUNT_mARRAYARRAY_NODE_SELF = c2; __av = c3;  }
    QUERY_2_COUNT_mARRAY1_mBTREE1_entry(const QUERY_2_COUNT_mARRAY1_mBTREE1_entry& other) : CONCAT_NODE_SELF(other.CONCAT_NODE_SELF), QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF(other.QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF), QUERY_2_COUNT_mARRAYARRAY_NODE_SELF(other.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_2_COUNT_mARRAY1_mBTREE1_entry& modify(const long c0, const long c1, const long c2) { CONCAT_NODE_SELF = c0; QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF = c1; QUERY_2_COUNT_mARRAYARRAY_NODE_SELF = c2;  return *this; }
    FORCE_INLINE QUERY_2_COUNT_mARRAY1_mBTREE1_entry& modify1(const long c1) { QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF = c1;  return *this; }
    FORCE_INLINE QUERY_2_COUNT_mARRAY1_mBTREE1_entry& modify2(const long c2) { QUERY_2_COUNT_mARRAYARRAY_NODE_SELF = c2;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, CONCAT_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_2_COUNT_mARRAYARRAY_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey012_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mARRAY1_mBTREE1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.CONCAT_NODE_SELF);
      hash_combine(h, e.QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF);
      hash_combine(h, e.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mARRAY1_mBTREE1_entry& x, const QUERY_2_COUNT_mARRAY1_mBTREE1_entry& y) {
      return x.CONCAT_NODE_SELF == y.CONCAT_NODE_SELF && x.QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF == y.QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF && x.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF == y.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF;
    }
  };
  
  struct QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey1_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mARRAY1_mBTREE1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mARRAY1_mBTREE1_entry& x, const QUERY_2_COUNT_mARRAY1_mBTREE1_entry& y) {
      return x.QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF == y.QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF;
    }
  };
  
  struct QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey2_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mARRAY1_mBTREE1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mARRAY1_mBTREE1_entry& x, const QUERY_2_COUNT_mARRAY1_mBTREE1_entry& y) {
      return x.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF == y.QUERY_2_COUNT_mARRAYARRAY_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_2_COUNT_mARRAY1_mBTREE1_entry, long,
    HashIndex<QUERY_2_COUNT_mARRAY1_mBTREE1_entry, long, QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey012_idxfn, true>,
    HashIndex<QUERY_2_COUNT_mARRAY1_mBTREE1_entry, long, QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey1_idxfn, false>,
    HashIndex<QUERY_2_COUNT_mARRAY1_mBTREE1_entry, long, QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey2_idxfn, false>
  > QUERY_2_COUNT_mARRAY1_mBTREE1_map;
  typedef HashIndex<QUERY_2_COUNT_mARRAY1_mBTREE1_entry, long, QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey012_idxfn, true> HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_012;
  typedef HashIndex<QUERY_2_COUNT_mARRAY1_mBTREE1_entry, long, QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey1_idxfn, false> HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1;
  typedef HashIndex<QUERY_2_COUNT_mARRAY1_mBTREE1_entry, long, QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey2_idxfn, false> HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2;
  
  
  struct QUERY_2_COUNT_mBTREE1_entry {
    long CONCAT_NODE_SELF; long QUERY_2_COUNT_mBTREEBTREE_NODE_SELF; long __av; QUERY_2_COUNT_mBTREE1_entry* nxt; QUERY_2_COUNT_mBTREE1_entry* prv;
  
    explicit QUERY_2_COUNT_mBTREE1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_2_COUNT_mBTREE1_entry(const long c0, const long c1, const long c2) { CONCAT_NODE_SELF = c0; QUERY_2_COUNT_mBTREEBTREE_NODE_SELF = c1; __av = c2;  }
    QUERY_2_COUNT_mBTREE1_entry(const QUERY_2_COUNT_mBTREE1_entry& other) : CONCAT_NODE_SELF(other.CONCAT_NODE_SELF), QUERY_2_COUNT_mBTREEBTREE_NODE_SELF(other.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_2_COUNT_mBTREE1_entry& modify(const long c0, const long c1) { CONCAT_NODE_SELF = c0; QUERY_2_COUNT_mBTREEBTREE_NODE_SELF = c1;  return *this; }
    FORCE_INLINE QUERY_2_COUNT_mBTREE1_entry& modify1(const long c1) { QUERY_2_COUNT_mBTREEBTREE_NODE_SELF = c1;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, CONCAT_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_2_COUNT_mBTREEBTREE_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_2_COUNT_mBTREE1_mapkey01_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mBTREE1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.CONCAT_NODE_SELF);
      hash_combine(h, e.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mBTREE1_entry& x, const QUERY_2_COUNT_mBTREE1_entry& y) {
      return x.CONCAT_NODE_SELF == y.CONCAT_NODE_SELF && x.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF == y.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF;
    }
  };
  
  struct QUERY_2_COUNT_mBTREE1_mapkey1_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mBTREE1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mBTREE1_entry& x, const QUERY_2_COUNT_mBTREE1_entry& y) {
      return x.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF == y.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_2_COUNT_mBTREE1_entry, long,
    HashIndex<QUERY_2_COUNT_mBTREE1_entry, long, QUERY_2_COUNT_mBTREE1_mapkey01_idxfn, true>,
    HashIndex<QUERY_2_COUNT_mBTREE1_entry, long, QUERY_2_COUNT_mBTREE1_mapkey1_idxfn, false>
  > QUERY_2_COUNT_mBTREE1_map;
  typedef HashIndex<QUERY_2_COUNT_mBTREE1_entry, long, QUERY_2_COUNT_mBTREE1_mapkey01_idxfn, true> HashIndex_QUERY_2_COUNT_mBTREE1_map_01;
  typedef HashIndex<QUERY_2_COUNT_mBTREE1_entry, long, QUERY_2_COUNT_mBTREE1_mapkey1_idxfn, false> HashIndex_QUERY_2_COUNT_mBTREE1_map_1;
  
  
  struct QUERY_2_COUNT_mCONCAT1_entry {
    long QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT; long __av; QUERY_2_COUNT_mCONCAT1_entry* nxt; QUERY_2_COUNT_mCONCAT1_entry* prv;
  
    explicit QUERY_2_COUNT_mCONCAT1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_2_COUNT_mCONCAT1_entry(const long c0, const long c1) { QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT = c0; __av = c1;  }
    QUERY_2_COUNT_mCONCAT1_entry(const QUERY_2_COUNT_mCONCAT1_entry& other) : QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT(other.QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_2_COUNT_mCONCAT1_entry& modify(const long c0) { QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_2_COUNT_mCONCAT1_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mCONCAT1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mCONCAT1_entry& x, const QUERY_2_COUNT_mCONCAT1_entry& y) {
      return x.QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT == y.QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT;
    }
  };
  
  typedef MultiHashMap<QUERY_2_COUNT_mCONCAT1_entry, long,
    HashIndex<QUERY_2_COUNT_mCONCAT1_entry, long, QUERY_2_COUNT_mCONCAT1_mapkey0_idxfn, true>
  > QUERY_2_COUNT_mCONCAT1_map;
  typedef HashIndex<QUERY_2_COUNT_mCONCAT1_entry, long, QUERY_2_COUNT_mCONCAT1_mapkey0_idxfn, true> HashIndex_QUERY_2_COUNT_mCONCAT1_map_0;
  
  
  struct QUERY_2_COUNT_mCONCAT2_entry {
    long QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT; long __av; QUERY_2_COUNT_mCONCAT2_entry* nxt; QUERY_2_COUNT_mCONCAT2_entry* prv;
  
    explicit QUERY_2_COUNT_mCONCAT2_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_2_COUNT_mCONCAT2_entry(const long c0, const long c1) { QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT = c0; __av = c1;  }
    QUERY_2_COUNT_mCONCAT2_entry(const QUERY_2_COUNT_mCONCAT2_entry& other) : QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT(other.QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_2_COUNT_mCONCAT2_entry& modify(const long c0) { QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_2_COUNT_mCONCAT2_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mCONCAT2_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mCONCAT2_entry& x, const QUERY_2_COUNT_mCONCAT2_entry& y) {
      return x.QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT == y.QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT;
    }
  };
  
  typedef MultiHashMap<QUERY_2_COUNT_mCONCAT2_entry, long,
    HashIndex<QUERY_2_COUNT_mCONCAT2_entry, long, QUERY_2_COUNT_mCONCAT2_mapkey0_idxfn, true>
  > QUERY_2_COUNT_mCONCAT2_map;
  typedef HashIndex<QUERY_2_COUNT_mCONCAT2_entry, long, QUERY_2_COUNT_mCONCAT2_mapkey0_idxfn, true> HashIndex_QUERY_2_COUNT_mCONCAT2_map_0;
  
  
  struct QUERY_3_COUNT_entry {
    long CONCAT_NODE_SELF; long __av; QUERY_3_COUNT_entry* nxt; QUERY_3_COUNT_entry* prv;
  
    explicit QUERY_3_COUNT_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_3_COUNT_entry(const long c0, const long c1) { CONCAT_NODE_SELF = c0; __av = c1;  }
    QUERY_3_COUNT_entry(const QUERY_3_COUNT_entry& other) : CONCAT_NODE_SELF(other.CONCAT_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_3_COUNT_entry& modify(const long c0) { CONCAT_NODE_SELF = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, CONCAT_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_3_COUNT_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_entry& e) {
      size_t h = 0;
      hash_combine(h, e.CONCAT_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_entry& x, const QUERY_3_COUNT_entry& y) {
      return x.CONCAT_NODE_SELF == y.CONCAT_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_3_COUNT_entry, long,
    HashIndex<QUERY_3_COUNT_entry, long, QUERY_3_COUNT_mapkey0_idxfn, true>
  > QUERY_3_COUNT_map;
  typedef HashIndex<QUERY_3_COUNT_entry, long, QUERY_3_COUNT_mapkey0_idxfn, true> HashIndex_QUERY_3_COUNT_map_0;
  
  
  struct QUERY_3_COUNT_mSINGLETON1_entry {
    long CONCAT_NODE_SELF; long QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF; long BTREE_SEPARATOR; long __av; QUERY_3_COUNT_mSINGLETON1_entry* nxt; QUERY_3_COUNT_mSINGLETON1_entry* prv;
  
    explicit QUERY_3_COUNT_mSINGLETON1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_3_COUNT_mSINGLETON1_entry(const long c0, const long c1, const long c2, const long c3) { CONCAT_NODE_SELF = c0; QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF = c1; BTREE_SEPARATOR = c2; __av = c3;  }
    QUERY_3_COUNT_mSINGLETON1_entry(const QUERY_3_COUNT_mSINGLETON1_entry& other) : CONCAT_NODE_SELF(other.CONCAT_NODE_SELF), QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF(other.QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF), BTREE_SEPARATOR(other.BTREE_SEPARATOR), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_3_COUNT_mSINGLETON1_entry& modify(const long c0, const long c1, const long c2) { CONCAT_NODE_SELF = c0; QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF = c1; BTREE_SEPARATOR = c2;  return *this; }
    FORCE_INLINE QUERY_3_COUNT_mSINGLETON1_entry& modify1(const long c1) { QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF = c1;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, CONCAT_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, BTREE_SEPARATOR);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_3_COUNT_mSINGLETON1_mapkey012_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_mSINGLETON1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.CONCAT_NODE_SELF);
      hash_combine(h, e.QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF);
      hash_combine(h, e.BTREE_SEPARATOR);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_mSINGLETON1_entry& x, const QUERY_3_COUNT_mSINGLETON1_entry& y) {
      return x.CONCAT_NODE_SELF == y.CONCAT_NODE_SELF && x.QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF == y.QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF && x.BTREE_SEPARATOR == y.BTREE_SEPARATOR;
    }
  };
  
  struct QUERY_3_COUNT_mSINGLETON1_mapkey1_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_mSINGLETON1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_mSINGLETON1_entry& x, const QUERY_3_COUNT_mSINGLETON1_entry& y) {
      return x.QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF == y.QUERY_3_COUNT_mSINGLETONSINGLETON_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_3_COUNT_mSINGLETON1_entry, long,
    HashIndex<QUERY_3_COUNT_mSINGLETON1_entry, long, QUERY_3_COUNT_mSINGLETON1_mapkey012_idxfn, true>,
    HashIndex<QUERY_3_COUNT_mSINGLETON1_entry, long, QUERY_3_COUNT_mSINGLETON1_mapkey1_idxfn, false>
  > QUERY_3_COUNT_mSINGLETON1_map;
  typedef HashIndex<QUERY_3_COUNT_mSINGLETON1_entry, long, QUERY_3_COUNT_mSINGLETON1_mapkey012_idxfn, true> HashIndex_QUERY_3_COUNT_mSINGLETON1_map_012;
  typedef HashIndex<QUERY_3_COUNT_mSINGLETON1_entry, long, QUERY_3_COUNT_mSINGLETON1_mapkey1_idxfn, false> HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1;
  
  
  struct QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry {
    long QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT; long BTREE_SEPARATOR; long __av; QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* nxt; QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* prv;
  
    explicit QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry(const long c0, const long c1, const long c2) { QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT = c0; BTREE_SEPARATOR = c1; __av = c2;  }
    QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry(const QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry& other) : QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT(other.QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT), BTREE_SEPARATOR(other.BTREE_SEPARATOR), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry& modify(const long c0, const long c1) { QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT = c0; BTREE_SEPARATOR = c1;  return *this; }
    FORCE_INLINE QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry& modify0(const long c0) { QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, BTREE_SEPARATOR);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey01_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT);
      hash_combine(h, e.BTREE_SEPARATOR);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry& x, const QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry& y) {
      return x.QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT == y.QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT && x.BTREE_SEPARATOR == y.BTREE_SEPARATOR;
    }
  };
  
  struct QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry& x, const QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry& y) {
      return x.QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT == y.QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT;
    }
  };
  
  typedef MultiHashMap<QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry, long,
    HashIndex<QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry, long, QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey01_idxfn, true>,
    HashIndex<QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry, long, QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn, false>
  > QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map;
  typedef HashIndex<QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry, long, QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey01_idxfn, true> HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_01;
  typedef HashIndex<QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry, long, QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn, false> HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0;
  
  
  struct QUERY_3_COUNT_mBTREE1_entry {
    long CONCAT_NODE_SELF; long QUERY_3_COUNT_mBTREEBTREE_NODE_SELF; long SINGLETON_KEY; long __av; QUERY_3_COUNT_mBTREE1_entry* nxt; QUERY_3_COUNT_mBTREE1_entry* prv;
  
    explicit QUERY_3_COUNT_mBTREE1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_3_COUNT_mBTREE1_entry(const long c0, const long c1, const long c2, const long c3) { CONCAT_NODE_SELF = c0; QUERY_3_COUNT_mBTREEBTREE_NODE_SELF = c1; SINGLETON_KEY = c2; __av = c3;  }
    QUERY_3_COUNT_mBTREE1_entry(const QUERY_3_COUNT_mBTREE1_entry& other) : CONCAT_NODE_SELF(other.CONCAT_NODE_SELF), QUERY_3_COUNT_mBTREEBTREE_NODE_SELF(other.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF), SINGLETON_KEY(other.SINGLETON_KEY), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_3_COUNT_mBTREE1_entry& modify(const long c0, const long c1, const long c2) { CONCAT_NODE_SELF = c0; QUERY_3_COUNT_mBTREEBTREE_NODE_SELF = c1; SINGLETON_KEY = c2;  return *this; }
    FORCE_INLINE QUERY_3_COUNT_mBTREE1_entry& modify1(const long c1) { QUERY_3_COUNT_mBTREEBTREE_NODE_SELF = c1;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, CONCAT_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_3_COUNT_mBTREEBTREE_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, SINGLETON_KEY);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_3_COUNT_mBTREE1_mapkey012_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_mBTREE1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.CONCAT_NODE_SELF);
      hash_combine(h, e.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF);
      hash_combine(h, e.SINGLETON_KEY);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_mBTREE1_entry& x, const QUERY_3_COUNT_mBTREE1_entry& y) {
      return x.CONCAT_NODE_SELF == y.CONCAT_NODE_SELF && x.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF == y.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF && x.SINGLETON_KEY == y.SINGLETON_KEY;
    }
  };
  
  struct QUERY_3_COUNT_mBTREE1_mapkey1_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_mBTREE1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_mBTREE1_entry& x, const QUERY_3_COUNT_mBTREE1_entry& y) {
      return x.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF == y.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_3_COUNT_mBTREE1_entry, long,
    HashIndex<QUERY_3_COUNT_mBTREE1_entry, long, QUERY_3_COUNT_mBTREE1_mapkey012_idxfn, true>,
    HashIndex<QUERY_3_COUNT_mBTREE1_entry, long, QUERY_3_COUNT_mBTREE1_mapkey1_idxfn, false>
  > QUERY_3_COUNT_mBTREE1_map;
  typedef HashIndex<QUERY_3_COUNT_mBTREE1_entry, long, QUERY_3_COUNT_mBTREE1_mapkey012_idxfn, true> HashIndex_QUERY_3_COUNT_mBTREE1_map_012;
  typedef HashIndex<QUERY_3_COUNT_mBTREE1_entry, long, QUERY_3_COUNT_mBTREE1_mapkey1_idxfn, false> HashIndex_QUERY_3_COUNT_mBTREE1_map_1;
  
  
  struct QUERY_3_COUNT_mBTREE1_mCONCAT1_entry {
    long QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT; long SINGLETON_KEY; long __av; QUERY_3_COUNT_mBTREE1_mCONCAT1_entry* nxt; QUERY_3_COUNT_mBTREE1_mCONCAT1_entry* prv;
  
    explicit QUERY_3_COUNT_mBTREE1_mCONCAT1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_3_COUNT_mBTREE1_mCONCAT1_entry(const long c0, const long c1, const long c2) { QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT = c0; SINGLETON_KEY = c1; __av = c2;  }
    QUERY_3_COUNT_mBTREE1_mCONCAT1_entry(const QUERY_3_COUNT_mBTREE1_mCONCAT1_entry& other) : QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT(other.QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT), SINGLETON_KEY(other.SINGLETON_KEY), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_3_COUNT_mBTREE1_mCONCAT1_entry& modify(const long c0, const long c1) { QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT = c0; SINGLETON_KEY = c1;  return *this; }
    FORCE_INLINE QUERY_3_COUNT_mBTREE1_mCONCAT1_entry& modify0(const long c0) { QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, SINGLETON_KEY);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_3_COUNT_mBTREE1_mCONCAT1_mapkey01_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_mBTREE1_mCONCAT1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT);
      hash_combine(h, e.SINGLETON_KEY);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_mBTREE1_mCONCAT1_entry& x, const QUERY_3_COUNT_mBTREE1_mCONCAT1_entry& y) {
      return x.QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT == y.QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT && x.SINGLETON_KEY == y.SINGLETON_KEY;
    }
  };
  
  struct QUERY_3_COUNT_mBTREE1_mCONCAT1_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_mBTREE1_mCONCAT1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_mBTREE1_mCONCAT1_entry& x, const QUERY_3_COUNT_mBTREE1_mCONCAT1_entry& y) {
      return x.QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT == y.QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT;
    }
  };
  
  typedef MultiHashMap<QUERY_3_COUNT_mBTREE1_mCONCAT1_entry, long,
    HashIndex<QUERY_3_COUNT_mBTREE1_mCONCAT1_entry, long, QUERY_3_COUNT_mBTREE1_mCONCAT1_mapkey01_idxfn, true>,
    HashIndex<QUERY_3_COUNT_mBTREE1_mCONCAT1_entry, long, QUERY_3_COUNT_mBTREE1_mCONCAT1_mapkey0_idxfn, false>
  > QUERY_3_COUNT_mBTREE1_mCONCAT1_map;
  typedef HashIndex<QUERY_3_COUNT_mBTREE1_mCONCAT1_entry, long, QUERY_3_COUNT_mBTREE1_mCONCAT1_mapkey01_idxfn, true> HashIndex_QUERY_3_COUNT_mBTREE1_mCONCAT1_map_01;
  typedef HashIndex<QUERY_3_COUNT_mBTREE1_mCONCAT1_entry, long, QUERY_3_COUNT_mBTREE1_mCONCAT1_mapkey0_idxfn, false> HashIndex_QUERY_3_COUNT_mBTREE1_mCONCAT1_map_0;
  
  
  struct QUERY_3_COUNT_mCONCAT1_entry {
    long QUERY_3_COUNT_mCONCATCONCAT_NODE_LEFT; long QUERY_3_COUNT_mCONCATCONCAT_NODE_RIGHT; long __av; QUERY_3_COUNT_mCONCAT1_entry* nxt; QUERY_3_COUNT_mCONCAT1_entry* prv;
  
    explicit QUERY_3_COUNT_mCONCAT1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_3_COUNT_mCONCAT1_entry(const long c0, const long c1, const long c2) { QUERY_3_COUNT_mCONCATCONCAT_NODE_LEFT = c0; QUERY_3_COUNT_mCONCATCONCAT_NODE_RIGHT = c1; __av = c2;  }
    QUERY_3_COUNT_mCONCAT1_entry(const QUERY_3_COUNT_mCONCAT1_entry& other) : QUERY_3_COUNT_mCONCATCONCAT_NODE_LEFT(other.QUERY_3_COUNT_mCONCATCONCAT_NODE_LEFT), QUERY_3_COUNT_mCONCATCONCAT_NODE_RIGHT(other.QUERY_3_COUNT_mCONCATCONCAT_NODE_RIGHT), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_3_COUNT_mCONCAT1_entry& modify(const long c0, const long c1) { QUERY_3_COUNT_mCONCATCONCAT_NODE_LEFT = c0; QUERY_3_COUNT_mCONCATCONCAT_NODE_RIGHT = c1;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_3_COUNT_mCONCATCONCAT_NODE_LEFT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_3_COUNT_mCONCATCONCAT_NODE_RIGHT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_3_COUNT_mCONCAT1_mapkey01_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_mCONCAT1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_3_COUNT_mCONCATCONCAT_NODE_LEFT);
      hash_combine(h, e.QUERY_3_COUNT_mCONCATCONCAT_NODE_RIGHT);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_mCONCAT1_entry& x, const QUERY_3_COUNT_mCONCAT1_entry& y) {
      return x.QUERY_3_COUNT_mCONCATCONCAT_NODE_LEFT == y.QUERY_3_COUNT_mCONCATCONCAT_NODE_LEFT && x.QUERY_3_COUNT_mCONCATCONCAT_NODE_RIGHT == y.QUERY_3_COUNT_mCONCATCONCAT_NODE_RIGHT;
    }
  };
  
  typedef MultiHashMap<QUERY_3_COUNT_mCONCAT1_entry, long,
    HashIndex<QUERY_3_COUNT_mCONCAT1_entry, long, QUERY_3_COUNT_mCONCAT1_mapkey01_idxfn, true>
  > QUERY_3_COUNT_mCONCAT1_map;
  typedef HashIndex<QUERY_3_COUNT_mCONCAT1_entry, long, QUERY_3_COUNT_mCONCAT1_mapkey01_idxfn, true> HashIndex_QUERY_3_COUNT_mCONCAT1_map_01;
  
  
  struct QUERY_4_COUNT_entry {
    long CONCAT_NODE_SELF; long __av; QUERY_4_COUNT_entry* nxt; QUERY_4_COUNT_entry* prv;
  
    explicit QUERY_4_COUNT_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_4_COUNT_entry(const long c0, const long c1) { CONCAT_NODE_SELF = c0; __av = c1;  }
    QUERY_4_COUNT_entry(const QUERY_4_COUNT_entry& other) : CONCAT_NODE_SELF(other.CONCAT_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_4_COUNT_entry& modify(const long c0) { CONCAT_NODE_SELF = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, CONCAT_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_4_COUNT_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_4_COUNT_entry& e) {
      size_t h = 0;
      hash_combine(h, e.CONCAT_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_4_COUNT_entry& x, const QUERY_4_COUNT_entry& y) {
      return x.CONCAT_NODE_SELF == y.CONCAT_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_4_COUNT_entry, long,
    HashIndex<QUERY_4_COUNT_entry, long, QUERY_4_COUNT_mapkey0_idxfn, true>
  > QUERY_4_COUNT_map;
  typedef HashIndex<QUERY_4_COUNT_entry, long, QUERY_4_COUNT_mapkey0_idxfn, true> HashIndex_QUERY_4_COUNT_map_0;
  
  
  struct QUERY_4_COUNT_mCONCAT1_entry {
    long QUERY_4_COUNT_mCONCATCONCAT_NODE_LEFT; long QUERY_4_COUNT_mCONCATCONCAT_NODE_RIGHT; long __av; QUERY_4_COUNT_mCONCAT1_entry* nxt; QUERY_4_COUNT_mCONCAT1_entry* prv;
  
    explicit QUERY_4_COUNT_mCONCAT1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_4_COUNT_mCONCAT1_entry(const long c0, const long c1, const long c2) { QUERY_4_COUNT_mCONCATCONCAT_NODE_LEFT = c0; QUERY_4_COUNT_mCONCATCONCAT_NODE_RIGHT = c1; __av = c2;  }
    QUERY_4_COUNT_mCONCAT1_entry(const QUERY_4_COUNT_mCONCAT1_entry& other) : QUERY_4_COUNT_mCONCATCONCAT_NODE_LEFT(other.QUERY_4_COUNT_mCONCATCONCAT_NODE_LEFT), QUERY_4_COUNT_mCONCATCONCAT_NODE_RIGHT(other.QUERY_4_COUNT_mCONCATCONCAT_NODE_RIGHT), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_4_COUNT_mCONCAT1_entry& modify(const long c0, const long c1) { QUERY_4_COUNT_mCONCATCONCAT_NODE_LEFT = c0; QUERY_4_COUNT_mCONCATCONCAT_NODE_RIGHT = c1;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_4_COUNT_mCONCATCONCAT_NODE_LEFT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_4_COUNT_mCONCATCONCAT_NODE_RIGHT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_4_COUNT_mCONCAT1_mapkey01_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_4_COUNT_mCONCAT1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_4_COUNT_mCONCATCONCAT_NODE_LEFT);
      hash_combine(h, e.QUERY_4_COUNT_mCONCATCONCAT_NODE_RIGHT);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_4_COUNT_mCONCAT1_entry& x, const QUERY_4_COUNT_mCONCAT1_entry& y) {
      return x.QUERY_4_COUNT_mCONCATCONCAT_NODE_LEFT == y.QUERY_4_COUNT_mCONCATCONCAT_NODE_LEFT && x.QUERY_4_COUNT_mCONCATCONCAT_NODE_RIGHT == y.QUERY_4_COUNT_mCONCATCONCAT_NODE_RIGHT;
    }
  };
  
  typedef MultiHashMap<QUERY_4_COUNT_mCONCAT1_entry, long,
    HashIndex<QUERY_4_COUNT_mCONCAT1_entry, long, QUERY_4_COUNT_mCONCAT1_mapkey01_idxfn, true>
  > QUERY_4_COUNT_mCONCAT1_map;
  typedef HashIndex<QUERY_4_COUNT_mCONCAT1_entry, long, QUERY_4_COUNT_mCONCAT1_mapkey01_idxfn, true> HashIndex_QUERY_4_COUNT_mCONCAT1_map_01;
  
  
  struct QUERY_5_COUNT_entry {
    long DELETESINGLETON_NODE_SELF; long __av; QUERY_5_COUNT_entry* nxt; QUERY_5_COUNT_entry* prv;
  
    explicit QUERY_5_COUNT_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_5_COUNT_entry(const long c0, const long c1) { DELETESINGLETON_NODE_SELF = c0; __av = c1;  }
    QUERY_5_COUNT_entry(const QUERY_5_COUNT_entry& other) : DELETESINGLETON_NODE_SELF(other.DELETESINGLETON_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_5_COUNT_entry& modify(const long c0) { DELETESINGLETON_NODE_SELF = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, DELETESINGLETON_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_5_COUNT_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_5_COUNT_entry& e) {
      size_t h = 0;
      hash_combine(h, e.DELETESINGLETON_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_5_COUNT_entry& x, const QUERY_5_COUNT_entry& y) {
      return x.DELETESINGLETON_NODE_SELF == y.DELETESINGLETON_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_5_COUNT_entry, long,
    HashIndex<QUERY_5_COUNT_entry, long, QUERY_5_COUNT_mapkey0_idxfn, true>
  > QUERY_5_COUNT_map;
  typedef HashIndex<QUERY_5_COUNT_entry, long, QUERY_5_COUNT_mapkey0_idxfn, true> HashIndex_QUERY_5_COUNT_map_0;
  
  
  struct QUERY_5_COUNT_mBTREE1_entry {
    long DELETESINGLETON_NODE_SELF; long QUERY_5_COUNT_mBTREEBTREE_NODE_SELF; long DELETESINGLETON_KEY; long __av; QUERY_5_COUNT_mBTREE1_entry* nxt; QUERY_5_COUNT_mBTREE1_entry* prv;
  
    explicit QUERY_5_COUNT_mBTREE1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_5_COUNT_mBTREE1_entry(const long c0, const long c1, const long c2, const long c3) { DELETESINGLETON_NODE_SELF = c0; QUERY_5_COUNT_mBTREEBTREE_NODE_SELF = c1; DELETESINGLETON_KEY = c2; __av = c3;  }
    QUERY_5_COUNT_mBTREE1_entry(const QUERY_5_COUNT_mBTREE1_entry& other) : DELETESINGLETON_NODE_SELF(other.DELETESINGLETON_NODE_SELF), QUERY_5_COUNT_mBTREEBTREE_NODE_SELF(other.QUERY_5_COUNT_mBTREEBTREE_NODE_SELF), DELETESINGLETON_KEY(other.DELETESINGLETON_KEY), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_5_COUNT_mBTREE1_entry& modify(const long c0, const long c1, const long c2) { DELETESINGLETON_NODE_SELF = c0; QUERY_5_COUNT_mBTREEBTREE_NODE_SELF = c1; DELETESINGLETON_KEY = c2;  return *this; }
    FORCE_INLINE QUERY_5_COUNT_mBTREE1_entry& modify1(const long c1) { QUERY_5_COUNT_mBTREEBTREE_NODE_SELF = c1;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, DELETESINGLETON_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_5_COUNT_mBTREEBTREE_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, DELETESINGLETON_KEY);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_5_COUNT_mBTREE1_mapkey012_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_5_COUNT_mBTREE1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.DELETESINGLETON_NODE_SELF);
      hash_combine(h, e.QUERY_5_COUNT_mBTREEBTREE_NODE_SELF);
      hash_combine(h, e.DELETESINGLETON_KEY);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_5_COUNT_mBTREE1_entry& x, const QUERY_5_COUNT_mBTREE1_entry& y) {
      return x.DELETESINGLETON_NODE_SELF == y.DELETESINGLETON_NODE_SELF && x.QUERY_5_COUNT_mBTREEBTREE_NODE_SELF == y.QUERY_5_COUNT_mBTREEBTREE_NODE_SELF && x.DELETESINGLETON_KEY == y.DELETESINGLETON_KEY;
    }
  };
  
  struct QUERY_5_COUNT_mBTREE1_mapkey1_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_5_COUNT_mBTREE1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_5_COUNT_mBTREEBTREE_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_5_COUNT_mBTREE1_entry& x, const QUERY_5_COUNT_mBTREE1_entry& y) {
      return x.QUERY_5_COUNT_mBTREEBTREE_NODE_SELF == y.QUERY_5_COUNT_mBTREEBTREE_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_5_COUNT_mBTREE1_entry, long,
    HashIndex<QUERY_5_COUNT_mBTREE1_entry, long, QUERY_5_COUNT_mBTREE1_mapkey012_idxfn, true>,
    HashIndex<QUERY_5_COUNT_mBTREE1_entry, long, QUERY_5_COUNT_mBTREE1_mapkey1_idxfn, false>
  > QUERY_5_COUNT_mBTREE1_map;
  typedef HashIndex<QUERY_5_COUNT_mBTREE1_entry, long, QUERY_5_COUNT_mBTREE1_mapkey012_idxfn, true> HashIndex_QUERY_5_COUNT_mBTREE1_map_012;
  typedef HashIndex<QUERY_5_COUNT_mBTREE1_entry, long, QUERY_5_COUNT_mBTREE1_mapkey1_idxfn, false> HashIndex_QUERY_5_COUNT_mBTREE1_map_1;
  
  
  struct QUERY_6_COUNT_entry {
    long DELETESINGLETON_NODE_SELF; long __av; QUERY_6_COUNT_entry* nxt; QUERY_6_COUNT_entry* prv;
  
    explicit QUERY_6_COUNT_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_6_COUNT_entry(const long c0, const long c1) { DELETESINGLETON_NODE_SELF = c0; __av = c1;  }
    QUERY_6_COUNT_entry(const QUERY_6_COUNT_entry& other) : DELETESINGLETON_NODE_SELF(other.DELETESINGLETON_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_6_COUNT_entry& modify(const long c0) { DELETESINGLETON_NODE_SELF = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, DELETESINGLETON_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_6_COUNT_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_6_COUNT_entry& e) {
      size_t h = 0;
      hash_combine(h, e.DELETESINGLETON_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_6_COUNT_entry& x, const QUERY_6_COUNT_entry& y) {
      return x.DELETESINGLETON_NODE_SELF == y.DELETESINGLETON_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_6_COUNT_entry, long,
    HashIndex<QUERY_6_COUNT_entry, long, QUERY_6_COUNT_mapkey0_idxfn, true>
  > QUERY_6_COUNT_map;
  typedef HashIndex<QUERY_6_COUNT_entry, long, QUERY_6_COUNT_mapkey0_idxfn, true> HashIndex_QUERY_6_COUNT_map_0;
  
  
  struct QUERY_7_COUNT_entry {
    long DELETESINGLETON_NODE_SELF; long __av; QUERY_7_COUNT_entry* nxt; QUERY_7_COUNT_entry* prv;
  
    explicit QUERY_7_COUNT_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_7_COUNT_entry(const long c0, const long c1) { DELETESINGLETON_NODE_SELF = c0; __av = c1;  }
    QUERY_7_COUNT_entry(const QUERY_7_COUNT_entry& other) : DELETESINGLETON_NODE_SELF(other.DELETESINGLETON_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_7_COUNT_entry& modify(const long c0) { DELETESINGLETON_NODE_SELF = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, DELETESINGLETON_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_7_COUNT_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_7_COUNT_entry& e) {
      size_t h = 0;
      hash_combine(h, e.DELETESINGLETON_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_7_COUNT_entry& x, const QUERY_7_COUNT_entry& y) {
      return x.DELETESINGLETON_NODE_SELF == y.DELETESINGLETON_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_7_COUNT_entry, long,
    HashIndex<QUERY_7_COUNT_entry, long, QUERY_7_COUNT_mapkey0_idxfn, true>
  > QUERY_7_COUNT_map;
  typedef HashIndex<QUERY_7_COUNT_entry, long, QUERY_7_COUNT_mapkey0_idxfn, true> HashIndex_QUERY_7_COUNT_map_0;
  
  
  struct QUERY_7_COUNT_mARRAY1_entry {
    long DELETESINGLETON_NODE_SELF; long QUERY_7_COUNT_mARRAYARRAY_NODE_SELF; long __av; QUERY_7_COUNT_mARRAY1_entry* nxt; QUERY_7_COUNT_mARRAY1_entry* prv;
  
    explicit QUERY_7_COUNT_mARRAY1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_7_COUNT_mARRAY1_entry(const long c0, const long c1, const long c2) { DELETESINGLETON_NODE_SELF = c0; QUERY_7_COUNT_mARRAYARRAY_NODE_SELF = c1; __av = c2;  }
    QUERY_7_COUNT_mARRAY1_entry(const QUERY_7_COUNT_mARRAY1_entry& other) : DELETESINGLETON_NODE_SELF(other.DELETESINGLETON_NODE_SELF), QUERY_7_COUNT_mARRAYARRAY_NODE_SELF(other.QUERY_7_COUNT_mARRAYARRAY_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_7_COUNT_mARRAY1_entry& modify(const long c0, const long c1) { DELETESINGLETON_NODE_SELF = c0; QUERY_7_COUNT_mARRAYARRAY_NODE_SELF = c1;  return *this; }
    FORCE_INLINE QUERY_7_COUNT_mARRAY1_entry& modify1(const long c1) { QUERY_7_COUNT_mARRAYARRAY_NODE_SELF = c1;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, DELETESINGLETON_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_7_COUNT_mARRAYARRAY_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_7_COUNT_mARRAY1_mapkey01_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_7_COUNT_mARRAY1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.DELETESINGLETON_NODE_SELF);
      hash_combine(h, e.QUERY_7_COUNT_mARRAYARRAY_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_7_COUNT_mARRAY1_entry& x, const QUERY_7_COUNT_mARRAY1_entry& y) {
      return x.DELETESINGLETON_NODE_SELF == y.DELETESINGLETON_NODE_SELF && x.QUERY_7_COUNT_mARRAYARRAY_NODE_SELF == y.QUERY_7_COUNT_mARRAYARRAY_NODE_SELF;
    }
  };
  
  struct QUERY_7_COUNT_mARRAY1_mapkey1_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_7_COUNT_mARRAY1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_7_COUNT_mARRAYARRAY_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_7_COUNT_mARRAY1_entry& x, const QUERY_7_COUNT_mARRAY1_entry& y) {
      return x.QUERY_7_COUNT_mARRAYARRAY_NODE_SELF == y.QUERY_7_COUNT_mARRAYARRAY_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_7_COUNT_mARRAY1_entry, long,
    HashIndex<QUERY_7_COUNT_mARRAY1_entry, long, QUERY_7_COUNT_mARRAY1_mapkey01_idxfn, true>,
    HashIndex<QUERY_7_COUNT_mARRAY1_entry, long, QUERY_7_COUNT_mARRAY1_mapkey1_idxfn, false>
  > QUERY_7_COUNT_mARRAY1_map;
  typedef HashIndex<QUERY_7_COUNT_mARRAY1_entry, long, QUERY_7_COUNT_mARRAY1_mapkey01_idxfn, true> HashIndex_QUERY_7_COUNT_mARRAY1_map_01;
  typedef HashIndex<QUERY_7_COUNT_mARRAY1_entry, long, QUERY_7_COUNT_mARRAY1_mapkey1_idxfn, false> HashIndex_QUERY_7_COUNT_mARRAY1_map_1;

  /* Temporary entry type definitions */
  struct tuple2_L_L {
    long _1; long __av; tuple2_L_L* nxt; tuple2_L_L* prv;
    explicit tuple2_L_L() : nxt(nullptr), prv(nullptr) { }
    FORCE_INLINE tuple2_L_L& modify(const long c1) { _1 = c1; return *this; }
    static bool equals(const tuple2_L_L &x, const tuple2_L_L &y) {
      return ((x._1 == y._1));
    }
    static long hash(const tuple2_L_L &e) {
      size_t h = 0;
      hash_combine(h, e._1);
      return h;
    }
  };

  /* Defines top-level materialized views */
  struct tlq_t {
    struct timeval t0, t; long tT, tN, tS;
    tlq_t(): tN(0), tS(0)  { 
      gettimeofday(&t0, NULL); 
    }
  
    /* Serialization code */
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << "\n";
      const QUERY_1_COUNT_map& _QUERY_1_COUNT = get_QUERY_1_COUNT();
      dbtoaster::serialize_nvp_tabbed(ar, STRING(QUERY_1_COUNT), _QUERY_1_COUNT, "\t");
      
      ar << "\n";
      const QUERY_2_COUNT_map& _QUERY_2_COUNT = get_QUERY_2_COUNT();
      dbtoaster::serialize_nvp_tabbed(ar, STRING(QUERY_2_COUNT), _QUERY_2_COUNT, "\t");
      
      ar << "\n";
      const QUERY_3_COUNT_map& _QUERY_3_COUNT = get_QUERY_3_COUNT();
      dbtoaster::serialize_nvp_tabbed(ar, STRING(QUERY_3_COUNT), _QUERY_3_COUNT, "\t");
      
      ar << "\n";
      const QUERY_4_COUNT_map& _QUERY_4_COUNT = get_QUERY_4_COUNT();
      dbtoaster::serialize_nvp_tabbed(ar, STRING(QUERY_4_COUNT), _QUERY_4_COUNT, "\t");
      
      ar << "\n";
      const QUERY_5_COUNT_map& _QUERY_5_COUNT = get_QUERY_5_COUNT();
      dbtoaster::serialize_nvp_tabbed(ar, STRING(QUERY_5_COUNT), _QUERY_5_COUNT, "\t");
      
      ar << "\n";
      const QUERY_6_COUNT_map& _QUERY_6_COUNT = get_QUERY_6_COUNT();
      dbtoaster::serialize_nvp_tabbed(ar, STRING(QUERY_6_COUNT), _QUERY_6_COUNT, "\t");
      
      ar << "\n";
      const QUERY_7_COUNT_map& _QUERY_7_COUNT = get_QUERY_7_COUNT();
      dbtoaster::serialize_nvp_tabbed(ar, STRING(QUERY_7_COUNT), _QUERY_7_COUNT, "\t");
    }
  
    /* Functions returning / computing the results of top level queries */
    const QUERY_1_COUNT_map& get_QUERY_1_COUNT() const {
      return QUERY_1_COUNT;
    }
    
    const QUERY_2_COUNT_map& get_QUERY_2_COUNT() const {
      return QUERY_2_COUNT;
    }
    
    const QUERY_3_COUNT_map& get_QUERY_3_COUNT() const {
      return QUERY_3_COUNT;
    }
    
    const QUERY_4_COUNT_map& get_QUERY_4_COUNT() const {
      return QUERY_4_COUNT;
    }
    
    const QUERY_5_COUNT_map& get_QUERY_5_COUNT() const {
      return QUERY_5_COUNT;
    }
    
    const QUERY_6_COUNT_map& get_QUERY_6_COUNT() const {
      return QUERY_6_COUNT;
    }
    
    const QUERY_7_COUNT_map& get_QUERY_7_COUNT() const {
      return QUERY_7_COUNT;
    }
  
  protected:
    /* Data structures used for storing / computing top-level queries */
    QUERY_1_COUNT_map QUERY_1_COUNT;
    QUERY_2_COUNT_map QUERY_2_COUNT;
    QUERY_3_COUNT_map QUERY_3_COUNT;
    QUERY_4_COUNT_map QUERY_4_COUNT;
    QUERY_5_COUNT_map QUERY_5_COUNT;
    QUERY_6_COUNT_map QUERY_6_COUNT;
    QUERY_7_COUNT_map QUERY_7_COUNT;
    
  };

  /* Contains materialized views and processing (IVM) logic */
  struct data_t : tlq_t {
  
    data_t(): tlq_t() {
      
      
    }
  
    
  
    /* Registering relations and trigger functions */
    ProgramBase* program_base;
    void register_data(ProgramBase& pb) {
      program_base = &pb;
    
      // Register maps
      pb.add_map<QUERY_1_COUNT_map>("QUERY_1_COUNT", QUERY_1_COUNT);
      pb.add_map<QUERY_2_COUNT_map>("QUERY_2_COUNT", QUERY_2_COUNT);
      pb.add_map<QUERY_2_COUNT_mARRAY1_map>("QUERY_2_COUNT_mARRAY1", QUERY_2_COUNT_mARRAY1);
      pb.add_map<QUERY_2_COUNT_mARRAY1_mBTREE1_map>("QUERY_2_COUNT_mARRAY1_mBTREE1", QUERY_2_COUNT_mARRAY1_mBTREE1);
      pb.add_map<QUERY_2_COUNT_mBTREE1_map>("QUERY_2_COUNT_mBTREE1", QUERY_2_COUNT_mBTREE1);
      pb.add_map<QUERY_2_COUNT_mCONCAT1_map>("QUERY_2_COUNT_mCONCAT1", QUERY_2_COUNT_mCONCAT1);
      pb.add_map<QUERY_2_COUNT_mCONCAT2_map>("QUERY_2_COUNT_mCONCAT2", QUERY_2_COUNT_mCONCAT2);
      pb.add_map<QUERY_3_COUNT_map>("QUERY_3_COUNT", QUERY_3_COUNT);
      pb.add_map<QUERY_3_COUNT_mSINGLETON1_map>("QUERY_3_COUNT_mSINGLETON1", QUERY_3_COUNT_mSINGLETON1);
      pb.add_map<QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map>("QUERY_3_COUNT_mSINGLETON1_mCONCAT1", QUERY_3_COUNT_mSINGLETON1_mCONCAT1);
      pb.add_map<QUERY_3_COUNT_mBTREE1_map>("QUERY_3_COUNT_mBTREE1", QUERY_3_COUNT_mBTREE1);
      pb.add_map<QUERY_3_COUNT_mBTREE1_mCONCAT1_map>("QUERY_3_COUNT_mBTREE1_mCONCAT1", QUERY_3_COUNT_mBTREE1_mCONCAT1);
      pb.add_map<QUERY_3_COUNT_mCONCAT1_map>("QUERY_3_COUNT_mCONCAT1", QUERY_3_COUNT_mCONCAT1);
      pb.add_map<QUERY_4_COUNT_map>("QUERY_4_COUNT", QUERY_4_COUNT);
      pb.add_map<QUERY_4_COUNT_mCONCAT1_map>("QUERY_4_COUNT_mCONCAT1", QUERY_4_COUNT_mCONCAT1);
      pb.add_map<QUERY_5_COUNT_map>("QUERY_5_COUNT", QUERY_5_COUNT);
      pb.add_map<QUERY_5_COUNT_mBTREE1_map>("QUERY_5_COUNT_mBTREE1", QUERY_5_COUNT_mBTREE1);
      pb.add_map<QUERY_6_COUNT_map>("QUERY_6_COUNT", QUERY_6_COUNT);
      pb.add_map<QUERY_7_COUNT_map>("QUERY_7_COUNT", QUERY_7_COUNT);
      pb.add_map<QUERY_7_COUNT_mARRAY1_map>("QUERY_7_COUNT_mARRAY1", QUERY_7_COUNT_mARRAY1);
    
      // Register streams and tables
      pb.add_relation("DELETESINGLETON", false);
      pb.add_relation("BTREE", false);
      pb.add_relation("CONCAT", false);
      pb.add_relation("ARRAY", false);
      pb.add_relation("SINGLETON", false);
    
      // Register stream triggers
      pb.add_trigger("DELETESINGLETON", insert_tuple, std::bind(&data_t::unwrap_insert_DELETESINGLETON, this, std::placeholders::_1));
      pb.add_trigger("DELETESINGLETON", delete_tuple, std::bind(&data_t::unwrap_delete_DELETESINGLETON, this, std::placeholders::_1));
      pb.add_trigger("BTREE", insert_tuple, std::bind(&data_t::unwrap_insert_BTREE, this, std::placeholders::_1));
      pb.add_trigger("BTREE", delete_tuple, std::bind(&data_t::unwrap_delete_BTREE, this, std::placeholders::_1));
      pb.add_trigger("CONCAT", insert_tuple, std::bind(&data_t::unwrap_insert_CONCAT, this, std::placeholders::_1));
      pb.add_trigger("CONCAT", delete_tuple, std::bind(&data_t::unwrap_delete_CONCAT, this, std::placeholders::_1));
      pb.add_trigger("ARRAY", insert_tuple, std::bind(&data_t::unwrap_insert_ARRAY, this, std::placeholders::_1));
      pb.add_trigger("ARRAY", delete_tuple, std::bind(&data_t::unwrap_delete_ARRAY, this, std::placeholders::_1));
      pb.add_trigger("SINGLETON", insert_tuple, std::bind(&data_t::unwrap_insert_SINGLETON, this, std::placeholders::_1));
      pb.add_trigger("SINGLETON", delete_tuple, std::bind(&data_t::unwrap_delete_SINGLETON, this, std::placeholders::_1));
    
      
    
    }
  
    /* Trigger functions for table relations */
    
    
    /* Trigger functions for stream relations */
    void on_insert_DELETESINGLETON(const long deletesingleton_iter_id, const long deletesingleton_node_self, const long deletesingleton_node_child, const long deletesingleton_key) {
      
      ++tN;
      long agg1 = 0L;
      { //slice
        const HASH_RES_t h1 = QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::hash(se2.modify0(deletesingleton_node_child));
        const HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0* i1 = static_cast<HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0*>(QUERY_3_COUNT_mSINGLETON1_mCONCAT1.index[1]);
        HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0::IdxNode* n1 = &(i1->buckets_[h1 & i1->mask_]);
        QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* e1;
        do if ((e1 = n1->obj) && h1 == n1->hash && QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::equals(se2, *e1)) {
          long btree_separator = e1->BTREE_SEPARATOR;
          long v1 = e1->__av;
          (/*if */(btree_separator > deletesingleton_key) ? agg1 += v1 : 0L);
        } while ((n1 = n1->nxt));
      }
      QUERY_5_COUNT.addOrDelOnZero(se1.modify(deletesingleton_node_self), agg1);
      
      QUERY_5_COUNT_mBTREE1.addOrDelOnZero(se3.modify(deletesingleton_node_self, deletesingleton_node_child, deletesingleton_key), 1);
      
      long agg2 = 0L;
      { //slice
        const HASH_RES_t h2 = QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::hash(se5.modify0(deletesingleton_node_child));
        const HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0* i2 = static_cast<HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0*>(QUERY_3_COUNT_mSINGLETON1_mCONCAT1.index[1]);
        HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0::IdxNode* n2 = &(i2->buckets_[h2 & i2->mask_]);
        QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* e2;
        do if ((e2 = n2->obj) && h2 == n2->hash && QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::equals(se5, *e2)) {
          long btree_separator = e2->BTREE_SEPARATOR;
          long v2 = e2->__av;
          (/*if */(deletesingleton_key >= btree_separator) ? agg2 += v2 : 0L);
        } while ((n2 = n2->nxt));
      }
      QUERY_6_COUNT.addOrDelOnZero(se4.modify(deletesingleton_node_self), agg2);
      
      QUERY_7_COUNT.addOrDelOnZero(se6.modify(deletesingleton_node_self), QUERY_2_COUNT_mCONCAT2.getValueOrDefault(se7.modify(deletesingleton_node_child)));
      
      QUERY_7_COUNT_mARRAY1.addOrDelOnZero(se8.modify(deletesingleton_node_self, deletesingleton_node_child), 1);
    }
    
    void unwrap_insert_DELETESINGLETON(const event_args_t& ea) {
      on_insert_DELETESINGLETON(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())));
    }
    
    void on_delete_DELETESINGLETON(const long deletesingleton_iter_id, const long deletesingleton_node_self, const long deletesingleton_node_child, const long deletesingleton_key) {
      
      ++tN;
      long agg3 = 0L;
      { //slice
        const HASH_RES_t h3 = QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::hash(se10.modify0(deletesingleton_node_child));
        const HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0* i3 = static_cast<HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0*>(QUERY_3_COUNT_mSINGLETON1_mCONCAT1.index[1]);
        HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0::IdxNode* n3 = &(i3->buckets_[h3 & i3->mask_]);
        QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* e3;
        do if ((e3 = n3->obj) && h3 == n3->hash && QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::equals(se10, *e3)) {
          long btree_separator = e3->BTREE_SEPARATOR;
          long v3 = e3->__av;
          (/*if */(btree_separator > deletesingleton_key) ? agg3 += v3 : 0L);
        } while ((n3 = n3->nxt));
      }
      QUERY_5_COUNT.addOrDelOnZero(se9.modify(deletesingleton_node_self), (agg3 * -1));
      
      QUERY_5_COUNT_mBTREE1.addOrDelOnZero(se11.modify(deletesingleton_node_self, deletesingleton_node_child, deletesingleton_key), -1);
      
      long agg4 = 0L;
      { //slice
        const HASH_RES_t h4 = QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::hash(se13.modify0(deletesingleton_node_child));
        const HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0* i4 = static_cast<HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0*>(QUERY_3_COUNT_mSINGLETON1_mCONCAT1.index[1]);
        HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0::IdxNode* n4 = &(i4->buckets_[h4 & i4->mask_]);
        QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* e4;
        do if ((e4 = n4->obj) && h4 == n4->hash && QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::equals(se13, *e4)) {
          long btree_separator = e4->BTREE_SEPARATOR;
          long v4 = e4->__av;
          (/*if */(deletesingleton_key >= btree_separator) ? agg4 += v4 : 0L);
        } while ((n4 = n4->nxt));
      }
      QUERY_6_COUNT.addOrDelOnZero(se12.modify(deletesingleton_node_self), (agg4 * -1));
      
      QUERY_7_COUNT.addOrDelOnZero(se14.modify(deletesingleton_node_self), (QUERY_2_COUNT_mCONCAT2.getValueOrDefault(se15.modify(deletesingleton_node_child)) * -1));
      
      QUERY_7_COUNT_mARRAY1.addOrDelOnZero(se16.modify(deletesingleton_node_self, deletesingleton_node_child), -1);
    }
    
    void unwrap_delete_DELETESINGLETON(const event_args_t& ea) {
      on_delete_DELETESINGLETON(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())));
    }
    
    void on_insert_BTREE(const long btree_iter_id, const long btree_node_self, const long btree_node_left, const long btree_node_right, const long btree_separator) {
      
      ++tN;
      { //slice
        const HASH_RES_t h5 = QUERY_2_COUNT_mBTREE1_mapkey1_idxfn::hash(se18.modify1(btree_node_self));
        const HashIndex_QUERY_2_COUNT_mBTREE1_map_1* i5 = static_cast<HashIndex_QUERY_2_COUNT_mBTREE1_map_1*>(QUERY_2_COUNT_mBTREE1.index[1]);
        HashIndex_QUERY_2_COUNT_mBTREE1_map_1::IdxNode* n5 = &(i5->buckets_[h5 & i5->mask_]);
        QUERY_2_COUNT_mBTREE1_entry* e5;
        do if ((e5 = n5->obj) && h5 == n5->hash && QUERY_2_COUNT_mBTREE1_mapkey1_idxfn::equals(se18, *e5)) {
          long concat_node_self = e5->CONCAT_NODE_SELF;
          long v5 = e5->__av;
          QUERY_2_COUNT.addOrDelOnZero(se17.modify(concat_node_self), v5);
        } while ((n5 = n5->nxt));
      }
      
      { //slice
        const HASH_RES_t h6 = QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey1_idxfn::hash(se20.modify1(btree_node_self));
        const HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1* i6 = static_cast<HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1*>(QUERY_2_COUNT_mARRAY1_mBTREE1.index[1]);
        HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1::IdxNode* n6 = &(i6->buckets_[h6 & i6->mask_]);
        QUERY_2_COUNT_mARRAY1_mBTREE1_entry* e6;
        do if ((e6 = n6->obj) && h6 == n6->hash && QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey1_idxfn::equals(se20, *e6)) {
          long concat_node_self = e6->CONCAT_NODE_SELF;
          long query_2_count_marrayarray_node_self = e6->QUERY_2_COUNT_mARRAYARRAY_NODE_SELF;
          long v6 = e6->__av;
          QUERY_2_COUNT_mARRAY1.addOrDelOnZero(se19.modify(concat_node_self, query_2_count_marrayarray_node_self), v6);
        } while ((n6 = n6->nxt));
      }
      
      QUERY_2_COUNT_mCONCAT1.addOrDelOnZero(se21.modify(btree_node_self), 1);
      
      { //slice
        const HASH_RES_t h7 = QUERY_3_COUNT_mBTREE1_mapkey1_idxfn::hash(se23.modify1(btree_node_self));
        const HashIndex_QUERY_3_COUNT_mBTREE1_map_1* i7 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_map_1*>(QUERY_3_COUNT_mBTREE1.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_map_1::IdxNode* n7 = &(i7->buckets_[h7 & i7->mask_]);
        QUERY_3_COUNT_mBTREE1_entry* e7;
        do if ((e7 = n7->obj) && h7 == n7->hash && QUERY_3_COUNT_mBTREE1_mapkey1_idxfn::equals(se23, *e7)) {
          long concat_node_self = e7->CONCAT_NODE_SELF;
          long singleton_key = e7->SINGLETON_KEY;
          long v7 = e7->__av;
          if (btree_separator > singleton_key) {
            QUERY_3_COUNT.addOrDelOnZero(se22.modify(concat_node_self), v7);
          }
        } while ((n7 = n7->nxt));
      }
      
      { //slice
        const HASH_RES_t h8 = QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey1_idxfn::hash(se25.modify1(btree_node_self));
        const HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1* i8 = static_cast<HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1*>(QUERY_2_COUNT_mARRAY1_mBTREE1.index[1]);
        HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1::IdxNode* n8 = &(i8->buckets_[h8 & i8->mask_]);
        QUERY_2_COUNT_mARRAY1_mBTREE1_entry* e8;
        do if ((e8 = n8->obj) && h8 == n8->hash && QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey1_idxfn::equals(se25, *e8)) {
          long concat_node_self = e8->CONCAT_NODE_SELF;
          long query_3_count_msingletonsingleton_node_self = e8->QUERY_2_COUNT_mARRAYARRAY_NODE_SELF;
          long v8 = e8->__av;
          QUERY_3_COUNT_mSINGLETON1.addOrDelOnZero(se24.modify(concat_node_self, query_3_count_msingletonsingleton_node_self, btree_separator), v8);
        } while ((n8 = n8->nxt));
      }
      
      QUERY_3_COUNT_mSINGLETON1_mCONCAT1.addOrDelOnZero(se26.modify(btree_node_self, btree_separator), 1);
      
      agg5.clear();
      { //foreach
        QUERY_3_COUNT_mBTREE1_mCONCAT1_entry* e9 = QUERY_3_COUNT_mBTREE1_mCONCAT1.head;
        while (e9) {
          long query_3_count_mconcatconcat_node_right = e9->QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT;
          long singleton_key = e9->SINGLETON_KEY;
          long v9 = e9->__av;
          (/*if */(btree_separator > singleton_key) ? add_to_temp_map(agg5, st1.modify(query_3_count_mconcatconcat_node_right), v9) : (void)0);
          e9 = e9->nxt;
        }
      }
      { // temp foreach
        tuple2_L_L* e10 = agg5.head;
        while(e10) {
          long query_3_count_mconcatconcat_node_right = e10->_1; 
          long v10 = e10->__av; 
      
          QUERY_3_COUNT_mCONCAT1.addOrDelOnZero(se27.modify(btree_node_self, query_3_count_mconcatconcat_node_right), v10);
      
          e10 = e10->nxt;
        }
      }
      
      { //slice
        const HASH_RES_t h9 = QUERY_3_COUNT_mBTREE1_mapkey1_idxfn::hash(se29.modify1(btree_node_self));
        const HashIndex_QUERY_3_COUNT_mBTREE1_map_1* i9 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_map_1*>(QUERY_3_COUNT_mBTREE1.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_map_1::IdxNode* n9 = &(i9->buckets_[h9 & i9->mask_]);
        QUERY_3_COUNT_mBTREE1_entry* e11;
        do if ((e11 = n9->obj) && h9 == n9->hash && QUERY_3_COUNT_mBTREE1_mapkey1_idxfn::equals(se29, *e11)) {
          long concat_node_self = e11->CONCAT_NODE_SELF;
          long singleton_key = e11->SINGLETON_KEY;
          long v11 = e11->__av;
          if (singleton_key >= btree_separator) {
            QUERY_4_COUNT.addOrDelOnZero(se28.modify(concat_node_self), v11);
          }
        } while ((n9 = n9->nxt));
      }
      
      agg6.clear();
      { //foreach
        QUERY_3_COUNT_mBTREE1_mCONCAT1_entry* e12 = QUERY_3_COUNT_mBTREE1_mCONCAT1.head;
        while (e12) {
          long query_4_count_mconcatconcat_node_right = e12->QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT;
          long singleton_key = e12->SINGLETON_KEY;
          long v12 = e12->__av;
          (/*if */(singleton_key >= btree_separator) ? add_to_temp_map(agg6, st2.modify(query_4_count_mconcatconcat_node_right), v12) : (void)0);
          e12 = e12->nxt;
        }
      }
      { // temp foreach
        tuple2_L_L* e13 = agg6.head;
        while(e13) {
          long query_4_count_mconcatconcat_node_right = e13->_1; 
          long v13 = e13->__av; 
      
          QUERY_4_COUNT_mCONCAT1.addOrDelOnZero(se30.modify(btree_node_self, query_4_count_mconcatconcat_node_right), v13);
      
          e13 = e13->nxt;
        }
      }
      
      { //slice
        const HASH_RES_t h10 = QUERY_5_COUNT_mBTREE1_mapkey1_idxfn::hash(se32.modify1(btree_node_self));
        const HashIndex_QUERY_5_COUNT_mBTREE1_map_1* i10 = static_cast<HashIndex_QUERY_5_COUNT_mBTREE1_map_1*>(QUERY_5_COUNT_mBTREE1.index[1]);
        HashIndex_QUERY_5_COUNT_mBTREE1_map_1::IdxNode* n10 = &(i10->buckets_[h10 & i10->mask_]);
        QUERY_5_COUNT_mBTREE1_entry* e14;
        do if ((e14 = n10->obj) && h10 == n10->hash && QUERY_5_COUNT_mBTREE1_mapkey1_idxfn::equals(se32, *e14)) {
          long deletesingleton_node_self = e14->DELETESINGLETON_NODE_SELF;
          long deletesingleton_key = e14->DELETESINGLETON_KEY;
          long v14 = e14->__av;
          if (btree_separator > deletesingleton_key) {
            QUERY_5_COUNT.addOrDelOnZero(se31.modify(deletesingleton_node_self), v14);
          }
        } while ((n10 = n10->nxt));
      }
      
      { //slice
        const HASH_RES_t h11 = QUERY_5_COUNT_mBTREE1_mapkey1_idxfn::hash(se34.modify1(btree_node_self));
        const HashIndex_QUERY_5_COUNT_mBTREE1_map_1* i11 = static_cast<HashIndex_QUERY_5_COUNT_mBTREE1_map_1*>(QUERY_5_COUNT_mBTREE1.index[1]);
        HashIndex_QUERY_5_COUNT_mBTREE1_map_1::IdxNode* n11 = &(i11->buckets_[h11 & i11->mask_]);
        QUERY_5_COUNT_mBTREE1_entry* e15;
        do if ((e15 = n11->obj) && h11 == n11->hash && QUERY_5_COUNT_mBTREE1_mapkey1_idxfn::equals(se34, *e15)) {
          long deletesingleton_node_self = e15->DELETESINGLETON_NODE_SELF;
          long deletesingleton_key = e15->DELETESINGLETON_KEY;
          long v15 = e15->__av;
          if (deletesingleton_key >= btree_separator) {
            QUERY_6_COUNT.addOrDelOnZero(se33.modify(deletesingleton_node_self), v15);
          }
        } while ((n11 = n11->nxt));
      }
    }
    
    void unwrap_insert_BTREE(const event_args_t& ea) {
      on_insert_BTREE(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())), *(reinterpret_cast<long*>(ea[4].get())));
    }
    
    void on_delete_BTREE(const long btree_iter_id, const long btree_node_self, const long btree_node_left, const long btree_node_right, const long btree_separator) {
      
      ++tN;
      { //slice
        const HASH_RES_t h12 = QUERY_2_COUNT_mBTREE1_mapkey1_idxfn::hash(se36.modify1(btree_node_self));
        const HashIndex_QUERY_2_COUNT_mBTREE1_map_1* i12 = static_cast<HashIndex_QUERY_2_COUNT_mBTREE1_map_1*>(QUERY_2_COUNT_mBTREE1.index[1]);
        HashIndex_QUERY_2_COUNT_mBTREE1_map_1::IdxNode* n12 = &(i12->buckets_[h12 & i12->mask_]);
        QUERY_2_COUNT_mBTREE1_entry* e16;
        do if ((e16 = n12->obj) && h12 == n12->hash && QUERY_2_COUNT_mBTREE1_mapkey1_idxfn::equals(se36, *e16)) {
          long concat_node_self = e16->CONCAT_NODE_SELF;
          long v16 = e16->__av;
          QUERY_2_COUNT.addOrDelOnZero(se35.modify(concat_node_self), (v16 * -1));
        } while ((n12 = n12->nxt));
      }
      
      { //slice
        const HASH_RES_t h13 = QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey1_idxfn::hash(se38.modify1(btree_node_self));
        const HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1* i13 = static_cast<HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1*>(QUERY_2_COUNT_mARRAY1_mBTREE1.index[1]);
        HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1::IdxNode* n13 = &(i13->buckets_[h13 & i13->mask_]);
        QUERY_2_COUNT_mARRAY1_mBTREE1_entry* e17;
        do if ((e17 = n13->obj) && h13 == n13->hash && QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey1_idxfn::equals(se38, *e17)) {
          long concat_node_self = e17->CONCAT_NODE_SELF;
          long query_2_count_marrayarray_node_self = e17->QUERY_2_COUNT_mARRAYARRAY_NODE_SELF;
          long v17 = e17->__av;
          QUERY_2_COUNT_mARRAY1.addOrDelOnZero(se37.modify(concat_node_self, query_2_count_marrayarray_node_self), (v17 * -1));
        } while ((n13 = n13->nxt));
      }
      
      QUERY_2_COUNT_mCONCAT1.addOrDelOnZero(se39.modify(btree_node_self), -1);
      
      { //slice
        const HASH_RES_t h14 = QUERY_3_COUNT_mBTREE1_mapkey1_idxfn::hash(se41.modify1(btree_node_self));
        const HashIndex_QUERY_3_COUNT_mBTREE1_map_1* i14 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_map_1*>(QUERY_3_COUNT_mBTREE1.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_map_1::IdxNode* n14 = &(i14->buckets_[h14 & i14->mask_]);
        QUERY_3_COUNT_mBTREE1_entry* e18;
        do if ((e18 = n14->obj) && h14 == n14->hash && QUERY_3_COUNT_mBTREE1_mapkey1_idxfn::equals(se41, *e18)) {
          long concat_node_self = e18->CONCAT_NODE_SELF;
          long singleton_key = e18->SINGLETON_KEY;
          long v18 = e18->__av;
          if ((btree_separator > singleton_key)) {
            QUERY_3_COUNT.addOrDelOnZero(se40.modify(concat_node_self), (v18 * -1));
          }
        } while ((n14 = n14->nxt));
      }
      
      { //slice
        const HASH_RES_t h15 = QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey1_idxfn::hash(se43.modify1(btree_node_self));
        const HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1* i15 = static_cast<HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1*>(QUERY_2_COUNT_mARRAY1_mBTREE1.index[1]);
        HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_1::IdxNode* n15 = &(i15->buckets_[h15 & i15->mask_]);
        QUERY_2_COUNT_mARRAY1_mBTREE1_entry* e19;
        do if ((e19 = n15->obj) && h15 == n15->hash && QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey1_idxfn::equals(se43, *e19)) {
          long concat_node_self = e19->CONCAT_NODE_SELF;
          long query_3_count_msingletonsingleton_node_self = e19->QUERY_2_COUNT_mARRAYARRAY_NODE_SELF;
          long v19 = e19->__av;
          QUERY_3_COUNT_mSINGLETON1.addOrDelOnZero(se42.modify(concat_node_self, query_3_count_msingletonsingleton_node_self, btree_separator), (v19 * -1));
        } while ((n15 = n15->nxt));
      }
      
      QUERY_3_COUNT_mSINGLETON1_mCONCAT1.addOrDelOnZero(se44.modify(btree_node_self, btree_separator), -1);
      
      agg7.clear();
      { //foreach
        QUERY_3_COUNT_mBTREE1_mCONCAT1_entry* e20 = QUERY_3_COUNT_mBTREE1_mCONCAT1.head;
        while (e20) {
          long query_3_count_mconcatconcat_node_right = e20->QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT;
          long singleton_key = e20->SINGLETON_KEY;
          long v20 = e20->__av;
          (/*if */(btree_separator > singleton_key) ? add_to_temp_map(agg7, st3.modify(query_3_count_mconcatconcat_node_right), v20) : (void)0);
          e20 = e20->nxt;
        }
      }
      { // temp foreach
        tuple2_L_L* e21 = agg7.head;
        while(e21) {
          long query_3_count_mconcatconcat_node_right = e21->_1; 
          long v21 = e21->__av; 
      
          QUERY_3_COUNT_mCONCAT1.addOrDelOnZero(se45.modify(btree_node_self, query_3_count_mconcatconcat_node_right), (v21 * -1));
      
          e21 = e21->nxt;
        }
      }
      
      { //slice
        const HASH_RES_t h16 = QUERY_3_COUNT_mBTREE1_mapkey1_idxfn::hash(se47.modify1(btree_node_self));
        const HashIndex_QUERY_3_COUNT_mBTREE1_map_1* i16 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_map_1*>(QUERY_3_COUNT_mBTREE1.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_map_1::IdxNode* n16 = &(i16->buckets_[h16 & i16->mask_]);
        QUERY_3_COUNT_mBTREE1_entry* e22;
        do if ((e22 = n16->obj) && h16 == n16->hash && QUERY_3_COUNT_mBTREE1_mapkey1_idxfn::equals(se47, *e22)) {
          long concat_node_self = e22->CONCAT_NODE_SELF;
          long singleton_key = e22->SINGLETON_KEY;
          long v22 = e22->__av;
          if ((singleton_key >= btree_separator)) {
            QUERY_4_COUNT.addOrDelOnZero(se46.modify(concat_node_self), (v22 * -1));
          }
        } while ((n16 = n16->nxt));
      }
      
      agg8.clear();
      { //foreach
        QUERY_3_COUNT_mBTREE1_mCONCAT1_entry* e23 = QUERY_3_COUNT_mBTREE1_mCONCAT1.head;
        while (e23) {
          long query_4_count_mconcatconcat_node_right = e23->QUERY_3_COUNT_mBTREE1_mCONCATCONCAT_NODE_RIGHT;
          long singleton_key = e23->SINGLETON_KEY;
          long v23 = e23->__av;
          (/*if */(singleton_key >= btree_separator) ? add_to_temp_map(agg8, st4.modify(query_4_count_mconcatconcat_node_right), v23) : (void)0);
          e23 = e23->nxt;
        }
      }
      { // temp foreach
        tuple2_L_L* e24 = agg8.head;
        while(e24) {
          long query_4_count_mconcatconcat_node_right = e24->_1; 
          long v24 = e24->__av; 
      
          QUERY_4_COUNT_mCONCAT1.addOrDelOnZero(se48.modify(btree_node_self, query_4_count_mconcatconcat_node_right), (v24 * -1));
      
          e24 = e24->nxt;
        }
      }
      
      { //slice
        const HASH_RES_t h17 = QUERY_5_COUNT_mBTREE1_mapkey1_idxfn::hash(se50.modify1(btree_node_self));
        const HashIndex_QUERY_5_COUNT_mBTREE1_map_1* i17 = static_cast<HashIndex_QUERY_5_COUNT_mBTREE1_map_1*>(QUERY_5_COUNT_mBTREE1.index[1]);
        HashIndex_QUERY_5_COUNT_mBTREE1_map_1::IdxNode* n17 = &(i17->buckets_[h17 & i17->mask_]);
        QUERY_5_COUNT_mBTREE1_entry* e25;
        do if ((e25 = n17->obj) && h17 == n17->hash && QUERY_5_COUNT_mBTREE1_mapkey1_idxfn::equals(se50, *e25)) {
          long deletesingleton_node_self = e25->DELETESINGLETON_NODE_SELF;
          long deletesingleton_key = e25->DELETESINGLETON_KEY;
          long v25 = e25->__av;
          if ((btree_separator > deletesingleton_key)) {
            QUERY_5_COUNT.addOrDelOnZero(se49.modify(deletesingleton_node_self), (v25 * -1));
          }
        } while ((n17 = n17->nxt));
      }
      
      { //slice
        const HASH_RES_t h18 = QUERY_5_COUNT_mBTREE1_mapkey1_idxfn::hash(se52.modify1(btree_node_self));
        const HashIndex_QUERY_5_COUNT_mBTREE1_map_1* i18 = static_cast<HashIndex_QUERY_5_COUNT_mBTREE1_map_1*>(QUERY_5_COUNT_mBTREE1.index[1]);
        HashIndex_QUERY_5_COUNT_mBTREE1_map_1::IdxNode* n18 = &(i18->buckets_[h18 & i18->mask_]);
        QUERY_5_COUNT_mBTREE1_entry* e26;
        do if ((e26 = n18->obj) && h18 == n18->hash && QUERY_5_COUNT_mBTREE1_mapkey1_idxfn::equals(se52, *e26)) {
          long deletesingleton_node_self = e26->DELETESINGLETON_NODE_SELF;
          long deletesingleton_key = e26->DELETESINGLETON_KEY;
          long v26 = e26->__av;
          if ((deletesingleton_key >= btree_separator)) {
            QUERY_6_COUNT.addOrDelOnZero(se51.modify(deletesingleton_node_self), (v26 * -1));
          }
        } while ((n18 = n18->nxt));
      }
    }
    
    void unwrap_delete_BTREE(const event_args_t& ea) {
      on_delete_BTREE(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())), *(reinterpret_cast<long*>(ea[4].get())));
    }
    
    void on_insert_CONCAT(const long concat_iter_id, const long concat_node_self, const long concat_node_left, const long concat_node_right) {
      
      ++tN;
      QUERY_2_COUNT.addOrDelOnZero(se53.modify(concat_node_self), (QUERY_2_COUNT_mCONCAT1.getValueOrDefault(se54.modify(concat_node_left)) * QUERY_2_COUNT_mCONCAT2.getValueOrDefault(se55.modify(concat_node_right))));
      
      QUERY_2_COUNT_mARRAY1.addOrDelOnZero(se56.modify(concat_node_self, concat_node_right), QUERY_2_COUNT_mCONCAT1.getValueOrDefault(se57.modify(concat_node_left)));
      
      QUERY_2_COUNT_mARRAY1_mBTREE1.addOrDelOnZero(se58.modify(concat_node_self, concat_node_left, concat_node_right), 1);
      
      QUERY_2_COUNT_mBTREE1.addOrDelOnZero(se59.modify(concat_node_self, concat_node_left), QUERY_2_COUNT_mCONCAT2.getValueOrDefault(se60.modify(concat_node_right)));
      
      QUERY_3_COUNT.addOrDelOnZero(se61.modify(concat_node_self), QUERY_3_COUNT_mCONCAT1.getValueOrDefault(se62.modify(concat_node_left, concat_node_right)));
      
      { //slice
        const HASH_RES_t h19 = QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::hash(se64.modify0(concat_node_left));
        const HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0* i19 = static_cast<HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0*>(QUERY_3_COUNT_mSINGLETON1_mCONCAT1.index[1]);
        HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0::IdxNode* n19 = &(i19->buckets_[h19 & i19->mask_]);
        QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* e27;
        do if ((e27 = n19->obj) && h19 == n19->hash && QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::equals(se64, *e27)) {
          long btree_separator = e27->BTREE_SEPARATOR;
          long v27 = e27->__av;
          QUERY_3_COUNT_mSINGLETON1.addOrDelOnZero(se63.modify(concat_node_self, concat_node_right, btree_separator), v27);
        } while ((n19 = n19->nxt));
      }
      
      { //slice
        const HASH_RES_t h20 = QUERY_3_COUNT_mBTREE1_mCONCAT1_mapkey0_idxfn::hash(se66.modify0(concat_node_right));
        const HashIndex_QUERY_3_COUNT_mBTREE1_mCONCAT1_map_0* i20 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_mCONCAT1_map_0*>(QUERY_3_COUNT_mBTREE1_mCONCAT1.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_mCONCAT1_map_0::IdxNode* n20 = &(i20->buckets_[h20 & i20->mask_]);
        QUERY_3_COUNT_mBTREE1_mCONCAT1_entry* e28;
        do if ((e28 = n20->obj) && h20 == n20->hash && QUERY_3_COUNT_mBTREE1_mCONCAT1_mapkey0_idxfn::equals(se66, *e28)) {
          long singleton_key = e28->SINGLETON_KEY;
          long v28 = e28->__av;
          QUERY_3_COUNT_mBTREE1.addOrDelOnZero(se65.modify(concat_node_self, concat_node_left, singleton_key), v28);
        } while ((n20 = n20->nxt));
      }
      
      QUERY_4_COUNT.addOrDelOnZero(se67.modify(concat_node_self), QUERY_4_COUNT_mCONCAT1.getValueOrDefault(se68.modify(concat_node_left, concat_node_right)));
    }
    
    void unwrap_insert_CONCAT(const event_args_t& ea) {
      on_insert_CONCAT(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())));
    }
    
    void on_delete_CONCAT(const long concat_iter_id, const long concat_node_self, const long concat_node_left, const long concat_node_right) {
      
      ++tN;
      QUERY_2_COUNT.addOrDelOnZero(se69.modify(concat_node_self), (QUERY_2_COUNT_mCONCAT1.getValueOrDefault(se70.modify(concat_node_left)) * (QUERY_2_COUNT_mCONCAT2.getValueOrDefault(se71.modify(concat_node_right)) * -1)));
      
      QUERY_2_COUNT_mARRAY1.addOrDelOnZero(se72.modify(concat_node_self, concat_node_right), (QUERY_2_COUNT_mCONCAT1.getValueOrDefault(se73.modify(concat_node_left)) * -1));
      
      QUERY_2_COUNT_mARRAY1_mBTREE1.addOrDelOnZero(se74.modify(concat_node_self, concat_node_left, concat_node_right), -1);
      
      QUERY_2_COUNT_mBTREE1.addOrDelOnZero(se75.modify(concat_node_self, concat_node_left), (QUERY_2_COUNT_mCONCAT2.getValueOrDefault(se76.modify(concat_node_right)) * -1));
      
      QUERY_3_COUNT.addOrDelOnZero(se77.modify(concat_node_self), (QUERY_3_COUNT_mCONCAT1.getValueOrDefault(se78.modify(concat_node_left, concat_node_right)) * -1));
      
      { //slice
        const HASH_RES_t h21 = QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::hash(se80.modify0(concat_node_left));
        const HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0* i21 = static_cast<HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0*>(QUERY_3_COUNT_mSINGLETON1_mCONCAT1.index[1]);
        HashIndex_QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map_0::IdxNode* n21 = &(i21->buckets_[h21 & i21->mask_]);
        QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* e29;
        do if ((e29 = n21->obj) && h21 == n21->hash && QUERY_3_COUNT_mSINGLETON1_mCONCAT1_mapkey0_idxfn::equals(se80, *e29)) {
          long btree_separator = e29->BTREE_SEPARATOR;
          long v29 = e29->__av;
          QUERY_3_COUNT_mSINGLETON1.addOrDelOnZero(se79.modify(concat_node_self, concat_node_right, btree_separator), (v29 * -1));
        } while ((n21 = n21->nxt));
      }
      
      { //slice
        const HASH_RES_t h22 = QUERY_3_COUNT_mBTREE1_mCONCAT1_mapkey0_idxfn::hash(se82.modify0(concat_node_right));
        const HashIndex_QUERY_3_COUNT_mBTREE1_mCONCAT1_map_0* i22 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_mCONCAT1_map_0*>(QUERY_3_COUNT_mBTREE1_mCONCAT1.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_mCONCAT1_map_0::IdxNode* n22 = &(i22->buckets_[h22 & i22->mask_]);
        QUERY_3_COUNT_mBTREE1_mCONCAT1_entry* e30;
        do if ((e30 = n22->obj) && h22 == n22->hash && QUERY_3_COUNT_mBTREE1_mCONCAT1_mapkey0_idxfn::equals(se82, *e30)) {
          long singleton_key = e30->SINGLETON_KEY;
          long v30 = e30->__av;
          QUERY_3_COUNT_mBTREE1.addOrDelOnZero(se81.modify(concat_node_self, concat_node_left, singleton_key), (v30 * -1));
        } while ((n22 = n22->nxt));
      }
      
      QUERY_4_COUNT.addOrDelOnZero(se83.modify(concat_node_self), (QUERY_4_COUNT_mCONCAT1.getValueOrDefault(se84.modify(concat_node_left, concat_node_right)) * -1));
    }
    
    void unwrap_delete_CONCAT(const event_args_t& ea) {
      on_delete_CONCAT(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())));
    }
    
    void on_insert_ARRAY(const long array_iter_id, const long array_node_self, const long array_size) {
      
      ++tN;
      if (array_size > 100) {
        QUERY_1_COUNT.addOrDelOnZero(se85.modify(array_node_self), 1);
      }
      
      { //slice
        const HASH_RES_t h23 = QUERY_2_COUNT_mARRAY1_mapkey1_idxfn::hash(se87.modify1(array_node_self));
        const HashIndex_QUERY_2_COUNT_mARRAY1_map_1* i23 = static_cast<HashIndex_QUERY_2_COUNT_mARRAY1_map_1*>(QUERY_2_COUNT_mARRAY1.index[1]);
        HashIndex_QUERY_2_COUNT_mARRAY1_map_1::IdxNode* n23 = &(i23->buckets_[h23 & i23->mask_]);
        QUERY_2_COUNT_mARRAY1_entry* e31;
        do if ((e31 = n23->obj) && h23 == n23->hash && QUERY_2_COUNT_mARRAY1_mapkey1_idxfn::equals(se87, *e31)) {
          long concat_node_self = e31->CONCAT_NODE_SELF;
          long v31 = e31->__av;
          QUERY_2_COUNT.addOrDelOnZero(se86.modify(concat_node_self), v31);
        } while ((n23 = n23->nxt));
      }
      
      { //slice
        const HASH_RES_t h24 = QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey2_idxfn::hash(se89.modify2(array_node_self));
        const HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2* i24 = static_cast<HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2*>(QUERY_2_COUNT_mARRAY1_mBTREE1.index[2]);
        HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2::IdxNode* n24 = &(i24->buckets_[h24 & i24->mask_]);
        QUERY_2_COUNT_mARRAY1_mBTREE1_entry* e32;
        do if ((e32 = n24->obj) && h24 == n24->hash && QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey2_idxfn::equals(se89, *e32)) {
          long concat_node_self = e32->CONCAT_NODE_SELF;
          long query_2_count_mbtreebtree_node_self = e32->QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF;
          long v32 = e32->__av;
          QUERY_2_COUNT_mBTREE1.addOrDelOnZero(se88.modify(concat_node_self, query_2_count_mbtreebtree_node_self), v32);
        } while ((n24 = n24->nxt));
      }
      
      QUERY_2_COUNT_mCONCAT2.addOrDelOnZero(se90.modify(array_node_self), 1);
      
      { //slice
        const HASH_RES_t h25 = QUERY_7_COUNT_mARRAY1_mapkey1_idxfn::hash(se92.modify1(array_node_self));
        const HashIndex_QUERY_7_COUNT_mARRAY1_map_1* i25 = static_cast<HashIndex_QUERY_7_COUNT_mARRAY1_map_1*>(QUERY_7_COUNT_mARRAY1.index[1]);
        HashIndex_QUERY_7_COUNT_mARRAY1_map_1::IdxNode* n25 = &(i25->buckets_[h25 & i25->mask_]);
        QUERY_7_COUNT_mARRAY1_entry* e33;
        do if ((e33 = n25->obj) && h25 == n25->hash && QUERY_7_COUNT_mARRAY1_mapkey1_idxfn::equals(se92, *e33)) {
          long deletesingleton_node_self = e33->DELETESINGLETON_NODE_SELF;
          long v33 = e33->__av;
          QUERY_7_COUNT.addOrDelOnZero(se91.modify(deletesingleton_node_self), v33);
        } while ((n25 = n25->nxt));
      }
    }
    
    void unwrap_insert_ARRAY(const event_args_t& ea) {
      on_insert_ARRAY(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())));
    }
    
    void on_delete_ARRAY(const long array_iter_id, const long array_node_self, const long array_size) {
      
      ++tN;
      if ((array_size > 100)) {
        QUERY_1_COUNT.addOrDelOnZero(se93.modify(array_node_self), -1);
      }
      
      { //slice
        const HASH_RES_t h26 = QUERY_2_COUNT_mARRAY1_mapkey1_idxfn::hash(se95.modify1(array_node_self));
        const HashIndex_QUERY_2_COUNT_mARRAY1_map_1* i26 = static_cast<HashIndex_QUERY_2_COUNT_mARRAY1_map_1*>(QUERY_2_COUNT_mARRAY1.index[1]);
        HashIndex_QUERY_2_COUNT_mARRAY1_map_1::IdxNode* n26 = &(i26->buckets_[h26 & i26->mask_]);
        QUERY_2_COUNT_mARRAY1_entry* e34;
        do if ((e34 = n26->obj) && h26 == n26->hash && QUERY_2_COUNT_mARRAY1_mapkey1_idxfn::equals(se95, *e34)) {
          long concat_node_self = e34->CONCAT_NODE_SELF;
          long v34 = e34->__av;
          QUERY_2_COUNT.addOrDelOnZero(se94.modify(concat_node_self), (v34 * -1));
        } while ((n26 = n26->nxt));
      }
      
      { //slice
        const HASH_RES_t h27 = QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey2_idxfn::hash(se97.modify2(array_node_self));
        const HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2* i27 = static_cast<HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2*>(QUERY_2_COUNT_mARRAY1_mBTREE1.index[2]);
        HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2::IdxNode* n27 = &(i27->buckets_[h27 & i27->mask_]);
        QUERY_2_COUNT_mARRAY1_mBTREE1_entry* e35;
        do if ((e35 = n27->obj) && h27 == n27->hash && QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey2_idxfn::equals(se97, *e35)) {
          long concat_node_self = e35->CONCAT_NODE_SELF;
          long query_2_count_mbtreebtree_node_self = e35->QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF;
          long v35 = e35->__av;
          QUERY_2_COUNT_mBTREE1.addOrDelOnZero(se96.modify(concat_node_self, query_2_count_mbtreebtree_node_self), (v35 * -1));
        } while ((n27 = n27->nxt));
      }
      
      QUERY_2_COUNT_mCONCAT2.addOrDelOnZero(se98.modify(array_node_self), -1);
      
      { //slice
        const HASH_RES_t h28 = QUERY_7_COUNT_mARRAY1_mapkey1_idxfn::hash(se100.modify1(array_node_self));
        const HashIndex_QUERY_7_COUNT_mARRAY1_map_1* i28 = static_cast<HashIndex_QUERY_7_COUNT_mARRAY1_map_1*>(QUERY_7_COUNT_mARRAY1.index[1]);
        HashIndex_QUERY_7_COUNT_mARRAY1_map_1::IdxNode* n28 = &(i28->buckets_[h28 & i28->mask_]);
        QUERY_7_COUNT_mARRAY1_entry* e36;
        do if ((e36 = n28->obj) && h28 == n28->hash && QUERY_7_COUNT_mARRAY1_mapkey1_idxfn::equals(se100, *e36)) {
          long deletesingleton_node_self = e36->DELETESINGLETON_NODE_SELF;
          long v36 = e36->__av;
          QUERY_7_COUNT.addOrDelOnZero(se99.modify(deletesingleton_node_self), (v36 * -1));
        } while ((n28 = n28->nxt));
      }
    }
    
    void unwrap_delete_ARRAY(const event_args_t& ea) {
      on_delete_ARRAY(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())));
    }
    
    void on_insert_SINGLETON(const long singleton_iter_id, const long singleton_node_self, const long singleton_key) {
      
      ++tN;
      { //slice
        const HASH_RES_t h29 = QUERY_3_COUNT_mSINGLETON1_mapkey1_idxfn::hash(se102.modify1(singleton_node_self));
        const HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1* i29 = static_cast<HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1*>(QUERY_3_COUNT_mSINGLETON1.index[1]);
        HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1::IdxNode* n29 = &(i29->buckets_[h29 & i29->mask_]);
        QUERY_3_COUNT_mSINGLETON1_entry* e37;
        do if ((e37 = n29->obj) && h29 == n29->hash && QUERY_3_COUNT_mSINGLETON1_mapkey1_idxfn::equals(se102, *e37)) {
          long concat_node_self = e37->CONCAT_NODE_SELF;
          long btree_separator = e37->BTREE_SEPARATOR;
          long v37 = e37->__av;
          if (btree_separator > singleton_key) {
            QUERY_3_COUNT.addOrDelOnZero(se101.modify(concat_node_self), v37);
          }
        } while ((n29 = n29->nxt));
      }
      
      { //slice
        const HASH_RES_t h30 = QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey2_idxfn::hash(se104.modify2(singleton_node_self));
        const HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2* i30 = static_cast<HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2*>(QUERY_2_COUNT_mARRAY1_mBTREE1.index[2]);
        HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2::IdxNode* n30 = &(i30->buckets_[h30 & i30->mask_]);
        QUERY_2_COUNT_mARRAY1_mBTREE1_entry* e38;
        do if ((e38 = n30->obj) && h30 == n30->hash && QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey2_idxfn::equals(se104, *e38)) {
          long concat_node_self = e38->CONCAT_NODE_SELF;
          long query_3_count_mbtreebtree_node_self = e38->QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF;
          long v38 = e38->__av;
          QUERY_3_COUNT_mBTREE1.addOrDelOnZero(se103.modify(concat_node_self, query_3_count_mbtreebtree_node_self, singleton_key), v38);
        } while ((n30 = n30->nxt));
      }
      
      QUERY_3_COUNT_mBTREE1_mCONCAT1.addOrDelOnZero(se105.modify(singleton_node_self, singleton_key), 1);
      
      agg9.clear();
      { //foreach
        QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* e39 = QUERY_3_COUNT_mSINGLETON1_mCONCAT1.head;
        while (e39) {
          long query_3_count_mconcatconcat_node_left = e39->QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT;
          long btree_separator = e39->BTREE_SEPARATOR;
          long v39 = e39->__av;
          (/*if */(btree_separator > singleton_key) ? add_to_temp_map(agg9, st5.modify(query_3_count_mconcatconcat_node_left), v39) : (void)0);
          e39 = e39->nxt;
        }
      }
      { // temp foreach
        tuple2_L_L* e40 = agg9.head;
        while(e40) {
          long query_3_count_mconcatconcat_node_left = e40->_1; 
          long v40 = e40->__av; 
      
          QUERY_3_COUNT_mCONCAT1.addOrDelOnZero(se106.modify(query_3_count_mconcatconcat_node_left, singleton_node_self), v40);
      
          e40 = e40->nxt;
        }
      }
      
      { //slice
        const HASH_RES_t h31 = QUERY_3_COUNT_mSINGLETON1_mapkey1_idxfn::hash(se108.modify1(singleton_node_self));
        const HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1* i31 = static_cast<HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1*>(QUERY_3_COUNT_mSINGLETON1.index[1]);
        HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1::IdxNode* n31 = &(i31->buckets_[h31 & i31->mask_]);
        QUERY_3_COUNT_mSINGLETON1_entry* e41;
        do if ((e41 = n31->obj) && h31 == n31->hash && QUERY_3_COUNT_mSINGLETON1_mapkey1_idxfn::equals(se108, *e41)) {
          long concat_node_self = e41->CONCAT_NODE_SELF;
          long btree_separator = e41->BTREE_SEPARATOR;
          long v41 = e41->__av;
          if (singleton_key >= btree_separator) {
            QUERY_4_COUNT.addOrDelOnZero(se107.modify(concat_node_self), v41);
          }
        } while ((n31 = n31->nxt));
      }
      
      agg10.clear();
      { //foreach
        QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* e42 = QUERY_3_COUNT_mSINGLETON1_mCONCAT1.head;
        while (e42) {
          long query_4_count_mconcatconcat_node_left = e42->QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT;
          long btree_separator = e42->BTREE_SEPARATOR;
          long v42 = e42->__av;
          (/*if */(singleton_key >= btree_separator) ? add_to_temp_map(agg10, st6.modify(query_4_count_mconcatconcat_node_left), v42) : (void)0);
          e42 = e42->nxt;
        }
      }
      { // temp foreach
        tuple2_L_L* e43 = agg10.head;
        while(e43) {
          long query_4_count_mconcatconcat_node_left = e43->_1; 
          long v43 = e43->__av; 
      
          QUERY_4_COUNT_mCONCAT1.addOrDelOnZero(se109.modify(query_4_count_mconcatconcat_node_left, singleton_node_self), v43);
      
          e43 = e43->nxt;
        }
      }
    }
    
    void unwrap_insert_SINGLETON(const event_args_t& ea) {
      on_insert_SINGLETON(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())));
    }
    
    void on_delete_SINGLETON(const long singleton_iter_id, const long singleton_node_self, const long singleton_key) {
      
      ++tN;
      { //slice
        const HASH_RES_t h32 = QUERY_3_COUNT_mSINGLETON1_mapkey1_idxfn::hash(se111.modify1(singleton_node_self));
        const HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1* i32 = static_cast<HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1*>(QUERY_3_COUNT_mSINGLETON1.index[1]);
        HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1::IdxNode* n32 = &(i32->buckets_[h32 & i32->mask_]);
        QUERY_3_COUNT_mSINGLETON1_entry* e44;
        do if ((e44 = n32->obj) && h32 == n32->hash && QUERY_3_COUNT_mSINGLETON1_mapkey1_idxfn::equals(se111, *e44)) {
          long concat_node_self = e44->CONCAT_NODE_SELF;
          long btree_separator = e44->BTREE_SEPARATOR;
          long v44 = e44->__av;
          if ((btree_separator > singleton_key)) {
            QUERY_3_COUNT.addOrDelOnZero(se110.modify(concat_node_self), (v44 * -1));
          }
        } while ((n32 = n32->nxt));
      }
      
      { //slice
        const HASH_RES_t h33 = QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey2_idxfn::hash(se113.modify2(singleton_node_self));
        const HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2* i33 = static_cast<HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2*>(QUERY_2_COUNT_mARRAY1_mBTREE1.index[2]);
        HashIndex_QUERY_2_COUNT_mARRAY1_mBTREE1_map_2::IdxNode* n33 = &(i33->buckets_[h33 & i33->mask_]);
        QUERY_2_COUNT_mARRAY1_mBTREE1_entry* e45;
        do if ((e45 = n33->obj) && h33 == n33->hash && QUERY_2_COUNT_mARRAY1_mBTREE1_mapkey2_idxfn::equals(se113, *e45)) {
          long concat_node_self = e45->CONCAT_NODE_SELF;
          long query_3_count_mbtreebtree_node_self = e45->QUERY_2_COUNT_mARRAY1_mBTREEBTREE_NODE_SELF;
          long v45 = e45->__av;
          QUERY_3_COUNT_mBTREE1.addOrDelOnZero(se112.modify(concat_node_self, query_3_count_mbtreebtree_node_self, singleton_key), (v45 * -1));
        } while ((n33 = n33->nxt));
      }
      
      QUERY_3_COUNT_mBTREE1_mCONCAT1.addOrDelOnZero(se114.modify(singleton_node_self, singleton_key), -1);
      
      agg11.clear();
      { //foreach
        QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* e46 = QUERY_3_COUNT_mSINGLETON1_mCONCAT1.head;
        while (e46) {
          long query_3_count_mconcatconcat_node_left = e46->QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT;
          long btree_separator = e46->BTREE_SEPARATOR;
          long v46 = e46->__av;
          (/*if */(btree_separator > singleton_key) ? add_to_temp_map(agg11, st7.modify(query_3_count_mconcatconcat_node_left), v46) : (void)0);
          e46 = e46->nxt;
        }
      }
      { // temp foreach
        tuple2_L_L* e47 = agg11.head;
        while(e47) {
          long query_3_count_mconcatconcat_node_left = e47->_1; 
          long v47 = e47->__av; 
      
          QUERY_3_COUNT_mCONCAT1.addOrDelOnZero(se115.modify(query_3_count_mconcatconcat_node_left, singleton_node_self), (v47 * -1));
      
          e47 = e47->nxt;
        }
      }
      
      { //slice
        const HASH_RES_t h34 = QUERY_3_COUNT_mSINGLETON1_mapkey1_idxfn::hash(se117.modify1(singleton_node_self));
        const HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1* i34 = static_cast<HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1*>(QUERY_3_COUNT_mSINGLETON1.index[1]);
        HashIndex_QUERY_3_COUNT_mSINGLETON1_map_1::IdxNode* n34 = &(i34->buckets_[h34 & i34->mask_]);
        QUERY_3_COUNT_mSINGLETON1_entry* e48;
        do if ((e48 = n34->obj) && h34 == n34->hash && QUERY_3_COUNT_mSINGLETON1_mapkey1_idxfn::equals(se117, *e48)) {
          long concat_node_self = e48->CONCAT_NODE_SELF;
          long btree_separator = e48->BTREE_SEPARATOR;
          long v48 = e48->__av;
          if ((singleton_key >= btree_separator)) {
            QUERY_4_COUNT.addOrDelOnZero(se116.modify(concat_node_self), (v48 * -1));
          }
        } while ((n34 = n34->nxt));
      }
      
      agg12.clear();
      { //foreach
        QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry* e49 = QUERY_3_COUNT_mSINGLETON1_mCONCAT1.head;
        while (e49) {
          long query_4_count_mconcatconcat_node_left = e49->QUERY_3_COUNT_mSINGLETON1_mCONCATCONCAT_NODE_LEFT;
          long btree_separator = e49->BTREE_SEPARATOR;
          long v49 = e49->__av;
          (/*if */(singleton_key >= btree_separator) ? add_to_temp_map(agg12, st8.modify(query_4_count_mconcatconcat_node_left), v49) : (void)0);
          e49 = e49->nxt;
        }
      }
      { // temp foreach
        tuple2_L_L* e50 = agg12.head;
        while(e50) {
          long query_4_count_mconcatconcat_node_left = e50->_1; 
          long v50 = e50->__av; 
      
          QUERY_4_COUNT_mCONCAT1.addOrDelOnZero(se118.modify(query_4_count_mconcatconcat_node_left, singleton_node_self), (v50 * -1));
      
          e50 = e50->nxt;
        }
      }
    }
    
    void unwrap_delete_SINGLETON(const event_args_t& ea) {
      on_delete_SINGLETON(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())));
    }
    
    void on_system_ready_event() {
      
    }
  
  private:
    
      /* Preallocated map entries (to avoid recreation of temporary objects) */
      QUERY_5_COUNT_entry se1;
      QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry se2;
      QUERY_5_COUNT_mBTREE1_entry se3;
      QUERY_6_COUNT_entry se4;
      QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry se5;
      QUERY_7_COUNT_entry se6;
      QUERY_2_COUNT_mCONCAT2_entry se7;
      QUERY_7_COUNT_mARRAY1_entry se8;
      QUERY_5_COUNT_entry se9;
      QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry se10;
      QUERY_5_COUNT_mBTREE1_entry se11;
      QUERY_6_COUNT_entry se12;
      QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry se13;
      QUERY_7_COUNT_entry se14;
      QUERY_2_COUNT_mCONCAT2_entry se15;
      QUERY_7_COUNT_mARRAY1_entry se16;
      QUERY_2_COUNT_entry se17;
      QUERY_2_COUNT_mBTREE1_entry se18;
      QUERY_2_COUNT_mARRAY1_entry se19;
      QUERY_2_COUNT_mARRAY1_mBTREE1_entry se20;
      QUERY_2_COUNT_mCONCAT1_entry se21;
      QUERY_3_COUNT_entry se22;
      QUERY_3_COUNT_mBTREE1_entry se23;
      QUERY_3_COUNT_mSINGLETON1_entry se24;
      QUERY_2_COUNT_mARRAY1_mBTREE1_entry se25;
      QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry se26;
      QUERY_3_COUNT_mCONCAT1_entry se27;
      tuple2_L_L st1;
      QUERY_4_COUNT_entry se28;
      QUERY_3_COUNT_mBTREE1_entry se29;
      QUERY_4_COUNT_mCONCAT1_entry se30;
      tuple2_L_L st2;
      QUERY_5_COUNT_entry se31;
      QUERY_5_COUNT_mBTREE1_entry se32;
      QUERY_6_COUNT_entry se33;
      QUERY_5_COUNT_mBTREE1_entry se34;
      QUERY_2_COUNT_entry se35;
      QUERY_2_COUNT_mBTREE1_entry se36;
      QUERY_2_COUNT_mARRAY1_entry se37;
      QUERY_2_COUNT_mARRAY1_mBTREE1_entry se38;
      QUERY_2_COUNT_mCONCAT1_entry se39;
      QUERY_3_COUNT_entry se40;
      QUERY_3_COUNT_mBTREE1_entry se41;
      QUERY_3_COUNT_mSINGLETON1_entry se42;
      QUERY_2_COUNT_mARRAY1_mBTREE1_entry se43;
      QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry se44;
      QUERY_3_COUNT_mCONCAT1_entry se45;
      tuple2_L_L st3;
      QUERY_4_COUNT_entry se46;
      QUERY_3_COUNT_mBTREE1_entry se47;
      QUERY_4_COUNT_mCONCAT1_entry se48;
      tuple2_L_L st4;
      QUERY_5_COUNT_entry se49;
      QUERY_5_COUNT_mBTREE1_entry se50;
      QUERY_6_COUNT_entry se51;
      QUERY_5_COUNT_mBTREE1_entry se52;
      QUERY_2_COUNT_entry se53;
      QUERY_2_COUNT_mCONCAT1_entry se54;
      QUERY_2_COUNT_mCONCAT2_entry se55;
      QUERY_2_COUNT_mARRAY1_entry se56;
      QUERY_2_COUNT_mCONCAT1_entry se57;
      QUERY_2_COUNT_mARRAY1_mBTREE1_entry se58;
      QUERY_2_COUNT_mBTREE1_entry se59;
      QUERY_2_COUNT_mCONCAT2_entry se60;
      QUERY_3_COUNT_entry se61;
      QUERY_3_COUNT_mCONCAT1_entry se62;
      QUERY_3_COUNT_mSINGLETON1_entry se63;
      QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry se64;
      QUERY_3_COUNT_mBTREE1_entry se65;
      QUERY_3_COUNT_mBTREE1_mCONCAT1_entry se66;
      QUERY_4_COUNT_entry se67;
      QUERY_4_COUNT_mCONCAT1_entry se68;
      QUERY_2_COUNT_entry se69;
      QUERY_2_COUNT_mCONCAT1_entry se70;
      QUERY_2_COUNT_mCONCAT2_entry se71;
      QUERY_2_COUNT_mARRAY1_entry se72;
      QUERY_2_COUNT_mCONCAT1_entry se73;
      QUERY_2_COUNT_mARRAY1_mBTREE1_entry se74;
      QUERY_2_COUNT_mBTREE1_entry se75;
      QUERY_2_COUNT_mCONCAT2_entry se76;
      QUERY_3_COUNT_entry se77;
      QUERY_3_COUNT_mCONCAT1_entry se78;
      QUERY_3_COUNT_mSINGLETON1_entry se79;
      QUERY_3_COUNT_mSINGLETON1_mCONCAT1_entry se80;
      QUERY_3_COUNT_mBTREE1_entry se81;
      QUERY_3_COUNT_mBTREE1_mCONCAT1_entry se82;
      QUERY_4_COUNT_entry se83;
      QUERY_4_COUNT_mCONCAT1_entry se84;
      QUERY_1_COUNT_entry se85;
      QUERY_2_COUNT_entry se86;
      QUERY_2_COUNT_mARRAY1_entry se87;
      QUERY_2_COUNT_mBTREE1_entry se88;
      QUERY_2_COUNT_mARRAY1_mBTREE1_entry se89;
      QUERY_2_COUNT_mCONCAT2_entry se90;
      QUERY_7_COUNT_entry se91;
      QUERY_7_COUNT_mARRAY1_entry se92;
      QUERY_1_COUNT_entry se93;
      QUERY_2_COUNT_entry se94;
      QUERY_2_COUNT_mARRAY1_entry se95;
      QUERY_2_COUNT_mBTREE1_entry se96;
      QUERY_2_COUNT_mARRAY1_mBTREE1_entry se97;
      QUERY_2_COUNT_mCONCAT2_entry se98;
      QUERY_7_COUNT_entry se99;
      QUERY_7_COUNT_mARRAY1_entry se100;
      QUERY_3_COUNT_entry se101;
      QUERY_3_COUNT_mSINGLETON1_entry se102;
      QUERY_3_COUNT_mBTREE1_entry se103;
      QUERY_2_COUNT_mARRAY1_mBTREE1_entry se104;
      QUERY_3_COUNT_mBTREE1_mCONCAT1_entry se105;
      QUERY_3_COUNT_mCONCAT1_entry se106;
      tuple2_L_L st5;
      QUERY_4_COUNT_entry se107;
      QUERY_3_COUNT_mSINGLETON1_entry se108;
      QUERY_4_COUNT_mCONCAT1_entry se109;
      tuple2_L_L st6;
      QUERY_3_COUNT_entry se110;
      QUERY_3_COUNT_mSINGLETON1_entry se111;
      QUERY_3_COUNT_mBTREE1_entry se112;
      QUERY_2_COUNT_mARRAY1_mBTREE1_entry se113;
      QUERY_3_COUNT_mBTREE1_mCONCAT1_entry se114;
      QUERY_3_COUNT_mCONCAT1_entry se115;
      tuple2_L_L st7;
      QUERY_4_COUNT_entry se116;
      QUERY_3_COUNT_mSINGLETON1_entry se117;
      QUERY_4_COUNT_mCONCAT1_entry se118;
      tuple2_L_L st8;
    
      
    
      /* Data structures used for storing materialized views */
      QUERY_2_COUNT_mARRAY1_map QUERY_2_COUNT_mARRAY1;
      QUERY_2_COUNT_mARRAY1_mBTREE1_map QUERY_2_COUNT_mARRAY1_mBTREE1;
      QUERY_2_COUNT_mBTREE1_map QUERY_2_COUNT_mBTREE1;
      QUERY_2_COUNT_mCONCAT1_map QUERY_2_COUNT_mCONCAT1;
      QUERY_2_COUNT_mCONCAT2_map QUERY_2_COUNT_mCONCAT2;
      QUERY_3_COUNT_mSINGLETON1_map QUERY_3_COUNT_mSINGLETON1;
      QUERY_3_COUNT_mSINGLETON1_mCONCAT1_map QUERY_3_COUNT_mSINGLETON1_mCONCAT1;
      QUERY_3_COUNT_mBTREE1_map QUERY_3_COUNT_mBTREE1;
      QUERY_3_COUNT_mBTREE1_mCONCAT1_map QUERY_3_COUNT_mBTREE1_mCONCAT1;
      QUERY_3_COUNT_mCONCAT1_map QUERY_3_COUNT_mCONCAT1;
      QUERY_4_COUNT_mCONCAT1_map QUERY_4_COUNT_mCONCAT1;
      QUERY_5_COUNT_mBTREE1_map QUERY_5_COUNT_mBTREE1;
      QUERY_7_COUNT_mARRAY1_map QUERY_7_COUNT_mARRAY1;
    
      /* Data structures used as temporary materialized views */
      MultiHashMap<tuple2_L_L, long, HashIndex<tuple2_L_L, long> > agg11;
      MultiHashMap<tuple2_L_L, long, HashIndex<tuple2_L_L, long> > agg6;
      MultiHashMap<tuple2_L_L, long, HashIndex<tuple2_L_L, long> > agg8;
      MultiHashMap<tuple2_L_L, long, HashIndex<tuple2_L_L, long> > agg10;
      MultiHashMap<tuple2_L_L, long, HashIndex<tuple2_L_L, long> > agg5;
      MultiHashMap<tuple2_L_L, long, HashIndex<tuple2_L_L, long> > agg12;
      MultiHashMap<tuple2_L_L, long, HashIndex<tuple2_L_L, long> > agg7;
      MultiHashMap<tuple2_L_L, long, HashIndex<tuple2_L_L, long> > agg9;
    
  };

  /* Type definition providing a way to execute the sql program */
  class Program : public ProgramBase {
    public:
      Program(int argc = 0, char* argv[] = 0) : ProgramBase(argc,argv) {
        data.register_data(*this);
  
        /* Specifying data sources */
        
        pair<string,string> source1_adaptor_params[] = { make_pair("schema", "long,long,long,long"), make_pair("deletions", "false") };
        std::shared_ptr<csv_adaptor> source1_adaptor(new csv_adaptor(get_relation_id("DELETESINGLETON"), 2, source1_adaptor_params));
        frame_descriptor source1_fd("\n");
        std::shared_ptr<dbt_file_source> source1_file(new dbt_file_source("maintenance_input.csv",source1_fd,source1_adaptor));
        add_source(source1_file, false);
        
        pair<string,string> source2_adaptor_params[] = { make_pair("schema", "long,long,long,long,long"), make_pair("deletions", "false") };
        std::shared_ptr<csv_adaptor> source2_adaptor(new csv_adaptor(get_relation_id("BTREE"), 2, source2_adaptor_params));
        frame_descriptor source2_fd("\n");
        std::shared_ptr<dbt_file_source> source2_file(new dbt_file_source("maintenance_input.csv",source2_fd,source2_adaptor));
        add_source(source2_file, false);
        
        pair<string,string> source3_adaptor_params[] = { make_pair("schema", "long,long,long,long"), make_pair("deletions", "false") };
        std::shared_ptr<csv_adaptor> source3_adaptor(new csv_adaptor(get_relation_id("CONCAT"), 2, source3_adaptor_params));
        frame_descriptor source3_fd("\n");
        std::shared_ptr<dbt_file_source> source3_file(new dbt_file_source("maintenance_input.csv",source3_fd,source3_adaptor));
        add_source(source3_file, false);
        
        pair<string,string> source4_adaptor_params[] = { make_pair("schema", "long,long,long"), make_pair("deletions", "false") };
        std::shared_ptr<csv_adaptor> source4_adaptor(new csv_adaptor(get_relation_id("ARRAY"), 2, source4_adaptor_params));
        frame_descriptor source4_fd("\n");
        std::shared_ptr<dbt_file_source> source4_file(new dbt_file_source("maintenance_input.csv",source4_fd,source4_adaptor));
        add_source(source4_file, false);
        
        pair<string,string> source5_adaptor_params[] = { make_pair("schema", "long,long,long"), make_pair("deletions", "false") };
        std::shared_ptr<csv_adaptor> source5_adaptor(new csv_adaptor(get_relation_id("SINGLETON"), 2, source5_adaptor_params));
        frame_descriptor source5_fd("\n");
        std::shared_ptr<dbt_file_source> source5_file(new dbt_file_source("maintenance_input.csv",source5_fd,source5_adaptor));
        add_source(source5_file, false);
      }
  
      /* Imports data for static tables and performs view initialization based on it. */
      void init() {
          table_multiplexer.init_source(run_opts->batch_size, run_opts->parallel, true);
          stream_multiplexer.init_source(run_opts->batch_size, run_opts->parallel, false);
  
          // struct timeval ts0, ts1, ts2;
          // gettimeofday(&ts0, NULL);
          process_tables();
          // gettimeofday(&ts1, NULL);
          // long int et1 = (ts1.tv_sec - ts0.tv_sec) * 1000L + (ts1.tv_usec - ts0.tv_usec) / 1000;
          // std::cout << "Populating static tables time: " << et1 << " (ms)" << std::endl;
  
          data.on_system_ready_event();
          // gettimeofday(&ts2, NULL);
          // long int et2 = (ts2.tv_sec - ts1.tv_sec) * 1000L + (ts2.tv_usec - ts1.tv_usec) / 1000;
          // std::cout << "OnSystemReady time: " << et2 << " (ms)" << std::endl;
  
          gettimeofday(&data.t0, NULL);
      }
  
      /* Saves a snapshot of the data required to obtain the results of top level queries. */
      snapshot_t take_snapshot() {
          // gettimeofday(&data.t, NULL);
          // long int t = (data.t.tv_sec - data.t0.tv_sec) * 1000L + (data.t.tv_usec - data.t0.tv_usec) / 1000;
          // std::cout << "Trigger running time: " << t << " (ms)" << std::endl;
          
          tlq_t* d = new tlq_t((tlq_t&) data);
          // gettimeofday(&(d->t), NULL);
          // d->tT = ((d->t).tv_sec - (d->t0).tv_sec) * 1000000L + ((d->t).tv_usec - (d->t0).tv_usec);
          // printf("SAMPLE = standard, %ld, %ld, %ld\n", d->tT, d->tN, d->tS);
          return snapshot_t( d );
      }
  
    protected:
      data_t data;
  };
  
  class Toaster_maintenance : public Program {
    public:
      Toaster_maintenance(int argc = 0, char* argv[] = 0) : Program(argc, argv) { }
  };

}