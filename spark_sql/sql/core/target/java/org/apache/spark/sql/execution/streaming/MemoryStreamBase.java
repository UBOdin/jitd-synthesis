package org.apache.spark.sql.execution.streaming;
public abstract class MemoryStreamBase<A extends java.lang.Object> implements org.apache.spark.sql.connector.read.streaming.SparkDataStream {
  /**
   * A {@link Source} that produces value stored in memory as they are added by the user.  This {@link Source}
   * is intended for use in unit tests as it can only replay data when the object is still
   * available.
   * <p>
   * If numPartitions is provided, the rows will be redistributed to the given number of partitions.
   * @param sqlContext (undocumented)
   * @param evidence$3 (undocumented)
   */
  public   MemoryStreamBase (org.apache.spark.sql.SQLContext sqlContext, org.apache.spark.sql.Encoder<A> evidence$3)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset addData (scala.collection.Seq<A> data)  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.connector.read.streaming.Offset addData (scala.collection.TraversableOnce<A> data)  ;
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> attributes ()  { throw new RuntimeException(); }
  public  void commit (org.apache.spark.sql.connector.read.streaming.Offset end)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset deserializeOffset (java.lang.String json)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<A> encoder ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType fullSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset initialOffset ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> toDF ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Dataset<A> toDS ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder.Serializer<A> toRow ()  { throw new RuntimeException(); }
}
