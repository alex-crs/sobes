package com.spring.students.services;

import com.spring.students.entities.Student;
import com.spring.students.repositories.StudentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public int addStudent(Student student) {
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    public int deleteStudent(Long id) {
        try {
            studentRepository.deleteById(id);
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    public Student getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    public int updateStudent(Student student) {
        try {
            Student oldStudent = studentRepository.getById(student.getId());
            if (student.getAge() != 0) {
                oldStudent.setAge(student.getAge());
            }
            if (student.getName() != null) {
                oldStudent.setName(student.getName());
            }
            studentRepository.save(oldStudent);
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

}
