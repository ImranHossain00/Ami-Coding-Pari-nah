package com.imran.dto;

import javax.validation.constraints.NotEmpty;

public class AddressDTO {
    @NotEmpty
    private String road;
    @NotEmpty
    private String thana;
    @NotEmpty
    private String district;
    @NotEmpty
    private String division;

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getThana() {
        return thana;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
