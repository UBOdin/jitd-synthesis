package org.apache.spark.sql.catalyst.expressions;
/**
 * Builds a map that is keyed by an Attribute's expression id. Using the expression id allows values
 * to be looked up even when the attributes used differ cosmetically (i.e., the capitalization
 * of the name, or the expected nullability).
 */
public  class AttributeMap$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final AttributeMap$ MODULE$ = null;
  public   AttributeMap$ ()  { throw new RuntimeException(); }
  public <A extends java.lang.Object> org.apache.spark.sql.catalyst.expressions.AttributeMap<A> apply (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, A>> kvs)  { throw new RuntimeException(); }
  public <A extends java.lang.Object> org.apache.spark.sql.catalyst.expressions.AttributeMap<A> empty ()  { throw new RuntimeException(); }
}
