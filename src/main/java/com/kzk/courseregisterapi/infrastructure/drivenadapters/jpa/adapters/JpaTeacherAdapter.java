package com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.adapters;

import com.kzk.courseregisterapi.domain.gateway.TeacherGateway;
import com.kzk.courseregisterapi.domain.model.Teacher;
import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.entities.TeacherJpaEntity;
import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.repositories.TeacherJpaRepository;
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
