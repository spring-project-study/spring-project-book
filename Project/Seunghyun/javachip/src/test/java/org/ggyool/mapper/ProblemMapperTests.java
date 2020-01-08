package org.ggyool.mapper;

import org.ggyool.domain.ProblemVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.ggyool.config.RootConfig.class} )
@Log4j
public class ProblemMapperTests {
	
	@Autowired
	private ProblemMapper mapper;
	
	//@Test
	public void insertTest() {
		ProblemVO vo = new ProblemVO();
		vo.setUser_id("ggyool2");
		vo.setUser_name("가나다라마바사");
		vo.setProblem_title("테스트 문제1 제목");
		vo.setProblem_content("테스트 문제1 내용");
		vo.setProblem_type('s');
		mapper.insert(vo);
	}
	
	//@Test
	public void readTest() {
		log.info(mapper.read(1));
	}
	
	//@Test
	public void updateTest() {
		ProblemVO vo = new ProblemVO();
		vo.setProblem_id(1);
		vo.setUser_id("ggyool2");
		vo.setUser_name("가나다라마바사");
		vo.setProblem_title("테스트 문제1 제목 수정");
		vo.setProblem_content("테스트 문제1 내용 수정");
		vo.setProblem_type('s');
		mapper.update(vo);
	}
	
	//@Test
	public void deleteTest() {
		mapper.delete(1);
	}
}
