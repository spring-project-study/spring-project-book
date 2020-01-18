package org.javachip.mapper;

import org.javachip.domain.ProblemVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.javachip.config.RootConfig.class} )
@Log4j	
public class ProblemMapperTests {
	
	@Autowired
	ProblemMapper mapper;
	
	//@Test
	public void insertTest() {
		ProblemVO vo = new ProblemVO();
		vo.setProblem_title("영어단어퀴즈!");
		vo.setProblem_content("봄은 영어로 무엇일까요?");
		vo.setUser_id("user00");
		vo.setUser_name("유저00");
		vo.setProblem_type("m");
		mapper.insert(vo);
	}
	
	//@Test
	public void getTest() {
		System.out.println(mapper.get(1));
	}
}








