package org.apache.spark.sql.execution.ui;
/**
 * A graph used for storing information of an executionPlan of DataFrame.
 * <p>
 * Each graph is defined with a set of nodes and a set of edges. Each node represents a node in the
 * SparkPlan tree, and each edge represents a parent-child relationship between two nodes.
 */
public  class SparkPlanGraph implements scala.Product, scala.Serializable {
  /**
   * Build a SparkPlanGraph from the root of a SparkPlan tree.
   * @param planInfo (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.execution.ui.SparkPlanGraph apply (org.apache.spark.sql.execution.SparkPlanInfo planInfo)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.ui.SparkPlanGraphNode> nodes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.ui.SparkPlanGraphEdge> edges ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkPlanGraph (scala.collection.Seq<org.apache.spark.sql.execution.ui.SparkPlanGraphNode> nodes, scala.collection.Seq<org.apache.spark.sql.execution.ui.SparkPlanGraphEdge> edges)  { throw new RuntimeException(); }
  public  java.lang.String makeDotFile (scala.collection.immutable.Map<java.lang.Object, java.lang.String> metrics)  { throw new RuntimeException(); }
  /**
   * All the SparkPlanGraphNodes, including those inside of WholeStageCodegen.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.execution.ui.SparkPlanGraphNode> allNodes ()  { throw new RuntimeException(); }
}
