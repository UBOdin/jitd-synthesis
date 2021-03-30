package org.apache.spark.sql.hive.execution;
/**
 * Options for the Hive data source. Note that rule <code>DetermineHiveSerde</code> will extract Hive
 * serde/format information from these options.
 */
public  class HiveOptions implements scala.Serializable {
  static public  java.lang.String FILE_FORMAT ()  { throw new RuntimeException(); }
  static public  java.lang.String INPUT_FORMAT ()  { throw new RuntimeException(); }
  static public  java.lang.String OUTPUT_FORMAT ()  { throw new RuntimeException(); }
  static public  java.lang.String SERDE ()  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Map<java.lang.String, java.lang.String> delimiterOptions ()  { throw new RuntimeException(); }
  static public  scala.Option<scala.Tuple2<java.lang.String, java.lang.String>> getHiveWriteCompression (org.apache.hadoop.hive.ql.plan.TableDesc tableInfo, org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
  // not preceding
  public   HiveOptions (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters)  { throw new RuntimeException(); }
  public   HiveOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> fileFormat ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> inputFormat ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> outputFormat ()  { throw new RuntimeException(); }
  public  boolean hasInputOutputFormat ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> serde ()  { throw new RuntimeException(); }
  public  boolean containsDelimiters ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> serdeProperties ()  { throw new RuntimeException(); }
}
