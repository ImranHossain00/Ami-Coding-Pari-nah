package com.imran.repository;

import com.imran.domain.NumberList;
import com.imran.domain.RESTApi;
import com.imran.domain.TimeAndDate;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Vector;

public interface NumberListRepository {
    void save(NumberList list);

    Vector<TimeAndDate> findByTimeAndUserId(RESTApi restApi);
}
