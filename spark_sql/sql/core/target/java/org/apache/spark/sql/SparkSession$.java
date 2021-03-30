package org.apache.spark.sql;
public  class SparkSession$ implements org.apache.spark.internal.Logging, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SparkSession$ MODULE$ = null;
  public   SparkSession$ ()  { throw new RuntimeException(); }
  /**
   * Creates a {@link SparkSession.Builder} for constructing a {@link SparkSession}.
   * <p>
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.SparkSession.Builder builder ()  { throw new RuntimeException(); }
  /**
   * Changes the SparkSession that will be returned in this thread and its children when
   * SparkSession.getOrCreate() is called. This can be used to ensure that a given thread receives
   * a SparkSession with an isolated session, instead of the global (first created) context.
   * <p>
   * @since 2.0.0
   * @param session (undocumented)
   */
  public  void setActiveSession (org.apache.spark.sql.SparkSession session)  { throw new RuntimeException(); }
  /**
   * Clears the active SparkSession for current thread. Subsequent calls to getOrCreate will
   * return the first created context instead of a thread-local override.
   * <p>
   * @since 2.0.0
   */
  public  void clearActiveSession ()  { throw new RuntimeException(); }
  /**
   * Sets the default SparkSession that is returned by the builder.
   * <p>
   * @since 2.0.0
   * @param session (undocumented)
   */
  public  void setDefaultSession (org.apache.spark.sql.SparkSession session)  { throw new RuntimeException(); }
  /**
   * Clears the default SparkSession that is returned by the builder.
   * <p>
   * @since 2.0.0
   */
  public  void clearDefaultSession ()  { throw new RuntimeException(); }
  /**
   * Returns the active SparkSession for the current thread, returned by the builder.
   * <p>
   * @note Return None, when calling this function on executors
   * <p>
   * @since 2.2.0
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.SparkSession> getActiveSession ()  { throw new RuntimeException(); }
  /**
   * Returns the default SparkSession that is returned by the builder.
   * <p>
   * @note Return None, when calling this function on executors
   * <p>
   * @since 2.2.0
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.SparkSession> getDefaultSession ()  { throw new RuntimeException(); }
  /**
   * Returns the currently active SparkSession, otherwise the default one. If there is no default
   * SparkSession, throws an exception.
   * <p>
   * @since 2.4.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.SparkSession active ()  { throw new RuntimeException(); }
  /**
   * Returns a cloned SparkSession with all specified configurations disabled, or
   * the original SparkSession if all configurations are already disabled.
   * @param session (undocumented)
   * @param configurations (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.SparkSession getOrCloneSessionWithConfigsOff (org.apache.spark.sql.SparkSession session, scala.collection.Seq<org.apache.spark.internal.config.ConfigEntry<java.lang.Object>> configurations)  { throw new RuntimeException(); }
  /**
   * @return true if Hive classes can be loaded, otherwise false.
   */
    boolean hiveClassesArePresent ()  { throw new RuntimeException(); }
    void cleanupAnyExistingSession ()  { throw new RuntimeException(); }
}
