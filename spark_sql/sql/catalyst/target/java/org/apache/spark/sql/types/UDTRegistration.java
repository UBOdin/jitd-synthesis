package org.apache.spark.sql.types;
/**
 * This object keeps the mappings between user classes and their User Defined Types (UDTs).
 * Previously we use the annotation <code>SQLUserDefinedType</code> to register UDTs for user classes.
 * However, by doing this, we add SparkSQL dependency on user classes. This object provides
 * alternative approach to register UDTs for user classes.
 */
public  class UDTRegistration {
  /**
   * Queries if a given user class is already registered or not.
   * @param userClassName the name of user class
   * @return boolean value indicates if the given user class is registered or not
   */
  static public  boolean exists (java.lang.String userClassName)  { throw new RuntimeException(); }
  /**
   * Registers an UserDefinedType to an user class. If the user class is already registered
   * with another UserDefinedType, warning log message will be shown.
   * @param userClass the name of user class
   * @param udtClass the name of UserDefinedType class for the given userClass
   */
  static public  void register (java.lang.String userClass, java.lang.String udtClass)  { throw new RuntimeException(); }
  /**
   * Returns the Class of UserDefinedType for the name of a given user class.
   * @param userClass class name of user class
   * @return Option value of the Class object of UserDefinedType
   */
  static public  scala.Option<java.lang.Class<?>> getUDTFor (java.lang.String userClass)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
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
}
