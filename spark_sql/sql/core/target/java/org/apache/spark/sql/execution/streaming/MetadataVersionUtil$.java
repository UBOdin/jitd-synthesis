package org.apache.spark.sql.execution.streaming;
public  class MetadataVersionUtil$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final MetadataVersionUtil$ MODULE$ = null;
  public   MetadataVersionUtil$ ()  { throw new RuntimeException(); }
  /**
   * Parse the log version from the given <code>text</code> -- will throw exception when the parsed version
   * exceeds <code>maxSupportedVersion</code>, or when <code>text</code> is malformed (such as "xyz", "v", "v-1",
   * "v123xyz" etc.)
   * @param text (undocumented)
   * @param maxSupportedVersion (undocumented)
   * @return (undocumented)
   */
  public  int validateVersion (java.lang.String text, int maxSupportedVersion)  { throw new RuntimeException(); }
}
