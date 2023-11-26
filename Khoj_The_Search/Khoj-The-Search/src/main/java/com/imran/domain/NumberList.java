package com.imran.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberList extends Domain {
    private List<Integer> numberList = new ArrayList<>();

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
}
