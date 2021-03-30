package org.apache.spark.sql.execution.adaptive;
public  class ReuseAdaptiveSubquery extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> implements scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.concurrent.TrieMap<org.apache.spark.sql.execution.SparkPlan, org.apache.spark.sql.execution.BaseSubqueryExec> reuseMap ()  { throw new RuntimeException(); }
  // not preceding
  public   ReuseAdaptiveSubquery (scala.collection.concurrent.TrieMap<org.apache.spark.sql.execution.SparkPlan, org.apache.spark.sql.execution.BaseSubqueryExec> reuseMap)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
