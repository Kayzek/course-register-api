package kzk.courseregistration.api.infrastructure.drivenadapters.jpa.repositories;

import kzk.courseregistration.api.infrastructure.drivenadapters.jpa.entities.SubjectJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectJpaRepository extends JpaRepository<SubjectJpaEntity, String> {
}
