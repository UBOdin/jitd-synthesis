package org.apache.spark.sql.types;
/**
 * @since 1.3.0
 */
public  class StructType$ extends org.apache.spark.sql.types.AbstractDataType implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final StructType$ MODULE$ = null;
  public   StructType$ ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
    boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
    java.lang.String simpleString ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.StructType fromString (java.lang.String raw)  { throw new RuntimeException(); }
  /**
   * Creates StructType for a given DDL-formatted string, which is a comma separated list of field
   * definitions, e.g., a INT, b STRING.
   * <p>
   * @since 2.2.0
   * @param ddl (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType fromDDL (java.lang.String ddl)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType apply (scala.collection.Seq<org.apache.spark.sql.types.StructField> fields)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType apply (java.util.List<org.apache.spark.sql.types.StructField> fields)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.StructType fromAttributes (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DataType removeMetadata (java.lang.String key, org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DataType merge (org.apache.spark.sql.types.DataType left, org.apache.spark.sql.types.DataType right)  { throw new RuntimeException(); }
    scala.collection.Map<java.lang.String, org.apache.spark.sql.types.StructField> fieldsMap (org.apache.spark.sql.types.StructField[] fields)  { throw new RuntimeException(); }
  /**
   * Returns a <code>StructType</code> that contains missing fields recursively from <code>source</code> to <code>target</code>.
   * Note that this doesn't support looking into array type and map type recursively.
   * @param source (undocumented)
   * @param target (undocumented)
   * @param resolver (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.types.StructType> findMissingFields (org.apache.spark.sql.types.StructType source, org.apache.spark.sql.types.StructType target, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
}
