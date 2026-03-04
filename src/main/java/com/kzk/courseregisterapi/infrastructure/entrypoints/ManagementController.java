package com.kzk.courseregisterapi.infrastructure.entrypoints;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.kzk.courseregisterapi.domain.model.Teacher;
import com.kzk.courseregisterapi.domain.model.Subject;
import com.kzk.courseregisterapi.usecase.ManagementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/management")
@Tag(name = "Administration (Management)", description = "Management endpoints for teachers and subjects.")
@RequiredArgsConstructor
public class ManagementController {

    private final ManagementUseCase useCase;

    @PostMapping("/teachers")
    @Operation(summary = "Create a new teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(useCase.createTeacher(teacher));
    }

    @GetMapping("/teachers")
    @Operation(summary = "List all teachers")
    public ResponseEntity<List<Teacher>> listTeachers() {
        return ResponseEntity.ok(useCase.listTeachers());
    }

    @PostMapping("/subjects")
    @Operation(summary = "Create a new subject")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        return ResponseEntity.ok(useCase.createSubject(subject));
    }

    @GetMapping("/subjects")
    @Operation(summary = "List all subjects")
    public ResponseEntity<List<Subject>> listSubjects() {
        return ResponseEntity.ok(useCase.listSubjects());
    }
}
