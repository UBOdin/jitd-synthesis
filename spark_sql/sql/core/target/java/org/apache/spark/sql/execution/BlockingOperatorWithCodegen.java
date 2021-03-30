package org.apache.spark.sql.execution;
/**
 * A special kind of operators which support whole stage codegen. Blocking means these operators
 * will consume all the inputs first, before producing output. Typical blocking operators are
 * sort and aggregate.
 */
public  interface BlockingOperatorWithCodegen extends org.apache.spark.sql.execution.CodegenSupport {
  public  boolean canCheckLimitNotReached ()  ;
  public  scala.collection.Seq<java.lang.String> limitNotReachedChecks ()  ;
  public  boolean needCopyResult ()  ;
  public  boolean needStopCheck ()  ;
}
