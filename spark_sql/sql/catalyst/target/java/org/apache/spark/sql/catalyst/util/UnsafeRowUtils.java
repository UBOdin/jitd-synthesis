package org.apache.spark.sql.catalyst.util;
public  class UnsafeRowUtils {
  /**
   * Use the following rules to check the integrity of the UnsafeRow:
   * - schema.fields.length == row.numFields should always be true
   * - UnsafeRow.calculateBitSetWidthInBytes(row.numFields) < row.getSizeInBytes should always be
   *   true if the expectedSchema contains at least one field.
   * - For variable-length fields: if null bit says it's null then don't do anything, else extract
   *   offset and size:
   *   1) 0 <= size < row.getSizeInBytes should always be true. We can be even more precise than
   *      this, where the upper bound of size can only be as big as the variable length part of
   *      the row.
   *   2) offset should be >= fixed sized part of the row.
   *   3) offset + size should be within the row bounds.
   * - For fixed-length fields that are narrower than 8 bytes (boolean/byte/short/int/float), if
   *   null bit says it's null then don't do anything, else:
   *     check if the unused bits in the field are all zeros. The UnsafeRowWriter's write() methods
   *     make this guarantee.
   * - Check the total length of the row.
   * @param row (undocumented)
   * @param expectedSchema (undocumented)
   * @return (undocumented)
   */
  static public  boolean validateStructuralIntegrity (org.apache.spark.sql.catalyst.expressions.UnsafeRow row, org.apache.spark.sql.types.StructType expectedSchema)  { throw new RuntimeException(); }
}
