package org.apache.spark.sql.catalyst.expressions;
public  class ExpressionSet implements scala.collection.Iterable<org.apache.spark.sql.catalyst.expressions.Expression> {
  protected   ExpressionSet (scala.collection.mutable.Set<org.apache.spark.sql.catalyst.expressions.Expression> baseSet, scala.collection.mutable.Buffer<org.apache.spark.sql.catalyst.expressions.Expression> originals)  { throw new RuntimeException(); }
  protected  void add (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  protected  void remove (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  public  boolean contains (org.apache.spark.sql.catalyst.expressions.Expression elem)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet filter (scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, java.lang.Object> p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet filterNot (scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, java.lang.Object> p)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet map (scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> f)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet flatMap (scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, scala.collection.Iterable<org.apache.spark.sql.catalyst.expressions.Expression>> f)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.Expression> iterator ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet union (org.apache.spark.sql.catalyst.expressions.ExpressionSet that)  { throw new RuntimeException(); }
  public  boolean subsetOf (org.apache.spark.sql.catalyst.expressions.ExpressionSet that)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet intersect (org.apache.spark.sql.catalyst.expressions.ExpressionSet that)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet diff (org.apache.spark.sql.catalyst.expressions.ExpressionSet that)  { throw new RuntimeException(); }
  public  boolean apply (org.apache.spark.sql.catalyst.expressions.Expression elem)  { throw new RuntimeException(); }
  public  boolean equals (Object obj)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet clone ()  { throw new RuntimeException(); }
  /**
   * Returns a string containing both the post {@link Canonicalize} expressions and the original
   * expressions in this set.
   * @return (undocumented)
   */
  public  java.lang.String toDebugString ()  { throw new RuntimeException(); }
}
