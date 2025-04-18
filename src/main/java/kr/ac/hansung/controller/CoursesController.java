package kr.ac.hansung.controller;

import kr.ac.hansung.service.CoursesService;
import kr.ac.hansung.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CoursesController {

        @Autowired
        private CoursesService coursesService;

        @GetMapping("/credits")
        public String showCredits(Model model) {
                // 모든 과목 정보를 가져옴
                List<Courses> allCourses = coursesService.getAllCourses();

                // 년도와 학기별로 과목들을 그룹화
                Map<Integer, Map<Integer, List<Courses>>> coursesByYearAndSemester = allCourses.stream()
                                .collect(Collectors.groupingBy(
                                                Courses::getYear,
                                                Collectors.groupingBy(Courses::getSemester)));

                // 년도와 학기별 총 학점 계산
                Map<Integer, Map<Integer, Integer>> creditsByYearAndSemester = coursesByYearAndSemester.entrySet()
                                .stream()
                                .collect(Collectors.toMap(
                                                Map.Entry::getKey,
                                                e -> e.getValue().entrySet().stream()
                                                                .collect(Collectors.toMap(
                                                                                Map.Entry::getKey,
                                                                                semesterEntry -> semesterEntry
                                                                                                .getValue().stream()
                                                                                                .mapToInt(Courses::getCredit)
                                                                                                .sum()))));

                // 전체 총 학점 계산
                int totalCredits = allCourses.stream()
                                .mapToInt(Courses::getCredit)
                                .sum();

                model.addAttribute("coursesByYearAndSemester", coursesByYearAndSemester);
                model.addAttribute("creditsByYearAndSemester", creditsByYearAndSemester);
                model.addAttribute("totalCredits", totalCredits);

                return "credits";
        }

        @GetMapping("/credits/detail")
        public String showCreditDetail(@RequestParam("year") int year, @RequestParam("semester") int semester,
                        Model model) {
                List<Courses> courses = coursesService.getCoursesByYearAndSemester(year, semester);
                int totalCredits = courses.stream().mapToInt(Courses::getCredit).sum();

                model.addAttribute("year", year);
                model.addAttribute("semester", semester);
                model.addAttribute("courses", courses);
                model.addAttribute("totalCredits", totalCredits);

                return "creditDetail";
        }

        @GetMapping("/enroll")
        public String showEnrollForm(Model model) {
                model.addAttribute("courses", new Courses());
                return "enroll";
        }

        @PostMapping("/enroll")
        public String processEnrollment(@Valid Courses courses, BindingResult result) {
                if (result.hasErrors()) {
                        return "enroll";
                }

                try {
                        coursesService.insertCourse(courses);
                        return "redirect:/enrollments";
                } catch (Exception e) {
                        result.rejectValue("courseCode", "error.courses", "이미 존재하는 과목 코드입니다.");
                        return "enroll";
                }
        }

        @GetMapping("/enrollments")
        public String showEnrollments(Model model) {
                List<Courses> enrolledCourses = coursesService.getCoursesByYearAndSemester(2025, 2);
                int totalCredits = enrolledCourses.stream().mapToInt(Courses::getCredit).sum();

                model.addAttribute("courses", enrolledCourses);
                model.addAttribute("totalCredits", totalCredits);
                return "enrollments";
        }
}