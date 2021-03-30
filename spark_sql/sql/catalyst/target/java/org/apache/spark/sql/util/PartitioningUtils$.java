package org.apache.spark.sql.util;
public  class PartitioningUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PartitioningUtils$ MODULE$ = null;
  public   PartitioningUtils$ ()  { throw new RuntimeException(); }
  /**
   * Normalize the column names in partition specification, w.r.t. the real partition column names
   * and case sensitivity. e.g., if the partition spec has a column named <code>monTh</code>, and there is a
   * partition column named <code>month</code>, and it's case insensitive, we will normalize <code>monTh</code> to
   * <code>month</code>.
   * @param partitionSpec (undocumented)
   * @param partCols (undocumented)
   * @param tblName (undocumented)
   * @param resolver (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> scala.collection.immutable.Map<java.lang.String, T> normalizePartitionSpec (scala.collection.immutable.Map<java.lang.String, T> partitionSpec, org.apache.spark.sql.types.StructType partCols, java.lang.String tblName, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  /**
   * Verify if the input partition spec exactly matches the existing defined partition spec
   * The columns must be the same but the orders could be different.
   * @param tableName (undocumented)
   * @param spec (undocumented)
   * @param partitionColumnNames (undocumented)
   */
  public  void requireExactMatchedPartitionSpec (java.lang.String tableName, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec, scala.collection.Seq<java.lang.String> partitionColumnNames)  { throw new RuntimeException(); }
}
