package com.test.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.entity.User;
import com.test.repository.TestsRepository;
import com.test.repository.UserRepository;
import com.test.service.EmailService;

@Controller
public class BookTestController {

    @Autowired
	private UserRepository userRepsitory;

    @Autowired
	private EmailService emailService;

    @Autowired
	private TestsRepository testsRepository;



    @RequestMapping("/Book-test/{page}")
    public String Booktest(@PathVariable("page") Integer page,Principal principal)
    {
        String s = "";
        if(page==1)
        {
            s = "10:00 am - 11:00am";
        }
        else if(page==2)
        {
            s = "11:00 am - 12:00pm";
        }
        else if(page==3)
        {
            s = "12:00 pm - 01:00pm";
        }

        String email = principal.getName();
        System.out.println(email);

        User user = this.userRepsitory.getUserByUserName(email);

     

        String subject="Regarding test booking";
		String message=""
				+ "<div style='border:1px solid #e2e2e2; padding:20px'>"
				+ "<h1>"
				+ ""
				+ "<b>"+"Dear "+user.getName()+", Your test is booked at "+s
				+ "</n>"
				+ "</h1> "
				+ "</div>";
		String to=email;

        this.emailService.sendEmail(subject, message, to);
		
       

        return "redirect:/Book_Test?alert=Check email for further update";
    }
    
}
