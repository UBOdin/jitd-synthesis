package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Insert query result into a directory.
 * <p>
 * param:  isLocal Indicates whether the specified directory is local directory
 * param:  storage Info about output file, row and what serialization format
 * param:  provider Specifies what data source to use; only used for data source file.
 * param:  child The query to be executed
 * param:  overwrite If true, the existing directory will be overwritten
 * <p>
 * Note that this plan is unresolved and has to be replaced by the concrete implementations
 * during analysis.
 */
public  class InsertIntoDir extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean isLocal ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> provider ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  boolean overwrite ()  { throw new RuntimeException(); }
  // not preceding
  public   InsertIntoDir (boolean isLocal, org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage, scala.Option<java.lang.String> provider, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, boolean overwrite)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
}
