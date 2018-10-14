package com.qwic.bike.service;

import com.qwic.bike.model.Production;
import com.qwic.bike.service.Impl.AssemblyServiceImpl;
import com.qwic.bike.util.ProductionTestUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AssemblyServiceTest {


    private AssemblyServiceImpl assemblyService = new AssemblyServiceImpl();

    @Test
    public void whenGetMaximumProductionCycle_VerifyProductionCounter(){
        List<Production> productions = ProductionTestUtils.getTestProductions();
        int productionCounter = assemblyService.getMaximumProductionCycle(productions);

        Assertions.assertThat(productionCounter).isEqualTo(3);


    }

    @Test
    public void whenGetMaximumProductionCycle_VerifyEmptyProductions(){
        List<Production> productions = Collections.emptyList();
        int productionCounter = assemblyService.getMaximumProductionCycle(productions);

        Assertions.assertThat(productionCounter).isEqualTo(0);


    }

    @Test
    public void whenGetMaximumProductionCycle_VerifySingleProduction(){
        List<Production> productions = ProductionTestUtils.getSingleTestProduction();
        int productionCounter = assemblyService.getMaximumProductionCycle(productions);

        Assertions.assertThat(productionCounter).isEqualTo(1);
    }
}
