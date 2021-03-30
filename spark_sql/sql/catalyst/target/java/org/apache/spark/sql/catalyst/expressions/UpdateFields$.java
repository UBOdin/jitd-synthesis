package org.apache.spark.sql.catalyst.expressions;
public  class UpdateFields$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final UpdateFields$ MODULE$ = null;
  public   UpdateFields$ ()  { throw new RuntimeException(); }
  /**
   * Adds/replaces field of <code>StructType</code> into <code>col</code> expression by name.
   * @param col (undocumented)
   * @param fieldName (undocumented)
   * @param expr (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.UpdateFields apply (org.apache.spark.sql.catalyst.expressions.Expression col, java.lang.String fieldName, org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  /**
   * Drops fields of <code>StructType</code> in <code>col</code> expression by name.
   * @param col (undocumented)
   * @param fieldName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.UpdateFields apply (org.apache.spark.sql.catalyst.expressions.Expression col, java.lang.String fieldName)  { throw new RuntimeException(); }
}
