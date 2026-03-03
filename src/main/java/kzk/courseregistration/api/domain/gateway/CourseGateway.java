package kzk.courseregistration.api.domain.gateway;

import kzk.courseregistration.api.domain.model.Course;
import java.util.List;

public interface CourseGateway {
    Course save(Course course);
    List<Course> findAll();
    boolean existsById(String code);
}
