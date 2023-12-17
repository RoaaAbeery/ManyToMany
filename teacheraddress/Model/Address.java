package com.example.teacheraddress.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Address {
    @Id
    private Integer id;
    @NotEmpty(message = "area should not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String area;
    @NotEmpty(message = "street should not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String street;
    @NotNull(message = "building Number should not be empty")
    @Positive(message = "building Number must be positive number")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
