package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable int id) {
        return service.getEmployee(id);
    }

    @PutMapping("/update")
    public Employee update(@RequestBody Employee emp) {
        return service.updateEmployee(emp);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee Deleted";
    }
}
