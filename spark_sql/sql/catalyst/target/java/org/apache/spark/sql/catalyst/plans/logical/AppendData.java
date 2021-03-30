package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Append data to an existing table.
 */
public  class AppendData extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.V2WriteCommand, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.plans.logical.AppendData byName (org.apache.spark.sql.catalyst.analysis.NamedRelation table, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan df, scala.collection.immutable.Map<java.lang.String, java.lang.String> writeOptions)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.logical.AppendData byPosition (org.apache.spark.sql.catalyst.analysis.NamedRelation table, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, scala.collection.immutable.Map<java.lang.String, java.lang.String> writeOptions)  { throw new RuntimeException(); }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.NamedRelation table ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> writeOptions ()  { throw new RuntimeException(); }
  public  boolean isByName ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.connector.write.Write> write ()  { throw new RuntimeException(); }
  // not preceding
  public   AppendData (org.apache.spark.sql.catalyst.analysis.NamedRelation table, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, scala.collection.immutable.Map<java.lang.String, java.lang.String> writeOptions, boolean isByName, scala.Option<org.apache.spark.sql.connector.write.Write> write)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.AppendData withNewQuery (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan newQuery)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.AppendData withNewTable (org.apache.spark.sql.catalyst.analysis.NamedRelation newTable)  { throw new RuntimeException(); }
}
