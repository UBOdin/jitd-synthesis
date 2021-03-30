package org.apache.spark.sql.catalyst.expressions;
/**
 * Creates a String containing all the elements of the input array separated by the delimiter.
 */
public  class ArrayJoin extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression array ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression delimiter ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> nullReplacement ()  { throw new RuntimeException(); }
  // not preceding
  public   ArrayJoin (org.apache.spark.sql.catalyst.expressions.Expression array, org.apache.spark.sql.catalyst.expressions.Expression delimiter, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> nullReplacement)  { throw new RuntimeException(); }
  public   ArrayJoin (org.apache.spark.sql.catalyst.expressions.Expression array, org.apache.spark.sql.catalyst.expressions.Expression delimiter)  { throw new RuntimeException(); }
  public   ArrayJoin (org.apache.spark.sql.catalyst.expressions.Expression array, org.apache.spark.sql.catalyst.expressions.Expression delimiter, org.apache.spark.sql.catalyst.expressions.Expression nullReplacement)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
