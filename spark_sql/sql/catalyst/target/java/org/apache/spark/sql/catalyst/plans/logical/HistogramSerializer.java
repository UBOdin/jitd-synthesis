package org.apache.spark.sql.catalyst.plans.logical;
public  class HistogramSerializer {
  /**
   * Serializes a given histogram to a string. For advanced statistics like histograms, sketches,
   * etc, we don't provide readability for their serialized formats in metastore
   * (string-to-string table properties). This is because it's hard or unnatural for these
   * statistics to be human readable. For example, a histogram usually cannot fit in a single,
   * self-described property. And for count-min-sketch, it's essentially unnatural to make it
   * a readable string.
   * @param histogram (undocumented)
   * @return (undocumented)
   */
  static public final  java.lang.String serialize (org.apache.spark.sql.catalyst.plans.logical.Histogram histogram)  { throw new RuntimeException(); }
  /** Deserializes a given string to a histogram. */
  static public final  org.apache.spark.sql.catalyst.plans.logical.Histogram deserialize (java.lang.String str)  { throw new RuntimeException(); }
}
