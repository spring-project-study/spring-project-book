package org.ggyool.mapper;

import org.ggyool.domain.MultipleChoiceVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.ggyool.config.RootConfig.class} )
@Log4j
public class MultipleChoiceMapperTests {
	
	@Autowired
	MultipleChoiceMapper mapper;
	
	//@Test
	public void insertTest(){
		MultipleChoiceVO vo = new MultipleChoiceVO();
		vo.setProblem_id(1);
		for(int i=1; i<=4; ++i)
		{
			vo.setChoice_content("1번 문제의 보기" + i);
			if(i==3) vo.setChk_answer(true);
			else vo.setChk_answer(false);
			mapper.insert(vo);
		}
	}
	
	//@Test
	public void readTest() {
		log.info(mapper.read(3));
	}
	
	//@Test
	public void updateTest() {
		MultipleChoiceVO vo = new MultipleChoiceVO();
		vo.setProblem_id(1);
		vo.setChoice_id(4);
		vo.setChk_answer(false);
		vo.setChoice_content("1번 문제의 보기4");
		mapper.update(vo);
	}
	
	//@Test
	public void answerListReadTest() {
		log.info(mapper.getAnswerListWithProblem(2));
	}
}
