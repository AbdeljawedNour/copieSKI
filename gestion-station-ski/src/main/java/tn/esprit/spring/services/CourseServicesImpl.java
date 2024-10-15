package tn.esprit.spring.services;

import tn.esprit.spring.dto.CourseDTO;
import tn.esprit.spring.entities.Support;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServicesImpl implements ICourseServices {

    private final ICourseRepository courseRepository;

    @Override
    public List<Course> retrieveAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public CourseDTO addCourse(CourseDTO courseDTO) {
        Course course = mapToEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return mapToDTO(savedCourse); // Retourne le DTO après enregistrement
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO) {
        Course course = mapToEntity(courseDTO);
        Course updatedCourse = courseRepository.save(course);
        return mapToDTO(updatedCourse); // Retourne le DTO après mise à jour
    }

    @Override
    public CourseDTO retrieveCourse(Long numCourse) {
        Course course = courseRepository.findById(numCourse).orElse(null);
        return mapToDTO(course); // Retourne le DTO
    }

    // Méthode pour mapper CourseDTO à Course
    private Course mapToEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }
        Course course = new Course();
        course.setNumCourse(courseDTO.getNumCourse());
        course.setLevel(courseDTO.getLevel());
        course.setTypeCourse(TypeCourse.valueOf(courseDTO.getTypeCourse())); // Assurez-vous que les valeurs correspondent
        course.setSupport(Support.valueOf(courseDTO.getSupport())); // Assurez-vous que les valeurs correspondent
        course.setPrice(courseDTO.getPrice());
        course.setTimeSlot(courseDTO.getTimeSlot());
        return course;
    }

    // Méthode pour mapper Course à CourseDTO
    private CourseDTO mapToDTO(Course course) {
        if (course == null) {
            return null;
        }
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setNumCourse(course.getNumCourse());
        courseDTO.setLevel(course.getLevel());
        courseDTO.setTypeCourse(course.getTypeCourse().name());
        courseDTO.setSupport(course.getSupport().name());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setTimeSlot(course.getTimeSlot());
        return courseDTO;
    }
}
