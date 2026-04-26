//add the package name
package com.codingshuttle.LearningSpringboot.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.LearningSpringboot.dto.EmployeeDto;
import com.codingshuttle.LearningSpringboot.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/get")
    public List<EmployeeDto> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Optional<EmployeeDto> getEmployees(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(id, employeeDto);
    }

    @PatchMapping("/update1/{id}")
    public Long updatePartialEmployeeMethod1(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return employeeService.updateEmployeePartial1(id, updates);
    }

    @PatchMapping("/update2/{id}")
    public Long updatePartialEmployeeMethod2(@PathVariable Long id, @RequestBody EmployeeDto updates) throws IllegalArgumentException, IllegalAccessException {
        return employeeService.updateEmployeePartial2(id, updates);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}