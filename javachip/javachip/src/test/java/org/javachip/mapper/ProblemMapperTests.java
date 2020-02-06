package org.javachip.mapper;

import java.util.List;

import org.javachip.domain.Criteria;
import org.javachip.domain.ProblemVO;
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

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {org.javachip.config.RootConfig.class,
								org.javachip.config.ServletConfig.class,
								org.javachip.config.WebConfig.class} )
@Log4j	
public class ProblemMapperTests {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	@Autowired
	private ProblemMapper mapper;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	//@Test
	public void getListTest() {
		//log.info(mapper.getList());
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("1");
		
		List<ProblemVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(problem -> log.info(problem));
	}
	
	//@Test
	public void getListWithPagingTest() throws Exception {
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/problem/list")
				.param("pageNum", "2")
				.param("amount",  "5"))
				.andReturn().getModelAndView().getModelMap());
	}
}
