package org.zerock.persistence;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTests {
    static {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:35791:XE",
                    "book_ex",
                    "book_ex");
            System.out.println("connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
