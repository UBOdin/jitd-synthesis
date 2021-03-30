package org.apache.spark.sql.types;
public  class ByteExactNumeric {
  static public  byte plus (byte x, byte y)  { throw new RuntimeException(); }
  static public  byte minus (byte x, byte y)  { throw new RuntimeException(); }
  static public  byte times (byte x, byte y)  { throw new RuntimeException(); }
  static public  byte negate (byte x)  { throw new RuntimeException(); }
  static public abstract  boolean equals (Object x$1)  ;
  static public  java.util.Comparator<T> reversed ()  { throw new RuntimeException(); }
  static public  java.util.Comparator<T> thenComparing (java.util.Comparator<? super T> x$1)  { throw new RuntimeException(); }
  static public <U extends java.lang.Object> java.util.Comparator<T> thenComparing (java.util.function.Function<? super T, ? extends U> x$1, java.util.Comparator<? super U> x$2)  { throw new RuntimeException(); }
  static public <U extends java.lang.Comparable<? super U>> java.util.Comparator<T> thenComparing (java.util.function.Function<? super T, ? extends U> x$1)  { throw new RuntimeException(); }
  static public  java.util.Comparator<T> thenComparingInt (java.util.function.ToIntFunction<? super T> x$1)  { throw new RuntimeException(); }
  static public  java.util.Comparator<T> thenComparingLong (java.util.function.ToLongFunction<? super T> x$1)  { throw new RuntimeException(); }
  static public  java.util.Comparator<T> thenComparingDouble (java.util.function.ToDoubleFunction<? super T> x$1)  { throw new RuntimeException(); }
  static public  scala.Some<java.lang.Object> tryCompare (T x, T y)  { throw new RuntimeException(); }
  static public  boolean lteq (T x, T y)  { throw new RuntimeException(); }
  static public  boolean gteq (T x, T y)  { throw new RuntimeException(); }
  static public  boolean lt (T x, T y)  { throw new RuntimeException(); }
  static public  boolean gt (T x, T y)  { throw new RuntimeException(); }
  static public  boolean equiv (T x, T y)  { throw new RuntimeException(); }
  static public  T max (T x, T y)  { throw new RuntimeException(); }
  static public  T min (T x, T y)  { throw new RuntimeException(); }
  static public  scala.math.Ordering<T> reverse ()  { throw new RuntimeException(); }
  static public <U extends java.lang.Object> scala.math.Ordering<U> on (scala.Function1<U, T> f)  { throw new RuntimeException(); }
  static public  scala.math.Ordering<T>.Ops mkOrderingOps (T lhs)  { throw new RuntimeException(); }
  static public  T zero ()  { throw new RuntimeException(); }
  static public  T one ()  { throw new RuntimeException(); }
  static public  T abs (T x)  { throw new RuntimeException(); }
  static public  int signum (T x)  { throw new RuntimeException(); }
  static public  scala.math.Integral<T>.IntegralOps mkNumericOps (T lhs)  { throw new RuntimeException(); }
  static public  byte quot (byte x, byte y)  { throw new RuntimeException(); }
  static public  byte rem (byte x, byte y)  { throw new RuntimeException(); }
  static public  byte fromInt (int x)  { throw new RuntimeException(); }
  static public  int toInt (byte x)  { throw new RuntimeException(); }
  static public  long toLong (byte x)  { throw new RuntimeException(); }
  static public  float toFloat (byte x)  { throw new RuntimeException(); }
  static public  double toDouble (byte x)  { throw new RuntimeException(); }
  static public  int compare (byte x, byte y)  { throw new RuntimeException(); }
}
