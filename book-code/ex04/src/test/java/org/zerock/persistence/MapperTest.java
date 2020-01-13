package org.zerock.persistence;


import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "file:web/WEB-INF/root-context.xml")
@Log4j
public class MapperTest {
    @Setter(onMethod_ = @Autowired)
    private BoardMapper boardMapper;

    @Test
    public void testGetList(){
        boardMapper.getList().forEach(board -> System.out.println(board));
    }

    @Test
    public void testInsert() {
        BoardVO board = new BoardVO();
        board.setTitle("글 작성 매퍼 테스트");
        board.setContent("테스트 컨텐츠");
        board.setWriter("admin");
        boardMapper.insert(board);

    }

    @Test
    public void testInsertSelectKey(){
        BoardVO board = new BoardVO();
        board.setTitle("글 작성 테스트");
        board.setContent("select Key");
        board.setWriter("admin");
        boardMapper.insertSelectKey(board);
        System.out.println(board);
    }

    @Test
    public void testRead() {
        BoardVO board = boardMapper.read(5L);
        System.out.println(board);
    }

    @Test
    public void testDelete() {
        System.out.println("delete : " +boardMapper.delete(27L));
    }

    @Test
    public void testUpdate() {
        BoardVO board = new BoardVO();

        board.setBno(5L);
        board.setContent("update");
        board.setTitle("update");
        board.setWriter("admin2");

        int count = boardMapper.update(board);
        System.out.println(count);
    }

    @Test
    public void testGetListWithPage(){
        Criteria cri = new Criteria();
        cri.setPageNum(5);
        List<BoardVO> list = boardMapper.getListWithPaging(cri);

        list.forEach(board -> System.out.println(board));

    }

    @Test
    public void testSearch() {
        Criteria cri = new Criteria();
        cri.setKeyword("새로");
        cri.setType("TC");

        List<BoardVO> list = boardMapper.getListWithPaging(cri);

        list.forEach(board -> System.out.println(board));
    }
}
