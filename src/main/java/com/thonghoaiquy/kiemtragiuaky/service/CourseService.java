package com.thonghoaiquy.kiemtragiuaky.service;

import com.thonghoaiquy.kiemtragiuaky.model.Course;
import com.thonghoaiquy.kiemtragiuaky.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Page<Course> getAllCoursesWithPagination(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
}