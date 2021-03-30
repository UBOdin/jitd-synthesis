package org.apache.spark.sql.execution.columnar;
 abstract class NativeColumnType<T extends org.apache.spark.sql.types.AtomicType> extends org.apache.spark.sql.execution.columnar.ColumnType<java.lang.Object> {
  // not preceding
  public   NativeColumnType (T dataType, int defaultSize)  { throw new RuntimeException(); }
  public  T dataType ()  { throw new RuntimeException(); }
  public  int defaultSize ()  { throw new RuntimeException(); }
  /**
   * Scala TypeTag. Can be used to create primitive arrays and hash tables.
   * @return (undocumented)
   */
  public  scala.reflect.api.TypeTags.TypeTag<java.lang.Object> scalaTag ()  { throw new RuntimeException(); }
}
