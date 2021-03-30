package org.apache.spark.sql.catalyst.expressions;
public  class AttributeMap<A extends java.lang.Object> implements scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.Attribute, A>, scala.Serializable {
  static public <A extends java.lang.Object> org.apache.spark.sql.catalyst.expressions.AttributeMap<A> apply (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, A>> kvs)  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> org.apache.spark.sql.catalyst.expressions.AttributeMap<A> empty ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.ExprId, scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, A>> baseMap ()  { throw new RuntimeException(); }
  // not preceding
  public   AttributeMap (scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.ExprId, scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, A>> baseMap)  { throw new RuntimeException(); }
  public  scala.Option<A> get (org.apache.spark.sql.catalyst.expressions.Attribute k)  { throw new RuntimeException(); }
  public  boolean contains (org.apache.spark.sql.catalyst.expressions.Attribute k)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, A>> iterator ()  { throw new RuntimeException(); }
}
