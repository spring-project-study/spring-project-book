package org.ggyool.mapper;

import java.util.List;

import org.ggyool.domain.BoardVO;
import org.ggyool.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.ggyool.config.RootConfig.class} )
@Log4j
public class BoardMapperTests {
	@Autowired
	private BoardMapper mapper;
	//@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	//@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}
