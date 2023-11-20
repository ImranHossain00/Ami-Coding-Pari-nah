package com.imran.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {
    @NotEmpty
    @Size(min = 6, max = 32)
    private String username;
    @NotEmpty
    @Size(min = 8, max = 32)
    private String password;
    @NotEmpty
    @Size(min = 8, max = 32)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
