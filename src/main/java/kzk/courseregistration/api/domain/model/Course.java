package kzk.courseregistration.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private String code;
    private String name;
    private String description;
    private String subjectId;
    private Long teacherId;
}
