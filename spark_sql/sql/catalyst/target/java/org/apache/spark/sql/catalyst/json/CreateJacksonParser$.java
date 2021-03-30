package org.apache.spark.sql.catalyst.json;
public  class CreateJacksonParser$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CreateJacksonParser$ MODULE$ = null;
  public   CreateJacksonParser$ ()  { throw new RuntimeException(); }
  public  com.fasterxml.jackson.core.JsonParser string (com.fasterxml.jackson.core.JsonFactory jsonFactory, java.lang.String record)  { throw new RuntimeException(); }
  public  com.fasterxml.jackson.core.JsonParser utf8String (com.fasterxml.jackson.core.JsonFactory jsonFactory, org.apache.spark.unsafe.types.UTF8String record)  { throw new RuntimeException(); }
  public  com.fasterxml.jackson.core.JsonParser text (com.fasterxml.jackson.core.JsonFactory jsonFactory, org.apache.hadoop.io.Text record)  { throw new RuntimeException(); }
  public  com.fasterxml.jackson.core.JsonParser text (java.lang.String enc, com.fasterxml.jackson.core.JsonFactory jsonFactory, org.apache.hadoop.io.Text record)  { throw new RuntimeException(); }
  public  com.fasterxml.jackson.core.JsonParser inputStream (com.fasterxml.jackson.core.JsonFactory jsonFactory, java.io.InputStream is)  { throw new RuntimeException(); }
  public  com.fasterxml.jackson.core.JsonParser inputStream (java.lang.String enc, com.fasterxml.jackson.core.JsonFactory jsonFactory, java.io.InputStream is)  { throw new RuntimeException(); }
  public  com.fasterxml.jackson.core.JsonParser internalRow (com.fasterxml.jackson.core.JsonFactory jsonFactory, org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  public  com.fasterxml.jackson.core.JsonParser internalRow (java.lang.String enc, com.fasterxml.jackson.core.JsonFactory jsonFactory, org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
}
