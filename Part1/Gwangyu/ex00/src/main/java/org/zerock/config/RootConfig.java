package org.zerock.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = {"org.zerock.sample"})
@MapperScan(basePackages = {"org.zerock.mapper"})
public class RootConfig {

//    private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
//    private static String URL = "jdbc:oracle:thin:@localhost:35791:XE";
    private static String DRIVER = "net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
    private static String URL = "jdbc:log4jdbc:oracle:thin:@localhost:35791:XE";
    private static String USER_ID = "book_ex";
    private static String PASSWORD = "book_ex";

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(DRIVER);
        hikariConfig.setJdbcUrl(URL);
        hikariConfig.setUsername(USER_ID);
        hikariConfig.setPassword(PASSWORD);
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        return hikariDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
    }
}
