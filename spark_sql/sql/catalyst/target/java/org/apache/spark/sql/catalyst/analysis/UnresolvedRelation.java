package org.apache.spark.sql.catalyst.analysis;
/**
 * Holds the name of a relation that has yet to be looked up in a catalog.
 * <p>
 * param:  multipartIdentifier table name
 * param:  options options to scan this relation. Only applicable to v2 table scan.
 */
public  class UnresolvedRelation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.analysis.NamedRelation, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.analysis.UnresolvedRelation apply (org.apache.spark.sql.catalyst.TableIdentifier tableIdentifier, org.apache.spark.sql.util.CaseInsensitiveStringMap extraOptions, boolean isStreaming)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.analysis.UnresolvedRelation apply (org.apache.spark.sql.catalyst.TableIdentifier tableIdentifier)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> multipartIdentifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.util.CaseInsensitiveStringMap options ()  { throw new RuntimeException(); }
  public  boolean isStreaming ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedRelation (scala.collection.Seq<java.lang.String> multipartIdentifier, org.apache.spark.sql.util.CaseInsensitiveStringMap options, boolean isStreaming)  { throw new RuntimeException(); }
  /** Returns a `.` separated name for this relation. */
  public  java.lang.String tableName ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
}
