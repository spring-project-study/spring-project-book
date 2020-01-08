package org.ggyool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/problem/*")
public class ProblemController {

	@GetMapping("/all")
	public String showAllProblem() {
		return "/problem/show";
	}
}
