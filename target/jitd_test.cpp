
#include <stack>
#include <sstream>
#include "runtime.hpp"
#include "jitd_test.hpp"
#include <thread>
#ifdef RDTSC

#define STORAGE_JITD
#include <mutex>
#include <map>
#include "harness.hpp"

#ifdef REPLAY_TOASTER
#include "../toaster_harness/toaster_maintenance.hpp"
#define REPLAY_DBT
#endif
#ifdef REPLAY_CLASSIC
#include "../toaster_harness/classic_maintenance.hpp"
#define REPLAY_DBT
#endif

#ifdef REPLAY_DBT

#include "program_base.cpp"
#include "event.cpp"
#include "runtime.cpp"
#include "streams.cpp"
#include "iprogram.cpp"
#include "standard_adaptors.cpp"
#include "smhasher/MurmurHash2.cpp"

#endif

uint64_t rdtsc(){
    unsigned int lo,hi;
    __asm__ __volatile__ ("rdtsc" : "=a" (lo), "=d" (hi));
    return ((uint64_t)hi << 32) | lo;
}
long unsigned int sticks, diffticks;

int delta_count = 0;
int ticks_index = 0;
int maint_type;
int trans_index = -1;

std::unordered_map<std::string, int> view_map = { {"DeleteElemFromSingleton", 0},
	{"DeleteKeyFromSingleton", 1}, {"DeleteSingletonFromArray", 2}, {"DeleteElemFromArray", 3},
	{"PushDownDontDeleteSingletonBtreeRight", 4}, {"PushDownDontDeleteSingletonBtreeLeft", 5},
	{"PushDownDontDeleteElemBtree", 6}, {"PushDownSingletonRight", 7}, {"PushDownSingletonLeft", 8},
	{"CrackArray", 9}, {"SortArray", 10}, {"after_remove_singleton", 11},
	{"after_remove_elements", 12}, {"after_insert", 13}, {"after_insert_singleton", 14}, {"PushDownAndCrack", 15} };

#ifdef REPLAY_DBT

namespace dbtoaster { class Custom_toaster : public Program {

	public:

	Custom_toaster(int argc = 0, char* argv[] = 0) : Program(argc, argv) { }

}; }

dbtoaster::Custom_toaster ct;

const QUERY_1_COUNT_map* query_1;
const QUERY_2_COUNT_map* query_2;
const QUERY_3_COUNT_map* query_3;
const QUERY_4_COUNT_map* query_4;
const QUERY_5_COUNT_map* query_5;

#endif

inline void view_end() {

	diffticks = rdtsc() - sticks;
	if (ticks_index >= ticks_size) {
		printf("Error:  view overflow\n");
		_exit(1);
	}
	ticks_array[ticks_index].delta[delta_count] = diffticks;
	delta_count++;
	if (delta_count == 3) {
		delta_count = 0;
		ticks_array[ticks_index].id = ticks_index;
		ticks_array[ticks_index].maint_type = maint_type;
		ticks_index++;
	}

	return;

}

inline void node_end(int node_rw, int node_type) {

	diffticks = rdtsc() - sticks;
	if (ticks_index >= ticks_size) {
		printf("Error:  node overflow\n");
		_exit(1);
	}
	ticks_array[ticks_index].id = ticks_index;
	ticks_array[ticks_index].maint_type = maint_type;
	ticks_array[ticks_index].delta[0] = diffticks;
	ticks_array[ticks_index].trans_id = trans_index;
	ticks_array[ticks_index].node_rw = node_rw;
	ticks_array[ticks_index].node_type = node_type;
	assert(delta_count == 0);
	ticks_index++;

	return;

}

inline void search_end(int search_type) {

	trans_index++;  // NOT ticks_index;

	diffticks = rdtsc() - sticks;
	if (ticks_index >= ticks_size) {
		printf("Error:  search overflow\n");
		_exit(1);
	}
	ticks_array[ticks_index].id = ticks_index;
	ticks_array[ticks_index].maint_type = search_type;
	ticks_array[ticks_index].delta[0] = diffticks;
	ticks_array[ticks_index].trans_id = trans_index;
	assert (delta_count == 0);
	ticks_index++;

	return;

}

// Per-transform timing:  include timing brackets.  Regardless, for the first
// bracket ("_VIEW_START"), fetch transform name:

#if defined REPLAY_NAIVE
#define _VIEW_START
#define VIEW_START
#define VIEW_END
#endif
#if defined REPLAY_SET || defined REPLAY_VIEW
#ifdef PER_TRANS
#define _VIEW_START maint_type = view_map[std::string(__func__)]; \
	trans_index++; \
	sticks = rdtsc();
#define VIEW_START sticks = rdtsc();
#define VIEW_END view_end()
#else
#define _VIEW_START maint_type = view_map[std::string(__func__)]; \
	trans_index++;
#define VIEW_START
#define VIEW_END
#endif
#endif

#ifdef PER_NODE
#define NODE_START \
	JITDNodeType node_type = node_ptr->type; \
	sticks = rdtsc();
#define _NODE_START sticks = rdtsc();
#define NODE_END(node_rw) node_end(node_rw, node_type);
#else
#define NODE_START
#define _NODE_START
#define NODE_END
#endif

#if defined PER_TRANS || defined PER_NODE || defined REPLAY_NAIVE
#define SEARCH_START sticks = rdtsc();
#define SEARCH_END(search_type) search_end(search_type);
#else
#define SEARCH_START
#define SEARCH_END(search_type)
#endif

#if defined REPLAY_VIEW
#if defined REPLAY_JITD
#define _viewErase(foo) (viewErase(foo))
#define _viewAdd(foo) (viewAdd(foo))
#endif
#if defined REPLAY_DBT
#define _viewErase(foo)
#define _viewAdd(foo)
#endif
#endif

#if defined REPLAY_NAIVE
#define _targetHandleRef (this->root),targetHandleRef
#endif
#if defined REPLAY_SET || defined REPLAY_VIEW
#define _targetHandleRef targetHandleRef
#endif

#else

#define _VIEW_START
#define VIEW_START
#define VIEW_END

#define SEARCH_START
#define SEARCH_END(search_type)

#endif

//#define JITD_DEBUG_POLICY true;
//std::shared_ptr<JITDNode> * rootHandleRef;


///////////////////// Transform Definitions ///////////////////// 


bool JITD::DeleteElemFromSingleton(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::DeleteElemFromSingleton"<<std::endl;*/
  {
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
              _viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
              _viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              /*** ParentMaintenance ***/
              setParent(target,parent);
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
              _viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
              _viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              /*** ParentMaintenance ***/
              setParent(target,parent);
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
              this->CrackArray_PQ.erase(&(target_root->node));
              //this->SortArray_PQ.erase(&(target_root->node));
              this->JITD_NODE_DeleteSingleton_set.erase(target);
#endif
#if defined REPLAY_VIEW
              _viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
              this->CrackArray_PQ.emplace(target);
              //this->SortArray_PQ.emplace(target);
#endif
#if defined REPLAY_VIEW
              _viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              /*** ParentMaintenance ***/
              setParent(target,parent);
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
              _viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
              _viewAdd(parent);
              /*** ViewMaintenance ***/
              viewAdd(target);
              /*** ParentMaintenance ***/
              setParent(target,parent);
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
_NODE_START;
              this->JITD_NODE_DeleteSingleton_set.erase(target);
node_end(0, JITD_NODE_DeleteSingleton);
              SetPqErase(&(target_root_node->lhs));
              SetPqErase(&(target_root_node->rhs));
#endif
#if defined REPLAY_VIEW
              _viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
              viewErase(&(target_root_node->lhs));
              viewErase(&(target_root_node->rhs));
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
              SetPqAdd(&(to_ptr->lhs));
_NODE_START;
              this->JITD_NODE_DeleteSingleton_set.emplace(&(to_ptr->rhs));
node_end(1, JITD_NODE_DeleteSingleton);
              SetPqAdd(&(to_ptr_rhs->node));
#endif
#if defined REPLAY_VIEW
              _viewAdd(parent);
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
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
_NODE_START;
              this->JITD_NODE_DeleteSingleton_set.erase(target);
node_end(0, JITD_NODE_DeleteSingleton);
              SetPqErase(&(target_root_node->lhs));
              SetPqErase(&(target_root_node->rhs));
#endif
#if defined REPLAY_VIEW
              _viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
              viewErase(&(target_root_node->lhs));
              viewErase(&(target_root_node->rhs));
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
_NODE_START;
              this->JITD_NODE_DeleteSingleton_set.emplace(&(to_ptr->lhs));
node_end(1, JITD_NODE_DeleteSingleton);
              SetPqAdd(&(to_ptr_lhs->node));
              SetPqAdd(&(to_ptr->rhs));
#endif
#if defined REPLAY_VIEW
              _viewAdd(parent);
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
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
              _viewErase(parent);
              /*** ViewMaintenance ***/
              viewErase(target);
              viewErase(&(target_root->node));
              viewErase(&(target_root_node->lhs));
              viewErase(&(target_root_node->rhs));
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
              _viewAdd(parent);
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
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
_NODE_START;
                  this->JITD_NODE_Concat_set.erase(target);
node_end(0, JITD_NODE_Concat);
                  SetPqErase(&(target_root_lhs->lhs));
                  SetPqErase(&(target_root_lhs->rhs));
#endif
#if defined REPLAY_VIEW
                  _viewErase(parent);
                  /*** ViewMaintenance ***/
                  viewErase(target);
                  viewErase(&(target_root->lhs));
                  viewErase(&(target_root_lhs->lhs));
                  viewErase(&(target_root_lhs->rhs));
                  viewErase(&(target_root->rhs));
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
                  SetPqAdd(&(to_ptr->lhs));
_NODE_START;
                  this->JITD_NODE_Concat_set.emplace(&(to_ptr->rhs));
node_end(1, JITD_NODE_Concat);
                  SetPqAdd(&(to_ptr_rhs->lhs));
#endif
#if defined REPLAY_VIEW
                  _viewAdd(parent);
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
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
_NODE_START;
                  this->JITD_NODE_Concat_set.erase(target);
node_end(0, JITD_NODE_Concat);
                  SetPqErase(&(target_root_lhs->lhs));
                  SetPqErase(&(target_root_lhs->rhs));
#endif
#if defined REPLAY_VIEW
                  _viewErase(parent);
                  /*** ViewMaintenance ***/
                  viewErase(target);
                  viewErase(&(target_root->lhs));
                  viewErase(&(target_root_lhs->lhs));
                  viewErase(&(target_root_lhs->rhs));
                  viewErase(&(target_root->rhs));
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
_NODE_START;
                  this->JITD_NODE_Concat_set.emplace(&(to_ptr->lhs));
node_end(1, JITD_NODE_Concat);
                  SetPqAdd(&(to_ptr_lhs->lhs));
                  SetPqAdd(&(to_ptr->rhs));
#endif
#if defined REPLAY_VIEW
                  _viewAdd(parent);
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
#endif
VIEW_END;
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

bool JITD::PushDownAndCrack(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::PushDownAndCrack"<<std::endl;*/
  {
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
                  /*** ViewMaintenanceParent ***/
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
                  _viewErase(parent);
                  /*** ViewMaintenance ***/
                  viewErase(target);
                  viewErase(&(target_root->lhs));
                  viewErase(&(target_root_lhs->lhs));
                  viewErase(&(target_root_lhs->rhs));
                  viewErase(&(target_root->rhs));
#endif
VIEW_END;
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
                  /*** ViewMaintenanceParent ***/
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
                  _viewAdd(parent);
                  /*** ViewMaintenance ***/
                  viewAdd(target);
                  viewAdd(&(to_ptr->lhs));
                  viewAdd(&(to_ptr_lhs->lhs));
                  viewAdd(&(to_ptr_lhs->rhs));
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
                  {
                    setParent(&(to_ptr_rhs->lhs),&(to_ptr->rhs));
                    fixNodeDecendents(&(to_ptr_rhs->lhs),&(to_ptr_rhs->lhs));
                  }
                  {
                    setParent(&(to_ptr_rhs->rhs),&(to_ptr->rhs));
                    fixNodeDecendents(&(to_ptr_rhs->rhs),&(to_ptr_rhs->rhs));
                  }
#endif
VIEW_END;
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

bool JITD::CrackArray(std::shared_ptr<JITDNode> * &target )
{
/*std::cout<<" The transform applied is:JITD::CrackArray"<<std::endl;*/
  {
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
_NODE_START;
          this->CrackArray_PQ.erase(target);
node_end(0, JITD_NODE_Array);
          //this->SortArray_PQ.erase(target);
#endif
#if defined REPLAY_VIEW
          _viewErase(parent);
          /*** ViewMaintenance ***/
          viewErase(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET
_NODE_START;
          this->CrackArray_PQ.emplace(&(to_ptr->lhs));
node_end(1, JITD_NODE_Array);
          //this->SortArray_PQ.emplace(&(to_ptr->lhs));
_NODE_START;
          this->CrackArray_PQ.emplace(&(to_ptr->rhs));
node_end(1, JITD_NODE_Array);
          //this->SortArray_PQ.emplace(&(to_ptr->rhs));
#endif
#if defined REPLAY_VIEW
          _viewAdd(parent);
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
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_VIEW
    std::shared_ptr<JITDNode>* parent = getParent(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
          _viewErase(parent);
          /*** ViewMaintenance ***/
          viewErase(target);
#endif
VIEW_END;
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
VIEW_START;
#if defined REPLAY_SET

#endif
#if defined REPLAY_VIEW
          _viewAdd(parent);
          /*** ViewMaintenance ***/
          viewAdd(target);
          /*** ParentMaintenance ***/
          setParent(target,parent);
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_SET
    SetPqErase(&( *(cq_elem.first)));
#endif
#if defined REPLAY_VIEW
    viewErase(&( *(cq_elem.first)));
#endif
VIEW_END;
    DeleteSingletonNode *cast_root = (DeleteSingletonNode*)((cq_elem.second)->get());
    /*** UpdateTarget ***/
    {
    }
    {

#if defined REPLAY_SET
VIEW_START;
    this->JITD_NODE_DeleteSingleton_set.emplace(&(*(cq_elem.second)));
VIEW_END;
#endif

#if defined REPLAY_SET || defined REPLAY_VIEW
      #ifdef ATOMIC_STORE
      std::atomic_store(&(cast_root->node),*(cq_elem.first));

      #endif

      #ifdef ATOMIC_STORE_RELEASE
      std::atomic_store_explicit(&(cast_root->node),*(cq_elem.first),std::memory_order_release);

      #endif
#endif
#if defined REPLAY_VIEW
VIEW_START;
      fixNodeDecendents(&(*(cq_elem.first)),&(cast_root->node));
VIEW_END;
#endif
    }
    /*** ViewMaintenance ***/
VIEW_START;
#if defined REPLAY_SET
    SetPqAdd(&(cast_root->node));
#endif
#if defined REPLAY_VIEW
    viewAdd(&(*(cq_elem.second)));
    viewAdd(&(cast_root->node));
    /*** ParentMaintenance ***/
    setParent(&(*(cq_elem.second)),NULL);
    setParent(&(cast_root->node),&(*(cq_elem.second)));
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_SET
    SetPqErase(&( *(cq_elem.first)));
#endif
#if defined REPLAY_VIEW
    viewErase(&( *(cq_elem.first)));
#endif
VIEW_END;
    DeleteElementsNode *cast_root = (DeleteElementsNode*)((cq_elem.second)->get());
    /*** UpdateTarget ***/
    {
    }
    {

#if defined REPLAY_SET
VIEW_START;
    this->JITD_NODE_DeleteElements_set.emplace(&(*(cq_elem.second)));
VIEW_END;
#endif

#if defined REPLAY_SET || defined REPLAY_VIEW
      #ifdef ATOMIC_STORE
      std::atomic_store(&(cast_root->node),*(cq_elem.first));

      #endif

      #ifdef ATOMIC_STORE_RELEASE
      std::atomic_store_explicit(&(cast_root->node),*(cq_elem.first),std::memory_order_release);

      #endif
#endif
#if defined REPLAY_VIEW
VIEW_START;
      fixNodeDecendents(&(*(cq_elem.first)),&(cast_root->node));
VIEW_END;
#endif
    }
    /*** ViewMaintenance ***/
VIEW_START;
#if defined REPLAY_SET
    SetPqAdd(&(cast_root->node));
#endif
#if defined REPLAY_VIEW
    viewAdd(&(*(cq_elem.second)));
    viewAdd(&(cast_root->node));
    /*** ParentMaintenance ***/
    setParent(&(*(cq_elem.second)),NULL);
    setParent(&(cast_root->node),&(*(cq_elem.second)));
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_SET
    SetPqErase(&( *(cq_elem.first)));
#endif
#if defined REPLAY_VIEW
    viewErase(&( *(cq_elem.first)));
#endif
VIEW_END;
    ConcatNode *cast_root = (ConcatNode*)((cq_elem.second)->get());
    /*** UpdateTarget ***/
    {
    }
    {

#if defined REPLAY_SET
VIEW_START;
    this->CrackArray_PQ.emplace(&(cast_root->rhs));
    this->SortArray_PQ.emplace(&(cast_root->rhs));
    this->JITD_NODE_Concat_set.emplace(&(*(cq_elem.second)));
VIEW_END;
#endif

#if defined REPLAY_SET || defined REPLAY_VIEW
      #ifdef ATOMIC_STORE
      std::atomic_store(&(cast_root->lhs),*(cq_elem.first));

      #endif

      #ifdef ATOMIC_STORE_RELEASE
      std::atomic_store_explicit(&(cast_root->lhs),*(cq_elem.first),std::memory_order_release);

      #endif
#endif
#if defined REPLAY_VIEW
VIEW_START;
      fixNodeDecendents(&(*(cq_elem.first)),&(cast_root->lhs));
VIEW_END;
#endif
    }
    {
    }
    /*** ViewMaintenance ***/
VIEW_START;
#if defined REPLAY_SET
    SetPqAdd(&(cast_root->lhs));
#endif
#if defined REPLAY_VIEW
    viewAdd(&(*(cq_elem.second)));
    viewAdd(&(cast_root->lhs));
    viewAdd(&(cast_root->rhs));
    /*** ParentMaintenance ***/
    setParent(&(*(cq_elem.second)),NULL);
    setParent(&(cast_root->lhs),&(*(cq_elem.second)));
    setParent(&(cast_root->rhs),&(*(cq_elem.second)));
#endif
VIEW_END;
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
_VIEW_START;
#if defined REPLAY_SET
    SetPqErase(&( *(cq_elem.first)));
#endif
#if defined REPLAY_VIEW
    viewErase(&( *(cq_elem.first)));
#endif
VIEW_END;
    ConcatNode *cast_root = (ConcatNode*)((cq_elem.second)->get());
    /*** UpdateTarget ***/
    {
    }
    {

#if defined REPLAY_SET
VIEW_START;
    this->JITD_NODE_Concat_set.emplace(&(*(cq_elem.second)));
VIEW_END;
#endif

#if defined REPLAY_SET || defined REPLAY_VIEW
      #ifdef ATOMIC_STORE
      std::atomic_store(&(cast_root->lhs),*(cq_elem.first));

      #endif

      #ifdef ATOMIC_STORE_RELEASE
      std::atomic_store_explicit(&(cast_root->lhs),*(cq_elem.first),std::memory_order_release);

      #endif
#endif
#if defined REPLAY_VIEW
VIEW_START;
      fixNodeDecendents(&(*(cq_elem.first)),&(cast_root->lhs));
VIEW_END;
#endif
    }
    {
    }
    /*** ViewMaintenance ***/
VIEW_START;
#if defined REPLAY_SET
    SetPqAdd(&(cast_root->lhs));
#endif
#if defined REPLAY_VIEW
    viewAdd(&(*(cq_elem.second)));
    viewAdd(&(cast_root->lhs));
    viewAdd(&(cast_root->rhs));
    /*** ParentMaintenance ***/
    setParent(&(*(cq_elem.second)),NULL);
    setParent(&(cast_root->lhs),&(*(cq_elem.second)));
    setParent(&(cast_root->rhs),&(*(cq_elem.second)));
#endif
VIEW_END;
  }

}


///////////////////// OnMatch Transforms /////////////////////


#if defined REPLAY_SET || defined REPLAY_VIEW


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
bool JITD::matchPushDownDontDeleteSingletonBtreeLeft(std::shared_ptr<JITDNode> * &targetHandleRef) 
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
	if(target_root_lock->type != JITD_NODE_DeleteSingleton){return false; }
DeleteSingletonNode *target_root_lock_real = (DeleteSingletonNode *)target_root_lock;
JITDNode *target_root_lock_real_node = target_root_lock_real->node.get();
if(target_root_lock_real_node->type != JITD_NODE_BTree){return false; }
BTreeNode *target_root_lock_real_node_real = (BTreeNode *)target_root_lock_real_node;

	if((keys_cmp((target_root_lock_real->elem), (target_root_lock_real_node_real->sep))) == (true))
    {
    	return true;
    }
    else
    {
    	return false;
    }
	
}
bool JITD::matchPushDownDontDeleteSingletonBtreeRight(std::shared_ptr<JITDNode> * &targetHandleRef) 
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
	if(target_root_lock->type != JITD_NODE_DeleteSingleton){return false; }
DeleteSingletonNode *target_root_lock_real = (DeleteSingletonNode *)target_root_lock;
JITDNode *target_root_lock_real_node = target_root_lock_real->node.get();
if(target_root_lock_real_node->type != JITD_NODE_BTree){return false; }
BTreeNode *target_root_lock_real_node_real = (BTreeNode *)target_root_lock_real_node;

	if((keys_cmp((target_root_lock_real->elem), (target_root_lock_real_node_real->sep))) == (false))
    {
    	return true;
    }
    else
    {
    	return false;
    }
	
}
bool JITD::matchDeleteSingletonFromArray(std::shared_ptr<JITDNode> * &targetHandleRef) 
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
	if(target_root_lock->type != JITD_NODE_DeleteSingleton){return false; }
DeleteSingletonNode *target_root_lock_real = (DeleteSingletonNode *)target_root_lock;
JITDNode *target_root_lock_real_node = target_root_lock_real->node.get();
if(target_root_lock_real_node->type != JITD_NODE_Array){return false; }
ArrayNode *target_root_lock_real_node_real = (ArrayNode *)target_root_lock_real_node;

	if(true)
    {
    	return true;
    }
    else
    {
    	return false;
    }
	
}
bool JITD::matchPushDownAndCrack(std::shared_ptr<JITDNode> * &targetHandleRef) 
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
if(target_root_lock_real_rhs->type != JITD_NODE_Array){return false; }
ArrayNode *target_root_lock_real_rhs_real = (ArrayNode *)target_root_lock_real_rhs;

	if(true)
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

	if((array_size((target_root_lock_real->data))) > (__array_size))
    {
    	return true;
    }
    else
    {
    	return false;
    }
	
}


#endif


///////////////////// Policy Implementation ///////////////////// 


#ifdef REPLAY_NAIVE


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

  long JITD::searchForDeleteElemFromSingleton( 
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
if(lock_raw_real_node->type != JITD_NODE_Singleton){break; }
SingletonNode *lock_raw_real_node_real = (SingletonNode *)lock_raw_real_node;


      

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
            child_score = searchForDeleteElemFromSingleton(
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
            child_score = searchForDeleteElemFromSingleton(
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
            child_score = searchForDeleteElemFromSingleton(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForDeleteElemFromSingleton(
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
            child_score = searchForDeleteElemFromSingleton(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForDeleteElemFromSingleton(
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

  long JITD::searchForDeleteKeyFromSingleton( 
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
if(lock_raw_real_node->type != JITD_NODE_Singleton){break; }
SingletonNode *lock_raw_real_node_real = (SingletonNode *)lock_raw_real_node;


      

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
            child_score = searchForDeleteKeyFromSingleton(
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
            child_score = searchForDeleteKeyFromSingleton(
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
            child_score = searchForDeleteKeyFromSingleton(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForDeleteKeyFromSingleton(
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
            child_score = searchForDeleteKeyFromSingleton(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForDeleteKeyFromSingleton(
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

  long JITD::searchForDeleteSingletonFromArray( 
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
if(lock_raw_real_node->type != JITD_NODE_Array){break; }
ArrayNode *lock_raw_real_node_real = (ArrayNode *)lock_raw_real_node;


      

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
            child_score = searchForDeleteSingletonFromArray(
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
            child_score = searchForDeleteSingletonFromArray(
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
            child_score = searchForDeleteSingletonFromArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForDeleteSingletonFromArray(
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
            child_score = searchForDeleteSingletonFromArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForDeleteSingletonFromArray(
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

  long JITD::searchForDeleteElemFromArray( 
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
if(lock_raw_real_node->type != JITD_NODE_Array){break; }
ArrayNode *lock_raw_real_node_real = (ArrayNode *)lock_raw_real_node;


      

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
            child_score = searchForDeleteElemFromArray(
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
            child_score = searchForDeleteElemFromArray(
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
            child_score = searchForDeleteElemFromArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForDeleteElemFromArray(
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
            child_score = searchForDeleteElemFromArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForDeleteElemFromArray(
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


      

      if((array_size((lock_raw_real->data))) > (__array_size)){

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

  long JITD::searchForSortArray( 
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


      

      if(true){

        best_score = array_size((lock_raw_real->data));
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
            child_score = searchForSortArray(
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
            child_score = searchForSortArray(
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
            child_score = searchForSortArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForSortArray(
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
            child_score = searchForSortArray(
              real_nodeHandleRef, 
              child_targetHandleRef
            );
            if(child_score > best_score) { 
              //target = child_target; 
              targetHandleRef = child_targetHandleRef;
              best_score = child_score;
            }
          
          real_nodeHandleRef = &(real_node->rhs);
            child_score = searchForSortArray(
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


#endif
#ifdef REPLAY_SET


  long JITD::searchForPushDownSingletonLeft(          // Return the "best" score available 
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  
    //std::cout<<"STARTING TRANSFORMPushDownSingletonLeft"<<std::endl;
    int count = 0;
    long best_score = -1;
    long curr_score = -1;
    if(!(this->JITD_NODE_Concat_set).empty())
    {
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      std::set< std::shared_ptr<JITDNode> * >::iterator begin_it = (this->JITD_NODE_Concat_set).begin();
      std::set< std::shared_ptr<JITDNode> * >::iterator end_it = (this->JITD_NODE_Concat_set).end();
      for(it = begin_it; it!= end_it; ++it)
      {
        

           JITDNode *iter_node = (*it)->get();
          

           if(iter_node->type != JITD_NODE_Concat){continue; }
ConcatNode *iter_node_real = (ConcatNode *)iter_node;
JITDNode *iter_node_real_lhs = iter_node_real->lhs.get();
if(iter_node_real_lhs->type != JITD_NODE_BTree){continue; }
BTreeNode *iter_node_real_lhs_real = (BTreeNode *)iter_node_real_lhs;
JITDNode *iter_node_real_rhs = iter_node_real->rhs.get();
if(iter_node_real_rhs->type != JITD_NODE_Singleton){continue; }
SingletonNode *iter_node_real_rhs_real = (SingletonNode *)iter_node_real_rhs;

          
           if((key_cmp((iter_node_real_rhs_real->elem), (iter_node_real_lhs_real->sep))) == (true)){
            best_score = 0;
          }

          if(best_score>curr_score)
          {
            //std::cout<<"BESTSCORE: "<<best_score<<std::endl;
            curr_score = best_score;
            
            targetHandleRef = (*it);
            return best_score;
            
          
      }
    }




}
    return best_score;
  
  }

  long JITD::searchForPushDownSingletonRight(          // Return the "best" score available 
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  
    //std::cout<<"STARTING TRANSFORMPushDownSingletonRight"<<std::endl;
    int count = 0;
    long best_score = -1;
    long curr_score = -1;
    if(!(this->JITD_NODE_Concat_set).empty())
    {
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      std::set< std::shared_ptr<JITDNode> * >::iterator begin_it = (this->JITD_NODE_Concat_set).begin();
      std::set< std::shared_ptr<JITDNode> * >::iterator end_it = (this->JITD_NODE_Concat_set).end();
      for(it = begin_it; it!= end_it; ++it)
      {
        

           JITDNode *iter_node = (*it)->get();
          

           if(iter_node->type != JITD_NODE_Concat){continue; }
ConcatNode *iter_node_real = (ConcatNode *)iter_node;
JITDNode *iter_node_real_lhs = iter_node_real->lhs.get();
if(iter_node_real_lhs->type != JITD_NODE_BTree){continue; }
BTreeNode *iter_node_real_lhs_real = (BTreeNode *)iter_node_real_lhs;
JITDNode *iter_node_real_rhs = iter_node_real->rhs.get();
if(iter_node_real_rhs->type != JITD_NODE_Singleton){continue; }
SingletonNode *iter_node_real_rhs_real = (SingletonNode *)iter_node_real_rhs;

          
           if((key_cmp((iter_node_real_rhs_real->elem), (iter_node_real_lhs_real->sep))) == (false)){
            best_score = 0;
          }

          if(best_score>curr_score)
          {
            //std::cout<<"BESTSCORE: "<<best_score<<std::endl;
            curr_score = best_score;
            
            targetHandleRef = (*it);
            return best_score;
            
          
      }
    }




}
    return best_score;
  
  }

  long JITD::searchForPushDownDontDeleteSingletonBtreeLeft(          // Return the "best" score available 
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  
    //std::cout<<"STARTING TRANSFORMPushDownDontDeleteSingletonBtreeLeft"<<std::endl;
    int count = 0;
    long best_score = -1;
    long curr_score = -1;
    if(!(this->JITD_NODE_DeleteSingleton_set).empty())
    {
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      std::set< std::shared_ptr<JITDNode> * >::iterator begin_it = (this->JITD_NODE_DeleteSingleton_set).begin();
      std::set< std::shared_ptr<JITDNode> * >::iterator end_it = (this->JITD_NODE_DeleteSingleton_set).end();
      for(it = begin_it; it!= end_it; ++it)
      {
        

           JITDNode *iter_node = (*it)->get();
          

           if(iter_node->type != JITD_NODE_DeleteSingleton){continue; }
DeleteSingletonNode *iter_node_real = (DeleteSingletonNode *)iter_node;
JITDNode *iter_node_real_node = iter_node_real->node.get();
if(iter_node_real_node->type != JITD_NODE_BTree){continue; }
BTreeNode *iter_node_real_node_real = (BTreeNode *)iter_node_real_node;

          
           if((keys_cmp((iter_node_real->elem), (iter_node_real_node_real->sep))) == (true)){
            best_score = 0;
          }

          if(best_score>curr_score)
          {
            //std::cout<<"BESTSCORE: "<<best_score<<std::endl;
            curr_score = best_score;
            
            targetHandleRef = (*it);
            return best_score;
            
          
      }
    }




}
    return best_score;
  
  }

  long JITD::searchForPushDownDontDeleteSingletonBtreeRight(          // Return the "best" score available 
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  
    //std::cout<<"STARTING TRANSFORMPushDownDontDeleteSingletonBtreeRight"<<std::endl;
    int count = 0;
    long best_score = -1;
    long curr_score = -1;
    if(!(this->JITD_NODE_DeleteSingleton_set).empty())
    {
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      std::set< std::shared_ptr<JITDNode> * >::iterator begin_it = (this->JITD_NODE_DeleteSingleton_set).begin();
      std::set< std::shared_ptr<JITDNode> * >::iterator end_it = (this->JITD_NODE_DeleteSingleton_set).end();
      for(it = begin_it; it!= end_it; ++it)
      {
        

           JITDNode *iter_node = (*it)->get();
          

           if(iter_node->type != JITD_NODE_DeleteSingleton){continue; }
DeleteSingletonNode *iter_node_real = (DeleteSingletonNode *)iter_node;
JITDNode *iter_node_real_node = iter_node_real->node.get();
if(iter_node_real_node->type != JITD_NODE_BTree){continue; }
BTreeNode *iter_node_real_node_real = (BTreeNode *)iter_node_real_node;

          
           if((keys_cmp((iter_node_real->elem), (iter_node_real_node_real->sep))) == (false)){
            best_score = 0;
          }

          if(best_score>curr_score)
          {
            //std::cout<<"BESTSCORE: "<<best_score<<std::endl;
            curr_score = best_score;
            
            targetHandleRef = (*it);
            return best_score;
            
          
      }
    }




}
    return best_score;
  
  }

  long JITD::searchForDeleteSingletonFromArray(          // Return the "best" score available 
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  
    //std::cout<<"STARTING TRANSFORMDeleteSingletonFromArray"<<std::endl;
    int count = 0;
    long best_score = -1;
    long curr_score = -1;
    if(!(this->JITD_NODE_DeleteSingleton_set).empty())
    {
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      std::set< std::shared_ptr<JITDNode> * >::iterator begin_it = (this->JITD_NODE_DeleteSingleton_set).begin();
      std::set< std::shared_ptr<JITDNode> * >::iterator end_it = (this->JITD_NODE_DeleteSingleton_set).end();
      for(it = begin_it; it!= end_it; ++it)
      {
        

           JITDNode *iter_node = (*it)->get();
          

           if(iter_node->type != JITD_NODE_DeleteSingleton){continue; }
DeleteSingletonNode *iter_node_real = (DeleteSingletonNode *)iter_node;
JITDNode *iter_node_real_node = iter_node_real->node.get();
if(iter_node_real_node->type != JITD_NODE_Array){continue; }
ArrayNode *iter_node_real_node_real = (ArrayNode *)iter_node_real_node;

          
           if(true){
            best_score = 0;
          }

          if(best_score>curr_score)
          {
            //std::cout<<"BESTSCORE: "<<best_score<<std::endl;
            curr_score = best_score;
            
            targetHandleRef = (*it);
            return best_score;
            
          
      }
    }




}
    return best_score;
  
  }

  long JITD::searchForCrackArray(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  

    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->CrackArray_PQ).empty())
    {
    
      std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->CrackArray_PQ).begin();
          
          /*#ifdef DEBUG
          assert(*it!=NULL);
          #endif
          
          std::shared_ptr<JITDNode> * pspjn = *it;
          
          #ifdef DEBUG
          assert(pspjn!=NULL);
          #endif

          std::shared_ptr<JITDNode> spjn = *pspjn;

          #ifdef DEBUG
          assert(spjn!=NULL);
          #endif
          
          JITDNode *iter_node = (spjn).get();
          */

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_Array){return -1; }
ArrayNode *iter_node_real = (ArrayNode *)iter_node;


          if((array_size((iter_node_real->data))) > (__array_size)){
            bestScore = array_size((iter_node_real->data));
          targetHandleRef = (*it);
          }

          
      
    }





    return bestScore;
  }


#endif
#ifdef REPLAY_VIEW
#ifdef REPLAY_JITD


  long JITD::searchForPushDownSingletonLeft(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  
    
    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->PushDownSingletonLeft_View).empty())
    {
      std::unordered_set< std::shared_ptr<JITDNode> * >::iterator it;
      //std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
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
      std::unordered_set< std::shared_ptr<JITDNode> * >::iterator it;
      //std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
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

  long JITD::searchForPushDownDontDeleteSingletonBtreeLeft(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  
    
    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->PushDownDontDeleteSingletonBtreeLeft_View).empty())
    {
      std::unordered_set< std::shared_ptr<JITDNode> * >::iterator it;
      //std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->PushDownDontDeleteSingletonBtreeLeft_View).begin();
          
         

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_DeleteSingleton){return -1; }
DeleteSingletonNode *iter_node_real = (DeleteSingletonNode *)iter_node;
JITDNode *iter_node_real_node = iter_node_real->node.get();
if(iter_node_real_node->type != JITD_NODE_BTree){return -1; }
BTreeNode *iter_node_real_node_real = (BTreeNode *)iter_node_real_node;


          if((keys_cmp((iter_node_real->elem), (iter_node_real_node_real->sep))) == (true)){
            bestScore = 0;
          
          targetHandleRef = (*it);
          }
          

          
      
    }





    return bestScore;
  }

  long JITD::searchForPushDownDontDeleteSingletonBtreeRight(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  
    
    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->PushDownDontDeleteSingletonBtreeRight_View).empty())
    {
      std::unordered_set< std::shared_ptr<JITDNode> * >::iterator it;
      //std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->PushDownDontDeleteSingletonBtreeRight_View).begin();
          
         

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_DeleteSingleton){return -1; }
DeleteSingletonNode *iter_node_real = (DeleteSingletonNode *)iter_node;
JITDNode *iter_node_real_node = iter_node_real->node.get();
if(iter_node_real_node->type != JITD_NODE_BTree){return -1; }
BTreeNode *iter_node_real_node_real = (BTreeNode *)iter_node_real_node;


          if((keys_cmp((iter_node_real->elem), (iter_node_real_node_real->sep))) == (false)){
            bestScore = 0;
          
          targetHandleRef = (*it);
          }
          

          
      
    }





    return bestScore;
  }

  long JITD::searchForDeleteSingletonFromArray(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  
    
    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->DeleteSingletonFromArray_View).empty())
    {
      std::unordered_set< std::shared_ptr<JITDNode> * >::iterator it;
      //std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->DeleteSingletonFromArray_View).begin();
          
         

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_DeleteSingleton){return -1; }
DeleteSingletonNode *iter_node_real = (DeleteSingletonNode *)iter_node;
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

  long JITD::searchForPushDownAndCrack(          // Return the "best" score available     
    std::shared_ptr<JITDNode> * &targetHandleRef // Return value: The pointer with the "best" score
  ) {
  
    
    int count = 0;
    long bestScore = -1;
    long curr_score = -1;
   
    
    if(!(this->PushDownAndCrack_View).empty())
    {
      std::unordered_set< std::shared_ptr<JITDNode> * >::iterator it;
      //std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
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
      //std::set< std::shared_ptr<JITDNode> * >::iterator it;
      
      it = (this->CrackArray_View).begin();
          
         

           JITDNode *iter_node = (*it)->get();
          
          
          if(iter_node->type != JITD_NODE_Array){return -1; }
ArrayNode *iter_node_real = (ArrayNode *)iter_node;


          if((array_size((iter_node_real->data))) > (__array_size)){
            bestScore = array_size((iter_node_real->data));
          
          targetHandleRef = (*it);
          }
          

          
      
    }





    return bestScore;
  }


#endif
#ifdef REPLAY_DBT

long JITD::searchForPushDownSingletonLeft(std::shared_ptr<JITDNode> * &targetHandleRef) {

	if (query_2->head != nullptr) {

		targetHandleRef = (std::shared_ptr<JITDNode>*)query_2->head->CONCAT_NODE_SELF;

		// For DBT, we are maintaining a combined view for PDSL and PSDR transforms.
		// So manually inspect values to determine which transform to perform:
		auto concat_node_handle = (std::shared_ptr<ConcatNode>*)targetHandleRef;
		assert((*concat_node_handle)->type == JITD_NODE_Concat);
		auto btree_node_handle = (std::shared_ptr<BTreeNode>*)&((*concat_node_handle)->lhs);
		assert((*btree_node_handle)->type == JITD_NODE_BTree);
		auto singleton_node_handle = (std::shared_ptr<SingletonNode>*)&((*concat_node_handle)->rhs);
		assert((*singleton_node_handle)->type == JITD_NODE_Singleton);

		if ((*singleton_node_handle)->elem.key < (*btree_node_handle)->sep) {
			return 1;
		}

		// Else -- return -1 and fall through to PDSL

	}

	return -1;

}

long JITD::searchForPushDownSingletonRight(std::shared_ptr<JITDNode> * &targetHandleRef) {

	if (query_2->head != nullptr) {
		targetHandleRef = (std::shared_ptr<JITDNode>*)query_2->head->CONCAT_NODE_SELF;
		return 1;
	}
	return -1;

}

long JITD::searchForPushDownDontDeleteSingletonBtreeLeft(std::shared_ptr<JITDNode> * &targetHandleRef) {

	if (query_3->head != nullptr) {
		targetHandleRef = (std::shared_ptr<JITDNode>*)query_3->head->DELETESINGLETON_NODE_SELF;
		return 1;
	}
	return -1;

}

long JITD::searchForPushDownDontDeleteSingletonBtreeRight(std::shared_ptr<JITDNode> * &targetHandleRef) {

	if (query_4->head != nullptr) {
		targetHandleRef = (std::shared_ptr<JITDNode>*)query_4->head->DELETESINGLETON_NODE_SELF;
		return 1;
	}
	return -1;

}

long JITD::searchForDeleteSingletonFromArray(std::shared_ptr<JITDNode> * &targetHandleRef) {

	if (query_5->head != nullptr) {
		targetHandleRef = (std::shared_ptr<JITDNode>*)query_5->head->DELETESINGLETON_NODE_SELF;
		return 1;
	}
	return -1;

}

long JITD::searchForCrackArray(std::shared_ptr<JITDNode> * &targetHandleRef) {

	if (query_1->head != nullptr) {
		targetHandleRef = (std::shared_ptr<JITDNode>*)query_1->head->ARRAY_NODE_SELF;
		return 1;
	}
	return -1;

}
 
#endif
#endif


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
            std::this_thread::sleep_for(std::chrono::microseconds(__sleep_time));
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
        
        if(pop_mce.flag == FLAG_remove_singleton)
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


#ifdef REPLAY_SET


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
  //this->childParentMap.emplace(node,parent);
  //viewAdd(node);
  switch(target_root_lock->type)
  {
    
      case JITD_NODE_DeleteSingleton : {
      this->JITD_NODE_DeleteSingleton_set.emplace(node);

      
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


#endif
#ifdef REPLAY_VIEW


void JITD::initialize_struts_view(std::shared_ptr<JITDNode>* node,std::shared_ptr<JITDNode>* parent)
{

#ifdef REPLAY_DBT

ct.init();

query_1 = &ct.data.QUERY_1_COUNT;
query_2 = &ct.data.QUERY_2_COUNT;
query_3 = &ct.data.QUERY_3_COUNT;
query_4 = &ct.data.QUERY_4_COUNT;
query_5 = &ct.data.QUERY_5_COUNT;

#endif

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


#endif


bool JITD::do_organize()
{
  
  
#if defined REPLAY_NAIVE
// Bug:  The JITD class "root" element is not maintained.  Need to re-fetch:
this->root = &(*jitd_root);
#endif


{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForPushDownSingletonLeft" <<std::endl;
  //this->print_debug();
  //check_pq();

SEARCH_START;
  long bestScore = searchForPushDownSingletonLeft(
    _targetHandleRef
  );
SEARCH_END(108);
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

SEARCH_START;
  long bestScore = searchForPushDownSingletonRight(
    _targetHandleRef
  );
SEARCH_END(107);
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

SEARCH_START;
  long bestScore = searchForPushDownDontDeleteSingletonBtreeLeft(
    _targetHandleRef
  );
SEARCH_END(105);
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

SEARCH_START;
  long bestScore = searchForPushDownDontDeleteSingletonBtreeRight(
    _targetHandleRef
  );
SEARCH_END(104);
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


    



/*
{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForDeleteSingletonFromArray" <<std::endl;
  //this->print_debug();
  //check_pq();

SEARCH_START;
  long bestScore = searchForDeleteSingletonFromArray(
    _targetHandleRef
  );
SEARCH_END(102);
  //std::cout<<"After calling searchForDeleteSingletonFromArray Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
    //std::cout<<"Candidate shared_ptr for DeleteSingletonFromArray: "<<(*targetHandleRef)<<std::endl;
    
      #ifdef TRANSFORM_COUNT
    DeleteSingletonFromArray_count++;
    #endif
      DeleteSingletonFromArray(targetHandleRef);
    
    return true;

  } 
  
  
  
  else { 
     
  }







}
*/


    



/*
{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForPushDownAndCrack" <<std::endl;
  //this->print_debug();
  //check_pq();

  long bestScore = searchForPushDownAndCrack(
    _targetHandleRef
  );
  //std::cout<<"After calling searchForPushDownAndCrack Best Score is "<<bestScore<<std::endl;
  if(bestScore >= 0) {
  
SEARCH_END;

    //std::cout<<"Candidate shared_ptr for PushDownAndCrack: "<<(*targetHandleRef)<<std::endl;
    
      #ifdef TRANSFORM_COUNT
    PushDownAndCrack_count++;
    #endif
      PushDownAndCrack(targetHandleRef);
    
    return true;

  } 
  
  
  
  else { 
     
  }







}
*/


    



{
  std::shared_ptr<JITDNode> * targetHandleRef;
  
  //std::shared_ptr<JITDNode> target;
  //std::cout<<"Before calling searchForCrackArray" <<std::endl;
  //this->print_debug();
  //check_pq();

SEARCH_START;
  long bestScore = searchForCrackArray(
    _targetHandleRef
  );
SEARCH_END(109);
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

#if defined REPLAY_SET

///////////////////// Set/PQ/View populate ///////////////////// 

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

NODE_START;

  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteSingleton : {
          this->JITD_NODE_DeleteSingleton_set.erase(node_handle);

          
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

NODE_END(0);

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

NODE_START;

  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteSingleton : {
          this->JITD_NODE_DeleteSingleton_set.emplace(node_handle);

          
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

NODE_END(1);

      #ifdef DEBUG
        //check_pq();
      #endif  
}

#endif
#if defined REPLAY_VIEW

void JITD::viewAdd(std::shared_ptr<JITDNode>* node_handle)
{
  if(node_handle == NULL){return;}

#if defined REPLAY_JITD

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

NODE_START;

  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteSingleton : {
        matched = this->matchPushDownDontDeleteSingletonBtreeLeft(node_handle);
if(matched == true){
this->PushDownDontDeleteSingletonBtreeLeft_View.emplace(node_handle);
}
matched = this->matchPushDownDontDeleteSingletonBtreeRight(node_handle);
if(matched == true){
this->PushDownDontDeleteSingletonBtreeRight_View.emplace(node_handle);
}
matched = this->matchDeleteSingletonFromArray(node_handle);
if(matched == true){
this->DeleteSingletonFromArray_View.emplace(node_handle);
}

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
matched = this->matchPushDownAndCrack(node_handle);
if(matched == true){
this->PushDownAndCrack_View.emplace(node_handle);
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

NODE_END(1);

#endif
#if defined REPLAY_DBT

	int id = 0;
	unsigned long self = (unsigned long)node_handle;
	JITDNodeType node_type = (*node_handle)->type;

_NODE_START;

	if (node_type == JITD_NODE_DeleteSingleton) {
		auto deletesingleton_node_handle = (std::shared_ptr<DeleteSingletonNode>*)node_handle;
		auto child_handle = &((*deletesingleton_node_handle)->node);
		long key = (*deletesingleton_node_handle)->elem;
		ct.data.on_insert_DELETESINGLETON(id, self, (unsigned long)child_handle, key);
	} else if (node_type == JITD_NODE_DeleteElements) {
		auto deleteelements_node_handle = (std::shared_ptr<DeleteElementsNode>*)node_handle;
		auto child_handle = &((*deleteelements_node_handle)->node);
		size_t size = array_size((*deleteelements_node_handle)->data);
		goto err_missing_node;
	} else if (node_type == JITD_NODE_BTree) {
		auto btree_node_handle = (std::shared_ptr<BTreeNode>*)node_handle;
		auto left_handle = &((*btree_node_handle)->lhs);
		auto right_handle = &((*btree_node_handle)->rhs);
		long separator = (*btree_node_handle)->sep;
		ct.data.on_insert_BTREE(id, self, (unsigned long)left_handle, (unsigned long)right_handle, separator);
	} else if (node_type == JITD_NODE_Concat) {
		auto concat_node_handle = (std::shared_ptr<ConcatNode>*)node_handle;
		auto left_handle = &((*concat_node_handle)->lhs);
		auto right_handle = &((*concat_node_handle)->rhs);
		ct.data.on_insert_CONCAT(id, self, (unsigned long)left_handle, (unsigned long)right_handle);
	} else if (node_type == JITD_NODE_SortedArray) {
		auto sortedarray_node_handle = (std::shared_ptr<SortedArrayNode>*)node_handle;
		size_t size = array_size((*sortedarray_node_handle)->data);
		goto err_missing_node;
	} else if (node_type == JITD_NODE_Array) {
		auto array_node_handle =  (std::shared_ptr<ArrayNode>*)node_handle;
		size_t size = array_size((*array_node_handle)->data);
		ct.data.on_insert_ARRAY(id, self, size);
	} else if (node_type == JITD_NODE_Singleton) {
		auto singleton_node_handle = (std::shared_ptr<SingletonNode>*)node_handle;
		Record r = (*singleton_node_handle)->elem;
		ct.data.on_insert_SINGLETON(id, self, r.key);
	}

NODE_END(1);

	return;

    err_missing_node:
	printf("Error:  Unsupported insert node type\n");
	_exit(1);

#endif

}
void JITD::viewErase(std::shared_ptr<JITDNode>* node_handle)
{
  if(node_handle == NULL){return;}

#if defined REPLAY_JITD

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

NODE_START;

  switch((node_ptr)->type){
    
      case JITD_NODE_DeleteSingleton : {
        this->PushDownDontDeleteSingletonBtreeLeft_View.erase(node_handle);
this->PushDownDontDeleteSingletonBtreeRight_View.erase(node_handle);
this->DeleteSingletonFromArray_View.erase(node_handle);

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
this->PushDownAndCrack_View.erase(node_handle);

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

NODE_END(0);

#endif
#if defined REPLAY_DBT

	int id = 0;
	unsigned long self = (unsigned long)node_handle;
	JITDNodeType node_type = (*node_handle)->type;

_NODE_START;

	if (node_type == JITD_NODE_DeleteSingleton) {
		auto deletesingleton_node_handle = (std::shared_ptr<DeleteSingletonNode>*)node_handle;
		auto child_handle = &((*deletesingleton_node_handle)->node);
		long key = (*deletesingleton_node_handle)->elem;
		ct.data.on_delete_DELETESINGLETON(id, self, (unsigned long)child_handle, key);
	} else if (node_type == JITD_NODE_DeleteElements) {
		auto deleteelements_node_handle = (std::shared_ptr<DeleteElementsNode>*)node_handle;
		auto child_handle = &((*deleteelements_node_handle)->node);
		size_t size = array_size((*deleteelements_node_handle)->data);
		goto err_missing_node;
	} else if (node_type == JITD_NODE_BTree) {
		auto btree_node_handle = (std::shared_ptr<BTreeNode>*)node_handle;
		auto left_handle = &((*btree_node_handle)->lhs);
		auto right_handle = &((*btree_node_handle)->rhs);
		long separator = (*btree_node_handle)->sep;
		ct.data.on_delete_BTREE(id, self, (unsigned long)left_handle, (unsigned long)right_handle, separator);
	} else if (node_type == JITD_NODE_Concat) {
		auto concat_node_handle = (std::shared_ptr<ConcatNode>*)node_handle;
		auto left_handle = &((*concat_node_handle)->lhs);
		auto right_handle = &((*concat_node_handle)->rhs);
		ct.data.on_delete_CONCAT(id, self, (unsigned long)left_handle, (unsigned long)right_handle);
	} else if (node_type == JITD_NODE_SortedArray) {
		auto sortedarray_node_handle = (std::shared_ptr<SortedArrayNode>*)node_handle;
		size_t size = array_size((*sortedarray_node_handle)->data);
		goto err_missing_node;
	} else if (node_type == JITD_NODE_Array) {
		auto array_node_handle =  (std::shared_ptr<ArrayNode>*)node_handle;
		size_t size = array_size((*array_node_handle)->data);
		ct.data.on_delete_ARRAY(id, self, size);
	} else if (node_type == JITD_NODE_Singleton) {
		auto singleton_node_handle = (std::shared_ptr<SingletonNode>*)node_handle;
		Record r = (*singleton_node_handle)->elem;
		ct.data.on_delete_SINGLETON(id, self, r.key);
	}

NODE_END(0);

	return;

    err_missing_node:
	printf("Error:  Unsupported delete node type\n");
	_exit(1);

#endif
  
}
std::shared_ptr<JITDNode> * JITD::getParent(std::shared_ptr<JITDNode> * &target)
{

#if defined REPLAY_JITD

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
  
#endif
#if defined REPLAY_DBT

return NULL;

#endif

  
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

#if defined REPLAY_JITD

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

#endif
#if defined REPLAY_DBT

return;

#endif

}
void JITD::fixNodeDecendents(std::shared_ptr<JITDNode>* node_handle,std::shared_ptr<JITDNode>* parent)
{

#if defined REPLAY_JITD

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

#endif
#if defined REPLAY_DBT
return;
#endif

  }

#endif

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
  #ifdef TRANSFORM_COUNT
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
  #endif
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
      
        std::cout<<"SIZE OF PushDownAndCrack View"<<PushDownAndCrack_View.size()<<"."<<std::endl;
        for(it = this->PushDownAndCrack_View.begin();it!=this->PushDownAndCrack_View.end();++it)
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
