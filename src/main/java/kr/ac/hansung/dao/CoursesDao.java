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

    public List<Courses> getAllCourses() {
        return entityManager.createQuery("SELECT c FROM Courses c", Courses.class)
                .getResultList();
    }

    public List<Courses> getCoursesByYearAndSemester(int year, int semester) {
        return entityManager
                .createQuery("SELECT c FROM Courses c WHERE c.year = :year AND c.semester = :semester", Courses.class)
                .setParameter("year", year)
                .setParameter("semester", semester)
                .getResultList();
    }

    public void insert(Courses course) {
        entityManager.persist(course);
    }
}
