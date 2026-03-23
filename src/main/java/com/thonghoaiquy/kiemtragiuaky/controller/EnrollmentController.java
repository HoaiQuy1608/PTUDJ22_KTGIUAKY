package com.thonghoaiquy.kiemtragiuaky.controller;

import com.thonghoaiquy.kiemtragiuaky.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.security.Principal;

@Controller
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/enroll/{courseId}")
    public String enroll(@PathVariable Long courseId, Principal principal) {
        if (principal != null) {
            enrollmentService.enrollCourse(principal.getName(), courseId);
        }
        return "redirect:/?enrolled=true";
    }
}