package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * A code generator for concatenating two {@link UnsafeRow}s into a single {@link UnsafeRow}.
 * <p>
 * The high level algorithm is:
 * <p>
 * 1. Concatenate the two bitsets together into a single one, taking padding into account.
 * 2. Move fixed-length data.
 * 3. Move variable-length data.
 * 4. Update the offset position (i.e. the upper 32 bits in the fixed length part) for all
 *    variable-length data.
 */
public  class GenerateUnsafeRowJoiner {
  static protected  org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner create (scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.types.StructType> in)  { throw new RuntimeException(); }
  static protected  scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.types.StructType> canonicalize (scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.types.StructType> in)  { throw new RuntimeException(); }
  static protected  scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.types.StructType> bind (scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.types.StructType> in, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner create (org.apache.spark.sql.types.StructType schema1, org.apache.spark.sql.types.StructType schema2)  { throw new RuntimeException(); }
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
  static protected  java.lang.String genericMutableRowType ()  { throw new RuntimeException(); }
  static public  OutType generate (InType expressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  static public  OutType generate (InType expressions)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext newCodeGenContext ()  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
}
