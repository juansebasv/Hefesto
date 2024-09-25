package com.greek.hefesto.ports.output.gateway.impl;

import com.greek.hefesto.config.property.NameProperty;
import com.greek.hefesto.core.domain.NameDO;
import com.greek.hefesto.ports.output.gateway.NamePort;
import com.greek.hefesto.ports.output.gateway.mapper.NameWebClientMapper;
import com.greek.hefesto.ports.output.gateway.response.GetNameResponse;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Slf4j
@Service
@Observed
public class NameWebClientAdapter implements NamePort {

    private final WebClient webClient;
    private final NameWebClientMapper nameWebClientMapper;
    private final NameProperty nameProperty;

    public NameWebClientAdapter(WebClient.Builder webClientBuilder, NameWebClientMapper nameWebClientMapper, NameProperty nameProperty) {
        this.webClient = webClientBuilder.build();
        this.nameWebClientMapper = nameWebClientMapper;
        this.nameProperty = nameProperty;
    }

    @Override
    public NameDO getNationalityByName(String name) {
        log.info("Retrieving nationality information for name: {}", name);
        GetNameResponse response = doRequestByIp(name);
        log.info("Received response from API: {}", response);
        NameDO result = nameWebClientMapper.buildUserDO(response);
        log.info("Successfully mapped API response to NameDO for name: {}", name);
        return result;
    }

    private GetNameResponse doRequestByIp(String name) {
        log.info("Initiating API call to retrieve nationality information for name: {}", name);
        var urlParam = Map.of("name", name);
        String uri = UriComponentsBuilder.fromHttpUrl(nameProperty.getDiscover().getName())
                .buildAndExpand(urlParam)
                .toUriString();
        log.info("Constructed URI for API call: {}", uri);

        try {
            GetNameResponse response = webClient.get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(GetNameResponse.class)
                    .block();
            log.info("Successfully retrieved nationality information for name: {}", name);
            return response;
        } catch (Exception ex) {
            log.error("Error occurred while retrieving nationality information for name: {}. Error details: {}", name, ex.getMessage());
            log.debug("Full stack trace:", ex);
            throw new RuntimeException("Error retrieving nationality information", ex);
        }
    }
}