package com.kzk.courseregisterapi.usecase;

import com.kzk.courseregisterapi.domain.gateway.CourseGateway;
import com.kzk.courseregisterapi.domain.gateway.StudentGateway;
import com.kzk.courseregisterapi.domain.model.Course;
import com.kzk.courseregisterapi.domain.model.Student;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CourseRegisterApiUseCase {

    private final CourseGateway courseGateway;
    private final StudentGateway studentGateway;

    public Course createCourse(Course course) {
        return courseGateway.save(course);
    }

    public List<Course> listCourses() {
        return courseGateway.findAll();
    }

    public List<Student> findStudentsByCourseCode(String courseCode) {
        return studentGateway.findByCourseCode(courseCode);
    }

    public String registerStudent(Student student) {
        if (courseGateway.existsById(student.getCourseCode())) {
            studentGateway.save(student);
            return "Student '" + student.getName() + "' registered in the course.";
        } else {
            return "Could not register the student. The course with code '" + student.getCourseCode() + "' does not exist.";
        }
    }
}
