package com.thonghoaiquy.kiemtragiuaky.controller;

import com.thonghoaiquy.kiemtragiuaky.model.Student;
import com.thonghoaiquy.kiemtragiuaky.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("student") Student student) {
        studentService.registerNewStudent(student);
        return "redirect:/login";
    }
}