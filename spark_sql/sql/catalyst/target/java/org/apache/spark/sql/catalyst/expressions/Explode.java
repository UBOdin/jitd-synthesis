package org.apache.spark.sql.catalyst.expressions;
/**
 * Given an input array produces a sequence of rows for each value in the array.
 * <p>
 * <pre><code>
 *   SELECT explode(array(10,20)) -&gt;
 *   10
 *   20
 * </code></pre>
 */
public  class Explode extends org.apache.spark.sql.catalyst.expressions.ExplodeBase implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  // not preceding
  public   Explode (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public  boolean position ()  { throw new RuntimeException(); }
}
