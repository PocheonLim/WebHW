package kr.ac.hansung.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Courses {

    @NotNull
    private int year;

    @NotNull
    private int semester;

    @Id
    @NotNull
    @Size(max = 20)
    @Column(name = "course_code")
    private String courseCode;

    @NotNull
    @Size(max = 100)
    @Column(name = "course_name")
    private String courseName;

    @NotNull
    @Size(max = 50)
    @Column(name = "course_type")
    private String courseType;

    @NotNull
    @Size(max = 50)
    private String professor;

    @NotNull
    private int credit;
}