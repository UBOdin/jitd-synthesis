package org.apache.spark.sql.catalyst.expressions;
/**
 * Separate v1, ..., vk into n rows. Each row will have k/n columns. n must be constant.
 * <pre><code>
 *   SELECT stack(2, 1, 2, 3) -&gt;
 *   1      2
 *   3      NULL
 * </code></pre>
 */
public  class Stack extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Generator, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public   Stack (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  /**
   * Return true iff the first child exists and has a foldable IntegerType.
   * @return (undocumented)
   */
  public  boolean hasFoldableNumRows ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType findDataType (int index)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType elementSchema ()  { throw new RuntimeException(); }
  public  scala.collection.TraversableOnce<org.apache.spark.sql.catalyst.InternalRow> eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  /**
   * Only support code generation when stack produces 50 rows or less.
   * @return (undocumented)
   */
  public  boolean supportCodegen ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
