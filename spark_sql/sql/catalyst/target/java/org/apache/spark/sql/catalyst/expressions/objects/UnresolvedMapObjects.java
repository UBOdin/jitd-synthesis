package org.apache.spark.sql.catalyst.expressions.objects;
/**
 * When constructing {@link MapObjects}, the element type must be given, which may not be available
 * before analysis. This class acts like a placeholder for {@link MapObjects}, and will be replaced by
 * {@link MapObjects} during analysis after the input data is resolved.
 * Note that, ideally we should not serialize and send unresolved expressions to executors, but
 * users may accidentally do this(e.g. mistakenly reference an encoder instance when implementing
 * Aggregator). Here we mark <code>function</code> as transient because it may reference scala Type, which is
 * not serializable. Then even users mistakenly reference unresolved expression and serialize it,
 * it's just a performance issue(more network traffic), and will not fail.
 */
public  class UnresolvedMapObjects extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> function ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Class<?>> customCollectionCls ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedMapObjects (scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> function, org.apache.spark.sql.catalyst.expressions.Expression child, scala.Option<java.lang.Class<?>> customCollectionCls)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
}
