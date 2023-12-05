package com.imran.dto;


import java.util.List;

public class PayloadDTO {
    String  timestamp;
    String input_values;

    public PayloadDTO(){}
    public PayloadDTO(String timestamp, String input_values) {
        this.timestamp = timestamp;
        this.input_values = input_values;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getInput_values() {
        return input_values;
    }

    public void setInput_values(String input_values) {
        this.input_values = input_values;
    }
}
