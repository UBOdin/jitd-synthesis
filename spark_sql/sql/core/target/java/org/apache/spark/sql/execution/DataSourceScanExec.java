package org.apache.spark.sql.execution;
public  interface DataSourceScanExec extends org.apache.spark.sql.execution.LeafExecNode {
  /**
   * The data being read in.  This is to provide input to the tests in a way compatible with
   * {@link InputRDDCodegen} which all implementations used to extend.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow>> inputRDDs ()  ;
  public  int maxMetadataValueLength ()  ;
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> metadata ()  ;
  public  java.lang.String nodeName ()  ;
  public  java.lang.String nodeNamePrefix ()  ;
  /**
   * Shorthand for calling redactString() without specifying redacting rules
   * @param text (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String redact (java.lang.String text)  ;
  public  org.apache.spark.sql.sources.BaseRelation relation ()  ;
  public  java.lang.String simpleString (int maxFields)  ;
  public  scala.Option<org.apache.spark.sql.catalyst.TableIdentifier> tableIdentifier ()  ;
  public  java.lang.String verboseStringWithOperatorId ()  ;
}
