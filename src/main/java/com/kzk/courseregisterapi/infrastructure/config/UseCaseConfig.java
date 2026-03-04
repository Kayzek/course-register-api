package com.kzk.courseregisterapi.infrastructure.config;

import com.kzk.courseregisterapi.domain.gateway.CourseGateway;
import com.kzk.courseregisterapi.domain.gateway.StudentGateway;
import com.kzk.courseregisterapi.domain.gateway.TeacherGateway;
import com.kzk.courseregisterapi.domain.gateway.SubjectGateway;
import com.kzk.courseregisterapi.usecase.CourseRegisterApiUseCase;
import com.kzk.courseregisterapi.usecase.ManagementUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CourseRegisterApiUseCase CourseRegisterApiUseCase(CourseGateway courseGateway, StudentGateway studentGateway) {
        return new CourseRegisterApiUseCase(courseGateway, studentGateway);
    }

    @Bean
    public ManagementUseCase managementUseCase(TeacherGateway teacherGateway, SubjectGateway subjectGateway) {
        return new ManagementUseCase(teacherGateway, subjectGateway);
    }
}
