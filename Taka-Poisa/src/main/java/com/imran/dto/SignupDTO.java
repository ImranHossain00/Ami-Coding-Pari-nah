package com.imran.dto;

import com.imran.annotations.PasswordEqual;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@PasswordEqual(
        first = "password",
        second = "confirmPassword",
        message = "password and confirm password do not match"
)
public class SignupDTO {
    @NotEmpty
    @Size(min = 2, max = 10)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 10)
    private String lastName;

    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 8, max = 40)
    private String password;
    @NotEmpty
    @Size(min = 8, max = 40)
    private String confirmPassword;


    public SignupDTO() {}
    public SignupDTO(String firstName,
                     String lastName,
                     String email,
                     String password,
                     String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
