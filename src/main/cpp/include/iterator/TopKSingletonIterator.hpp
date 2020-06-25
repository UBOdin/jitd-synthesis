template <class Tuple>
class TopKSingletonIterator : public IteratorBase<Record> {
  Record data;
  bool done;
  const Record key;
  const int size;
  public: 

  
    TopKSingletonIterator(const Record &data,const Record key,const int size) : 
      data(data),done(false),key(key),size(size) {
        //std::cout<<"SingletonIterator created for "<<data<<std::endl;
      }
      
 

    // void next()
    // {
    //   //done = true;
    // }
    // void range_next(const long &r1,const long &r2)
    // {
    //   //done = true;
    // }
    // void seek(const Record &k)
    // {
    //   //done = true;
    // }

    bool atEnd()
    {
      //std::cout<<"SingletonIterator atEnd"<<std::endl;
      return done;
    }

   Record get()
    {
      done = true;
      return data;
    }
};