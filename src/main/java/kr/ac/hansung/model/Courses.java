package kr.ac.hansung.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "년도를 입력해주세요.")
    @Min(value = 2020, message = "2020년 이후의 년도만 입력 가능합니다.")
    private int year;

    @NotNull(message = "학기를 입력해주세요.")
    @Min(value = 1, message = "1 또는 2만 입력 가능합니다.")
    @Max(value = 2, message = "1 또는 2만 입력 가능합니다.")
    private int semester;

    @Id
    @NotNull(message = "과목 코드를 입력해주세요.")
    @Size(min = 4, max = 8, message = "과목 코드는 4-8자 사이여야 합니다.")
    @Column(name = "course_code")
    private String courseCode;

    @NotNull(message = "과목명을 입력해주세요.")
    @Size(min = 2, max = 20, message = "과목명은 2-20자 사이여야 합니다.")
    @Column(name = "course_name")
    private String courseName;

    @NotNull(message = "과목 구분을 선택해주세요.")
    @Size(min = 2, max = 20, message = "과목 구분은 2-20자 사이여야 합니다.")
    @Column(name = "course_type")
    private String courseType;

    @NotNull(message = "담당교수를 입력해주세요.")
    @Size(min = 2, max = 20, message = "담당교수명은 2-20자 사이여야 합니다.")
    private String professor;

    @NotNull(message = "학점을 선택해주세요.")
    @Min(value = 1, message = "학점은 1-3 사이여야 합니다.")
    @Max(value = 3, message = "학점은 1-3 사이여야 합니다.")
    private int credit;
}