package org.apache.spark.sql.catalyst.util;
public  class CharVarcharUtils$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CharVarcharUtils$ MODULE$ = null;
  public   CharVarcharUtils$ ()  { throw new RuntimeException(); }
  /**
   * Replaces CharType/VarcharType with StringType recursively in the given struct type. If a
   * top-level StructField's data type is CharType/VarcharType or has nested CharType/VarcharType,
   * this method will add the original type string to the StructField's metadata, so that we can
   * re-construct the original data type with CharType/VarcharType later when needed.
   * @param st (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType replaceCharVarcharWithStringInSchema (org.apache.spark.sql.types.StructType st)  { throw new RuntimeException(); }
  /**
   * Returns true if the given data type is CharType/VarcharType or has nested CharType/VarcharType.
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  boolean hasCharVarchar (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Validate the given {@link DataType} to fail if it is char or varchar types or contains nested ones
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.DataType failIfHasCharVarchar (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Replaces CharType/VarcharType with StringType recursively in the given data type.
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.DataType replaceCharVarcharWithString (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Replaces CharType/VarcharType with StringType recursively in the given data type, with a
   * warning message if it has char or varchar types
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.DataType replaceCharVarcharWithStringForCast (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Removes the metadata entry that contains the original type string of CharType/VarcharType from
   * the given attribute's metadata.
   * @param attr (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference cleanAttrMetadata (org.apache.spark.sql.catalyst.expressions.AttributeReference attr)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> getRawTypeString (org.apache.spark.sql.types.Metadata metadata)  { throw new RuntimeException(); }
  /**
   * Re-construct the original data type from the type string in the given metadata.
   * This is needed when dealing with char/varchar columns/fields.
   * @param metadata (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.types.DataType> getRawType (org.apache.spark.sql.types.Metadata metadata)  { throw new RuntimeException(); }
  /**
   * Re-construct the original schema from the type string in the given metadata of each field.
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType getRawSchema (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Returns an expression to apply write-side string length check for the given expression. A
   * string value can not exceed N characters if it's written into a CHAR(N)/VARCHAR(N)
   * column/field.
   * @param expr (undocumented)
   * @param targetAttr (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression stringLengthCheck (org.apache.spark.sql.catalyst.expressions.Expression expr, org.apache.spark.sql.catalyst.expressions.Attribute targetAttr)  { throw new RuntimeException(); }
  /**
   * Return expressions to apply char type padding for the string comparison between the given
   * attributes. When comparing two char type columns/fields, we need to pad the shorter one to
   * the longer length.
   * @param attrs (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> addPaddingInStringComparison (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attrs)  { throw new RuntimeException(); }
}
