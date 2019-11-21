package org.zerock.sample;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.zerock.config.RootConfig;
import org.zerock.config.WebConfig;
import org.zerock.config.WebInitializer;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebInitializer.class, RootConfig.class, WebConfig.class})
@WebAppConfiguration
public class HotelTests {
    @Setter(onMethod_ = {@Autowired})
    private SampleHotel sampleHotel;

    @Test
    public void testExist() {
        assertNotNull(sampleHotel);

    }
}
