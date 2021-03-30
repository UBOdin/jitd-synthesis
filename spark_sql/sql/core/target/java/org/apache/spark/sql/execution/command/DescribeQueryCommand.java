package org.apache.spark.sql.execution.command;
/**
 * Command that looks like
 * <pre><code>
 *   DESCRIBE [QUERY] statement
 * </code></pre>
 * <p>
 * Parameter 'statement' can be one of the following types :
 * 1. SELECT statements
 * 2. SELECT statements inside set operators (UNION, INTERSECT etc)
 * 3. VALUES statement.
 * 4. TABLE statement. Example : TABLE table_name
 * 5. statements of the form 'FROM table SELECT *'
 * 6. Multi select statements of the following form:
 *    select * from (from a select * select *)
 * 7. Common table expressions (CTEs)
 */
public  class DescribeQueryCommand extends org.apache.spark.sql.execution.command.DescribeCommandBase implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String queryText ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan ()  { throw new RuntimeException(); }
  // not preceding
  public   DescribeQueryCommand (java.lang.String queryText, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> output ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
