package com.imran.service;

import com.imran.domain.NumberList;
import com.imran.dto.NumberListDTO;
import com.imran.repository.NumberListRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberListServiceImpl implements NumberListService{

    private NumberListRepository numberListRepository;

    public NumberListServiceImpl(NumberListRepository numberListRepository) {
        this.numberListRepository = numberListRepository;
    }

    @Override
    public void saveNumbers(NumberListDTO numberListDTO) {
        NumberList numberList = new NumberList();
        numberListRepository.save(numberList);
    }

    @Override
    public boolean searchTheNumber(NumberListDTO numberListDTO) {
        saveNumbers(numberListDTO);
        List<Integer> inputValues = convertParameters(numberListDTO.getInputValues());
        List<Integer> searchValues = convertParameters(numberListDTO.getSearchValue());
        return true;
    }

    private List<Integer> convertParameters(String searchValue) {
        List<Character> chars
                = searchValue
                .replaceAll(",", " ")
                .trim()
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toList());
        chars.add(' ');
        List<Integer> list = new ArrayList<>();
        StringBuilder tem = new StringBuilder();

        for (char c : chars) {
            if (c == ' ' && tem.length() > 0) {
                list.add(Integer.parseInt(tem.toString()));
                tem = new StringBuilder();
            }
            else if (c != ' ')
                tem.append(c);
        }

        return list;
    }
}
