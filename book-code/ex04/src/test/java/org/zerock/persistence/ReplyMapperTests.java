package org.zerock.persistence;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardBuilder;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "file:web/WEB-INF/root-context.xml")
@Log4j
public class ReplyMapperTests {

    @Setter(onMethod_ = @Autowired)
    private ReplyMapper replyMapper;

    @Test
    public void testManager() {
        log.debug(replyMapper);
    }

    @Test
    public void insert() {
        Long[] bnoArr = {3L,4L,5L,6L,7L};
        IntStream.range(1,10).forEach(i -> {
            ReplyVO replyVO = new ReplyVO();

            replyVO.setBno(bnoArr[i%5]);
            replyVO.setReply(i+ "번째 insert");
            replyVO.setReplyer(i + "replyer");
            replyMapper.insert(replyVO);
        });
    }

    @Test
    public void readTest() {
        long rno = 5L;
        ReplyVO vo =replyMapper.read(rno);
        log.debug(vo);
    }

    @Test
    public void deleteTest() {
        long rno = 5L;
        replyMapper.delete(5L);
    }

    @Test
    public void updateTest() {
        ReplyVO vo = new ReplyVO();

        vo.setRno(6L);
        vo.setReply("테스트");
        replyMapper.update(vo);
    }

    @Test
    public void testList() {
        Criteria cri = new Criteria();
        List<ReplyVO> replies = replyMapper.getListWithPaging(cri,6L);
        replies.forEach(reply -> log.debug(reply));
    }
}
