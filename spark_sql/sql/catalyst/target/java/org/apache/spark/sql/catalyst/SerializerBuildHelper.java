package org.apache.spark.sql.catalyst;
public  class SerializerBuildHelper {
  static public  class MapElementInformation implements scala.Product, scala.Serializable {
    public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
    public  boolean nullable ()  { throw new RuntimeException(); }
    public  scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> funcForNewExpr ()  { throw new RuntimeException(); }
    // not preceding
    public   MapElementInformation (org.apache.spark.sql.types.DataType dataType, boolean nullable, scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> funcForNewExpr)  { throw new RuntimeException(); }
  }
  static public  class MapElementInformation$ extends scala.runtime.AbstractFunction3<org.apache.spark.sql.types.DataType, java.lang.Object, scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression>, org.apache.spark.sql.catalyst.SerializerBuildHelper.MapElementInformation> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final MapElementInformation$ MODULE$ = null;
    public   MapElementInformation$ ()  { throw new RuntimeException(); }
  }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForBoolean (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForByte (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForShort (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForInteger (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForLong (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForFloat (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForDouble (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForString (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForJavaInstant (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForJavaEnum (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForSqlTimestamp (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForJavaLocalDate (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForSqlDate (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForJavaDuration (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForJavaPeriod (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForJavaBigDecimal (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForScalaBigDecimal (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForJavaBigInteger (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForScalaBigInt (org.apache.spark.sql.catalyst.expressions.Expression inputObject)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForPrimitiveArray (org.apache.spark.sql.catalyst.expressions.Expression inputObject, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForGenericArray (org.apache.spark.sql.catalyst.expressions.Expression inputObject, org.apache.spark.sql.types.DataType dataType, boolean nullable)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForMapObjects (org.apache.spark.sql.catalyst.expressions.Expression inputObject, org.apache.spark.sql.types.ObjectType dataType, scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> funcForNewExpr)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForMap (org.apache.spark.sql.catalyst.expressions.Expression inputObject, org.apache.spark.sql.catalyst.SerializerBuildHelper.MapElementInformation keyInformation, org.apache.spark.sql.catalyst.SerializerBuildHelper.MapElementInformation valueInformation)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForObject (org.apache.spark.sql.catalyst.expressions.Expression inputObject, scala.collection.Seq<scala.Tuple2<java.lang.String, org.apache.spark.sql.catalyst.expressions.Expression>> fields)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression createSerializerForUserDefinedType (org.apache.spark.sql.catalyst.expressions.Expression inputObject, org.apache.spark.sql.types.UserDefinedType<?> udt, java.lang.Class<?> udtClass)  { throw new RuntimeException(); }
}
