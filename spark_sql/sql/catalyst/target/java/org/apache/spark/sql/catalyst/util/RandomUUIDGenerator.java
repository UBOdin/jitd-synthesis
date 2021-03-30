package org.apache.spark.sql.catalyst.util;
/**
 * This class is used to generate a UUID from Pseudo-Random Numbers.
 * <p>
 * For the algorithm, see RFC 4122: A Universally Unique IDentifier (UUID) URN Namespace,
 * section 4.4 "Algorithms for Creating a UUID from Truly Random or Pseudo-Random Numbers".
 */
public  class RandomUUIDGenerator implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long randomSeed ()  { throw new RuntimeException(); }
  // not preceding
  public   RandomUUIDGenerator (long randomSeed)  { throw new RuntimeException(); }
  public  java.util.UUID getNextUUID ()  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.types.UTF8String getNextUUIDUTF8String ()  { throw new RuntimeException(); }
}
