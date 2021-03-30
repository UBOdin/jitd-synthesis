package org.apache.spark.sql.hive;
/**
 * 1. The Underlying data type in catalyst and in Hive
 * In catalyst:
 *  Primitive  =&gt;
 *     UTF8String
 *     int / scala.Int
 *     boolean / scala.Boolean
 *     float / scala.Float
 *     double / scala.Double
 *     long / scala.Long
 *     short / scala.Short
 *     byte / scala.Byte
 *     {@link org.apache.spark.sql.types.Decimal}
 *     Array[Byte]
 *     java.sql.Date
 *     java.sql.Timestamp
 *  Complex Types =&gt;
 *    Map: <code>MapData</code>
 *    List: <code>ArrayData</code>
 *    Struct: {@link org.apache.spark.sql.catalyst.InternalRow}
 *    Union: NOT SUPPORTED YET
 *  The Complex types plays as a container, which can hold arbitrary data types.
 * <p>
 * In Hive, the native data types are various, in UDF/UDAF/UDTF, and associated with
 * Object Inspectors, in Hive expression evaluation framework, the underlying data are
 * Primitive Type
 *   Java Boxed Primitives:
 *       org.apache.hadoop.hive.common.type.HiveVarchar
 *       org.apache.hadoop.hive.common.type.HiveChar
 *       java.lang.String
 *       java.lang.Integer
 *       java.lang.Boolean
 *       java.lang.Float
 *       java.lang.Double
 *       java.lang.Long
 *       java.lang.Short
 *       java.lang.Byte
 *       org.apache.hadoop.hive.common.<code>type</code>.HiveDecimal
 *       byte[]
 *       java.sql.Date
 *       java.sql.Timestamp
 *   Writables:
 *       org.apache.hadoop.hive.serde2.io.HiveVarcharWritable
 *       org.apache.hadoop.hive.serde2.io.HiveCharWritable
 *       org.apache.hadoop.io.Text
 *       org.apache.hadoop.io.IntWritable
 *       org.apache.hadoop.hive.serde2.io.DoubleWritable
 *       org.apache.hadoop.io.BooleanWritable
 *       org.apache.hadoop.io.LongWritable
 *       org.apache.hadoop.io.FloatWritable
 *       org.apache.hadoop.hive.serde2.io.ShortWritable
 *       org.apache.hadoop.hive.serde2.io.ByteWritable
 *       org.apache.hadoop.io.BytesWritable
 *       org.apache.hadoop.hive.serde2.io.DateWritable
 *       org.apache.hadoop.hive.serde2.io.TimestampWritable
 *       org.apache.hadoop.hive.serde2.io.HiveDecimalWritable
 * Complex Type
 *   List: Object[] / java.util.List
 *   Map: java.util.Map
 *   Struct: Object[] / java.util.List / java POJO
 *   Union: class StandardUnion { byte tag; Object object }
 * <p>
 * NOTICE: HiveVarchar/HiveChar is not supported by catalyst, it will be simply considered as
 *  String type.
 * <p>
 * 2. Hive ObjectInspector is a group of flexible APIs to inspect value in different data
 *  representation, and developers can extend those API as needed, so technically,
 *  object inspector supports arbitrary data type in java.
 * <p>
 * Fortunately, only few built-in Hive Object Inspectors are used in generic udf/udaf/udtf
 * evaluation.
 * 1) Primitive Types (PrimitiveObjectInspector &amp; its sub classes)
 <pre><code>
 public interface PrimitiveObjectInspector {
 // Java Primitives (java.lang.Integer, java.lang.String etc.)
 Object getPrimitiveJavaObject(Object o);
 // Writables (hadoop.io.IntWritable, hadoop.io.Text etc.)
 Object getPrimitiveWritableObject(Object o);
 // ObjectInspector only inspect the `writable` always return true, we need to check it
 // before invoking the methods above.
 boolean preferWritable();
 ...
 }
 </code></pre>
 * <p>
 * 2) Complex Types:
 *   ListObjectInspector: inspects java array or {@link java.util.List}
 *   MapObjectInspector: inspects {@link java.util.Map}
 *   Struct.StructObjectInspector: inspects java array, {@link java.util.List} and
 *                                 even a normal java object (POJO)
 *   UnionObjectInspector: (tag: Int, object data) (TODO: not supported by SparkSQL yet)
 * <p>
 * 3) ConstantObjectInspector:
 * Constant object inspector can be either primitive type or Complex type, and it bundles a
 * constant value as its property, usually the value is created when the constant object inspector
 * constructed.
 * <pre><code>
 public interface ConstantObjectInspector extends ObjectInspector {
 Object getWritableConstantValue();
 ...
 }
 </code></pre>
 * Hive provides 3 built-in constant object inspectors:
 * Primitive Object Inspectors:
 *     WritableConstantStringObjectInspector
 *     WritableConstantHiveVarcharObjectInspector
 *     WritableConstantHiveCharObjectInspector
 *     WritableConstantHiveDecimalObjectInspector
 *     WritableConstantTimestampObjectInspector
 *     WritableConstantIntObjectInspector
 *     WritableConstantDoubleObjectInspector
 *     WritableConstantBooleanObjectInspector
 *     WritableConstantLongObjectInspector
 *     WritableConstantFloatObjectInspector
 *     WritableConstantShortObjectInspector
 *     WritableConstantByteObjectInspector
 *     WritableConstantBinaryObjectInspector
 *     WritableConstantDateObjectInspector
 * Map Object Inspector:
 *     StandardConstantMapObjectInspector
 * List Object Inspector:
 *     StandardConstantListObjectInspector}
 * Struct Object Inspector: Hive doesn't provide the built-in constant object inspector for Struct
 * Union Object Inspector: Hive doesn't provide the built-in constant object inspector for Union
 * <p>
 * 3. This trait facilitates:
 *    Data Unwrapping: Hive Data =&gt; Catalyst Data (unwrap)
 *    Data Wrapping: Catalyst Data =&gt; Hive Data (wrap)
 *    Binding the Object Inspector for Catalyst Data (toInspector)
 *    Retrieving the Catalyst Data Type from Object Inspector (inspectorToDataType)
 * <p>
 * 4. Future Improvement (TODO)
 *   This implementation is quite ugly and inefficient:
 *     a. Pattern matching in runtime
 *     b. Small objects creation in catalyst data =&gt; writable
 *     c. Unnecessary unwrap / wrap for nested UDF invoking:
 *       e.g. date_add(printf("%s-%s-%s", a,b,c), 3)
 *       We don't need to unwrap the data for printf and wrap it again and passes in data_add
 */
public  interface HiveInspectors {
  public  class typeInfoConversions {
    public  org.apache.hadoop.hive.serde2.typeinfo.TypeInfo toTypeInfo ()  { throw new RuntimeException(); }
    public   typeInfoConversions (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  }
  public  org.apache.spark.sql.types.DecimalType decimalTypeInfoToCatalyst (org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector inspector)  ;
  public  org.apache.hadoop.io.BytesWritable getBinaryWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getBinaryWritableConstantObjectInspector (Object value)  ;
  public  org.apache.hadoop.io.BooleanWritable getBooleanWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getBooleanWritableConstantObjectInspector (Object value)  ;
  public  org.apache.hadoop.hive.serde2.io.ByteWritable getByteWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getByteWritableConstantObjectInspector (Object value)  ;
  public  org.apache.spark.sql.execution.datasources.DaysWritable getDateWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getDateWritableConstantObjectInspector (Object value)  ;
  public  org.apache.hadoop.hive.serde2.io.HiveDecimalWritable getDecimalWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getDecimalWritableConstantObjectInspector (Object value)  ;
  public  org.apache.hadoop.hive.serde2.io.DoubleWritable getDoubleWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getDoubleWritableConstantObjectInspector (Object value)  ;
  public  org.apache.hadoop.io.FloatWritable getFloatWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getFloatWritableConstantObjectInspector (Object value)  ;
  public  org.apache.hadoop.io.IntWritable getIntWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getIntWritableConstantObjectInspector (Object value)  ;
  public  org.apache.hadoop.io.LongWritable getLongWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getLongWritableConstantObjectInspector (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getPrimitiveNullWritableConstantObjectInspector ()  ;
  public  org.apache.hadoop.hive.serde2.io.ShortWritable getShortWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getShortWritableConstantObjectInspector (Object value)  ;
  public  org.apache.hadoop.io.Text getStringWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getStringWritableConstantObjectInspector (Object value)  ;
  public  org.apache.hadoop.hive.serde2.io.TimestampWritable getTimestampWritable (Object value)  ;
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector getTimestampWritableConstantObjectInspector (Object value)  ;
  public  org.apache.spark.sql.types.DataType inspectorToDataType (org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector inspector)  ;
  public  boolean isSubClassOf (java.lang.reflect.Type t, java.lang.Class<?> parent)  ;
  public  org.apache.spark.sql.types.DataType javaTypeToDataType (java.lang.reflect.Type clz)  ;
  /**
   * @param dataType Catalyst data type
   * @return Hive java object inspector (recursively), not the Writable ObjectInspector
   * We can easily map to the Hive built-in object inspector according to the data type.
   */
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector toInspector (org.apache.spark.sql.types.DataType dataType)  ;
  /**
   * Map the catalyst expression to ObjectInspector, however,
   * if the expression is <code>Literal</code> or foldable, a constant writable object inspector returns;
   * Otherwise, we always get the object inspector according to its data type(in catalyst)
   * @param expr Catalyst expression to be mapped
   * @return Hive java objectinspector (recursively).
   */
  public  org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector toInspector (org.apache.spark.sql.catalyst.expressions.Expression expr)  ;
  /**
   * Builds unwrappers ahead of time according to object inspector
   * types to avoid pattern matching and branching costs per row.
   * <p>
   * Strictly follows the following order in unwrapping (constant OI has the higher priority):
   * Constant Null object inspector =&gt;
   *   return null
   * Constant object inspector =&gt;
   *   extract the value from constant object inspector
   * If object inspector prefers writable =&gt;
   *   extract writable from <code>data</code> and then get the catalyst type from the writable
   * Extract the java object directly from the object inspector
   * <p>
   * NOTICE: the complex data type requires recursive unwrapping.
   * <p>
   * @param objectInspector the ObjectInspector used to create an unwrapper.
   * @return A function that unwraps data objects.
   *         Use the overloaded HiveStructField version for in-place updating of a MutableRow.
   */
  public  scala.Function1<java.lang.Object, java.lang.Object> unwrapperFor (org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector objectInspector)  ;
  /**
   * Builds unwrappers ahead of time according to object inspector
   * types to avoid pattern matching and branching costs per row.
   * <p>
   * @param field The HiveStructField to create an unwrapper for.
   * @return A function that performs in-place updating of a MutableRow.
   *         Use the overloaded ObjectInspector version for assignments.
   */
  public  scala.Function3<java.lang.Object, org.apache.spark.sql.catalyst.InternalRow, java.lang.Object, scala.runtime.BoxedUnit> unwrapperFor (org.apache.hadoop.hive.serde2.objectinspector.StructField field)  ;
  public  scala.Function1<java.lang.Object, java.lang.Object> withNullSafe (scala.Function1<java.lang.Object, java.lang.Object> f)  ;
  public  java.lang.Object wrap (Object a, org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector oi, org.apache.spark.sql.types.DataType dataType)  ;
  public  java.lang.Object[] wrap (org.apache.spark.sql.catalyst.InternalRow row, scala.Function1<java.lang.Object, java.lang.Object>[] wrappers, java.lang.Object[] cache, org.apache.spark.sql.types.DataType[] dataTypes)  ;
  public  java.lang.Object[] wrap (scala.collection.Seq<java.lang.Object> row, scala.Function1<java.lang.Object, java.lang.Object>[] wrappers, java.lang.Object[] cache, org.apache.spark.sql.types.DataType[] dataTypes)  ;
  /**
   * Wraps with Hive types based on object inspector.
   * @param oi (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  scala.Function1<java.lang.Object, java.lang.Object> wrapperFor (org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector oi, org.apache.spark.sql.types.DataType dataType)  ;
}
