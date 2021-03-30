package org.apache.spark.sql.catalyst.expressions;
/**
 * An aggregate expression that gets rewritten (currently by the optimizer) into a
 * different aggregate expression for evaluation. This is mainly used to provide compatibility
 * with other databases. For example, we use this to support every, any/some aggregates by rewriting
 * them with Min and Max respectively.
 */
public  interface UnevaluableAggregate {
  public  scala.runtime.Nothing$ aggBufferAttributes ()  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression evaluateExpression ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> initialValues ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> mergeExpressions ()  ;
  public  boolean nullable ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> updateExpressions ()  ;
}
