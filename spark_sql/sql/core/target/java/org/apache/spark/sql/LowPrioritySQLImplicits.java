package org.apache.spark.sql;
/**
 * Lower priority implicit methods for converting Scala objects into {@link Dataset}s.
 * Conflicting implicits are placed here to disambiguate resolution.
 * <p>
 * Reasons for including specific implicits:
 * newProductEncoder - to disambiguate for <code>List</code>s which are both <code>Seq</code> and <code>Product</code>
 */
public  interface LowPrioritySQLImplicits {
  /** @since 1.6.0 */
  public <T extends scala.Product> org.apache.spark.sql.Encoder<T> newProductEncoder (scala.reflect.api.TypeTags.TypeTag<T> evidence$9)  ;
}
