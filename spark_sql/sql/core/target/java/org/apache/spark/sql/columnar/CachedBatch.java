package org.apache.spark.sql.columnar;
/**
 * Basic interface that all cached batches of data must support. This is primarily to allow
 * for metrics to be handled outside of the encoding and decoding steps in a standard way.
 */
public  interface CachedBatch {
  public  int numRows ()  ;
  public  long sizeInBytes ()  ;
}
