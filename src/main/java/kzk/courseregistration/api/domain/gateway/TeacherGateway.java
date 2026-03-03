package kzk.courseregistration.api.domain.gateway;

import kzk.courseregistration.api.domain.model.Teacher;
import java.util.List;
import java.util.Optional;

public interface TeacherGateway {
    Teacher save(Teacher teacher);
    List<Teacher> findAll();
    Optional<Teacher> findById(Long id);
}
