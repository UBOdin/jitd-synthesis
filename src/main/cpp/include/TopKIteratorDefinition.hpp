Iterator<Record> ConcatNode::iterator(const Record key,const int size)
{
  // std::shared_ptr<JITDNode>* lhs_ptr = &lhs;
  // std::shared_ptr<JITDNode>* rhs_ptr = &rhs;
  // return Iterator<Record>(new MergeIterator<JITDNode>(lhs_ptr,rhs_ptr));
  return Iterator<Record>(new TopKMergeIterator<JITDNode>(lhs,rhs,key,size));
}
Iterator<Record> BTreeNode::iterator(const Record key,const int size)
{
  // std::shared_ptr<JITDNode>* lhs_ptr = &lhs;
  // std::shared_ptr<JITDNode>* rhs_ptr = &rhs;
  // return Iterator<Record>(new FastIterator<JITDNode>(lhs_ptr,sep,rhs_ptr));
  return Iterator<Record>(new TopKFastIterator<JITDNode>(lhs,sep,rhs,key,size));
}
Iterator<Record> ArrayNode::iterator(const Record key,const int size)
{
  if(data.size()>size)
  {
    return Iterator<Record>(new TopKUnsortedBufferIterator<JITDNode>(data,key,size));
  }
  else
  {
    return Iterator<Record>(new TopKBufferIterator<JITDNode>(data,key,size));
  }
}
Iterator<Record> SortedArrayNode::iterator(const Record key,const int size)
{
  std::vector<Record>::iterator its = data.begin();
  std::vector<Record>::const_iterator cits = its;
  std::vector<Record>::iterator ite = data.end();
  std::vector<Record>::const_iterator cite = ite;
  return Iterator<Record>(new TopKBufferIterator<JITDNode>(data,cits,cite,key,size));
}
Iterator<Record> SingletonNode::iterator(const Record key,const int size)
{
  return Iterator<Record>(new TopKSingletonIterator<JITDNode>(elem,key,size));
}
Iterator<Record> DeleteSingletonNode::iterator(const Record key,const int size)
{
  return Iterator<Record>(new TopKDeleteSingletonIterator<JITDNode>(node,elem,key,size));
}
Iterator<Record> DeleteElementsNode::iterator(const Record key,const int size)
{
  return Iterator<Record>(new TopKDeleteElemIterator<JITDNode>(node,data,key,size));
}
