package org.apache.spark.sql;
/**
 * Configuration methods common to create/replace operations and insert/overwrite operations.
 * @param <R>  builder type to return
 * @since 3.0.0
 */
public  interface WriteConfigMethods<R extends java.lang.Object> {
  /**
   * Add a write option.
   * <p>
   * @since 3.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  R option (java.lang.String key, java.lang.String value)  ;
  /**
   * Add a boolean output option.
   * <p>
   * @since 3.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  R option (java.lang.String key, boolean value)  ;
  /**
   * Add a long output option.
   * <p>
   * @since 3.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  R option (java.lang.String key, long value)  ;
  /**
   * Add a double output option.
   * <p>
   * @since 3.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  R option (java.lang.String key, double value)  ;
  /**
   * Add write options from a Scala Map.
   * <p>
   * @since 3.0.0
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  R options (scala.collection.Map<java.lang.String, java.lang.String> options)  ;
  /**
   * Add write options from a Java Map.
   * <p>
   * @since 3.0.0
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  R options (java.util.Map<java.lang.String, java.lang.String> options)  ;
}
