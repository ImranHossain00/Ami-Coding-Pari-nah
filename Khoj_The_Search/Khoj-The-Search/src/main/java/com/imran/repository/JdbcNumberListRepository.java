package com.imran.repository;

import com.imran.domain.NumberList;

import java.sql.Timestamp;
import java.util.Optional;

public class JdbcNumberListRepository implements NumberListRepository{
    @Override
    public void save(NumberList list) {

    }

    @Override
    public Optional<NumberList> findByTimeAndUserId(Timestamp sTime, Timestamp eTime, Long id) {
        return Optional.empty();
    }
}
