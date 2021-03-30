package org.apache.spark.sql.catalyst.json;
/**
 * Constructs a parser for a given schema that translates a json string to an {@link InternalRow}.
 */
public  class JacksonParser implements org.apache.spark.internal.Logging {
  public  org.apache.spark.sql.catalyst.json.JSONOptions options ()  { throw new RuntimeException(); }
  // not preceding
  public   JacksonParser (org.apache.spark.sql.types.DataType schema, org.apache.spark.sql.catalyst.json.JSONOptions options, boolean allowArrayAsStructs, scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters)  { throw new RuntimeException(); }
  /**
   * Create a converter which converts the JSON documents held by the <code>JsonParser</code>
   * to a value according to a desired schema.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  scala.Function1<com.fasterxml.jackson.core.JsonParser, java.lang.Object> makeConverter (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Parse the JSON input to the set of {@link InternalRow}s.
   * <p>
   * @param recordLiteral an optional function that will be used to generate
   *   the corrupt record text instead of record.toString
   * @param createParser (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> scala.collection.Iterable<org.apache.spark.sql.catalyst.InternalRow> parse (T record, scala.Function2<com.fasterxml.jackson.core.JsonFactory, T, com.fasterxml.jackson.core.JsonParser> createParser, scala.Function1<T, org.apache.spark.unsafe.types.UTF8String> recordLiteral)  { throw new RuntimeException(); }
}
