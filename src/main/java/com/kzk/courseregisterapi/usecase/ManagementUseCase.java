package com.kzk.courseregisterapi.usecase;

import com.kzk.courseregisterapi.domain.gateway.TeacherGateway;
import com.kzk.courseregisterapi.domain.gateway.SubjectGateway;
import com.kzk.courseregisterapi.domain.model.Teacher;
import com.kzk.courseregisterapi.domain.model.Subject;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ManagementUseCase {

    private final TeacherGateway teacherGateway;
    private final SubjectGateway subjectGateway;

    // Teacher operations
    public Teacher createTeacher(Teacher teacher) {
        return teacherGateway.save(teacher);
    }

    public List<Teacher> listTeachers() {
        return teacherGateway.findAll();
    }

    // Subject operations
    public Subject createSubject(Subject subject) {
        return subjectGateway.save(subject);
    }

    public List<Subject> listSubjects() {
        return subjectGateway.findAll();
    }
}
