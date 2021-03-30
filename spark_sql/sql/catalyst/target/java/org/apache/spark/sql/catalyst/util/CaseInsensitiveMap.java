package org.apache.spark.sql.catalyst.util;
/**
 * Builds a map in which keys are case insensitive. Input map can be accessed for cases where
 * case-sensitive information is required. The primary constructor is marked private to avoid
 * nested case-insensitive map creation, otherwise the keys in the original map will become
 * case-insensitive in this scenario.
 * Note: CaseInsensitiveMap is serializable. However, after transformation, e.g. <code>filterKeys()</code>,
 *       it may become not serializable.
 */
public  class CaseInsensitiveMap<T extends java.lang.Object> implements scala.collection.immutable.Map<java.lang.String, T>, scala.Serializable {
  static public <T extends java.lang.Object> org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<T> apply (scala.collection.immutable.Map<java.lang.String, T> params)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, T> originalMap ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, T> keyLowerCasedMap ()  { throw new RuntimeException(); }
  public  scala.Option<T> get (java.lang.String k)  { throw new RuntimeException(); }
  public  boolean contains (java.lang.String k)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<scala.Tuple2<java.lang.String, T>> iterator ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, T> toMap ()  { throw new RuntimeException(); }
}
