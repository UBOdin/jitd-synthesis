package org.apache.spark.sql.execution;
/**
 * The wrapper class of input and output schema properties
 */
public  class ScriptTransformationIOSchema implements scala.Serializable, scala.Product {
  static public  scala.collection.immutable.Map<java.lang.String, java.lang.String> defaultFormat ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.ScriptTransformationIOSchema defaultIOSchema ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.ScriptTransformationIOSchema apply (org.apache.spark.sql.catalyst.plans.logical.ScriptInputOutputSchema input)  { throw new RuntimeException(); }
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
  public   ScriptTransformationIOSchema (scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> inputRowFormat, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> outputRowFormat, scala.Option<java.lang.String> inputSerdeClass, scala.Option<java.lang.String> outputSerdeClass, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> inputSerdeProps, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> outputSerdeProps, scala.Option<java.lang.String> recordReaderClass, scala.Option<java.lang.String> recordWriterClass, boolean schemaLess)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> inputRowFormatMap ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> outputRowFormatMap ()  { throw new RuntimeException(); }
}
