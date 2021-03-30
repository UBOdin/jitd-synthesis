package org.apache.spark.sql.types;
/**
 * The user defined type in Python.
 * <p>
 * Note: This can only be accessed via Python UDF, or accessed as serialized object.
 */
  class PythonUserDefinedType extends org.apache.spark.sql.types.UserDefinedType<java.lang.Object> {
  // not preceding
  public   PythonUserDefinedType (org.apache.spark.sql.types.DataType sqlType, java.lang.String pyUDT, java.lang.String serializedPyClass)  { throw new RuntimeException(); }
    boolean acceptsType (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  Object deserialize (Object datam)  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
    org.json4s.JsonAST.JValue jsonValue ()  { throw new RuntimeException(); }
  public  java.lang.String pyUDT ()  { throw new RuntimeException(); }
  public  Object serialize (Object obj)  { throw new RuntimeException(); }
  public  java.lang.String serializedPyClass ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType sqlType ()  { throw new RuntimeException(); }
  public  java.lang.Class<java.lang.Object> userClass ()  { throw new RuntimeException(); }
}
