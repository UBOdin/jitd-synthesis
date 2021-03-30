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
public  class GenerateUnsafeRowJoiner$ extends org.apache.spark.sql.catalyst.expressions.codegen.CodeGenerator<scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.types.StructType>, org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final GenerateUnsafeRowJoiner$ MODULE$ = null;
  public   GenerateUnsafeRowJoiner$ ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner create (scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.types.StructType> in)  { throw new RuntimeException(); }
  protected  scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.types.StructType> canonicalize (scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.types.StructType> in)  { throw new RuntimeException(); }
  protected  scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.types.StructType> bind (scala.Tuple2<org.apache.spark.sql.types.StructType, org.apache.spark.sql.types.StructType> in, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner create (org.apache.spark.sql.types.StructType schema1, org.apache.spark.sql.types.StructType schema2)  { throw new RuntimeException(); }
}
