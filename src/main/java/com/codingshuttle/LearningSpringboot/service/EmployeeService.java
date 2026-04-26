package com.codingshuttle.LearningSpringboot.service;

import com.codingshuttle.LearningSpringboot.dto.EmployeeDto;
import com.codingshuttle.LearningSpringboot.model.Employee;
import com.codingshuttle.LearningSpringboot.repository.EmployeeRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    ModelMapper modelMapper;

    public Optional<EmployeeDto> getEmployeeById(Long id) 
    {
        Optional<Employee> e = employeeRepository.findById(id);
        if (e.isPresent()) {
            EmployeeDto result = modelMapper.map(e.get(), EmployeeDto.class);
            return Optional.of(result);
        }
        return Optional.empty();
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeesdto = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        for(Employee e : employees) {
            employeesdto.add(modelMapper.map(e, EmployeeDto.class));
        }
        return employeesdto;
    }
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
            Employee e = modelMapper.map(employeeDto, Employee.class);
            e.setId(null);  // Ensure ID is null for new records (auto-generated)
            Employee savedEmployee = employeeRepository.save(e);
            //return ResponseEntity.ok(modelMapper.map(savedEmployee, EmployeeDto.class));
            return modelMapper.map(savedEmployee, EmployeeDto.class);
    }
    
    public ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto) {
            employeeDto.setId(id);
            Employee e = modelMapper.map(employeeDto, Employee.class);
            Employee updatedEmployee = employeeRepository.save(e);
            return ResponseEntity.ok(modelMapper.map(updatedEmployee, EmployeeDto.class));
    }
    public ResponseEntity<Void> deleteEmployee(Long id) {
        //employeeRepository.deleteById(id);
        boolean employeeExists = employeeRepository.existsById(id);
        if (!employeeExists) {
            return ResponseEntity.notFound().build();
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Long updateEmployeePartial1(Long id, Map<String,Object> updates) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        updates.forEach((field, value) -> {
            Field fieldtoUpdate = ReflectionUtils.getRequiredField(Employee.class, field);
            fieldtoUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldtoUpdate, existingEmployee, value);
        });
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return updatedEmployee.getId();
    }

    public Long updateEmployeePartial2(Long id, EmployeeDto updates) throws IllegalArgumentException, IllegalAccessException {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        for(Field field : updates.getClass().getDeclaredFields()) 
        {
            field.setAccessible(true);
            Object val = field.get(updates);
            if(val != null) {
                Field fieldToUpdate = ReflectionUtils.getRequiredField(Employee.class, field.getName());
                fieldToUpdate.setAccessible(true);
                ReflectionUtils.setField(fieldToUpdate, existingEmployee, val);
            }
        }
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return updatedEmployee.getId();
    }
}