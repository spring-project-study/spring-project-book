package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import java.util.List;

public interface ReplyMapper {

    public int insert(ReplyVO replyVO);

    public ReplyVO read(Long rno);

    public int delete(Long rno);

    public int update(ReplyVO vo);

    public List<ReplyVO> getListWithPaging(
            @Param("cri") Criteria criteria,
            @Param("bno") Long bno);
}
