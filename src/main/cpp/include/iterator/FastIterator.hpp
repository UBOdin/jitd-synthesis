#include<stack>
using namespace std;
template <class JITDNode> 
class FastIterator : public IteratorBase<Record> {
std::shared_ptr<JITDNode> lhs, rhs;
Iterator<Record> lhsIter, rhsIter;
std::stack<std::shared_ptr<JITDNode>> nodeStack;
std::shared_ptr<JITDNode> node_ptr;
Iterator<Record> iter; 
const Key sep;
  
  public: 
    FastIterator(const std::shared_ptr<JITDNode> &lhs, 
      const Key sep, 
      const std::shared_ptr<JITDNode> &rhs):lhs(lhs),rhs(rhs),sep(sep)
      {
        //lhs = std::atomic_load(lhs_ptr);
        //rhs = std::atomic_load(rhs_ptr);
        //std::cout<<"Fastiterator constructor with sep,lhs,rhs -> sep val: "<<sep<<std::endl;
        
 
      }
      
    void initroot(const Record &k1)
    {
      //std::cout<<"In init root"<<std::endl;
      if(k1 < sep)
        {
          std::cout<<"Key seek is less than sep"<<sep<<std::endl;
          // node = rhs;
          // std::cout<<"node->type rhs" << node->type()<<std::endl;
          node_ptr = lhs;
          //std::cout<<"LHS node->type" << node->type()<<std::endl;
          nodeStack.push(rhs);
          //std::cout<<"after initroot stack size "<<nodeStack.size()<<std::endl;
        } 
        else
        {
          std::cout<<"Key seek is greater than sep"<<std::endl;
          node_ptr = rhs;
          //std::cout<<"RHS node->type" << node->type()<<std::endl;
          //std::cout<<"node->type rhs" << node->type()<<std::endl;
          // node = lhs;
          // std::cout<<"node->type lhs" << node->type()<<std::endl;
          // nodeStack.push(rhs);
        }
        //std::cout<<"FI: stack size after iniroot: "<<nodeStack.size()<<std::endl;
    }
    
    

    Record get()
    {
      //std::cout<<"in fast iterator get"<<std::endl;
      if(iter.get()==NULL && node_ptr == NULL)
      {
        //std::cout<<"iter not init in FI"<<std::endl;
          
            if(jitd_accessor_size(lhs) == 0)
            {
              
              iter = rhs->iterator();
            }
            else
            {
              
              iter = lhs->iterator();
            }
           
      }
      return iter->get();
      
    }
    void initNode()
    {
      //std::cout<<"in initNode node type is"<<node->type()<<std::endl;
      while(node_ptr!=NULL)
      {
        JITDNode *node_raw = node_ptr.get();

        if(node_ptr->type == JITD_NODE_SortedArray && iter->atEnd() )
        {
          //SortedArrayNode * node = (SortedArrayNode *)node_raw;
          //std::cout<<"init buffiter SA"<<std::endl;
          
          //if((node->iterator())->isEmpty())
          if((node_ptr->iterator())->atEnd())
          {
            node_ptr = nodeStack.top();
            nodeStack.pop();
          }
          else
          {
            if(iter.get() == NULL)
            {
              iter = node_ptr->iterator();
            }
            
            return;
          }
          
        }
        else if(node_ptr->type == JITD_NODE_Array && iter->atEnd() )
        {
          //std::cout<<"init buffiter Array"<<std::endl;
          //if((node->iterator())->isEmpty())
          //ArrayNode * node = (ArrayNode *)node_raw;
          if((node_ptr->iterator())->atEnd())
          {
            node_ptr = nodeStack.top();
            nodeStack.pop();
          }
          else
          {
            // if(iter.get() == NULL)
            // {
              iter = node_ptr->iterator();
            //}
            return;
          }
        }
        else if(node_ptr->type == JITD_NODE_BTree)
        {
          //std::cout<<"init Btree stack with sep "<<node->getSepVal()<<std::endl;
          BTreeNode * node = (BTreeNode *)node_raw;
          nodeStack.push(node->rhs);
          //std::cout<<"pushed rhs"<<std::endl;
          node_ptr = node->lhs;  
        }
        else if(node_ptr->type == JITD_NODE_Concat)
        {
          //std::cout<<"init Btree stack with sep "<<node->getSepVal()<<std::endl;
          if((node_ptr->iterator())->atEnd())
          {
            node_ptr = nodeStack.top();
            nodeStack.pop();
          }
          else
          {
            // if(iter.get() == NULL)
            // {
              iter = node_ptr->iterator();
            //}
            return;
          }  
        }
        else if(node_ptr->type == JITD_NODE_Singleton)
        {
          //std::cout<<"init Btree stack with sep "<<node->getSepVal()<<std::endl;
          if((node_ptr->iterator())->atEnd())
          {
            node_ptr = nodeStack.top();
            nodeStack.pop();
          }
          else
          {
            // if(iter.get() == NULL)
            // {
              iter = node_ptr->iterator();
            //}
            return;
          }  
        }
        else if(node_ptr->type == JITD_NODE_DeleteElements)
        {
            
        }
        else if(node_ptr->type == JITD_NODE_DeleteSingleton)
        {
     
        }
      }
      
      
    }
    void next()
    {
      //std::cout<<"in fast iter next"<<std::endl;
      
      //  std::cout<<"node stack not empty"<<std::endl;
      JITDNode *node_raw = node_ptr.get();
      if(node_ptr != NULL || !nodeStack.empty())
      {
        if(node_ptr->type == JITD_NODE_SortedArray)
        {
            

            iter->next();
            //std::cout<<"value of iter after SA next"<<*iter->get()<<std::endl;

        }
        else if(node_ptr->type == JITD_NODE_Array)
        {
          //std::cout<<"FI:Array in next()"<<std::endl;
          
          
          //std::cout<< *buffiter->get()<<",";
            iter->next();

        }
        //std::cout<<"here"<<std::endl;
        else if(node_ptr->type == JITD_NODE_BTree)
        {
        

          BTreeNode * node = (BTreeNode *)node_raw;
          //std::cout<<"FI:Btree in next() with sep value " <<node->sep<<std::endl;
          nodeStack.push(node->rhs);
          node_ptr = node->lhs;
          

        }
        else if(node_ptr->type == JITD_NODE_Concat)
        {
          //std::cout<<"found Btree cog in next with sep val"<<node->getSepVal()<<std::endl;
          //std::cout<<"FI:Concat in next() "<<std::endl;
          //iter = node_ptr->iterator();
          iter->next();
        
          

        }
        else if(node_ptr->type == JITD_NODE_Singleton)
        {
          //std::cout<<"found Btree cog in next with sep val"<<node->getSepVal()<<std::endl;
          //std::cout<<"FI:Concat in next() "<<std::endl;
          //iter = node_ptr->iterator();
          iter->next();
        
          

        }
        else if(node_ptr->type == JITD_NODE_DeleteElements)
        {
          //std::cout<<"found Btree cog in next with sep val"<<node->getSepVal()<<std::endl;

          iter->next();
          

        }
        else if(node_ptr->type == JITD_NODE_DeleteSingleton)
        {
          //std::cout<<"found Btree cog in next with sep val"<<node->getSepVal()<<std::endl;

          
          iter->next();

        }
        if(!nodeStack.empty() && iter->atEnd())
        {
          //std::cout<<"node stack not empty and iter at end"<<std::endl;
          node_ptr = nodeStack.top();
          nodeStack.pop();
          //std::cout<<"type of node "<<node->type()<<std::endl;
          initNode();
        } 
      }

    } 
    void range_next(const long &r1,const long &r2)
    {
      //std::cout<<"in fast iter next"<<std::endl;
      
      //  std::cout<<"node stack not empty"<<std::endl;
      JITDNode *node_raw = node_ptr.get();
      if(node_ptr != NULL || !nodeStack.empty())
      {
        if(node_ptr->type == JITD_NODE_SortedArray)
        {
            

            iter->range_next(r1,r2);
            //std::cout<<"value of iter after SA next"<<*iter->get()<<std::endl;

        }
        else if(node_ptr->type == JITD_NODE_Array)
        {
          //std::cout<<"FI:Array in next()"<<std::endl;
          
          
          //std::cout<< *buffiter->get()<<",";
            iter->range_next(r1,r2);

        }
        //std::cout<<"here"<<std::endl;
        else if(node_ptr->type == JITD_NODE_BTree)
        {
        

          BTreeNode * node = (BTreeNode *)node_raw;
          //std::cout<<"FI:Btree in next() with sep value " <<node->sep<<std::endl;
          nodeStack.push(node->rhs);
          node_ptr = node->lhs;
          

        }
        else if(node_ptr->type == JITD_NODE_Concat)
        {
          //std::cout<<"found Btree cog in next with sep val"<<node->getSepVal()<<std::endl;
          //std::cout<<"FI:Concat in next() "<<std::endl;
          //iter = node_ptr->iterator();
          iter->range_next(r1,r2);
        
          

        }
        else if(node_ptr->type == JITD_NODE_Singleton)
        {
          //std::cout<<"found Btree cog in next with sep val"<<node->getSepVal()<<std::endl;
          //std::cout<<"FI:Concat in next() "<<std::endl;
          //iter = node_ptr->iterator();
          iter->range_next(r1,r2);
        
          

        }
        else if(node_ptr->type == JITD_NODE_DeleteElements)
        {
          //std::cout<<"found Btree cog in next with sep val"<<node->getSepVal()<<std::endl;

          iter->range_next(r1,r2);
          

        }
        else if(node_ptr->type == JITD_NODE_DeleteSingleton)
        {
          //std::cout<<"found Btree cog in next with sep val"<<node->getSepVal()<<std::endl;

          
          iter->range_next(r1,r2);

        }
        if(!nodeStack.empty() && iter->atEnd())
        {
          //std::cout<<"node stack not empty and iter at end"<<std::endl;
          node_ptr = nodeStack.top();
          nodeStack.pop();
          //std::cout<<"type of node "<<node->type()<<std::endl;
          initNode();
        } 
      }

    }  
    void seek(const Record &k)
    {
      //std::cout<<"in fast iter seek"<<std::endl;
      initroot(k);
      //std::cout<<"Initroot done"<<std::endl;
      while(node_ptr!=NULL)
      {
        JITDNode *node_raw = node_ptr.get();
        if(node_ptr->type == JITD_NODE_BTree)
        {
          
          BTreeNode * node = (BTreeNode *)node_raw;
          std::cout<<"FI:Btree with sep value " <<node->sep<<std::endl;
          if(k < node->sep)
          {
            //std::cout<<"in if"<<std::endl;
            nodeStack.push(node->rhs);
            //std::cout<<"pushed node"<<std::endl;
            node_ptr = node->lhs;
            //std::cout<<"Node lhs sep "<< node->getSepVal()<<std::endl;
            //std::cout<<"FI: seek() stack size "<<nodeStack.size()<<std::endl;
            
          } 
          else
          {
            
            //std::cout<<"in else";
            node_ptr = node->rhs;
            //std::cout<<"Node lhs sep "<< node->getSepVal()<<std::endl;
          }
        }
        else if(node_ptr->type ==  JITD_NODE_Concat)
        {
         //NOTE:CREATES A BRAND NEW ITER EVEN IF AT END ALREADY CREATED IT.
         if(iter.get()==NULL)
         {
          iter = node_ptr->iterator();
          //std::cout<<"FI SEEK(): iter was NULL so created a new iter for the node."<<std::endl;
         } 
          
          //std::cout<<"FI: seek() Concat " <<std::endl;
          if(iter->atEnd() && !nodeStack.empty())
          {
              //std::cout<<"empty buffer node reassigned with sibling"<<std::endl;
              node_ptr = nodeStack.top();
              nodeStack.pop();
              //std::cout<<"stack size "<<nodeStack.size()<<std::endl;
          }
          else
          {
            iter->seek(k);
            if(iter->atEnd() && !nodeStack.empty())
            {
              node_ptr = nodeStack.top();
              nodeStack.pop();
              //std::cout<<"stack size "<<nodeStack.size()<<std::endl;
            }
            else
            {
              return;
            }
            
          }
        }
        else if(node_ptr->type ==  JITD_NODE_DeleteElements)
        {
         //NOTE:CREATES A BRAND NEW ITER EVEN IF AT END ALREADY CREATED IT.
         if(iter.get()==NULL)
         {
          iter = node_ptr->iterator();
          //std::cout<<"FI SEEK(): iter was NULL so created a new iter for the node."<<std::endl;
         } 
          
          //std::cout<<"FI: seek() Concat " <<std::endl;
          if(iter->atEnd() && !nodeStack.empty())
          {
              //std::cout<<"empty buffer node reassigned with sibling"<<std::endl;
              node_ptr = nodeStack.top();
              nodeStack.pop();
              //std::cout<<"stack size "<<nodeStack.size()<<std::endl;
          }
          else
          {
            iter->seek(k);
            if(iter->atEnd() && !nodeStack.empty())
            {
              node_ptr = nodeStack.top();
              nodeStack.pop();
              //std::cout<<"stack size "<<nodeStack.size()<<std::endl;
            }
            else
            {
              return;
            }
            
          }
        }
        else if(node_ptr->type ==  JITD_NODE_DeleteSingleton)
        {
         //NOTE:CREATES A BRAND NEW ITER EVEN IF AT END ALREADY CREATED IT.
         if(iter.get()==NULL)
         {
          iter = node_ptr->iterator();
          //std::cout<<"FI SEEK(): iter was NULL so created a new iter for the node."<<std::endl;
         } 
          
          //std::cout<<"FI: seek() Concat " <<std::endl;
          if(iter->atEnd() && !nodeStack.empty())
          {
              //std::cout<<"empty buffer node reassigned with sibling"<<std::endl;
              node_ptr = nodeStack.top();
              nodeStack.pop();
              //std::cout<<"stack size "<<nodeStack.size()<<std::endl;
          }
          else
          {
            iter->seek(k);
            if(iter->atEnd() && !nodeStack.empty())
            {
              node_ptr = nodeStack.top();
              nodeStack.pop();
              //std::cout<<"stack size "<<nodeStack.size()<<std::endl;
            }
            else
            {
              return;
            }
            
          }
        }
        else if(node_ptr->type ==  JITD_NODE_Singleton)
        {
           if(iter.get()==NULL)
           {
            iter = node_ptr->iterator();
            //std::cout<<"FI SEEK(): iter was NULL so created a new iter for the node."<<std::endl;
           }
          //std::cout<<"FI: seek() Concat " <<std::endl;
          if(iter->atEnd() && !nodeStack.empty())
          {
              //std::cout<<"empty buffer node reassigned with sibling"<<std::endl;
              node_ptr = nodeStack.top();
              nodeStack.pop();
              //std::cout<<"stack size "<<nodeStack.size()<<std::endl;
          }
          else
          {
            iter->seek(k);
            if(iter->atEnd() && !nodeStack.empty())
            {
              node_ptr = nodeStack.top();
              nodeStack.pop();
              //std::cout<<"stack size "<<nodeStack.size()<<std::endl;
            }
            else
            {
              return;
            }
            
          }
        }
        else if(node_ptr->type == JITD_NODE_SortedArray)
        {
          //std::cout<<"Node is sorted array"<<std::endl;
          if(iter.get()==NULL)
           {
            iter = node_ptr->iterator();
            //std::cout<<"FI SEEK(): iter was NULL so created a new iter for the node."<<std::endl;
           }
          
          if(iter->atEnd() && !nodeStack.empty())
          {
              //std::cout<<"empty buffer node reassigned with sibling"<<std::endl;
              node_ptr = nodeStack.top();
              nodeStack.pop();
              //std::cout<<"stack size "<<nodeStack.size()<<std::endl;
          }
          else
          {
            iter->seek(k);
            if(iter->atEnd() && !nodeStack.empty())
            {
              node_ptr = nodeStack.top();
              nodeStack.pop();
              //std::cout<<"stack size "<<nodeStack.size()<<std::endl;
            }
            else
            {
              return;
            }
            
          } 
          
        }
        else if(node_ptr->type == JITD_NODE_Array)
        {
          //std::cout<<" FI: Seek() Node is array"<<std::endl;
          if(iter.get()==NULL)
           {
            iter = node_ptr->iterator();
            //std::cout<<"FI SEEK(): iter was NULL so created a new iter for the node."<<std::endl;
           }
          if(iter->atEnd() && !nodeStack.empty())
          {
              //std::cout<<"Seeked but didnt find key"<<std::endl;
              //std::cout<<"empty buffer node reassigned with sibling"<<std::endl;
              node_ptr = nodeStack.top();
              nodeStack.pop();
          }
          else
          {
            iter->seek(k);
            if(iter->atEnd() && !nodeStack.empty())
            {
              //std::cout<<"Seeked but didnt find key"<<std::endl;
              node_ptr = nodeStack.top();
              nodeStack.pop();
              //std::cout<<"stack size "<<nodeStack.size()<<std::endl;
            }
            else
            {
              //std::cout<<"FI: stack size before seek return "<<nodeStack.size()<<std::endl;
              return;
            }
          } 
        }
        
       }  
    }
    bool atEnd()
    {
      //std::cout<<"fast iter atEnd"<<std::endl;
      if(iter.get()==NULL && node_ptr == NULL)
      {
        //std::cout<<"no iter in fast iter"<<",";
          
            if(jitd_accessor_size(lhs) == 0)
            {
              //std::cout<<"in rhs node"<<std::endl;
              iter = rhs->iterator();
            }
            else
            {
              //std::cout<<"FI at end() creating lhs iter"<<std::endl;
              iter = lhs->iterator();
            }
            bool end = iter->atEnd();
            //std::cout<<"FI call to iter atend() returned"<<std::endl;
            return end;
            //return iter->atEnd();
           
      }
      else if(nodeStack.empty() && iter->atEnd())
      {
        //std::cout<<"node stack E, buffiter E"<<std::endl;
        return true;
      }
      else if(!nodeStack.empty() && iter->atEnd())
      {
        //std::cout<<"node stack NE, buffiter E"<<std::endl;
        return false;
      }
      else if(!nodeStack.empty() && !iter->atEnd())
      {
        //std::cout<<"node stack NE, buffiter NE"<<std::endl;
        return false;
      }
      else
      {
        //std::cout<<"else of atEnd"<<std::endl;
        return false;
      }
    }
    
    // BufferElement<Tuple> get()
    // {
    //   initNeeded();
    //   return lhsDone ? rhsIter->get() : lhsIter->get();
    //}
};