
///////////////////// Headers ///////////////////// 

#include <iostream>
#include <vector>
#include <unordered_map>
#include <set>
#include <unordered_set>
#include <queue>
#include <memory>
#include <algorithm>
#include <ios>
#include <functional>
#include <sys/time.h>
#include <pthread.h>
#include "tbb/concurrent_queue.h" 
#include <condition_variable>
#include<mutex>
#include<cassert>
 
#include "int_record.hpp"
 
#include "runtime.hpp"


  #define JITD_DEBUG(cmd)

#define assertm(exp, msg) assert(((void)msg, exp))
///////////////////// Structures ///////////////////// 



///////////////////// Base Node Meta ///////////////////// 
typedef enum{
  EXIT,
  INSERT,
  REMOVE
}ClientInstruction;


typedef enum { 
  
    JITD_NODE_DeleteElements, 
  
    JITD_NODE_BTree, 
  
    JITD_NODE_Concat, 
  
    JITD_NODE_SortedArray, 
  
    JITD_NODE_Array, 
  
    JITD_NODE_Singleton, 
  
} JITDNodeType;

class JITDNode {
  public: 
  JITDNode(JITDNodeType type) : type(type) {}

  JITDNodeType type;
  //std::cout<<"STATE CALLED"<<std::endl;
};

typedef std::function<void(std::shared_ptr<JITDNode> &new_node)> UpdateHandle;

struct mutatorCqElement{
  int flag;
  std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> element;
};
///////////////////// Node Type Definitions ///////////////////// 


class DeleteElementsNode : public JITDNode { 
  public:
  DeleteElementsNode( const std::shared_ptr<JITDNode> &node, const std::vector<Record> &data ) : 
    JITDNode(JITD_NODE_DeleteElements)
    ,
      node(node)
    ,
      data(data)
    
  {}
  
  
    void update_node_handle(std::shared_ptr<JITDNode> &new_value){
      node = new_value;
    }
  

  public:  
    std::shared_ptr<JITDNode> node; 
   
    std::vector<Record> data; 
  
};

class BTreeNode : public JITDNode { 
  public:
  BTreeNode( const std::shared_ptr<JITDNode> &lhs, const long &sep, const std::shared_ptr<JITDNode> &rhs ) : 
    JITDNode(JITD_NODE_BTree)
    ,
      lhs(lhs)
    ,
      sep(sep)
    ,
      rhs(rhs)
    
  {}
  
  
    void update_lhs_handle(std::shared_ptr<JITDNode> &new_value){
      lhs = new_value;
    }
  
    void update_rhs_handle(std::shared_ptr<JITDNode> &new_value){
      rhs = new_value;
    }
  

  public:  
    std::shared_ptr<JITDNode> lhs; 
   
    long sep; 
   
    std::shared_ptr<JITDNode> rhs; 
  
};

class ConcatNode : public JITDNode { 
  public:
  ConcatNode( const std::shared_ptr<JITDNode> &lhs, const std::shared_ptr<JITDNode> &rhs ) : 
    JITDNode(JITD_NODE_Concat)
    ,
      lhs(lhs)
    ,
      rhs(rhs)
    
  {}
  
  
    void update_lhs_handle(std::shared_ptr<JITDNode> &new_value){
      lhs = new_value;
    }
  
    void update_rhs_handle(std::shared_ptr<JITDNode> &new_value){
      rhs = new_value;
    }
  

  public:  
    std::shared_ptr<JITDNode> lhs; 
   
    std::shared_ptr<JITDNode> rhs; 
  
};

class SortedArrayNode : public JITDNode { 
  public:
  SortedArrayNode( const std::vector<Record> &data ) : 
    JITDNode(JITD_NODE_SortedArray)
    ,
      data(data)
    
  {}
  
    SortedArrayNode():
      JITDNode(JITD_NODE_SortedArray)
        , data()
        {
}

  
  

  public:  
    std::vector<Record> data; 
  
};

class ArrayNode : public JITDNode { 
  public:
  ArrayNode( const std::vector<Record> &data ) : 
    JITDNode(JITD_NODE_Array)
    ,
      data(data)
    
  {}
  
    ArrayNode():
      JITDNode(JITD_NODE_Array)
        , data()
        {
}

  
  

  public:  
    std::vector<Record> data; 
  
};

class SingletonNode : public JITDNode { 
  public:
  SingletonNode( const Record &elem ) : 
    JITDNode(JITD_NODE_Singleton)
    ,
      elem(elem)
    
  {}
  
    SingletonNode():
      JITDNode(JITD_NODE_Singleton)
        , elem()
        {
}

  
  

  public:  
    Record elem; 
  
};


///////////////////// Transform Definitions ///////////////////// 

typedef enum { 
  
   JITD_TRANSFORM_DeleteElemFromArray,
  
   JITD_TRANSFORM_PushDownDontDeleteElemBtree,
  
   JITD_TRANSFORM_PushDownAndCrack,
  
   JITD_TRANSFORM_MergeUnSortedConcatArray,
  
   JITD_TRANSFORM_CrackArray,
  
} JITDTransformType;



///////////////////// JITD Debug Methods ///////////////////// 

class JITD;
std::shared_ptr<JITD> assemble_jitd(std::istream &in);
void print_JITD_node_structure(std::shared_ptr<JITDNode> node, const std::string &prefix);
void print_JITD_node_structure_viz(std::shared_ptr<JITDNode> node,std::shared_ptr<JITDNode> parent);
void jitd_get_depth(std::shared_ptr<JITDNode> node,int depth, int &maxdepth);
void print_time_vector_sum();
void print_search_time_vector_sum();
   
///////////////////// JITD Accessors ///////////////////// 


  int jitd_accessor_size(const std::shared_ptr<JITDNode> &jitd_node);

  bool jitd_accessor_get(const std::shared_ptr<JITDNode> &jitd_node, long target, Record &result);

///////////////////// JITD Definition ///////////////////// 


      
    






class JITD {
  
  public:
    pthread_mutex_t lock;



    struct CrackArray_Cmp{
 bool operator()( std::shared_ptr<JITDNode> * e1, std::shared_ptr<JITDNode> * e2) const{
  size_t e1_score = 0;
  JITDNode * e1_node_ptr = (*e1).get();
  size_t e2_score = 0;
  JITDNode * e2_node_ptr = (*e2).get();
  ArrayNode * e1_node_ptr_real = (ArrayNode *)e1_node_ptr;
  ArrayNode * e2_node_ptr_real = (ArrayNode *)e2_node_ptr;
  e1_score = array_size((e1_node_ptr_real->data));
  e2_score = array_size((e2_node_ptr_real->data));
  if(e1_score == e2_score){
    return (e1<e2);
  }
  else{
    return (e1_score > e2_score);
  }
 }
};



    std::set<std::shared_ptr<JITDNode> *> JITD_NODE_DeleteElements_set;
std::set<std::shared_ptr<JITDNode> *> PushDownDontDeleteElemBtree_View;
std::set<std::shared_ptr<JITDNode> *> JITD_NODE_Concat_set;
std::set<std::shared_ptr<JITDNode> *> PushDownAndCrack_View;
std::set<std::shared_ptr<JITDNode> *, CrackArray_Cmp> CrackArray_PQ;
std::set<std::shared_ptr<JITDNode> *, CrackArray_Cmp> CrackArray_View;
std::set<std::shared_ptr<JITDNode> *> MergeUnSortedConcatArray_View;
std::set<std::shared_ptr<JITDNode> *> DeleteElemFromArray_View;

    

    std::unordered_multimap<std::shared_ptr<JITDNode> *,std::shared_ptr<JITDNode> *> childParentMap;
    tbb::concurrent_bounded_queue<mutatorCqElement> work_queue;

    JITD(std::shared_ptr<std::shared_ptr<JITDNode>> jitd_root) : jitd_root(jitd_root)
    {
      if (pthread_mutex_init(&lock, NULL) != 0) { 
        std::cerr<<"\n mutex init has failed\n"<<std::endl; 
        exit(-1);
      }

      std::shared_ptr<JITDNode> *root_handle = &(*(this->jitd_root));initialize_struts(root_handle,NULL);
    }
    


    
    bool DeleteElemFromArray(std::shared_ptr<JITDNode> * &targetHandleRef);
    
    bool PushDownDontDeleteElemBtree(std::shared_ptr<JITDNode> * &targetHandleRef);
    
    bool PushDownAndCrack(std::shared_ptr<JITDNode> * &targetHandleRef);
    
    bool MergeUnSortedConcatArray(std::shared_ptr<JITDNode> * &targetHandleRef);
    
    bool CrackArray(std::shared_ptr<JITDNode> * &targetHandleRef);
    

    
      int size() {
        return jitd_accessor_size(*jitd_root);
      }
    
      bool get(long target, Record &result) {
        return jitd_accessor_get(*jitd_root, target, result);
      }
    

    
      void remove_elements(const std::vector<Record> &data);
void after_remove_elements(std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem);

    
      void insert(const std::vector<Record> &data);
void after_insert(std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem);

    
      void insert_singleton(const Record &data);
void after_insert_singleton(std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem);

    
    
    
   
    void print_pq();
    void check_pq();
    void print_map();
    void check_view();
    
    std::shared_ptr<JITDNode> * getParent(std::shared_ptr<JITDNode> * &target);
    void SetPqErase(std::shared_ptr<JITDNode> * node_handle);
    void SetPqAdd(std::shared_ptr<JITDNode> * node_handle);
    void viewAdd(std::shared_ptr<JITDNode> * node_handle);
    void viewErase(std::shared_ptr<JITDNode> * node_handle);
    void fixMap(std::shared_ptr<JITDNode> * node_handle,std::shared_ptr<JITDNode> * parent);
    
    void print_debug() {print_JITD_node_structure(*jitd_root, std::string("")); }
    void get_depth(int depth,int &maxdepth) {jitd_get_depth(*jitd_root,depth,maxdepth);}
    void print_debug_viz() {print_JITD_node_structure_viz(*jitd_root,*jitd_root); }
    bool do_organize();
    int organize_wait();
    
    void check_pq_intergrity(){check_pq();};
    void print_pq_size() {print_pq();}

    
    
    long searchForDeleteElemFromArray(std::shared_ptr<JITDNode> * &targetHandleRef);
    long searchForPushDownDontDeleteElemBtree(std::shared_ptr<JITDNode> * &targetHandleRef);
    long searchForPushDownAndCrack(std::shared_ptr<JITDNode> * &targetHandleRef);
    long searchForMergeUnSortedConcatArray(std::shared_ptr<JITDNode> * &targetHandleRef);
    long searchForCrackArray(std::shared_ptr<JITDNode> * &targetHandleRef);

    
    bool matchDeleteElemFromArray(std::shared_ptr<JITDNode> * &targetHandleRef);
    bool matchPushDownDontDeleteElemBtree(std::shared_ptr<JITDNode> * &targetHandleRef);
    bool matchPushDownAndCrack(std::shared_ptr<JITDNode> * &targetHandleRef);
    bool matchMergeUnSortedConcatArray(std::shared_ptr<JITDNode> * &targetHandleRef);
    bool matchCrackArray(std::shared_ptr<JITDNode> * &targetHandleRef);

    void initialize_struts(std::shared_ptr<JITDNode>* node, std::shared_ptr<JITDNode>* parent);
    
    
  private:

    //std::shared_ptr<JITDNode> root;
    std::shared_ptr<std::shared_ptr<JITDNode>> jitd_root;
    //void update_root(std::shared_ptr<JITDNode> &newRoot){ atomic_store(&root, newRoot); }
};


