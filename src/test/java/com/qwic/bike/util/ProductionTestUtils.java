package com.qwic.bike.util;

import com.qwic.bike.model.Production;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ProductionTestUtils {

    public static List<Production> getTestProductions(){
        return Arrays.asList(new Production(LocalDateTime.parse("2018-01-02T00:00:00.000"), 5),
                new Production(LocalDateTime.parse("2018-01-09T00:00:00.000"), 7),
                new Production(LocalDateTime.parse("2018-01-15T00:00:00.000"), 6),
                new Production(LocalDateTime.parse("2018-01-09T00:00:00.000"), 3));
    }

    public static List<Production> getSingleTestProduction(){
        return Arrays.asList(new Production(LocalDateTime.parse("2018-01-02T00:00:00.000"), 5));
    }
}
