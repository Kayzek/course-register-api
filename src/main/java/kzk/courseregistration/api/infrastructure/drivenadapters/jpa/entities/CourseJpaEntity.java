package kzk.courseregistration.api.infrastructure.drivenadapters.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class CourseJpaEntity {
    @Id
    private String code;
    private String name;
    private String description;
    private String subjectId;
    private Long teacherId;
}
