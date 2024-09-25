package com.greek.hefesto.ports.output.gateway.mapper;

import com.greek.hefesto.core.domain.NameDO;
import com.greek.hefesto.ports.output.gateway.response.GetNameResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper interface for converting name-related data between external response and internal domain objects.
 * <p>
 * This mapper is configured using MapStruct with the following settings:
 * - Spring component model for integration with Spring framework
 * - Constructor-based dependency injection
 * - Ignores any unmapped properties in the target object
 * </p>
 */
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface NameWebClientMapper {

    /**
     * Converts an external name response to an internal name domain object.
     *
     * @param getNameResponse The external response containing name-related data
     * @return A {@link NameDO} object representing the name information in the internal domain model
     */
    NameDO buildUserDO(GetNameResponse getNameResponse);
}