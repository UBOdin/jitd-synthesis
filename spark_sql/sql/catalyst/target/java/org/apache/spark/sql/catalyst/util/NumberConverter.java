package org.apache.spark.sql.catalyst.util;
public  class NumberConverter {
  /**
   * Convert numbers between different number bases. If toBase>0 the result is
   * unsigned, otherwise it is signed.
   * NB: This logic is borrowed from org.apache.hadoop.hive.ql.ud.UDFConv
   * @param n (undocumented)
   * @param fromBase (undocumented)
   * @param toBase (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.unsafe.types.UTF8String convert (byte[] n, int fromBase, int toBase)  { throw new RuntimeException(); }
  static public  byte[] toBinary (long l)  { throw new RuntimeException(); }
  static public  byte[] toBinary (int i)  { throw new RuntimeException(); }
  static public  byte[] toBinary (short s)  { throw new RuntimeException(); }
  static public  byte[] toBinary (byte s)  { throw new RuntimeException(); }
}
