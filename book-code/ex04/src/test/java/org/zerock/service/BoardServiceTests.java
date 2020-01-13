package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "file:web/WEB-INF/root-context.xml")
public class BoardServiceTests {

    @Autowired
    private BoardService service;

    @Test
    public void testExist(){
        assertNotNull(service);

    }

    @Test
    public void textRegister(){
        BoardVO board = new BoardVO();
        board.setTitle("테스트 타이틀");
        board.setWriter("admin");
        board.setContent("test 내용");

        service.register(board);
    }

    @Test
    public void testGetList(){

//        service.getList().forEach(board -> System.out.println(board));
        service.getList(new Criteria(2,10)).forEach(board -> System.out.println(board));
    }

    @Test
    public void testGet() {
        System.out.println(service.get(5L));
    }

    @Test
    public void testDelte() {
        System.out.println(service.remove(30L));
    }

    @Test
    public void testUpdate() {
        BoardVO board = service.get(1L);
        board.setContent("UPDATE Test");
        board.setWriter("DI");
        board.setTitle("UPDATE Title");

        System.out.println(service.modify(board));

    }
}
