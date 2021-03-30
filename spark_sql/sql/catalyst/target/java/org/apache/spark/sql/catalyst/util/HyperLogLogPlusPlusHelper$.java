package org.apache.spark.sql.catalyst.util;
/**
 * Constants used in the implementation of the HyperLogLogPlusPlus aggregate function.
 * <p>
 * See the Appendix to HyperLogLog in Practice: Algorithmic Engineering of a State of the Art
 * Cardinality (https://docs.google.com/document/d/1gyjfMHy43U9OWBXxfaeG-3MjGzejW1dlpyMwEYAAWEI/view?fullscreen)
 * for more information.
 */
public  class HyperLogLogPlusPlusHelper$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HyperLogLogPlusPlusHelper$ MODULE$ = null;
  public   HyperLogLogPlusPlusHelper$ ()  { throw new RuntimeException(); }
  /**
   * The size of a word used for storing registers: 64 Bits.
   * @return (undocumented)
   */
  public  int WORD_SIZE ()  { throw new RuntimeException(); }
  /**
   * The number of bits that is required per register.
   * <p>
   * This number is determined by the maximum number of leading binary zeros a hashcode can
   * produce. This is equal to the number of bits the hashcode returns. The current
   * implementation uses a 64-bit hashcode, this means 6-bits are (at most) needed to store the
   * number of leading zeros.
   * @return (undocumented)
   */
  public  int REGISTER_SIZE ()  { throw new RuntimeException(); }
  /**
   * Value used to mask a register stored in a word.
   * @return (undocumented)
   */
  public  long REGISTER_WORD_MASK ()  { throw new RuntimeException(); }
  /**
   * The number of registers which can be stored in one word.
   * @return (undocumented)
   */
  public  int REGISTERS_PER_WORD ()  { throw new RuntimeException(); }
  /**
   * Number of points used for interpolating the bias value.
   * @return (undocumented)
   */
  public  int K ()  { throw new RuntimeException(); }
  /**
   * Thresholds which decide if the linear counting or the regular algorithm is used.
   * @return (undocumented)
   */
  public  double[] THRESHOLDS ()  { throw new RuntimeException(); }
  /**
   * Lookup table used to find the (index of the) bias correction for a given precision (exact)
   * and estimate (nearest).
   * @return (undocumented)
   */
  public  double[][] RAW_ESTIMATE_DATA ()  { throw new RuntimeException(); }
  /**
   * Bias corrections given a precision and the index of the raw estimate table.
   * @return (undocumented)
   */
  public  double[][] BIAS_DATA ()  { throw new RuntimeException(); }
}
