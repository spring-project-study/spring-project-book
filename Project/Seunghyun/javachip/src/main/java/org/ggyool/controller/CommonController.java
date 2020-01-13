package org.ggyool.controller;

import org.ggyool.domain.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied:" + auth);
		model.addAttribute("msg", "Access Denied");
	}
	
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		
		log.info("error: " + error);
		log.info("logout: " + logout);
		
		if(error!=null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		if(logout!=null) {
			model.addAttribute("logout","Logout!!");
		}
	}
	
	@PostMapping("/login")
	public void loginPost() {
		log.info("!!!!!!!!!!!!!!!!!!");
	}
	
	@GetMapping("/customLogout")
	public void logoutGET(String password){
		log.info("get custom logout");	
	}
	
	@PostMapping("/customLogout")
	public void logoutPost(){
		log.info("post custom logout");	
	}
	
	@GetMapping("/register")
	public void registerGet() {
		
	}
	
	@PostMapping("/register")
	public String regiterPost(MemberVO vo, RedirectAttributes rttr) {
		rttr.addFlashAttribute("vo", vo);
		return "redirect:/member/register";
	}
}
