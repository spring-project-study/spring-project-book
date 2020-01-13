package org.ggyool.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.ggyool.config.RootConfig.class} )
@Log4j
public class MemberMapperTests {

	@Autowired
	private MemberMapper mapper;
	
	/*
	public void testRead() {
		System.out.println("here!!!");
		log.info(mapper.read("user"));
	}*/
}
