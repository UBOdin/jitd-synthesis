package org.apache.spark.sql.catalyst.util;
/**
 * A builder of {@link ArrayBasedMapData}, which fails if a null map key is detected, and removes
 * duplicated map keys w.r.t. the last wins policy.
 */
public  class ArrayBasedMapBuilder implements scala.Serializable {
  public   ArrayBasedMapBuilder (org.apache.spark.sql.types.DataType keyType, org.apache.spark.sql.types.DataType valueType)  { throw new RuntimeException(); }
  /**
   * Builds the result {@link ArrayBasedMapData} and reset this builder to free up the resources. The
   * builder becomes fresh afterward and is ready to take input and build another map.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.util.ArrayBasedMapData build ()  { throw new RuntimeException(); }
  /**
   * Builds a {@link ArrayBasedMapData} from the given key and value array and reset this builder. The
   * builder becomes fresh afterward and is ready to take input and build another map.
   * @param keyArray (undocumented)
   * @param valueArray (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.util.ArrayBasedMapData from (org.apache.spark.sql.catalyst.util.ArrayData keyArray, org.apache.spark.sql.catalyst.util.ArrayData valueArray)  { throw new RuntimeException(); }
  public  void put (Object key, Object value)  { throw new RuntimeException(); }
  public  void put (org.apache.spark.sql.catalyst.InternalRow entry)  { throw new RuntimeException(); }
  public  void putAll (org.apache.spark.sql.catalyst.util.ArrayData keyArray, org.apache.spark.sql.catalyst.util.ArrayData valueArray)  { throw new RuntimeException(); }
  /**
   * Returns the current size of the map which is going to be produced by the current builder.
   * @return (undocumented)
   */
  public  int size ()  { throw new RuntimeException(); }
}
