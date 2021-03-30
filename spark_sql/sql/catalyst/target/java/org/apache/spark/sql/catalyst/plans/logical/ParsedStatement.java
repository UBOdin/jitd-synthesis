package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A logical plan node that contains exactly what was parsed from SQL.
 * <p>
 * This is used to hold information parsed from SQL when there are multiple implementations of a
 * query or command. For example, CREATE TABLE may be implemented by different nodes for v1 and v2.
 * Instead of parsing directly to a v1 CreateTable that keeps metadata in CatalogTable, and then
 * converting that v1 metadata to the v2 equivalent, the sql {@link CreateTableStatement} plan is
 * produced by the parser and converted once into both implementations.
 * <p>
 * Parsed logical plans are not resolved because they must be converted to concrete logical plans.
 * <p>
 * Parsed logical plans are located in Catalyst so that as much SQL parsing logic as possible is be
 * kept in a {@link org.apache.spark.sql.catalyst.parser.AbstractSqlParser}.
 */
public abstract class ParsedStatement extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan {
  public   ParsedStatement ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  // not preceding
  public final  boolean resolved ()  { throw new RuntimeException(); }
}
