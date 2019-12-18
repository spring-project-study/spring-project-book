package org.zerock.persistence;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "file:web/WEB-INF/root-context.xml")
@Log4j
public class JDBCTest {

    @Autowired
    HikariDataSource hikariDataSource;

    @Test
    public void connection(){
        try {
            Connection con = hikariDataSource.getConnection();
//            log.debug(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
