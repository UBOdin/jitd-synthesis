#include <iostream>
#include <vector>
#include "int_record.hpp"

/*****************************/


typedef enum { 
  ArrayNodeType, 
  SortedNodeType, 
  ConcatNodeType, 
  BTreeNodeType, 
} JITDNodeType;

class JITDNode {
  public: 
  JITDNode(JITDNodeType type) : type(type) {}

  JITDNodeType type;
};

/*****************************/


class ArrayNode : public JITDNode { 
  public:
  ArrayNode( std::vector<Record> data ) : 
    JITDNode(ArrayNodeType),
    data(data)
  {}

  public:  
    std::vector<Record> data; 
};

class SortedNode : public JITDNode { 
  public:
  SortedNode( std::vector<Record> data ) : 
    JITDNode(SortedNodeType),
    data(data)
  {}

  public:  
    std::vector<Record> data; 
};

class ConcatNode : public JITDNode { 
  public:
  ConcatNode( JITDNode * lhs, JITDNode * rhs ) : 
    JITDNode(ConcatNodeType),
    lhs(lhs),
    rhs(rhs)
  {}

  public:  
    JITDNode * lhs;  
    JITDNode * rhs; 
};

class BTreeNode : public JITDNode { 
  public:
  BTreeNode( int sep, JITDNode * lhs, JITDNode * rhs ) : 
    JITDNode(BTreeNodeType),
    sep(sep),
    lhs(lhs),
    rhs(rhs)
  {}

  public:  
    int sep;  
    JITDNode * lhs;  
    JITDNode * rhs; 
};

int main(int argc, char **argv){ 
  std::cout << "TEST SUCCESSFUL!";
  return 0;
 }