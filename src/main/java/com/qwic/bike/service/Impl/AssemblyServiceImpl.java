package com.qwic.bike.service.Impl;

import com.qwic.bike.model.Production;
import com.qwic.bike.service.AssemblyService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssemblyServiceImpl implements AssemblyService {


    @Override
    public int getMaximumProductionCycle(List<Production> productions) {

        //check if there's only single production
        if(productions.size() <= 1){
            return productions.size();
        }

        //sort the intervals
        productions = productions.stream().sorted(Comparator.comparing(Production::getEndDay,
                (s1, s2) -> s1.compareTo(s2))).collect(Collectors.toList());

        //iterate the intervals to find the valid production cycles
        int i = 0;
        int productionCycle = 1;
        for(int j = 1; j < productions.size(); j++){
            if(productions.get(i).getEndDay().isBefore(productions.get(j).getStartingDay())){
                productionCycle++;
                i = j;
            }
        }

        System.out.println("Production counter is :" + productionCycle);

        return productionCycle;
    }
}
