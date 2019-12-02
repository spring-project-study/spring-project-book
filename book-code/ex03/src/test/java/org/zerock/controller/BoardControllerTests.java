package org.zerock.controller;

import lombok.Setter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
        "file:web/WEB-INF/root-context.xml",
        "file:web/WEB-INF/servlet-context.xml"
})
public class BoardControllerTests {

    @Setter(onMethod_ = {@Autowired})
    private WebApplicationContext ctx;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception {
        System.out.println(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                        .andReturn()
                        .getModelAndView()
                        .getModel()
        );
    }

    @Test
    public void testRegister() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title", "테스트 글 작성222")
                .param("content", "테스트 내용111")
                .param("writer", "admin333"))
                .andReturn()
                .getModelAndView()
                .getViewName();

        System.out.println(resultPage);
    }

    @Test
    public void testGet() throws Exception {
        System.out.println(
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/board/get")
                        .param("bno", "2"))
                        .andReturn()
                        .getModelAndView()
                        .getModelMap()
        );
    }

    @Test
    public void testModify() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                .param("bno", "1")
                .param("title", "테스트 코드 테스트")
                .param("content", "게시판고고")
                .param("writer", "writerer"))
                .andReturn()
                .getModelAndView().getViewName();
        System.out.println(resultPage);
    }

    @Test
    public void testRemove() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
                .param("bno", "10")
        ).andReturn().getModelAndView().getViewName();

        System.out.println(resultPage);
    }
}
