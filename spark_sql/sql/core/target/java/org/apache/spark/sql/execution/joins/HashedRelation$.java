package org.apache.spark.sql.execution.joins;
public  class HashedRelation$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HashedRelation$ MODULE$ = null;
  public   HashedRelation$ ()  { throw new RuntimeException(); }
  /**
   * Create a HashedRelation from an Iterator of InternalRow.
   * <p>
   * @param allowsNullKey Allow NULL keys in HashedRelation.
   *                      This is used for full outer join in <code>ShuffledHashJoinExec</code> only.
   * @param input (undocumented)
   * @param key (undocumented)
   * @param sizeEstimate (undocumented)
   * @param taskMemoryManager (undocumented)
   * @param isNullAware (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.joins.HashedRelation apply (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> key, int sizeEstimate, org.apache.spark.memory.TaskMemoryManager taskMemoryManager, boolean isNullAware, boolean allowsNullKey)  { throw new RuntimeException(); }
}
