package com.thonghoaiquy.kiemtragiuaky.service;

import com.thonghoaiquy.kiemtragiuaky.model.Role;
import com.thonghoaiquy.kiemtragiuaky.model.Student;
import com.thonghoaiquy.kiemtragiuaky.repository.RoleRepository;
import com.thonghoaiquy.kiemtragiuaky.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));

        Role roleUser = roleRepository.findByName("STUDENT");
        if (roleUser == null) {
            roleUser = new Role();
            roleUser.setName("STUDENT");
            roleRepository.save(roleUser);
        }

        Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
        student.setRoles(roles);

        studentRepository.save(student);
    }

    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }
}