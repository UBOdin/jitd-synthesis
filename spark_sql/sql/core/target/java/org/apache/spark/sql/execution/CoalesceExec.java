package org.apache.spark.sql.execution;
/**
 * Physical plan for returning a new RDD that has exactly <code>numPartitions</code> partitions.
 * Similar to coalesce defined on an {@link RDD}, this operation results in a narrow dependency, e.g.
 * if you go from 1000 partitions to 100 partitions, there will not be a shuffle, instead each of
 * the 100 new partitions will claim 10 of the current partitions.  If a larger number of partitions
 * is requested, it will stay at the current number of partitions.
 * <p>
 * However, if you're doing a drastic coalesce, e.g. to numPartitions = 1,
 * this may result in your computation taking place on fewer nodes than
 * you like (e.g. one node in the case of numPartitions = 1). To avoid this,
 * you see ShuffleExchange. This will add a shuffle step, but means the
 * current upstream partitions will be executed in parallel (per whatever
 * the current partitioning is).
 */
public  class CoalesceExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, scala.Product, scala.Serializable {
  static public  class EmptyPartition implements org.apache.spark.Partition, scala.Product, scala.Serializable {
    public  int index ()  { throw new RuntimeException(); }
    // not preceding
    public   EmptyPartition (int index)  { throw new RuntimeException(); }
  }
  static public  class EmptyPartition$ extends scala.runtime.AbstractFunction1<java.lang.Object, org.apache.spark.sql.execution.CoalesceExec.EmptyPartition> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final EmptyPartition$ MODULE$ = null;
    public   EmptyPartition$ ()  { throw new RuntimeException(); }
  }
  /** A simple RDD with no data, but with the given number of partitions. */
  static public  class EmptyRDDWithPartitions extends org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> {
    // not preceding
    public   EmptyRDDWithPartitions (org.apache.spark.SparkContext sc, int numPartitions)  { throw new RuntimeException(); }
    public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> compute (org.apache.spark.Partition split, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
    public  org.apache.spark.Partition[] getPartitions ()  { throw new RuntimeException(); }
  }
  public  int numPartitions ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   CoalesceExec (int numPartitions, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
