package org.apache.spark.sql.execution.adaptive;
/**
 * A shuffle query stage whose child is a {@link ShuffleExchangeLike} or {@link ReusedExchangeExec}.
 * <p>
 * param:  id the query stage id.
 * param:  plan the underlying plan.
 * param:  _canonicalized the canonicalized plan before applying query stage optimizer rules.
 */
public  class ShuffleQueryStageExec extends org.apache.spark.sql.execution.adaptive.QueryStageExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int id ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan plan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan _canonicalized ()  { throw new RuntimeException(); }
  // not preceding
  public   ShuffleQueryStageExec (int id, org.apache.spark.sql.execution.SparkPlan plan, org.apache.spark.sql.execution.SparkPlan _canonicalized)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.exchange.ShuffleExchangeLike shuffle ()  { throw new RuntimeException(); }
  public  scala.concurrent.Future<java.lang.Object> doMaterialize ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.adaptive.QueryStageExec newReuseInstance (int newStageId, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> newOutput)  { throw new RuntimeException(); }
  public  void cancel ()  { throw new RuntimeException(); }
  /**
   * Returns the Option[MapOutputStatistics]. If the shuffle map stage has no partition,
   * this method returns None, as there is no map statistics.
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.MapOutputStatistics> mapStats ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics getRuntimeStatistics ()  { throw new RuntimeException(); }
}
