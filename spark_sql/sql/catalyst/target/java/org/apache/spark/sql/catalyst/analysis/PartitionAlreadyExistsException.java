package org.apache.spark.sql.catalyst.analysis;
public  class PartitionAlreadyExistsException extends org.apache.spark.sql.AnalysisException {
  public   PartitionAlreadyExistsException (java.lang.String message)  { throw new RuntimeException(); }
  public   PartitionAlreadyExistsException (java.lang.String db, java.lang.String table, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  { throw new RuntimeException(); }
  public   PartitionAlreadyExistsException (java.lang.String tableName, org.apache.spark.sql.catalyst.InternalRow partitionIdent, org.apache.spark.sql.types.StructType partitionSchema)  { throw new RuntimeException(); }
}
