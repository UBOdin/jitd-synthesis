package org.apache.spark.sql.types;
/**
 * The data type for User Defined Types (UDTs).
 * <p>
 * This interface allows a user to make their own classes more interoperable with SparkSQL;
 * e.g., by creating a {@link UserDefinedType} for a class X, it becomes possible to create
 * a <code>DataFrame</code> which has class X in the schema.
 * <p>
 * For SparkSQL to recognize UDTs, the UDT must be annotated with
 * {@link SQLUserDefinedType}.
 * <p>
 * The conversion via <code>serialize</code> occurs when instantiating a <code>DataFrame</code> from another RDD.
 * The conversion via <code>deserialize</code> occurs when reading from a <code>DataFrame</code>.
 */
public abstract class UserDefinedType<UserType extends java.lang.Object> extends org.apache.spark.sql.types.DataType implements scala.Serializable {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree().setOriginal(Select(Ident(scala), scala.Null)), TypeTree()))
  public   UserDefinedType ()  { throw new RuntimeException(); }
  /** Underlying storage type for this UDT */
  public abstract  org.apache.spark.sql.types.DataType sqlType ()  ;
  /** Paired Python UDT class, if exists. */
  public  java.lang.String pyUDT ()  { throw new RuntimeException(); }
  /** Serialized Python UDT class, if exists. */
  public  java.lang.String serializedPyClass ()  { throw new RuntimeException(); }
  /**
   * Convert the user type to a SQL datum
   * @param obj (undocumented)
   * @return (undocumented)
   */
  public abstract  Object serialize (UserType obj)  ;
  /** Convert a SQL datum to the user type */
  public abstract  UserType deserialize (Object datum)  ;
    org.json4s.JsonAST.JValue jsonValue ()  { throw new RuntimeException(); }
  /**
   * Class object for the UserType
   * @return (undocumented)
   */
  public abstract  java.lang.Class<UserType> userClass ()  ;
  public  int defaultSize ()  { throw new RuntimeException(); }
  /**
   * For UDT, asNullable will not change the nullability of its internal sqlType and just returns
   * itself.
   * @return (undocumented)
   */
    org.apache.spark.sql.types.UserDefinedType<UserType> asNullable ()  { throw new RuntimeException(); }
    boolean acceptsType (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  java.lang.String catalogString ()  { throw new RuntimeException(); }
}
