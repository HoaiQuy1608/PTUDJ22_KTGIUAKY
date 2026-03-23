package com.thonghoaiquy.kiemtragiuaky.service;

import com.thonghoaiquy.kiemtragiuaky.model.Course;
import com.thonghoaiquy.kiemtragiuaky.model.Enrollment;
import com.thonghoaiquy.kiemtragiuaky.model.Student;
import com.thonghoaiquy.kiemtragiuaky.repository.CourseRepository;
import com.thonghoaiquy.kiemtragiuaky.repository.EnrollmentRepository;
import com.thonghoaiquy.kiemtragiuaky.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void enrollCourse(String username, Long courseId) {
        Student student = studentRepository.findByUsername(username);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student != null && course != null) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);
            enrollment.setEnrollmentDate(LocalDateTime.now());
            enrollmentRepository.save(enrollment);
        }
    }
}