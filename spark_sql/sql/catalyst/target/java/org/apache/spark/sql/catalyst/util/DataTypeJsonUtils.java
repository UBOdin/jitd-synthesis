package org.apache.spark.sql.catalyst.util;
public  class DataTypeJsonUtils {
  /**
   * Jackson serializer for {@link DataType}. Internally this delegates to json4s based serialization.
   */
  static public  class DataTypeJsonSerializer extends com.fasterxml.jackson.databind.JsonSerializer<org.apache.spark.sql.types.DataType> {
    public   DataTypeJsonSerializer ()  { throw new RuntimeException(); }
    public  void serialize (org.apache.spark.sql.types.DataType value, com.fasterxml.jackson.core.JsonGenerator gen, com.fasterxml.jackson.databind.SerializerProvider provider)  { throw new RuntimeException(); }
  }
  /**
   * Jackson deserializer for {@link DataType}. Internally this delegates to json4s based
   * deserialization.
   */
  static public  class DataTypeJsonDeserializer extends com.fasterxml.jackson.databind.JsonDeserializer<org.apache.spark.sql.types.DataType> {
    public   DataTypeJsonDeserializer ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.types.DataType deserialize (com.fasterxml.jackson.core.JsonParser jsonParser, com.fasterxml.jackson.databind.DeserializationContext deserializationContext)  { throw new RuntimeException(); }
  }
}
