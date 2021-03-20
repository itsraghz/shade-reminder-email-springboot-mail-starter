package com.example.emailapp.web;

import com.example.emailapp.bo.EmailAPIBO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/email/")
public class EmailController {

    //@RequestMapping(value="/", method = RequestMethod.GET, produces = "text/html")
    @GetMapping
    public String welcome(Model model) {
        System.out.println("welcome() method invoked...");
        System.out.println("Model Object given by Spring :: " + model);
        model.addAttribute("message", "Welcome to the SpringBoot Email Project - at [" + new Date() + "]");

        List<EmailAPIBO> emailAPIBOList = new ArrayList<>();
        emailAPIBOList.add(new EmailAPIBO("/email/sendEmail", "Simple Test Email", "First and Test Email"));

        model.addAttribute("emailAPIBOList", emailAPIBOList);
        System.out.println("Model Object after updated by EmailController :: " + model);
        return "welcome";
    }
}
