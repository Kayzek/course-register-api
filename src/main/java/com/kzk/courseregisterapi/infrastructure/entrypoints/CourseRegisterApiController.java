package com.kzk.courseregisterapi.infrastructure.entrypoints;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.kzk.courseregisterapi.domain.model.Course;
import com.kzk.courseregisterapi.domain.model.Student;
import com.kzk.courseregisterapi.usecase.CourseRegisterApiUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Course Registration", description = "Endpoints for managing courses and students.")
@RequiredArgsConstructor
public class CourseRegisterApiController {

    private final CourseRegisterApiUseCase useCase;

    @PostMapping("/courses")
    @Operation(summary = "Create a new course", responses = {
            @ApiResponse(responseCode = "200", description = "Course created successfully")
    })
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(useCase.createCourse(course));
    }

    @GetMapping("/courses")
    @Operation(summary = "List all courses", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    })
    public ResponseEntity<List<Course>> listCourses() {
        return ResponseEntity.ok(useCase.listCourses());
    }

    @PostMapping("/students")
    @Operation(summary = "Register a student in a course", responses = {
            @ApiResponse(responseCode = "200", description = "Registration result message")
    })
    public ResponseEntity<String> registerStudent(@RequestBody Student student) {
        String result = useCase.registerStudent(student);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/courses/{code}/students")
    @Operation(summary = "List students by course", description = "Retrieves all students registered in a specific course by its code.")
    public ResponseEntity<List<Student>> listStudentsByCourse(@PathVariable String code) {
        return ResponseEntity.ok(useCase.findStudentsByCourseCode(code));
    }
}
