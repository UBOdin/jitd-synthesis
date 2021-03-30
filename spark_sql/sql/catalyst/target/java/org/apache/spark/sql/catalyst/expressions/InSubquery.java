package org.apache.spark.sql.catalyst.expressions;
/**
 * Evaluates to <code>true</code> if <code>values</code> are returned in <code>query</code>'s result set.
 */
public  class InSubquery extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Predicate, org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> values ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ListQuery query ()  { throw new RuntimeException(); }
  // not preceding
  public   InSubquery (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> values, org.apache.spark.sql.catalyst.expressions.ListQuery query)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
