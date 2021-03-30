package org.apache.spark.sql.execution.aggregate;
/**
 * This is a helper class to generate an append-only row-based hash map that can act as a 'cache'
 * for extremely fast key-value lookups while evaluating aggregates (and fall back to the
 * <code>BytesToBytesMap</code> if a given key isn't found). This is 'codegened' in HashAggregate to speed
 * up aggregates w/ key.
 * <p>
 * NOTE: the generated hash map currently doesn't support nullable keys and falls back to the
 * <code>BytesToBytesMap</code> to store them.
 */
public abstract class HashMapGenerator {
  public  class Buffer implements scala.Product, scala.Serializable {
    static public abstract  R apply (T1 v1, T2 v2)  ;
    static public  java.lang.String toString ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
    public  java.lang.String name ()  { throw new RuntimeException(); }
    // not preceding
    public   Buffer (org.apache.spark.sql.types.DataType dataType, java.lang.String name)  { throw new RuntimeException(); }
  }
  public  class Buffer$ extends scala.runtime.AbstractFunction2<org.apache.spark.sql.types.DataType, java.lang.String, org.apache.spark.sql.execution.aggregate.HashMapGenerator.Buffer> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Buffer$ MODULE$ = null;
    public   Buffer$ ()  { throw new RuntimeException(); }
  }
  public   HashMapGenerator (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> aggregateExpressions, java.lang.String generatedClassName, org.apache.spark.sql.types.StructType groupingKeySchema, org.apache.spark.sql.types.StructType bufferSchema)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> buffVars ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.aggregate.HashMapGenerator.Buffer> bufferValues ()  { throw new RuntimeException(); }
  protected final  java.lang.String genComputeHash (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, java.lang.String input, org.apache.spark.sql.types.DataType dataType, java.lang.String result)  { throw new RuntimeException(); }
  public  java.lang.String generate ()  { throw new RuntimeException(); }
  protected final  java.lang.String generateClose ()  { throw new RuntimeException(); }
  /**
   * Generates a method that returns true if the group-by keys exist at a given index.
   * @return (undocumented)
   */
  protected abstract  java.lang.String generateEquals ()  ;
  /**
   * Generates a method that returns a row which keeps track of the
   * aggregate value(s) for a given set of keys. If the corresponding row doesn't exist, the
   * generated method adds the corresponding row in the associated key value batch.
   * @return (undocumented)
   */
  protected abstract  java.lang.String generateFindOrInsert ()  ;
  /**
   * Generates a method that computes a hash by currently xor-ing all individual group-by keys. For
   * instance, if we have 2 long group-by keys, the generated function would be of the form:
   * <p>
   * <pre><code>
   * private long hash(long agg_key, long agg_key1) {
   *   return agg_key ^ agg_key1;
   *   }
   * </code></pre>
   * @return (undocumented)
   */
  protected final  java.lang.String generateHashFunction ()  { throw new RuntimeException(); }
  protected abstract  java.lang.String generateRowIterator ()  ;
  public  java.lang.String groupingKeySignature ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.aggregate.HashMapGenerator.Buffer> groupingKeys ()  { throw new RuntimeException(); }
  protected abstract  java.lang.String initializeAggregateHashMap ()  ;
}
