package org.apache.spark.sql.execution.datasources;
/**
 * Saves the results of <code>query</code> in to a data source.
 * <p>
 * Note that this command is different from {@link InsertIntoDataSourceCommand}. This command will call
 * <code>CreatableRelationProvider.createRelation</code> to write out the data, while
 * {@link InsertIntoDataSourceCommand} calls <code>InsertableRelation.insert</code>. Ideally these 2 data source
 * interfaces should do the same thing, but as we've already published these 2 interfaces and the
 * implementations may have different logic, we have to keep these 2 different commands.
 */
public  class SaveIntoDataSourceCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.CreatableRelationProvider dataSource ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> options ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SaveMode mode ()  { throw new RuntimeException(); }
  // not preceding
  public   SaveIntoDataSourceCommand (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, org.apache.spark.sql.sources.CreatableRelationProvider dataSource, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.SaveMode mode)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.QueryPlan<?>> innerChildren ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan clone ()  { throw new RuntimeException(); }
}
