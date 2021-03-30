package org.apache.spark.sql.catalyst.expressions;
/**
 * Returns a random permutation of the given array.
 */
public  class Shuffle extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, org.apache.spark.sql.catalyst.expressions.Stateful, org.apache.spark.sql.catalyst.expressions.ExpressionWithRandomSeed, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public final  boolean deterministic ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> randomSeed ()  { throw new RuntimeException(); }
  // not preceding
  public   Shuffle (org.apache.spark.sql.catalyst.expressions.Expression child, scala.Option<java.lang.Object> randomSeed)  { throw new RuntimeException(); }
  public   Shuffle (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression seedExpression ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Shuffle withNewSeed (long seed)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.DataType elementType ()  { throw new RuntimeException(); }
  protected  void initializeInternal (int partitionIndex)  { throw new RuntimeException(); }
  protected  Object evalInternal (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Shuffle freshCopy ()  { throw new RuntimeException(); }
}
