template <class JITDNode> 
class DeleteElemIterator : public IteratorBase<Record> {
  std::shared_ptr<JITDNode> source;
  std::vector<Key> keys;
  Iterator<Record> sourceIter;
  bool sourceEnd;
  
  public: 

    DeleteElemIterator(std::shared_ptr<JITDNode> source,
    std::vector<Key> keys
    ) : source(source),keys(keys)
    {
      sourceIter = source->iterator();
      sourceEnd = sourceIter->atEnd();

    }
    void next()
    {
      if(sourceIter->atEnd()) { return; }
      sourceIter->next();
      advanceWhileCurrentTupleIsInvalid();
    }
    void seek(const Record &k)
    {
      if(sourceIter->atEnd()) { return; }
      sourceIter->seek(k);
      advanceWhileCurrentTupleIsInvalid();
    }
    bool atEnd()
    {
      return sourceIter->atEnd();
    }
    Record get()
    {
      return sourceIter->get();
    }
  
  private:
  
    inline void advanceWhileCurrentTupleIsInvalid()
    {
      //std::vector<Record>::const_iterator it;
      for(auto it = keys.begin();it!=keys.end();++it)
      {
          if(*it == sourceIter->get())
          {
            sourceIter->next();
          }
      }

//       if(!sourceIter->atEnd() && !delIter->atEnd()){ 
//         if(*delIter->get() < *sourceIter->get()){
//           delIter->seek(*sourceIter->get()); 
//         }
// //        std::cerr << "At : " << *sourceIter->get() << "<=>" << *delIter->get() << std::endl;
//       }
//       while(!sourceIter->atEnd() && !delIter->atEnd() &&
//             (*sourceIter->get() == *delIter->get())){
//         sourceIter->next();
//         delIter->next();
//         if(*delIter->get() < *sourceIter->get()){
//           delIter->seek(*sourceIter->get());
//         }
// //        if(!sourceIter->atEnd() && !delIter->atEnd()){
// //          std::cerr << "Skip To : " << *sourceIter->get() << "<=>" << *delIter->get() << std::endl;
// //        }
//       }
    }
};