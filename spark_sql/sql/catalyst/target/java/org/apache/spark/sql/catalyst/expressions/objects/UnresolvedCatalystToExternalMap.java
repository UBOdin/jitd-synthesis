package org.apache.spark.sql.catalyst.expressions.objects;
/**
 * Similar to {@link UnresolvedMapObjects}, this is a placeholder of {@link CatalystToExternalMap}.
 * <p>
 * param:  child An expression that when evaluated returns a map object.
 * param:  keyFunction The function applied on the key collection elements.
 * param:  valueFunction The function applied on the value collection elements.
 * param:  collClass The type of the resulting collection.
 */
public  class UnresolvedCatalystToExternalMap extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> keyFunction ()  { throw new RuntimeException(); }
  public  scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> valueFunction ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> collClass ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedCatalystToExternalMap (org.apache.spark.sql.catalyst.expressions.Expression child, scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> keyFunction, scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> valueFunction, java.lang.Class<?> collClass)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
}
