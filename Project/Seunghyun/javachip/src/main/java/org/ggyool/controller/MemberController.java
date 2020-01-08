package org.ggyool.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ggyool.domain.MemberVO;
import org.ggyool.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService service;

	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	@GetMapping("/register")
	public String memberRegsiter(HttpServletRequest request) throws UnsupportedEncodingException {
		//request.setCharacterEncoding("UTF-8");
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		MemberVO vo = (MemberVO) flashMap.get("vo");
		vo.setUser_pw(passEncoder.encode(vo.getUser_pw()));
		service.register(vo);
		System.out.println("here!");
		System.out.println(vo.getUser_id());
		return "redirect:/";
	}
	
	@GetMapping("/info")
	public void memberInfo() {
		
	}
	
	
}
