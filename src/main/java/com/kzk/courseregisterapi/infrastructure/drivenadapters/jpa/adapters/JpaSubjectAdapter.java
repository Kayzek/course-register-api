package com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.adapters;

import com.kzk.courseregisterapi.domain.gateway.SubjectGateway;
import com.kzk.courseregisterapi.domain.model.Subject;
import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.entities.SubjectJpaEntity;
import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.repositories.SubjectJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaSubjectAdapter implements SubjectGateway {

    private final SubjectJpaRepository repository;

    @Override
    public Subject save(Subject subject) {
        SubjectJpaEntity entity = new SubjectJpaEntity();
        entity.setId(subject.getId());
        entity.setName(subject.getName());
        entity.setDescription(subject.getDescription());
        
        SubjectJpaEntity saved = repository.save(entity);
        return new Subject(saved.getId(), saved.getName(), saved.getDescription());
    }

    @Override
    public List<Subject> findAll() {
        return repository.findAll().stream()
                .map(e -> new Subject(e.getId(), e.getName(), e.getDescription()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Subject> findById(String id) {
        return repository.findById(id)
                .map(e -> new Subject(e.getId(), e.getName(), e.getDescription()));
    }
}
