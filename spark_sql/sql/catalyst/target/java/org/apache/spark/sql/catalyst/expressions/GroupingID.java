package org.apache.spark.sql.catalyst.expressions;
/**
 * GroupingID is a function that computes the level of grouping.
 * <p>
 * If groupByExprs is empty, it means all grouping expressions in GroupingSets.
 */
public  class GroupingID extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> groupByExprs ()  { throw new RuntimeException(); }
  // not preceding
  public   GroupingID (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> groupByExprs)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
