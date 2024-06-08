package com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests;


import com.TurkcellSRS.CustomerService.Entity.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class AddCustomerRequest {

    @Positive
    @NotBlank(message = "This field is required")
    @Size(min = 11,max = 11)
    private Long nationalityId;

    @NotBlank(message = "This field is required") @Size(max=50)
    private String firstName;

    @Size(max = 50) @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String middleName;
    @NotBlank(message = "This field is required") @Size(max = 50)  @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @NotNull(message = "This field is required")
    private Date birthDate;
    @NotBlank(message = "This field is required")
    private String gender;
    @Size(max = 50) @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String fatherName;

    @Size(max = 50) @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String motherName;
}
