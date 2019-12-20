package org.ggyool.service;

import static org.junit.Assert.assertNotNull;

import org.ggyool.domain.UserVO;
import org.ggyool.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.ggyool.config.RootConfig.class} )
@Log4j
public class UserServiceTests {
	
	@Autowired
	private UserService service;
	
	//@Test
	public void registerTest()
	{
		UserVO vo = new UserVO();
		vo.setUserId("user00");
		vo.setUserPassword("user00");
		service.register(vo);
		
		vo = new UserVO();
		vo.setUserId("user01");
		vo.setUserPassword("user01");
		service.register(vo);
	}
	
	//@Test
	public void removeTest()
	{
		Long uno = 28L;
		service.remove(28L);
	}
	
	@Test
	public void modifyTest()
	{
		UserVO vo = new UserVO();
		vo.setUno(27L);
		vo.setUserId("user00");
		vo.setUserPassword("user00");
		service.modify(vo);
	}
}
