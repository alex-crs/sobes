package com.spring.students.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    private String name;
    private int age;
}
