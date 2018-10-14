package com.qwic.bike.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qwic.bike.model.Production;
import com.qwic.bike.service.AssemblyService;
import com.qwic.bike.util.ProductionTestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebFluxTest
public class AssemblyRestControllerTest {

    @Autowired
    private WebTestClient client;

    @MockBean
    private AssemblyService assemblyService;

    @Test
    public void whenGetMaximumProductCycle_thenVerifyProductions() throws Exception{
        List<Production> productions = ProductionTestUtils.getTestProductions();

        Map<String, Integer > responseMap = Collections.singletonMap("productionCycle", 3);
        Mockito.when(assemblyService.getMaximumProductionCycle(productions)).thenReturn(3);

        String response = "{\n" +
                "    \"productionCycle\" : 3\n" +
                "}";
        client.post().uri("/").contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(productions))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Map.class)
                .isEqualTo(responseMap);

    }


}
