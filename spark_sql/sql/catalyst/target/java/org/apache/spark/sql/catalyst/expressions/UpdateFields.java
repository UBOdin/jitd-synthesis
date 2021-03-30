package org.apache.spark.sql.catalyst.expressions;
/**
 * Updates fields in a struct.
 */
public  class UpdateFields extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  /**
   * Adds/replaces field of <code>StructType</code> into <code>col</code> expression by name.
   * @param col (undocumented)
   * @param fieldName (undocumented)
   * @param expr (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.expressions.UpdateFields apply (org.apache.spark.sql.catalyst.expressions.Expression col, java.lang.String fieldName, org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  /**
   * Drops fields of <code>StructType</code> in <code>col</code> expression by name.
   * @param col (undocumented)
   * @param fieldName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.expressions.UpdateFields apply (org.apache.spark.sql.catalyst.expressions.Expression col, java.lang.String fieldName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression structExpr ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.StructFieldsOperation> fieldOps ()  { throw new RuntimeException(); }
  // not preceding
  public   UpdateFields (org.apache.spark.sql.catalyst.expressions.Expression structExpr, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.StructFieldsOperation> fieldOps)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> newExprs ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.Expression evalExpr ()  { throw new RuntimeException(); }
}
