package com.qwic.bike.controller;
/**
 *
 * @author afatima
 * @Desc Rest controller for qwic bike production
 */

import com.qwic.bike.controller.validation.BikeValidator;
import com.qwic.bike.model.Production;
import com.qwic.bike.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AssemblyRestController {

    @Autowired
    private AssemblyService assemblyService;

    @PostMapping(path="/")
    public Map<String, Integer> getMaximumProductionCycle(@RequestBody List<Production> productions){
        BikeValidator.validateProductions(productions);
        int productionCycle = assemblyService.getMaximumProductionCycle(productions);
        return Collections.singletonMap("productionCycle", productionCycle);
    }
}
