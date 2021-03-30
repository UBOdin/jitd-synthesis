package org.apache.spark.sql.execution.python;
public  class EvaluatePython {
  static public  boolean needConversionInPython (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Helper for converting from Catalyst type to java type suitable for Pyrolite.
   * @param obj (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  static public  Object toJava (Object obj, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Make a converter that converts <code>obj</code> to the type specified by the data type, or returns
   * null if the type of obj is unexpected. Because Python doesn't enforce the type.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  static public  scala.Function1<java.lang.Object, java.lang.Object> makeFromJava (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * This should be called before trying to serialize any above classes un cluster mode,
   * this should be put in the closure
   */
  static public  void registerPicklers ()  { throw new RuntimeException(); }
  /**
   * Convert an RDD of Java objects to an RDD of serialized Python objects, that is usable by
   * PySpark.
   * @param rdd (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.rdd.RDD<byte[]> javaToPython (org.apache.spark.rdd.RDD<java.lang.Object> rdd)  { throw new RuntimeException(); }
}
