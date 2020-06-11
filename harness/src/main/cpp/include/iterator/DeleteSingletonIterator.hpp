template <class JITDNode> 
class DeleteSingletonIterator : public IteratorBase<Record> {
  std::shared_ptr<JITDNode> source;
  Key key;
  Iterator<Record> sourceIter;
  bool sourceEnd;
  
  public: 

    DeleteSingletonIterator(const std::shared_ptr<JITDNode> &source,
    const Key key
    ) : source(source),key(key)
    {
      sourceIter = source->iterator();
      sourceEnd = sourceIter->atEnd();

    }
    void next()
    {
      if(sourceIter->atEnd()) { return; }
      sourceIter->next();
      if(key == sourceIter->get())
      {
        sourceIter->next();
      }
    }
    void seek(const Record &k)
    {
      if(sourceIter->atEnd()) { return; }
      sourceIter->seek(k);
      if(key == sourceIter->get())
      {
        sourceIter->next();
      }
    }
    bool atEnd()
    {
      return sourceIter->atEnd();
    }
    Record get()
    {
      return sourceIter->get();
    }
  
};