package com.example.teacheraddress.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    @NotNull(message = "teacher_id should not be empty")
    private Integer teacher_id;
    @NotEmpty(message = "area should not be empty")
    private String area;
    @NotEmpty(message = "street should not be empty")
    private String street;
    @NotNull(message = "building Number should not be empty")
    @Positive(message = "building Number must be positive number")
    private Integer buildingNumber;
}
