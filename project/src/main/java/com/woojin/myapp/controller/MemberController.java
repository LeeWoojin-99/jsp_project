package com.woojin.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.woojin.myapp.domain.MemberVO;
import com.woojin.myapp.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@Inject
	private MemberService msv;
	
	int isOK;

	@GetMapping("register")
	public void registerGet() {}

	@PostMapping("register")
	public String registerPost(MemberVO mvo, RedirectAttributes reAttr) {
		MemberVO registerMember = msv.selectOne(mvo); // id가 일치하는 member의 정보를 추출
		if(registerMember != null) { // 이미 존재하는 id
			reAttr.addFlashAttribute("msg_member_register", 0);
			return "redirect:/main";
		}
		isOK = msv.insert(mvo);
		log.info("isOK : "+(isOK>0?"성공":"실패"));
		if(isOK > 0) reAttr.addFlashAttribute("msg_member_register", 1);
		return "redirect:/main";
	}
	
	@GetMapping("login")
	public void loginGet() {}
	
	@PostMapping("login")
	public String loginPost(MemberVO mvo, RedirectAttributes reAttr, HttpServletRequest request) {
		MemberVO loginMember = msv.selectOne(mvo); // id가 일치하는 member의 정보를 추출
		if(loginMember == null) { // 존재하지 않는 아이디
			reAttr.addFlashAttribute("msg_login", 0);
			return "redirect:/main";
		}else if(!mvo.getPw().equals(loginMember.getPw())) { // 비밀번호 불일치
			reAttr.addFlashAttribute("msg_login", 1);
			return "redirect:/main";
		}
		reAttr.addFlashAttribute("msg_login", 2);
		request.getSession().setAttribute("session", loginMember);
		return "redirect:/main";
	}
	
}
