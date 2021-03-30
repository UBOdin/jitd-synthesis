package org.apache.spark.sql.execution;
public  interface BaseScriptTransformationExec extends org.apache.spark.sql.execution.UnaryExecNode {
  public  void checkFailureAndPropagate (org.apache.spark.sql.execution.BaseScriptTransformationWriterThread writerThread, java.lang.Throwable cause, java.lang.Process proc, org.apache.spark.util.CircularBuffer stderrBuffer)  ;
  public  org.apache.spark.sql.execution.SparkPlan child ()  ;
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> createOutputIteratorWithoutSerde (org.apache.spark.sql.execution.BaseScriptTransformationWriterThread writerThread, java.io.InputStream inputStream, java.lang.Process proc, org.apache.spark.util.CircularBuffer stderrBuffer)  ;
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  ;
  public  scala.Tuple4<java.io.OutputStream, java.lang.Process, java.io.InputStream, org.apache.spark.util.CircularBuffer> initProc ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> input ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> inputExpressionsWithoutSerde ()  ;
  public  org.apache.spark.sql.execution.ScriptTransformationIOSchema ioschema ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  ;
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  ;
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> processIterator (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> inputIterator, org.apache.hadoop.conf.Configuration hadoopConf)  ;
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  ;
  public  java.lang.String script ()  ;
}
