package com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.repositories;

import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.entities.TeacherJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherJpaRepository extends JpaRepository<TeacherJpaEntity, Long> {
}
