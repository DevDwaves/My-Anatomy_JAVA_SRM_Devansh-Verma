package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Department;
import com.example.service.DepartmentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/departments")
public class DepartmentController 
{
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) 
    {
        this.departmentService = departmentService;
    }

    @GetMapping
    public String departments(Model model, HttpSession session) 
    {
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("role", session.getAttribute("role"));

        return "departments";
    }

    @PostMapping("/save")
    public String save(@RequestParam String name, HttpSession session) 
    {
        String role = (String) session.getAttribute("role");

        if ("HR".equals(role)) 
        {

            departmentService.create(new Department(null, name));
        }

        return "redirect:/departments";
    }
}
