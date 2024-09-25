package com.greek.hefesto.ports.input.mapper;

import com.greek.hefesto.core.domain.NameDO;
import com.greek.hefesto.ports.input.response.NameResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface NameMapper {

    NameResponse requestToDomain(NameDO nameDO);
}
