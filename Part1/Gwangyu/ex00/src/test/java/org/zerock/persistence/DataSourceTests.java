package org.zerock.persistence;

import lombok.Setter;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
//@Log
public class DataSourceTests {
    @Setter(onMethod_ = {@Autowired})
    private DataSource dataSource;
    @Test
    public void testConnection() {
        try {
            Connection con = dataSource.getConnection();
//            log.info(con.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
