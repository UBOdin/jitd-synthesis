package org.apache.spark.sql.catalyst.analysis;
/**
 * A variant of {@link UnresolvedRelation} which can only be resolved to a v2 relation
 * (<code>DataSourceV2Relation</code>), not v1 relation or temp view.
 * <p>
 * param:  originalNameParts the original table identifier name parts before catalog is resolved.
 * param:  catalog The catalog which the table should be looked up from.
 * param:  tableName The name of the table to look up.
 */
public  class UnresolvedV2Relation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.analysis.NamedRelation, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> originalNameParts ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.TableCatalog catalog ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Identifier tableName ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedV2Relation (scala.collection.Seq<java.lang.String> originalNameParts, org.apache.spark.sql.connector.catalog.TableCatalog catalog, org.apache.spark.sql.connector.catalog.Identifier tableName)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
}
