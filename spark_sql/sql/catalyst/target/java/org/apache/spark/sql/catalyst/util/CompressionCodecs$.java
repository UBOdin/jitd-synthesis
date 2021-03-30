package org.apache.spark.sql.catalyst.util;
public  class CompressionCodecs$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CompressionCodecs$ MODULE$ = null;
  public   CompressionCodecs$ ()  { throw new RuntimeException(); }
  /**
   * Return the full version of the given codec class.
   * If it is already a class name, just return it.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String getCodecClassName (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Set compression configurations to Hadoop <code>Configuration</code>.
   * <code>codec</code> should be a full class path
   * @param conf (undocumented)
   * @param codec (undocumented)
   */
  public  void setCodecConfiguration (org.apache.hadoop.conf.Configuration conf, java.lang.String codec)  { throw new RuntimeException(); }
}
