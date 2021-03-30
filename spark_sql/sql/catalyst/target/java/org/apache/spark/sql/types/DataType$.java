package org.apache.spark.sql.types;
/**
 * @since 1.3.0
 */
public  class DataType$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DataType$ MODULE$ = null;
  public   DataType$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType fromDDL (java.lang.String ddl)  { throw new RuntimeException(); }
  /**
   * Parses data type from a string with schema. It calls <code>parser</code> for <code>schema</code>.
   * If it fails, calls <code>fallbackParser</code>. If the fallback function fails too, combines error message
   * from <code>parser</code> and <code>fallbackParser</code>.
   * <p>
   * @param schema The schema string to parse by <code>parser</code> or <code>fallbackParser</code>.
   * @param parser The function that should be invoke firstly.
   * @param errorMsg The error message for <code>parser</code>.
   * @param fallbackParser The function that is called when <code>parser</code> fails.
   * @return The data type parsed from the <code>schema</code> schema.
   */
  public  org.apache.spark.sql.types.DataType parseTypeWithFallback (java.lang.String schema, scala.Function1<java.lang.String, org.apache.spark.sql.types.DataType> parser, java.lang.String errorMsg, scala.Function1<java.lang.String, org.apache.spark.sql.types.DataType> fallbackParser)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType fromJson (java.lang.String json)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DataType parseDataType (org.json4s.JsonAST.JValue json)  { throw new RuntimeException(); }
  protected  void buildFormattedString (org.apache.spark.sql.types.DataType dataType, java.lang.String prefix, org.apache.spark.sql.catalyst.util.StringUtils.StringConcat stringConcat, int maxDepth)  { throw new RuntimeException(); }
  /**
   * Compares two types, ignoring nullability of ArrayType, MapType, StructType.
   * @param left (undocumented)
   * @param right (undocumented)
   * @return (undocumented)
   */
    boolean equalsIgnoreNullability (org.apache.spark.sql.types.DataType left, org.apache.spark.sql.types.DataType right)  { throw new RuntimeException(); }
  /**
   * Compares two types, ignoring compatible nullability of ArrayType, MapType, StructType.
   * <p>
   * Compatible nullability is defined as follows:
   *   - If <code>from</code> and <code>to</code> are ArrayTypes, <code>from</code> has a compatible nullability with <code>to</code>
   *   if and only if <code>to.containsNull</code> is true, or both of <code>from.containsNull</code> and
   *   <code>to.containsNull</code> are false.
   *   - If <code>from</code> and <code>to</code> are MapTypes, <code>from</code> has a compatible nullability with <code>to</code>
   *   if and only if <code>to.valueContainsNull</code> is true, or both of <code>from.valueContainsNull</code> and
   *   <code>to.valueContainsNull</code> are false.
   *   - If <code>from</code> and <code>to</code> are StructTypes, <code>from</code> has a compatible nullability with <code>to</code>
   *   if and only if for all every pair of fields, <code>to.nullable</code> is true, or both
   *   of <code>fromField.nullable</code> and <code>toField.nullable</code> are false.
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
    boolean equalsIgnoreCompatibleNullability (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  /**
   * Compares two types, ignoring compatible nullability of ArrayType, MapType, StructType, and
   * also the field name. It compares based on the position.
   * <p>
   * Compatible nullability is defined as follows:
   *   - If <code>from</code> and <code>to</code> are ArrayTypes, <code>from</code> has a compatible nullability with <code>to</code>
   *   if and only if <code>to.containsNull</code> is true, or both of <code>from.containsNull</code> and
   *   <code>to.containsNull</code> are false.
   *   - If <code>from</code> and <code>to</code> are MapTypes, <code>from</code> has a compatible nullability with <code>to</code>
   *   if and only if <code>to.valueContainsNull</code> is true, or both of <code>from.valueContainsNull</code> and
   *   <code>to.valueContainsNull</code> are false.
   *   - If <code>from</code> and <code>to</code> are StructTypes, <code>from</code> has a compatible nullability with <code>to</code>
   *   if and only if for all every pair of fields, <code>to.nullable</code> is true, or both
   *   of <code>fromField.nullable</code> and <code>toField.nullable</code> are false.
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
    boolean equalsIgnoreNameAndCompatibleNullability (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  /**
   * Compares two types, ignoring nullability of ArrayType, MapType, StructType, and ignoring case
   * sensitivity of field names in StructType.
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
    boolean equalsIgnoreCaseAndNullability (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  /**
   * Returns true if the two data types share the same "shape", i.e. the types
   * are the same, but the field names don't need to be the same.
   * <p>
   * @param ignoreNullability whether to ignore nullability when comparing the types
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
  public  boolean equalsStructurally (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to, boolean ignoreNullability)  { throw new RuntimeException(); }
  /**
   * Returns true if the write data type can be read using the read data type.
   * <p>
   * The write type is compatible with the read type if:
   * - Both types are arrays, the array element types are compatible, and element nullability is
   *   compatible (read allows nulls or write does not contain nulls).
   * - Both types are maps and the map key and value types are compatible, and value nullability
   *   is compatible  (read allows nulls or write does not contain nulls).
   * - Both types are structs and have the same number of fields. The type and nullability of each
   *   field from read/write is compatible. If byName is true, the name of each field from
   *   read/write needs to be the same.
   * - Both types are atomic and the write type can be safely cast to the read type.
   * <p>
   * Extra fields in write-side structs are not allowed to avoid accidentally writing data that
   * the read schema will not read, and to ensure map key equality is not changed when data is read.
   * <p>
   * @param write a write-side data type to validate against the read type
   * @param read a read-side data type
   * @return true if data written with the write type can be read using the read type
   * @param byName (undocumented)
   * @param resolver (undocumented)
   * @param context (undocumented)
   * @param storeAssignmentPolicy (undocumented)
   * @param addError (undocumented)
   */
  public  boolean canWrite (org.apache.spark.sql.types.DataType write, org.apache.spark.sql.types.DataType read, boolean byName, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver, java.lang.String context, scala.Enumeration.Value storeAssignmentPolicy, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> addError)  { throw new RuntimeException(); }
}
