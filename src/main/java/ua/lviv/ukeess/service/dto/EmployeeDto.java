package ua.lviv.ukeess.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmployeeDto {

    private Long id;

    @NotBlank
    private String name;

    private Boolean active;

    @NotBlank
    private String departmentName;
}
