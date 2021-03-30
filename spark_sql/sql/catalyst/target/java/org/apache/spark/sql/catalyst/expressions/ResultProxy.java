package org.apache.spark.sql.catalyst.expressions;
/**
 * A simple wrapper for holding <code>Any</code> in the cache of <code>SubExprEvaluationRuntime</code>.
 */
public  class ResultProxy implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  Object result ()  { throw new RuntimeException(); }
  // not preceding
  public   ResultProxy (Object result)  { throw new RuntimeException(); }
}
