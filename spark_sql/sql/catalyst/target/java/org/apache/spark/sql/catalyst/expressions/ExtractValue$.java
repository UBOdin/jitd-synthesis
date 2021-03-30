package org.apache.spark.sql.catalyst.expressions;
public  class ExtractValue$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ExtractValue$ MODULE$ = null;
  public   ExtractValue$ ()  { throw new RuntimeException(); }
  /**
   * Returns the resolved <code>ExtractValue</code>. It will return one kind of concrete <code>ExtractValue</code>,
   * depend on the type of <code>child</code> and <code>extraction</code>.
   * <p>
   *   <code>child</code>      |    <code>extraction</code>    |    concrete <code>ExtractValue</code>
   * ----------------------------------------------------------------
   *    Struct      |   Literal String   |        GetStructField
   * Array[Struct]  |   Literal String   |     GetArrayStructFields
   *    Array       |   Integral type    |         GetArrayItem
   *     Map        |   map key type     |         GetMapValue
   * @param child (undocumented)
   * @param extraction (undocumented)
   * @param resolver (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression apply (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression extraction, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
}
