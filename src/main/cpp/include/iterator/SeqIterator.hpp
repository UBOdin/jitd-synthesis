
template <class JITDNode> 
class SeqIterator : public IteratorBase<Record> {
  std::shared_ptr<JITDNode> lhs, rhs;
  Iterator<Record> lhsIter, rhsIter;
  bool lhsDone, rhsDone;
  const long sep;
  
  public: 
    SeqIterator(
      std::shared_ptr<JITDNode> lhs, 
      long sep, 
      std::shared_ptr<JITDNode> rhs
    ) :
      sep(sep), lhs(lhs), rhs(rhs), 
      lhsDone(jitd_accessor_size(lhs) < 1), rhsDone(jitd_accessor_size(rhs) < 1) {}
    
    inline void initNeeded()
    { 
      if(!lhsDone) {
        if(lhsIter.get() == NULL) { 
          lhsIter = lhs->iterator();
          lhsDone = lhsIter->atEnd();
        }
      }
      if(lhsDone)  {
        if(rhsIter.get() == NULL) { 
          rhsIter = rhs->iterator();
          rhsDone = rhsIter->atEnd();
        }
      }
    }

    void next()
    {
      initNeeded();
      if(!lhsDone)     { lhsIter->next(); lhsDone = lhsIter->atEnd(); }
      else if(!rhsDone){ rhsIter->next(); rhsDone = rhsIter->atEnd(); }
    }
    void range_next(const long &r1,const long &r2)
    {
      initNeeded();
      if(!lhsDone)     { lhsIter->range_next(r1,r2); lhsDone = lhsIter->atEnd(); }
      else if(!rhsDone){ rhsIter->range_next(r1,r2); rhsDone = rhsIter->atEnd(); }
    }
    void seek(const Record &k)
    {
      if(k > sep) { lhsDone = true; }
      std::cout<<"key: "<<k<<"sep: "<<sep<<std::endl;
      // check key first... may not need to init LHS.
      initNeeded();
      if(!lhsDone)     { lhsIter->seek(k); lhsDone = lhsIter->atEnd(); }
      else if(!rhsDone){ rhsIter->seek(k); rhsDone = rhsIter->atEnd(); }
    }

    bool atEnd()
    {
      return lhsDone && rhsDone;
    }
    
    Record get()
    {
      initNeeded();
      return lhsDone ? rhsIter->get() : lhsIter->get();
    }
};