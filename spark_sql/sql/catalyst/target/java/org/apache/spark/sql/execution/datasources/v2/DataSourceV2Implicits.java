package org.apache.spark.sql.execution.datasources.v2;
public  class DataSourceV2Implicits {
  static public  class TableHelper {
    public   TableHelper (org.apache.spark.sql.connector.catalog.Table table)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.catalog.SupportsAtomicPartitionManagement asAtomicPartitionable ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.catalog.SupportsDelete asDeletable ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.catalog.SupportsPartitionManagement asPartitionable ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.catalog.SupportsRead asReadable ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.catalog.TruncatableTable asTruncatable ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.catalog.SupportsWrite asWritable ()  { throw new RuntimeException(); }
    public  boolean supports (org.apache.spark.sql.connector.catalog.TableCapability capability)  { throw new RuntimeException(); }
    public  boolean supportsAny (scala.collection.Seq<org.apache.spark.sql.connector.catalog.TableCapability> capabilities)  { throw new RuntimeException(); }
  }
  static public  class MetadataColumnsHelper {
    public   MetadataColumnsHelper (org.apache.spark.sql.connector.catalog.MetadataColumn[] metadata)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.types.StructType asStruct ()  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> toAttributes ()  { throw new RuntimeException(); }
  }
  static public  class MetadataColumnHelper {
    public   MetadataColumnHelper (org.apache.spark.sql.catalyst.expressions.Attribute attr)  { throw new RuntimeException(); }
    public  boolean isMetadataCol ()  { throw new RuntimeException(); }
  }
  static public  class OptionsHelper {
    public   OptionsHelper (scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.util.CaseInsensitiveStringMap asOptions ()  { throw new RuntimeException(); }
  }
  static public  class PartitionSpecsHelper {
    public   PartitionSpecsHelper (scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.PartitionSpec> partSpecs)  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.ResolvedPartitionSpec> asResolvedPartitionSpecs ()  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.UnresolvedPartitionSpec> asUnresolvedPartitionSpecs ()  { throw new RuntimeException(); }
  }
}
