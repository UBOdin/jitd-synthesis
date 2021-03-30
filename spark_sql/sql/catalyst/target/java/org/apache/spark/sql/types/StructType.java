package org.apache.spark.sql.types;
/**
 * A {@link StructType} object can be constructed by
 * <pre><code>
 * StructType(fields: Seq[StructField])
 * </code></pre>
 * For a {@link StructType} object, one or multiple {@link StructField}s can be extracted by names.
 * If multiple {@link StructField}s are extracted, a {@link StructType} object will be returned.
 * If a provided name does not have a matching field, it will be ignored. For the case
 * of extracting a single {@link StructField}, a <code>null</code> will be returned.
 * <p>
 * Scala Example:
 * <pre><code>
 * import org.apache.spark.sql._
 * import org.apache.spark.sql.types._
 *
 * val struct =
 *   StructType(
 *     StructField("a", IntegerType, true) ::
 *     StructField("b", LongType, false) ::
 *     StructField("c", BooleanType, false) :: Nil)
 *
 * // Extract a single StructField.
 * val singleField = struct("b")
 * // singleField: StructField = StructField(b,LongType,false)
 *
 * // If this struct does not have a field called "d", it throws an exception.
 * struct("d")
 * // java.lang.IllegalArgumentException: d does not exist.
 * //   ...
 *
 * // Extract multiple StructFields. Field names are provided in a set.
 * // A StructType object will be returned.
 * val twoFields = struct(Set("b", "c"))
 * // twoFields: StructType =
 * //   StructType(StructField(b,LongType,false), StructField(c,BooleanType,false))
 *
 * // Any names without matching fields will throw an exception.
 * // For the case shown below, an exception is thrown due to "d".
 * struct(Set("b", "c", "d"))
 * // java.lang.IllegalArgumentException: d does not exist.
 * //    ...
 * </code></pre>
 * <p>
 * A {@link org.apache.spark.sql.Row} object is used as a value of the {@link StructType}.
 * <p>
 * Scala Example:
 * <pre><code>
 * import org.apache.spark.sql._
 * import org.apache.spark.sql.types._
 *
 * val innerStruct =
 *   StructType(
 *     StructField("f1", IntegerType, true) ::
 *     StructField("f2", LongType, false) ::
 *     StructField("f3", BooleanType, false) :: Nil)
 *
 * val struct = StructType(
 *   StructField("a", innerStruct, true) :: Nil)
 *
 * // Create a Row with the schema defined by struct
 * val row = Row(Row(1, 2, true))
 * </code></pre>
 * <p>
 * @since 1.3.0
 */
public  class StructType extends org.apache.spark.sql.types.DataType implements scala.collection.Seq<org.apache.spark.sql.types.StructField>, scala.Product, scala.Serializable {
  static   org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
  static   boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.StructType fromString (java.lang.String raw)  { throw new RuntimeException(); }
  /**
   * Creates StructType for a given DDL-formatted string, which is a comma separated list of field
   * definitions, e.g., a INT, b STRING.
   * <p>
   * @since 2.2.0
   * @param ddl (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.types.StructType fromDDL (java.lang.String ddl)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.StructType fromAttributes (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DataType removeMetadata (java.lang.String key, org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  static   scala.collection.Map<java.lang.String, org.apache.spark.sql.types.StructField> fieldsMap (org.apache.spark.sql.types.StructField[] fields)  { throw new RuntimeException(); }
  /**
   * Returns a <code>StructType</code> that contains missing fields recursively from <code>source</code> to <code>target</code>.
   * Note that this doesn't support looking into array type and map type recursively.
   * @param source (undocumented)
   * @param target (undocumented)
   * @param resolver (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<org.apache.spark.sql.types.StructType> findMissingFields (org.apache.spark.sql.types.StructType source, org.apache.spark.sql.types.StructType target, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructField[] fields ()  { throw new RuntimeException(); }
  // not preceding
  public   StructType (org.apache.spark.sql.types.StructField[] fields)  { throw new RuntimeException(); }
  /** No-arg constructor for kryo. */
  public   StructType ()  { throw new RuntimeException(); }
  /** Returns all field names in an array. */
  public  java.lang.String[] fieldNames ()  { throw new RuntimeException(); }
  /**
   * Returns all field names in an array. This is an alias of <code>fieldNames</code>.
   * <p>
   * @since 2.4.0
   * @return (undocumented)
   */
  public  java.lang.String[] names ()  { throw new RuntimeException(); }
  public  boolean equals (Object that)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  /**
   * Creates a new {@link StructType} by adding a new field.
   * <pre><code>
   * val struct = (new StructType)
   *   .add(StructField("a", IntegerType, true))
   *   .add(StructField("b", LongType, false))
   *   .add(StructField("c", StringType, true))
   *</code></pre>
   * @param field (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType add (org.apache.spark.sql.types.StructField field)  { throw new RuntimeException(); }
  /**
   * Creates a new {@link StructType} by adding a new nullable field with no metadata.
   * <p>
   * val struct = (new StructType)
   *   .add("a", IntegerType)
   *   .add("b", LongType)
   *   .add("c", StringType)
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType add (java.lang.String name, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Creates a new {@link StructType} by adding a new field with no metadata.
   * <p>
   * val struct = (new StructType)
   *   .add("a", IntegerType, true)
   *   .add("b", LongType, false)
   *   .add("c", StringType, true)
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @param nullable (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType add (java.lang.String name, org.apache.spark.sql.types.DataType dataType, boolean nullable)  { throw new RuntimeException(); }
  /**
   * Creates a new {@link StructType} by adding a new field and specifying metadata.
   * <pre><code>
   * val struct = (new StructType)
   *   .add("a", IntegerType, true, Metadata.empty)
   *   .add("b", LongType, false, Metadata.empty)
   *   .add("c", StringType, true, Metadata.empty)
   * </code></pre>
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @param nullable (undocumented)
   * @param metadata (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType add (java.lang.String name, org.apache.spark.sql.types.DataType dataType, boolean nullable, org.apache.spark.sql.types.Metadata metadata)  { throw new RuntimeException(); }
  /**
   * Creates a new {@link StructType} by adding a new field and specifying metadata.
   * <pre><code>
   * val struct = (new StructType)
   *   .add("a", IntegerType, true, "comment1")
   *   .add("b", LongType, false, "comment2")
   *   .add("c", StringType, true, "comment3")
   * </code></pre>
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @param nullable (undocumented)
   * @param comment (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType add (java.lang.String name, org.apache.spark.sql.types.DataType dataType, boolean nullable, java.lang.String comment)  { throw new RuntimeException(); }
  /**
   * Creates a new {@link StructType} by adding a new nullable field with no metadata where the
   * dataType is specified as a String.
   * <p>
   * <pre><code>
   * val struct = (new StructType)
   *   .add("a", "int")
   *   .add("b", "long")
   *   .add("c", "string")
   * </code></pre>
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType add (java.lang.String name, java.lang.String dataType)  { throw new RuntimeException(); }
  /**
   * Creates a new {@link StructType} by adding a new field with no metadata where the
   * dataType is specified as a String.
   * <p>
   * <pre><code>
   * val struct = (new StructType)
   *   .add("a", "int", true)
   *   .add("b", "long", false)
   *   .add("c", "string", true)
   * </code></pre>
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @param nullable (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType add (java.lang.String name, java.lang.String dataType, boolean nullable)  { throw new RuntimeException(); }
  /**
   * Creates a new {@link StructType} by adding a new field and specifying metadata where the
   * dataType is specified as a String.
   * <pre><code>
   * val struct = (new StructType)
   *   .add("a", "int", true, Metadata.empty)
   *   .add("b", "long", false, Metadata.empty)
   *   .add("c", "string", true, Metadata.empty)
   * </code></pre>
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @param nullable (undocumented)
   * @param metadata (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType add (java.lang.String name, java.lang.String dataType, boolean nullable, org.apache.spark.sql.types.Metadata metadata)  { throw new RuntimeException(); }
  /**
   * Creates a new {@link StructType} by adding a new field and specifying metadata where the
   * dataType is specified as a String.
   * <pre><code>
   * val struct = (new StructType)
   *   .add("a", "int", true, "comment1")
   *   .add("b", "long", false, "comment2")
   *   .add("c", "string", true, "comment3")
   * </code></pre>
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @param nullable (undocumented)
   * @param comment (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType add (java.lang.String name, java.lang.String dataType, boolean nullable, java.lang.String comment)  { throw new RuntimeException(); }
  /**
   * Extracts the {@link StructField} with the given name.
   * <p>
   * @throws IllegalArgumentException if a field with the given name does not exist
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructField apply (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Returns a {@link StructType} containing {@link StructField}s of the given names, preserving the
   * original order of fields.
   * <p>
   * @throws IllegalArgumentException if at least one given field name does not exist
   * @param names (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType apply (scala.collection.immutable.Set<java.lang.String> names)  { throw new RuntimeException(); }
  /**
   * Returns the index of a given field.
   * <p>
   * @throws IllegalArgumentException if a field with the given name does not exist
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  int fieldIndex (java.lang.String name)  { throw new RuntimeException(); }
    scala.Option<java.lang.Object> getFieldIndex (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Returns the normalized path to a field and the field in this struct and its child structs.
   * <p>
   * If includeCollections is true, this will return fields that are nested in maps and arrays.
   * @param fieldNames (undocumented)
   * @param includeCollections (undocumented)
   * @param resolver (undocumented)
   * @return (undocumented)
   */
    scala.Option<scala.Tuple2<scala.collection.Seq<java.lang.String>, org.apache.spark.sql.types.StructField>> findNestedField (scala.collection.Seq<java.lang.String> fieldNames, boolean includeCollections, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> toAttributes ()  { throw new RuntimeException(); }
  public  java.lang.String treeString ()  { throw new RuntimeException(); }
  public  java.lang.String treeString (int maxDepth)  { throw new RuntimeException(); }
  public  void printTreeString ()  { throw new RuntimeException(); }
    void buildFormattedString (java.lang.String prefix, org.apache.spark.sql.catalyst.util.StringUtils.StringConcat stringConcat, int maxDepth)  { throw new RuntimeException(); }
    org.json4s.JsonAST.JObject jsonValue ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructField apply (int fieldIndex)  { throw new RuntimeException(); }
  public  int length ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.types.StructField> iterator ()  { throw new RuntimeException(); }
  /**
   * The default size of a value of the StructType is the total default sizes of all field types.
   * @return (undocumented)
   */
  public  int defaultSize ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  public  java.lang.String catalogString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  /**
   * Returns a string containing a schema in DDL format. For example, the following value:
   * <code>StructType(Seq(StructField("eventId", IntegerType), StructField("s", StringType)))</code>
   * will be converted to <code>eventId</code> INT, <code>s</code> STRING.
   * The returned DDL schema can be used in a table creation.
   * <p>
   * @since 2.4.0
   * @return (undocumented)
   */
  public  java.lang.String toDDL ()  { throw new RuntimeException(); }
    java.lang.String simpleString (int maxNumberFields)  { throw new RuntimeException(); }
  /**
   * Merges with another schema (<code>StructType</code>).  For a struct field A from <code>this</code> and a struct field
   * B from <code>that</code>,
   * <p>
   * 1. If A and B have the same name and data type, they are merged to a field C with the same name
   *    and data type.  C is nullable if and only if either A or B is nullable.
   * 2. If A doesn't exist in <code>that</code>, it's included in the result schema.
   * 3. If B doesn't exist in <code>this</code>, it's also included in the result schema.
   * 4. Otherwise, <code>this</code> and <code>that</code> are considered as conflicting schemas and an exception would be
   *    thrown.
   * @param that (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.types.StructType merge (org.apache.spark.sql.types.StructType that)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.StructType asNullable ()  { throw new RuntimeException(); }
    boolean existsRecursively (scala.Function1<org.apache.spark.sql.types.DataType, java.lang.Object> f)  { throw new RuntimeException(); }
  // not preceding
    org.apache.spark.sql.catalyst.expressions.InterpretedOrdering interpretedOrdering ()  { throw new RuntimeException(); }
}
