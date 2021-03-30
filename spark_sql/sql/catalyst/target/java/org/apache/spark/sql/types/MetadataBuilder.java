package org.apache.spark.sql.types;
/**
 * Builder for {@link Metadata}. If there is a key collision, the latter will overwrite the former.
 * <p>
 * @since 1.3.0
 */
public  class MetadataBuilder {
  public   MetadataBuilder ()  { throw new RuntimeException(); }
  /** Builds the {@link Metadata} instance. */
  public  org.apache.spark.sql.types.Metadata build ()  { throw new RuntimeException(); }
  /** Returns the immutable version of this map.  Used for java interop. */
  protected  scala.collection.immutable.Map<java.lang.String, java.lang.Object> getMap ()  { throw new RuntimeException(); }
  /** Puts a Boolean. */
  public  org.apache.spark.sql.types.MetadataBuilder putBoolean (java.lang.String key, boolean value)  { throw new RuntimeException(); }
  /** Puts a Boolean array. */
  public  org.apache.spark.sql.types.MetadataBuilder putBooleanArray (java.lang.String key, boolean[] value)  { throw new RuntimeException(); }
  /** Puts a Double. */
  public  org.apache.spark.sql.types.MetadataBuilder putDouble (java.lang.String key, double value)  { throw new RuntimeException(); }
  /** Puts a Double array. */
  public  org.apache.spark.sql.types.MetadataBuilder putDoubleArray (java.lang.String key, double[] value)  { throw new RuntimeException(); }
  /** Puts a Long. */
  public  org.apache.spark.sql.types.MetadataBuilder putLong (java.lang.String key, long value)  { throw new RuntimeException(); }
  /** Puts a Long array. */
  public  org.apache.spark.sql.types.MetadataBuilder putLongArray (java.lang.String key, long[] value)  { throw new RuntimeException(); }
  /** Puts a {@link Metadata}. */
  public  org.apache.spark.sql.types.MetadataBuilder putMetadata (java.lang.String key, org.apache.spark.sql.types.Metadata value)  { throw new RuntimeException(); }
  /** Puts a {@link Metadata} array. */
  public  org.apache.spark.sql.types.MetadataBuilder putMetadataArray (java.lang.String key, org.apache.spark.sql.types.Metadata[] value)  { throw new RuntimeException(); }
  /** Puts a null. */
  public  org.apache.spark.sql.types.MetadataBuilder putNull (java.lang.String key)  { throw new RuntimeException(); }
  /** Puts a String. */
  public  org.apache.spark.sql.types.MetadataBuilder putString (java.lang.String key, java.lang.String value)  { throw new RuntimeException(); }
  /** Puts a String array. */
  public  org.apache.spark.sql.types.MetadataBuilder putStringArray (java.lang.String key, java.lang.String[] value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.MetadataBuilder remove (java.lang.String key)  { throw new RuntimeException(); }
  /** Include the content of an existing {@link Metadata} instance. */
  public  org.apache.spark.sql.types.MetadataBuilder withMetadata (org.apache.spark.sql.types.Metadata metadata)  { throw new RuntimeException(); }
}
