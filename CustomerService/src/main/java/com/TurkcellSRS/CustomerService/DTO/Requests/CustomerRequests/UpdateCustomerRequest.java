package com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateCustomerRequest {

    @Positive
    @NotBlank(message = "This field is required")
    @Digits(integer = 11, fraction = 0)
    private Long nationalityId;

    @NotBlank(message = "This field is required") @Size(max=50)
    private String firstName;

    @Size(max = 50) @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String middleName;
    @NotBlank(message = "This field is required") @Size(max = 50)  @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String lastName;

    @NotBlank(message = "This field is required")
    private Date birthDate;

    @NotBlank(message = "This field is required")
    private String gender;
    @Size(max = 50) @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String fatherName;

    @Size(max = 50) @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String motherName;
}
