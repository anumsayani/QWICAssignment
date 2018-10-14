package com.qwic.bike.controller.validation;

import com.qwic.bike.model.Production;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BikeValidator{

    public static void validateProductions(List<Production> productions){
        if(productions == null || productions.isEmpty() || productions.size() >= 100000){
            throw new IllegalArgumentException("Productions empty or invalid");
        }

        productions.stream().forEach(o -> isValid(o));
    }

    private static void isValid(Production production){
        if(production.getDuration() <= 0 || production.getDuration() >= 1000){
            throw new IllegalArgumentException("Invalid Production duration");
        }

        if(production.getStartingDay().isAfter(LocalDateTime.now())){
            throw new IllegalArgumentException("Invalid Starting Date");
        }
    }

}
