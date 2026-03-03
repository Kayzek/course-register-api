package kzk.courseregistration.api.infrastructure.drivenadapters.jpa.repositories;

import kzk.courseregistration.api.infrastructure.drivenadapters.jpa.entities.TeacherJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherJpaRepository extends JpaRepository<TeacherJpaEntity, Long> {
}
