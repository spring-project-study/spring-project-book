package org.zerock.service;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import java.util.List;

public interface ReplyService {

    public int register(ReplyVO replyVO);
    public ReplyVO get(Long rno);
    public int modify(ReplyVO replyVO);
    public int remove(Long rno);
    public List<ReplyVO> getList(Criteria cri, Long bno);

}
