package org.apache.spark.sql.execution;
/**
 * Physical plan for a custom subquery that collects and transforms the broadcast key values.
 * This subquery retrieves the partition key from the broadcast results based on the type of
 * {@link HashedRelation} returned. If the key is packed inside a Long, we extract it through
 * bitwise operations, otherwise we return it from the appropriate index of the {@link UnsafeRow}.
 * <p>
 * param:  index the index of the join key in the list of keys from the build side
 * param:  buildKeys the join keys from the build side of the join used
 * param:  child the BroadcastExchange from the build side of the join
 */
public  class SubqueryBroadcastExec extends org.apache.spark.sql.execution.BaseSubqueryExec implements org.apache.spark.sql.execution.UnaryExecNode, scala.Product, scala.Serializable {
  static   scala.concurrent.ExecutionContextExecutorService executionContext ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  int index ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> buildKeys ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   SubqueryBroadcastExec (java.lang.String name, int index, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> buildKeys, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan doCanonicalize ()  { throw new RuntimeException(); }
  protected  void doPrepare ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] executeCollect ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
}
