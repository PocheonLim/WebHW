package kr.ac.hansung.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.ac.hansung.model.Courses;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CoursesDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Courses> getCoursesByYear(int year) {
        return entityManager.createQuery("SELECT c FROM Courses c WHERE c.year = :year", Courses.class)
                .setParameter("year", year)
                .getResultList();
    }

    public List<Courses> getCoursesByYearAndSemester(int year, int semester) {
        return entityManager
                .createQuery("SELECT c FROM Courses c WHERE c.year = :year AND c.semester = :semester", Courses.class)
                .setParameter("year", year)
                .setParameter("semester", semester)
                .getResultList();
    }

    public Courses getCourse(String courseCode) {
        return entityManager.find(Courses.class, courseCode);
    }

    public List<Courses> getAllCourses() {
        return entityManager.createQuery("SELECT c FROM Courses c", Courses.class)
                .getResultList();
    }

    public void insert(Courses course) {
        entityManager.persist(course);
    }

    public void update(Courses course) {
        entityManager.merge(course);
    }

    public void delete(String courseCode) {
        Courses course = entityManager.find(Courses.class, courseCode);
        if (course != null) {
            entityManager.remove(course);
        }
    }
}
