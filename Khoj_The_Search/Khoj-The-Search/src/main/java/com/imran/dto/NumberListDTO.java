package com.imran.dto;

import javax.validation.constraints.NotEmpty;

public class NumberListDTO {

    @NotEmpty
    private String inputValues;
    @NotEmpty
    private String searchValue;


    public String getInputValues() {
        return inputValues;
    }

    public void setInputValues(String inputValues) {
        this.inputValues = inputValues;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
