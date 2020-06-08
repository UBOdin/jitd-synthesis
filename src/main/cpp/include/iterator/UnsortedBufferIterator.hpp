template <class Tuple>
class UnsortedBufferIterator : public IteratorBase<Record> {
  std::vector<Record> data;
  std::vector<Record>::const_iterator curr, start, end;
  
  public: 

    // BufferIterator assumes that buff is sorted.
    UnsortedBufferIterator(std::vector<Record> &data) : 
      data(data), start(data.begin()), curr(data.begin()), end(data.end()) {}

    
    UnsortedBufferIterator(
      std::vector<Record> &data, 
      std::vector<Record>::const_iterator &start, 
      std::vector<Record>::const_iterator &end
    ) : 
      data(data), start(start), curr(start), end(end) {}

    void next()
    {
      //std::cout<<"BufferIterator next() called"<<std::endl;
      if(curr < end){ curr += 1; }
     //std::cout<<"The value next is:"<<*curr<<std::endl;
    }
    void range_next(const long &r1,const long &r2)
    {
      //std::cout<<"BufferIterator next() called"<<std::endl;
      
      //if(curr < end){ curr += 1; }
      // while(*curr < r1-1)
      // {
      //   next();
      // }
      // while(*curr > r2-1)
      // {
      //   next();
      // }
      next();
      
      //if(*curr > r2){std::cout<<"curr repositioned to end"<<std::endl;curr = end;}
     // std::cout<<"The value next is:"<<*curr<<std::endl;
    }
    void seek(const Record &k)
    {
      curr = start;
    }

    bool atEnd()
    {

      return curr == end;
    }

    Record get()
    {
      if(data.size()!=0)
      {
        return *curr;
      }
      else
      {
        return 0;
      }
      
    }
};