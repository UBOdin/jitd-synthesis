package org.apache.spark.sql.catalyst.expressions;
/**
 * Will become common base class for {@link ArrayDistinct}, {@link ArrayUnion}, {@link ArrayIntersect},
 * and {@link ArrayExcept}.
 */
public  interface ArraySetLike {
  public  java.lang.String buildResultArray (java.lang.String builder, java.lang.String value, java.lang.String size, java.lang.String nullElementIndex)  ;
  public  boolean canUseSpecializedHashSet ()  ;
  public  org.apache.spark.sql.types.DataType dt ()  ;
  public  org.apache.spark.sql.types.DataType et ()  ;
  public  java.lang.String genGetValue (java.lang.String array, java.lang.String i)  ;
  // not preceding
  public  java.lang.String hsPostFix ()  ;
  public  java.lang.String hsTypeName ()  ;
  public  java.lang.String hsValueCast ()  ;
  public  java.lang.String nullValueHolder ()  ;
  public  scala.math.Ordering<java.lang.Object> ordering ()  ;
  public  java.lang.String withResultArrayNullCheck (java.lang.String body, java.lang.String value, java.lang.String nullElementIndex)  ;
}
