package com.codingshuttle.LearningSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingshuttle.LearningSpringboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}