package com.situ.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.situ.model.User;
import com.situ.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService service;

	@GetMapping("/login")
	public String login() {
		return "login/userlogin";
	}

	@PostMapping("/login")
	public String login(User user, String cap, Map<String, Object> map, HttpServletRequest request) {
		System.out.println(cap);
		//if()
		String yan = (String) request.getSession().getAttribute("captcha");
		
		if(!yan.equals(cap)) {
			map.put("info", "验证码错误");
			return "login/userlogin";
		}
		
		System.out.println(user);
		User checkuser = service.findUser(user);

		if (checkuser == null) {
			map.put("info", "用户账号或密码错误");
			return "login/userlogin";
		}else {
			request.getSession().setAttribute("@@user_login", checkuser);
			return "redirect:/employee/list";
		}
	}

}
