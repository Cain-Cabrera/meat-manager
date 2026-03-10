package com.caincabrera.meat_manager.client.infrastructure.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Builder
@Data
public class ClientDto {

    @NotBlank(message = "first name is required")
    private String firstname;

    @NotBlank(message = "last name is required")
    private String lastName;

    @NotBlank(message = "dni is required")
    @Length(min = 8, max = 8)
    private String dni;

    @NotBlank(message = "email name is required")
    @Email(message = "invalid email format")
    private String email;

    @Positive
    @Min(value = 14, message = "minimum age 14 years old")
    private int age;
}
