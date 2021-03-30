package org.apache.spark.sql.catalyst.expressions;
/**
 * A Set designed to hold {@link AttributeReference} objects, that performs equality checking using
 * expression id instead of standard java equality.  Using expression id means that these
 * sets will correctly test for membership, even when the AttributeReferences in question differ
 * cosmetically (e.g., the names have different capitalizations).
 * <p>
 * Note that we do not override equality for Attribute references as it is really weird when
 * <code>AttributeReference("a"...) == AttributeReference("b", ...)</code>. This tactic leads to broken tests,
 * and also makes doing transformations hard (we always try keep older trees instead of new ones
 * when the transformation was a no-op).
 */
public  class AttributeSet implements scala.collection.Iterable<org.apache.spark.sql.catalyst.expressions.Attribute>, scala.Serializable {
  /** Returns an empty {@link AttributeSet}. */
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet empty ()  { throw new RuntimeException(); }
  /** Constructs a new {@link AttributeSet} that contains a single {@link Attribute}. */
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet apply (org.apache.spark.sql.catalyst.expressions.Attribute a)  { throw new RuntimeException(); }
  /** Constructs a new {@link AttributeSet} given a sequence of {@link Expression Expressions}. */
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet apply (scala.collection.Iterable<org.apache.spark.sql.catalyst.expressions.Expression> baseSet)  { throw new RuntimeException(); }
  /** Constructs a new {@link AttributeSet} given a sequence of {@link AttributeSet}s. */
  static public  org.apache.spark.sql.catalyst.expressions.AttributeSet fromAttributeSets (scala.collection.Iterable<org.apache.spark.sql.catalyst.expressions.AttributeSet> sets)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  /** Returns true if the members of this AttributeSet and other are the same. */
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  /** Returns true if this set contains an Attribute with the same expression id as `elem` */
  public  boolean contains (org.apache.spark.sql.catalyst.expressions.NamedExpression elem)  { throw new RuntimeException(); }
  /** Returns an iterator containing all of the attributes in the set. */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.Attribute> iterator ()  { throw new RuntimeException(); }
  /**
   * Returns true if the {@link Attribute Attributes} in this set are a subset of the Attributes in
   * <code>other</code>.
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  boolean subsetOf (org.apache.spark.sql.catalyst.expressions.AttributeSet other)  { throw new RuntimeException(); }
  /**
   * Returns a new {@link AttributeSet} contain only the {@link Attribute Attributes} where <code>f</code> evaluates to
   * true.
   * @param f (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet filter (scala.Function1<org.apache.spark.sql.catalyst.expressions.Attribute, java.lang.Object> f)  { throw new RuntimeException(); }
  /**
   * Returns a new {@link AttributeSet} that only contains {@link Attribute Attributes} that are found in
   * <code>this</code> and <code>other</code>.
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet intersect (org.apache.spark.sql.catalyst.expressions.AttributeSet other)  { throw new RuntimeException(); }
  public <U extends java.lang.Object> void foreach (scala.Function1<org.apache.spark.sql.catalyst.expressions.Attribute, U> f)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> toSeq ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean isEmpty ()  { throw new RuntimeException(); }
}
