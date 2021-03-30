package org.apache.spark.sql.catalyst.optimizer;
/**
 * Prunes unnecessary object serializers from query plan. This rule prunes both individual
 * serializer and nested fields in serializers.
 */
public  class ObjectSerializerPruning {
  static public  class IsNullCondition$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final IsNullCondition$ MODULE$ = null;
    public   IsNullCondition$ ()  { throw new RuntimeException(); }
    public  boolean unapply (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  }
  /**
   * Visible for testing.
   * Collects all struct types from given data type object, recursively.
   * @param dt (undocumented)
   * @param structs (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.mutable.ArrayBuffer<org.apache.spark.sql.types.StructType> collectStructType (org.apache.spark.sql.types.DataType dt, scala.collection.mutable.ArrayBuffer<org.apache.spark.sql.types.StructType> structs)  { throw new RuntimeException(); }
  /**
   * This method prunes given serializer expression by given pruned data type. For example,
   * given a serializer creating struct(a int, b int) and pruned data type struct(a int),
   * this method returns pruned serializer creating struct(a int).
   * @param serializer (undocumented)
   * @param prunedDataType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.expressions.NamedExpression pruneSerializer (org.apache.spark.sql.catalyst.expressions.NamedExpression serializer, org.apache.spark.sql.types.DataType prunedDataType)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
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
  static public  java.lang.String ruleName ()  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
}
