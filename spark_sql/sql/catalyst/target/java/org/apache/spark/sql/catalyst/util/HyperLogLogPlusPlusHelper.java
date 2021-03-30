package org.apache.spark.sql.catalyst.util;
public  class HyperLogLogPlusPlusHelper implements scala.Serializable {
  /**
   * The size of a word used for storing registers: 64 Bits.
   * @return (undocumented)
   */
  static public  int WORD_SIZE ()  { throw new RuntimeException(); }
  /**
   * The number of bits that is required per register.
   * <p>
   * This number is determined by the maximum number of leading binary zeros a hashcode can
   * produce. This is equal to the number of bits the hashcode returns. The current
   * implementation uses a 64-bit hashcode, this means 6-bits are (at most) needed to store the
   * number of leading zeros.
   * @return (undocumented)
   */
  static public  int REGISTER_SIZE ()  { throw new RuntimeException(); }
  /**
   * Value used to mask a register stored in a word.
   * @return (undocumented)
   */
  static public  long REGISTER_WORD_MASK ()  { throw new RuntimeException(); }
  /**
   * The number of registers which can be stored in one word.
   * @return (undocumented)
   */
  static public  int REGISTERS_PER_WORD ()  { throw new RuntimeException(); }
  /**
   * Number of points used for interpolating the bias value.
   * @return (undocumented)
   */
  static public  int K ()  { throw new RuntimeException(); }
  /**
   * Thresholds which decide if the linear counting or the regular algorithm is used.
   * @return (undocumented)
   */
  static public  double[] THRESHOLDS ()  { throw new RuntimeException(); }
  /**
   * Lookup table used to find the (index of the) bias correction for a given precision (exact)
   * and estimate (nearest).
   * @return (undocumented)
   */
  static public  double[][] RAW_ESTIMATE_DATA ()  { throw new RuntimeException(); }
  /**
   * Bias corrections given a precision and the index of the raw estimate table.
   * @return (undocumented)
   */
  static public  double[][] BIAS_DATA ()  { throw new RuntimeException(); }
  public   HyperLogLogPlusPlusHelper (double relativeSD)  { throw new RuntimeException(); }
  /**
   * The number of words used to store the registers. We use Longs for storage because this is the
   * most compact way of storage; Spark aligns to 8-byte words or uses Long wrappers.
   * <p>
   * We only store whole registers per word in order to prevent overly complex bitwise operations.
   * In practice this means we only use 60 out of 64 bits.
   * @return (undocumented)
   */
  public  int numWords ()  { throw new RuntimeException(); }
  /**
   * Update the HLL++ buffer.
   * <p>
   * Variable names in the HLL++ paper match variable names in the code.
   * @param buffer (undocumented)
   * @param bufferOffset (undocumented)
   * @param _value (undocumented)
   * @param dataType (undocumented)
   */
  public  void update (org.apache.spark.sql.catalyst.InternalRow buffer, int bufferOffset, Object _value, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Merge the HLL buffers by iterating through the registers in both buffers and select the
   * maximum number of leading zeros for each register.
   * @param buffer1 (undocumented)
   * @param buffer2 (undocumented)
   * @param offset1 (undocumented)
   * @param offset2 (undocumented)
   */
  public  void merge (org.apache.spark.sql.catalyst.InternalRow buffer1, org.apache.spark.sql.catalyst.InternalRow buffer2, int offset1, int offset2)  { throw new RuntimeException(); }
  /**
   * Estimate the bias using the raw estimates with their respective biases from the HLL++
   * appendix. We currently use KNN interpolation to determine the bias (as suggested in the
   * paper).
   * @param e (undocumented)
   * @return (undocumented)
   */
  public  double estimateBias (double e)  { throw new RuntimeException(); }
  /**
   * Compute the HyperLogLog estimate.
   * <p>
   * Variable names in the HLL++ paper match variable names in the code.
   * @param buffer (undocumented)
   * @param bufferOffset (undocumented)
   * @return (undocumented)
   */
  public  long query (org.apache.spark.sql.catalyst.InternalRow buffer, int bufferOffset)  { throw new RuntimeException(); }
  /**
   * The <code>rsd</code> of HLL++ is always equal to or better than the <code>rsd</code> requested.
   * This method returns the <code>rsd</code> this instance actually guarantees.
   * <p>
   * @return the actual <code>rsd</code>.
   */
  public  double trueRsd ()  { throw new RuntimeException(); }
}
