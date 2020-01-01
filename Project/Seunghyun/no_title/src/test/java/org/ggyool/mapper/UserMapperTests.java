package org.ggyool.mapper;

import org.ggyool.domain.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.ggyool.config.RootConfig.class} )
@Log4j
public class UserMapperTests {
	
	@Autowired
	private UserMapper mapper;
	
	//@Test
	public void testCreateTable()
	{
		log.info("current test");
		//mapper.createTable("bangeum");
		//UserVO vo = new UserVO();
		//vo.setUserId("user01");
		//vo.setUserPassword("user01");
		//mapper.insert(vo);
		//mapper.read(2L);
	}
	
}
