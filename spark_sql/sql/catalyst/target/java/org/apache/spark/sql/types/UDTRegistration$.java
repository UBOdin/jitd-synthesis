package org.apache.spark.sql.types;
/**
 * This object keeps the mappings between user classes and their User Defined Types (UDTs).
 * Previously we use the annotation <code>SQLUserDefinedType</code> to register UDTs for user classes.
 * However, by doing this, we add SparkSQL dependency on user classes. This object provides
 * alternative approach to register UDTs for user classes.
 */
public  class UDTRegistration$ implements scala.Serializable, org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final UDTRegistration$ MODULE$ = null;
  public   UDTRegistration$ ()  { throw new RuntimeException(); }
  /**
   * Queries if a given user class is already registered or not.
   * @param userClassName the name of user class
   * @return boolean value indicates if the given user class is registered or not
   */
  public  boolean exists (java.lang.String userClassName)  { throw new RuntimeException(); }
  /**
   * Registers an UserDefinedType to an user class. If the user class is already registered
   * with another UserDefinedType, warning log message will be shown.
   * @param userClass the name of user class
   * @param udtClass the name of UserDefinedType class for the given userClass
   */
  public  void register (java.lang.String userClass, java.lang.String udtClass)  { throw new RuntimeException(); }
  /**
   * Returns the Class of UserDefinedType for the name of a given user class.
   * @param userClass class name of user class
   * @return Option value of the Class object of UserDefinedType
   */
  public  scala.Option<java.lang.Class<?>> getUDTFor (java.lang.String userClass)  { throw new RuntimeException(); }
}
