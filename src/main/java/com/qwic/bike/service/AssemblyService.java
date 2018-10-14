package com.qwic.bike.service;

import com.qwic.bike.model.Production;

import java.util.List;

public interface AssemblyService {
    int getMaximumProductionCycle(List<Production> productions);
}
