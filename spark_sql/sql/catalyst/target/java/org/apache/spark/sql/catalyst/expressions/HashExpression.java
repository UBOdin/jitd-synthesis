package org.apache.spark.sql.catalyst.expressions;
/**
 * A function that calculates hash value for a group of expressions.  Note that the <code>seed</code> argument
 * is not exposed to users and should only be set inside spark SQL.
 * <p>
 * The hash value for an expression depends on its type and seed:
 *  - null:               seed
 *  - boolean:            turn boolean into int, 1 for true, 0 for false, and then use murmur3 to
 *                        hash this int with seed.
 *  - byte, short, int:   use murmur3 to hash the input as int with seed.
 *  - long:               use murmur3 to hash the long input with seed.
 *  - float:              turn it into int: java.lang.Float.floatToIntBits(input), and hash it.
 *  - double:             turn it into long: java.lang.Double.doubleToLongBits(input), and hash it.
 *  - decimal:            if it's a small decimal, i.e. precision <= 18, turn it into long and hash
 *                        it. Else, turn it into bytes and hash it.
 *  - calendar interval:  hash <code>microseconds</code> first, and use the result as seed to hash <code>months</code>.
 *  - binary:             use murmur3 to hash the bytes with seed.
 *  - string:             get the bytes of string and hash it.
 *  - array:              The <code>result</code> starts with seed, then use <code>result</code> as seed, recursively
 *                        calculate hash value for each element, and assign the element hash value
 *                        to <code>result</code>.
 *  - struct:             The <code>result</code> starts with seed, then use <code>result</code> as seed, recursively
 *                        calculate hash value for each field, and assign the field hash value to
 *                        <code>result</code>.
 * <p>
 * Finally we aggregate the hash values for each expression by the same way of struct.
 */
public abstract class HashExpression<E extends java.lang.Object> extends org.apache.spark.sql.catalyst.expressions.Expression {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   HashExpression ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  protected abstract  E computeHash (Object value, org.apache.spark.sql.types.DataType dataType, E seed)  ;
  protected  java.lang.String computeHash (java.lang.String input, org.apache.spark.sql.types.DataType dataType, java.lang.String result, org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  protected  java.lang.String genHashBoolean (java.lang.String input, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashBytes (java.lang.String b, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashCalendarInterval (java.lang.String input, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashDecimal (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.types.DecimalType d, java.lang.String input, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashDouble (java.lang.String input, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashFloat (java.lang.String input, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashForArray (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, java.lang.String input, java.lang.String result, org.apache.spark.sql.types.DataType elementType, boolean containsNull)  { throw new RuntimeException(); }
  protected  java.lang.String genHashForMap (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, java.lang.String input, java.lang.String result, org.apache.spark.sql.types.DataType keyType, org.apache.spark.sql.types.DataType valueType, boolean valueContainsNull)  { throw new RuntimeException(); }
  protected  java.lang.String genHashForStruct (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, java.lang.String input, java.lang.String result, org.apache.spark.sql.types.StructField[] fields)  { throw new RuntimeException(); }
  protected  java.lang.String genHashInt (java.lang.String i, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashLong (java.lang.String l, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashString (java.lang.String input, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashTimestamp (java.lang.String t, java.lang.String result)  { throw new RuntimeException(); }
  protected abstract  java.lang.String hasherClassName ()  ;
  protected  java.lang.String nullSafeElementHash (java.lang.String input, java.lang.String index, boolean nullable, org.apache.spark.sql.types.DataType elementType, java.lang.String result, org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  /** Seed of the HashExpression. */
  public abstract  E seed ()  ;
}
