package com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.repositories;

import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.entities.CourseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaRepository extends JpaRepository<CourseJpaEntity, String> {
}
