package org.zerock.sample;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import org.springframework.test.context.web.WebAppConfiguration;
import org.zerock.config.RootConfig;
import org.zerock.config.WebConfig;
import org.zerock.config.WebInitializer;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebInitializer.class, RootConfig.class, WebConfig.class})
public class SampleTests {

    @Setter(onMethod_ = {@Autowired})
    private Restaurant restaurant;

    @Test
    public void testExist() {
        assertNotNull(restaurant);

    }
}

