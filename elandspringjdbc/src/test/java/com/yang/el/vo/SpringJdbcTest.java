package com.yang.el.vo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class SpringJdbcTest {
    private ApplicationContext applicationContext = null;


    @Before
    public void TestInit() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContextfirst.xml");
    }
    @Test
    public void testUpdateForSpringJDBC(){
        DataSource dataSource= (DataSource) applicationContext.getBean("Mydatabase");
        System.out.println("database  "+dataSource);
    }
}
