package org.apache.spark.sql.execution;
public  class SortPrefixUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SortPrefixUtils$ MODULE$ = null;
  public   SortPrefixUtils$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.collection.unsafe.sort.PrefixComparator getPrefixComparator (org.apache.spark.sql.catalyst.expressions.SortOrder sortOrder)  { throw new RuntimeException(); }
  /**
   * Creates the prefix comparator for the first field in the given schema, in ascending order.
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.util.collection.unsafe.sort.PrefixComparator getPrefixComparator (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Returns whether the specified SortOrder can be satisfied with a radix sort on the prefix.
   * @param sortOrder (undocumented)
   * @return (undocumented)
   */
  public  boolean canSortFullyWithPrefix (org.apache.spark.sql.catalyst.expressions.SortOrder sortOrder)  { throw new RuntimeException(); }
  /**
   * Returns whether the fully sorting on the specified key field is possible with radix sort.
   * @param field (undocumented)
   * @return (undocumented)
   */
  public  boolean canSortFullyWithPrefix (org.apache.spark.sql.types.StructField field)  { throw new RuntimeException(); }
  /**
   * Creates the prefix computer for the first field in the given schema, in ascending order.
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.UnsafeExternalRowSorter.PrefixComputer createPrefixGenerator (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
}
