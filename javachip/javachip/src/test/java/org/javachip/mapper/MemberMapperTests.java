package org.javachip.mapper;

import org.javachip.domain.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.javachip.config.RootConfig.class} )
@Log4j	
public class MemberMapperTests {
	@Autowired
	private MemberMapper mapper;
	//@Test
	public void insertTest() {
		MemberVO vo = new MemberVO();
		vo.setUser_id("user01");
		vo.setUser_pw("user01");
		vo.setUser_name("����01");
		mapper.insert(vo);
	}
	
	
	
	//@Test
	public void getListTest() {
		log.info(mapper.getList());
	}
}
