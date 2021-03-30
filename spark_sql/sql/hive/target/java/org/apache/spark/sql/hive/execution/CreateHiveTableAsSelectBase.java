package org.apache.spark.sql.hive.execution;
public  interface CreateHiveTableAsSelectBase extends org.apache.spark.sql.execution.command.DataWritingCommand {
  public  java.lang.String argString (int maxFields)  ;
  public  org.apache.spark.sql.execution.command.DataWritingCommand getWritingCommand (org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog, org.apache.spark.sql.catalyst.catalog.CatalogTable tableDesc, boolean tableExists)  ;
  public  org.apache.spark.sql.SaveMode mode ()  ;
  public  scala.collection.Seq<java.lang.String> outputColumnNames ()  ;
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.SparkPlan child)  ;
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable tableDesc ()  ;
  public  org.apache.spark.sql.catalyst.TableIdentifier tableIdentifier ()  ;
  public  java.lang.String writingCommandClassName ()  ;
}
