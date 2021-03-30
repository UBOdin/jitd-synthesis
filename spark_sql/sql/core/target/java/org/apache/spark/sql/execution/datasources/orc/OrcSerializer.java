package org.apache.spark.sql.execution.datasources.orc;
/**
 * A serializer to serialize Spark rows to ORC structs.
 */
public  class OrcSerializer {
  public   OrcSerializer (org.apache.spark.sql.types.StructType dataSchema)  { throw new RuntimeException(); }
  public  org.apache.orc.mapred.OrcStruct serialize (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
}
