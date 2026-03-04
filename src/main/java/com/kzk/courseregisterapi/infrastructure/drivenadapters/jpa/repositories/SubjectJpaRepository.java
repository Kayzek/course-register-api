package com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.repositories;

import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.entities.SubjectJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectJpaRepository extends JpaRepository<SubjectJpaEntity, String> {
}
