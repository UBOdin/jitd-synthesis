package org.apache.spark.sql.execution.datasources.v2;
/**
 * A logical plan for a DSv2 table with a scan already created.
 * <p>
 * This is used in the optimizer to push filters and projection down before conversion to physical
 * plan. This ensures that the stats that are used by the optimizer account for the filters and
 * projection that will be pushed down.
 * <p>
 * param:  relation a {@link DataSourceV2Relation}
 * param:  scan a DSv2 {@link Scan}
 * param:  output the output attributes of this relation
 */
public  class DataSourceV2ScanRelation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.analysis.NamedRelation, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.v2.DataSourceV2Relation relation ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.Scan scan ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> output ()  { throw new RuntimeException(); }
  // not preceding
  public   DataSourceV2ScanRelation (org.apache.spark.sql.execution.datasources.v2.DataSourceV2Relation relation, org.apache.spark.sql.connector.read.Scan scan, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> output)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
}
