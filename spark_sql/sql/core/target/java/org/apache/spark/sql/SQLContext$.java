package org.apache.spark.sql;
/**
 * This SQLContext object contains utility functions to create a singleton SQLContext instance,
 * or to get the created SQLContext instance.
 * <p>
 * It also provides utility functions to support preference for threads in multiple sessions
 * scenario, setActive could set a SQLContext for current thread, which will be returned by
 * getOrCreate instead of the global one.
 */
public  class SQLContext$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SQLContext$ MODULE$ = null;
  public   SQLContext$ ()  { throw new RuntimeException(); }
  /**
   * Get the singleton SQLContext if it exists or create a new one using the given SparkContext.
   * <p>
   * This function can be used to create a singleton SQLContext object that can be shared across
   * the JVM.
   * <p>
   * If there is an active SQLContext for current thread, it will be returned instead of the global
   * one.
   * <p>
   * @since 1.5.0
   * @param sparkContext (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use SparkSession.builder instead. Since 2.0.0. 
   */
  public  org.apache.spark.sql.SQLContext getOrCreate (org.apache.spark.SparkContext sparkContext)  { throw new RuntimeException(); }
  /**
   * Changes the SQLContext that will be returned in this thread and its children when
   * SQLContext.getOrCreate() is called. This can be used to ensure that a given thread receives
   * a SQLContext with an isolated session, instead of the global (first created) context.
   * <p>
   * @since 1.6.0
   * @param sqlContext (undocumented)
   *
   * @deprecated Use SparkSession.setActiveSession instead. Since 2.0.0. 
   */
  public  void setActive (org.apache.spark.sql.SQLContext sqlContext)  { throw new RuntimeException(); }
  /**
   * Clears the active SQLContext for current thread. Subsequent calls to getOrCreate will
   * return the first created context instead of a thread-local override.
   * <p>
   * @since 1.6.0
   *
   * @deprecated Use SparkSession.clearActiveSession instead. Since 2.0.0. 
   */
  public  void clearActive ()  { throw new RuntimeException(); }
  /**
   * Converts an iterator of Java Beans to InternalRow using the provided
   * bean info &amp; schema. This is not related to the singleton, but is a static
   * method for internal use.
   * @param data (undocumented)
   * @param beanClass (undocumented)
   * @param attrs (undocumented)
   * @return (undocumented)
   */
    scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> beansToRows (scala.collection.Iterator<?> data, java.lang.Class<?> beanClass, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> attrs)  { throw new RuntimeException(); }
  /**
   * Extract <code>spark.sql.*</code> properties from the conf and return them as a {@link Properties}.
   * @param sparkConf (undocumented)
   * @return (undocumented)
   */
    java.util.Properties getSQLProperties (org.apache.spark.SparkConf sparkConf)  { throw new RuntimeException(); }
}
