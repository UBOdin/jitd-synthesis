Iterator<Record> ConcatNode::iterator()
{
  // std::shared_ptr<JITDNode>* lhs_ptr = &lhs;
  // std::shared_ptr<JITDNode>* rhs_ptr = &rhs;
  // return Iterator<Record>(new MergeIterator<JITDNode>(lhs_ptr,rhs_ptr));
  return Iterator<Record>(new MergeIterator<JITDNode>(lhs,rhs));
}
Iterator<Record> BTreeNode::iterator()
{
  // std::shared_ptr<JITDNode>* lhs_ptr = &lhs;
  // std::shared_ptr<JITDNode>* rhs_ptr = &rhs;
  // return Iterator<Record>(new FastIterator<JITDNode>(lhs_ptr,sep,rhs_ptr));
  return Iterator<Record>(new FastIterator<JITDNode>(lhs,sep,rhs));
}
Iterator<Record> ArrayNode::iterator()
{
  
    return Iterator<Record>(new BufferIterator<JITDNode>(data));
  
}
Iterator<Record> SortedArrayNode::iterator()
{
  std::vector<Record>::iterator its = data.begin();
  std::vector<Record>::const_iterator cits = its;
  std::vector<Record>::iterator ite = data.end();
  std::vector<Record>::const_iterator cite = ite;
  return Iterator<Record>(new BufferIterator<JITDNode>(data,cits,cite));
}
Iterator<Record> SingletonNode::iterator()
{
  return Iterator<Record>(new SingletonIterator<JITDNode>(elem));
}
Iterator<Record> DeleteSingletonNode::iterator()
{
  return Iterator<Record>(new DeleteSingletonIterator<JITDNode>(node,elem));
}
Iterator<Record> DeleteElementsNode::iterator()
{
  return Iterator<Record>(new DeleteElemIterator<JITDNode>(node,data));
}
