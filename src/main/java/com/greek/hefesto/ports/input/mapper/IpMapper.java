package com.greek.hefesto.ports.input.mapper;

import com.greek.hefesto.core.domain.IpGeoDO;
import com.greek.hefesto.ports.input.response.IpResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface IpMapper {

    IpResponse requestToDomain(IpGeoDO ipGeoInfo);
}
