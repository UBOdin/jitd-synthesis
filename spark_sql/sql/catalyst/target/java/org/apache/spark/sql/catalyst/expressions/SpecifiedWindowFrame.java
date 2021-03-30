package org.apache.spark.sql.catalyst.expressions;
/**
 * A specified Window Frame. The val lower/upper can be either a foldable {@link Expression} or a
 * {@link SpecialFrameBoundary}.
 */
public  class SpecifiedWindowFrame extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.WindowFrame, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.FrameType frameType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression lower ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression upper ()  { throw new RuntimeException(); }
  // not preceding
  public   SpecifiedWindowFrame (org.apache.spark.sql.catalyst.expressions.FrameType frameType, org.apache.spark.sql.catalyst.expressions.Expression lower, org.apache.spark.sql.catalyst.expressions.Expression upper)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> valueBoundary ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  public  boolean isUnbounded ()  { throw new RuntimeException(); }
  public  boolean isValueBound ()  { throw new RuntimeException(); }
  public  boolean isOffset ()  { throw new RuntimeException(); }
}
