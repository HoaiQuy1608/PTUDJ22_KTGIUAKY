package com.thonghoaiquy.kiemtragiuaky.repository;

import com.thonghoaiquy.kiemtragiuaky.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}