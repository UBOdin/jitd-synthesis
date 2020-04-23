
#include <stack>
#include <sstream>
#include "runtime.hpp"
#include "jitd_test.hpp"


//#define JITD_DEBUG_POLICY true;
//std::shared_ptr<JITDNode> * rootHandleRef;


///////////////////// Transform Definitions ///////////////////// 


bool JITD::DeleteElemFromArray(std::shared_ptr<JITDNode> * &target )
{
/***std::cout<<" The transform applied is:JITD::DeleteElemFromArray"<<std::endl;***/
  {
    std::shared_ptr<JITDNode>* parent = getParent(target);
    // Extract target into DeleteElements
    std::shared_ptr<JITDNode> target_root_lock = std::atomic_load((target));
    switch((target_root_lock)->type){ 
      case JITD_NODE_DeleteElements:{
        DeleteElementsNode *target_root = (DeleteElementsNode *)(target_root_lock).get();
        // Extract &(target_root->node) into Array
        std::shared_ptr<JITDNode> target_root_node_lock = std::atomic_load((&(target_root->node)));
        switch((target_root_node_lock)->type){ 
          case JITD_NODE_Array:{
            ArrayNode *target_root_node = (ArrayNode *)(target_root_node_lock).get();
            {
              /*** ViewMaintenanceParent ***/
              viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
              /*** SetMaintenance ***/
              {
              }
              {
                {
                  {
                    {
                      {
                      }
                      {
                      }
                    }
                    this->CrackArray_PQ.erase(&(target_root->node));
                  }
                  {
                  }
                }
                {
                }
              }
              this->JITD_NODE_DeleteElements_set.erase(target);
              {
              }
              /*** MapMaintenance ***/
              this->childParentMap.erase(target);
              this->childParentMap.erase(&(target_root->node));
              /*** BEGIN ASSEMBLING to_ptr ***/
              /*** Assemble to_ptr as a Array ***/
              ArrayNode * to_ptr = new ArrayNode(target_root_node->data);
              std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
              /*** Handle post-processing for to_ptr ***/
              delete_from_leaf(to_ptr->data, target_root->data);
              /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
              std::atomic_store(target, to_ptr_ref);
              /*** SetMaintenance ***/
              {
                {
                  {
                    {
                      {
                      }
                      {
                      }
                    }
                    this->CrackArray_PQ.emplace(target);
                  }
                  {
                  }
                }
                {
                }
              }
              {
              }
              /*** ViewMaintenanceParent ***/
              viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              /*** MapMaintenance ***/
              this->childParentMap.emplace(target,parent);
              return true;
            }
          }; break;
          default: { //target_root_node is not a Array
            return false;
          }; break;
        }
      }; break;
      default: { //target_root is not a DeleteElements
        return false;
      }; break;
    }
  }

}

bool JITD::PushDownDontDeleteElemBtree(std::shared_ptr<JITDNode> * &target )
{
/***std::cout<<" The transform applied is:JITD::PushDownDontDeleteElemBtree"<<std::endl;***/
  {
    std::shared_ptr<JITDNode>* parent = getParent(target);
    // Extract target into DeleteElements
    std::shared_ptr<JITDNode> target_root_lock = std::atomic_load((target));
    switch((target_root_lock)->type){ 
      case JITD_NODE_DeleteElements:{
        DeleteElementsNode *target_root = (DeleteElementsNode *)(target_root_lock).get();
        // Extract &(target_root->node) into BTree
        std::shared_ptr<JITDNode> target_root_node_lock = std::atomic_load((&(target_root->node)));
        switch((target_root_node_lock)->type){ 
          case JITD_NODE_BTree:{
            BTreeNode *target_root_node = (BTreeNode *)(target_root_node_lock).get();
            {
              /*** ViewMaintenanceParent ***/
              viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
              viewErase(&(target_root_node->lhs));
              viewErase(&(target_root_node->rhs));
              /*** SetMaintenance ***/
              {
              }
              {
                {
                  {
                    {
                      {
                      }
                      {
                      }
                    }
                    {
                    }
                  }
                  {
                  }
                }
                {
                }
              }
              {
              }
              {
              }
              this->JITD_NODE_DeleteElements_set.erase(target);
              {
              }
              SetPqErase(&(target_root_node->lhs));
              SetPqErase(&(target_root_node->rhs));
              /*** MapMaintenance ***/
              this->childParentMap.erase(target);
              this->childParentMap.erase(&(target_root->node));
              this->childParentMap.erase(&(target_root_node->lhs));
              this->childParentMap.erase(&(target_root_node->rhs));
              /*** BEGIN ASSEMBLING to_ptr ***/
              /*** Assemble to_ptr_lhs as a DeleteElements ***/
              DeleteElementsNode * to_ptr_lhs = new DeleteElementsNode(target_root_node->lhs, target_root->data);
              std::shared_ptr<JITDNode> to_ptr_lhs_ref = std::shared_ptr<JITDNode>(to_ptr_lhs);
              /*** Assemble to_ptr_rhs as a DeleteElements ***/
              DeleteElementsNode * to_ptr_rhs = new DeleteElementsNode(target_root_node->rhs, target_root->data);
              std::shared_ptr<JITDNode> to_ptr_rhs_ref = std::shared_ptr<JITDNode>(to_ptr_rhs);
              /*** Assemble to_ptr as a BTree ***/
              BTreeNode * to_ptr = new BTreeNode(to_ptr_lhs_ref, target_root_node->sep, to_ptr_rhs_ref);
              std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
              /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
              std::atomic_store(target, to_ptr_ref);
              /*** SetMaintenance ***/
              {
              }
              {
                {
                  {
                    {
                      {
                      }
                      {
                      }
                    }
                    {
                    }
                  }
                  {
                  }
                }
                {
                }
              }
              {
              }
              {
                {
                  {
                    {
                      {
                      }
                      {
                      }
                    }
                    {
                    }
                  }
                  {
                  }
                }
                {
                }
              }
              {
              }
              {
              }
              this->JITD_NODE_DeleteElements_set.emplace(&(to_ptr->lhs));
              SetPqAdd(&(to_ptr_lhs->node));
              this->JITD_NODE_DeleteElements_set.emplace(&(to_ptr->rhs));
              SetPqAdd(&(to_ptr_rhs->node));
              /*** ViewMaintenanceParent ***/
              viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              viewAdd(&(to_ptr->lhs));
              viewAdd(&(to_ptr_lhs->node));
              viewAdd(&(to_ptr->rhs));
              viewAdd(&(to_ptr_rhs->node));
              /*** MapMaintenance ***/
              this->childParentMap.emplace(target,parent);
              this->childParentMap.emplace(&(to_ptr->lhs),target);
              {
                this->childParentMap.emplace(&(to_ptr_lhs->node),&(to_ptr->lhs));
                fixMap(&(to_ptr_lhs->node),&(to_ptr_lhs->node));
              }
              this->childParentMap.emplace(&(to_ptr->rhs),target);
              {
                this->childParentMap.emplace(&(to_ptr_rhs->node),&(to_ptr->rhs));
                fixMap(&(to_ptr_rhs->node),&(to_ptr_rhs->node));
              }
              return true;
            }
          }; break;
          default: { //target_root_node is not a BTree
            return false;
          }; break;
        }
      }; break;
      default: { //target_root is not a DeleteElements
        return false;
      }; break;
    }
  }

}

bool JITD::PushDownAndCrack(std::shared_ptr<JITDNode> * &target )
{
/***std::cout<<" The transform applied is:JITD::PushDownAndCrack"<<std::endl;***/
  {
    std::shared_ptr<JITDNode>* parent = getParent(target);
    // Extract target into Concat
    std::shared_ptr<JITDNode> target_root_lock = std::atomic_load((target));
    switch((target_root_lock)->type){ 
      case JITD_NODE_Concat:{
        ConcatNode *target_root = (ConcatNode *)(target_root_lock).get();
        // Extract &(target_root->lhs) into BTree
        std::shared_ptr<JITDNode> target_root_lhs_lock = std::atomic_load((&(target_root->lhs)));
        switch((target_root_lhs_lock)->type){ 
          case JITD_NODE_BTree:{
            BTreeNode *target_root_lhs = (BTreeNode *)(target_root_lhs_lock).get();
            // Extract &(target_root->rhs) into Array
            std::shared_ptr<JITDNode> target_root_rhs_lock = std::atomic_load((&(target_root->rhs)));
            switch((target_root_rhs_lock)->type){ 
              case JITD_NODE_Array:{
                ArrayNode *target_root_rhs = (ArrayNode *)(target_root_rhs_lock).get();
                {
                  /*** ViewMaintenanceParent ***/
                  viewErase(parent);
                  /*** ViewMaintenance ***/
                  viewErase(target);
                  viewErase(&(target_root->lhs));
                  viewErase(&(target_root_lhs->lhs));
                  viewErase(&(target_root_lhs->rhs));
                  viewErase(&(target_root->rhs));
                  /*** SetMaintenance ***/
                  {
                  }
                  {
                    {
                      {
                        {
                          {
                          }
                          {
                          }
                        }
                        {
                        }
                      }
                      {
                      }
                    }
                    {
                    }
                  }
                  {
                  }
                  {
                  }
                  {
                    {
                      {
                        {
                          {
                          }
                          {
                          }
                        }
                        this->CrackArray_PQ.erase(&(target_root->rhs));
                      }
                      {
                      }
                    }
                    {
                    }
                  }
                  this->JITD_NODE_Concat_set.erase(target);
                  {
                  }
                  SetPqErase(&(target_root_lhs->lhs));
                  SetPqErase(&(target_root_lhs->rhs));
                  {
                  }
                  /*** MapMaintenance ***/
                  this->childParentMap.erase(target);
                  this->childParentMap.erase(&(target_root->lhs));
                  this->childParentMap.erase(&(target_root_lhs->lhs));
                  this->childParentMap.erase(&(target_root_lhs->rhs));
                  this->childParentMap.erase(&(target_root->rhs));
                  /*** BEGIN ASSEMBLING to_ptr ***/
                  /*** Assemble to_ptr_lhs_rhs as a Array ***/
                  ArrayNode * to_ptr_lhs_rhs_ref = new ArrayNode();
                  std::shared_ptr<JITDNode> lhs_partition_ref = std::shared_ptr<JITDNode>(to_ptr_lhs_rhs_ref);
                  /*** Assemble to_ptr_lhs as a Concat ***/
                  ConcatNode * to_ptr_lhs = new ConcatNode(target_root_lhs->lhs, lhs_partition_ref);
                  std::shared_ptr<JITDNode> to_ptr_lhs_ref = std::shared_ptr<JITDNode>(to_ptr_lhs);
                  /*** Assemble to_ptr_rhs_rhs as a Array ***/
                  ArrayNode * to_ptr_rhs_rhs_ref = new ArrayNode();
                  std::shared_ptr<JITDNode> rhs_partition_ref = std::shared_ptr<JITDNode>(to_ptr_rhs_rhs_ref);
                  /*** Assemble to_ptr_rhs as a Concat ***/
                  ConcatNode * to_ptr_rhs = new ConcatNode(target_root_lhs->rhs, rhs_partition_ref);
                  std::shared_ptr<JITDNode> to_ptr_rhs_ref = std::shared_ptr<JITDNode>(to_ptr_rhs);
                  /*** Assemble to_ptr as a BTree ***/
                  BTreeNode * to_ptr = new BTreeNode(to_ptr_lhs_ref, target_root_lhs->sep, to_ptr_rhs_ref);
                  std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
                  /*** Handle post-processing for to_ptr ***/
                  do_crack(target_root_rhs->data, target_root_lhs->sep, to_ptr_lhs_rhs_ref->data, to_ptr_rhs_rhs_ref->data);
                  /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
                  std::atomic_store(target, to_ptr_ref);
                  /*** SetMaintenance ***/
                  {
                  }
                  {
                  }
                  {
                  }
                  {
                    {
                      {
                        {
                          {
                          }
                          {
                          }
                        }
                        this->CrackArray_PQ.emplace(&(to_ptr_lhs->rhs));
                      }
                      {
                      }
                    }
                    {
                    }
                  }
                  {
                  }
                  {
                  }
                  {
                    {
                      {
                        {
                          {
                          }
                          {
                          }
                        }
                        this->CrackArray_PQ.emplace(&(to_ptr_rhs->rhs));
                      }
                      {
                      }
                    }
                    {
                    }
                  }
                  {
                  }
                  this->JITD_NODE_Concat_set.emplace(&(to_ptr->lhs));
                  SetPqAdd(&(to_ptr_lhs->lhs));
                  {
                  }
                  this->JITD_NODE_Concat_set.emplace(&(to_ptr->rhs));
                  SetPqAdd(&(to_ptr_rhs->lhs));
                  {
                  }
                  /*** ViewMaintenanceParent ***/
                  viewAdd(parent);
                  /*** ViewMaintenance ***/
                  viewAdd(target);
                  viewAdd(&(to_ptr->lhs));
                  viewAdd(&(to_ptr_lhs->lhs));
                  viewAdd(&(to_ptr_lhs->rhs));
                  viewAdd(&(to_ptr->rhs));
                  viewAdd(&(to_ptr_rhs->lhs));
                  viewAdd(&(to_ptr_rhs->rhs));
                  /*** MapMaintenance ***/
                  this->childParentMap.emplace(target,parent);
                  this->childParentMap.emplace(&(to_ptr->lhs),target);
                  {
                    this->childParentMap.emplace(&(to_ptr_lhs->lhs),&(to_ptr->lhs));
                    fixMap(&(to_ptr_lhs->lhs),&(to_ptr_lhs->lhs));
                  }
                  {
                    this->childParentMap.emplace(&(to_ptr_lhs->rhs),&(to_ptr->lhs));
                    fixMap(&(to_ptr_lhs->rhs),&(to_ptr_lhs->rhs));
                  }
                  this->childParentMap.emplace(&(to_ptr->rhs),target);
                  {
                    this->childParentMap.emplace(&(to_ptr_rhs->lhs),&(to_ptr->rhs));
                    fixMap(&(to_ptr_rhs->lhs),&(to_ptr_rhs->lhs));
                  }
                  {
                    this->childParentMap.emplace(&(to_ptr_rhs->rhs),&(to_ptr->rhs));
                    fixMap(&(to_ptr_rhs->rhs),&(to_ptr_rhs->rhs));
                  }
                  return true;
                }
              }; break;
              default: { //target_root_rhs is not a Array
                return false;
              }; break;
            }
          }; break;
          default: { //target_root_lhs is not a BTree
            return false;
          }; break;
        }
      }; break;
      default: { //target_root is not a Concat
        return false;
      }; break;
    }
  }

}

bool JITD::MergeUnSortedConcatArray(std::shared_ptr<JITDNode> * &target )
{
/***std::cout<<" The transform applied is:JITD::MergeUnSortedConcatArray"<<std::endl;***/
  {
    std::shared_ptr<JITDNode>* parent = getParent(target);
    // Extract target into Concat
    std::shared_ptr<JITDNode> target_root_lock = std::atomic_load((target));
    switch((target_root_lock)->type){ 
      case JITD_NODE_Concat:{
        ConcatNode *target_root = (ConcatNode *)(target_root_lock).get();
        // Extract &(target_root->lhs) into Array
        std::shared_ptr<JITDNode> target_root_lhs_lock = std::atomic_load((&(target_root->lhs)));
        switch((target_root_lhs_lock)->type){ 
          case JITD_NODE_Array:{
            ArrayNode *target_root_lhs = (ArrayNode *)(target_root_lhs_lock).get();
            // Extract &(target_root->rhs) into Array
            std::shared_ptr<JITDNode> target_root_rhs_lock = std::atomic_load((&(target_root->rhs)));
            switch((target_root_rhs_lock)->type){ 
              case JITD_NODE_Array:{
                ArrayNode *target_root_rhs = (ArrayNode *)(target_root_rhs_lock).get();
                {
                  /*** ViewMaintenanceParent ***/
                  viewErase(parent);
                  /*** ViewMaintenance ***/
                  viewErase(target);
                  viewErase(&(target_root->lhs));
                  viewErase(&(target_root->rhs));
                  /*** SetMaintenance ***/
                  {
                  }
                  {
                    {
                      {
                        {
                          {
                          }
                          {
                          }
                        }
                        this->CrackArray_PQ.erase(&(target_root->lhs));
                      }
                      {
                      }
                    }
                    {
                    }
                  }
                  {
                    {
                      {
                        {
                          {
                          }
                          {
                          }
                        }
                        this->CrackArray_PQ.erase(&(target_root->rhs));
                      }
                      {
                      }
                    }
                    {
                    }
                  }
                  this->JITD_NODE_Concat_set.erase(target);
                  {
                  }
                  {
                  }
                  /*** MapMaintenance ***/
                  this->childParentMap.erase(target);
                  this->childParentMap.erase(&(target_root->lhs));
                  this->childParentMap.erase(&(target_root->rhs));
                  /*** BEGIN ASSEMBLING to_ptr ***/
                  /*** Assemble to_ptr as a Array ***/
                  ArrayNode * to_ptr = new ArrayNode(target_root_lhs->data);
                  std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
                  /*** Handle post-processing for to_ptr ***/
                  append(to_ptr->data, target_root_rhs->data);
                  /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
                  std::atomic_store(target, to_ptr_ref);
                  /*** SetMaintenance ***/
                  {
                    {
                      {
                        {
                          {
                          }
                          {
                          }
                        }
                        this->CrackArray_PQ.emplace(target);
                      }
                      {
                      }
                    }
                    {
                    }
                  }
                  {
                  }
                  /*** ViewMaintenanceParent ***/
                  viewAdd(parent);
                  /*** ViewMaintenance ***/
                  viewAdd(target);
                  /*** MapMaintenance ***/
                  this->childParentMap.emplace(target,parent);
                  return true;
                }
              }; break;
              default: { //target_root_rhs is not a Array
                return false;
              }; break;
            }
          }; break;
          default: { //target_root_lhs is not a Array
            return false;
          }; break;
        }
      }; break;
      default: { //target_root is not a Concat
        return false;
      }; break;
    }
  }

}

bool JITD::CrackArray(std::shared_ptr<JITDNode> * &target )
{
/***std::cout<<" The transform applied is:JITD::CrackArray"<<std::endl;***/
  {
    std::shared_ptr<JITDNode>* parent = getParent(target);
    // Extract target into Array
    std::shared_ptr<JITDNode> target_root_lock = std::atomic_load((target));
    switch((target_root_lock)->type){ 
      case JITD_NODE_Array:{
        ArrayNode *target_root = (ArrayNode *)(target_root_lock).get();
        {
          /*** ViewMaintenanceParent ***/
          viewErase(parent);
          /*** ViewMaintenance ***/
          viewErase(target);
          /*** SetMaintenance ***/
          {
            {
              {
                {
                  {
                  }
                  {
                  }
                }
                this->CrackArray_PQ.erase(target);
              }
              {
              }
            }
            {
            }
          }
          {
          }
          /*** MapMaintenance ***/
          this->childParentMap.erase(target);
          /*** BEGIN ASSEMBLING to_ptr ***/
          /*** Assemble to_ptr_lhs as a Array ***/
          ArrayNode * to_ptr_lhs_ref = new ArrayNode();
          std::shared_ptr<JITDNode> lhs_partition_ref = std::shared_ptr<JITDNode>(to_ptr_lhs_ref);
          /*** Assemble to_ptr_rhs as a Array ***/
          ArrayNode * to_ptr_rhs_ref = new ArrayNode();
          std::shared_ptr<JITDNode> rhs_partition_ref = std::shared_ptr<JITDNode>(to_ptr_rhs_ref);
          /*** Assemble to_ptr as a BTree ***/
          BTreeNode * to_ptr = new BTreeNode(lhs_partition_ref, pick_separator(target_root->data), rhs_partition_ref);
          std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
          /*** Handle post-processing for to_ptr ***/
          do_crack(target_root->data, to_ptr->sep, to_ptr_lhs_ref->data, to_ptr_rhs_ref->data);
          /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
          std::atomic_store(target, to_ptr_ref);
          /*** SetMaintenance ***/
          {
          }
          {
            {
              {
                {
                  {
                  }
                  {
                  }
                }
                this->CrackArray_PQ.emplace(&(to_ptr->lhs));
              }
              {
              }
            }
            {
            }
          }
          {
            {
              {
                {
                  {
                  }
                  {
                  }
                }
                this->CrackArray_PQ.emplace(&(to_ptr->rhs));
              }
              {
              }
            }
            {
            }
          }
          {
          }
          {
          }
          {
          }
          /*** ViewMaintenanceParent ***/
          viewAdd(parent);
          /*** ViewMaintenance ***/
          viewAdd(target);
          viewAdd(&(to_ptr->lhs));
          viewAdd(&(to_ptr->rhs));
          /*** MapMaintenance ***/
          this->childParentMap.emplace(target,parent);
          this->childParentMap.emplace(&(to_ptr->lhs),target);
          this->childParentMap.emplace(&(to_ptr->rhs),target);
          return true;
        }
      }; break;
      default: { //target_root is not a Array
        return false;
      }; break;
    }
  }

}


///////////////////// Accessor Definitions ///////////////////// 


int jitd_accessor_size(const std::shared_ptr<JITDNode> &jitd_node_ref )
{
/***std::cout<<" The transform applied is:jitd_accessor_size"<<std::endl;***/
  // Extract &(jitd_node_ref) into Singleton or Concat or DeleteElements or BTree or Array or SortedArray
  std::shared_ptr<JITDNode> jitd_node_lock = std::atomic_load((&(jitd_node_ref)));
  switch((jitd_node_lock)->type){ 
    case JITD_NODE_Singleton:{
      SingletonNode *jitd_node = (SingletonNode *)(jitd_node_lock).get();
      return 1;
    }; break;
    case JITD_NODE_Concat:{
      ConcatNode *jitd_node = (ConcatNode *)(jitd_node_lock).get();
      return (jitd_accessor_size(jitd_node->lhs)) + (jitd_accessor_size(jitd_node->rhs));
    }; break;
    case JITD_NODE_DeleteElements:{
      DeleteElementsNode *jitd_node = (DeleteElementsNode *)(jitd_node_lock).get();
      return (jitd_accessor_size(jitd_node->node)) - (array_size(jitd_node->data));
    }; break;
    case JITD_NODE_BTree:{
      BTreeNode *jitd_node = (BTreeNode *)(jitd_node_lock).get();
      return (jitd_accessor_size(jitd_node->lhs)) + (jitd_accessor_size(jitd_node->rhs));
    }; break;
    case JITD_NODE_Array:{
      ArrayNode *jitd_node = (ArrayNode *)(jitd_node_lock).get();
      return array_size(jitd_node->data);
    }; break;
    case JITD_NODE_SortedArray:{
      SortedArrayNode *jitd_node = (SortedArrayNode *)(jitd_node_lock).get();
      return array_size(jitd_node->data);
    }; break;
    default: { //jitd_node is not a Singleton or a Concat or a DeleteElements or a BTree or a Array or a SortedArray
      std::cerr << "Unhandled Node Type in size" << std::endl;
      exit(-1);
    }; break;
  }

}

bool jitd_accessor_get(const std::shared_ptr<JITDNode> &jitd_node_ref ,long target ,Record &result )
{
/***std::cout<<" The transform applied is:jitd_accessor_get"<<std::endl;***/
  // Extract &(jitd_node_ref) into Singleton or Concat or DeleteElements or BTree or Array or SortedArray
  std::shared_ptr<JITDNode> jitd_node_lock = std::atomic_load((&(jitd_node_ref)));
  switch((jitd_node_lock)->type){ 
    case JITD_NODE_Singleton:{
      SingletonNode *jitd_node = (SingletonNode *)(jitd_node_lock).get();
      return singleton_scan(jitd_node->elem, target, result);
    }; break;
    case JITD_NODE_Concat:{
      ConcatNode *jitd_node = (ConcatNode *)(jitd_node_lock).get();
      if(jitd_accessor_get(jitd_node->lhs, target, result))
        return true;
      else
        return jitd_accessor_get(jitd_node->rhs, target, result);
    }; break;
    case JITD_NODE_DeleteElements:{
      DeleteElementsNode *jitd_node = (DeleteElementsNode *)(jitd_node_lock).get();
      if(record_scan(jitd_node->data, target, result))
        return false;
      else
        return jitd_accessor_get(jitd_node->node, target, result);
    }; break;
    case JITD_NODE_BTree:{
      BTreeNode *jitd_node = (BTreeNode *)(jitd_node_lock).get();
      if((target) < (jitd_node->sep))
        return jitd_accessor_get(jitd_node->lhs, target, result);
      else
        return jitd_accessor_get(jitd_node->rhs, target, result);
    }; break;
    case JITD_NODE_Array:{
      ArrayNode *jitd_node = (ArrayNode *)(jitd_node_lock).get();
      return record_scan(jitd_node->data, target, result);
    }; break;
    case JITD_NODE_SortedArray:{
      SortedArrayNode *jitd_node = (SortedArrayNode *)(jitd_node_lock).get();
      return record_binary_search(jitd_node->data, target, result);
    }; break;
    default: { //jitd_node is not a Singleton or a Concat or a DeleteElements or a BTree or a Array or a SortedArray
      std::cerr << "Unhandled Node Type in get" << std::endl;
      exit(-1);
    }; break;
  }

}


///////////////////// Mutator Definitions ///////////////////// 


void JITD::remove_elements(const std::vector<Record> &data )
{
/***std::cout<<" The transform applied is:JITD::remove_elements"<<std::endl;***/
  {
    pthread_mutex_lock(&this->lock);
    /*** BEGIN ASSEMBLING new_root ***/
    /*** Assemble new_root as a DeleteElements ***/
    DeleteElementsNode * new_root = new DeleteElementsNode(*jitd_root, data);
    /*** END ASSEMBLING new_root as new_root_ref ***/
    std::shared_ptr<std::shared_ptr<JITDNode>> new_root_ptr = std::shared_ptr<std::shared_ptr<JITDNode>>(std::make_shared<std::shared_ptr<JITDNode>>(std::shared_ptr<JITDNode>(new_root)));
    mutatorCqElement mce;
    mce.flag = REMOVE;
    (mce.element).first = jitd_root;
    (mce.element).second = new_root_ptr;
    this->work_queue.push(mce);
    std::atomic_store(&jitd_root, new_root_ptr);
    pthread_mutex_unlock(&this->lock);
  }

}
void JITD::after_remove_elements(std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem)
{
/***std::cout<<" The transform applied is:JITD::after_remove_elements"<<std::endl;***/
  {
    SetPqErase(&( *(cq_elem.first)));
    this->childParentMap.erase(&( *(cq_elem.first)));
    viewErase(&( *(cq_elem.first)));
    DeleteElementsNode *cast_root = (DeleteElementsNode*)((cq_elem.second)->get());
    /*** SetMaintenance ***/
    {
      {
        {
          {
            {
            }
            {
            }
          }
          {
          }
        }
        {
        }
      }
      {
      }
    }
    {
    }
    this->JITD_NODE_DeleteElements_set.emplace(&(*(cq_elem.second)));
    {
      std::atomic_store(&(cast_root->node), *(cq_elem.first));
      fixMap(&(*(cq_elem.first)),&(cast_root->node));
      SetPqAdd(&(cast_root->node));
    }
    /*** ViewMaintenance ***/
    viewAdd(&(*(cq_elem.second)));
    viewAdd(&(cast_root->node));
    /*** MapMaintenance ***/
    this->childParentMap.emplace(std::make_pair<std::shared_ptr<JITDNode> *,std::shared_ptr<JITDNode> *>(&(*(cq_elem.second)),NULL));
    this->childParentMap.emplace(&(cast_root->node),&(*(cq_elem.second)));
  }

}


void JITD::insert(const std::vector<Record> &data )
{
/***std::cout<<" The transform applied is:JITD::insert"<<std::endl;***/
  {
    pthread_mutex_lock(&this->lock);
    /*** BEGIN ASSEMBLING new_root ***/
    /*** Assemble new_root_rhs as a Array ***/
    ArrayNode * new_root_rhs = new ArrayNode(data);
    std::shared_ptr<JITDNode> new_root_rhs_ref = std::shared_ptr<JITDNode>(new_root_rhs);
    /*** Assemble new_root as a Concat ***/
    ConcatNode * new_root = new ConcatNode(*jitd_root, new_root_rhs_ref);
    /*** END ASSEMBLING new_root as new_root_ref ***/
    std::shared_ptr<std::shared_ptr<JITDNode>> new_root_ptr = std::shared_ptr<std::shared_ptr<JITDNode>>(std::make_shared<std::shared_ptr<JITDNode>>(std::shared_ptr<JITDNode>(new_root)));
    mutatorCqElement mce;
    mce.flag = INSERT;
    (mce.element).first = jitd_root;
    (mce.element).second = new_root_ptr;
    this->work_queue.push(mce);
    std::atomic_store(&jitd_root, new_root_ptr);
    pthread_mutex_unlock(&this->lock);
  }

}
void JITD::after_insert(std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem)
{
/***std::cout<<" The transform applied is:JITD::after_insert"<<std::endl;***/
  {
    SetPqErase(&( *(cq_elem.first)));
    this->childParentMap.erase(&( *(cq_elem.first)));
    viewErase(&( *(cq_elem.first)));
    ConcatNode *cast_root = (ConcatNode*)((cq_elem.second)->get());
    /*** SetMaintenance ***/
    {
    }
    {
    }
    {
      {
        {
          {
            {
            }
            {
            }
          }
          this->CrackArray_PQ.emplace(&(cast_root->rhs));
        }
        {
        }
      }
      {
      }
    }
    this->JITD_NODE_Concat_set.emplace(&(*(cq_elem.second)));
    {
      std::atomic_store(&(cast_root->lhs), *(cq_elem.first));
      fixMap(&(*(cq_elem.first)),&(cast_root->lhs));
      SetPqAdd(&(cast_root->lhs));
    }
    {
    }
    /*** ViewMaintenance ***/
    viewAdd(&(*(cq_elem.second)));
    viewAdd(&(cast_root->lhs));
    viewAdd(&(cast_root->rhs));
    /*** MapMaintenance ***/
    this->childParentMap.emplace(std::make_pair<std::shared_ptr<JITDNode> *,std::shared_ptr<JITDNode> *>(&(*(cq_elem.second)),NULL));
    this->childParentMap.emplace(&(cast_root->lhs),&(*(cq_elem.second)));
    this->childParentMap.emplace(&(cast_root->rhs),&(*(cq_elem.second)));
  }

}


void JITD::insert_singleton(const Record &data )
{
/***std::cout<<" The transform applied is:JITD::insert_singleton"<<std::endl;***/
  {
    pthread_mutex_lock(&this->lock);
    /*** BEGIN ASSEMBLING new_root ***/
    /*** Assemble new_root_rhs as a Singleton ***/
    SingletonNode * new_root_rhs = new SingletonNode(data);
    std::shared_ptr<JITDNode> new_root_rhs_ref = std::shared_ptr<JITDNode>(new_root_rhs);
    /*** Assemble new_root as a Concat ***/
    ConcatNode * new_root = new ConcatNode(*jitd_root, new_root_rhs_ref);
    /*** END ASSEMBLING new_root as new_root_ref ***/
    std::shared_ptr<std::shared_ptr<JITDNode>> new_root_ptr = std::shared_ptr<std::shared_ptr<JITDNode>>(std::make_shared<std::shared_ptr<JITDNode>>(std::shared_ptr<JITDNode>(new_root)));
    mutatorCqElement mce;
    mce.flag = INSERT;
    (mce.element).first = jitd_root;
    (mce.element).second = new_root_ptr;
    this->work_queue.push(mce);
    std::atomic_store(&jitd_root, new_root_ptr);
    pthread_mutex_unlock(&this->lock);
  }

}
void JITD::after_insert_singleton(std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem)
{
/***std::cout<<" The transform applied is:JITD::after_insert_singleton"<<std::endl;***/
  {
    SetPqErase(&( *(cq_elem.first)));
    this->childParentMap.erase(&( *(cq_elem.first)));
    viewErase(&( *(cq_elem.first)));
    ConcatNode *cast_root = (ConcatNode*)((cq_elem.second)->get());
    /*** SetMaintenance ***/
    {
    }
    {
    }
    {
      {
        {
          {
            {
            }
            {
            }
          }
          {
          }
        }
        {
        }
      }
      {
      }
    }
    this->JITD_NODE_Concat_set.emplace(&(*(cq_elem.second)));
    {
      std::atomic_store(&(cast_root->lhs), *(cq_elem.first));
      fixMap(&(*(cq_elem.first)),&(cast_root->lhs));
      SetPqAdd(&(cast_root->lhs));
    }
    {
    }
    /*** ViewMaintenance ***/
    viewAdd(&(*(cq_elem.second)));
    viewAdd(&(cast_root->lhs));
    viewAdd(&(cast_root->rhs));
    /*** MapMaintenance ***/
    this->childParentMap.emplace(std::make_pair<std::shared_ptr<JITDNode> *,std::shared_ptr<JITDNode> *>(&(*(cq_elem.second)),NULL));
    this->childParentMap.emplace(&(cast_root->lhs),&(*(cq_elem.second)));
    this->childParentMap.emplace(&(cast_root->rhs),&(*(cq_elem.second)));
  }

}


///////////////////// OnMatch Transforms /////////////////////


bool JITD::matchPushDownDontDeleteElemBtree(std::shared_ptr<JITDNode> * &targetHandleRef) 
{ 
	
	std::shared_ptr<JITDNode> target_root = std::atomic_load(targetHandleRef);
	JITDNode * target_root_lock = target_root.get();
	if(target_root_lock->type != JITD_NODE_DeleteElements){return false; }
DeleteElementsNode *target_root_lock_real = (DeleteElementsNode *)target_root_lock;
JITDNode *target_root_lock_real_node = target_root_lock_real->node.get();
if(target_root_lock_real_node->type != JITD_NODE_BTree){return false; }
BTreeNode *target_root_lock_real_node_real = (BTreeNode *)target_root_lock_real_node;


	return true;
}
bool JITD::matchPushDownAndCrack(std::shared_ptr<JITDNode> * &targetHandleRef) 
{ 
	
	std::shared_ptr<JITDNode> target_root = std::atomic_load(targetHandleRef);
	JITDNode * target_root_lock = target_root.get();
	if(target_root_lock->type != JITD_NODE_Concat){return false; }
ConcatNode *target_root_lock_real = (ConcatNode *)target_root_lock;
JITDNode *target_root_lock_real_lhs = target_root_lock_real->lhs.get();
if(target_root_lock_real_lhs->type != JITD_NODE_BTree){return false; }
BTreeNode *target_root_lock_real_lhs_real = (BTreeNode *)target_root_lock_real_lhs;
JITDNode *target_root_lock_real_rhs = target_root_lock_real->rhs.get();
if(target_root_lock_real_rhs->type != JITD_NODE_Array){return false; }
ArrayNode *target_root_lock_real_rhs_real = (ArrayNode *)target_root_lock_real_rhs;


	return true;
}
bool JITD::matchCrackArray(std::shared_ptr<JITDNode> * &targetHandleRef) 
{ 
	
	std::shared_ptr<JITDNode> target_root = std::atomic_load(targetHandleRef);
	JITDNode * target_root_lock = target_root.get();
	if(target_root_lock->type != JITD_NODE_Array){return false; }
ArrayNode *target_root_lock_real = (ArrayNode *)target_root_lock;


	return true;
}
bool JITD::matchMergeUnSortedConcatArray(std::shared_ptr<JITDNode> * &targetHandleRef) 
{ 
	
	std::shared_ptr<JITDNode> target_root = std::atomic_load(targetHandleRef);
	JITDNode * target_root_lock = target_root.get();
	if(target_root_lock->type != JITD_NODE_Concat){return false; }
ConcatNode *target_root_lock_real = (ConcatNode *)target_root_lock;
JITDNode *target_root_lock_real_lhs = target_root_lock_real->lhs.get();
if(target_root_lock_real_lhs->type != JITD_NODE_Array){return false; }
ArrayNode *target_root_lock_real_lhs_real = (ArrayNode *)target_root_lock_real_lhs;
JITDNode *target_root_lock_real_rhs = target_root_lock_real->rhs.get();
if(target_root_lock_real_rhs->type != JITD_NODE_Array){return false; }
ArrayNode *target_root_lock_real_rhs_real = (ArrayNode *)target_root_lock_real_rhs;


	return true;
}
bool JITD::matchDeleteElemFromArray(std::shared_ptr<JITDNode> * &targetHandleRef) 
{ 
	
	std::shared_ptr<JITDNode> target_root = std::atomic_load(targetHandleRef);
	JITDNode * target_root_lock = target_root.get();
	if(target_root_lock->type != JITD_NODE_DeleteElements){return false; }
DeleteElementsNode *target_root_lock_real = (DeleteElementsNode *)target_root_lock;
JITDNode *target_root_lock_real_node = target_root_lock_real->node.get();
if(target_root_lock_real_node->type != JITD_NODE_Array){return false; }
ArrayNode *target_root_lock_real_node_real = (ArrayNode *)target_root_lock_real_node;


	return true;
}
///////////////////// Policy Implementation ///////////////////// 


  long JITD::searchForPushDownDontDeleteElemBtree(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  

    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->PushDownDontDeleteElemBtree_View).empty())
    {
    
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->PushDownDontDeleteElemBtree_View).begin();
          
         

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_DeleteElements){return -1; }
DeleteElementsNode *iter_node_real = (DeleteElementsNode *)iter_node;
JITDNode *iter_node_real_node = iter_node_real->node.get();
if(iter_node_real_node->type != JITD_NODE_BTree){return -1; }
BTreeNode *iter_node_real_node_real = (BTreeNode *)iter_node_real_node;


          if(true){
            bestScore = 0;
          targetHandleRef = (*it);
          }

          
      
    }





    return bestScore;
  }

  long JITD::searchForPushDownAndCrack(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  

    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->PushDownAndCrack_View).empty())
    {
    
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->PushDownAndCrack_View).begin();
          
         

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_Concat){return -1; }
ConcatNode *iter_node_real = (ConcatNode *)iter_node;
JITDNode *iter_node_real_lhs = iter_node_real->lhs.get();
if(iter_node_real_lhs->type != JITD_NODE_BTree){return -1; }
BTreeNode *iter_node_real_lhs_real = (BTreeNode *)iter_node_real_lhs;
JITDNode *iter_node_real_rhs = iter_node_real->rhs.get();
if(iter_node_real_rhs->type != JITD_NODE_Array){return -1; }
ArrayNode *iter_node_real_rhs_real = (ArrayNode *)iter_node_real_rhs;


          if(true){
            bestScore = 0;
          targetHandleRef = (*it);
          }

          
      
    }





    return bestScore;
  }

  long JITD::searchForCrackArray(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  

    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->CrackArray_View).empty())
    {
    
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->CrackArray_View).begin();
          
         

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_Array){return -1; }
ArrayNode *iter_node_real = (ArrayNode *)iter_node;


          if((array_size((iter_node_real->data))) > (35)){
            bestScore = array_size((iter_node_real->data));
          targetHandleRef = (*it);
          }

          
      
    }





    return bestScore;
  }

  long JITD::searchForMergeUnSortedConcatArray(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  

    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->MergeUnSortedConcatArray_View).empty())
    {
    
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->MergeUnSortedConcatArray_View).begin();
          
         

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_Concat){return -1; }
ConcatNode *iter_node_real = (ConcatNode *)iter_node;
JITDNode *iter_node_real_lhs = iter_node_real->lhs.get();
if(iter_node_real_lhs->type != JITD_NODE_Array){return -1; }
ArrayNode *iter_node_real_lhs_real = (ArrayNode *)iter_node_real_lhs;
JITDNode *iter_node_real_rhs = iter_node_real->rhs.get();
if(iter_node_real_rhs->type != JITD_NODE_Array){return -1; }
ArrayNode *iter_node_real_rhs_real = (ArrayNode *)iter_node_real_rhs;


          if(true){
            bestScore = 0;
          targetHandleRef = (*it);
          }

          
      
    }





    return bestScore;
  }

  long JITD::searchForDeleteElemFromArray(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  

    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->DeleteElemFromArray_View).empty())
    {
    
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->DeleteElemFromArray_View).begin();
          
         

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_DeleteElements){return -1; }
DeleteElementsNode *iter_node_real = (DeleteElementsNode *)iter_node;
JITDNode *iter_node_real_node = iter_node_real->node.get();
if(iter_node_real_node->type != JITD_NODE_Array){return -1; }
ArrayNode *iter_node_real_node_real = (ArrayNode *)iter_node_real_node;


          if(true){
            bestScore = 0;
          targetHandleRef = (*it);
          }

          
      
    }





    return bestScore;
  }



int JITD::organize_wait()
{
  
    int t = 0;
   
    bool not_done = true;
    while(true)
    {

      if(this->work_queue.empty() && not_done == true)
      {
        
        not_done = this->do_organize();
        t++;
        //std::cout<<"JITD_PRINT ";
        //this->print_debug();
        //this->check_view();
      }
      else
      {
        mutatorCqElement pop_mce;
        
        this->work_queue.pop(pop_mce);
        if(pop_mce.flag == EXIT)
        {
          return t;
        }
        else if(pop_mce.flag == INSERT)
        {
            this->after_insert(pop_mce.element);
            not_done = true;
            //std::cout<<"INSERT_PRINT ";
            //this->print_debug();
            //this->check_view();
            
        } 
        else if(pop_mce.flag == REMOVE)
        {
            this->after_remove_elements(pop_mce.element);
            not_done = true;
            //std::cout<<"DELETE_PRINT ";
            //this->print_debug();
            //this->check_view();
            
        }
        else
        {
          std::cerr<<"Invalid Mutator Operation"<<std::endl;
          exit(-1);
        }
        
      }
      
    
    }   
    
   
       
  return t;
}
void JITD::initialize_struts(std::shared_ptr<JITDNode>* node,std::shared_ptr<JITDNode>* parent)
{
  std::shared_ptr<JITDNode> target_root_lock = std::atomic_load((node));
  this->childParentMap.emplace(node,parent);
  viewAdd(node);
  switch(target_root_lock->type)
  {
    
      case JITD_NODE_DeleteElements : {
      this->JITD_NODE_DeleteElements_set.emplace(node);

      
      DeleteElementsNode *node_real = (DeleteElementsNode *)target_root_lock.get();
        initialize_struts(&(node_real->node),node);
 
        break;      
      }

    
      case JITD_NODE_BTree : {
      
      
      BTreeNode *node_real = (BTreeNode *)target_root_lock.get();
        initialize_struts(&(node_real->lhs),node);
initialize_struts(&(node_real->rhs),node);
 
        break;      
      }

    
      case JITD_NODE_Concat : {
      this->JITD_NODE_Concat_set.emplace(node);

      
      ConcatNode *node_real = (ConcatNode *)target_root_lock.get();
        initialize_struts(&(node_real->lhs),node);
initialize_struts(&(node_real->rhs),node);
 
        break;      
      }

    
      case JITD_NODE_SortedArray : {
      
      
      SortedArrayNode *node_real = (SortedArrayNode *)target_root_lock.get();
         
        break;      
      }

    
      case JITD_NODE_Array : {
      
      this->CrackArray_PQ.emplace(node);

      ArrayNode *node_real = (ArrayNode *)target_root_lock.get();
         
        break;      
      }

    
      case JITD_NODE_Singleton : {
      
      
      SingletonNode *node_real = (SingletonNode *)target_root_lock.get();
         
        break;      
      }

    

  }
}
bool JITD::do_organize()
{
  
  



{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForPushDownDontDeleteElemBtree" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForPushDownDontDeleteElemBtree(
    targetHandleRef
  );
  //std::cout<<"After calling searchForPushDownDontDeleteElemBtree Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
    //std::cout<<"Candidate shared_ptr for PushDownDontDeleteElemBtree: "<<(*targetHandleRef)<<std::endl;
    PushDownDontDeleteElemBtree(targetHandleRef);
    
    return true;

  } else { 
     
  }







}


  



{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForPushDownAndCrack" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForPushDownAndCrack(
    targetHandleRef
  );
  //std::cout<<"After calling searchForPushDownAndCrack Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
    //std::cout<<"Candidate shared_ptr for PushDownAndCrack: "<<(*targetHandleRef)<<std::endl;
    PushDownAndCrack(targetHandleRef);
    
    return true;

  } else { 
     
  }







}


    



{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForCrackArray" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForCrackArray(
    targetHandleRef
  );
  //std::cout<<"After calling searchForCrackArray Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
    //std::cout<<"Candidate shared_ptr for CrackArray: "<<(*targetHandleRef)<<std::endl;
    CrackArray(targetHandleRef);
    
    return true;

  } else { 
     
  }







}


    



{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForMergeUnSortedConcatArray" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForMergeUnSortedConcatArray(
    targetHandleRef
  );
  //std::cout<<"After calling searchForMergeUnSortedConcatArray Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
    //std::cout<<"Candidate shared_ptr for MergeUnSortedConcatArray: "<<(*targetHandleRef)<<std::endl;
    MergeUnSortedConcatArray(targetHandleRef);
    
    return true;

  } else { 
     
  }







}


    



{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForDeleteElemFromArray" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForDeleteElemFromArray(
    targetHandleRef
  );
  //std::cout<<"After calling searchForDeleteElemFromArray Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
    //std::cout<<"Candidate shared_ptr for DeleteElemFromArray: "<<(*targetHandleRef)<<std::endl;
    DeleteElemFromArray(targetHandleRef);
    
    return true;

  } else { 
     
  }







}


  return false;


}
///////////////////// Set/PQ populate ///////////////////// 

void JITD::SetPqErase(std::shared_ptr<JITDNode> * node_handle)
{
  #ifdef DEBUG
    assert(node_handle!=NULL);
  #endif
  std::shared_ptr<JITDNode> node_ptr = std::atomic_load((node_handle));
   #ifdef DEBUG
    assert(node_ptr!=NULL);
  #endif
  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteElements : {
          this->JITD_NODE_DeleteElements_set.erase(node_handle);

          
          };break;
        
      case JITD_NODE_BTree : {
          
          
          };break;
        
      case JITD_NODE_Concat : {
          this->JITD_NODE_Concat_set.erase(node_handle);

          
          };break;
        
      case JITD_NODE_SortedArray : {
          
          
          };break;
        
      case JITD_NODE_Array : {
          
          this->CrackArray_PQ.erase(node_handle);

          };break;
        
      case JITD_NODE_Singleton : {
          
          
          };break;
        
        default:{std::cerr << "Unhandled Node Type in get" << std::endl;
        exit(-1);};break;
      }
      #ifdef DEBUG
        //check_pq();
      #endif 
}
void JITD::SetPqAdd(std::shared_ptr<JITDNode> * node_handle)
{
 #ifdef DEBUG
    assert(node_handle!=NULL);
  #endif
  std::shared_ptr<JITDNode> node_ptr = std::atomic_load((node_handle));
   #ifdef DEBUG
    assert(node_ptr!=NULL);
  #endif
  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteElements : {
          this->JITD_NODE_DeleteElements_set.emplace(node_handle);

          
          };break;
        
      case JITD_NODE_BTree : {
          
          
          };break;
        
      case JITD_NODE_Concat : {
          this->JITD_NODE_Concat_set.emplace(node_handle);

          
          };break;
        
      case JITD_NODE_SortedArray : {
          
          
          };break;
        
      case JITD_NODE_Array : {
          
          this->CrackArray_PQ.emplace(node_handle);

          };break;
        
      case JITD_NODE_Singleton : {
          
          
          };break;
        
      default:{std::cerr << "Unhandled Node Type in get" << std::endl;
      exit(-1);};break;
      }
      #ifdef DEBUG
        //check_pq();
      #endif  
}
void JITD::viewAdd(std::shared_ptr<JITDNode>* node_handle)
{
  if(node_handle == NULL){return;}
  bool matched = false;
  std::shared_ptr<JITDNode> node_ptr = std::atomic_load((node_handle));
  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteElements : {
        matched = this->matchPushDownDontDeleteElemBtree(node_handle);
if(matched == true){
this->PushDownDontDeleteElemBtree_View.emplace(node_handle);
}
matched = this->matchDeleteElemFromArray(node_handle);
if(matched == true){
this->DeleteElemFromArray_View.emplace(node_handle);
}

        break;
      }

    
      case JITD_NODE_BTree : {
        
        break;
      }

    
      case JITD_NODE_Concat : {
        matched = this->matchPushDownAndCrack(node_handle);
if(matched == true){
this->PushDownAndCrack_View.emplace(node_handle);
}
matched = this->matchMergeUnSortedConcatArray(node_handle);
if(matched == true){
this->MergeUnSortedConcatArray_View.emplace(node_handle);
}

        break;
      }

    
      case JITD_NODE_SortedArray : {
        
        break;
      }

    
      case JITD_NODE_Array : {
        matched = this->matchCrackArray(node_handle);
if(matched == true){
this->CrackArray_View.emplace(node_handle);
}

        break;
      }

    
      case JITD_NODE_Singleton : {
        
        break;
      }

    

  }

}
void JITD::viewErase(std::shared_ptr<JITDNode>* node_handle)
{
  if(node_handle == NULL){return;}
  bool matched = false;
  std::shared_ptr<JITDNode> node_ptr = std::atomic_load((node_handle));
  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteElements : {
        this->PushDownDontDeleteElemBtree_View.erase(node_handle);
this->DeleteElemFromArray_View.erase(node_handle);

        break;
      
      }

    
      case JITD_NODE_BTree : {
        
        break;
      
      }

    
      case JITD_NODE_Concat : {
        this->PushDownAndCrack_View.erase(node_handle);
this->MergeUnSortedConcatArray_View.erase(node_handle);

        break;
      
      }

    
      case JITD_NODE_SortedArray : {
        
        break;
      
      }

    
      case JITD_NODE_Array : {
        this->CrackArray_View.erase(node_handle);

        break;
      
      }

    
      case JITD_NODE_Singleton : {
        
        break;
      
      }

    

  }
  
}
std::shared_ptr<JITDNode> * JITD::getParent(std::shared_ptr<JITDNode> * &target)
{
  std::unordered_multimap <std::shared_ptr<JITDNode> *, std::shared_ptr<JITDNode> *> :: iterator iter; 
  iter = this->childParentMap.find(target);
  if(iter!=childParentMap.end())
  {
    //parent = (iter->second);
    return iter->second;
  }
  else
  {
    //parent = NULL;
    return NULL;
  }
  
}
void JITD::fixMap(std::shared_ptr<JITDNode>* node_handle,std::shared_ptr<JITDNode>* parent)
{
  std::shared_ptr<JITDNode> node_ptr = std::atomic_load((node_handle));
  switch((node_ptr)->type){
  
    case JITD_NODE_DeleteElements : {
      DeleteElementsNode *node_real = (DeleteElementsNode *)node_ptr.get();
      std::unordered_multimap <std::shared_ptr<JITDNode> *, std::shared_ptr<JITDNode> *> :: iterator iter;

      iter = this->childParentMap.find(&(node_real->node));
if(iter!=this->childParentMap.end()){
iter->second = parent;
}

      break;
    }

  
    case JITD_NODE_BTree : {
      BTreeNode *node_real = (BTreeNode *)node_ptr.get();
      std::unordered_multimap <std::shared_ptr<JITDNode> *, std::shared_ptr<JITDNode> *> :: iterator iter;

      iter = this->childParentMap.find(&(node_real->lhs));
if(iter!=this->childParentMap.end()){
iter->second = parent;
}
iter = this->childParentMap.find(&(node_real->rhs));
if(iter!=this->childParentMap.end()){
iter->second = parent;
}

      break;
    }

  
    case JITD_NODE_Concat : {
      ConcatNode *node_real = (ConcatNode *)node_ptr.get();
      std::unordered_multimap <std::shared_ptr<JITDNode> *, std::shared_ptr<JITDNode> *> :: iterator iter;

      iter = this->childParentMap.find(&(node_real->lhs));
if(iter!=this->childParentMap.end()){
iter->second = parent;
}
iter = this->childParentMap.find(&(node_real->rhs));
if(iter!=this->childParentMap.end()){
iter->second = parent;
}

      break;
    }

  
    case JITD_NODE_SortedArray : {
      SortedArrayNode *node_real = (SortedArrayNode *)node_ptr.get();
      std::unordered_multimap <std::shared_ptr<JITDNode> *, std::shared_ptr<JITDNode> *> :: iterator iter;

      
      break;
    }

  
    case JITD_NODE_Array : {
      ArrayNode *node_real = (ArrayNode *)node_ptr.get();
      std::unordered_multimap <std::shared_ptr<JITDNode> *, std::shared_ptr<JITDNode> *> :: iterator iter;

      
      break;
    }

  
    case JITD_NODE_Singleton : {
      SingletonNode *node_real = (SingletonNode *)node_ptr.get();
      std::unordered_multimap <std::shared_ptr<JITDNode> *, std::shared_ptr<JITDNode> *> :: iterator iter;

      
      break;
    }

  

  }
}

///////////////////// Debugging Utilities ///////////////////// 

std::shared_ptr<JITD> assemble_jitd(std::istream &in)
{
  std::string op, line;

  std::stack<std::shared_ptr<JITDNode>> node_stack;
  std::shared_ptr<JITDNode> jitd_root_handle;
  while(getline(in, line)){
    std::basic_istringstream<char> toks(line);
    int columns = 0;
    toks >> op;
    
      if(op == "DeleteElements"){
        

          // Construct a data
          std::vector<Record> data;
          load_records(data, toks);
        

          // Construct a node
          std::shared_ptr<JITDNode> node;
          node = node_stack.top(); node_stack.pop();
        

        // Assemble everything into a DeleteElements
        node_stack.emplace(new DeleteElementsNode(node, data));
      

      } else 
    
      if(op == "BTree"){
        

          // Construct a rhs
          std::shared_ptr<JITDNode> rhs;
          rhs = node_stack.top(); node_stack.pop();
        

          // Construct a sep
          long sep;
          sep = load_key(toks);
        

          // Construct a lhs
          std::shared_ptr<JITDNode> lhs;
          lhs = node_stack.top(); node_stack.pop();
        

        // Assemble everything into a BTree
        node_stack.emplace(new BTreeNode(lhs, sep, rhs));
      

      } else 
    
      if(op == "Concat"){
        

          // Construct a rhs
          std::shared_ptr<JITDNode> rhs;
          rhs = node_stack.top(); node_stack.pop();
        

          // Construct a lhs
          std::shared_ptr<JITDNode> lhs;
          lhs = node_stack.top(); node_stack.pop();
        

        // Assemble everything into a Concat
        node_stack.emplace(new ConcatNode(lhs, rhs));
      

      } else 
    
      if(op == "SortedArray"){
        

          // Construct a data
          std::vector<Record> data;
          load_records(data, toks);
        

        // Assemble everything into a SortedArray
        node_stack.emplace(new SortedArrayNode(data));
      

      } else 
    
      if(op == "Array"){
        

          // Construct a data
          std::vector<Record> data;
          load_records(data, toks);
        

        // Assemble everything into a Array
        node_stack.emplace(new ArrayNode(data));
      

      } else 
    
      if(op == "Singleton"){
        

          // Construct a elem
          Record elem;
          
        

        // Assemble everything into a Singleton
        node_stack.emplace(new SingletonNode(elem));
      

      } else 
    
    
    if(op == "Return")
    {
      return std::shared_ptr<JITD>(new JITD(std::shared_ptr<std::shared_ptr<JITDNode>>(std::make_shared<std::shared_ptr<JITDNode>>(std::shared_ptr<JITDNode>(node_stack.top())))));
    }
    else {
      std::cerr << "Invalid assembly instruction '"<<op<<"'" << std::endl; 
      exit(-1); 
      return std::shared_ptr<JITD>();
    }
  }
  std::cerr << "Reached end of build with no Return" << std::endl; 
  exit(-1); 
}


void JITD:: check_view()
{
 //std::set<std::shared_ptr<JITDNode>* >::iterator it;
  //
  //if(!(this->DeleteElemFromArray_View).empty())
  //{
  //  for(it = (this->DeleteElemFromArray_View).begin();it!=(this->DeleteElemFromArray_View).end();++it)
  //  {
  //        std::shared_ptr<JITDNode> * curr = *it;
  //        std::cout<<"Address of curr: "<<curr<<"Address of node in DeleteElemFromArray_View(*curr): "<<*curr<<std::endl;
  //  }
  //}

 //
  //if(!(this->PushDownDontDeleteElemBtree_View).empty())
  //{
  //  for(it = (this->PushDownDontDeleteElemBtree_View).begin();it!=(this->PushDownDontDeleteElemBtree_View).end();++it)
  //  {
  //        std::shared_ptr<JITDNode> * curr = *it;
  //        std::cout<<"Address of curr: "<<curr<<"Address of node in PushDownDontDeleteElemBtree_View(*curr): "<<*curr<<std::endl;
  //  }
  //}

 //
  //if(!(this->PushDownAndCrack_View).empty())
  //{
  //  for(it = (this->PushDownAndCrack_View).begin();it!=(this->PushDownAndCrack_View).end();++it)
  //  {
  //        std::shared_ptr<JITDNode> * curr = *it;
  //        std::cout<<"Address of curr: "<<curr<<"Address of node in PushDownAndCrack_View(*curr): "<<*curr<<std::endl;
  //  }
  //}

 //
  //if(!(this->MergeUnSortedConcatArray_View).empty())
  //{
  //  for(it = (this->MergeUnSortedConcatArray_View).begin();it!=(this->MergeUnSortedConcatArray_View).end();++it)
  //  {
  //        std::shared_ptr<JITDNode> * curr = *it;
  //        std::cout<<"Address of curr: "<<curr<<"Address of node in MergeUnSortedConcatArray_View(*curr): "<<*curr<<std::endl;
  //  }
  //}

 //
  //if(!(this->CrackArray_View).empty())
  //{
  //  for(it = (this->CrackArray_View).begin();it!=(this->CrackArray_View).end();++it)
  //  {
  //        std::shared_ptr<JITDNode> * curr = *it;
  //        std::cout<<"Address of curr: "<<curr<<"Address of node in CrackArray_View(*curr): "<<*curr<<std::endl;
  //  }
  //}

 //

}
void JITD::print_pq()
{

  
}

void JITD::print_map()
{
  std::unordered_multimap <std::shared_ptr<JITDNode> *, std::shared_ptr<JITDNode> *> :: iterator itr; 
  for (itr = childParentMap.begin(); itr != childParentMap.end(); ++itr) 
    { 
        if(itr->first != NULL)
        {
          std::shared_ptr<JITDNode> node = *(itr->first);
          if(node!=NULL)
          {
            switch(node->type)
            {
              
                case JITD_NODE_DeleteElements : {
                  DeleteElementsNode *node_real = (DeleteElementsNode *)node.get();
                  std::cout <<itr->first<< ":DeleteElements(addr:"<<node_real<<")-> ";
                  break;
                }
              
                case JITD_NODE_BTree : {
                  BTreeNode *node_real = (BTreeNode *)node.get();
                  std::cout <<itr->first<< ":BTree(addr:"<<node_real<<")-> ";
                  break;
                }
              
                case JITD_NODE_Concat : {
                  ConcatNode *node_real = (ConcatNode *)node.get();
                  std::cout <<itr->first<< ":Concat(addr:"<<node_real<<")-> ";
                  break;
                }
              
                case JITD_NODE_SortedArray : {
                  SortedArrayNode *node_real = (SortedArrayNode *)node.get();
                  std::cout <<itr->first<< ":SortedArray(addr:"<<node_real<<")-> ";
                  break;
                }
              
                case JITD_NODE_Array : {
                  ArrayNode *node_real = (ArrayNode *)node.get();
                  std::cout <<itr->first<< ":Array(addr:"<<node_real<<")-> ";
                  break;
                }
              
                case JITD_NODE_Singleton : {
                  SingletonNode *node_real = (SingletonNode *)node.get();
                  std::cout <<itr->first<< ":Singleton(addr:"<<node_real<<")-> ";
                  break;
                }
              
            }
          }
          else
          {
            std::cout<<  '\t' << "node is NULL" << '\n';
          }
        
        }
        else
        {
            std::cout<<  '\t' << "iter->first is NULL" << '\n';
        }
        if(itr->second != NULL)
        {
          std::shared_ptr<JITDNode> parent = *(itr->second);
          if(parent!=NULL)
          {
            switch(parent->type)
            {
              
                case JITD_NODE_DeleteElements : {
                  DeleteElementsNode *parent_real = (DeleteElementsNode *)parent.get();
                  std::cout <<itr->second<<'\t'<< ":DeleteElements(addr:"<<parent_real<<") "<<'\n';
                  break;
                }
              
                case JITD_NODE_BTree : {
                  BTreeNode *parent_real = (BTreeNode *)parent.get();
                  std::cout <<itr->second<<'\t'<< ":BTree(addr:"<<parent_real<<") "<<'\n';
                  break;
                }
              
                case JITD_NODE_Concat : {
                  ConcatNode *parent_real = (ConcatNode *)parent.get();
                  std::cout <<itr->second<<'\t'<< ":Concat(addr:"<<parent_real<<") "<<'\n';
                  break;
                }
              
                case JITD_NODE_SortedArray : {
                  SortedArrayNode *parent_real = (SortedArrayNode *)parent.get();
                  std::cout <<itr->second<<'\t'<< ":SortedArray(addr:"<<parent_real<<") "<<'\n';
                  break;
                }
              
                case JITD_NODE_Array : {
                  ArrayNode *parent_real = (ArrayNode *)parent.get();
                  std::cout <<itr->second<<'\t'<< ":Array(addr:"<<parent_real<<") "<<'\n';
                  break;
                }
              
                case JITD_NODE_Singleton : {
                  SingletonNode *parent_real = (SingletonNode *)parent.get();
                  std::cout <<itr->second<<'\t'<< ":Singleton(addr:"<<parent_real<<") "<<'\n';
                  break;
                }
              
            }
          }
          else
          {
            std::cout<<  '\t' << "parent is NULL" << '\n';
          }
          
        }
        else
        {
          std::cout<<  '\t' << "iter->second is NULL" << '\n'; 
        }
    } 
    std::cout << std::endl; 
}

void print_JITD_node_structure(std::shared_ptr<JITDNode> node, const std::string &prefix){ 

  switch(node->type){
    
      case JITD_NODE_DeleteElements : {
        DeleteElementsNode *node_real = (DeleteElementsNode *)node.get();
        std::cout << prefix << "DeleteElements(addr:"<<node_real<<")[ "
        << "data=" << node_real->data.size() << " elements";

        std::cout << std::endl;
print_JITD_node_structure(node_real->node, prefix+std::string("  "));
std::cout << prefix; 
        std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_BTree : {
        BTreeNode *node_real = (BTreeNode *)node.get();
        std::cout << prefix << "BTree(addr:"<<node_real<<")[ "
        << "sep=" << node_real->sep;

        std::cout << std::endl;
print_JITD_node_structure(node_real->lhs, prefix+std::string("  "));
print_JITD_node_structure(node_real->rhs, prefix+std::string("  "));
std::cout << prefix; 
        std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_Concat : {
        ConcatNode *node_real = (ConcatNode *)node.get();
        std::cout << prefix << "Concat(addr:"<<node_real<<")[ "
        ;

        std::cout << std::endl;
print_JITD_node_structure(node_real->lhs, prefix+std::string("  "));
print_JITD_node_structure(node_real->rhs, prefix+std::string("  "));
std::cout << prefix; 
        std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_SortedArray : {
        SortedArrayNode *node_real = (SortedArrayNode *)node.get();
        std::cout << prefix << "SortedArray(addr:"<<node_real<<")[ "
        << "data=" << node_real->data.size() << " elements";

         
        std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_Array : {
        ArrayNode *node_real = (ArrayNode *)node.get();
        std::cout << prefix << "Array(addr:"<<node_real<<")[ "
        << "data=" << node_real->data.size() << " elements";

         
        std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_Singleton : {
        SingletonNode *node_real = (SingletonNode *)node.get();
        std::cout << prefix << "Singleton(addr:"<<node_real<<")[ "
        << "elem=" << node_real->elem;

         
        std::cout << " ]" << std::endl;
        break;
      }
    
  }
}
void jitd_get_depth(std::shared_ptr<JITDNode> node, int depth, int &maxdepth)
{
  if(node != NULL)
  {
  switch(node->type){
  
    case JITD_NODE_DeleteElements : {
        DeleteElementsNode *node_real = (DeleteElementsNode *)node.get();
        jitd_get_depth(node_real->node,++depth,maxdepth);
if(depth > maxdepth){
maxdepth = depth;
}

        break; 
      }
    
    case JITD_NODE_BTree : {
        BTreeNode *node_real = (BTreeNode *)node.get();
        jitd_get_depth(node_real->lhs,++depth,maxdepth);
if(depth > maxdepth){
maxdepth = depth;
}
jitd_get_depth(node_real->rhs,depth,maxdepth);

        break; 
      }
    
    case JITD_NODE_Concat : {
        ConcatNode *node_real = (ConcatNode *)node.get();
        jitd_get_depth(node_real->lhs,++depth,maxdepth);
if(depth > maxdepth){
maxdepth = depth;
}
jitd_get_depth(node_real->rhs,depth,maxdepth);

        break; 
      }
    
    case JITD_NODE_SortedArray : {
        SortedArrayNode *node_real = (SortedArrayNode *)node.get();
        
        break; 
      }
    
    case JITD_NODE_Array : {
        ArrayNode *node_real = (ArrayNode *)node.get();
        
        break; 
      }
    
    case JITD_NODE_Singleton : {
        SingletonNode *node_real = (SingletonNode *)node.get();
        
        break; 
      }
    

  }
 } 
}
void print_JITD_node_structure_viz(std::shared_ptr<JITDNode> node,std::shared_ptr<JITDNode> parent){ 

  switch(node->type){
    
      case JITD_NODE_DeleteElements : {
        DeleteElementsNode *node_real = (DeleteElementsNode *)node.get();
        switch(parent->type){
          
          case JITD_NODE_DeleteElements : {
              std::cout << "DeleteElements(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_BTree : {
              std::cout << "BTree(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Concat : {
              std::cout << "Concat(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_SortedArray : {
              std::cout << "SortedArray(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Array : {
              std::cout << "Array(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Singleton : {
              std::cout << "Singleton(addr:"<<node_real<<")[] -> ";

          break;}

          
        }

        std::cout << "DeleteElements(addr:"<<node_real<<")[] "<<std::endl;
        

        std::cout << std::endl;
print_JITD_node_structure_viz(node_real->node,node);
 
        //std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_BTree : {
        BTreeNode *node_real = (BTreeNode *)node.get();
        switch(parent->type){
          
          case JITD_NODE_DeleteElements : {
              std::cout << "DeleteElements(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_BTree : {
              std::cout << "BTree(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Concat : {
              std::cout << "Concat(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_SortedArray : {
              std::cout << "SortedArray(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Array : {
              std::cout << "Array(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Singleton : {
              std::cout << "Singleton(addr:"<<node_real<<")[] -> ";

          break;}

          
        }

        std::cout << "BTree(addr:"<<node_real<<")[] "<<std::endl;
        

        std::cout << std::endl;
print_JITD_node_structure_viz(node_real->lhs,node);
print_JITD_node_structure_viz(node_real->rhs,node);
 
        //std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_Concat : {
        ConcatNode *node_real = (ConcatNode *)node.get();
        switch(parent->type){
          
          case JITD_NODE_DeleteElements : {
              std::cout << "DeleteElements(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_BTree : {
              std::cout << "BTree(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Concat : {
              std::cout << "Concat(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_SortedArray : {
              std::cout << "SortedArray(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Array : {
              std::cout << "Array(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Singleton : {
              std::cout << "Singleton(addr:"<<node_real<<")[] -> ";

          break;}

          
        }

        std::cout << "Concat(addr:"<<node_real<<")[] "<<std::endl;
        

        std::cout << std::endl;
print_JITD_node_structure_viz(node_real->lhs,node);
print_JITD_node_structure_viz(node_real->rhs,node);
 
        //std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_SortedArray : {
        SortedArrayNode *node_real = (SortedArrayNode *)node.get();
        switch(parent->type){
          
          case JITD_NODE_DeleteElements : {
              std::cout << "DeleteElements(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_BTree : {
              std::cout << "BTree(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Concat : {
              std::cout << "Concat(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_SortedArray : {
              std::cout << "SortedArray(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Array : {
              std::cout << "Array(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Singleton : {
              std::cout << "Singleton(addr:"<<node_real<<")[] -> ";

          break;}

          
        }

        std::cout << "SortedArray(addr:"<<node_real<<")[] "<<std::endl;
        

         
        //std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_Array : {
        ArrayNode *node_real = (ArrayNode *)node.get();
        switch(parent->type){
          
          case JITD_NODE_DeleteElements : {
              std::cout << "DeleteElements(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_BTree : {
              std::cout << "BTree(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Concat : {
              std::cout << "Concat(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_SortedArray : {
              std::cout << "SortedArray(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Array : {
              std::cout << "Array(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Singleton : {
              std::cout << "Singleton(addr:"<<node_real<<")[] -> ";

          break;}

          
        }

        std::cout << "Array(addr:"<<node_real<<")[] "<<std::endl;
        

         
        //std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_Singleton : {
        SingletonNode *node_real = (SingletonNode *)node.get();
        switch(parent->type){
          
          case JITD_NODE_DeleteElements : {
              std::cout << "DeleteElements(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_BTree : {
              std::cout << "BTree(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Concat : {
              std::cout << "Concat(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_SortedArray : {
              std::cout << "SortedArray(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Array : {
              std::cout << "Array(addr:"<<node_real<<")[] -> ";

          break;}

          
          case JITD_NODE_Singleton : {
              std::cout << "Singleton(addr:"<<node_real<<")[] -> ";

          break;}

          
        }

        std::cout << "Singleton(addr:"<<node_real<<")[] "<<std::endl;
        

         
        //std::cout << " ]" << std::endl;
        break;
      }
    
  }
}
