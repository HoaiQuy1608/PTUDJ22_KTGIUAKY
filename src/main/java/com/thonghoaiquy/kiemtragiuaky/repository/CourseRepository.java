package com.thonghoaiquy.kiemtragiuaky.repository;

import com.thonghoaiquy.kiemtragiuaky.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
