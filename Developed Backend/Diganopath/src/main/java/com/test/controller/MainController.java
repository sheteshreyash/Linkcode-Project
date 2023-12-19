package com.test.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.entity.Profile;
import com.test.entity.User;
import com.test.entity.tests;
import com.test.repository.TestsRepository;
import com.test.repository.UserRepository;

@Controller
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TestsRepository testsRepository;


	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/")
	public String home()
	{
		return "User_Dashboard";
	}
	@RequestMapping("/User_Dashboard")
	public String User_Dashboard(Model model,Principal principal)
	{
		return "User_Dashboard";
	}
	@GetMapping("/Add_Profile_Form")
	public String AddContactForm(Model model)
	{
		model.addAttribute("profile", new Profile());
		return "Add_Profile_Form";
	}
	
	//Processing Add contact form

	@PostMapping("/process-Profile")
	public String processProfile(@ModelAttribute Profile profile,Principal principal)
	{
		String name = principal.getName(); 
		User user=this.userRepository.findByUsername(name);
		user.getProfile().add(profile);
		this.userRepository.save(user);
		System.out.println("DATA"+profile);
		System.out.println("Sucessfully Added To Database!!");
		return "Add_Profile_Form";
	}

	@GetMapping("/View_Profile")
	public String viewProfile(Model model)
	{
		model.addAttribute("title", "view Profile");
		return "View_Profile";
	}

	@GetMapping("/Test")
	public String Test(Model model)
	{
		model.addAttribute("title", "view Test");
		
		return "Test";
	}

	@GetMapping("/CT_Scan")
	public String CT_Scan(Model model)
	{
		model.addAttribute("title", "CT_Scan");
		return "CT_Scan";
	}
	
	@GetMapping("/Book_Test")
	public String Book_Test(Model model)
	{
		model.addAttribute("title", "Book_Test");
		List<tests> allRecords = this.testsRepository.findAll();
		model.addAttribute("Test_list", allRecords);
		return "Book_Test";
	}

	@GetMapping("/Download_Report")
	public String DownloadReport(Model model)
	{
		model.addAttribute("title", "Download_Report");
		return "Download_Report";
	}


	@GetMapping("/Logout")
	public String Logout()
	{
		return "redirect:/login";
	}
}
