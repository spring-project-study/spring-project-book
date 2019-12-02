package org.zerock.persistence;

import lombok.Setter;
import lombok.extern.java.Log;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.zerock.config.RootConfig;
import org.zerock.config.WebConfig;
import org.zerock.config.WebInitializer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebInitializer.class, RootConfig.class, WebConfig.class})
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

    @Setter(onMethod_ = {@Autowired})
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void TestMyBatis() {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        Connection con = sqlsession.getConnection();

        System.out.println(sqlsession);
        System.out.println(con);
    }
}
