package com.imran.domain;

import java.time.LocalDateTime;
import java.util.Map;

public class RESTApi {
    private Long userId;
    private LocalDateTime startTime;
    private LocalDateTime endingTime;
    private Map<LocalDateTime, String> listMap;

    public RESTApi() {

    }

    public Map<LocalDateTime, String > getListMap() {
        return listMap;
    }

    public void setListMap(Map<LocalDateTime, String > listMap) {
        this.listMap = listMap;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalDateTime endingTime) {
        this.endingTime = endingTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
