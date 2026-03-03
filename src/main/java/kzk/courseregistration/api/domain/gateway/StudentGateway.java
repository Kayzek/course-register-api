package kzk.courseregistration.api.domain.gateway;

import kzk.courseregistration.api.domain.model.Student;
import java.util.List;

public interface StudentGateway {
    Student save(Student student);
    List<Student> findByCourseCode(String code);
}
