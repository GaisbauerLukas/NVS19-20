package at.htl.dogschool.control;

import at.htl.dogschool.entity.CourseType;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CourseTypeRepository {


    @PersistenceContext
    static
    EntityManager entityManager;

    public static CourseType createCourseType(CourseType courseType) {
        entityManager.persist(courseType);
        return courseType;
    }

    public static CourseType updateCourseType(CourseType courseType) {
        courseType = entityManager.merge(courseType);
        return courseType;
    }

    public static CourseType deleteCourseType(long id) {
        CourseType courseType = entityManager.find(CourseType.class,id);
        entityManager.remove(courseType);
        return courseType;
    }

    public static List<CourseType> getAll(){
        return null;//entityManager.createQuery("Select t from S_COURSE_TYPE t",CourseType.class).getResultList();
        //Erkennt den Typ nicht weder S_COURSE_TYPE noch CourseType
    }

    public CourseType findByAbbr(String abbr) {
        return null;
    }

    public List<CourseType> findAll() {
        return null;
    }

    public CourseType save(CourseType courseType) {
        return null;
    }

    public CourseType findById(long id) {
        return null;
    }

    public void delete(long id) {

    }

}
