package org.apache.spark.sql.hive.execution;
public  class HiveScriptIOSchema$ implements org.apache.spark.sql.hive.HiveInspectors {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HiveScriptIOSchema$ MODULE$ = null;
  public   HiveScriptIOSchema$ ()  { throw new RuntimeException(); }
  public  scala.Option<scala.Tuple2<org.apache.hadoop.hive.serde2.AbstractSerDe, org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector>> initInputSerDe (org.apache.spark.sql.execution.ScriptTransformationIOSchema ioschema, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> input)  { throw new RuntimeException(); }
  public  scala.Option<scala.Tuple2<org.apache.hadoop.hive.serde2.AbstractSerDe, org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector>> initOutputSerDe (org.apache.spark.sql.execution.ScriptTransformationIOSchema ioschema, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.serde2.AbstractSerDe initSerDe (java.lang.String serdeClassName, scala.collection.Seq<java.lang.String> columns, scala.collection.Seq<org.apache.spark.sql.types.DataType> columnTypes, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> serdeProps)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.hadoop.hive.ql.exec.RecordReader> recordReader (org.apache.spark.sql.execution.ScriptTransformationIOSchema ioschema, java.io.InputStream inputStream, org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.hadoop.hive.ql.exec.RecordWriter> recordWriter (org.apache.spark.sql.execution.ScriptTransformationIOSchema ioschema, java.io.OutputStream outputStream, org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
}
