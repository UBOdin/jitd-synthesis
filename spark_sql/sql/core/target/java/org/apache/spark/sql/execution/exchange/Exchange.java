package org.apache.spark.sql.execution.exchange;
/**
 * Base class for operators that exchange data among multiple threads or processes.
 * <p>
 * Exchanges are the key class of operators that enable parallelism. Although the implementation
 * differs significantly, the concept is similar to the exchange operator described in
 * "Volcano -- An Extensible and Parallel Query Evaluation System" by Goetz Graefe.
 */
public abstract class Exchange extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode {
  public   Exchange ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
}
