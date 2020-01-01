package org.ggyool.mapper;

import org.ggyool.domain.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@Log4j
public class MemberMapperTests {
	@Autowired
	private MemberMapper mapper;
	
	//@Test
	public void testRead() {
		MemberVO vo = mapper.read("admin90");
		log.info(vo);
		vo.getAuthList().forEach(authVO ->log.info(authVO));
	}
}
