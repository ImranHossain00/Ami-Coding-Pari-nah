package com.imran.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ContactDTO {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Pattern(
            regexp = "^(?:\\+88|01)?\\d{11}",
            message = "Must be a valid Bangladeshi phone number"
    )
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
