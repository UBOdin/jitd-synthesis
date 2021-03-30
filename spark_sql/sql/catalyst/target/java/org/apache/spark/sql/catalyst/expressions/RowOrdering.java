package org.apache.spark.sql.catalyst.expressions;
public  class RowOrdering {
  /**
   * Returns true iff the data type can be ordered (i.e. can be sorted).
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  static public  boolean isOrderable (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Returns true iff outputs from the expressions can be ordered.
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  boolean isOrderable (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.BaseOrdering createCodeGeneratedObject (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> in)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.BaseOrdering createInterpretedObject (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> in)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.BaseOrdering create (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> order, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  /**
   * Creates a row ordering for the given schema, in natural ascending order.
   * @param dataTypes (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.expressions.BaseOrdering createNaturalAscendingOrdering (scala.collection.Seq<org.apache.spark.sql.types.DataType> dataTypes)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static public  OUT createObject (IN in)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
}
