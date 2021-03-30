package org.apache.spark.sql.execution.streaming;
public  class MetadataVersionUtil {
  /**
   * Parse the log version from the given <code>text</code> -- will throw exception when the parsed version
   * exceeds <code>maxSupportedVersion</code>, or when <code>text</code> is malformed (such as "xyz", "v", "v-1",
   * "v123xyz" etc.)
   * @param text (undocumented)
   * @param maxSupportedVersion (undocumented)
   * @return (undocumented)
   */
  static public  int validateVersion (java.lang.String text, int maxSupportedVersion)  { throw new RuntimeException(); }
}
