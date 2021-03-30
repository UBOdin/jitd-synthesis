package org.apache.spark.sql.execution.streaming.continuous;
/**
 * The RDD writing to a sink in continuous processing.
 * <p>
 * Within each task, we repeatedly call prev.compute(). Each resulting iterator contains the data
 * to be written for one epoch, which we commit and forward to the driver.
 * <p>
 * We keep repeating prev.compute() and writing new epochs until the query is shut down.
 */
public  class ContinuousWriteRDD extends org.apache.spark.rdd.RDD<scala.runtime.BoxedUnit> {
  // not preceding
  public   ContinuousWriteRDD (org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> prev, org.apache.spark.sql.connector.write.streaming.StreamingDataWriterFactory writerFactory)  { throw new RuntimeException(); }
  public  void clearDependencies ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<scala.runtime.BoxedUnit> compute (org.apache.spark.Partition split, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  public  org.apache.spark.Partition[] getPartitions ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.Partitioner> partitioner ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> prev ()  { throw new RuntimeException(); }
}
