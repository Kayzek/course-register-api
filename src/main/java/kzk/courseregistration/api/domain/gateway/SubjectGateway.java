package kzk.courseregistration.api.domain.gateway;

import kzk.courseregistration.api.domain.model.Subject;
import java.util.List;
import java.util.Optional;

public interface SubjectGateway {
    Subject save(Subject subject);
    List<Subject> findAll();
    Optional<Subject> findById(String id);
}
