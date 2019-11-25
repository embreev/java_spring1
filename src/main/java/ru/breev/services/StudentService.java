package ru.breev.services;

import ru.breev.entities.Student;
import ru.breev.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    public void insert(Student student) {
        studentsRepository.insert(student);
    }

    public Optional<Student> findById(Long id) {
        return studentsRepository.findOneById(id);
    }
}
