package org.apache.spark.sql.catalyst.util;
public  class ArrayBasedMapData$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ArrayBasedMapData$ MODULE$ = null;
  public   ArrayBasedMapData$ ()  { throw new RuntimeException(); }
  /**
   * Creates a {@link ArrayBasedMapData} by applying the given converters over
   * each (key -> value) pair of the input {@link java.util.Map}
   * <p>
   * @param javaMap Input map
   * @param keyConverter This function is applied over all the keys of the input map to
   *                     obtain the output map's keys
   * @param valueConverter This function is applied over all the values of the input map to
   *                       obtain the output map's values
   * @return (undocumented)
   */
  public <K extends java.lang.Object, V extends java.lang.Object> org.apache.spark.sql.catalyst.util.ArrayBasedMapData apply (java.util.Map<K, V> javaMap, scala.Function1<java.lang.Object, java.lang.Object> keyConverter, scala.Function1<java.lang.Object, java.lang.Object> valueConverter)  { throw new RuntimeException(); }
  /**
   * Creates a {@link ArrayBasedMapData} by applying the given converters over
   * each (key -> value) pair of the input map
   * <p>
   * @param map Input map
   * @param keyConverter This function is applied over all the keys of the input map to
   *                     obtain the output map's keys
   * @param valueConverter This function is applied over all the values of the input map to
   *                       obtain the output map's values
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.util.ArrayBasedMapData apply (scala.collection.Map<?, ?> map, scala.Function1<java.lang.Object, java.lang.Object> keyConverter, scala.Function1<java.lang.Object, java.lang.Object> valueConverter)  { throw new RuntimeException(); }
  /**
   * Creates a {@link ArrayBasedMapData} by applying the given converters over
   * each (key -> value) pair from the given iterator
   * <p>
   * Note that, user is responsible to guarantee that the key array does not have duplicated
   * elements, otherwise the behavior is undefined.
   * <p>
   * @param iterator Input iterator
   * @param size Number of elements
   * @param keyConverter This function is applied over all the keys extracted from the
   *                     given iterator to obtain the output map's keys
   * @param valueConverter This function is applied over all the values extracted from the
   *                       given iterator to obtain the output map's values
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.util.ArrayBasedMapData apply (scala.collection.Iterator<scala.Tuple2<?, ?>> iterator, int size, scala.Function1<java.lang.Object, java.lang.Object> keyConverter, scala.Function1<java.lang.Object, java.lang.Object> valueConverter)  { throw new RuntimeException(); }
  /**
   * Creates a {@link ArrayBasedMapData} from a key and value array.
   * <p>
   * Note that, user is responsible to guarantee that the key array does not have duplicated
   * elements, otherwise the behavior is undefined.
   * @param keys (undocumented)
   * @param values (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.util.ArrayBasedMapData apply (java.lang.Object keys, java.lang.Object values)  { throw new RuntimeException(); }
  /**
   * Creates a {@link ArrayBasedMapData} from a key and value array.
   * <p>
   * Note that, user is responsible to guarantee that the key array does not have duplicated
   * elements, otherwise the behavior is undefined.
   * @param map (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.Object, java.lang.Object> toScalaMap (org.apache.spark.sql.catalyst.util.ArrayBasedMapData map)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.Object, java.lang.Object> toScalaMap (java.lang.Object[] keys, java.lang.Object[] values)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.Object, java.lang.Object> toScalaMap (scala.collection.Seq<java.lang.Object> keys, scala.collection.Seq<java.lang.Object> values)  { throw new RuntimeException(); }
  public  java.util.Map<java.lang.Object, java.lang.Object> toJavaMap (java.lang.Object[] keys, java.lang.Object[] values)  { throw new RuntimeException(); }
}
