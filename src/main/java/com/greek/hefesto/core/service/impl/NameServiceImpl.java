package com.greek.hefesto.core.service.impl;

import com.greek.hefesto.core.domain.NameDO;
import com.greek.hefesto.core.service.NameService;
import com.greek.hefesto.ports.output.gateway.NamePort;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Observed
@RequiredArgsConstructor
public class NameServiceImpl implements NameService {

    private final NamePort namePort;

    @Override
    public NameDO getNationalityByName(String name) {
        return namePort.getNationalityByName(name);
    }
}
