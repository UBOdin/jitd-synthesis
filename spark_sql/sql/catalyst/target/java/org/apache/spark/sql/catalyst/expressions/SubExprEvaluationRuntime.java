package org.apache.spark.sql.catalyst.expressions;
/**
 * This class helps subexpression elimination for interpreted evaluation
 * such as <code>InterpretedUnsafeProjection</code>. It maintains an evaluation cache.
 * This class wraps <code>ExpressionProxy</code> around given expressions. The <code>ExpressionProxy</code>
 * intercepts expression evaluation and loads from the cache first.
 */
public  class SubExprEvaluationRuntime {
  public   SubExprEvaluationRuntime (int cacheMaxEntries)  { throw new RuntimeException(); }
    com.google.common.cache.LoadingCache<org.apache.spark.sql.catalyst.expressions.ExpressionProxy, org.apache.spark.sql.catalyst.expressions.ResultProxy> cache ()  { throw new RuntimeException(); }
  public  Object getEval (org.apache.spark.sql.catalyst.expressions.ExpressionProxy proxy)  { throw new RuntimeException(); }
  /**
   * Finds subexpressions and wraps them with <code>ExpressionProxy</code>.
   * @param expressions (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> proxyExpressions (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions)  { throw new RuntimeException(); }
  /**
   * Sets given input row as current row for evaluating expressions. This cleans up the cache
   * too as new input comes.
   * @param input (undocumented)
   */
  public  void setInput (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
}
