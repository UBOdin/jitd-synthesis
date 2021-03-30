package org.apache.spark.sql.catalyst.expressions;
/**
 * A MurMur3 Hash expression.
 * <p>
 * We should use this hash function for both shuffle and bucket, so that we can guarantee shuffle
 * and bucketing have same data distribution.
 */
public  class Murmur3Hash extends org.apache.spark.sql.catalyst.expressions.HashExpression<java.lang.Object> implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  int seed ()  { throw new RuntimeException(); }
  // not preceding
  public   Murmur3Hash (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children, int seed)  { throw new RuntimeException(); }
  public   Murmur3Hash (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  protected  java.lang.String hasherClassName ()  { throw new RuntimeException(); }
  protected  int computeHash (Object value, org.apache.spark.sql.types.DataType dataType, int seed)  { throw new RuntimeException(); }
}
