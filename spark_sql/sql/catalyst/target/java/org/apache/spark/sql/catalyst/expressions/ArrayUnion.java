package org.apache.spark.sql.catalyst.expressions;
/**
 * Returns an array of the elements in the union of x and y, without duplicates
 */
public  class ArrayUnion extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.ArrayBinaryLike, org.apache.spark.sql.catalyst.expressions.ComplexTypeMergingExpression, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.util.ArrayData unionOrdering (org.apache.spark.sql.catalyst.util.ArrayData array1, org.apache.spark.sql.catalyst.util.ArrayData array2, org.apache.spark.sql.types.DataType elementType, scala.math.Ordering<java.lang.Object> ordering)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypesForMerging ()  { throw new RuntimeException(); }
  protected  boolean canUseSpecializedHashSet ()  { throw new RuntimeException(); }
  protected  scala.math.Ordering<java.lang.Object> ordering ()  { throw new RuntimeException(); }
  protected  java.lang.String hsPostFix ()  { throw new RuntimeException(); }
  protected  java.lang.String hsTypeName ()  { throw new RuntimeException(); }
  protected  java.lang.String hsValueCast ()  { throw new RuntimeException(); }
  protected  java.lang.String nullValueHolder ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.types.DataType elementType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  // not preceding
  public   ArrayUnion (org.apache.spark.sql.catalyst.expressions.Expression left, org.apache.spark.sql.catalyst.expressions.Expression right)  { throw new RuntimeException(); }
  // not preceding
  public  scala.Function2<org.apache.spark.sql.catalyst.util.ArrayData, org.apache.spark.sql.catalyst.util.ArrayData, org.apache.spark.sql.catalyst.util.ArrayData> evalUnion ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object input1, Object input2)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
