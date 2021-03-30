package org.apache.spark.sql.catalyst.expressions.objects;
public  class SerializerSupport$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SerializerSupport$ MODULE$ = null;
  public   SerializerSupport$ ()  { throw new RuntimeException(); }
  /**
   * It creates a new <code>SerializerInstance</code> which is either a <code>KryoSerializerInstance</code> (is
   * <code>useKryo</code> is set to <code>true</code>) or a <code>JavaSerializerInstance</code>.
   * @param useKryo (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.serializer.SerializerInstance newSerializer (boolean useKryo)  { throw new RuntimeException(); }
}
