package kr.ac.hansung.service;

import kr.ac.hansung.dao.CoursesDao;
import kr.ac.hansung.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    @Autowired
    private CoursesDao coursesDao;

    public List<Courses> getAllCourses() {
        return coursesDao.getAllCourses();
    }

    public List<Courses> getCoursesByYear(int year) {
        return coursesDao.getCoursesByYear(year);
    }

    public List<Courses> getCoursesByYearAndSemester(int year, int semester) {
        return coursesDao.getCoursesByYearAndSemester(year, semester);
    }

    public Courses getCourse(String courseCode) {
        return coursesDao.getCourse(courseCode);
    }

    public void insertCourse(Courses course) {
        coursesDao.insert(course);
    }

    public void updateCourse(Courses course) {
        coursesDao.update(course);
    }

    public void deleteCourse(String courseCode) {
        coursesDao.delete(courseCode);
    }
}