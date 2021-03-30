package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Input and output properties when passing data to a script.
 * For example, in Hive this would specify which SerDes to use.
 */
public  class ScriptInputOutputSchema implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> inputRowFormat ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> outputRowFormat ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> inputSerdeClass ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> outputSerdeClass ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> inputSerdeProps ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> outputSerdeProps ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> recordReaderClass ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> recordWriterClass ()  { throw new RuntimeException(); }
  public  boolean schemaLess ()  { throw new RuntimeException(); }
  // not preceding
  public   ScriptInputOutputSchema (scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> inputRowFormat, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> outputRowFormat, scala.Option<java.lang.String> inputSerdeClass, scala.Option<java.lang.String> outputSerdeClass, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> inputSerdeProps, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> outputSerdeProps, scala.Option<java.lang.String> recordReaderClass, scala.Option<java.lang.String> recordWriterClass, boolean schemaLess)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> inputRowFormatSQL ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> outputRowFormatSQL ()  { throw new RuntimeException(); }
}
