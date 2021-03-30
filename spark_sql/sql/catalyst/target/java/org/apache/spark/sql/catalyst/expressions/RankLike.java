package org.apache.spark.sql.catalyst.expressions;
/**
 * A RankLike function is a WindowFunction that changes its value based on a change in the value of
 * the order of the window in which is processed. For instance, when the value of <code>input</code> changes
 * in a window ordered by <code>input</code> the rank function also changes. The size of the change of the
 * rank function is (typically) not dependent on the size of the change in <code>input</code>.
 * <p>
 * This documentation has been based upon similar documentation for the Hive and Presto projects.
 */
public abstract class RankLike extends org.apache.spark.sql.catalyst.expressions.AggregateWindowFunction {
  public   RankLike ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression evaluateExpression ()  { throw new RuntimeException(); }
  /** Increase the rank when the current rank == 0 or when the one of order attributes changes. */
  protected  org.apache.spark.sql.catalyst.expressions.If increaseRank ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Expression increaseRowNumber ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> initialValues ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Literal one ()  { throw new RuntimeException(); }
  /** Store the values of the window 'order' expressions. */
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> orderAttrs ()  { throw new RuntimeException(); }
  /** Predicate that detects if the order attributes have changed. */
  protected  org.apache.spark.sql.catalyst.expressions.Expression orderEquals ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Literal> orderInit ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.AttributeReference rank ()  { throw new RuntimeException(); }
  /**
   * Different RankLike implementations use different source expressions to update their rank value.
   * Rank for instance uses the number of rows seen, whereas DenseRank uses the number of changes.
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.expressions.Expression rankSource ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.AttributeReference rowNumber ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> updateExpressions ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.expressions.RankLike withOrder (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> order)  ;
  protected  org.apache.spark.sql.catalyst.expressions.Literal zero ()  { throw new RuntimeException(); }
}
