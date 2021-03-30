package org.apache.spark.sql.catalyst.analysis;
/**
 * Represents unresolved ordinal used in order by or group by.
 * <p>
 * For example:
 * <pre><code>
 *   select a from table order by 1
 *   select a   from table group by 1
 * </code></pre>
 * param:  ordinal ordinal starts from 1, instead of 0
 */
public  class UnresolvedOrdinal extends org.apache.spark.sql.catalyst.expressions.LeafExpression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, org.apache.spark.sql.catalyst.expressions.NonSQLExpression, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int ordinal ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedOrdinal (int ordinal)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
}
