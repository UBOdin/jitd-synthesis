package org.apache.spark.sql.execution.streaming.sources;
/**
 * A write-only table for forwarding data into the specified {@link ForeachWriter}.
 * <p>
 * param:  writer The {@link ForeachWriter} to process all data.
 * param:  converter An object to convert internal rows to target type T. Either it can be
 *                  a {@link ExpressionEncoder} or a direct converter function.
 * @param <T>  The expected type of the sink.
 */
public  class ForeachWriterTable<T extends java.lang.Object> implements org.apache.spark.sql.connector.catalog.Table, org.apache.spark.sql.connector.catalog.SupportsWrite, scala.Product, scala.Serializable {
  static public <T extends java.lang.Object> org.apache.spark.sql.execution.streaming.sources.ForeachWriterTable<?> apply (org.apache.spark.sql.ForeachWriter<T> writer, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T> encoder)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.ForeachWriter<T> writer ()  { throw new RuntimeException(); }
  public  scala.util.Either<org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T>, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, T>> converter ()  { throw new RuntimeException(); }
  // not preceding
  public   ForeachWriterTable (org.apache.spark.sql.ForeachWriter<T> writer, scala.util.Either<org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T>, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, T>> converter)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  java.util.Set<org.apache.spark.sql.connector.catalog.TableCapability> capabilities ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.WriteBuilder newWriteBuilder (org.apache.spark.sql.connector.write.LogicalWriteInfo info)  { throw new RuntimeException(); }
}
