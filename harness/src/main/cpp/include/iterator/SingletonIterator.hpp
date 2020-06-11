template <class Tuple>
class SingletonIterator : public IteratorBase<Record> {
  Record data;
  bool done;
  
  public: 

  
    SingletonIterator(const Record &data) : 
      data(data),done(false) {
        //std::cout<<"SingletonIterator created for "<<data<<std::endl;
      }
      
 

    void next()
    {
      //done = true;
    }
    void range_next(const long &r1,const long &r2)
    {
      //done = true;
    }
    void seek(const Record &k)
    {
      //done = true;
    }

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