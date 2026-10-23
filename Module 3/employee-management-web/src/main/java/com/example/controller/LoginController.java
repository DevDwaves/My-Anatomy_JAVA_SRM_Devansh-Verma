package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.security.JwtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController 
{
    private final JwtService jwtService;

    public LoginController(JwtService jwtService) 
    {
        this.jwtService = jwtService;
    }

    @GetMapping("/")
    public String home() 
    {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() 
    {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) 
    {
        String role = null;

        if (username.equals("hr") && password.equals("1234")) 
        {
            role = "HR";
        } 
        else if (
                username.equals("manager")
                && password.equals("1234")) 
        {
            role = "MANAGER";
        } 
        else if (
                username.equals("employee")
                && password.equals("1234")) 
        {
            role = "EMPLOYEE";
        }

        if (role == null) 
        {
            model.addAttribute(
                    "error",
                    "Invalid username or password"
            );
            return "login";
        }

        String token =
                jwtService.generateToken(
                        username,
                        role
                );

        session.setAttribute(
                "jwtToken",
                token
        );

        session.setAttribute(
                "username",
                username
        );

        session.setAttribute(
                "role",
                role
        );
        return "redirect:/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) 
    {
        session.invalidate();
        return "redirect:/login";
    }
}
