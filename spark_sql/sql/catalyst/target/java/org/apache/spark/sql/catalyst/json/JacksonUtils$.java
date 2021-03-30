package org.apache.spark.sql.catalyst.json;
public  class JacksonUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final JacksonUtils$ MODULE$ = null;
  public   JacksonUtils$ ()  { throw new RuntimeException(); }
  /**
   * Advance the parser until a null or a specific token is found
   * @param parser (undocumented)
   * @param stopOn (undocumented)
   * @return (undocumented)
   */
  public  boolean nextUntil (com.fasterxml.jackson.core.JsonParser parser, com.fasterxml.jackson.core.JsonToken stopOn)  { throw new RuntimeException(); }
  public  void verifyType (java.lang.String name, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Verify if the schema is supported in JSON parsing.
   * @param schema (undocumented)
   */
  public  void verifySchema (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
}
