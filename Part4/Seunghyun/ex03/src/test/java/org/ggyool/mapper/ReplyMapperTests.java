package org.ggyool.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.ggyool.domain.Criteria;
import org.ggyool.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.ggyool.config.RootConfig.class} )
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr = {1212530L, 1212529L, 1212522L, 1212510L, 1212523L};
	@Autowired
	private ReplyMapper mapper;
	
	//@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	//@Test
	public void testCreate() {
		IntStream.rangeClosed(1,10).forEach(i->{
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[i%5]);
			vo.setReply("´ñ±Û Å×½ºÆ® " + i);
			vo.setReplyer("replyer"+i);
			mapper.insert(vo);
		});
	}
	
	//@Test
	public void testRead() {
		Long targetRno = 5L;
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
	}
	
	//@Test
	public void testDelete() {
		Long targetRno = 2L;
		mapper.delete(targetRno);
	}
	
	//@Test
	public void testUpdate() {
		Long targetRno = 5L;
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("Update Reply");
		int count = mapper.update(vo);
		log.info("UPDATE COUNT: " + count);
	}
	
	//@Test
	public void testList() {
		Criteria cri = new Criteria();
		//1212530L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		replies.forEach(reply->log.info(reply));
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2,2);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		replies.forEach(reply->log.info(reply));
	}
}
