package com.imran.dto;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class NumberListDTO {

    @NotEmpty
    private String inputValues;
    @NotEmpty
    private String searchValue;

    private LocalDateTime insertionTime
            = LocalDateTime.now();

    public LocalDateTime getInsertionTime() {
        return insertionTime;
    }

    public void setInsertionTime(LocalDateTime insertionTime) {
        this.insertionTime = insertionTime;
    }

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
