package com.thonghoaiquy.kiemtragiuaky.controller;

import com.thonghoaiquy.kiemtragiuaky.model.Course;
import com.thonghoaiquy.kiemtragiuaky.service.CategoryService;
import com.thonghoaiquy.kiemtragiuaky.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/courses")
public class AdminCourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "admin/course-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/course-form";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/admin/courses";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/course-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourseById(id);
        return "redirect:/admin/courses";
    }
}