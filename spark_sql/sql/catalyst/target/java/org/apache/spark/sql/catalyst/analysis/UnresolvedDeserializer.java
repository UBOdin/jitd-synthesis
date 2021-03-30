package org.apache.spark.sql.catalyst.analysis;
/**
 * Holds the deserializer expression and the attributes that are available during the resolution
 * for it.  Deserializer expression is a special kind of expression that is not always resolved by
 * children output, but by given attributes, e.g. the <code>keyDeserializer</code> in <code>MapGroups</code> should be
 * resolved by <code>groupingAttributes</code> instead of children output.
 * <p>
 * param:  deserializer The unresolved deserializer expression
 * param:  inputAttributes The input attributes used to resolve deserializer expression, can be empty
 *                        if we want to resolve deserializer by children output.
 */
public  class UnresolvedDeserializer extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, org.apache.spark.sql.catalyst.expressions.NonSQLExpression, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression deserializer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttributes ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedDeserializer (org.apache.spark.sql.catalyst.expressions.Expression deserializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttributes)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
}
