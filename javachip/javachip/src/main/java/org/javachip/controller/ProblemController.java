package org.javachip.controller;

import org.javachip.domain.Criteria;
import org.javachip.domain.PageDTO;
import org.javachip.service.ProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/problem/*")
@AllArgsConstructor
public class ProblemController {
	
	private ProblemService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		model.addAttribute("list", service.getListWithPaging(cri));
		int total = service.getTotal(cri);
		log.info(cri);
		log.info("total:" + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
}
