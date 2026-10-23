package com.example.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Employee;

@Service
public class EmployeeService 
{
    private final List<Employee> employees = new ArrayList<>();

    private long nextId = 1;

    public Employee create(Employee employee) 
    {
        employee.setId(nextId++);
        employees.add(employee);
        return employee;
    }

    public Employee getById(Long id) 
    {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Employee> getEmployees(int page, int size, String sortBy, String direction) 
    {

        List<Employee> result = new ArrayList<>(employees);

        Comparator<Employee> comparator;

        if ("salary".equalsIgnoreCase(sortBy)) 
        {
            comparator = Comparator.comparingDouble(Employee::getSalary);

        } 
        else if ("email".equalsIgnoreCase(sortBy)) 
        {
            comparator = Comparator.comparing(Employee::getEmail);

        } 
        else 
        {
            comparator = Comparator.comparing(Employee::getName);
        }

        if ("desc".equalsIgnoreCase(direction)) 
        {
            comparator = comparator.reversed();
        }

        result.sort(comparator);

        int start = page * size;

        if (start >= result.size()) 
        {
            return new ArrayList<>();
        }

        int end = Math.min(start + size, result.size());

        return result.subList(start, end);
    }

    public int getTotalPages(int size) 
    {
        if (employees.isEmpty()) 
        {
            return 1;
        }

        return (int) Math.ceil((double) employees.size() / size);
    }

    public Employee update(Long id,Employee updated) 
    {
        Employee existing = getById(id);

        if (existing == null) 
        {
            return null;
        }

        existing.setName(updated.getName());

        existing.setEmail(updated.getEmail());

        existing.setSalary(updated.getSalary());

        existing.setDepartment(updated.getDepartment());

        return existing;
    }

    public boolean delete(Long id) 
    {
        return employees.removeIf(e -> e.getId().equals(id));
    }
}
