package org.apache.spark.sql.catalyst.catalog;
public  class ExternalCatalogUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ExternalCatalogUtils$ MODULE$ = null;
  public   ExternalCatalogUtils$ ()  { throw new RuntimeException(); }
  public  java.lang.String DEFAULT_PARTITION_NAME ()  { throw new RuntimeException(); }
  public  java.util.BitSet charToEscape ()  { throw new RuntimeException(); }
  /**
   * ASCII 01-1F are HTTP control characters that need to be escaped.
   * <p>
   and  are \n and \r, respectively.
   * @param c (undocumented)
   * @return (undocumented)
   */
  public  boolean needsEscaping (char c)  { throw new RuntimeException(); }
  public  java.lang.String escapePathName (java.lang.String path)  { throw new RuntimeException(); }
  public  java.lang.String unescapePathName (java.lang.String path)  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.Path generatePartitionPath (scala.collection.immutable.Map<java.lang.String, java.lang.String> spec, scala.collection.Seq<java.lang.String> partitionColumnNames, org.apache.hadoop.fs.Path tablePath)  { throw new RuntimeException(); }
  public  java.lang.String getPartitionPathString (java.lang.String col, java.lang.String value)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> prunePartitionsByFilter (org.apache.spark.sql.catalyst.catalog.CatalogTable catalogTable, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> inputPartitions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, java.lang.String defaultTimeZoneId)  { throw new RuntimeException(); }
  /**
   * Returns true if <code>spec1</code> is a partial partition spec w.r.t. <code>spec2</code>, e.g. PARTITION (a=1) is a
   * partial partition spec w.r.t. PARTITION (a=1,b=2).
   * @param spec1 (undocumented)
   * @param spec2 (undocumented)
   * @return (undocumented)
   */
  public  boolean isPartialPartitionSpec (scala.collection.immutable.Map<java.lang.String, java.lang.String> spec1, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec2)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> convertNullPartitionValues (scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  { throw new RuntimeException(); }
}
