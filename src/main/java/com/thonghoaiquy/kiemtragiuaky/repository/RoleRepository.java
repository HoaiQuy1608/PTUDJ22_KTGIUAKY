package com.thonghoaiquy.kiemtragiuaky.repository;

import com.thonghoaiquy.kiemtragiuaky.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
