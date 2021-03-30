package org.apache.spark.sql.catalyst.catalog;
public  class CatalogUtils {
  static public  scala.collection.Seq<java.lang.String> normalizePartCols (java.lang.String tableName, scala.collection.Seq<java.lang.String> tableCols, scala.collection.Seq<java.lang.String> partCols, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.catalog.BucketSpec normalizeBucketSpec (java.lang.String tableName, scala.collection.Seq<java.lang.String> tableCols, org.apache.spark.sql.catalyst.catalog.BucketSpec bucketSpec, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  /**
   * Convert URI to String.
   * Since URI.toString does not decode the uri, e.g. change '%25' to '%'.
   * Here we create a hadoop Path with the given URI, and rely on Path.toString
   * to decode the uri
   * @param uri the URI of the path
   * @return the String of the path
   */
  static public  java.lang.String URIToString (java.net.URI uri)  { throw new RuntimeException(); }
  /**
   * Convert String to URI.
   * Since new URI(string) does not encode string, e.g. change '%' to '%25'.
   * Here we create a hadoop Path with the given String, and rely on Path.toUri
   * to encode the string
   * @param str the String of the path
   * @return the URI of the path
   */
  static public  java.net.URI stringToURI (java.lang.String str)  { throw new RuntimeException(); }
}
