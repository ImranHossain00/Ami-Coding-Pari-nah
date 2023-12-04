package com.imran.repository;

import com.imran.domain.NumberList;
import com.imran.domain.RESTApi;

import java.sql.Timestamp;
import java.util.Optional;

public interface NumberListRepository {
    void save(NumberList list);

    void findByTimeAndUserId(RESTApi restApi);
}
