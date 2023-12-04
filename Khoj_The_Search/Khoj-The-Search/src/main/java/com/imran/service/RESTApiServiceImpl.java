package com.imran.service;

import com.imran.domain.RESTApi;
import com.imran.dto.RestApiDTO;
import com.imran.repository.NumberListRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.function.Predicate;
public class RESTApiServiceImpl implements RESTApiService {

    NumberListRepository numberListRepository;

    public RESTApiServiceImpl(NumberListRepository numberListRepository) {
        this.numberListRepository = numberListRepository;
    }

    @Override
    public void search(RestApiDTO restApiDTO) {

        var restApi = copyToRestApi(restApiDTO);
        numberListRepository.findByTimeAndUserId(restApi);

        restApiDTO.setStatus(!restApi.getListMap().isEmpty());
        restApiDTO.setListMap(restApi.getListMap());
    }

    @Override
    public boolean isCorrectFormate(String dateTime) {
        String formatter = "yyyy-MM-dd HH:mm:ss";
        try {

            LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(formatter));
            return true;
        } catch (Exception e ) {
            return false;
        }
    }

    private RESTApi copyToRestApi(RestApiDTO restApiDTO) {
        var restApi = new RESTApi();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        restApi.setUserId(Long.parseLong(restApiDTO.getUserId()));
        restApi.setStartTime(LocalDateTime.parse(restApiDTO.getStartTime(), formatter));
        restApi.setEndingTime(LocalDateTime.parse(restApiDTO.getEndingTime(), formatter));

        return restApi;
    }
}
