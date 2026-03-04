package com.kzk.courseregisterapi.domain.gateway;

import com.kzk.courseregisterapi.domain.model.Student;
import java.util.List;

public interface StudentGateway {
    Student save(Student student);
    List<Student> findByCourseCode(String code);
}
