package org.ggyool.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.ggyool.domain.ListMultipleChoiceVO;
import org.ggyool.domain.ProblemVO;
import org.ggyool.service.MultipleChoiceService;
import org.ggyool.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/problem/*")
public class ProblemController {
	
	@Autowired
	private ProblemService problemService;
	
	@Autowired
	private MultipleChoiceService choiceService;
	
	@GetMapping("/all")
	public String showAllProblem(Model model) {
		model.addAttribute("list", problemService.getList());
		return "/problem/show";
	}
	
	@GetMapping("/register")
	public void registerProblemGet() {
	}
	// 
	@PostMapping("/register")
	public String registerProblemPost(ProblemVO vo, ListMultipleChoiceVO voList) {
		vo.setProblem_type('m');
		problemService.register(vo);
		choiceService.registerList(voList, vo.getProblem_id());
		return "redirect:/problem/all";
	}
	
	@GetMapping("/{pid}")
	public String showSelectedProblem(@PathVariable("pid") Integer pid, Model model){
		model.addAttribute("problem", problemService.get(pid));
		model.addAttribute("choicelist", choiceService.getListWithProblem(pid));
		return "/problem/get";
	}	
	
	@PostMapping("/{pid}")
	public String checkAnswer(@PathVariable("pid") Integer pid, Integer[] userInputArray, RedirectAttributes rttr) {
		ArrayList<Integer> userInputList = new ArrayList<Integer>(Arrays.asList(userInputArray));
		ArrayList<Integer> answerList = choiceService.getAnswerListWithProblem(pid);

		if(userInputList == null || answerList==null) {
			// 제대로 입력하지 않은 경우
			return "redirect:/problem/" + pid;
		}
		Collections.sort(userInputList);
		Collections.sort(answerList);
		
		boolean isAnswer = true;
		if(userInputList.size() == answerList.size()) {
			int len = userInputList.size();
			for(int i=0; i<len; ++i){
				if(userInputList.get(i) != answerList.get(i)) {
					isAnswer = false;
					break;
				}
			}
		}
		else {
			isAnswer = false;
		}		
		rttr.addFlashAttribute("isAnswer", isAnswer);
		return "redirect:/problem/" + pid;
	}
}
