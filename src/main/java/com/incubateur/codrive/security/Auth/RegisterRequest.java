package com.incubateur.codrive.security.Auth;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String password;
    private Boolean isDriver;
    private String mail;
    private Boolean actif;
    private LocalDate dateOfBirth;
    private Integer points;
    private Boolean isAdmin;
}
