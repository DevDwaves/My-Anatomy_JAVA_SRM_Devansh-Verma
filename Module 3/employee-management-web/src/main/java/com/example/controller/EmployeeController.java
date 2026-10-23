package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Department;
import com.example.model.Employee;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employees")
public class EmployeeController 
{
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    public EmployeeController(
            EmployeeService employeeService,
            DepartmentService departmentService) 
    {

        this.employeeService = employeeService;

        this.departmentService =
                departmentService;
    }

    @GetMapping
    public String employees(@RequestParam(defaultValue = "0") int page,

            @RequestParam(
                    defaultValue = "5"
            )
            int size,

            @RequestParam(defaultValue = "name")
            String sortBy, @RequestParam(defaultValue = "asc")
            String direction,

            HttpSession session,

            Model model) {

        model.addAttribute(
                "employees",
                employeeService.getEmployees(
                        page,
                        size,
                        sortBy,
                        direction
                )
        );

        model.addAttribute(
                "currentPage",
                page
        );

        model.addAttribute(
                "totalPages",
                employeeService.getTotalPages(size)
        );

        model.addAttribute(
                "sortBy",
                sortBy
        );

        model.addAttribute(
                "direction",
                direction
        );

        model.addAttribute(
                "role",
                session.getAttribute("role")
        );

        return "employees";
    }

    @GetMapping("/new")
    public String newEmployee(
            HttpSession session,
            Model model) {

        String role =
                (String) session.getAttribute("role");

        if (!"HR".equals(role)) {

            return "redirect:/employees";
        }

        model.addAttribute(
                "employee",
                new Employee()
        );

        model.addAttribute(
                "departments",
                departmentService.getAll()
        );

        return "employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee, @RequestParam Long departmentId, HttpSession session) {

        String role = (String) session.getAttribute("role");

        if (!"HR".equals(role)) 
        {

            return "redirect:/employees";
        }

        Department department =
                departmentService.getById(
                        departmentId
                );

        employee.setDepartment(department);

        employeeService.create(employee);

        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Long id,
            HttpSession session,
            Model model) {

        String role =
                (String) session.getAttribute("role");

        if (!"HR".equals(role)
                && !"MANAGER".equals(role)) {

            return "redirect:/employees";
        }

        Employee employee =
                employeeService.getById(id);

        model.addAttribute(
                "employee",
                employee
        );

        model.addAttribute(
                "departments",
                departmentService.getAll()
        );

        return "employee-form";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable Long id,
            @ModelAttribute Employee employee,
            @RequestParam Long departmentId,
            HttpSession session) {

        String role =
                (String) session.getAttribute("role");

        if (!"HR".equals(role)
                && !"MANAGER".equals(role)) {

            return "redirect:/employees";
        }

        Department department =
                departmentService.getById(
                        departmentId
                );

        employee.setDepartment(department);

        employeeService.update(
                id,
                employee
        );

        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id,
            HttpSession session) {

        String role =
                (String) session.getAttribute("role");

        if (!"HR".equals(role)) {

            return "redirect:/employees";
        }

        employeeService.delete(id);

        return "redirect:/employees";
    }
}
