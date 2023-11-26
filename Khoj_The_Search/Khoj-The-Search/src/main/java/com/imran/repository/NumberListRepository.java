package com.imran.repository;

import com.imran.domain.NumberList;

import java.sql.Timestamp;
import java.util.Optional;

public interface NumberListRepository {
    void save(NumberList list);

    Optional<NumberList> findByTimeAndUserId(Timestamp sTime, Timestamp eTime, Long id);
}
