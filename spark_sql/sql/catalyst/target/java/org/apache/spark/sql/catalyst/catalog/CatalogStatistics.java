package org.apache.spark.sql.catalyst.catalog;
/**
 * This class of statistics is used in {@link CatalogTable} to interact with metastore.
 * We define this new class instead of directly using {@link Statistics} here because there are no
 * concepts of attributes in catalog.
 */
public  class CatalogStatistics implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.math.BigInt sizeInBytes ()  { throw new RuntimeException(); }
  public  scala.Option<scala.math.BigInt> rowCount ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.catalyst.catalog.CatalogColumnStat> colStats ()  { throw new RuntimeException(); }
  // not preceding
  public   CatalogStatistics (scala.math.BigInt sizeInBytes, scala.Option<scala.math.BigInt> rowCount, scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.catalyst.catalog.CatalogColumnStat> colStats)  { throw new RuntimeException(); }
  /**
   * Convert {@link CatalogStatistics} to {@link Statistics}, and match column stats to attributes based
   * on column names.
   * @param planOutput (undocumented)
   * @param planStatsEnabled (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics toPlanStats (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> planOutput, boolean planStatsEnabled)  { throw new RuntimeException(); }
  /** Readable string representation for the CatalogStatistics. */
  public  java.lang.String simpleString ()  { throw new RuntimeException(); }
}
