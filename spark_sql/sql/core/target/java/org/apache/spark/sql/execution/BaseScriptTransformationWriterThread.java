package org.apache.spark.sql.execution;
public abstract class BaseScriptTransformationWriterThread extends java.lang.Thread implements org.apache.spark.internal.Logging {
  public   BaseScriptTransformationWriterThread ()  { throw new RuntimeException(); }
  protected  java.lang.Throwable _exception ()  { throw new RuntimeException(); }
  public abstract  org.apache.hadoop.conf.Configuration conf ()  ;
  /** Contains the exception thrown while writing the parent iterator to the external process. */
  public  scala.Option<java.lang.Throwable> exception ()  { throw new RuntimeException(); }
  public abstract  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputSchema ()  ;
  public abstract  org.apache.spark.sql.execution.ScriptTransformationIOSchema ioSchema ()  ;
  public abstract  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> iter ()  ;
  public abstract  java.io.OutputStream outputStream ()  ;
  public abstract  java.lang.Process proc ()  ;
  protected abstract  void processRows ()  ;
  protected  void processRowsWithoutSerde ()  { throw new RuntimeException(); }
  public  void run ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.util.CircularBuffer stderrBuffer ()  ;
  public abstract  org.apache.spark.TaskContext taskContext ()  ;
}
