package com.greek.hefesto.ports.output.gateway.mapper;

import com.greek.hefesto.core.domain.IpGeoDO;
import com.greek.hefesto.ports.output.gateway.response.GetIpGeoInfoResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper interface for converting IP geolocation data between external and internal representations.
 * <p>
 * This mapper uses MapStruct for object mapping with the following configurations:
 * - Spring component model
 * - Constructor injection strategy
 * - Ignores unmapped target properties
 * </p>
 */
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface IpGeoWebClientMapper {

    /**
     * Converts the external IP geolocation response to the internal domain object.
     *
     * @param doRequestByIp The external IP geolocation response
     * @return The corresponding internal IP geolocation domain object
     */
    IpGeoDO buildUserDO(GetIpGeoInfoResponse doRequestByIp);
}