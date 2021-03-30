package org.apache.spark.sql.catalyst.plans.logical;
/**
 * ALTER TABLE ... CHANGE COLUMN command, as parsed from SQL.
 */
public  class AlterTableAlterColumnStatement extends org.apache.spark.sql.catalyst.plans.logical.ParsedStatement implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> tableName ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> column ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.DataType> dataType ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> nullable ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> comment ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.connector.catalog.TableChange.ColumnPosition> position ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableAlterColumnStatement (scala.collection.Seq<java.lang.String> tableName, scala.collection.Seq<java.lang.String> column, scala.Option<org.apache.spark.sql.types.DataType> dataType, scala.Option<java.lang.Object> nullable, scala.Option<java.lang.String> comment, scala.Option<org.apache.spark.sql.connector.catalog.TableChange.ColumnPosition> position)  { throw new RuntimeException(); }
}
