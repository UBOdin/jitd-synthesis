
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
            /*** onRewrite1 ***/
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
            /*** onRewrite2 ***/
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

bool JITD::DeleteKeyFromSingleton(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::DeleteKeyFromSingleton"<<std::endl;*/
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
            /*** onRewrite1 ***/
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
            /*** onRewrite2 ***/
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

bool JITD::DeleteSingletonFromArray(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::DeleteSingletonFromArray"<<std::endl;*/
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
            /*** onRewrite1 ***/
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
            /*** onRewrite2 ***/
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

bool JITD::DeleteElemFromArray(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::DeleteElemFromArray"<<std::endl;*/
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
            /*** onRewrite1 ***/
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
            /*** onRewrite2 ***/
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

bool JITD::PushDownDontDeleteSingletonBtreeRight(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownDontDeleteSingletonBtreeRight"<<std::endl;*/
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
            /*** onRewrite1 ***/
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
            /*** onRewrite2 ***/
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

bool JITD::PushDownDontDeleteSingletonBtreeLeft(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownDontDeleteSingletonBtreeLeft"<<std::endl;*/
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
            /*** onRewrite1 ***/
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
            /*** onRewrite2 ***/
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

bool JITD::PushDownDontDeleteElemBtree(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownDontDeleteElemBtree"<<std::endl;*/
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
            /*** onRewrite1 ***/
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
            /*** onRewrite2 ***/
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

bool JITD::PushDownSingletonRight(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownSingletonRight"<<std::endl;*/
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
                /*** onRewrite1 ***/
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
                /*** onRewrite2 ***/
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

bool JITD::PushDownSingletonLeft(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownSingletonLeft"<<std::endl;*/
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
                /*** onRewrite1 ***/
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
                /*** onRewrite2 ***/
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

bool JITD::PushDownAndCrack(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownAndCrack"<<std::endl;*/
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
          // Extract &(target_root->rhs) into Array
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
            case JITD_NODE_Array:{
              ArrayNode *target_root_rhs = (ArrayNode *)(target_root_rhs_lock).get();
              {
                /*** onRewrite1 ***/
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
                #ifdef ATOMIC_STORE
                std::atomic_store(target, to_ptr_ref);
                #endif
                #ifdef ATOMIC_STORE_RELEASE
                std::atomic_store_explicit(target, to_ptr_ref,std::memory_order_release);
                #endif
                /*** onRewrite2 ***/
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

bool JITD::CrackArray(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::CrackArray"<<std::endl;*/
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
        /*** onRewrite1 ***/
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
        /*** onRewrite2 ***/
        return true;
      }
    }; break;
    default: { //target_root is not a Array
      return false;
    }; break;
  }

}

bool JITD::SortArray(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::SortArray"<<std::endl;*/
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
        /*** onRewrite1 ***/
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
        /*** onRewrite2 ***/
        return true;
      }
    }; break;
    default: { //target_root is not a Array
      return false;
    }; break;
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
    DeleteSingletonNode *cast_root = (DeleteSingletonNode*)((cq_elem.second)->get());
    /*** onRewrite2 ***/
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
    DeleteElementsNode *cast_root = (DeleteElementsNode*)((cq_elem.second)->get());
    /*** onRewrite2 ***/
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
    ConcatNode *cast_root = (ConcatNode*)((cq_elem.second)->get());
    /*** onRewrite2 ***/
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
    ConcatNode *cast_root = (ConcatNode*)((cq_elem.second)->get());
    /*** onRewrite2 ***/
  }

}


///////////////////// OnMatch Transforms /////////////////////


///////////////////// Policy Implementation ///////////////////// 


  long JITD::searchForPushDownSingletonLeft( 
  std::shared_ptr<JITDNode> * &node,         // Return the "best" score available
    std::shared_ptr<JITDNode> * &targetHandleRef     // Return value: The pointer with the "best" 
  ) {
    std::shared_ptr<JITDNode> lock = std::atomic_load(node);
    JITDNode *lock_raw = lock.get();

    long best_score = -1;
    long child_score = -1;
    std::shared_ptr<JITDNode> child_target;
    std::shared_ptr<JITDNode> * child_targetHandleRef;
    


    do {
      

      if(lock_raw->type != JITD_NODE_Concat){break; }
ConcatNode *lock_raw_real = (ConcatNode *)lock_raw;
JITDNode *lock_raw_real_lhs = lock_raw_real->lhs.get();
if(lock_raw_real_lhs->type != JITD_NODE_BTree){break; }
BTreeNode *lock_raw_real_lhs_real = (BTreeNode *)lock_raw_real_lhs;
JITDNode *lock_raw_real_rhs = lock_raw_real->rhs.get();
if(lock_raw_real_rhs->type != JITD_NODE_Singleton){break; }
SingletonNode *lock_raw_real_rhs_real = (SingletonNode *)lock_raw_real_rhs;


      

      if((key_cmp((lock_raw_real_rhs_real->elem), (lock_raw_real_lhs_real->sep))) == (true)){

        best_score = 0;
          //std::cout<<"Getting best score as "<<best_score<<std::endl;
        targetHandleRef = (node);
        return best_score;
        

      }
    } while(false);

    

    switch(lock_raw->type){
      
        case JITD_NODE_DeleteSingleton: {
          DeleteSingletonNode *real_node = (DeleteSingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForPushDownSingletonLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_DeleteElements: {
          DeleteElementsNode *real_node = (DeleteElementsNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForPushDownSingletonLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_BTree: {
          BTreeNode *real_node = (BTreeNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForPushDownSingletonLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForPushDownSingletonLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_Concat: {
          ConcatNode *real_node = (ConcatNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForPushDownSingletonLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForPushDownSingletonLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_SortedArray: {
          SortedArrayNode *real_node = (SortedArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Array: {
          ArrayNode *real_node = (ArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Singleton: {
          SingletonNode *real_node = (SingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
    }

    return best_score;
  }

  long JITD::searchForPushDownSingletonRight( 
  std::shared_ptr<JITDNode> * &node,         // Return the "best" score available
    std::shared_ptr<JITDNode> * &targetHandleRef     // Return value: The pointer with the "best" 
  ) {
    std::shared_ptr<JITDNode> lock = std::atomic_load(node);
    JITDNode *lock_raw = lock.get();

    long best_score = -1;
    long child_score = -1;
    std::shared_ptr<JITDNode> child_target;
    std::shared_ptr<JITDNode> * child_targetHandleRef;
    


    do {
      

      if(lock_raw->type != JITD_NODE_Concat){break; }
ConcatNode *lock_raw_real = (ConcatNode *)lock_raw;
JITDNode *lock_raw_real_lhs = lock_raw_real->lhs.get();
if(lock_raw_real_lhs->type != JITD_NODE_BTree){break; }
BTreeNode *lock_raw_real_lhs_real = (BTreeNode *)lock_raw_real_lhs;
JITDNode *lock_raw_real_rhs = lock_raw_real->rhs.get();
if(lock_raw_real_rhs->type != JITD_NODE_Singleton){break; }
SingletonNode *lock_raw_real_rhs_real = (SingletonNode *)lock_raw_real_rhs;


      

      if((key_cmp((lock_raw_real_rhs_real->elem), (lock_raw_real_lhs_real->sep))) == (false)){

        best_score = 0;
          //std::cout<<"Getting best score as "<<best_score<<std::endl;
        targetHandleRef = (node);
        return best_score;
        

      }
    } while(false);

    

    switch(lock_raw->type){
      
        case JITD_NODE_DeleteSingleton: {
          DeleteSingletonNode *real_node = (DeleteSingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForPushDownSingletonRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_DeleteElements: {
          DeleteElementsNode *real_node = (DeleteElementsNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForPushDownSingletonRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_BTree: {
          BTreeNode *real_node = (BTreeNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForPushDownSingletonRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForPushDownSingletonRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_Concat: {
          ConcatNode *real_node = (ConcatNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForPushDownSingletonRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForPushDownSingletonRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_SortedArray: {
          SortedArrayNode *real_node = (SortedArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Array: {
          ArrayNode *real_node = (ArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Singleton: {
          SingletonNode *real_node = (SingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
    }

    return best_score;
  }

  long JITD::searchForPushDownDontDeleteSingletonBtreeLeft( 
  std::shared_ptr<JITDNode> * &node,         // Return the "best" score available
    std::shared_ptr<JITDNode> * &targetHandleRef     // Return value: The pointer with the "best" 
  ) {
    std::shared_ptr<JITDNode> lock = std::atomic_load(node);
    JITDNode *lock_raw = lock.get();

    long best_score = -1;
    long child_score = -1;
    std::shared_ptr<JITDNode> child_target;
    std::shared_ptr<JITDNode> * child_targetHandleRef;
    


    do {
      

      if(lock_raw->type != JITD_NODE_DeleteSingleton){break; }
DeleteSingletonNode *lock_raw_real = (DeleteSingletonNode *)lock_raw;
JITDNode *lock_raw_real_node = lock_raw_real->node.get();
if(lock_raw_real_node->type != JITD_NODE_BTree){break; }
BTreeNode *lock_raw_real_node_real = (BTreeNode *)lock_raw_real_node;


      

      if((keys_cmp((lock_raw_real->elem), (lock_raw_real_node_real->sep))) == (true)){

        best_score = 0;
          //std::cout<<"Getting best score as "<<best_score<<std::endl;
        targetHandleRef = (node);
        return best_score;
        

      }
    } while(false);

    

    switch(lock_raw->type){
      
        case JITD_NODE_DeleteSingleton: {
          DeleteSingletonNode *real_node = (DeleteSingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForPushDownDontDeleteSingletonBtreeLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_DeleteElements: {
          DeleteElementsNode *real_node = (DeleteElementsNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForPushDownDontDeleteSingletonBtreeLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_BTree: {
          BTreeNode *real_node = (BTreeNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForPushDownDontDeleteSingletonBtreeLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForPushDownDontDeleteSingletonBtreeLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_Concat: {
          ConcatNode *real_node = (ConcatNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForPushDownDontDeleteSingletonBtreeLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForPushDownDontDeleteSingletonBtreeLeft(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_SortedArray: {
          SortedArrayNode *real_node = (SortedArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Array: {
          ArrayNode *real_node = (ArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Singleton: {
          SingletonNode *real_node = (SingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
    }

    return best_score;
  }

  long JITD::searchForPushDownDontDeleteSingletonBtreeRight( 
  std::shared_ptr<JITDNode> * &node,         // Return the "best" score available
    std::shared_ptr<JITDNode> * &targetHandleRef     // Return value: The pointer with the "best" 
  ) {
    std::shared_ptr<JITDNode> lock = std::atomic_load(node);
    JITDNode *lock_raw = lock.get();

    long best_score = -1;
    long child_score = -1;
    std::shared_ptr<JITDNode> child_target;
    std::shared_ptr<JITDNode> * child_targetHandleRef;
    


    do {
      

      if(lock_raw->type != JITD_NODE_DeleteSingleton){break; }
DeleteSingletonNode *lock_raw_real = (DeleteSingletonNode *)lock_raw;
JITDNode *lock_raw_real_node = lock_raw_real->node.get();
if(lock_raw_real_node->type != JITD_NODE_BTree){break; }
BTreeNode *lock_raw_real_node_real = (BTreeNode *)lock_raw_real_node;


      

      if((keys_cmp((lock_raw_real->elem), (lock_raw_real_node_real->sep))) == (false)){

        best_score = 0;
          //std::cout<<"Getting best score as "<<best_score<<std::endl;
        targetHandleRef = (node);
        return best_score;
        

      }
    } while(false);

    

    switch(lock_raw->type){
      
        case JITD_NODE_DeleteSingleton: {
          DeleteSingletonNode *real_node = (DeleteSingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForPushDownDontDeleteSingletonBtreeRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_DeleteElements: {
          DeleteElementsNode *real_node = (DeleteElementsNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForPushDownDontDeleteSingletonBtreeRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_BTree: {
          BTreeNode *real_node = (BTreeNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForPushDownDontDeleteSingletonBtreeRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForPushDownDontDeleteSingletonBtreeRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_Concat: {
          ConcatNode *real_node = (ConcatNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForPushDownDontDeleteSingletonBtreeRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForPushDownDontDeleteSingletonBtreeRight(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_SortedArray: {
          SortedArrayNode *real_node = (SortedArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Array: {
          ArrayNode *real_node = (ArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Singleton: {
          SingletonNode *real_node = (SingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
    }

    return best_score;
  }

  long JITD::searchForPushDownDontDeleteElemBtree( 
  std::shared_ptr<JITDNode> * &node,         // Return the "best" score available
    std::shared_ptr<JITDNode> * &targetHandleRef     // Return value: The pointer with the "best" 
  ) {
    std::shared_ptr<JITDNode> lock = std::atomic_load(node);
    JITDNode *lock_raw = lock.get();

    long best_score = -1;
    long child_score = -1;
    std::shared_ptr<JITDNode> child_target;
    std::shared_ptr<JITDNode> * child_targetHandleRef;
    


    do {
      

      if(lock_raw->type != JITD_NODE_DeleteElements){break; }
DeleteElementsNode *lock_raw_real = (DeleteElementsNode *)lock_raw;
JITDNode *lock_raw_real_node = lock_raw_real->node.get();
if(lock_raw_real_node->type != JITD_NODE_BTree){break; }
BTreeNode *lock_raw_real_node_real = (BTreeNode *)lock_raw_real_node;


      

      if(true){

        best_score = 0;
          //std::cout<<"Getting best score as "<<best_score<<std::endl;
        targetHandleRef = (node);
        return best_score;
        

      }
    } while(false);

    

    switch(lock_raw->type){
      
        case JITD_NODE_DeleteSingleton: {
          DeleteSingletonNode *real_node = (DeleteSingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForPushDownDontDeleteElemBtree(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_DeleteElements: {
          DeleteElementsNode *real_node = (DeleteElementsNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForPushDownDontDeleteElemBtree(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_BTree: {
          BTreeNode *real_node = (BTreeNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForPushDownDontDeleteElemBtree(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForPushDownDontDeleteElemBtree(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_Concat: {
          ConcatNode *real_node = (ConcatNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForPushDownDontDeleteElemBtree(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForPushDownDontDeleteElemBtree(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_SortedArray: {
          SortedArrayNode *real_node = (SortedArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Array: {
          ArrayNode *real_node = (ArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Singleton: {
          SingletonNode *real_node = (SingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
    }

    return best_score;
  }

  long JITD::searchForCrackArray( 
  std::shared_ptr<JITDNode> * &node,         // Return the "best" score available
    std::shared_ptr<JITDNode> * &targetHandleRef     // Return value: The pointer with the "best" 
  ) {
    std::shared_ptr<JITDNode> lock = std::atomic_load(node);
    JITDNode *lock_raw = lock.get();

    long best_score = -1;
    long child_score = -1;
    std::shared_ptr<JITDNode> child_target;
    std::shared_ptr<JITDNode> * child_targetHandleRef;
    


    do {
      

      if(lock_raw->type != JITD_NODE_Array){break; }
ArrayNode *lock_raw_real = (ArrayNode *)lock_raw;


      

      if((array_size((lock_raw_real->data))) > (10)){

        best_score = 0;
          //std::cout<<"Getting best score as "<<best_score<<std::endl;
        targetHandleRef = (node);
        return best_score;
        

      }
    } while(false);

    

    switch(lock_raw->type){
      
        case JITD_NODE_DeleteSingleton: {
          DeleteSingletonNode *real_node = (DeleteSingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForCrackArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_DeleteElements: {
          DeleteElementsNode *real_node = (DeleteElementsNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->node);
            child_score = searchForCrackArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_BTree: {
          BTreeNode *real_node = (BTreeNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForCrackArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForCrackArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_Concat: {
          ConcatNode *real_node = (ConcatNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          real_nodeHandleRef = &(real_node->lhs);
            child_score = searchForCrackArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForCrackArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          break;
        }
      
        case JITD_NODE_SortedArray: {
          SortedArrayNode *real_node = (SortedArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Array: {
          ArrayNode *real_node = (ArrayNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
        case JITD_NODE_Singleton: {
          SingletonNode *real_node = (SingletonNode *)lock_raw;
          std::shared_ptr<JITDNode> * real_nodeHandleRef;
          
          break;
        }
      
    }

    return best_score;
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

bool JITD::do_organize()
{
  
  



{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForPushDownSingletonLeft" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForPushDownSingletonLeft(
    (this->root),targetHandleRef
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
    (this->root),targetHandleRef
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
  //std::cout<<"Before calling searchForPushDownDontDeleteSingletonBtreeLeft" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForPushDownDontDeleteSingletonBtreeLeft(
    (this->root),targetHandleRef
  );
  //std::cout<<"After calling searchForPushDownDontDeleteSingletonBtreeLeft Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
    //std::cout<<"Candidate shared_ptr for PushDownDontDeleteSingletonBtreeLeft: "<<(*targetHandleRef)<<std::endl;
    
      #ifdef TRANSFORM_COUNT
    PushDownDontDeleteSingletonBtreeLeft_count++;
    #endif
      PushDownDontDeleteSingletonBtreeLeft(targetHandleRef);
    
    return true;

  } 
  
  
  
  else { 
     
  }







}


    



{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForPushDownDontDeleteSingletonBtreeRight" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForPushDownDontDeleteSingletonBtreeRight(
    (this->root),targetHandleRef
  );
  //std::cout<<"After calling searchForPushDownDontDeleteSingletonBtreeRight Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
    //std::cout<<"Candidate shared_ptr for PushDownDontDeleteSingletonBtreeRight: "<<(*targetHandleRef)<<std::endl;
    
      #ifdef TRANSFORM_COUNT
    PushDownDontDeleteSingletonBtreeRight_count++;
    #endif
      PushDownDontDeleteSingletonBtreeRight(targetHandleRef);
    
    return true;

  } 
  
  
  
  else { 
     
  }







}


    



{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForPushDownDontDeleteElemBtree" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForPushDownDontDeleteElemBtree(
    (this->root),targetHandleRef
  );
  //std::cout<<"After calling searchForPushDownDontDeleteElemBtree Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
    //std::cout<<"Candidate shared_ptr for PushDownDontDeleteElemBtree: "<<(*targetHandleRef)<<std::endl;
    
      #ifdef TRANSFORM_COUNT
    PushDownDontDeleteElemBtree_count++;
    #endif
      PushDownDontDeleteElemBtree(targetHandleRef);
    
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
    (this->root),targetHandleRef
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
  
    std::cout<<"The transform PushDownAndCrack was called "<< PushDownAndCrack_count<<" times"<<std::endl;
  
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
          toks >> elem;
        

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
          Key key;
          Record elem;
          toks >> key;
          elem.key = key;

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
/*
bool JITD::jitd_transforms_sanity(std::shared_ptr<JITDNode>* node_ref)
{
  bool matched = false;
  std::shared_ptr<JITDNode> node = std::atomic_load(node_ref);
  switch(node->type){
    
      case JITD_NODE_DeleteSingleton : {
        DeleteSingletonNode *node_real = (DeleteSingletonNode *)node.get();
        matched = this->matchPushDownDontDeleteSingletonBtreeLeft(node_ref);
if(matched == true){return true;}
matched = this->matchPushDownDontDeleteSingletonBtreeRight(node_ref);
if(matched == true){return true;}


        matched = jitd_transforms_sanity(&(node_real->node));
if(matched == true){return(true);}
 
        break;
      }
    
      case JITD_NODE_DeleteElements : {
        DeleteElementsNode *node_real = (DeleteElementsNode *)node.get();
        matched = this->matchPushDownDontDeleteElemBtree(node_ref);
if(matched == true){return true;}


        matched = jitd_transforms_sanity(&(node_real->node));
if(matched == true){return(true);}
 
        break;
      }
    
      case JITD_NODE_BTree : {
        BTreeNode *node_real = (BTreeNode *)node.get();
        

        matched = jitd_transforms_sanity(&(node_real->lhs));
if(matched == true){return(true);}
matched = jitd_transforms_sanity(&(node_real->rhs));
if(matched == true){return(true);}
 
        break;
      }
    
      case JITD_NODE_Concat : {
        ConcatNode *node_real = (ConcatNode *)node.get();
        matched = this->matchPushDownSingletonLeft(node_ref);
if(matched == true){return true;}
matched = this->matchPushDownSingletonRight(node_ref);
if(matched == true){return true;}


        matched = jitd_transforms_sanity(&(node_real->lhs));
if(matched == true){return(true);}
matched = jitd_transforms_sanity(&(node_real->rhs));
if(matched == true){return(true);}
 
        break;
      }
    
      case JITD_NODE_SortedArray : {
        SortedArrayNode *node_real = (SortedArrayNode *)node.get();
        

         
        break;
      }
    
      case JITD_NODE_Array : {
        ArrayNode *node_real = (ArrayNode *)node.get();
        matched = this->matchCrackArray(node_ref);
if(matched == true){return true;}


         
        break;
      }
    
      case JITD_NODE_Singleton : {
        SingletonNode *node_real = (SingletonNode *)node.get();
        

         
        break;
      }
    
  }
  return(matched);
}
*/
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
