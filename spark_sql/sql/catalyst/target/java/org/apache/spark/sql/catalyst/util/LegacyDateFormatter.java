package org.apache.spark.sql.catalyst.util;
public  interface LegacyDateFormatter extends org.apache.spark.sql.catalyst.util.DateFormatter {
  public  java.lang.String format (int days)  ;
  public  java.lang.String format (java.time.LocalDate localDate)  ;
  public  int parse (java.lang.String s)  ;
  public  java.util.Date parseToDate (java.lang.String s)  ;
}
