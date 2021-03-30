package org.apache.spark.sql.catalyst.expressions;
/**
 * Returns monotonically increasing 64-bit integers.
 * <p>
 * The generated ID is guaranteed to be monotonically increasing and unique, but not consecutive.
 * The current implementation puts the partition ID in the upper 31 bits, and the lower 33 bits
 * represent the record number within each partition. The assumption is that the data frame has
 * less than 1 billion partitions, and each partition has less than 8 billion records.
 * <p>
 * Since this expression is stateful, it cannot be a case object.
 */
public  class MonotonicallyIncreasingID extends org.apache.spark.sql.catalyst.expressions.LeafExpression implements org.apache.spark.sql.catalyst.expressions.Stateful, scala.Product, scala.Serializable {
  static public abstract  R apply ()  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public final  boolean deterministic ()  { throw new RuntimeException(); }
  public   MonotonicallyIncreasingID ()  { throw new RuntimeException(); }
  /**
   * Record ID within each partition. By being transient, count's value is reset to 0 every time
   * we serialize and deserialize and initialize it.
   * @param partitionIndex (undocumented)
   */
  protected  void initializeInternal (int partitionIndex)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  protected  long evalInternal (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.MonotonicallyIncreasingID freshCopy ()  { throw new RuntimeException(); }
}
