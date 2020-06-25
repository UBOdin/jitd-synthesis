template <class Tuple>
class TopKUnsortedBufferIterator : public IteratorBase<Record> {
  std::vector<Record> data;
  //std::vector<Record>::const_iterator curr, start, end;
  //std::priority_queue<Record,std::vector<Record>,std::greater<Record>> topk_pq;
  std::priority_queue<Record> topk_pq;
  const Record key;
  const int size;
  public: 

    // BufferIterator assumes that buff is sorted.
    TopKUnsortedBufferIterator(std::vector<Record> &data,const Record key,const int size) : 
      data(data),key(key),size(size) {//std::cout<<"BufferIterator Constructor for node with elems:"<<data.size()<<std::endl;
      //std::sort(data.begin(),data.end());
      // for(auto it = data.begin();it!=data.end();++it)
      // {
      //   std::cout<<"The value in data is: "<<*it<<std::endl;
      // }
      
      std::vector<Record>::const_iterator it;
      for(it = data.begin();it!=data.end();++it)
      {

        if(topk_pq.size()<size)
        {
          if(*it == key)
          {
            topk_pq.emplace(*it);
            //std::cout<<"EMPLACING: "<<*it<<std::endl;
            
          }
          else if(*it > key)
          {
            topk_pq.emplace(*it);
            //std::cout<<"EMPLACING: "<<*it<<std::endl;
            
          }
        }
        else
        {
          if(*it > key && *it < topk_pq.top())
          {
            //std::cout<<"POPPING: "<<topk_pq.top()<<std::endl;
            topk_pq.pop();
            topk_pq.emplace(*it);
            //std::cout<<"EMPLACING: "<<*it<<std::endl;
          }
        }

      }
      //std::cout<<"Size of topk_pq"<<topk_pq.size()<<std::endl;
    }

    void next()
    {
      //std::cout<<"BufferIterator next() called"<<std::endl;
      //if(curr < end){ curr += 1; }
     // std::cout<<"The value next is:"<<*curr<<std::endl;
      if(!topk_pq.empty()){topk_pq.pop();}
    }
    
void seek(const Record &k,const int s)
    {
      //curr = start;
      //std::cout<<"Seek does nothing here"<<std::endl;
      // std::vector<Record>::const_iterator it;
      // for(it = data.begin();it!=data.end();++it)
      // {

      //   if(topk_pq.size()<s)
      //   {
      //     if(*it == k)
      //     {
      //       topk_pq.emplace(*it);
            
      //     }
      //     else if(*it > k)
      //     {
      //       topk_pq.emplace(*it);
            
      //     }
      //   }
      //   else
      //   {
      //     if(*it > k && *it < topk_pq.top())
      //     {
      //       topk_pq.pop();
      //       topk_pq.emplace(*it);
      //     }
      //   }

      // }
      // std::cout<<"Size of topk_pq"<<topk_pq.size()<<std::endl;
      // while(!topk_pq.empty())
      // {
      //   std::cout<<"The top of topk_pq is: "<<topk_pq.top();
      //   topk_pq.pop();
      // }
      
    }
    bool atEnd()
    {
      
      //return curr == end;
      return topk_pq.empty();
    }

    Record get()
    {
      //return *curr;
      return topk_pq.top();
    }
};