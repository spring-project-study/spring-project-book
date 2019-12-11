package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@RequestMapping("")
	public void basic() {
		log.info("basic.....");
	}
	
	@GetMapping("/getDto")
	public String getDto(SampleDTO dto) {
		log.info("getDto run");
		log.info(dto);
		return "getDto";
	}
	
	@GetMapping("/getNameAge")
	public String getNameAge(@RequestParam("name") String n, @RequestParam("age" ) int a) {
		log.info("getNameAge run");
		log.info("name: " + n);
		log.info("age: " + a);
		return "getNameAge";
	}
	
	@GetMapping("/getNameAge/test")
	public String getNameAgeTest(@RequestParam("name") String n, @RequestParam("age" ) int a) {
		log.info("test");
		return "getNameAgeTest";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto:" + dto);
		log.info("page: " + page);
		return "ex04";
	}
	
	@GetMapping("/ex042")
	public String ex042(SampleDTO dto, @ModelAttribute("mage") int mage) {
		log.info("dto:" + dto);
		log.info("mage: " + mage);
		return "ex042";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("honggildong");
		return dto;
	}
}
