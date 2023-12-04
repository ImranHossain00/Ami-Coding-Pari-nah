package com.imran.dto;


import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Map;

public class RestApiDTO {
    @NotEmpty
    private String userId;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String endingTime;
    private Map<LocalDateTime, String > listMap;
    private boolean status;

    public Map<LocalDateTime, String> getListMap() {
        return listMap;
    }

    public void setListMap(Map<LocalDateTime, String > listMap) {
        this.listMap = listMap;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }
}
