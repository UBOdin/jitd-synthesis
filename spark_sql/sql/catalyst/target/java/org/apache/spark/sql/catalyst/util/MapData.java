package org.apache.spark.sql.catalyst.util;
/**
 * This is an internal data representation for map type in Spark SQL. This should not implement
 * <code>equals</code> and <code>hashCode</code> because the type cannot be used as join keys, grouping keys, or
 * in equality tests. See SPARK-9415 and PR#13847 for the discussions.
 */
public abstract class MapData implements scala.Serializable {
  public   MapData ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.util.MapData copy ()  ;
  public  void foreach (org.apache.spark.sql.types.DataType keyType, org.apache.spark.sql.types.DataType valueType, scala.Function2<java.lang.Object, java.lang.Object, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.util.ArrayData keyArray ()  ;
  public abstract  int numElements ()  ;
  public abstract  org.apache.spark.sql.catalyst.util.ArrayData valueArray ()  ;
}
