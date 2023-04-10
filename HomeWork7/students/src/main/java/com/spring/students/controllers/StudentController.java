package com.spring.students.controllers;

import com.spring.students.DTO.StudentDTO;
import com.spring.students.converter.DTOConverter;
import com.spring.students.entities.Student;
import com.spring.students.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        int i = studentService.addStudent(student);
        if (i > 0) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        int i = studentService.deleteStudent(id);
        if (i > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return DTOConverter.getStudentDTO(student);
        }
        return null;
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable Long id) {
        student.setId(id);
        int i = studentService.updateStudent(student);
        if (i > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
