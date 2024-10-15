package tn.esprit.spring.controllers;

import tn.esprit.spring.dto.CourseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.services.ICourseServices;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "\uD83D\uDCDA Course Management")
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseRestController {

    private final ICourseServices courseServices;

    @Operation(description = "Add Course")
    @PostMapping("/add")
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO) {
        return courseServices.addCourse(courseDTO); // Appel direct à la méthode du service
    }

    @Operation(description = "Retrieve all Courses")
    @GetMapping("/all")
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseServices.retrieveAllCourses();
        return courses.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Operation(description = "Update Course")
    @PutMapping("/update")
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO) {
        return courseServices.updateCourse(courseDTO); // Appel direct à la méthode du service
    }

    @Operation(description = "Retrieve Course by Id")
    @GetMapping("/get/{id-course}")
    public CourseDTO getById(@PathVariable("id-course") Long numCourse) {
        return courseServices.retrieveCourse(numCourse); // Récupération directe du DTO
    }

    // Méthode pour mapper Course à CourseDTO
    private CourseDTO mapToDTO(Course course) {
        if (course == null) {
            return null;
        }
        CourseDTO dto = new CourseDTO();
        dto.setNumCourse(course.getNumCourse());
        dto.setLevel(course.getLevel());
        dto.setTypeCourse(course.getTypeCourse().name());
        dto.setSupport(course.getSupport().name());
        dto.setPrice(course.getPrice());
        dto.setTimeSlot(course.getTimeSlot());
        return dto;
    }
}
