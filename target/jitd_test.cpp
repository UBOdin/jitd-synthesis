
#include <stack>
#include <sstream>
#include "runtime.hpp"
#include "jitd_test.hpp"
#include <thread>
#ifdef RDTSC
uint64_t rdtsc(){
    unsigned int lo,hi;
    __asm__ __volatile__ ("rdtsc" : "=a" (lo), "=d" (hi));
    return ((uint64_t)hi << 32) | lo;
}
long unsigned int sticks, diffticks;
#endif

//#define JITD_DEBUG_POLICY true;
//std::shared_ptr<JITDNode> * rootHandleRef;


///////////////////// Transform Definitions ///////////////////// 


bool JITD::DeleteElemFromSingleton(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::DeleteElemFromSingleton"<<std::endl;*/
  {
START_TIMER;
    std::shared_ptr<JITDNode>* parent = getParent(target);
END_TIMER;
    std::shared_ptr<JITDNode> target_root_lock;
    // Extract target into DeleteElements
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((target_root_lock)->type){ 
      case JITD_NODE_DeleteElements:{
        DeleteElementsNode *target_root = (DeleteElementsNode *)(target_root_lock).get();
        std::shared_ptr<JITDNode> target_root_node_lock;
        // Extract &(target_root->node) into Singleton
        #ifdef ATOMIC_LOAD
        target_root_node_lock = std::atomic_load((&(target_root->node)));
        #endif
        #ifdef ATOMIC_LOAD_CONSUME
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_consume);
        #endif
        #ifdef ATOMIC_LOAD_ACQUIRE
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_acquire);
        #endif
        switch((target_root_node_lock)->type){ 
          case JITD_NODE_Singleton:{
            SingletonNode *target_root_node = (SingletonNode *)(target_root_node_lock).get();
            {
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
END_TIMER;
              /*** BEGIN ASSEMBLING to_ptr ***/
              /*** Assemble to_ptr as a Singleton ***/
              SingletonNode * to_ptr = new SingletonNode(target_root_node->elem);
              std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
              /*** Handle post-processing for to_ptr ***/
              delete_keys_from_singleton(to_ptr->elem, target_root->data);
              /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
              #ifdef ATOMIC_STORE
              std::atomic_store(target, to_ptr_ref);
              #endif
              #ifdef ATOMIC_STORE_RELEASE
              std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
              #endif
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              /*** ParentMaintenance ***/
              setParent(target,parent);
END_TIMER;
              return true;
            }
          }; break;
          default: { //target_root_node is not a Singleton
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

bool JITD::DeleteKeyFromSingleton(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::DeleteKeyFromSingleton"<<std::endl;*/
  {
START_TIMER;
    std::shared_ptr<JITDNode>* parent = getParent(target);
END_TIMER;
    std::shared_ptr<JITDNode> target_root_lock;
    // Extract target into DeleteSingleton
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((target_root_lock)->type){ 
      case JITD_NODE_DeleteSingleton:{
        DeleteSingletonNode *target_root = (DeleteSingletonNode *)(target_root_lock).get();
        std::shared_ptr<JITDNode> target_root_node_lock;
        // Extract &(target_root->node) into Singleton
        #ifdef ATOMIC_LOAD
        target_root_node_lock = std::atomic_load((&(target_root->node)));
        #endif
        #ifdef ATOMIC_LOAD_CONSUME
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_consume);
        #endif
        #ifdef ATOMIC_LOAD_ACQUIRE
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_acquire);
        #endif
        switch((target_root_node_lock)->type){ 
          case JITD_NODE_Singleton:{
            SingletonNode *target_root_node = (SingletonNode *)(target_root_node_lock).get();
            {
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
END_TIMER;
              /*** BEGIN ASSEMBLING to_ptr ***/
              /*** Assemble to_ptr as a Singleton ***/
              SingletonNode * to_ptr = new SingletonNode(target_root_node->elem);
              std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
              /*** Handle post-processing for to_ptr ***/
              delete_singleton_key(to_ptr->elem, target_root->elem);
              /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
              #ifdef ATOMIC_STORE
              std::atomic_store(target, to_ptr_ref);
              #endif
              #ifdef ATOMIC_STORE_RELEASE
              std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
              #endif
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              /*** ParentMaintenance ***/
              setParent(target,parent);
END_TIMER;
              return true;
            }
          }; break;
          default: { //target_root_node is not a Singleton
            return false;
          }; break;
        }
      }; break;
      default: { //target_root is not a DeleteSingleton
        return false;
      }; break;
    }
  }

}

bool JITD::DeleteSingletonFromArray(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::DeleteSingletonFromArray"<<std::endl;*/
  {
START_TIMER;
    std::shared_ptr<JITDNode>* parent = getParent(target);
END_TIMER;
    std::shared_ptr<JITDNode> target_root_lock;
    // Extract target into DeleteSingleton
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((target_root_lock)->type){ 
      case JITD_NODE_DeleteSingleton:{
        DeleteSingletonNode *target_root = (DeleteSingletonNode *)(target_root_lock).get();
        std::shared_ptr<JITDNode> target_root_node_lock;
        // Extract &(target_root->node) into Array
        #ifdef ATOMIC_LOAD
        target_root_node_lock = std::atomic_load((&(target_root->node)));
        #endif
        #ifdef ATOMIC_LOAD_CONSUME
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_consume);
        #endif
        #ifdef ATOMIC_LOAD_ACQUIRE
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_acquire);
        #endif
        switch((target_root_node_lock)->type){ 
          case JITD_NODE_Array:{
            ArrayNode *target_root_node = (ArrayNode *)(target_root_node_lock).get();
            {
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
END_TIMER;
              /*** BEGIN ASSEMBLING to_ptr ***/
              /*** Assemble to_ptr as a Array ***/
              ArrayNode * to_ptr = new ArrayNode(target_root_node->data);
              std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
              /*** Handle post-processing for to_ptr ***/
              delete_singleton_from_leaf(to_ptr->data, target_root->elem);
              /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
              #ifdef ATOMIC_STORE
              std::atomic_store(target, to_ptr_ref);
              #endif
              #ifdef ATOMIC_STORE_RELEASE
              std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
              #endif
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              /*** ParentMaintenance ***/
              setParent(target,parent);
END_TIMER;
              return true;
            }
          }; break;
          default: { //target_root_node is not a Array
            return false;
          }; break;
        }
      }; break;
      default: { //target_root is not a DeleteSingleton
        return false;
      }; break;
    }
  }

}

bool JITD::DeleteElemFromArray(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::DeleteElemFromArray"<<std::endl;*/
  {
START_TIMER;
    std::shared_ptr<JITDNode>* parent = getParent(target);
END_TIMER;
    std::shared_ptr<JITDNode> target_root_lock;
    // Extract target into DeleteElements
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((target_root_lock)->type){ 
      case JITD_NODE_DeleteElements:{
        DeleteElementsNode *target_root = (DeleteElementsNode *)(target_root_lock).get();
        std::shared_ptr<JITDNode> target_root_node_lock;
        // Extract &(target_root->node) into Array
        #ifdef ATOMIC_LOAD
        target_root_node_lock = std::atomic_load((&(target_root->node)));
        #endif
        #ifdef ATOMIC_LOAD_CONSUME
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_consume);
        #endif
        #ifdef ATOMIC_LOAD_ACQUIRE
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_acquire);
        #endif
        switch((target_root_node_lock)->type){ 
          case JITD_NODE_Array:{
            ArrayNode *target_root_node = (ArrayNode *)(target_root_node_lock).get();
            {
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
END_TIMER;
              /*** BEGIN ASSEMBLING to_ptr ***/
              /*** Assemble to_ptr as a Array ***/
              ArrayNode * to_ptr = new ArrayNode(target_root_node->data);
              std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
              /*** Handle post-processing for to_ptr ***/
              delete_from_leaf(to_ptr->data, target_root->data);
              /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
              #ifdef ATOMIC_STORE
              std::atomic_store(target, to_ptr_ref);
              #endif
              #ifdef ATOMIC_STORE_RELEASE
              std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
              #endif
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              /*** ParentMaintenance ***/
              setParent(target,parent);
END_TIMER;
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

bool JITD::PushDownDontDeleteSingletonBtreeRight(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownDontDeleteSingletonBtreeRight"<<std::endl;*/
  {
START_TIMER;
    std::shared_ptr<JITDNode>* parent = getParent(target);
END_TIMER;
    std::shared_ptr<JITDNode> target_root_lock;
    // Extract target into DeleteSingleton
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((target_root_lock)->type){ 
      case JITD_NODE_DeleteSingleton:{
        DeleteSingletonNode *target_root = (DeleteSingletonNode *)(target_root_lock).get();
        std::shared_ptr<JITDNode> target_root_node_lock;
        // Extract &(target_root->node) into BTree
        #ifdef ATOMIC_LOAD
        target_root_node_lock = std::atomic_load((&(target_root->node)));
        #endif
        #ifdef ATOMIC_LOAD_CONSUME
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_consume);
        #endif
        #ifdef ATOMIC_LOAD_ACQUIRE
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_acquire);
        #endif
        switch((target_root_node_lock)->type){ 
          case JITD_NODE_BTree:{
            BTreeNode *target_root_node = (BTreeNode *)(target_root_node_lock).get();
            {
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
              viewErase(&(target_root_node->lhs));
              viewErase(&(target_root_node->rhs));
END_TIMER;
              /*** BEGIN ASSEMBLING to_ptr ***/
              /*** Assemble to_ptr_rhs as a DeleteSingleton ***/
              DeleteSingletonNode * to_ptr_rhs = new DeleteSingletonNode(target_root_node->rhs, target_root->elem);
              std::shared_ptr<JITDNode> to_ptr_rhs_ref = std::shared_ptr<JITDNode>(to_ptr_rhs);
              /*** Assemble to_ptr as a BTree ***/
              BTreeNode * to_ptr = new BTreeNode(target_root_node->lhs, target_root_node->sep, to_ptr_rhs_ref);
              std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
              /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
              #ifdef ATOMIC_STORE
              std::atomic_store(target, to_ptr_ref);
              #endif
              #ifdef ATOMIC_STORE_RELEASE
              std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
              #endif
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              viewAdd(&(to_ptr->lhs));
              viewAdd(&(to_ptr->rhs));
              viewAdd(&(to_ptr_rhs->node));
              /*** ParentMaintenance ***/
              setParent(target,parent);
              {
                setParent(&(to_ptr->lhs),target);
                fixNodeDecendents(&(to_ptr->lhs),&(to_ptr->lhs));
              }
              {
                setParent(&(to_ptr->rhs),target);
                fixNodeDecendents(&(to_ptr->rhs),&(to_ptr->rhs));
              }
              {
                setParent(&(to_ptr_rhs->node),&(to_ptr->rhs));
                fixNodeDecendents(&(to_ptr_rhs->node),&(to_ptr_rhs->node));
              }
END_TIMER;
              return true;
            }
          }; break;
          default: { //target_root_node is not a BTree
            return false;
          }; break;
        }
      }; break;
      default: { //target_root is not a DeleteSingleton
        return false;
      }; break;
    }
  }

}

bool JITD::PushDownDontDeleteSingletonBtreeLeft(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownDontDeleteSingletonBtreeLeft"<<std::endl;*/
  {
START_TIMER;
    std::shared_ptr<JITDNode>* parent = getParent(target);
END_TIMER;
    std::shared_ptr<JITDNode> target_root_lock;
    // Extract target into DeleteSingleton
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((target_root_lock)->type){ 
      case JITD_NODE_DeleteSingleton:{
        DeleteSingletonNode *target_root = (DeleteSingletonNode *)(target_root_lock).get();
        std::shared_ptr<JITDNode> target_root_node_lock;
        // Extract &(target_root->node) into BTree
        #ifdef ATOMIC_LOAD
        target_root_node_lock = std::atomic_load((&(target_root->node)));
        #endif
        #ifdef ATOMIC_LOAD_CONSUME
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_consume);
        #endif
        #ifdef ATOMIC_LOAD_ACQUIRE
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_acquire);
        #endif
        switch((target_root_node_lock)->type){ 
          case JITD_NODE_BTree:{
            BTreeNode *target_root_node = (BTreeNode *)(target_root_node_lock).get();
            {
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
              viewErase(&(target_root_node->lhs));
              viewErase(&(target_root_node->rhs));
END_TIMER;
              /*** BEGIN ASSEMBLING to_ptr ***/
              /*** Assemble to_ptr_lhs as a DeleteSingleton ***/
              DeleteSingletonNode * to_ptr_lhs = new DeleteSingletonNode(target_root_node->lhs, target_root->elem);
              std::shared_ptr<JITDNode> to_ptr_lhs_ref = std::shared_ptr<JITDNode>(to_ptr_lhs);
              /*** Assemble to_ptr as a BTree ***/
              BTreeNode * to_ptr = new BTreeNode(to_ptr_lhs_ref, target_root_node->sep, target_root_node->rhs);
              std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
              /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
              #ifdef ATOMIC_STORE
              std::atomic_store(target, to_ptr_ref);
              #endif
              #ifdef ATOMIC_STORE_RELEASE
              std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
              #endif
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              viewAdd(&(to_ptr->lhs));
              viewAdd(&(to_ptr_lhs->node));
              viewAdd(&(to_ptr->rhs));
              /*** ParentMaintenance ***/
              setParent(target,parent);
              {
                setParent(&(to_ptr->lhs),target);
                fixNodeDecendents(&(to_ptr->lhs),&(to_ptr->lhs));
              }
              {
                setParent(&(to_ptr_lhs->node),&(to_ptr->lhs));
                fixNodeDecendents(&(to_ptr_lhs->node),&(to_ptr_lhs->node));
              }
              {
                setParent(&(to_ptr->rhs),target);
                fixNodeDecendents(&(to_ptr->rhs),&(to_ptr->rhs));
              }
END_TIMER;
              return true;
            }
          }; break;
          default: { //target_root_node is not a BTree
            return false;
          }; break;
        }
      }; break;
      default: { //target_root is not a DeleteSingleton
        return false;
      }; break;
    }
  }

}

bool JITD::PushDownDontDeleteElemBtree(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownDontDeleteElemBtree"<<std::endl;*/
  {
START_TIMER;
    std::shared_ptr<JITDNode>* parent = getParent(target);
END_TIMER;
    std::shared_ptr<JITDNode> target_root_lock;
    // Extract target into DeleteElements
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((target_root_lock)->type){ 
      case JITD_NODE_DeleteElements:{
        DeleteElementsNode *target_root = (DeleteElementsNode *)(target_root_lock).get();
        std::shared_ptr<JITDNode> target_root_node_lock;
        // Extract &(target_root->node) into BTree
        #ifdef ATOMIC_LOAD
        target_root_node_lock = std::atomic_load((&(target_root->node)));
        #endif
        #ifdef ATOMIC_LOAD_CONSUME
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_consume);
        #endif
        #ifdef ATOMIC_LOAD_ACQUIRE
        target_root_node_lock = std::atomic_load_explicit(&(target_root->node),std::memory_order_acquire);
        #endif
        switch((target_root_node_lock)->type){ 
          case JITD_NODE_BTree:{
            BTreeNode *target_root_node = (BTreeNode *)(target_root_node_lock).get();
            {
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
              viewErase(&(target_root_node->lhs));
              viewErase(&(target_root_node->rhs));
END_TIMER;
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
              #ifdef ATOMIC_STORE
              std::atomic_store(target, to_ptr_ref);
              #endif
              #ifdef ATOMIC_STORE_RELEASE
              std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
              #endif
              /*** ViewMaintenanceParent ***/
START_TIMER;
              viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              viewAdd(&(to_ptr->lhs));
              viewAdd(&(to_ptr_lhs->node));
              viewAdd(&(to_ptr->rhs));
              viewAdd(&(to_ptr_rhs->node));
              /*** ParentMaintenance ***/
              setParent(target,parent);
              {
                setParent(&(to_ptr->lhs),target);
                fixNodeDecendents(&(to_ptr->lhs),&(to_ptr->lhs));
              }
              {
                setParent(&(to_ptr_lhs->node),&(to_ptr->lhs));
                fixNodeDecendents(&(to_ptr_lhs->node),&(to_ptr_lhs->node));
              }
              {
                setParent(&(to_ptr->rhs),target);
                fixNodeDecendents(&(to_ptr->rhs),&(to_ptr->rhs));
              }
              {
                setParent(&(to_ptr_rhs->node),&(to_ptr->rhs));
                fixNodeDecendents(&(to_ptr_rhs->node),&(to_ptr_rhs->node));
              }
END_TIMER;
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

bool JITD::PushDownSingletonRight(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownSingletonRight"<<std::endl;*/
  {
START_TIMER;
    std::shared_ptr<JITDNode>* parent = getParent(target);
END_TIMER;
    std::shared_ptr<JITDNode> target_root_lock;
    // Extract target into Concat
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((target_root_lock)->type){ 
      case JITD_NODE_Concat:{
        ConcatNode *target_root = (ConcatNode *)(target_root_lock).get();
        std::shared_ptr<JITDNode> target_root_lhs_lock;
        // Extract &(target_root->lhs) into BTree
        #ifdef ATOMIC_LOAD
        target_root_lhs_lock = std::atomic_load((&(target_root->lhs)));
        #endif
        #ifdef ATOMIC_LOAD_CONSUME
        target_root_lhs_lock = std::atomic_load_explicit(&(target_root->lhs),std::memory_order_consume);
        #endif
        #ifdef ATOMIC_LOAD_ACQUIRE
        target_root_lhs_lock = std::atomic_load_explicit(&(target_root->lhs),std::memory_order_acquire);
        #endif
        switch((target_root_lhs_lock)->type){ 
          case JITD_NODE_BTree:{
            BTreeNode *target_root_lhs = (BTreeNode *)(target_root_lhs_lock).get();
            std::shared_ptr<JITDNode> target_root_rhs_lock;
            // Extract &(target_root->rhs) into Singleton
            #ifdef ATOMIC_LOAD
            target_root_rhs_lock = std::atomic_load((&(target_root->rhs)));
            #endif
            #ifdef ATOMIC_LOAD_CONSUME
            target_root_rhs_lock = std::atomic_load_explicit(&(target_root->rhs),std::memory_order_consume);
            #endif
            #ifdef ATOMIC_LOAD_ACQUIRE
            target_root_rhs_lock = std::atomic_load_explicit(&(target_root->rhs),std::memory_order_acquire);
            #endif
            switch((target_root_rhs_lock)->type){ 
              case JITD_NODE_Singleton:{
                SingletonNode *target_root_rhs = (SingletonNode *)(target_root_rhs_lock).get();
                {
                  /*** ViewMaintenanceParent ***/
START_TIMER;
                  viewErase(parent);
                  /*** ViewMaintenance ***/
                  viewErase(target);
                  viewErase(&(target_root->lhs));
                  viewErase(&(target_root_lhs->lhs));
                  viewErase(&(target_root_lhs->rhs));
                  viewErase(&(target_root->rhs));
END_TIMER;
                  /*** BEGIN ASSEMBLING to_ptr ***/
                  /*** Assemble to_ptr_rhs_rhs as a Singleton ***/
                  SingletonNode * to_ptr_rhs_rhs = new SingletonNode(target_root_rhs->elem);
                  std::shared_ptr<JITDNode> to_ptr_rhs_rhs_ref = std::shared_ptr<JITDNode>(to_ptr_rhs_rhs);
                  /*** Assemble to_ptr_rhs as a Concat ***/
                  ConcatNode * to_ptr_rhs = new ConcatNode(target_root_lhs->rhs, to_ptr_rhs_rhs_ref);
                  std::shared_ptr<JITDNode> to_ptr_rhs_ref = std::shared_ptr<JITDNode>(to_ptr_rhs);
                  /*** Assemble to_ptr as a BTree ***/
                  BTreeNode * to_ptr = new BTreeNode(target_root_lhs->lhs, target_root_lhs->sep, to_ptr_rhs_ref);
                  std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
                  /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
                  #ifdef ATOMIC_STORE
                  std::atomic_store(target, to_ptr_ref);
                  #endif
                  #ifdef ATOMIC_STORE_RELEASE
                  std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
                  #endif
                  /*** ViewMaintenanceParent ***/
START_TIMER;
                  viewAdd(parent);
                  /*** ViewMaintenance ***/
                  viewAdd(target);
                  viewAdd(&(to_ptr->lhs));
                  viewAdd(&(to_ptr->rhs));
                  viewAdd(&(to_ptr_rhs->lhs));
                  viewAdd(&(to_ptr_rhs->rhs));
                  /*** ParentMaintenance ***/
                  setParent(target,parent);
                  {
                    setParent(&(to_ptr->lhs),target);
                    fixNodeDecendents(&(to_ptr->lhs),&(to_ptr->lhs));
                  }
                  {
                    setParent(&(to_ptr->rhs),target);
                    fixNodeDecendents(&(to_ptr->rhs),&(to_ptr->rhs));
                  }
                  {
                    setParent(&(to_ptr_rhs->lhs),&(to_ptr->rhs));
                    fixNodeDecendents(&(to_ptr_rhs->lhs),&(to_ptr_rhs->lhs));
                  }
                  {
                    setParent(&(to_ptr_rhs->rhs),&(to_ptr->rhs));
                    fixNodeDecendents(&(to_ptr_rhs->rhs),&(to_ptr_rhs->rhs));
                  }
END_TIMER;
                  return true;
                }
              }; break;
              default: { //target_root_rhs is not a Singleton
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

bool JITD::PushDownSingletonLeft(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownSingletonLeft"<<std::endl;*/
  {
START_TIMER;
    std::shared_ptr<JITDNode>* parent = getParent(target);
END_TIMER;
    std::shared_ptr<JITDNode> target_root_lock;
    // Extract target into Concat
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((target_root_lock)->type){ 
      case JITD_NODE_Concat:{
        ConcatNode *target_root = (ConcatNode *)(target_root_lock).get();
        std::shared_ptr<JITDNode> target_root_lhs_lock;
        // Extract &(target_root->lhs) into BTree
        #ifdef ATOMIC_LOAD
        target_root_lhs_lock = std::atomic_load((&(target_root->lhs)));
        #endif
        #ifdef ATOMIC_LOAD_CONSUME
        target_root_lhs_lock = std::atomic_load_explicit(&(target_root->lhs),std::memory_order_consume);
        #endif
        #ifdef ATOMIC_LOAD_ACQUIRE
        target_root_lhs_lock = std::atomic_load_explicit(&(target_root->lhs),std::memory_order_acquire);
        #endif
        switch((target_root_lhs_lock)->type){ 
          case JITD_NODE_BTree:{
            BTreeNode *target_root_lhs = (BTreeNode *)(target_root_lhs_lock).get();
            std::shared_ptr<JITDNode> target_root_rhs_lock;
            // Extract &(target_root->rhs) into Singleton
            #ifdef ATOMIC_LOAD
            target_root_rhs_lock = std::atomic_load((&(target_root->rhs)));
            #endif
            #ifdef ATOMIC_LOAD_CONSUME
            target_root_rhs_lock = std::atomic_load_explicit(&(target_root->rhs),std::memory_order_consume);
            #endif
            #ifdef ATOMIC_LOAD_ACQUIRE
            target_root_rhs_lock = std::atomic_load_explicit(&(target_root->rhs),std::memory_order_acquire);
            #endif
            switch((target_root_rhs_lock)->type){ 
              case JITD_NODE_Singleton:{
                SingletonNode *target_root_rhs = (SingletonNode *)(target_root_rhs_lock).get();
                {
                  /*** ViewMaintenanceParent ***/
START_TIMER;
                  viewErase(parent);
                  /*** ViewMaintenance ***/
                  viewErase(target);
                  viewErase(&(target_root->lhs));
                  viewErase(&(target_root_lhs->lhs));
                  viewErase(&(target_root_lhs->rhs));
                  viewErase(&(target_root->rhs));
END_TIMER;
                  /*** BEGIN ASSEMBLING to_ptr ***/
                  /*** Assemble to_ptr_lhs_rhs as a Singleton ***/
                  SingletonNode * to_ptr_lhs_rhs = new SingletonNode(target_root_rhs->elem);
                  std::shared_ptr<JITDNode> to_ptr_lhs_rhs_ref = std::shared_ptr<JITDNode>(to_ptr_lhs_rhs);
                  /*** Assemble to_ptr_lhs as a Concat ***/
                  ConcatNode * to_ptr_lhs = new ConcatNode(target_root_lhs->lhs, to_ptr_lhs_rhs_ref);
                  std::shared_ptr<JITDNode> to_ptr_lhs_ref = std::shared_ptr<JITDNode>(to_ptr_lhs);
                  /*** Assemble to_ptr as a BTree ***/
                  BTreeNode * to_ptr = new BTreeNode(to_ptr_lhs_ref, target_root_lhs->sep, target_root_lhs->rhs);
                  std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
                  /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
                  #ifdef ATOMIC_STORE
                  std::atomic_store(target, to_ptr_ref);
                  #endif
                  #ifdef ATOMIC_STORE_RELEASE
                  std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
                  #endif
                  /*** ViewMaintenanceParent ***/
START_TIMER;
                  viewAdd(parent);
                  /*** ViewMaintenance ***/
                  viewAdd(target);
                  viewAdd(&(to_ptr->lhs));
                  viewAdd(&(to_ptr_lhs->lhs));
                  viewAdd(&(to_ptr_lhs->rhs));
                  viewAdd(&(to_ptr->rhs));
                  /*** ParentMaintenance ***/
                  setParent(target,parent);
                  {
                    setParent(&(to_ptr->lhs),target);
                    fixNodeDecendents(&(to_ptr->lhs),&(to_ptr->lhs));
                  }
                  {
                    setParent(&(to_ptr_lhs->lhs),&(to_ptr->lhs));
                    fixNodeDecendents(&(to_ptr_lhs->lhs),&(to_ptr_lhs->lhs));
                  }
                  {
                    setParent(&(to_ptr_lhs->rhs),&(to_ptr->lhs));
                    fixNodeDecendents(&(to_ptr_lhs->rhs),&(to_ptr_lhs->rhs));
                  }
                  {
                    setParent(&(to_ptr->rhs),target);
                    fixNodeDecendents(&(to_ptr->rhs),&(to_ptr->rhs));
                  }
END_TIMER;
                  return true;
                }
              }; break;
              default: { //target_root_rhs is not a Singleton
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

bool JITD::CrackArray(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::CrackArray"<<std::endl;*/
  {
START_TIMER;
    std::shared_ptr<JITDNode>* parent = getParent(target);
END_TIMER;
    std::shared_ptr<JITDNode> target_root_lock;
    // Extract target into Array
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((target_root_lock)->type){ 
      case JITD_NODE_Array:{
        ArrayNode *target_root = (ArrayNode *)(target_root_lock).get();
        {
          /*** ViewMaintenanceParent ***/
START_TIMER;
          viewErase(parent);
          /*** ViewMaintenance ***/
          viewErase(target);
END_TIMER;
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
          #ifdef ATOMIC_STORE
          std::atomic_store(target, to_ptr_ref);
          #endif
          #ifdef ATOMIC_STORE_RELEASE
          std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
          #endif
          /*** ViewMaintenanceParent ***/
START_TIMER;
          viewAdd(parent);
          /*** ViewMaintenance ***/
          viewAdd(target);
          viewAdd(&(to_ptr->lhs));
          viewAdd(&(to_ptr->rhs));
          /*** ParentMaintenance ***/
          setParent(target,parent);
          {
            setParent(&(to_ptr->lhs),target);
            fixNodeDecendents(&(to_ptr->lhs),&(to_ptr->lhs));
          }
          {
            setParent(&(to_ptr->rhs),target);
            fixNodeDecendents(&(to_ptr->rhs),&(to_ptr->rhs));
          }
END_TIMER;
          return true;
        }
      }; break;
      default: { //target_root is not a Array
        return false;
      }; break;
    }
  }

}

bool JITD::SortArray(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::SortArray"<<std::endl;*/
  {
START_TIMER;
    std::shared_ptr<JITDNode>* parent = getParent(target);
END_TIMER;
    std::shared_ptr<JITDNode> target_root_lock;
    // Extract target into Array
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((target_root_lock)->type){ 
      case JITD_NODE_Array:{
        ArrayNode *target_root = (ArrayNode *)(target_root_lock).get();
        {
          /*** ViewMaintenanceParent ***/
START_TIMER;
          viewErase(parent);
          /*** ViewMaintenance ***/
          viewErase(target);
END_TIMER;
          /*** BEGIN ASSEMBLING to_ptr ***/
          /*** Assemble to_ptr as a SortedArray ***/
          SortedArrayNode * to_ptr = new SortedArrayNode(target_root->data);
          std::shared_ptr<JITDNode> to_ptr_ref = std::shared_ptr<JITDNode>(to_ptr);
          /*** Handle post-processing for to_ptr ***/
          std::sort(std::begin(to_ptr->data), std::end(to_ptr->data));
          /*** END ASSEMBLING to_ptr as to_ptr_ref ***/
          #ifdef ATOMIC_STORE
          std::atomic_store(target, to_ptr_ref);
          #endif
          #ifdef ATOMIC_STORE_RELEASE
          std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
          #endif
          /*** ViewMaintenanceParent ***/
START_TIMER;
          viewAdd(parent);
          /*** ViewMaintenance ***/
          viewAdd(target);
          /*** ParentMaintenance ***/
          setParent(target,parent);
END_TIMER;
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
/*std::cout<<" The transform applied is:jitd_accessor_size"<<std::endl;*/
  std::shared_ptr<JITDNode> jitd_node_lock;
  // Extract &(jitd_node_ref) into Singleton or Concat or DeleteElements or BTree or Array or DeleteSingleton or SortedArray
  #ifdef ATOMIC_LOAD
  jitd_node_lock = std::atomic_load((&(jitd_node_ref)));
  #endif
  #ifdef ATOMIC_LOAD_CONSUME
  jitd_node_lock = std::atomic_load_explicit(&(jitd_node_ref),std::memory_order_consume);
  #endif
  #ifdef ATOMIC_LOAD_ACQUIRE
  jitd_node_lock = std::atomic_load_explicit(&(jitd_node_ref),std::memory_order_acquire);
  #endif
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
      return (jitd_accessor_size(jitd_node->node)) - (key_array_size(jitd_node->data));
    }; break;
    case JITD_NODE_BTree:{
      BTreeNode *jitd_node = (BTreeNode *)(jitd_node_lock).get();
      return (jitd_accessor_size(jitd_node->lhs)) + (jitd_accessor_size(jitd_node->rhs));
    }; break;
    case JITD_NODE_Array:{
      ArrayNode *jitd_node = (ArrayNode *)(jitd_node_lock).get();
      return array_size(jitd_node->data);
    }; break;
    case JITD_NODE_DeleteSingleton:{
      DeleteSingletonNode *jitd_node = (DeleteSingletonNode *)(jitd_node_lock).get();
      return (jitd_accessor_size(jitd_node->node)) - (1);
    }; break;
    case JITD_NODE_SortedArray:{
      SortedArrayNode *jitd_node = (SortedArrayNode *)(jitd_node_lock).get();
      return array_size(jitd_node->data);
    }; break;
    default: { //jitd_node is not a Singleton or a Concat or a DeleteElements or a BTree or a Array or a DeleteSingleton or a SortedArray
      std::cerr << "Unhandled Node Type in size" << std::endl;
      exit(-1);
    }; break;
  }

}

bool jitd_accessor_get(const std::shared_ptr<JITDNode> &jitd_node_ref ,long target ,Record &result )
{
/*std::cout<<" The transform applied is:jitd_accessor_get"<<std::endl;*/
  std::shared_ptr<JITDNode> jitd_node_lock;
  // Extract &(jitd_node_ref) into Singleton or Concat or DeleteElements or BTree or Array or DeleteSingleton or SortedArray
  #ifdef ATOMIC_LOAD
  jitd_node_lock = std::atomic_load((&(jitd_node_ref)));
  #endif
  #ifdef ATOMIC_LOAD_CONSUME
  jitd_node_lock = std::atomic_load_explicit(&(jitd_node_ref),std::memory_order_consume);
  #endif
  #ifdef ATOMIC_LOAD_ACQUIRE
  jitd_node_lock = std::atomic_load_explicit(&(jitd_node_ref),std::memory_order_acquire);
  #endif
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
      if(key_scan(jitd_node->data, target, result))
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
    case JITD_NODE_DeleteSingleton:{
      DeleteSingletonNode *jitd_node = (DeleteSingletonNode *)(jitd_node_lock).get();
      if(false)
        return false;
      else
        return jitd_accessor_get(jitd_node->node, target, result);
    }; break;
    case JITD_NODE_SortedArray:{
      SortedArrayNode *jitd_node = (SortedArrayNode *)(jitd_node_lock).get();
      return record_binary_search(jitd_node->data, target, result);
    }; break;
    default: { //jitd_node is not a Singleton or a Concat or a DeleteElements or a BTree or a Array or a DeleteSingleton or a SortedArray
      std::cerr << "Unhandled Node Type in get" << std::endl;
      exit(-1);
    }; break;
  }

}


///////////////////// Mutator Definitions ///////////////////// 


void JITD::remove_singleton(const long &data )
{
/*std::cout<<" The transform applied is:JITD::remove_singleton"<<std::endl;*/
  {
    /*** BEGIN ASSEMBLING new_root ***/
    /*** Assemble new_root as a DeleteSingleton ***/
    DeleteSingletonNode * new_root = new DeleteSingletonNode(*jitd_root, data);
    /*** END ASSEMBLING new_root as new_root_ref ***/
    std::shared_ptr<std::shared_ptr<JITDNode>> new_root_ptr = std::shared_ptr<std::shared_ptr<JITDNode>>(std::make_shared<std::shared_ptr<JITDNode>>(std::shared_ptr<JITDNode>(new_root)));
    this->work_queue.emplace(FLAG_remove_singleton,jitd_root,new_root_ptr);

    #ifdef ATOMIC_STORE
    std::atomic_store(&jitd_root, new_root_ptr);

    #endif

    #ifdef ATOMIC_STORE_RELEASE
    std::atomic_store_explicit(&jitd_root, new_root_ptr,std::memory_order_release);

    #endif
  }

}
void JITD::after_remove_singleton(std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem)
{
/*std::cout<<" The transform applied is:JITD::after_remove_singleton"<<std::endl;*/
  {
START_TIMER;
    viewErase(&( *(cq_elem.first)));
END_TIMER;
    DeleteSingletonNode *cast_root = (DeleteSingletonNode*)((cq_elem.second)->get());
    /*** UpdateTarget ***/
    {
    }
    {

      #ifdef ATOMIC_STORE
      std::atomic_store(&(cast_root->node),*(cq_elem.first));

      #endif

      #ifdef ATOMIC_STORE_RELEASE
      std::atomic_store_explicit(&(cast_root->node),*(cq_elem.first),std::memory_order_release);

      #endif
START_TIMER;
      fixNodeDecendents(&(*(cq_elem.first)),&(cast_root->node));
END_TIMER;
    }
    /*** ViewMaintenance ***/
START_TIMER;
    viewAdd(&(*(cq_elem.second)));
    viewAdd(&(cast_root->node));
    /*** ParentMaintenance ***/
    setParent(&(*(cq_elem.second)),NULL);
    setParent(&(cast_root->node),&(*(cq_elem.second)));
END_TIMER;
  }

}


void JITD::remove_elements(const std::vector<long> &data )
{
/*std::cout<<" The transform applied is:JITD::remove_elements"<<std::endl;*/
  {
    /*** BEGIN ASSEMBLING new_root ***/
    /*** Assemble new_root as a DeleteElements ***/
    DeleteElementsNode * new_root = new DeleteElementsNode(*jitd_root, data);
    /*** END ASSEMBLING new_root as new_root_ref ***/
    std::shared_ptr<std::shared_ptr<JITDNode>> new_root_ptr = std::shared_ptr<std::shared_ptr<JITDNode>>(std::make_shared<std::shared_ptr<JITDNode>>(std::shared_ptr<JITDNode>(new_root)));
    this->work_queue.emplace(FLAG_remove_elements,jitd_root,new_root_ptr);

    #ifdef ATOMIC_STORE
    std::atomic_store(&jitd_root, new_root_ptr);

    #endif

    #ifdef ATOMIC_STORE_RELEASE
    std::atomic_store_explicit(&jitd_root, new_root_ptr,std::memory_order_release);

    #endif
  }

}
void JITD::after_remove_elements(std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem)
{
/*std::cout<<" The transform applied is:JITD::after_remove_elements"<<std::endl;*/
  {
START_TIMER;
    viewErase(&( *(cq_elem.first)));
END_TIMER;
    DeleteElementsNode *cast_root = (DeleteElementsNode*)((cq_elem.second)->get());
    /*** UpdateTarget ***/
    {
    }
    {

      #ifdef ATOMIC_STORE
      std::atomic_store(&(cast_root->node),*(cq_elem.first));

      #endif

      #ifdef ATOMIC_STORE_RELEASE
      std::atomic_store_explicit(&(cast_root->node),*(cq_elem.first),std::memory_order_release);

      #endif
START_TIMER;
      fixNodeDecendents(&(*(cq_elem.first)),&(cast_root->node));
END_TIMER;
    }
    /*** ViewMaintenance ***/
START_TIMER;
    viewAdd(&(*(cq_elem.second)));
    viewAdd(&(cast_root->node));
    /*** ParentMaintenance ***/
    setParent(&(*(cq_elem.second)),NULL);
    setParent(&(cast_root->node),&(*(cq_elem.second)));
END_TIMER;
  }

}


void JITD::insert(const std::vector<Record> &data )
{
/*std::cout<<" The transform applied is:JITD::insert"<<std::endl;*/
  {
    /*** BEGIN ASSEMBLING new_root ***/
    /*** Assemble new_root_rhs as a Array ***/
    ArrayNode * new_root_rhs = new ArrayNode(data);
    std::shared_ptr<JITDNode> new_root_rhs_ref = std::shared_ptr<JITDNode>(new_root_rhs);
    /*** Assemble new_root as a Concat ***/
    ConcatNode * new_root = new ConcatNode(*jitd_root, new_root_rhs_ref);
    /*** END ASSEMBLING new_root as new_root_ref ***/
    std::shared_ptr<std::shared_ptr<JITDNode>> new_root_ptr = std::shared_ptr<std::shared_ptr<JITDNode>>(std::make_shared<std::shared_ptr<JITDNode>>(std::shared_ptr<JITDNode>(new_root)));
    this->work_queue.emplace(FLAG_insert,jitd_root,new_root_ptr);

    #ifdef ATOMIC_STORE
    std::atomic_store(&jitd_root, new_root_ptr);

    #endif

    #ifdef ATOMIC_STORE_RELEASE
    std::atomic_store_explicit(&jitd_root, new_root_ptr,std::memory_order_release);

    #endif
  }

}
void JITD::after_insert(std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem)
{
/*std::cout<<" The transform applied is:JITD::after_insert"<<std::endl;*/
  {
START_TIMER;
    viewErase(&( *(cq_elem.first)));
END_TIMER;
    ConcatNode *cast_root = (ConcatNode*)((cq_elem.second)->get());
    /*** UpdateTarget ***/
    {
    }
    {

      #ifdef ATOMIC_STORE
      std::atomic_store(&(cast_root->lhs),*(cq_elem.first));

      #endif

      #ifdef ATOMIC_STORE_RELEASE
      std::atomic_store_explicit(&(cast_root->lhs),*(cq_elem.first),std::memory_order_release);

      #endif
START_TIMER;
      fixNodeDecendents(&(*(cq_elem.first)),&(cast_root->lhs));
END_TIMER;
    }
    {
    }
    /*** ViewMaintenance ***/
START_TIMER;
    viewAdd(&(*(cq_elem.second)));
    viewAdd(&(cast_root->lhs));
    viewAdd(&(cast_root->rhs));
    /*** ParentMaintenance ***/
    setParent(&(*(cq_elem.second)),NULL);
    setParent(&(cast_root->lhs),&(*(cq_elem.second)));
    setParent(&(cast_root->rhs),&(*(cq_elem.second)));
END_TIMER;
  }

}


void JITD::insert_singleton(const Record &data )
{
/*std::cout<<" The transform applied is:JITD::insert_singleton"<<std::endl;*/
  {
    /*** BEGIN ASSEMBLING new_root ***/
    /*** Assemble new_root_rhs as a Singleton ***/
    SingletonNode * new_root_rhs = new SingletonNode(data);
    std::shared_ptr<JITDNode> new_root_rhs_ref = std::shared_ptr<JITDNode>(new_root_rhs);
    /*** Assemble new_root as a Concat ***/
    ConcatNode * new_root = new ConcatNode(*jitd_root, new_root_rhs_ref);
    /*** END ASSEMBLING new_root as new_root_ref ***/
    std::shared_ptr<std::shared_ptr<JITDNode>> new_root_ptr = std::shared_ptr<std::shared_ptr<JITDNode>>(std::make_shared<std::shared_ptr<JITDNode>>(std::shared_ptr<JITDNode>(new_root)));
    this->work_queue.emplace(FLAG_insert_singleton,jitd_root,new_root_ptr);

    #ifdef ATOMIC_STORE
    std::atomic_store(&jitd_root, new_root_ptr);

    #endif

    #ifdef ATOMIC_STORE_RELEASE
    std::atomic_store_explicit(&jitd_root, new_root_ptr,std::memory_order_release);

    #endif
  }

}
void JITD::after_insert_singleton(std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem)
{
/*std::cout<<" The transform applied is:JITD::after_insert_singleton"<<std::endl;*/
  {
START_TIMER;
    viewErase(&( *(cq_elem.first)));
END_TIMER;
    ConcatNode *cast_root = (ConcatNode*)((cq_elem.second)->get());
    /*** UpdateTarget ***/
    {
    }
    {

      #ifdef ATOMIC_STORE
      std::atomic_store(&(cast_root->lhs),*(cq_elem.first));

      #endif

      #ifdef ATOMIC_STORE_RELEASE
      std::atomic_store_explicit(&(cast_root->lhs),*(cq_elem.first),std::memory_order_release);

      #endif
START_TIMER;
      fixNodeDecendents(&(*(cq_elem.first)),&(cast_root->lhs));
END_TIMER;
    }
    {
    }
    /*** ViewMaintenance ***/
START_TIMER;
    viewAdd(&(*(cq_elem.second)));
    viewAdd(&(cast_root->lhs));
    viewAdd(&(cast_root->rhs));
    /*** ParentMaintenance ***/
    setParent(&(*(cq_elem.second)),NULL);
    setParent(&(cast_root->lhs),&(*(cq_elem.second)));
    setParent(&(cast_root->rhs),&(*(cq_elem.second)));
END_TIMER;
  }

}


///////////////////// OnMatch Transforms /////////////////////


bool JITD::matchPushDownSingletonLeft(std::shared_ptr<JITDNode> * &targetHandleRef) 
{ 
	std::shared_ptr<JITDNode> target_root;
    #ifdef ATOMIC_LOAD
    target_root = std::atomic_load((targetHandleRef));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root = std::atomic_load_explicit(targetHandleRef,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root = std::atomic_load_explicit(targetHandleRef,std::memory_order_acquire);
    #endif
	//std::shared_ptr<JITDNode> target_root = std::atomic_load(targetHandleRef);
	JITDNode * target_root_lock = target_root.get();
	if(target_root_lock->type != JITD_NODE_Concat){return false; }
ConcatNode *target_root_lock_real = (ConcatNode *)target_root_lock;
JITDNode *target_root_lock_real_lhs = target_root_lock_real->lhs.get();
if(target_root_lock_real_lhs->type != JITD_NODE_BTree){return false; }
BTreeNode *target_root_lock_real_lhs_real = (BTreeNode *)target_root_lock_real_lhs;
JITDNode *target_root_lock_real_rhs = target_root_lock_real->rhs.get();
if(target_root_lock_real_rhs->type != JITD_NODE_Singleton){return false; }
SingletonNode *target_root_lock_real_rhs_real = (SingletonNode *)target_root_lock_real_rhs;

	if((key_cmp((target_root_lock_real_rhs_real->elem), (target_root_lock_real_lhs_real->sep))) == (true))
    {
    	return true;
    }
    else
    {
    	return false;
    }
	
}
bool JITD::matchPushDownSingletonRight(std::shared_ptr<JITDNode> * &targetHandleRef) 
{ 
	std::shared_ptr<JITDNode> target_root;
    #ifdef ATOMIC_LOAD
    target_root = std::atomic_load((targetHandleRef));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root = std::atomic_load_explicit(targetHandleRef,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root = std::atomic_load_explicit(targetHandleRef,std::memory_order_acquire);
    #endif
	//std::shared_ptr<JITDNode> target_root = std::atomic_load(targetHandleRef);
	JITDNode * target_root_lock = target_root.get();
	if(target_root_lock->type != JITD_NODE_Concat){return false; }
ConcatNode *target_root_lock_real = (ConcatNode *)target_root_lock;
JITDNode *target_root_lock_real_lhs = target_root_lock_real->lhs.get();
if(target_root_lock_real_lhs->type != JITD_NODE_BTree){return false; }
BTreeNode *target_root_lock_real_lhs_real = (BTreeNode *)target_root_lock_real_lhs;
JITDNode *target_root_lock_real_rhs = target_root_lock_real->rhs.get();
if(target_root_lock_real_rhs->type != JITD_NODE_Singleton){return false; }
SingletonNode *target_root_lock_real_rhs_real = (SingletonNode *)target_root_lock_real_rhs;

	if((key_cmp((target_root_lock_real_rhs_real->elem), (target_root_lock_real_lhs_real->sep))) == (false))
    {
    	return true;
    }
    else
    {
    	return false;
    }
	
}
bool JITD::matchCrackArray(std::shared_ptr<JITDNode> * &targetHandleRef) 
{ 
	std::shared_ptr<JITDNode> target_root;
    #ifdef ATOMIC_LOAD
    target_root = std::atomic_load((targetHandleRef));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root = std::atomic_load_explicit(targetHandleRef,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root = std::atomic_load_explicit(targetHandleRef,std::memory_order_acquire);
    #endif
	//std::shared_ptr<JITDNode> target_root = std::atomic_load(targetHandleRef);
	JITDNode * target_root_lock = target_root.get();
	if(target_root_lock->type != JITD_NODE_Array){return false; }
ArrayNode *target_root_lock_real = (ArrayNode *)target_root_lock;

	if((array_size((target_root_lock_real->data))) > (100))
    {
    	return true;
    }
    else
    {
    	return false;
    }
	
}
///////////////////// Policy Implementation ///////////////////// 


  long JITD::searchForPushDownSingletonLeft(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  

    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->PushDownSingletonLeft_View).empty())
    {
    
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->PushDownSingletonLeft_View).begin();
          
         

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_Concat){return -1; }
ConcatNode *iter_node_real = (ConcatNode *)iter_node;
JITDNode *iter_node_real_lhs = iter_node_real->lhs.get();
if(iter_node_real_lhs->type != JITD_NODE_BTree){return -1; }
BTreeNode *iter_node_real_lhs_real = (BTreeNode *)iter_node_real_lhs;
JITDNode *iter_node_real_rhs = iter_node_real->rhs.get();
if(iter_node_real_rhs->type != JITD_NODE_Singleton){return -1; }
SingletonNode *iter_node_real_rhs_real = (SingletonNode *)iter_node_real_rhs;


          if((key_cmp((iter_node_real_rhs_real->elem), (iter_node_real_lhs_real->sep))) == (true)){
            bestScore = 0;
          
          targetHandleRef = (*it);
          }
          

          
      
    }





    return bestScore;
  }

  long JITD::searchForPushDownSingletonRight(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  

    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->PushDownSingletonRight_View).empty())
    {
    
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->PushDownSingletonRight_View).begin();
          
         

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_Concat){return -1; }
ConcatNode *iter_node_real = (ConcatNode *)iter_node;
JITDNode *iter_node_real_lhs = iter_node_real->lhs.get();
if(iter_node_real_lhs->type != JITD_NODE_BTree){return -1; }
BTreeNode *iter_node_real_lhs_real = (BTreeNode *)iter_node_real_lhs;
JITDNode *iter_node_real_rhs = iter_node_real->rhs.get();
if(iter_node_real_rhs->type != JITD_NODE_Singleton){return -1; }
SingletonNode *iter_node_real_rhs_real = (SingletonNode *)iter_node_real_rhs;


          if((key_cmp((iter_node_real_rhs_real->elem), (iter_node_real_lhs_real->sep))) == (false)){
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


          if((array_size((iter_node_real->data))) > (100)){
            bestScore = array_size((iter_node_real->data));
          
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
        //std::cout<<"JITD_PRINT: "<<not_done<<std::endl;
        //this->print_debug();
        //this->check_view();
        //this->print_map();
        
        
      }
      else
      {
        mutatorCqElement pop_mce;

        #ifdef BLOCK
        this->work_queue.pop(pop_mce);
        #endif

        #ifdef SPIN
        while(this->work_queue.try_pop(pop_mce) == false)
        {
            std::this_thread::sleep_for(std::chrono::microseconds(100));
        }
        #endif

        if(pop_mce.flag == EXIT)
        {
          #ifdef RDTSC
          std::cout<<"At EXIT Size of the rdtsc vec is"<<this->rdtsc_vector.size()<<std::endl;
          #endif
          #ifdef TRANSFORM_COUNT
            this->times_transforms_called();
          #endif
          return t;
        }
        
        else if(pop_mce.flag == FLAG_remove_singleton)
        {
          this->after_remove_singleton(pop_mce.element);
          not_done = true;
          //std::cout<<"AFTER_remove_singleton_PRINT: "<<not_done<<std::endl;
          //this->print_debug();
          //this->check_view();
          //this->print_map();
          
        }
        
        else if(pop_mce.flag == FLAG_remove_elements)
        {
          this->after_remove_elements(pop_mce.element);
          not_done = true;
          //std::cout<<"AFTER_remove_elements_PRINT: "<<not_done<<std::endl;
          //this->print_debug();
          //this->check_view();
          //this->print_map();
          
        }
        
        else if(pop_mce.flag == FLAG_insert)
        {
          this->after_insert(pop_mce.element);
          not_done = true;
          //std::cout<<"AFTER_insert_PRINT: "<<not_done<<std::endl;
          //this->print_debug();
          //this->check_view();
          //this->print_map();
          
        }
        
        else if(pop_mce.flag == FLAG_insert_singleton)
        {
          this->after_insert_singleton(pop_mce.element);
          not_done = true;
          //std::cout<<"AFTER_insert_singleton_PRINT: "<<not_done<<std::endl;
          //this->print_debug();
          //this->check_view();
          //this->print_map();
          
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
void JITD::initialize_struts_view(std::shared_ptr<JITDNode>* node,std::shared_ptr<JITDNode>* parent)
{
    std::shared_ptr<JITDNode> target_root_lock;
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((node));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(node,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(node,std::memory_order_acquire);
    #endif
  //std::shared_ptr<JITDNode> target_root_lock = std::atomic_load((node));
  //this->childParentMap.emplace(node,parent);
  viewAdd(node);
  switch(target_root_lock->type)
  {
    
      case JITD_NODE_DeleteSingleton : {
      DeleteSingletonNode *node_real = (DeleteSingletonNode *)target_root_lock.get();
      node_real->parent = parent;
        initialize_struts_view(&(node_real->node),node);
 
        break;      
      }

    
      case JITD_NODE_DeleteElements : {
      DeleteElementsNode *node_real = (DeleteElementsNode *)target_root_lock.get();
      node_real->parent = parent;
        initialize_struts_view(&(node_real->node),node);
 
        break;      
      }

    
      case JITD_NODE_BTree : {
      BTreeNode *node_real = (BTreeNode *)target_root_lock.get();
      node_real->parent = parent;
        initialize_struts_view(&(node_real->lhs),node);
initialize_struts_view(&(node_real->rhs),node);
 
        break;      
      }

    
      case JITD_NODE_Concat : {
      ConcatNode *node_real = (ConcatNode *)target_root_lock.get();
      node_real->parent = parent;
        initialize_struts_view(&(node_real->lhs),node);
initialize_struts_view(&(node_real->rhs),node);
 
        break;      
      }

    
      case JITD_NODE_SortedArray : {
      SortedArrayNode *node_real = (SortedArrayNode *)target_root_lock.get();
      node_real->parent = parent;
         
        break;      
      }

    
      case JITD_NODE_Array : {
      ArrayNode *node_real = (ArrayNode *)target_root_lock.get();
      node_real->parent = parent;
         
        break;      
      }

    
      case JITD_NODE_Singleton : {
      SingletonNode *node_real = (SingletonNode *)target_root_lock.get();
      node_real->parent = parent;
         
        break;      
      }

    

  }
}
/*
void JITD::initialize_struts(std::shared_ptr<JITDNode>* node,std::shared_ptr<JITDNode>* parent)
{
    std::shared_ptr<JITDNode> target_root_lock;
    #ifdef ATOMIC_LOAD
    target_root_lock = std::atomic_load((node));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    target_root_lock = std::atomic_load_explicit(node,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    target_root_lock = std::atomic_load_explicit(node,std::memory_order_acquire);
    #endif
  //std::shared_ptr<JITDNode> target_root_lock = std::atomic_load((node));
  this->childParentMap.emplace(node,parent);
  viewAdd(node);
  switch(target_root_lock->type)
  {
    
      case JITD_NODE_DeleteSingleton : {
      
      
      DeleteSingletonNode *node_real = (DeleteSingletonNode *)target_root_lock.get();
        initialize_struts(&(node_real->node),node);
 
        break;      
      }

    
      case JITD_NODE_DeleteElements : {
      
      
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
*/
bool JITD::do_organize()
{
  
  



{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForPushDownSingletonLeft" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForPushDownSingletonLeft(
    targetHandleRef
  );
  //std::cout<<"After calling searchForPushDownSingletonLeft Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
    //std::cout<<"Candidate shared_ptr for PushDownSingletonLeft: "<<(*targetHandleRef)<<std::endl;
    
      #ifdef TRANSFORM_COUNT
    PushDownSingletonLeft_count++;
    #endif
      PushDownSingletonLeft(targetHandleRef);
    
    return true;

  } 
  
  
  
  else { 
     
  }







}


  



{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForPushDownSingletonRight" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForPushDownSingletonRight(
    targetHandleRef
  );
  //std::cout<<"After calling searchForPushDownSingletonRight Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
    //std::cout<<"Candidate shared_ptr for PushDownSingletonRight: "<<(*targetHandleRef)<<std::endl;
    
      #ifdef TRANSFORM_COUNT
    PushDownSingletonRight_count++;
    #endif
      PushDownSingletonRight(targetHandleRef);
    
    return true;

  } 
  
  
  
  else { 
     
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
    
      #ifdef TRANSFORM_COUNT
    CrackArray_count++;
    #endif
      CrackArray(targetHandleRef);
    
    return true;

  } 
  
  
  
  else { 
     
  }







}


  return false;


}
///////////////////// Set/PQ/View populate ///////////////////// 
/*
void JITD::SetPqErase(std::shared_ptr<JITDNode> * node_handle)
{
  #ifdef DEBUG
    assert(node_handle!=NULL);
  #endif
    std::shared_ptr<JITDNode> node_ptr;
    #ifdef ATOMIC_LOAD
    node_ptr = std::atomic_load((node_handle));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_acquire);
    #endif
  //std::shared_ptr<JITDNode> node_ptr = std::atomic_load((node_handle));
   #ifdef DEBUG
    assert(node_ptr!=NULL);
  #endif
  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteSingleton : {
          
          
          };break;
        
      case JITD_NODE_DeleteElements : {
          
          
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
  std::shared_ptr<JITDNode> node_ptr;
    #ifdef ATOMIC_LOAD
    node_ptr = std::atomic_load((node_handle));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_acquire);
    #endif
  //std::shared_ptr<JITDNode> node_ptr = std::atomic_load((node_handle));
   #ifdef DEBUG
    assert(node_ptr!=NULL);
  #endif
  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteSingleton : {
          
          
          };break;
        
      case JITD_NODE_DeleteElements : {
          
          
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
}*/
void JITD::viewAdd(std::shared_ptr<JITDNode>* node_handle)
{
  if(node_handle == NULL){return;}
  bool matched = false;
  std::shared_ptr<JITDNode> node_ptr;
    #ifdef ATOMIC_LOAD
    node_ptr = std::atomic_load((node_handle));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_acquire);
    #endif
  //std::shared_ptr<JITDNode> node_ptr = std::atomic_load((node_handle));
  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteSingleton : {
        
        break;
      }

    
      case JITD_NODE_DeleteElements : {
        
        break;
      }

    
      case JITD_NODE_BTree : {
        
        break;
      }

    
      case JITD_NODE_Concat : {
        matched = this->matchPushDownSingletonLeft(node_handle);
if(matched == true){
this->PushDownSingletonLeft_View.emplace(node_handle);
}
matched = this->matchPushDownSingletonRight(node_handle);
if(matched == true){
this->PushDownSingletonRight_View.emplace(node_handle);
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
  std::shared_ptr<JITDNode> node_ptr;
    #ifdef ATOMIC_LOAD
    node_ptr = std::atomic_load((node_handle));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_acquire);
    #endif
  //std::shared_ptr<JITDNode> node_ptr = std::atomic_load((node_handle));
  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteSingleton : {
        
        break;
      
      }

    
      case JITD_NODE_DeleteElements : {
        
        break;
      
      }

    
      case JITD_NODE_BTree : {
        
        break;
      
      }

    
      case JITD_NODE_Concat : {
        this->PushDownSingletonLeft_View.erase(node_handle);
this->PushDownSingletonRight_View.erase(node_handle);

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
    std::shared_ptr<JITDNode> node_ptr;
    #ifdef ATOMIC_LOAD
    node_ptr = std::atomic_load((target));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    node_ptr = std::atomic_load_explicit(target,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    node_ptr = std::atomic_load_explicit(target,std::memory_order_acquire);
    #endif
    switch((node_ptr)->type){
      
        case JITD_NODE_DeleteSingleton : {
          DeleteSingletonNode *node_real = (DeleteSingletonNode *)node_ptr.get();
          return (node_real->parent);
        break;
        }

      
        case JITD_NODE_DeleteElements : {
          DeleteElementsNode *node_real = (DeleteElementsNode *)node_ptr.get();
          return (node_real->parent);
        break;
        }

      
        case JITD_NODE_BTree : {
          BTreeNode *node_real = (BTreeNode *)node_ptr.get();
          return (node_real->parent);
        break;
        }

      
        case JITD_NODE_Concat : {
          ConcatNode *node_real = (ConcatNode *)node_ptr.get();
          return (node_real->parent);
        break;
        }

      
        case JITD_NODE_SortedArray : {
          SortedArrayNode *node_real = (SortedArrayNode *)node_ptr.get();
          return (node_real->parent);
        break;
        }

      
        case JITD_NODE_Array : {
          ArrayNode *node_real = (ArrayNode *)node_ptr.get();
          return (node_real->parent);
        break;
        }

      
        case JITD_NODE_Singleton : {
          SingletonNode *node_real = (SingletonNode *)node_ptr.get();
          return (node_real->parent);
        break;
        }

      
    }
  
  
}
/*
std::shared_ptr<JITDNode> * JITD::getParentMap(std::shared_ptr<JITDNode> * &target)
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
*/
void JITD::setParent(std::shared_ptr<JITDNode>* node_handle,std::shared_ptr<JITDNode>* parent)
{
    std::shared_ptr<JITDNode> node_ptr;
    #ifdef ATOMIC_LOAD
    node_ptr = std::atomic_load((node_handle));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_acquire);
    #endif
    switch((node_ptr)->type){
      
        case JITD_NODE_DeleteSingleton : {
          DeleteSingletonNode *node_real = (DeleteSingletonNode *)node_ptr.get();
          node_real->parent = parent;
        break;
        }

      
        case JITD_NODE_DeleteElements : {
          DeleteElementsNode *node_real = (DeleteElementsNode *)node_ptr.get();
          node_real->parent = parent;
        break;
        }

      
        case JITD_NODE_BTree : {
          BTreeNode *node_real = (BTreeNode *)node_ptr.get();
          node_real->parent = parent;
        break;
        }

      
        case JITD_NODE_Concat : {
          ConcatNode *node_real = (ConcatNode *)node_ptr.get();
          node_real->parent = parent;
        break;
        }

      
        case JITD_NODE_SortedArray : {
          SortedArrayNode *node_real = (SortedArrayNode *)node_ptr.get();
          node_real->parent = parent;
        break;
        }

      
        case JITD_NODE_Array : {
          ArrayNode *node_real = (ArrayNode *)node_ptr.get();
          node_real->parent = parent;
        break;
        }

      
        case JITD_NODE_Singleton : {
          SingletonNode *node_real = (SingletonNode *)node_ptr.get();
          node_real->parent = parent;
        break;
        }

      
    }
}
void JITD::fixNodeDecendents(std::shared_ptr<JITDNode>* node_handle,std::shared_ptr<JITDNode>* parent)
{
  std::shared_ptr<JITDNode> node_ptr;
    #ifdef ATOMIC_LOAD
    node_ptr = std::atomic_load((node_handle));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_acquire);
    #endif
  //std::shared_ptr<JITDNode> node_ptr = std::atomic_load((node_handle));
  switch((node_ptr)->type){
  
    case JITD_NODE_DeleteSingleton : {
      DeleteSingletonNode *node_real = (DeleteSingletonNode *)node_ptr.get();
     
        switch((node_real->node)->type){
case JITD_NODE_DeleteSingleton :{
DeleteSingletonNode *child_node_real =(DeleteSingletonNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_DeleteElements :{
DeleteElementsNode *child_node_real =(DeleteElementsNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_BTree :{
BTreeNode *child_node_real =(BTreeNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Concat :{
ConcatNode *child_node_real =(ConcatNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_SortedArray :{
SortedArrayNode *child_node_real =(SortedArrayNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Array :{
ArrayNode *child_node_real =(ArrayNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Singleton :{
SingletonNode *child_node_real =(SingletonNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
}

      
           
        
      break;
    }

  
    case JITD_NODE_DeleteElements : {
      DeleteElementsNode *node_real = (DeleteElementsNode *)node_ptr.get();
     
        switch((node_real->node)->type){
case JITD_NODE_DeleteSingleton :{
DeleteSingletonNode *child_node_real =(DeleteSingletonNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_DeleteElements :{
DeleteElementsNode *child_node_real =(DeleteElementsNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_BTree :{
BTreeNode *child_node_real =(BTreeNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Concat :{
ConcatNode *child_node_real =(ConcatNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_SortedArray :{
SortedArrayNode *child_node_real =(SortedArrayNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Array :{
ArrayNode *child_node_real =(ArrayNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Singleton :{
SingletonNode *child_node_real =(SingletonNode*)(node_real->node).get();
child_node_real->parent = parent;
break;}
}

      
           
        
      break;
    }

  
    case JITD_NODE_BTree : {
      BTreeNode *node_real = (BTreeNode *)node_ptr.get();
     
        switch((node_real->lhs)->type){
case JITD_NODE_DeleteSingleton :{
DeleteSingletonNode *child_node_real =(DeleteSingletonNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_DeleteElements :{
DeleteElementsNode *child_node_real =(DeleteElementsNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_BTree :{
BTreeNode *child_node_real =(BTreeNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Concat :{
ConcatNode *child_node_real =(ConcatNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_SortedArray :{
SortedArrayNode *child_node_real =(SortedArrayNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Array :{
ArrayNode *child_node_real =(ArrayNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Singleton :{
SingletonNode *child_node_real =(SingletonNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
}
switch((node_real->rhs)->type){
case JITD_NODE_DeleteSingleton :{
DeleteSingletonNode *child_node_real =(DeleteSingletonNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_DeleteElements :{
DeleteElementsNode *child_node_real =(DeleteElementsNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_BTree :{
BTreeNode *child_node_real =(BTreeNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Concat :{
ConcatNode *child_node_real =(ConcatNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_SortedArray :{
SortedArrayNode *child_node_real =(SortedArrayNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Array :{
ArrayNode *child_node_real =(ArrayNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Singleton :{
SingletonNode *child_node_real =(SingletonNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
}

      
           
        
      break;
    }

  
    case JITD_NODE_Concat : {
      ConcatNode *node_real = (ConcatNode *)node_ptr.get();
     
        switch((node_real->lhs)->type){
case JITD_NODE_DeleteSingleton :{
DeleteSingletonNode *child_node_real =(DeleteSingletonNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_DeleteElements :{
DeleteElementsNode *child_node_real =(DeleteElementsNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_BTree :{
BTreeNode *child_node_real =(BTreeNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Concat :{
ConcatNode *child_node_real =(ConcatNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_SortedArray :{
SortedArrayNode *child_node_real =(SortedArrayNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Array :{
ArrayNode *child_node_real =(ArrayNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Singleton :{
SingletonNode *child_node_real =(SingletonNode*)(node_real->lhs).get();
child_node_real->parent = parent;
break;}
}
switch((node_real->rhs)->type){
case JITD_NODE_DeleteSingleton :{
DeleteSingletonNode *child_node_real =(DeleteSingletonNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_DeleteElements :{
DeleteElementsNode *child_node_real =(DeleteElementsNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_BTree :{
BTreeNode *child_node_real =(BTreeNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Concat :{
ConcatNode *child_node_real =(ConcatNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_SortedArray :{
SortedArrayNode *child_node_real =(SortedArrayNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Array :{
ArrayNode *child_node_real =(ArrayNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
case JITD_NODE_Singleton :{
SingletonNode *child_node_real =(SingletonNode*)(node_real->rhs).get();
child_node_real->parent = parent;
break;}
}

      
           
        
      break;
    }

  
    case JITD_NODE_SortedArray : {
      SortedArrayNode *node_real = (SortedArrayNode *)node_ptr.get();
     
        
      
           
        
      break;
    }

  
    case JITD_NODE_Array : {
      ArrayNode *node_real = (ArrayNode *)node_ptr.get();
     
        
      
           
        
      break;
    }

  
    case JITD_NODE_Singleton : {
      SingletonNode *node_real = (SingletonNode *)node_ptr.get();
     
        
      
           
        
      break;
    }

  

  }
  }
/*
void JITD::fixMap(std::shared_ptr<JITDNode>* node_handle,std::shared_ptr<JITDNode>* parent)
{
  std::shared_ptr<JITDNode> node_ptr;
    #ifdef ATOMIC_LOAD
    node_ptr = std::atomic_load((node_handle));
    #endif
    #ifdef ATOMIC_LOAD_CONSUME
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_consume);
    #endif
    #ifdef ATOMIC_LOAD_ACQUIRE
    node_ptr = std::atomic_load_explicit(node_handle,std::memory_order_acquire);
    #endif
  //std::shared_ptr<JITDNode> node_ptr = std::atomic_load((node_handle));
  switch((node_ptr)->type){
  
    case JITD_NODE_DeleteSingleton : {
      DeleteSingletonNode *node_real = (DeleteSingletonNode *)node_ptr.get();
      std::unordered_multimap <std::shared_ptr<JITDNode> *, std::shared_ptr<JITDNode> *> :: iterator iter;

      iter = this->childParentMap.find(&(node_real->node));
if(iter!=this->childParentMap.end()){
iter->second = parent;
}

      break;
    }

  
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
*/
///////////////////// Debugging Utilities ///////////////////// 
void JITD::times_transforms_called()
{
  
    std::cout<<"The transform DeleteElemFromSingleton was called "<< DeleteElemFromSingleton_count<<" times"<<std::endl;
  
    std::cout<<"The transform DeleteKeyFromSingleton was called "<< DeleteKeyFromSingleton_count<<" times"<<std::endl;
  
    std::cout<<"The transform DeleteSingletonFromArray was called "<< DeleteSingletonFromArray_count<<" times"<<std::endl;
  
    std::cout<<"The transform DeleteElemFromArray was called "<< DeleteElemFromArray_count<<" times"<<std::endl;
  
    std::cout<<"The transform PushDownDontDeleteSingletonBtreeRight was called "<< PushDownDontDeleteSingletonBtreeRight_count<<" times"<<std::endl;
  
    std::cout<<"The transform PushDownDontDeleteSingletonBtreeLeft was called "<< PushDownDontDeleteSingletonBtreeLeft_count<<" times"<<std::endl;
  
    std::cout<<"The transform PushDownDontDeleteElemBtree was called "<< PushDownDontDeleteElemBtree_count<<" times"<<std::endl;
  
    std::cout<<"The transform PushDownSingletonRight was called "<< PushDownSingletonRight_count<<" times"<<std::endl;
  
    std::cout<<"The transform PushDownSingletonLeft was called "<< PushDownSingletonLeft_count<<" times"<<std::endl;
  
    std::cout<<"The transform CrackArray was called "<< CrackArray_count<<" times"<<std::endl;
  
    std::cout<<"The transform SortArray was called "<< SortArray_count<<" times"<<std::endl;
  
}
std::shared_ptr<JITD> assemble_jitd(std::istream &in)
{
  std::string op, line;

  std::stack<std::shared_ptr<JITDNode>> node_stack;
  std::shared_ptr<JITDNode> jitd_root_handle;
  while(getline(in, line)){
    std::basic_istringstream<char> toks(line);
    int columns = 0;
    toks >> op;
    
      if(op == "DeleteSingleton"){
        

          // Construct a elem
          long elem;
          elem = load_key(toks);
        

          // Construct a node
          std::shared_ptr<JITDNode> node;
          node = node_stack.top(); node_stack.pop();
        

        // Assemble everything into a DeleteSingleton
        node_stack.emplace(new DeleteSingletonNode(node, elem));
      

      } else 
    
      if(op == "DeleteElements"){
        

          // Construct a data
          std::vector<long> data;
          std::cout << "Unsupported generator field type: TArray(key)" << std::endl; exit(-1);
        

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
          load_records_from_file_ycsb(data, toks,columns);
        

        // Assemble everything into a SortedArray
        node_stack.emplace(new SortedArrayNode(data));
      

      } else 
    
      if(op == "Array"){
        

          // Construct a data
          std::vector<Record> data;
          load_records_from_file_ycsb(data, toks,columns);
        

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
{/*
      std::set<std::shared_ptr<JITDNode> *>::iterator it;
      
        std::cout<<"SIZE OF DeleteElemFromSingleton View"<<DeleteElemFromSingleton_View.size()<<"."<<std::endl;
        for(it = this->DeleteElemFromSingleton_View.begin();it!=this->DeleteElemFromSingleton_View.end();++it)
        {
        
          

          std::shared_ptr<JITDNode> * curr = *it;
          std::cout<<"Address of shared_ptr: "<<*curr<<std::endl;

          
          

        }
      
        std::cout<<"SIZE OF DeleteKeyFromSingleton View"<<DeleteKeyFromSingleton_View.size()<<"."<<std::endl;
        for(it = this->DeleteKeyFromSingleton_View.begin();it!=this->DeleteKeyFromSingleton_View.end();++it)
        {
        
          

          std::shared_ptr<JITDNode> * curr = *it;
          std::cout<<"Address of shared_ptr: "<<*curr<<std::endl;

          
          

        }
      
        std::cout<<"SIZE OF DeleteSingletonFromArray View"<<DeleteSingletonFromArray_View.size()<<"."<<std::endl;
        for(it = this->DeleteSingletonFromArray_View.begin();it!=this->DeleteSingletonFromArray_View.end();++it)
        {
        
          

          std::shared_ptr<JITDNode> * curr = *it;
          std::cout<<"Address of shared_ptr: "<<*curr<<std::endl;

          
          

        }
      
        std::cout<<"SIZE OF DeleteElemFromArray View"<<DeleteElemFromArray_View.size()<<"."<<std::endl;
        for(it = this->DeleteElemFromArray_View.begin();it!=this->DeleteElemFromArray_View.end();++it)
        {
        
          

          std::shared_ptr<JITDNode> * curr = *it;
          std::cout<<"Address of shared_ptr: "<<*curr<<std::endl;

          
          

        }
      
        std::cout<<"SIZE OF PushDownDontDeleteSingletonBtreeRight View"<<PushDownDontDeleteSingletonBtreeRight_View.size()<<"."<<std::endl;
        for(it = this->PushDownDontDeleteSingletonBtreeRight_View.begin();it!=this->PushDownDontDeleteSingletonBtreeRight_View.end();++it)
        {
        
          

          std::shared_ptr<JITDNode> * curr = *it;
          std::cout<<"Address of shared_ptr: "<<*curr<<std::endl;

          
          

        }
      
        std::cout<<"SIZE OF PushDownDontDeleteSingletonBtreeLeft View"<<PushDownDontDeleteSingletonBtreeLeft_View.size()<<"."<<std::endl;
        for(it = this->PushDownDontDeleteSingletonBtreeLeft_View.begin();it!=this->PushDownDontDeleteSingletonBtreeLeft_View.end();++it)
        {
        
          

          std::shared_ptr<JITDNode> * curr = *it;
          std::cout<<"Address of shared_ptr: "<<*curr<<std::endl;

          
          

        }
      
        std::cout<<"SIZE OF PushDownDontDeleteElemBtree View"<<PushDownDontDeleteElemBtree_View.size()<<"."<<std::endl;
        for(it = this->PushDownDontDeleteElemBtree_View.begin();it!=this->PushDownDontDeleteElemBtree_View.end();++it)
        {
        
          

          std::shared_ptr<JITDNode> * curr = *it;
          std::cout<<"Address of shared_ptr: "<<*curr<<std::endl;

          
          

        }
      
        std::cout<<"SIZE OF PushDownSingletonRight View"<<PushDownSingletonRight_View.size()<<"."<<std::endl;
        for(it = this->PushDownSingletonRight_View.begin();it!=this->PushDownSingletonRight_View.end();++it)
        {
        
          

          std::shared_ptr<JITDNode> * curr = *it;
          std::cout<<"Address of shared_ptr: "<<*curr<<std::endl;

          
          

        }
      
        std::cout<<"SIZE OF PushDownSingletonLeft View"<<PushDownSingletonLeft_View.size()<<"."<<std::endl;
        for(it = this->PushDownSingletonLeft_View.begin();it!=this->PushDownSingletonLeft_View.end();++it)
        {
        
          

          std::shared_ptr<JITDNode> * curr = *it;
          std::cout<<"Address of shared_ptr: "<<*curr<<std::endl;

          
          

        }
      
        std::cout<<"SIZE OF CrackArray View"<<CrackArray_View.size()<<"."<<std::endl;
        for(it = this->CrackArray_View.begin();it!=this->CrackArray_View.end();++it)
        {
        
          

          std::shared_ptr<JITDNode> * curr = *it;
          std::cout<<"Address of shared_ptr: "<<*curr<<std::endl;

          
          

        }
      
        std::cout<<"SIZE OF SortArray View"<<SortArray_View.size()<<"."<<std::endl;
        for(it = this->SortArray_View.begin();it!=this->SortArray_View.end();++it)
        {
        
          

          std::shared_ptr<JITDNode> * curr = *it;
          std::cout<<"Address of shared_ptr: "<<*curr<<std::endl;

          
          

        }
      */
      
}
/*
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
              
                case JITD_NODE_DeleteSingleton : {
                  DeleteSingletonNode *node_real = (DeleteSingletonNode *)node.get();
                  std::cout <<itr->first<< ":DeleteSingleton(addr:"<<node_real<<")-> ";
                  break;
                }
              
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
              
                case JITD_NODE_DeleteSingleton : {
                  DeleteSingletonNode *parent_real = (DeleteSingletonNode *)parent.get();
                  std::cout <<itr->second<<'\t'<< ":DeleteSingleton(addr:"<<parent_real<<") "<<'\n';
                  break;
                }
              
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
*/
void JITD::jitd_node_count(std::shared_ptr<JITDNode> node){ 
  
  switch(node->type){
    
      case JITD_NODE_DeleteSingleton : {
        DeleteSingletonNode *node_real = (DeleteSingletonNode *)node.get();
        this->node_count++;

        jitd_node_count(node_real->node);
 
        break;
      }
    
      case JITD_NODE_DeleteElements : {
        DeleteElementsNode *node_real = (DeleteElementsNode *)node.get();
        this->node_count++;

        jitd_node_count(node_real->node);
 
        break;
      }
    
      case JITD_NODE_BTree : {
        BTreeNode *node_real = (BTreeNode *)node.get();
        this->node_count++;

        jitd_node_count(node_real->lhs);
jitd_node_count(node_real->rhs);
 
        break;
      }
    
      case JITD_NODE_Concat : {
        ConcatNode *node_real = (ConcatNode *)node.get();
        this->node_count++;

        jitd_node_count(node_real->lhs);
jitd_node_count(node_real->rhs);
 
        break;
      }
    
      case JITD_NODE_SortedArray : {
        SortedArrayNode *node_real = (SortedArrayNode *)node.get();
        this->node_count++;

         
        break;
      }
    
      case JITD_NODE_Array : {
        ArrayNode *node_real = (ArrayNode *)node.get();
        this->node_count++;

         
        break;
      }
    
      case JITD_NODE_Singleton : {
        SingletonNode *node_real = (SingletonNode *)node.get();
        this->node_count++;

         
        break;
      }
    
  }
  
}
void print_JITD_node_structure(std::shared_ptr<JITDNode> node, const std::string &prefix){ 
  
  switch(node->type){
    
      case JITD_NODE_DeleteSingleton : {
        DeleteSingletonNode *node_real = (DeleteSingletonNode *)node.get();
        std::cout << prefix << "DeleteSingleton(addr:"<<node_real<<",Parent:"<<node_real->parent<<")[ "
        << "elem=" << node_real->elem;

        std::cout << std::endl;
print_JITD_node_structure(node_real->node, prefix+std::string("  "));
std::cout << prefix; 
        std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_DeleteElements : {
        DeleteElementsNode *node_real = (DeleteElementsNode *)node.get();
        std::cout << prefix << "DeleteElements(addr:"<<node_real<<",Parent:"<<node_real->parent<<")[ "
        << "data=" << node_real->data.size() << " elements";

        std::cout << std::endl;
print_JITD_node_structure(node_real->node, prefix+std::string("  "));
std::cout << prefix; 
        std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_BTree : {
        BTreeNode *node_real = (BTreeNode *)node.get();
        std::cout << prefix << "BTree(addr:"<<node_real<<",Parent:"<<node_real->parent<<")[ "
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
        std::cout << prefix << "Concat(addr:"<<node_real<<",Parent:"<<node_real->parent<<")[ "
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
        std::cout << prefix << "SortedArray(addr:"<<node_real<<",Parent:"<<node_real->parent<<")[ "
        << "data=" << node_real->data.size() << " elements";

         
        std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_Array : {
        ArrayNode *node_real = (ArrayNode *)node.get();
        std::cout << prefix << "Array(addr:"<<node_real<<",Parent:"<<node_real->parent<<")[ "
        << "data=" << node_real->data.size() << " elements";

         
        std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_Singleton : {
        SingletonNode *node_real = (SingletonNode *)node.get();
        std::cout << prefix << "Singleton(addr:"<<node_real<<",Parent:"<<node_real->parent<<")[ "
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
  
    case JITD_NODE_DeleteSingleton : {
        DeleteSingletonNode *node_real = (DeleteSingletonNode *)node.get();
        jitd_get_depth(node_real->node,++depth,maxdepth);
if(depth > maxdepth){
maxdepth = depth;
}

        break; 
      }
    
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
    
      case JITD_NODE_DeleteSingleton : {
        DeleteSingletonNode *node_real = (DeleteSingletonNode *)node.get();
        switch(parent->type){
          
          case JITD_NODE_DeleteSingleton : {
              std::cout << "DeleteSingleton(addr:"<<node_real<<")[] -> ";

          break;}

          
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

        std::cout << "DeleteSingleton(addr:"<<node_real<<")[] "<<std::endl;
        

        std::cout << std::endl;
print_JITD_node_structure_viz(node_real->node,node);
 
        //std::cout << " ]" << std::endl;
        break;
      }
    
      case JITD_NODE_DeleteElements : {
        DeleteElementsNode *node_real = (DeleteElementsNode *)node.get();
        switch(parent->type){
          
          case JITD_NODE_DeleteSingleton : {
              std::cout << "DeleteSingleton(addr:"<<node_real<<")[] -> ";

          break;}

          
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
          
          case JITD_NODE_DeleteSingleton : {
              std::cout << "DeleteSingleton(addr:"<<node_real<<")[] -> ";

          break;}

          
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
          
          case JITD_NODE_DeleteSingleton : {
              std::cout << "DeleteSingleton(addr:"<<node_real<<")[] -> ";

          break;}

          
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
          
          case JITD_NODE_DeleteSingleton : {
              std::cout << "DeleteSingleton(addr:"<<node_real<<")[] -> ";

          break;}

          
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
          
          case JITD_NODE_DeleteSingleton : {
              std::cout << "DeleteSingleton(addr:"<<node_real<<")[] -> ";

          break;}

          
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
          
          case JITD_NODE_DeleteSingleton : {
              std::cout << "DeleteSingleton(addr:"<<node_real<<")[] -> ";

          break;}

          
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
