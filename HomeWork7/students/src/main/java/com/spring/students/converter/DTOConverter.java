package com.spring.students.converter;

import com.spring.students.DTO.StudentDTO;
import com.spring.students.entities.Student;

public class DTOConverter {
    public static StudentDTO getStudentDTO(Student student){
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .build();
    }
}
