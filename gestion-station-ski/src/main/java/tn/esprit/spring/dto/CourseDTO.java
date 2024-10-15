
package tn.esprit.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long numCourse; // Identifiant du cours
    private int level; // Niveau du cours
    private String typeCourse; // Type de cours (par exemple, COLLECTIVE_CHILDREN, COLLECTIVE_ADULT, INDIVIDUAL)
    private String support; // Support du cours (par exemple, SKI, SNOWBOARD)
    private Float price; // Prix du cours
    private int timeSlot; // Plage horaire du cours
}
