package com.imran.dto;

import javax.validation.constraints.NotEmpty;
import java.io.InputStream;

public class NIDInfoDTO {

    private InputStream photo;
    @NotEmpty
    private String name;
    @NotEmpty
    private String dob;
    @NotEmpty
    private String nidNumber;

    public InputStream getPhoto() {
        return photo;
    }

    public void setPhoto(InputStream photo) {
        this.photo = photo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNidNumber() {
        return nidNumber;
    }

    public void setNidNumber(String nidNumber) {
        this.nidNumber = nidNumber;
    }
}
