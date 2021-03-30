package org.apache.spark.sql.execution.aggregate;
/**
 * This is a helper class to generate an append-only row-based hash map that can act as a 'cache'
 * for extremely fast key-value lookups while evaluating aggregates (and fall back to the
 * <code>BytesToBytesMap</code> if a given key isn't found). This is 'codegened' in HashAggregate to speed
 * up aggregates w/ key.
 * <p>
 * We also have VectorizedHashMapGenerator, which generates a append-only vectorized hash map.
 * We choose one of the two as the 1st level, fast hash map during aggregation.
 * <p>
 * NOTE: This row-based hash map currently doesn't support nullable keys and falls back to the
 * <code>BytesToBytesMap</code> to store them.
 */
public  class RowBasedHashMapGenerator extends org.apache.spark.sql.execution.aggregate.HashMapGenerator {
  public   RowBasedHashMapGenerator (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> aggregateExpressions, java.lang.String generatedClassName, org.apache.spark.sql.types.StructType groupingKeySchema, org.apache.spark.sql.types.StructType bufferSchema, int bitMaxCapacity)  { throw new RuntimeException(); }
  /**
   * Generates a method that returns true if the group-by keys exist at a given index in the
   * associated {@link org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch}.
   * <p>
   * @return (undocumented)
   */
  protected  java.lang.String generateEquals ()  { throw new RuntimeException(); }
  /**
   * Generates a method that returns a
   * {@link org.apache.spark.sql.catalyst.expressions.UnsafeRow} which keeps track of the
   * aggregate value(s) for a given set of keys. If the corresponding row doesn't exist, the
   * generated method adds the corresponding row in the associated
   * {@link org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch}.
   * <p>
   * @return (undocumented)
   */
  protected  java.lang.String generateFindOrInsert ()  { throw new RuntimeException(); }
  protected  java.lang.String generateRowIterator ()  { throw new RuntimeException(); }
  protected  java.lang.String initializeAggregateHashMap ()  { throw new RuntimeException(); }
}
