package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Department;

@Service
public class DepartmentService
{
    private final List<Department> departments = new ArrayList<>();

    private long nextId = 1;

    public DepartmentService() 
    {
        departments.add(new Department(nextId++, "IT"));
        departments.add(new Department(nextId++, "HR"));
        departments.add(new Department(nextId++, "Finance"));
    }

    public List<Department> getAll() 
    {
        return departments;
    }

    public Department getById(Long id) 
    {
        return departments.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Department create(Department department) 
    {
        department.setId(nextId++);
        departments.add(department);
        return department;
    }
}