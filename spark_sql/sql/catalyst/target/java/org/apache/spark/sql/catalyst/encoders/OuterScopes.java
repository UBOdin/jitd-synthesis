package org.apache.spark.sql.catalyst.encoders;
public  class OuterScopes {
  // not preceding
  static public  java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> outerScopes ()  { throw new RuntimeException(); }
  /**
   * Adds a new outer scope to this context that can be used when instantiating an <code>inner class</code>
   * during deserialization. Inner classes are created when a case class is defined in the
   * Spark REPL and registering the outer scope that this class was defined in allows us to create
   * new instances on the spark executors.  In normal use, users should not need to call this
   * function.
   * <p>
   * Warning: this function operates on the assumption that there is only ever one instance of any
   * given wrapper class.
   * @param outer (undocumented)
   */
  static public  void addOuterScope (java.lang.Object outer)  { throw new RuntimeException(); }
  /**
   * Returns a function which can get the outer scope for the given inner class.  By using function
   * as return type, we can delay the process of getting outer pointer to execution time, which is
   * useful for inner class defined in REPL.
   * @param innerCls (undocumented)
   * @return (undocumented)
   */
  static public  scala.Function0<java.lang.Object> getOuterScope (java.lang.Class<?> innerCls)  { throw new RuntimeException(); }
}
