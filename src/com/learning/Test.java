package com.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //jdbc:postgresql://20.26.83.147:5432/crm_a?targetServerType=master&binaryTransfer=False&forceBinary=False&grammar=oracle
        String url = "jdbc:postgresql://20.26.83.147:5432/crm_a?targetServerType=master&binaryTransfer=False&forceBinary=False&grammar=oracle";
        Connection conn = DriverManager.getConnection(url, "sqlcheck_test", "sqlcheck_test");
        System.out.println(conn);

        Statement statement = conn.createStatement();
        statement.execute("create table org_firm_rel_1\n" +
                "(\n" +
                "     ORGANIZE_ID NUMBER(12)   not null ,\n" +
                "     FIRM_ID NUMBER(12)   ,\n" +
                "     RELATION VARCHAR2(5)   ,\n" +
                "     state VARCHAR2(5),\n" +
                "     TRANS_ORDER_ID NUMBER(12)   ,\n" +
                "     CRATE_DATE DATE   ,\n" +
                "     DONE_DATE DATE  ,\n" +
                "      OP_ID NUMBER(12)   ,\n" +
                "     ORG_ID NUMBER(12)   ,\n" +
                "     EXT1 VARCHAR2(2000)   ,\n" +
                "     EXT2 VARCHAR2(2000)   ,\n" +
                "     REMARK VARCHAR2(2000) \n" +
                ")\n" );
   }
}
