package tn.esprit.spring.services;

import tn.esprit.spring.entities.Course;
import tn.esprit.spring.dto.CourseDTO;

import java.util.List;

public interface ICourseServices {

    List<Course> retrieveAllCourses();

    CourseDTO addCourse(CourseDTO courseDTO);  // Renommé pour respecter les conventions

    CourseDTO updateCourse(CourseDTO courseDTO); // Renommé pour respecter les conventions

    CourseDTO retrieveCourse(Long numCourse);
}
