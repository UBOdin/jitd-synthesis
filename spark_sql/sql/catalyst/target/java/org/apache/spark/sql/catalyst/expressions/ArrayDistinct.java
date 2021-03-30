package org.apache.spark.sql.catalyst.expressions;
/**
 * Removes duplicate values from the array.
 */
public  class ArrayDistinct extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.ArraySetLike, org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected  boolean canUseSpecializedHashSet ()  { throw new RuntimeException(); }
  protected  scala.math.Ordering<java.lang.Object> ordering ()  { throw new RuntimeException(); }
  protected  java.lang.String hsPostFix ()  { throw new RuntimeException(); }
  protected  java.lang.String hsTypeName ()  { throw new RuntimeException(); }
  protected  java.lang.String hsValueCast ()  { throw new RuntimeException(); }
  protected  java.lang.String nullValueHolder ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  // not preceding
  public   ArrayDistinct (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.types.DataType dt ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.types.DataType et ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object array)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
