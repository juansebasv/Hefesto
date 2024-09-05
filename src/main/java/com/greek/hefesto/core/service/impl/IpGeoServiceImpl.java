package com.greek.hefesto.core.service.impl;

import com.greek.hefesto.core.domain.IpGeoDO;
import com.greek.hefesto.core.service.IpGeoService;
import com.greek.hefesto.ports.output.gateway.IpGeoPort;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Observed
@RequiredArgsConstructor
public class IpGeoServiceImpl implements IpGeoService {

    private final IpGeoPort ipGeoPort;

    @Override
    public IpGeoDO getIpGeoInfoByIp(String ip) {
        return ipGeoPort.getIpGeoInfoByIp(ip);
    }
}
