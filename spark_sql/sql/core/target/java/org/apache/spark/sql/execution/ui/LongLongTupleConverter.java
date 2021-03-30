package org.apache.spark.sql.execution.ui;
/**
 * Jackson {@link Converter} for converting an (Int, Int) tuple into a (Long, Long) tuple.
 * <p>
 * This is necessary due to limitations in how Jackson's scala module deserializes primitives;
 * see the "Deserializing Option[Int] and other primitive challenges" section in
 * https://github.com/FasterXML/jackson-module-scala/wiki/FAQ for a discussion of this issue and
 * SPARK-18462 for the specific problem that motivated this conversion.
 */
public  class LongLongTupleConverter implements com.fasterxml.jackson.databind.util.Converter<scala.Tuple2<java.lang.Object, java.lang.Object>, scala.Tuple2<java.lang.Object, java.lang.Object>> {
  public   LongLongTupleConverter ()  { throw new RuntimeException(); }
  public  scala.Tuple2<java.lang.Object, java.lang.Object> convert (scala.Tuple2<java.lang.Object, java.lang.Object> in)  { throw new RuntimeException(); }
  public  com.fasterxml.jackson.databind.JavaType getInputType (com.fasterxml.jackson.databind.type.TypeFactory typeFactory)  { throw new RuntimeException(); }
  public  com.fasterxml.jackson.databind.JavaType getOutputType (com.fasterxml.jackson.databind.type.TypeFactory typeFactory)  { throw new RuntimeException(); }
}
