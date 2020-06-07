template <class Tuple>
class SingletonIterator : public IteratorBase<Record> {
  Record data;
  bool done;
  
  public: 

  
    SingletonIterator(Record &data) : 
      data(data),done(false) {}
      
 

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
      return done;
    }

   Record get()
    {
      done = true;
      return data;
    }
};