package org.apache.spark.sql.internal.connector;
/**
 * A mix-in interface for {@link FileScan}. This can be used to report metadata
 * for a file based scan operator. This is currently used for supporting formatted
 * explain.
 */
public  interface SupportsMetadata {
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> getMetaData ()  ;
}
