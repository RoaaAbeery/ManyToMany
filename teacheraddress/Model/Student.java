package com.example.teacheraddress.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    private String name;
    @NotNull(message = "age should not be empty")
    @Positive(message = "age must be positive number")
    private Integer age;
    @NotEmpty(message = "major should not be empty")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> course;
}
