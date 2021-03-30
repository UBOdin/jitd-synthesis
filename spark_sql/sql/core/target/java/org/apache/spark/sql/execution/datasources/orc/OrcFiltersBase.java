package org.apache.spark.sql.execution.datasources.orc;
/**
 * Methods that can be shared when upgrading the built-in Hive.
 */
public  interface OrcFiltersBase {
  public  class OrcPrimitiveField implements scala.Product, scala.Serializable {
    static public abstract  R apply (T1 v1, T2 v2)  ;
    static public  java.lang.String toString ()  { throw new RuntimeException(); }
    public  java.lang.String fieldName ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.types.DataType fieldType ()  { throw new RuntimeException(); }
    // not preceding
    public   OrcPrimitiveField (java.lang.String fieldName, org.apache.spark.sql.types.DataType fieldType)  { throw new RuntimeException(); }
  }
  public  class OrcPrimitiveField$ extends scala.runtime.AbstractFunction2<java.lang.String, org.apache.spark.sql.types.DataType, org.apache.spark.sql.execution.datasources.orc.OrcFiltersBase.OrcPrimitiveField> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final OrcPrimitiveField$ MODULE$ = null;
    public   OrcPrimitiveField$ ()  { throw new RuntimeException(); }
  }
    scala.Option<org.apache.spark.sql.sources.Filter> buildTree (scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters)  ;
  /**
   * This method returns a map which contains ORC field name and data type. Each key
   * represents a column; <code>dots</code> are used as separators for nested columns. If any part
   * of the names contains <code>dots</code>, it is quoted to avoid confusion. See
   * <code>org.apache.spark.sql.connector.catalog.quoted</code> for implementation details.
   * <p>
   * BinaryType, UserDefinedType, ArrayType and MapType are ignored.
   * @param schema (undocumented)
   * @param caseSensitive (undocumented)
   * @return (undocumented)
   */
    scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.datasources.orc.OrcFiltersBase.OrcPrimitiveField> getSearchableTypeMap (org.apache.spark.sql.types.StructType schema, boolean caseSensitive)  ;
}
