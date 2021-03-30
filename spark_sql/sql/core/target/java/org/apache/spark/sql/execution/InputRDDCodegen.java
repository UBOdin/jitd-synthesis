package org.apache.spark.sql.execution;
/**
 * Leaf codegen node reading from a single RDD.
 */
public  interface InputRDDCodegen extends org.apache.spark.sql.execution.CodegenSupport {
  public  boolean createUnsafeProjection ()  ;
  public  java.lang.String doProduce (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  ;
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> inputRDD ()  ;
  public  scala.collection.Seq<org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow>> inputRDDs ()  ;
}
