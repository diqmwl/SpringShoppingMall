package kr.ac.hansung.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Product;
import kr.ac.hansung.model.User;
import kr.ac.hansung.service.ProductService;
import kr.ac.hansung.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String showLogin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "timeout", required = false) String timeout, Model model) {
		if (error != null) {
			model.addAttribute("errorMsg", "Invalid username and password");
		} 
		if (timeout != null) {
			model.addAttribute("timeout", "자동 로그아웃되었습니다.");
		}
		if (logout != null) {
			model.addAttribute("logoutMsg", "You have been logged out successfully");
		}
		return "login";
	}
	
	@RequestMapping("/main/register")
	public String showLogin(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping("/main/docreate")
	public String doCreate(Model model, @Valid User user, BindingResult result,  Principal principal) {
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "subject";
		}
		userService.insert(user);
		return "home";

	}
}
