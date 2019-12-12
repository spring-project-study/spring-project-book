package org.ggyool.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.ggyool.config.RootConfig.class})
@Log4j
public class BoardServiceTests {
	@Autowired
	private BoardService service;
	
	//@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
}
