package com.greek.hefesto.ports.output.gateway.impl;

import com.greek.hefesto.config.property.IpGeoProperty;
import com.greek.hefesto.core.domain.IpGeoDO;
import com.greek.hefesto.ports.output.gateway.IpGeoPort;
import com.greek.hefesto.ports.output.gateway.mapper.IpGeoWebClientMapper;
import com.greek.hefesto.ports.output.gateway.response.GetIpGeoInfoResponse;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Slf4j
@Service
@Observed
public class IpGeoWebClientAdapter implements IpGeoPort {

    private final WebClient webClient;
    private final IpGeoWebClientMapper ipGeoWebClientMapper;
    private final IpGeoProperty ipGeoProperty;

    public IpGeoWebClientAdapter(WebClient.Builder webClientBuilder, IpGeoWebClientMapper ipGeoWebClientMapper, IpGeoProperty ipGeoProperty) {
        this.webClient = webClientBuilder.build();
        this.ipGeoWebClientMapper = ipGeoWebClientMapper;
        this.ipGeoProperty = ipGeoProperty;
    }

    @Override
    public IpGeoDO getIpGeoInfoByIp(String ip) {
        log.info("Retrieving geolocation information for IP: {}", ip);
        try {
            GetIpGeoInfoResponse response = doRequestByIp(ip);
            IpGeoDO result = ipGeoWebClientMapper.buildUserDO(response);
            log.debug("Successfully mapped geolocation response to domain object for IP: {}", ip);
            return result;
        } catch (Exception e) {
            log.error("Failed to retrieve geolocation information for IP: {}", ip, e);
            throw e;
        }
    }

    private GetIpGeoInfoResponse doRequestByIp(String ip) {
        log.debug("Preparing API request for IP: {}", ip);
        var urlParam = Map.of("ip", ip);
        String uri = UriComponentsBuilder.fromHttpUrl(ipGeoProperty.getGeolocate().getIp())
                .buildAndExpand(urlParam)
                .toUriString();
        log.debug("Constructed URI for geolocation request: {}", uri);

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(GetIpGeoInfoResponse.class)
                .doOnSubscribe(subscription -> log.info("Initiating geolocation API request for IP: {}", ip))
                .doOnSuccess(response -> log.info("Successfully received geolocation data for IP: {}", ip))
                .onErrorMap(ex -> {
                    log.error("Error occurred while fetching geolocation data for IP: {}. Error: {}", ip, ex.getMessage());
                    return new Exception("Failed to retrieve geolocation information", ex);
                })
                .block();
    }
}