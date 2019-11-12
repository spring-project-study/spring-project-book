package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.zerock.config.RootConfig;
import org.zerock.config.WebConfig;
import org.zerock.config.WebInitializer;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
//@Log4j
@ContextConfiguration(classes = {WebConfig.class, WebInitializer.class, RootConfig.class})
public class SampleTests {
    @Setter(onMethod_ = {@Autowired})
    private Restaurant restaurant;

    @Test
    public void testExist() {
        assertNotNull(restaurant);


    }
}
