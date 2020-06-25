template <class JITDNode> 
class TopKDeleteSingletonIterator : public IteratorBase<Record> {
  std::shared_ptr<JITDNode> source;
  Key data;
  Iterator<Record> sourceIter;
  bool sourceEnd;
  const Record key;
  const int size;
  
  public: 

    TopKDeleteSingletonIterator(const std::shared_ptr<JITDNode> &source,
    const Key data,const Record key,const int size
    ) : source(source),data(data),key(key),size(size)
    {
      sourceIter = source->iterator(key,size);
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
    void seek(const Record &k,const int size)
    {
      if(sourceIter->atEnd()) { return; }
      sourceIter->seek(k,size);
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