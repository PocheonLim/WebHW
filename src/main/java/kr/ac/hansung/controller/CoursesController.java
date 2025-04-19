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

        // 학점 조회 기능
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

                // 모델에 데이터 추가
                model.addAttribute("coursesByYearAndSemester", coursesByYearAndSemester);
                model.addAttribute("creditsByYearAndSemester", creditsByYearAndSemester);
                model.addAttribute("totalCredits", totalCredits);

                return "credits";
        }

        // 상세 학점 조회 기능
        @GetMapping("/credits/detail")
        public String showCreditDetail(@RequestParam("year") int year, @RequestParam("semester") int semester,
                        Model model) {
                // 특정 년도와 학기의 과목 정보를 가져옴
                List<Courses> courses = coursesService.getCoursesByYearAndSemester(year, semester);
                // 해당 학기의 총 학점 계산
                int totalCredits = courses.stream().mapToInt(Courses::getCredit).sum();

                // 모델에 데이터 추가
                model.addAttribute("year", year);
                model.addAttribute("semester", semester);
                model.addAttribute("courses", courses);
                model.addAttribute("totalCredits", totalCredits);

                return "creditDetail";
        }

        // 수강 신청 폼 표시
        @GetMapping("/enroll")
        public String showEnrollForm(Model model) {
                // 새로운 Courses 객체를 생성하여 폼에 바인딩
                model.addAttribute("courses", new Courses());
                return "enroll";
        }

        // 수강 신청 처리
        @PostMapping("/enroll")
        public String processEnrollment(@Valid Courses courses, BindingResult result) {
                // 입력값 검증
                if (result.hasErrors()) {
                        return "enroll";
                }

                try {
                        // 수강 신청 정보를 데이터베이스에 저장
                        coursesService.insertCourse(courses);
                        // 수강 신청 내역 페이지로 리다이렉트
                        return "redirect:/enrollments";
                } catch (Exception e) {
                        // 과목 코드 중복 시 에러 메시지 추가
                        result.rejectValue("courseCode", "error.courses", "이미 존재하는 과목 코드입니다.");
                        return "enroll";
                }
        }

        // 수강 신청 내역 조회
        @GetMapping("/enrollments")
        public String showEnrollments(Model model) {
                // 2025년 2학기의 수강 신청 내역을 가져옴
                List<Courses> enrolledCourses = coursesService.getCoursesByYearAndSemester(2025, 2);
                // 총 학점 계산
                int totalCredits = enrolledCourses.stream().mapToInt(Courses::getCredit).sum();

                // 모델에 데이터 추가
                model.addAttribute("courses", enrolledCourses);
                model.addAttribute("totalCredits", totalCredits);
                return "enrollments";
        }
}