package kzk.courseregistration.api.infrastructure.drivenadapters.jpa.repositories;

import kzk.courseregistration.api.infrastructure.drivenadapters.jpa.entities.CourseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaRepository extends JpaRepository<CourseJpaEntity, String> {
}
