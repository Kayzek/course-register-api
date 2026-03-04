package com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.adapters;

import com.kzk.courseregisterapi.domain.gateway.CourseGateway;
import com.kzk.courseregisterapi.domain.model.Course;
import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.entities.CourseJpaEntity;
import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.repositories.CourseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaCourseAdapter implements CourseGateway {

    private final CourseJpaRepository repository;

    @Override
    public Course save(Course course) {
        CourseJpaEntity entity = new CourseJpaEntity();
        entity.setCode(course.getCode());
        entity.setName(course.getName());
        entity.setDescription(course.getDescription());
        entity.setSubjectId(course.getSubjectId());
        entity.setTeacherId(course.getTeacherId());
        
        CourseJpaEntity saved = repository.save(entity);
        return new Course(saved.getCode(), saved.getName(), saved.getDescription(), saved.getSubjectId(), saved.getTeacherId());
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll().stream()
                .map(e -> new Course(e.getCode(), e.getName(), e.getDescription(), e.getSubjectId(), e.getTeacherId()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsById(String code) {
        return repository.existsById(code);
    }
}
