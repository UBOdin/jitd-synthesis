Iterator<Record> ConcatNode::iterator()
{
  return Iterator<Record>(new MergeIterator<JITDNode>(lhs,rhs));
}
Iterator<Record> BTreeNode::iterator()
{
  return Iterator<Record>(new FastIterator<JITDNode>(lhs,sep,rhs));
}
Iterator<Record> ArrayNode::iterator()
{
  return Iterator<Record>(new UnsortedBufferIterator<Record>(data));
}
Iterator<Record> SortedArrayNode::iterator()
{
  std::vector<Record>::iterator its = data.begin();
  std::vector<Record>::const_iterator cits = its;
  std::vector<Record>::iterator ite = data.end();
  std::vector<Record>::const_iterator cite = ite;
  return Iterator<Record>(new BufferIterator<Record>(data,cits,cite));
}
Iterator<Record> SingletonNode::iterator()
{
  return Iterator<Record>(new SingletonIterator<Record>(elem));
}
Iterator<Record> DeleteSingletonNode::iterator()
{
  return NULL;
}
Iterator<Record> DeleteElementsNode::iterator()
{
  return NULL;
}