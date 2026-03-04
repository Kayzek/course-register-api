package com.kzk.courseregisterapi.infrastructure.drivenadapters.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@NoArgsConstructor
public class SubjectJpaEntity {
    @Id
    private String id;
    private String name;
    private String description;
}
