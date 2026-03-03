package kzk.courseregistration.api.infrastructure.drivenadapters.jpa.adapters;

import kzk.courseregistration.api.domain.gateway.StudentGateway;
import kzk.courseregistration.api.domain.model.Student;
import kzk.courseregistration.api.infrastructure.drivenadapters.jpa.entities.StudentJpaEntity;
import kzk.courseregistration.api.infrastructure.drivenadapters.jpa.repositories.StudentJpaRepository;
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
