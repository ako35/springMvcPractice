package com.tpe.controller;

import com.tpe.domain.Course;
import com.tpe.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/form")
    public String showCoursesForm(@ModelAttribute("course")Course course){
        return "courseForm";
    }

    @PostMapping("/saveCourse")
    public String createCourse(@Valid @ModelAttribute Course course){
        courseService.saveCourse(course);
        return "redirect:/courses";
    }
    @GetMapping
    public ModelAndView getCourses(){
        List<Course> courseList= courseService.getAllCourse();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("courses", courseList);
        modelAndView.setViewName("courses");
        return modelAndView;
    }

}
