package org.zerock.mapper;

import org.springframework.stereotype.Component;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import java.util.List;

@Component
public interface BoardMapper {

    //@Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getList();

    public void insert(BoardVO board);

    public void insertSelectKey(BoardVO board);

    public BoardVO read(long bno);

    public int delete(long bno);

    public int update(BoardVO board);

    public List<BoardVO> getListWithPaging(Criteria cri);

    public int getTotalCount(Criteria cri);
}
