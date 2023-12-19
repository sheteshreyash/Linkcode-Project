package com.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dto.UserRegisterDto;
import com.test.service.EmailService;
import com.test.service.UserService;

@Controller
@RequestMapping("/register")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;
	
	@GetMapping
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("user", new UserRegisterDto());
		return "register";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegisterDto user)
	{
		userService.save(user);
		String email = user.getEmail();

		String subject="Pathocare : Registration Successful";
		String message=""
				+ "<div style='border:1px solid #e2e2e2; padding:20px'>"
				+ "<h2>"
				+ "Dear "+user.getName()+"</h2>"+"<br>"+"<h1>"
				+ "<b>" +" Congratulations! You have successfully registered on the Pathocare Portal "
				+ "</n>"
				+ "</h1> "
				+ "</div>";
		String to=email;


		boolean flag = this.emailService.sendEmail(subject, message, to);
		return "redirect:/register?success";
	}
	
}
