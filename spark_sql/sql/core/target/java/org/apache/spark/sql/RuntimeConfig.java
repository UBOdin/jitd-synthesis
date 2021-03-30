package org.apache.spark.sql;
/**
 * Runtime configuration interface for Spark. To access this, use <code>SparkSession.conf</code>.
 * <p>
 * Options set here are automatically propagated to the Hadoop configuration during I/O.
 * <p>
 * @since 2.0.0
 */
public  class RuntimeConfig {
     RuntimeConfig (org.apache.spark.sql.internal.SQLConf sqlConf)  { throw new RuntimeException(); }
  /**
   * Sets the given Spark runtime configuration property.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   */
  public  void set (java.lang.String key, java.lang.String value)  { throw new RuntimeException(); }
  /**
   * Sets the given Spark runtime configuration property.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   */
  public  void set (java.lang.String key, boolean value)  { throw new RuntimeException(); }
  /**
   * Sets the given Spark runtime configuration property.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param value (undocumented)
   */
  public  void set (java.lang.String key, long value)  { throw new RuntimeException(); }
  /**
   * Returns the value of Spark runtime configuration property for the given key.
   * <p>
   * @throws java.util.NoSuchElementException if the key is not set and does not have a default
   *                                          value
   * @since 2.0.0
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String get (java.lang.String key) throws java.util.NoSuchElementException { throw new RuntimeException(); }
  /**
   * Returns the value of Spark runtime configuration property for the given key.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @param default_ (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String get (java.lang.String key, java.lang.String default_)  { throw new RuntimeException(); }
  /**
   * Returns the value of Spark runtime configuration property for the given key.
   * @param entry (undocumented)
   * @return (undocumented)
   */
  protected <T extends java.lang.Object> T get (org.apache.spark.internal.config.ConfigEntry<T> entry) throws java.util.NoSuchElementException { throw new RuntimeException(); }
  protected <T extends java.lang.Object> scala.Option<T> get (org.apache.spark.internal.config.OptionalConfigEntry<T> entry)  { throw new RuntimeException(); }
  /**
   * Returns the value of Spark runtime configuration property for the given key.
   * @param entry (undocumented)
   * @param default_ (undocumented)
   * @return (undocumented)
   */
  protected <T extends java.lang.Object> T get (org.apache.spark.internal.config.ConfigEntry<T> entry, T default_)  { throw new RuntimeException(); }
  /**
   * Returns all properties set in this conf.
   * <p>
   * @since 2.0.0
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> getAll ()  { throw new RuntimeException(); }
  /**
   * Returns the value of Spark runtime configuration property for the given key.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<java.lang.String> getOption (java.lang.String key)  { throw new RuntimeException(); }
  /**
   * Resets the configuration property for the given key.
   * <p>
   * @since 2.0.0
   * @param key (undocumented)
   */
  public  void unset (java.lang.String key)  { throw new RuntimeException(); }
  /**
   * Indicates whether the configuration property with the given key
   * is modifiable in the current session.
   * <p>
   * @return <code>true</code> if the configuration property is modifiable. For static SQL, Spark Core,
   *         invalid (not existing) and other non-modifiable configuration properties,
   *         the returned value is <code>false</code>.
   * @since 2.4.0
   * @param key (undocumented)
   */
  public  boolean isModifiable (java.lang.String key)  { throw new RuntimeException(); }
  /**
   * Returns whether a particular key is set.
   * @param key (undocumented)
   * @return (undocumented)
   */
  protected  boolean contains (java.lang.String key)  { throw new RuntimeException(); }
}
