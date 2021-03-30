package org.apache.spark.sql.catalyst.expressions;
public abstract class RowNumberLike extends org.apache.spark.sql.catalyst.expressions.AggregateWindowFunction {
  public   RowNumberLike ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> initialValues ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Literal one ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.AttributeReference rowNumber ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> updateExpressions ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Literal zero ()  { throw new RuntimeException(); }
}
