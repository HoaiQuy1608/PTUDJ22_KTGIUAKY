package com.thonghoaiquy.kiemtragiuaky.controller;

import com.thonghoaiquy.kiemtragiuaky.model.Course;
import com.thonghoaiquy.kiemtragiuaky.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping({"/", "/home"})
    public String viewHomePage(
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        int pageSize = 5;
        Page<Course> coursePage = courseService.getAllCoursesWithPagination(PageRequest.of(page, pageSize));

        model.addAttribute("courses", coursePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", coursePage.getTotalPages());

        return "home";
    }
}