package org.apache.spark.sql.execution.datasources.v2;
public  interface TableWriteExecHelper extends org.apache.spark.sql.execution.datasources.v2.V2TableWriteExec, org.apache.spark.sql.execution.datasources.v2.SupportsV1Write {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> writeToTable (org.apache.spark.sql.connector.catalog.TableCatalog catalog, org.apache.spark.sql.connector.catalog.Table table, org.apache.spark.sql.util.CaseInsensitiveStringMap writeOptions, org.apache.spark.sql.connector.catalog.Identifier ident)  ;
}
