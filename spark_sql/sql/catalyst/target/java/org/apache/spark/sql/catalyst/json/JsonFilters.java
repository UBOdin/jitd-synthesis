package org.apache.spark.sql.catalyst.json;
/**
 * The class provides API for applying pushed down source filters to rows with
 * a struct schema parsed from JSON records. The class should be used in this way:
 * 1. Before processing of the next row, <code>JacksonParser</code> (parser for short) resets the internal
 *    state of <code>JsonFilters</code> by calling the <code>reset()</code> method.
 * 2. The parser reads JSON fields one-by-one in streaming fashion. It converts an incoming
 *    field value to the desired type from the schema. After that, it sets the value to an instance
 *    of <code>InternalRow</code> at the position according to the schema. Order of parsed JSON fields can
 *    be different from the order in the schema.
 * 3. Per every JSON field of the top-level JSON object, the parser calls <code>skipRow</code> by passing
 *    an <code>InternalRow</code> in which some of fields can be already set, and the position of the JSON
 *    field according to the schema.
 *    3.1 <code>skipRow</code> finds a group of predicates that refers to this JSON field.
 *    3.2 Per each predicate from the group, <code>skipRow</code> decrements its reference counter.
 *    3.2.1 If predicate reference counter becomes 0, it means that all predicate attributes have
 *          been already set in the internal row, and the predicate can be applied to it. <code>skipRow</code>
 *          invokes the predicate for the row.
 *    3.3 <code>skipRow</code> applies predicates until one of them returns <code>false</code>. In that case, the method
 *        returns <code>true</code> to the parser.
 *    3.4 If all predicates with zero reference counter return <code>true</code>, the final result of
 *        the method is <code>false</code> which tells the parser to not skip the row.
 * 4. If the parser gets <code>true</code> from <code>JsonFilters.skipRow</code>, it must not call the method anymore
 *    for this internal row, and should go the step 1.
 * <p>
 * Besides of <code>StructFilters</code> assumptions, <code>JsonFilters</code> assumes that:
 *   - <code>skipRow()</code> can be called for any valid index of the struct fields,
 *      and in any order.
 *   - After <code>skipRow()</code> returns <code>true</code>, the internal state of <code>JsonFilters</code> can be inconsistent,
 *     so, <code>skipRow()</code> must not be called for the current row anymore without <code>reset()</code>.
 * <p>
 * param:  pushedFilters The pushed down source filters. The filters should refer to
 *                      the fields of the provided schema.
 * param:  schema The required schema of records from datasource files.
 */
public  class JsonFilters extends org.apache.spark.sql.catalyst.StructFilters {
  /**
   * Stateful JSON predicate that keeps track of its dependent references in the
   * current row via <code>refCount</code>.
   * <p>
   * param:  predicate The predicate compiled from pushed down source filters.
   * param:  totalRefs The total amount of all filters references which the predicate
   *                  compiled from.
   */
  public  class JsonPredicate implements scala.Product, scala.Serializable {
    static public abstract  R apply (T1 v1, T2 v2)  ;
    static public  java.lang.String toString ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.expressions.BasePredicate predicate ()  { throw new RuntimeException(); }
    public  int totalRefs ()  { throw new RuntimeException(); }
    // not preceding
    public   JsonPredicate (org.apache.spark.sql.catalyst.expressions.BasePredicate predicate, int totalRefs)  { throw new RuntimeException(); }
    public  int refCount ()  { throw new RuntimeException(); }
    public  void reset ()  { throw new RuntimeException(); }
  }
  public  class JsonPredicate$ extends scala.runtime.AbstractFunction2<org.apache.spark.sql.catalyst.expressions.BasePredicate, java.lang.Object, org.apache.spark.sql.catalyst.json.JsonFilters.JsonPredicate> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final JsonPredicate$ MODULE$ = null;
    public   JsonPredicate$ ()  { throw new RuntimeException(); }
  }
  public   JsonFilters (scala.collection.Seq<org.apache.spark.sql.sources.Filter> pushedFilters, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Reset states of all predicates by re-initializing reference counters.
   */
  public  void reset ()  { throw new RuntimeException(); }
  /**
   * Applies predicates (compiled filters) associated with the row field value
   * at the position <code>index</code> only if other predicates dependencies are already
   * set in the given row.
   * <p>
   * Note: If the function returns <code>true</code>, <code>refCount</code> of some predicates can be not decremented.
   * <p>
   * @param row The row with fully or partially set values.
   * @param index The index of already set value.
   * @return <code>true</code> if at least one of applicable predicates (all dependent row values are set)
   *         return <code>false</code>. It returns <code>false</code> if all predicates return <code>true</code>.
   */
  public  boolean skipRow (org.apache.spark.sql.catalyst.InternalRow row, int index)  { throw new RuntimeException(); }
}
