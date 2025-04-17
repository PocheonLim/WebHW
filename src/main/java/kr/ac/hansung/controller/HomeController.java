package kr.ac.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/enroll")
    public String showEnroll() {
        return "enroll";
    }

    @GetMapping("/enrollments")
    public String showEnrollments() {
        return "enrollments";
    }
}
