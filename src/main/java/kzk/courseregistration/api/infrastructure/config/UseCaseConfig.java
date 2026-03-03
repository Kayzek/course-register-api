package kzk.courseregistration.api.infrastructure.config;

import kzk.courseregistration.api.domain.gateway.CourseGateway;
import kzk.courseregistration.api.domain.gateway.StudentGateway;
import kzk.courseregistration.api.domain.gateway.TeacherGateway;
import kzk.courseregistration.api.domain.gateway.SubjectGateway;
import kzk.courseregistration.api.usecase.CourseRegistrationUseCase;
import kzk.courseregistration.api.usecase.ManagementUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CourseRegistrationUseCase courseRegistrationUseCase(CourseGateway courseGateway, StudentGateway studentGateway) {
        return new CourseRegistrationUseCase(courseGateway, studentGateway);
    }

    @Bean
    public ManagementUseCase managementUseCase(TeacherGateway teacherGateway, SubjectGateway subjectGateway) {
        return new ManagementUseCase(teacherGateway, subjectGateway);
    }
}
