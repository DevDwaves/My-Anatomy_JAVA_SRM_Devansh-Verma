package com.example.model;

public class Employee 
{
    private Long id;
    private String name;
    private String email;
    private double salary;

    private Department department;

    public Employee() 
    {}

    public Employee(
            Long id,
            String name,
            String email,
            double salary,
            Department department) 
    {

        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public double getSalary() 
    {
        return salary;
    }

    public void setSalary(double salary) 
    {
        this.salary = salary;
    }

    public Department getDepartment() 
    {
        return department;
    }

    public void setDepartment(Department department) 
    {
        this.department = department;
    }
}
