package com.kzk.courseregisterapi.domain.gateway;

import com.kzk.courseregisterapi.domain.model.Course;
import java.util.List;

public interface CourseGateway {
    Course save(Course course);
    List<Course> findAll();
    boolean existsById(String code);
}
