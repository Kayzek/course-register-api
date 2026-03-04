package com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.repositories;

import com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.entities.StudentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentJpaRepository extends JpaRepository<StudentJpaEntity, Long> {
    List<StudentJpaEntity> findByCourseCode(String courseCode);
}
