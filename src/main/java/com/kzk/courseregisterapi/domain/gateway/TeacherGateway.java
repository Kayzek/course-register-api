package com.kzk.courseregisterapi.domain.gateway;

import com.kzk.courseregisterapi.domain.model.Teacher;
import java.util.List;
import java.util.Optional;

public interface TeacherGateway {
    Teacher save(Teacher teacher);
    List<Teacher> findAll();
    Optional<Teacher> findById(Long id);
}
