template <class Tuple>
class TopKBufferIterator : public IteratorBase<Record> {
  std::vector<Record> data;
  std::vector<Record>::const_iterator curr, start, end;
  const Record key;
  const int size;
  public: 

    // BufferIterator assumes that buff is sorted.
    TopKBufferIterator(std::vector<Record> &data,const Record key,const int size) : 
      data(data), start(data.begin()), curr(data.begin()), end(data.end()),key(key),size(size) {//std::cout<<"BufferIterator Constructor for node with elems:"<<data.size()<<std::endl;
      std::sort(data.begin(),data.end());
      // for(auto it = data.begin();it!=data.end();++it)
      // {
      //   std::cout<<*it<<",";
      // }
    }

    // BufferIterator assumes that buff is sorted.
    TopKBufferIterator(
      std::vector<Record> &data, 
      std::vector<Record>::const_iterator &start, 
      std::vector<Record>::const_iterator &end,
      const Record key,const int size
    ) : 
      data(data), start(start), curr(start), end(end),key(key),size(size) {}

    void next()
    {
      //std::cout<<"BufferIterator next() called"<<std::endl;
      if(curr < end){ curr += 1; }
     // std::cout<<"The value next is:"<<*curr<<std::endl;
    }
    // void range_next(const long &r1,const long &r2)
    // {
    //   //std::cout<<"BufferIterator next() called"<<std::endl;
    //   if(curr < end){ curr += 1; }
    //   if(*curr > r2){curr = end;}
    //  // std::cout<<"The value next is:"<<*curr<<std::endl;
    // }
    // void seek(const Record &k)
    // {
    //   //curr = start;
    //   if(data.size()==0)
    //   {
    //     curr = end;
    //   }
    //   else
    //   {
    //     //std::cout<<"BufferIterator SEEK(): "<<k<<"Curr points at: "<<*curr<<std::endl;
    //     unsigned int d = 1;
    //     std::vector<Record>::const_iterator high = curr;
    //     while((high < end) && (*high < k)){
    //       curr = high;
    //       high += d;
    //       d *= 2;
    //     }
    //     if(high > end){ high = end; }
    //     if(curr < high){
    //       curr = lower_bound(curr, high, k);
    //     }
    //     //std::cout<<"Data size: "<<data.size()<<"End of SEEK(): Curr points at: "<<*curr<<std::endl;
    //   }
      
    // }
void seek(const Record &k,const int s)
    {
      //curr = start;
      if(data.size()==0)
      {
        curr = end;
      }
      else
      {
        //std::cout<<"BufferIterator SEEK(): "<<k<<"Curr points at: "<<*curr<<std::endl;
        unsigned int d = 1;
        std::vector<Record>::const_iterator high = curr;
        while((high < end) && (*high < k)){
          curr = high;
          high += d;
          d *= 2;
        }
        if(high > end){ high = end; }
        if(curr < high){
          curr = lower_bound(curr, high, k);
        }
        //std::cout<<"Data size: "<<data.size()<<"End of SEEK(): Curr points at: "<<*curr<<std::endl;
      }
      
    }
    bool atEnd()
    {
      
      return curr == end;
    }

    Record get()
    {
      return *curr;
    }
};