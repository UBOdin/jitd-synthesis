package org.apache.spark.sql.catalyst.analysis;
public  class PartitionsAlreadyExistException extends org.apache.spark.sql.AnalysisException {
  public   PartitionsAlreadyExistException (java.lang.String message)  { throw new RuntimeException(); }
  public   PartitionsAlreadyExistException (java.lang.String db, java.lang.String table, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> specs)  { throw new RuntimeException(); }
  public   PartitionsAlreadyExistException (java.lang.String tableName, scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> partitionIdents, org.apache.spark.sql.types.StructType partitionSchema)  { throw new RuntimeException(); }
}
