package org.apache.spark.sql;
public  class Dataset$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Dataset$ MODULE$ = null;
  public   Dataset$ ()  { throw new RuntimeException(); }
  public  java.util.concurrent.atomic.AtomicLong curId ()  { throw new RuntimeException(); }
  public  java.lang.String DATASET_ID_KEY ()  { throw new RuntimeException(); }
  public  java.lang.String COL_POS_KEY ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.trees.TreeNodeTag<java.lang.Object> DATASET_ID_TAG ()  { throw new RuntimeException(); }
  public <T extends java.lang.Object> org.apache.spark.sql.Dataset<T> apply (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan, org.apache.spark.sql.Encoder<T> evidence$1)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> ofRows (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan)  { throw new RuntimeException(); }
  /** A variant of ofRows that allows passing in a tracker so we can track query parsing time. */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> ofRows (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan, org.apache.spark.sql.catalyst.QueryPlanningTracker tracker)  { throw new RuntimeException(); }
}
