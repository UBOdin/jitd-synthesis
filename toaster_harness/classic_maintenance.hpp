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
  
  
  struct QUERY_2_COUNT_mBTREE1_raw_reln_6_entry {
    long CONCAT_ITER_ID; long CONCAT_NODE_SELF; long QUERY_2_COUNT_mBTREEBTREE_NODE_SELF; long CONCAT_NODE_RIGHT; long __av; QUERY_2_COUNT_mBTREE1_raw_reln_6_entry* nxt; QUERY_2_COUNT_mBTREE1_raw_reln_6_entry* prv;
  
    explicit QUERY_2_COUNT_mBTREE1_raw_reln_6_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_2_COUNT_mBTREE1_raw_reln_6_entry(const long c0, const long c1, const long c2, const long c3, const long c4) { CONCAT_ITER_ID = c0; CONCAT_NODE_SELF = c1; QUERY_2_COUNT_mBTREEBTREE_NODE_SELF = c2; CONCAT_NODE_RIGHT = c3; __av = c4;  }
    QUERY_2_COUNT_mBTREE1_raw_reln_6_entry(const QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& other) : CONCAT_ITER_ID(other.CONCAT_ITER_ID), CONCAT_NODE_SELF(other.CONCAT_NODE_SELF), QUERY_2_COUNT_mBTREEBTREE_NODE_SELF(other.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF), CONCAT_NODE_RIGHT(other.CONCAT_NODE_RIGHT), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& modify(const long c0, const long c1, const long c2, const long c3) { CONCAT_ITER_ID = c0; CONCAT_NODE_SELF = c1; QUERY_2_COUNT_mBTREEBTREE_NODE_SELF = c2; CONCAT_NODE_RIGHT = c3;  return *this; }
    FORCE_INLINE QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& modify2(const long c2) { QUERY_2_COUNT_mBTREEBTREE_NODE_SELF = c2;  return *this; }
    FORCE_INLINE QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& modify3(const long c3) { CONCAT_NODE_RIGHT = c3;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, CONCAT_ITER_ID);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, CONCAT_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_2_COUNT_mBTREEBTREE_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, CONCAT_NODE_RIGHT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey0123_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& e) {
      size_t h = 0;
      hash_combine(h, e.CONCAT_ITER_ID);
      hash_combine(h, e.CONCAT_NODE_SELF);
      hash_combine(h, e.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF);
      hash_combine(h, e.CONCAT_NODE_RIGHT);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& x, const QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& y) {
      return x.CONCAT_ITER_ID == y.CONCAT_ITER_ID && x.CONCAT_NODE_SELF == y.CONCAT_NODE_SELF && x.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF == y.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF && x.CONCAT_NODE_RIGHT == y.CONCAT_NODE_RIGHT;
    }
  };
  
  struct QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey2_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& x, const QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& y) {
      return x.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF == y.QUERY_2_COUNT_mBTREEBTREE_NODE_SELF;
    }
  };
  
  struct QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey3_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& e) {
      size_t h = 0;
      hash_combine(h, e.CONCAT_NODE_RIGHT);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& x, const QUERY_2_COUNT_mBTREE1_raw_reln_6_entry& y) {
      return x.CONCAT_NODE_RIGHT == y.CONCAT_NODE_RIGHT;
    }
  };
  
  typedef MultiHashMap<QUERY_2_COUNT_mBTREE1_raw_reln_6_entry, long,
    HashIndex<QUERY_2_COUNT_mBTREE1_raw_reln_6_entry, long, QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey0123_idxfn, true>,
    HashIndex<QUERY_2_COUNT_mBTREE1_raw_reln_6_entry, long, QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey2_idxfn, false>,
    HashIndex<QUERY_2_COUNT_mBTREE1_raw_reln_6_entry, long, QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey3_idxfn, false>
  > QUERY_2_COUNT_mBTREE1_raw_reln_6_map;
  typedef HashIndex<QUERY_2_COUNT_mBTREE1_raw_reln_6_entry, long, QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey0123_idxfn, true> HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_0123;
  typedef HashIndex<QUERY_2_COUNT_mBTREE1_raw_reln_6_entry, long, QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey2_idxfn, false> HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_2;
  typedef HashIndex<QUERY_2_COUNT_mBTREE1_raw_reln_6_entry, long, QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey3_idxfn, false> HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_3;
  
  
  struct QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry {
    long BTREE_ITER_ID; long QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT; long BTREE_NODE_LEFT; long BTREE_NODE_RIGHT; long BTREE_SEPARATOR; long __av; QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry* nxt; QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry* prv;
  
    explicit QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry(const long c0, const long c1, const long c2, const long c3, const long c4, const long c5) { BTREE_ITER_ID = c0; QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT = c1; BTREE_NODE_LEFT = c2; BTREE_NODE_RIGHT = c3; BTREE_SEPARATOR = c4; __av = c5;  }
    QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry(const QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry& other) : BTREE_ITER_ID(other.BTREE_ITER_ID), QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT(other.QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT), BTREE_NODE_LEFT(other.BTREE_NODE_LEFT), BTREE_NODE_RIGHT(other.BTREE_NODE_RIGHT), BTREE_SEPARATOR(other.BTREE_SEPARATOR), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry& modify(const long c0, const long c1, const long c2, const long c3, const long c4) { BTREE_ITER_ID = c0; QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT = c1; BTREE_NODE_LEFT = c2; BTREE_NODE_RIGHT = c3; BTREE_SEPARATOR = c4;  return *this; }
    FORCE_INLINE QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry& modify1(const long c1) { QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT = c1;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, BTREE_ITER_ID);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, BTREE_NODE_LEFT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, BTREE_NODE_RIGHT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, BTREE_SEPARATOR);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey01234_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.BTREE_ITER_ID);
      hash_combine(h, e.QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT);
      hash_combine(h, e.BTREE_NODE_LEFT);
      hash_combine(h, e.BTREE_NODE_RIGHT);
      hash_combine(h, e.BTREE_SEPARATOR);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry& x, const QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry& y) {
      return x.BTREE_ITER_ID == y.BTREE_ITER_ID && x.QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT == y.QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT && x.BTREE_NODE_LEFT == y.BTREE_NODE_LEFT && x.BTREE_NODE_RIGHT == y.BTREE_NODE_RIGHT && x.BTREE_SEPARATOR == y.BTREE_SEPARATOR;
    }
  };
  
  struct QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry& x, const QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry& y) {
      return x.QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT == y.QUERY_2_COUNT_mCONCATCONCAT_NODE_LEFT;
    }
  };
  
  typedef MultiHashMap<QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry, long,
    HashIndex<QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry, long, QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey01234_idxfn, true>,
    HashIndex<QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry, long, QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn, false>
  > QUERY_2_COUNT_mCONCAT1_raw_reln_1_map;
  typedef HashIndex<QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry, long, QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey01234_idxfn, true> HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_01234;
  typedef HashIndex<QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry, long, QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn, false> HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1;
  
  
  struct QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry {
    long SINGLETON_ITER_ID; long QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT; long SINGLETON_KEY; long __av; QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry* nxt; QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry* prv;
  
    explicit QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry(const long c0, const long c1, const long c2, const long c3) { SINGLETON_ITER_ID = c0; QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT = c1; SINGLETON_KEY = c2; __av = c3;  }
    QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry(const QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry& other) : SINGLETON_ITER_ID(other.SINGLETON_ITER_ID), QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT(other.QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT), SINGLETON_KEY(other.SINGLETON_KEY), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry& modify(const long c0, const long c1, const long c2) { SINGLETON_ITER_ID = c0; QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT = c1; SINGLETON_KEY = c2;  return *this; }
    FORCE_INLINE QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry& modify1(const long c1) { QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT = c1;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, SINGLETON_ITER_ID);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, SINGLETON_KEY);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey012_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry& e) {
      size_t h = 0;
      hash_combine(h, e.SINGLETON_ITER_ID);
      hash_combine(h, e.QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT);
      hash_combine(h, e.SINGLETON_KEY);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry& x, const QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry& y) {
      return x.SINGLETON_ITER_ID == y.SINGLETON_ITER_ID && x.QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT == y.QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT && x.SINGLETON_KEY == y.SINGLETON_KEY;
    }
  };
  
  struct QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey1_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry& x, const QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry& y) {
      return x.QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT == y.QUERY_2_COUNT_mCONCATCONCAT_NODE_RIGHT;
    }
  };
  
  typedef MultiHashMap<QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry, long,
    HashIndex<QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry, long, QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey012_idxfn, true>,
    HashIndex<QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry, long, QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey1_idxfn, false>
  > QUERY_2_COUNT_mCONCAT2_raw_reln_2_map;
  typedef HashIndex<QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry, long, QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey012_idxfn, true> HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_012;
  typedef HashIndex<QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry, long, QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey1_idxfn, false> HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1;
  
  
  struct QUERY_3_COUNT_entry {
    long DELETESINGLETON_NODE_SELF; long __av; QUERY_3_COUNT_entry* nxt; QUERY_3_COUNT_entry* prv;
  
    explicit QUERY_3_COUNT_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_3_COUNT_entry(const long c0, const long c1) { DELETESINGLETON_NODE_SELF = c0; __av = c1;  }
    QUERY_3_COUNT_entry(const QUERY_3_COUNT_entry& other) : DELETESINGLETON_NODE_SELF(other.DELETESINGLETON_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_3_COUNT_entry& modify(const long c0) { DELETESINGLETON_NODE_SELF = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, DELETESINGLETON_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_3_COUNT_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_entry& e) {
      size_t h = 0;
      hash_combine(h, e.DELETESINGLETON_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_entry& x, const QUERY_3_COUNT_entry& y) {
      return x.DELETESINGLETON_NODE_SELF == y.DELETESINGLETON_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_3_COUNT_entry, long,
    HashIndex<QUERY_3_COUNT_entry, long, QUERY_3_COUNT_mapkey0_idxfn, true>
  > QUERY_3_COUNT_map;
  typedef HashIndex<QUERY_3_COUNT_entry, long, QUERY_3_COUNT_mapkey0_idxfn, true> HashIndex_QUERY_3_COUNT_map_0;
  
  
  struct QUERY_3_COUNT_mBTREE1_raw_reln_15_entry {
    long DELETESINGLETON_ITER_ID; long DELETESINGLETON_NODE_SELF; long QUERY_3_COUNT_mBTREEBTREE_NODE_SELF; long DELETESINGLETON_KEY; long __av; QUERY_3_COUNT_mBTREE1_raw_reln_15_entry* nxt; QUERY_3_COUNT_mBTREE1_raw_reln_15_entry* prv;
  
    explicit QUERY_3_COUNT_mBTREE1_raw_reln_15_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_3_COUNT_mBTREE1_raw_reln_15_entry(const long c0, const long c1, const long c2, const long c3, const long c4) { DELETESINGLETON_ITER_ID = c0; DELETESINGLETON_NODE_SELF = c1; QUERY_3_COUNT_mBTREEBTREE_NODE_SELF = c2; DELETESINGLETON_KEY = c3; __av = c4;  }
    QUERY_3_COUNT_mBTREE1_raw_reln_15_entry(const QUERY_3_COUNT_mBTREE1_raw_reln_15_entry& other) : DELETESINGLETON_ITER_ID(other.DELETESINGLETON_ITER_ID), DELETESINGLETON_NODE_SELF(other.DELETESINGLETON_NODE_SELF), QUERY_3_COUNT_mBTREEBTREE_NODE_SELF(other.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF), DELETESINGLETON_KEY(other.DELETESINGLETON_KEY), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_3_COUNT_mBTREE1_raw_reln_15_entry& modify(const long c0, const long c1, const long c2, const long c3) { DELETESINGLETON_ITER_ID = c0; DELETESINGLETON_NODE_SELF = c1; QUERY_3_COUNT_mBTREEBTREE_NODE_SELF = c2; DELETESINGLETON_KEY = c3;  return *this; }
    FORCE_INLINE QUERY_3_COUNT_mBTREE1_raw_reln_15_entry& modify2(const long c2) { QUERY_3_COUNT_mBTREEBTREE_NODE_SELF = c2;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, DELETESINGLETON_ITER_ID);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, DELETESINGLETON_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_3_COUNT_mBTREEBTREE_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, DELETESINGLETON_KEY);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey0123_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_mBTREE1_raw_reln_15_entry& e) {
      size_t h = 0;
      hash_combine(h, e.DELETESINGLETON_ITER_ID);
      hash_combine(h, e.DELETESINGLETON_NODE_SELF);
      hash_combine(h, e.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF);
      hash_combine(h, e.DELETESINGLETON_KEY);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_mBTREE1_raw_reln_15_entry& x, const QUERY_3_COUNT_mBTREE1_raw_reln_15_entry& y) {
      return x.DELETESINGLETON_ITER_ID == y.DELETESINGLETON_ITER_ID && x.DELETESINGLETON_NODE_SELF == y.DELETESINGLETON_NODE_SELF && x.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF == y.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF && x.DELETESINGLETON_KEY == y.DELETESINGLETON_KEY;
    }
  };
  
  struct QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_3_COUNT_mBTREE1_raw_reln_15_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_3_COUNT_mBTREE1_raw_reln_15_entry& x, const QUERY_3_COUNT_mBTREE1_raw_reln_15_entry& y) {
      return x.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF == y.QUERY_3_COUNT_mBTREEBTREE_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_3_COUNT_mBTREE1_raw_reln_15_entry, long,
    HashIndex<QUERY_3_COUNT_mBTREE1_raw_reln_15_entry, long, QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey0123_idxfn, true>,
    HashIndex<QUERY_3_COUNT_mBTREE1_raw_reln_15_entry, long, QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn, false>
  > QUERY_3_COUNT_mBTREE1_raw_reln_15_map;
  typedef HashIndex<QUERY_3_COUNT_mBTREE1_raw_reln_15_entry, long, QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey0123_idxfn, true> HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_0123;
  typedef HashIndex<QUERY_3_COUNT_mBTREE1_raw_reln_15_entry, long, QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn, false> HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2;
  
  
  struct QUERY_4_COUNT_entry {
    long DELETESINGLETON_NODE_SELF; long __av; QUERY_4_COUNT_entry* nxt; QUERY_4_COUNT_entry* prv;
  
    explicit QUERY_4_COUNT_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_4_COUNT_entry(const long c0, const long c1) { DELETESINGLETON_NODE_SELF = c0; __av = c1;  }
    QUERY_4_COUNT_entry(const QUERY_4_COUNT_entry& other) : DELETESINGLETON_NODE_SELF(other.DELETESINGLETON_NODE_SELF), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_4_COUNT_entry& modify(const long c0) { DELETESINGLETON_NODE_SELF = c0;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, DELETESINGLETON_NODE_SELF);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_4_COUNT_mapkey0_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_4_COUNT_entry& e) {
      size_t h = 0;
      hash_combine(h, e.DELETESINGLETON_NODE_SELF);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_4_COUNT_entry& x, const QUERY_4_COUNT_entry& y) {
      return x.DELETESINGLETON_NODE_SELF == y.DELETESINGLETON_NODE_SELF;
    }
  };
  
  typedef MultiHashMap<QUERY_4_COUNT_entry, long,
    HashIndex<QUERY_4_COUNT_entry, long, QUERY_4_COUNT_mapkey0_idxfn, true>
  > QUERY_4_COUNT_map;
  typedef HashIndex<QUERY_4_COUNT_entry, long, QUERY_4_COUNT_mapkey0_idxfn, true> HashIndex_QUERY_4_COUNT_map_0;
  
  
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
  
  
  struct QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry {
    long ARRAY_ITER_ID; long QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD; long ARRAY_SIZE; long __av; QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry* nxt; QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry* prv;
  
    explicit QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry() : nxt(nullptr), prv(nullptr) { }
    explicit QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry(const long c0, const long c1, const long c2, const long c3) { ARRAY_ITER_ID = c0; QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD = c1; ARRAY_SIZE = c2; __av = c3;  }
    QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry(const QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry& other) : ARRAY_ITER_ID(other.ARRAY_ITER_ID), QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD(other.QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD), ARRAY_SIZE(other.ARRAY_SIZE), __av(other.__av), nxt(nullptr), prv(nullptr) { }
    
    
    FORCE_INLINE QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry& modify(const long c0, const long c1, const long c2) { ARRAY_ITER_ID = c0; QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD = c1; ARRAY_SIZE = c2;  return *this; }
    FORCE_INLINE QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry& modify1(const long c1) { QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD = c1;  return *this; }
    template<class Archive>
    void serialize(Archive& ar, const unsigned int version) const {
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, ARRAY_ITER_ID);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, ARRAY_SIZE);
      ar << ELEM_SEPARATOR;
      DBT_SERIALIZATION_NVP(ar, __av);
    }
  };
  
  struct QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_mapkey012_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry& e) {
      size_t h = 0;
      hash_combine(h, e.ARRAY_ITER_ID);
      hash_combine(h, e.QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD);
      hash_combine(h, e.ARRAY_SIZE);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry& x, const QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry& y) {
      return x.ARRAY_ITER_ID == y.ARRAY_ITER_ID && x.QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD == y.QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD && x.ARRAY_SIZE == y.ARRAY_SIZE;
    }
  };
  
  struct QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_mapkey1_idxfn {
    FORCE_INLINE static size_t hash(const QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry& e) {
      size_t h = 0;
      hash_combine(h, e.QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD);
      return h;
    }
    
    FORCE_INLINE static bool equals(const QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry& x, const QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry& y) {
      return x.QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD == y.QUERY_5_COUNT_mDELETESINGLETONDELETESINGLETON_NODE_CHILD;
    }
  };
  
  typedef MultiHashMap<QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry, long,
    HashIndex<QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry, long, QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_mapkey012_idxfn, true>,
    HashIndex<QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry, long, QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_mapkey1_idxfn, false>
  > QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_map;
  typedef HashIndex<QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry, long, QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_mapkey012_idxfn, true> HashIndex_QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_map_012;
  typedef HashIndex<QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry, long, QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_mapkey1_idxfn, false> HashIndex_QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_map_1;

  

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
  
//  protected:
    /* Data structures used for storing / computing top-level queries */
    QUERY_1_COUNT_map QUERY_1_COUNT;
    QUERY_2_COUNT_map QUERY_2_COUNT;
    QUERY_3_COUNT_map QUERY_3_COUNT;
    QUERY_4_COUNT_map QUERY_4_COUNT;
    QUERY_5_COUNT_map QUERY_5_COUNT;
    
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
      pb.add_map<QUERY_2_COUNT_mBTREE1_raw_reln_6_map>("QUERY_2_COUNT_mBTREE1_raw_reln_6", QUERY_2_COUNT_mBTREE1_raw_reln_6);
      pb.add_map<QUERY_2_COUNT_mCONCAT1_raw_reln_1_map>("QUERY_2_COUNT_mCONCAT1_raw_reln_1", QUERY_2_COUNT_mCONCAT1_raw_reln_1);
      pb.add_map<QUERY_2_COUNT_mCONCAT2_raw_reln_2_map>("QUERY_2_COUNT_mCONCAT2_raw_reln_2", QUERY_2_COUNT_mCONCAT2_raw_reln_2);
      pb.add_map<QUERY_3_COUNT_map>("QUERY_3_COUNT", QUERY_3_COUNT);
      pb.add_map<QUERY_3_COUNT_mBTREE1_raw_reln_15_map>("QUERY_3_COUNT_mBTREE1_raw_reln_15", QUERY_3_COUNT_mBTREE1_raw_reln_15);
      pb.add_map<QUERY_4_COUNT_map>("QUERY_4_COUNT", QUERY_4_COUNT);
      pb.add_map<QUERY_5_COUNT_map>("QUERY_5_COUNT", QUERY_5_COUNT);
      pb.add_map<QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_map>("QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21", QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21);
    
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
        const HASH_RES_t h1 = QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::hash(se2.modify1(deletesingleton_node_child));
        const HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1* i1 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1*>(QUERY_2_COUNT_mCONCAT1_raw_reln_1.index[1]);
        HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1::IdxNode* n1 = &(i1->buckets_[h1 & i1->mask_]);
        QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry* e1;
        do if ((e1 = n1->obj) && h1 == n1->hash && QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::equals(se2, *e1)) {
          long btree_iter_id = e1->BTREE_ITER_ID;
          long btree_node_left = e1->BTREE_NODE_LEFT;
          long btree_node_right = e1->BTREE_NODE_RIGHT;
          long btree_separator = e1->BTREE_SEPARATOR;
          long v1 = e1->__av;
          (/*if */(btree_separator > deletesingleton_key) ? agg1 += v1 : 0L);
        } while ((n1 = n1->nxt));
      }
      QUERY_3_COUNT.addOrDelOnZero(se1.modify(deletesingleton_node_self), agg1);
      
      QUERY_3_COUNT_mBTREE1_raw_reln_15.addOrDelOnZero(se3.modify(deletesingleton_iter_id, deletesingleton_node_self, deletesingleton_node_child, deletesingleton_key), 1);
      
      long agg2 = 0L;
      { //slice
        const HASH_RES_t h2 = QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::hash(se5.modify1(deletesingleton_node_child));
        const HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1* i2 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1*>(QUERY_2_COUNT_mCONCAT1_raw_reln_1.index[1]);
        HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1::IdxNode* n2 = &(i2->buckets_[h2 & i2->mask_]);
        QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry* e2;
        do if ((e2 = n2->obj) && h2 == n2->hash && QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::equals(se5, *e2)) {
          long btree_iter_id = e2->BTREE_ITER_ID;
          long btree_node_left = e2->BTREE_NODE_LEFT;
          long btree_node_right = e2->BTREE_NODE_RIGHT;
          long btree_separator = e2->BTREE_SEPARATOR;
          long v2 = e2->__av;
          (/*if */(deletesingleton_key >= btree_separator) ? agg2 += v2 : 0L);
        } while ((n2 = n2->nxt));
      }
      QUERY_4_COUNT.addOrDelOnZero(se4.modify(deletesingleton_node_self), agg2);
      
      long agg3 = 0L;
      { //slice
        const HASH_RES_t h3 = QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_mapkey1_idxfn::hash(se7.modify1(deletesingleton_node_child));
        const HashIndex_QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_map_1* i3 = static_cast<HashIndex_QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_map_1*>(QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21.index[1]);
        HashIndex_QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_map_1::IdxNode* n3 = &(i3->buckets_[h3 & i3->mask_]);
        QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry* e3;
        do if ((e3 = n3->obj) && h3 == n3->hash && QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_mapkey1_idxfn::equals(se7, *e3)) {
          long array_iter_id = e3->ARRAY_ITER_ID;
          long array_size = e3->ARRAY_SIZE;
          long v3 = e3->__av;
          agg3 += v3;
        } while ((n3 = n3->nxt));
      }
      QUERY_5_COUNT.addOrDelOnZero(se6.modify(deletesingleton_node_self), agg3);
    }
    
    void unwrap_insert_DELETESINGLETON(const event_args_t& ea) {
      on_insert_DELETESINGLETON(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())));
    }
    
    void on_delete_DELETESINGLETON(const long deletesingleton_iter_id, const long deletesingleton_node_self, const long deletesingleton_node_child, const long deletesingleton_key) {
      
      ++tN;
      long agg4 = 0L;
      { //slice
        const HASH_RES_t h4 = QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::hash(se9.modify1(deletesingleton_node_child));
        const HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1* i4 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1*>(QUERY_2_COUNT_mCONCAT1_raw_reln_1.index[1]);
        HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1::IdxNode* n4 = &(i4->buckets_[h4 & i4->mask_]);
        QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry* e4;
        do if ((e4 = n4->obj) && h4 == n4->hash && QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::equals(se9, *e4)) {
          long btree_iter_id = e4->BTREE_ITER_ID;
          long btree_node_left = e4->BTREE_NODE_LEFT;
          long btree_node_right = e4->BTREE_NODE_RIGHT;
          long btree_separator = e4->BTREE_SEPARATOR;
          long v4 = e4->__av;
          (/*if */(btree_separator > deletesingleton_key) ? agg4 += v4 : 0L);
        } while ((n4 = n4->nxt));
      }
      QUERY_3_COUNT.addOrDelOnZero(se8.modify(deletesingleton_node_self), (agg4 * -1));
      
      QUERY_3_COUNT_mBTREE1_raw_reln_15.addOrDelOnZero(se10.modify(deletesingleton_iter_id, deletesingleton_node_self, deletesingleton_node_child, deletesingleton_key), -1);
      
      long agg5 = 0L;
      { //slice
        const HASH_RES_t h5 = QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::hash(se12.modify1(deletesingleton_node_child));
        const HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1* i5 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1*>(QUERY_2_COUNT_mCONCAT1_raw_reln_1.index[1]);
        HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1::IdxNode* n5 = &(i5->buckets_[h5 & i5->mask_]);
        QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry* e5;
        do if ((e5 = n5->obj) && h5 == n5->hash && QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::equals(se12, *e5)) {
          long btree_iter_id = e5->BTREE_ITER_ID;
          long btree_node_left = e5->BTREE_NODE_LEFT;
          long btree_node_right = e5->BTREE_NODE_RIGHT;
          long btree_separator = e5->BTREE_SEPARATOR;
          long v5 = e5->__av;
          (/*if */(deletesingleton_key >= btree_separator) ? agg5 += v5 : 0L);
        } while ((n5 = n5->nxt));
      }
      QUERY_4_COUNT.addOrDelOnZero(se11.modify(deletesingleton_node_self), (agg5 * -1));
      
      long agg6 = 0L;
      { //slice
        const HASH_RES_t h6 = QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_mapkey1_idxfn::hash(se14.modify1(deletesingleton_node_child));
        const HashIndex_QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_map_1* i6 = static_cast<HashIndex_QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_map_1*>(QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21.index[1]);
        HashIndex_QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_map_1::IdxNode* n6 = &(i6->buckets_[h6 & i6->mask_]);
        QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry* e6;
        do if ((e6 = n6->obj) && h6 == n6->hash && QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_mapkey1_idxfn::equals(se14, *e6)) {
          long array_iter_id = e6->ARRAY_ITER_ID;
          long array_size = e6->ARRAY_SIZE;
          long v6 = e6->__av;
          agg6 += v6;
        } while ((n6 = n6->nxt));
      }
      QUERY_5_COUNT.addOrDelOnZero(se13.modify(deletesingleton_node_self), (agg6 * -1));
    }
    
    void unwrap_delete_DELETESINGLETON(const event_args_t& ea) {
      on_delete_DELETESINGLETON(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())));
    }
    
    void on_insert_BTREE(const long btree_iter_id, const long btree_node_self, const long btree_node_left, const long btree_node_right, const long btree_separator) {
      
      ++tN;
      { //slice
        const HASH_RES_t h8 = QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey2_idxfn::hash(se17.modify2(btree_node_self));
        const HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_2* i8 = static_cast<HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_2*>(QUERY_2_COUNT_mBTREE1_raw_reln_6.index[1]);
        HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_2::IdxNode* n8 = &(i8->buckets_[h8 & i8->mask_]);
        QUERY_2_COUNT_mBTREE1_raw_reln_6_entry* e7;
        do if ((e7 = n8->obj) && h8 == n8->hash && QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey2_idxfn::equals(se17, *e7)) {
          long concat_iter_id = e7->CONCAT_ITER_ID;
          long concat_node_self = e7->CONCAT_NODE_SELF;
          long concat_node_right = e7->CONCAT_NODE_RIGHT;
          long v7 = e7->__av;
          { //slice
            const HASH_RES_t h7 = QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey1_idxfn::hash(se16.modify1(concat_node_right));
            const HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1* i7 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1*>(QUERY_2_COUNT_mCONCAT2_raw_reln_2.index[1]);
            HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1::IdxNode* n7 = &(i7->buckets_[h7 & i7->mask_]);
            QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry* e8;
            do if ((e8 = n7->obj) && h7 == n7->hash && QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey1_idxfn::equals(se16, *e8)) {
              long singleton_iter_id = e8->SINGLETON_ITER_ID;
              long singleton_key = e8->SINGLETON_KEY;
              long v8 = e8->__av;
              QUERY_2_COUNT.addOrDelOnZero(se15.modify(concat_node_self), (v7 * v8));
            } while ((n7 = n7->nxt));
          }
        } while ((n8 = n8->nxt));
      }
      
      QUERY_2_COUNT_mCONCAT1_raw_reln_1.addOrDelOnZero(se18.modify(btree_iter_id, btree_node_self, btree_node_left, btree_node_right, btree_separator), 1);
      
      { //slice
        const HASH_RES_t h9 = QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::hash(se20.modify2(btree_node_self));
        const HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2* i9 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2*>(QUERY_3_COUNT_mBTREE1_raw_reln_15.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2::IdxNode* n9 = &(i9->buckets_[h9 & i9->mask_]);
        QUERY_3_COUNT_mBTREE1_raw_reln_15_entry* e9;
        do if ((e9 = n9->obj) && h9 == n9->hash && QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::equals(se20, *e9)) {
          long deletesingleton_iter_id = e9->DELETESINGLETON_ITER_ID;
          long deletesingleton_node_self = e9->DELETESINGLETON_NODE_SELF;
          long deletesingleton_key = e9->DELETESINGLETON_KEY;
          long v9 = e9->__av;
          if (btree_separator > deletesingleton_key) {
            QUERY_3_COUNT.addOrDelOnZero(se19.modify(deletesingleton_node_self), v9);
          }
        } while ((n9 = n9->nxt));
      }
      
      { //slice
        const HASH_RES_t h10 = QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::hash(se22.modify2(btree_node_self));
        const HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2* i10 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2*>(QUERY_3_COUNT_mBTREE1_raw_reln_15.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2::IdxNode* n10 = &(i10->buckets_[h10 & i10->mask_]);
        QUERY_3_COUNT_mBTREE1_raw_reln_15_entry* e10;
        do if ((e10 = n10->obj) && h10 == n10->hash && QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::equals(se22, *e10)) {
          long deletesingleton_iter_id = e10->DELETESINGLETON_ITER_ID;
          long deletesingleton_node_self = e10->DELETESINGLETON_NODE_SELF;
          long deletesingleton_key = e10->DELETESINGLETON_KEY;
          long v10 = e10->__av;
          if (deletesingleton_key >= btree_separator) {
            QUERY_4_COUNT.addOrDelOnZero(se21.modify(deletesingleton_node_self), v10);
          }
        } while ((n10 = n10->nxt));
      }
    }
    
    void unwrap_insert_BTREE(const event_args_t& ea) {
      on_insert_BTREE(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())), *(reinterpret_cast<long*>(ea[4].get())));
    }
    
    void on_delete_BTREE(const long btree_iter_id, const long btree_node_self, const long btree_node_left, const long btree_node_right, const long btree_separator) {
      
      ++tN;
      { //slice
        const HASH_RES_t h12 = QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey2_idxfn::hash(se25.modify2(btree_node_self));
        const HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_2* i12 = static_cast<HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_2*>(QUERY_2_COUNT_mBTREE1_raw_reln_6.index[1]);
        HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_2::IdxNode* n12 = &(i12->buckets_[h12 & i12->mask_]);
        QUERY_2_COUNT_mBTREE1_raw_reln_6_entry* e11;
        do if ((e11 = n12->obj) && h12 == n12->hash && QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey2_idxfn::equals(se25, *e11)) {
          long concat_iter_id = e11->CONCAT_ITER_ID;
          long concat_node_self = e11->CONCAT_NODE_SELF;
          long concat_node_right = e11->CONCAT_NODE_RIGHT;
          long v11 = e11->__av;
          { //slice
            const HASH_RES_t h11 = QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey1_idxfn::hash(se24.modify1(concat_node_right));
            const HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1* i11 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1*>(QUERY_2_COUNT_mCONCAT2_raw_reln_2.index[1]);
            HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1::IdxNode* n11 = &(i11->buckets_[h11 & i11->mask_]);
            QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry* e12;
            do if ((e12 = n11->obj) && h11 == n11->hash && QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey1_idxfn::equals(se24, *e12)) {
              long singleton_iter_id = e12->SINGLETON_ITER_ID;
              long singleton_key = e12->SINGLETON_KEY;
              long v12 = e12->__av;
              QUERY_2_COUNT.addOrDelOnZero(se23.modify(concat_node_self), ((v11 * v12) * -1));
            } while ((n11 = n11->nxt));
          }
        } while ((n12 = n12->nxt));
      }
      
      QUERY_2_COUNT_mCONCAT1_raw_reln_1.addOrDelOnZero(se26.modify(btree_iter_id, btree_node_self, btree_node_left, btree_node_right, btree_separator), -1);
      
      { //slice
        const HASH_RES_t h13 = QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::hash(se28.modify2(btree_node_self));
        const HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2* i13 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2*>(QUERY_3_COUNT_mBTREE1_raw_reln_15.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2::IdxNode* n13 = &(i13->buckets_[h13 & i13->mask_]);
        QUERY_3_COUNT_mBTREE1_raw_reln_15_entry* e13;
        do if ((e13 = n13->obj) && h13 == n13->hash && QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::equals(se28, *e13)) {
          long deletesingleton_iter_id = e13->DELETESINGLETON_ITER_ID;
          long deletesingleton_node_self = e13->DELETESINGLETON_NODE_SELF;
          long deletesingleton_key = e13->DELETESINGLETON_KEY;
          long v13 = e13->__av;
          if ((btree_separator > deletesingleton_key)) {
            QUERY_3_COUNT.addOrDelOnZero(se27.modify(deletesingleton_node_self), (v13 * -1));
          }
        } while ((n13 = n13->nxt));
      }
      
      { //slice
        const HASH_RES_t h14 = QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::hash(se30.modify2(btree_node_self));
        const HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2* i14 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2*>(QUERY_3_COUNT_mBTREE1_raw_reln_15.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2::IdxNode* n14 = &(i14->buckets_[h14 & i14->mask_]);
        QUERY_3_COUNT_mBTREE1_raw_reln_15_entry* e14;
        do if ((e14 = n14->obj) && h14 == n14->hash && QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::equals(se30, *e14)) {
          long deletesingleton_iter_id = e14->DELETESINGLETON_ITER_ID;
          long deletesingleton_node_self = e14->DELETESINGLETON_NODE_SELF;
          long deletesingleton_key = e14->DELETESINGLETON_KEY;
          long v14 = e14->__av;
          if ((deletesingleton_key >= btree_separator)) {
            QUERY_4_COUNT.addOrDelOnZero(se29.modify(deletesingleton_node_self), (v14 * -1));
          }
        } while ((n14 = n14->nxt));
      }
    }
    
    void unwrap_delete_BTREE(const event_args_t& ea) {
      on_delete_BTREE(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())), *(reinterpret_cast<long*>(ea[4].get())));
    }
    
    void on_insert_CONCAT(const long concat_iter_id, const long concat_node_self, const long concat_node_left, const long concat_node_right) {
      
      ++tN;
      long agg7 = 0L;
      { //slice
        const HASH_RES_t h15 = QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::hash(se32.modify1(concat_node_left));
        const HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1* i15 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1*>(QUERY_2_COUNT_mCONCAT1_raw_reln_1.index[1]);
        HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1::IdxNode* n15 = &(i15->buckets_[h15 & i15->mask_]);
        QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry* e15;
        do if ((e15 = n15->obj) && h15 == n15->hash && QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::equals(se32, *e15)) {
          long btree_iter_id = e15->BTREE_ITER_ID;
          long btree_node_left = e15->BTREE_NODE_LEFT;
          long btree_node_right = e15->BTREE_NODE_RIGHT;
          long btree_separator = e15->BTREE_SEPARATOR;
          long v15 = e15->__av;
          agg7 += v15;
        } while ((n15 = n15->nxt));
      }
      long agg8 = 0L;
      { //slice
        const HASH_RES_t h16 = QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey1_idxfn::hash(se33.modify1(concat_node_right));
        const HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1* i16 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1*>(QUERY_2_COUNT_mCONCAT2_raw_reln_2.index[1]);
        HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1::IdxNode* n16 = &(i16->buckets_[h16 & i16->mask_]);
        QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry* e16;
        do if ((e16 = n16->obj) && h16 == n16->hash && QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey1_idxfn::equals(se33, *e16)) {
          long singleton_iter_id = e16->SINGLETON_ITER_ID;
          long singleton_key = e16->SINGLETON_KEY;
          long v16 = e16->__av;
          agg8 += v16;
        } while ((n16 = n16->nxt));
      }
      QUERY_2_COUNT.addOrDelOnZero(se31.modify(concat_node_self), (agg7 * agg8));
      
      QUERY_2_COUNT_mBTREE1_raw_reln_6.addOrDelOnZero(se34.modify(concat_iter_id, concat_node_self, concat_node_left, concat_node_right), 1);
    }
    
    void unwrap_insert_CONCAT(const event_args_t& ea) {
      on_insert_CONCAT(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())));
    }
    
    void on_delete_CONCAT(const long concat_iter_id, const long concat_node_self, const long concat_node_left, const long concat_node_right) {
      
      ++tN;
      long agg9 = 0L;
      { //slice
        const HASH_RES_t h17 = QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::hash(se36.modify1(concat_node_left));
        const HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1* i17 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1*>(QUERY_2_COUNT_mCONCAT1_raw_reln_1.index[1]);
        HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1::IdxNode* n17 = &(i17->buckets_[h17 & i17->mask_]);
        QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry* e17;
        do if ((e17 = n17->obj) && h17 == n17->hash && QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::equals(se36, *e17)) {
          long btree_iter_id = e17->BTREE_ITER_ID;
          long btree_node_left = e17->BTREE_NODE_LEFT;
          long btree_node_right = e17->BTREE_NODE_RIGHT;
          long btree_separator = e17->BTREE_SEPARATOR;
          long v17 = e17->__av;
          agg9 += v17;
        } while ((n17 = n17->nxt));
      }
      long agg10 = 0L;
      { //slice
        const HASH_RES_t h18 = QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey1_idxfn::hash(se37.modify1(concat_node_right));
        const HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1* i18 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1*>(QUERY_2_COUNT_mCONCAT2_raw_reln_2.index[1]);
        HashIndex_QUERY_2_COUNT_mCONCAT2_raw_reln_2_map_1::IdxNode* n18 = &(i18->buckets_[h18 & i18->mask_]);
        QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry* e18;
        do if ((e18 = n18->obj) && h18 == n18->hash && QUERY_2_COUNT_mCONCAT2_raw_reln_2_mapkey1_idxfn::equals(se37, *e18)) {
          long singleton_iter_id = e18->SINGLETON_ITER_ID;
          long singleton_key = e18->SINGLETON_KEY;
          long v18 = e18->__av;
          agg10 += v18;
        } while ((n18 = n18->nxt));
      }
      QUERY_2_COUNT.addOrDelOnZero(se35.modify(concat_node_self), (agg9 * (agg10 * -1)));
      
      QUERY_2_COUNT_mBTREE1_raw_reln_6.addOrDelOnZero(se38.modify(concat_iter_id, concat_node_self, concat_node_left, concat_node_right), -1);
    }
    
    void unwrap_delete_CONCAT(const event_args_t& ea) {
      on_delete_CONCAT(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())), *(reinterpret_cast<long*>(ea[3].get())));
    }
    
    void on_insert_ARRAY(const long array_iter_id, const long array_node_self, const long array_size) {
      
      ++tN;
      if (array_size > __array_size) {
        QUERY_1_COUNT.addOrDelOnZero(se39.modify(array_node_self), 1);
      }
      
      { //slice
        const HASH_RES_t h19 = QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::hash(se41.modify2(array_node_self));
        const HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2* i19 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2*>(QUERY_3_COUNT_mBTREE1_raw_reln_15.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2::IdxNode* n19 = &(i19->buckets_[h19 & i19->mask_]);
        QUERY_3_COUNT_mBTREE1_raw_reln_15_entry* e19;
        do if ((e19 = n19->obj) && h19 == n19->hash && QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::equals(se41, *e19)) {
          long deletesingleton_iter_id = e19->DELETESINGLETON_ITER_ID;
          long deletesingleton_node_self = e19->DELETESINGLETON_NODE_SELF;
          long deletesingleton_key = e19->DELETESINGLETON_KEY;
          long v19 = e19->__av;
          QUERY_5_COUNT.addOrDelOnZero(se40.modify(deletesingleton_node_self), v19);
        } while ((n19 = n19->nxt));
      }
      
      QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21.addOrDelOnZero(se42.modify(array_iter_id, array_node_self, array_size), 1);
    }
    
    void unwrap_insert_ARRAY(const event_args_t& ea) {
      on_insert_ARRAY(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())));
    }
    
    void on_delete_ARRAY(const long array_iter_id, const long array_node_self, const long array_size) {
      
      ++tN;
      if ((array_size > __array_size)) {
        QUERY_1_COUNT.addOrDelOnZero(se43.modify(array_node_self), -1);
      }
      
      { //slice
        const HASH_RES_t h20 = QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::hash(se45.modify2(array_node_self));
        const HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2* i20 = static_cast<HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2*>(QUERY_3_COUNT_mBTREE1_raw_reln_15.index[1]);
        HashIndex_QUERY_3_COUNT_mBTREE1_raw_reln_15_map_2::IdxNode* n20 = &(i20->buckets_[h20 & i20->mask_]);
        QUERY_3_COUNT_mBTREE1_raw_reln_15_entry* e20;
        do if ((e20 = n20->obj) && h20 == n20->hash && QUERY_3_COUNT_mBTREE1_raw_reln_15_mapkey2_idxfn::equals(se45, *e20)) {
          long deletesingleton_iter_id = e20->DELETESINGLETON_ITER_ID;
          long deletesingleton_node_self = e20->DELETESINGLETON_NODE_SELF;
          long deletesingleton_key = e20->DELETESINGLETON_KEY;
          long v20 = e20->__av;
          QUERY_5_COUNT.addOrDelOnZero(se44.modify(deletesingleton_node_self), (v20 * -1));
        } while ((n20 = n20->nxt));
      }
      
      QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21.addOrDelOnZero(se46.modify(array_iter_id, array_node_self, array_size), -1);
    }
    
    void unwrap_delete_ARRAY(const event_args_t& ea) {
      on_delete_ARRAY(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())));
    }
    
    void on_insert_SINGLETON(const long singleton_iter_id, const long singleton_node_self, const long singleton_key) {
      
      ++tN;
      { //slice
        const HASH_RES_t h22 = QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey3_idxfn::hash(se49.modify3(singleton_node_self));
        const HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_3* i22 = static_cast<HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_3*>(QUERY_2_COUNT_mBTREE1_raw_reln_6.index[2]);
        HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_3::IdxNode* n22 = &(i22->buckets_[h22 & i22->mask_]);
        QUERY_2_COUNT_mBTREE1_raw_reln_6_entry* e21;
        do if ((e21 = n22->obj) && h22 == n22->hash && QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey3_idxfn::equals(se49, *e21)) {
          long concat_iter_id = e21->CONCAT_ITER_ID;
          long concat_node_self = e21->CONCAT_NODE_SELF;
          long concat_node_left = e21->QUERY_2_COUNT_mBTREEBTREE_NODE_SELF;
          long v21 = e21->__av;
          { //slice
            const HASH_RES_t h21 = QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::hash(se48.modify1(concat_node_left));
            const HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1* i21 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1*>(QUERY_2_COUNT_mCONCAT1_raw_reln_1.index[1]);
            HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1::IdxNode* n21 = &(i21->buckets_[h21 & i21->mask_]);
            QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry* e22;
            do if ((e22 = n21->obj) && h21 == n21->hash && QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::equals(se48, *e22)) {
              long btree_iter_id = e22->BTREE_ITER_ID;
              long btree_node_left = e22->BTREE_NODE_LEFT;
              long btree_node_right = e22->BTREE_NODE_RIGHT;
              long btree_separator = e22->BTREE_SEPARATOR;
              long v22 = e22->__av;
              QUERY_2_COUNT.addOrDelOnZero(se47.modify(concat_node_self), (v21 * v22));
            } while ((n21 = n21->nxt));
          }
        } while ((n22 = n22->nxt));
      }
      
      QUERY_2_COUNT_mCONCAT2_raw_reln_2.addOrDelOnZero(se50.modify(singleton_iter_id, singleton_node_self, singleton_key), 1);
    }
    
    void unwrap_insert_SINGLETON(const event_args_t& ea) {
      on_insert_SINGLETON(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())));
    }
    
    void on_delete_SINGLETON(const long singleton_iter_id, const long singleton_node_self, const long singleton_key) {
      
      ++tN;
      { //slice
        const HASH_RES_t h24 = QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey3_idxfn::hash(se53.modify3(singleton_node_self));
        const HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_3* i24 = static_cast<HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_3*>(QUERY_2_COUNT_mBTREE1_raw_reln_6.index[2]);
        HashIndex_QUERY_2_COUNT_mBTREE1_raw_reln_6_map_3::IdxNode* n24 = &(i24->buckets_[h24 & i24->mask_]);
        QUERY_2_COUNT_mBTREE1_raw_reln_6_entry* e23;
        do if ((e23 = n24->obj) && h24 == n24->hash && QUERY_2_COUNT_mBTREE1_raw_reln_6_mapkey3_idxfn::equals(se53, *e23)) {
          long concat_iter_id = e23->CONCAT_ITER_ID;
          long concat_node_self = e23->CONCAT_NODE_SELF;
          long concat_node_left = e23->QUERY_2_COUNT_mBTREEBTREE_NODE_SELF;
          long v23 = e23->__av;
          { //slice
            const HASH_RES_t h23 = QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::hash(se52.modify1(concat_node_left));
            const HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1* i23 = static_cast<HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1*>(QUERY_2_COUNT_mCONCAT1_raw_reln_1.index[1]);
            HashIndex_QUERY_2_COUNT_mCONCAT1_raw_reln_1_map_1::IdxNode* n23 = &(i23->buckets_[h23 & i23->mask_]);
            QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry* e24;
            do if ((e24 = n23->obj) && h23 == n23->hash && QUERY_2_COUNT_mCONCAT1_raw_reln_1_mapkey1_idxfn::equals(se52, *e24)) {
              long btree_iter_id = e24->BTREE_ITER_ID;
              long btree_node_left = e24->BTREE_NODE_LEFT;
              long btree_node_right = e24->BTREE_NODE_RIGHT;
              long btree_separator = e24->BTREE_SEPARATOR;
              long v24 = e24->__av;
              QUERY_2_COUNT.addOrDelOnZero(se51.modify(concat_node_self), ((v23 * v24) * -1));
            } while ((n23 = n23->nxt));
          }
        } while ((n24 = n24->nxt));
      }
      
      QUERY_2_COUNT_mCONCAT2_raw_reln_2.addOrDelOnZero(se54.modify(singleton_iter_id, singleton_node_self, singleton_key), -1);
    }
    
    void unwrap_delete_SINGLETON(const event_args_t& ea) {
      on_delete_SINGLETON(*(reinterpret_cast<long*>(ea[0].get())), *(reinterpret_cast<long*>(ea[1].get())), *(reinterpret_cast<long*>(ea[2].get())));
    }
    
    void on_system_ready_event() {
      
    }
  
  private:
    
      /* Preallocated map entries (to avoid recreation of temporary objects) */
      QUERY_3_COUNT_entry se1;
      QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry se2;
      QUERY_3_COUNT_mBTREE1_raw_reln_15_entry se3;
      QUERY_4_COUNT_entry se4;
      QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry se5;
      QUERY_5_COUNT_entry se6;
      QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry se7;
      QUERY_3_COUNT_entry se8;
      QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry se9;
      QUERY_3_COUNT_mBTREE1_raw_reln_15_entry se10;
      QUERY_4_COUNT_entry se11;
      QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry se12;
      QUERY_5_COUNT_entry se13;
      QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry se14;
      QUERY_2_COUNT_entry se15;
      QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry se16;
      QUERY_2_COUNT_mBTREE1_raw_reln_6_entry se17;
      QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry se18;
      QUERY_3_COUNT_entry se19;
      QUERY_3_COUNT_mBTREE1_raw_reln_15_entry se20;
      QUERY_4_COUNT_entry se21;
      QUERY_3_COUNT_mBTREE1_raw_reln_15_entry se22;
      QUERY_2_COUNT_entry se23;
      QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry se24;
      QUERY_2_COUNT_mBTREE1_raw_reln_6_entry se25;
      QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry se26;
      QUERY_3_COUNT_entry se27;
      QUERY_3_COUNT_mBTREE1_raw_reln_15_entry se28;
      QUERY_4_COUNT_entry se29;
      QUERY_3_COUNT_mBTREE1_raw_reln_15_entry se30;
      QUERY_2_COUNT_entry se31;
      QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry se32;
      QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry se33;
      QUERY_2_COUNT_mBTREE1_raw_reln_6_entry se34;
      QUERY_2_COUNT_entry se35;
      QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry se36;
      QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry se37;
      QUERY_2_COUNT_mBTREE1_raw_reln_6_entry se38;
      QUERY_1_COUNT_entry se39;
      QUERY_5_COUNT_entry se40;
      QUERY_3_COUNT_mBTREE1_raw_reln_15_entry se41;
      QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry se42;
      QUERY_1_COUNT_entry se43;
      QUERY_5_COUNT_entry se44;
      QUERY_3_COUNT_mBTREE1_raw_reln_15_entry se45;
      QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_entry se46;
      QUERY_2_COUNT_entry se47;
      QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry se48;
      QUERY_2_COUNT_mBTREE1_raw_reln_6_entry se49;
      QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry se50;
      QUERY_2_COUNT_entry se51;
      QUERY_2_COUNT_mCONCAT1_raw_reln_1_entry se52;
      QUERY_2_COUNT_mBTREE1_raw_reln_6_entry se53;
      QUERY_2_COUNT_mCONCAT2_raw_reln_2_entry se54;
    
      
    
      /* Data structures used for storing materialized views */
      QUERY_2_COUNT_mBTREE1_raw_reln_6_map QUERY_2_COUNT_mBTREE1_raw_reln_6;
      QUERY_2_COUNT_mCONCAT1_raw_reln_1_map QUERY_2_COUNT_mCONCAT1_raw_reln_1;
      QUERY_2_COUNT_mCONCAT2_raw_reln_2_map QUERY_2_COUNT_mCONCAT2_raw_reln_2;
      QUERY_3_COUNT_mBTREE1_raw_reln_15_map QUERY_3_COUNT_mBTREE1_raw_reln_15;
      QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21_map QUERY_5_COUNT_mDELETESINGLETON1_raw_reln_21;
    
      
    
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
  
//    protected:
      data_t data;
  };
  
  class Classic_maintenance : public Program {
    public:
      Classic_maintenance(int argc = 0, char* argv[] = 0) : Program(argc, argv) { }
  };

}
