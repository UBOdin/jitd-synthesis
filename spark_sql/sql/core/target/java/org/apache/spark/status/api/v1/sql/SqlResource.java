package org.apache.spark.status.api.v1.sql;
  class SqlResource implements org.apache.spark.status.api.v1.BaseAppResource {
  public   SqlResource ()  { throw new RuntimeException(); }
  public  java.lang.String WHOLE_STAGE_CODEGEN ()  { throw new RuntimeException(); }
  protected  java.lang.String appId ()  { throw new RuntimeException(); }
  protected  java.lang.String attemptId ()  { throw new RuntimeException(); }
  protected  javax.servlet.http.HttpServletRequest httpRequest ()  { throw new RuntimeException(); }
  protected  javax.servlet.ServletContext servletContext ()  { throw new RuntimeException(); }
  public  org.apache.spark.status.api.v1.sql.ExecutionData sql (long execId, boolean details, boolean planDescription)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.status.api.v1.sql.ExecutionData> sqlList (boolean details, boolean planDescription, int offset, int length)  { throw new RuntimeException(); }
}
