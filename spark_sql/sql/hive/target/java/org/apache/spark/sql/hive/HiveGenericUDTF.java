package org.apache.spark.sql.hive;
/**
 * Converts a Hive Generic User Defined Table Generating Function (UDTF) to a
 * <code>Generator</code>. Note that the semantics of Generators do not allow
 * Generators to maintain state in between input rows.  Thus UDTFs that rely on partitioning
 * dependent operations like calls to <code>close()</code> before producing output will not operate the same as
 * in Hive.  However, in practice this should not affect compatibility for most sane UDTFs
 * (e.g. explode or GenericUDTFParseUrlTuple).
 * <p>
 * Operators that require maintaining state in between input rows should instead be implemented as
 * user defined aggregations, which have clean semantics even in a partitioned execution.
 */
  class HiveGenericUDTF extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Generator, org.apache.spark.sql.hive.HiveInspectors, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, org.apache.spark.sql.catalyst.expressions.UserDefinedExpression, scala.Product, scala.Serializable {
  protected  class UDTFCollector implements org.apache.hadoop.hive.ql.udf.generic.Collector {
    public   UDTFCollector ()  { throw new RuntimeException(); }
    public  void collect (java.lang.Object input)  { throw new RuntimeException(); }
    public  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> collectRows ()  { throw new RuntimeException(); }
    public  scala.collection.mutable.ArrayBuffer<org.apache.spark.sql.catalyst.InternalRow> collected ()  { throw new RuntimeException(); }
  }
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.HiveShim.HiveFunctionWrapper funcWrapper ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public   HiveGenericUDTF (java.lang.String name, org.apache.spark.sql.hive.HiveShim.HiveFunctionWrapper funcWrapper, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.hadoop.hive.ql.udf.generic.GenericUDTF function ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.hadoop.hive.serde2.objectinspector.StandardStructObjectInspector inputInspector ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector outputInspector ()  { throw new RuntimeException(); }
  // not preceding
  protected  java.lang.Object[] udtInput ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.hive.HiveGenericUDTF.UDTFCollector collector ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.StructType elementSchema ()  { throw new RuntimeException(); }
  public  scala.collection.TraversableOnce<org.apache.spark.sql.catalyst.InternalRow> eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  scala.collection.TraversableOnce<org.apache.spark.sql.catalyst.InternalRow> terminate ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
