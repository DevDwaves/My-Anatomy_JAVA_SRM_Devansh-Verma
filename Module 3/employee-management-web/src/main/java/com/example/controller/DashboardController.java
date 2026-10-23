package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController 
{
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) 
    {
        model.addAttribute(
                "username",
                session.getAttribute("username")
        );

        model.addAttribute(
                "role",
                session.getAttribute("role")
        );

        return "dashboard";
    }
}
