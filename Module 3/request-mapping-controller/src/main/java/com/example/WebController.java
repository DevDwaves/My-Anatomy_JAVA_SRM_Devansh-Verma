package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController
{
    @GetMapping("/")    //http://localhost/8080 (www.srm.in)
    public String homePage()
    {
        return "home.html"; //To open home page
    }
    @GetMapping("/login")   //http://localhost/8080/login
    public String loginPage()
    {
        return "login.html";    //To open login page
    }
}