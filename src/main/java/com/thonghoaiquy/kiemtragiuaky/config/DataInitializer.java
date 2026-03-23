package com.thonghoaiquy.kiemtragiuaky.config;

import com.thonghoaiquy.kiemtragiuaky.model.Role;
import com.thonghoaiquy.kiemtragiuaky.model.Student;
import com.thonghoaiquy.kiemtragiuaky.repository.RoleRepository;
import com.thonghoaiquy.kiemtragiuaky.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initAdmin(StudentRepository studentRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Role adminRole = roleRepository.findByName("ADMIN");
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setName("ADMIN");
                roleRepository.save(adminRole);
            }

            if (studentRepository.findByUsername("admin") == null) {
                Student adminUser = new Student();
                adminUser.setUsername("admin");
                adminUser.setPassword(passwordEncoder.encode("123456"));
                adminUser.setEmail("admin@example.com");

                Set<Role> roles = new HashSet<>();
                roles.add(adminRole);
                adminUser.setRoles(roles);

                studentRepository.save(adminUser);
                System.out.println(">>> Đã tạo tài khoản ADMIN: user=admin | pass=123456");
            }
        };
    }
}