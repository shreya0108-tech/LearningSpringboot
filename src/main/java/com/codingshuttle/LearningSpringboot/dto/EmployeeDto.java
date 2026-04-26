package com.codingshuttle.LearningSpringboot.dto;

import java.time.LocalDate;

import com.codingshuttle.LearningSpringboot.annotation.AgeValidator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
          private Long id;
          private String name;
          private String department;
          private String email;
          private String phoneNumber;
          @AgeValidator
          private int age;
          private LocalDate dateOfJoining;
}