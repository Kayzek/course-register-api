package com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.adapters;

import com.kzk.courseregisterapi.domain.gateway.StudentGateway;
import com.kzk.courseregisterapi.domain.model.Student;
import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.entities.StudentJpaEntity;
import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.repositories.StudentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaStudentAdapter implements StudentGateway {

    private final StudentJpaRepository repository;

    @Override
    public Student save(Student student) {
        StudentJpaEntity entity = new StudentJpaEntity();
        entity.setName(student.getName());
        entity.setLastName(student.getLastName());
        entity.setEmail(student.getEmail());
        entity.setCourseCode(student.getCourseCode());
        
        StudentJpaEntity saved = repository.save(entity);
        return new Student(saved.getId(), saved.getName(), saved.getLastName(), saved.getEmail(), saved.getCourseCode());
    }

    @Override
    public List<Student> findByCourseCode(String code) {
        return repository.findByCourseCode(code).stream()
                .map(e -> new Student(e.getId(), e.getName(), e.getLastName(), e.getEmail(), e.getCourseCode()))
                .collect(Collectors.toList());
    }
}
