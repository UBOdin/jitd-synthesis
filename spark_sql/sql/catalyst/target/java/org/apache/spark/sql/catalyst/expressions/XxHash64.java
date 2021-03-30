package org.apache.spark.sql.catalyst.expressions;
/**
 * A xxHash64 64-bit hash expression.
 */
public  class XxHash64 extends org.apache.spark.sql.catalyst.expressions.HashExpression<java.lang.Object> implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  long seed ()  { throw new RuntimeException(); }
  // not preceding
  public   XxHash64 (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children, long seed)  { throw new RuntimeException(); }
  public   XxHash64 (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  protected  java.lang.String hasherClassName ()  { throw new RuntimeException(); }
  protected  long computeHash (Object value, org.apache.spark.sql.types.DataType dataType, long seed)  { throw new RuntimeException(); }
}
