package org.apache.spark.sql.execution.joins;
/**
 * An optimized CartesianRDD for UnsafeRow, which will cache the rows from second child RDD,
 * will be much faster than building the right partition for every row in left RDD, it also
 * materialize the right RDD (in case of the right RDD is nondeterministic).
 */
public  class UnsafeCartesianRDD extends org.apache.spark.rdd.CartesianRDD<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow> {
  public   UnsafeCartesianRDD (org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.expressions.UnsafeRow> left, org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.expressions.UnsafeRow> right, int inMemoryBufferThreshold, int spillThreshold)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow>> compute (org.apache.spark.Partition split, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
}
