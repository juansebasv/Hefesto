package com.greek.hefesto.ports.output.gateway;

import com.greek.hefesto.core.domain.IpGeoDO;

/**
 * Port interface for IP geolocation data retrieval operations.
 */
public interface IpGeoPort {

    /**
     * Fetches geolocation information for the specified IP address.
     *
     * @param ip The IP address to query.
     * @return An {@link IpGeoDO} containing the geolocation data.
     */
    IpGeoDO getIpGeoInfoByIp(String ip);
}