package org.apache.spark.sql.execution.datasources.v2;
public  interface V2ExistingTableWriteExec extends org.apache.spark.sql.execution.datasources.v2.V2TableWriteExec {
  public  scala.Function0<scala.runtime.BoxedUnit> refreshCache ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  ;
  public  org.apache.spark.sql.connector.write.Write write ()  ;
}
