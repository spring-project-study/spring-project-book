package org.zerock.persistence;

import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.zerock.config.RootConfig;
import org.zerock.config.WebConfig;
import org.zerock.config.WebInitializer;
import org.zerock.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebInitializer.class, RootConfig.class, WebConfig.class})
@WebAppConfiguration
public class TimeMapperTests {

    @Setter(onMethod_ = @Autowired)
    private TimeMapper timeMapper;

    @Test
    public void testGetTime(){
        System.out.println(timeMapper.getClass().getName());
        System.out.println(timeMapper.getTime());
    }

    @Test
    public void testGetTime2(){
        System.out.println(timeMapper.getTime2());
    }

    @Test
    public void testGetTime3(){
        System.out.println(timeMapper.getTime3());
    }


}