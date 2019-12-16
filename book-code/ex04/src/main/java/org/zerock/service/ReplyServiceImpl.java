package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import java.util.List;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService{

    private ReplyMapper mapper;


    @Override
    public int register(ReplyVO replyVO) {
        log.debug(replyVO);
        return mapper.insert(replyVO);
    }

    @Override
    public ReplyVO get(Long rno) {
        log.debug(rno);
        return mapper.read(rno);
    }

    @Override
    public int modify(ReplyVO replyVO) {
        log.debug(replyVO);
        return mapper.update(replyVO);
    }

    @Override
    public int remove(Long rno) {
        log.debug(rno);
        return mapper.delete(rno);
    }

    @Override
    public List<ReplyVO> getList(Criteria cri, Long bno) {
        log.debug(cri);
        log.debug(bno);
        return mapper.getListWithPaging(cri, bno);
    }
}
