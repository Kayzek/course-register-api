package kzk.courseregistration.api.infrastructure.drivenadapters.jpa.adapters;

import kzk.courseregistration.api.domain.gateway.TeacherGateway;
import kzk.courseregistration.api.domain.model.Teacher;
import kzk.courseregistration.api.infrastructure.drivenadapters.jpa.entities.TeacherJpaEntity;
import kzk.courseregistration.api.infrastructure.drivenadapters.jpa.repositories.TeacherJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaTeacherAdapter implements TeacherGateway {

    private final TeacherJpaRepository repository;

    @Override
    public Teacher save(Teacher teacher) {
        TeacherJpaEntity entity = new TeacherJpaEntity();
        entity.setName(teacher.getName());
        entity.setEmail(teacher.getEmail());
        entity.setSpecialty(teacher.getSpecialty());
        
        TeacherJpaEntity saved = repository.save(entity);
        return new Teacher(saved.getId(), saved.getName(), saved.getEmail(), saved.getSpecialty());
    }

    @Override
    public List<Teacher> findAll() {
        return repository.findAll().stream()
                .map(e -> new Teacher(e.getId(), e.getName(), e.getEmail(), e.getSpecialty()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return repository.findById(id)
                .map(e -> new Teacher(e.getId(), e.getName(), e.getEmail(), e.getSpecialty()));
    }
}
