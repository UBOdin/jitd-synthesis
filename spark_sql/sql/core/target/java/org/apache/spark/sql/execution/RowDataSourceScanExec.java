package org.apache.spark.sql.execution;
/** Physical plan node for scanning data from a relation. */
public  class RowDataSourceScanExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.DataSourceScanExec, org.apache.spark.sql.execution.InputRDDCodegen, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.CodegenSupport parent ()  { throw new RuntimeException(); }
  protected  java.lang.String nodeNamePrefix ()  { throw new RuntimeException(); }
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  protected  int maxMetadataValueLength ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType requiredSchema ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<org.apache.spark.sql.sources.Filter> filters ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<org.apache.spark.sql.sources.Filter> handledFilters ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> rdd ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.BaseRelation relation ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.TableIdentifier> tableIdentifier ()  { throw new RuntimeException(); }
  // not preceding
  public   RowDataSourceScanExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.types.StructType requiredSchema, scala.collection.immutable.Set<org.apache.spark.sql.sources.Filter> filters, scala.collection.immutable.Set<org.apache.spark.sql.sources.Filter> handledFilters, org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> rdd, org.apache.spark.sql.sources.BaseRelation relation, scala.Option<org.apache.spark.sql.catalyst.TableIdentifier> tableIdentifier)  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  protected  boolean createUnsafeProjection ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> inputRDD ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> metadata ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan doCanonicalize ()  { throw new RuntimeException(); }
}
