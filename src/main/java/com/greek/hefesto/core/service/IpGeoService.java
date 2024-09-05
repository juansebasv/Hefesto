package com.greek.hefesto.core.service;

import com.greek.hefesto.core.domain.IpGeoDO;

/**
 * Service interface for retrieving geographical information based on IP addresses.
 * <p>
 * This service provides functionality to obtain geolocation data for given IP addresses,
 * which can be useful for various applications such as content localization, fraud detection,
 * and traffic analysis.
 * </p>
 *
 * @since 1.0
 * @see IpGeoDO
 */
public interface IpGeoService {

    /**
     * Retrieves geographical information for a given IP address.
     * <p>
     * This method queries a geolocation database or service to obtain information
     * about the physical location associated with the provided IP address. The returned
     * data may include details such as country, region, city, latitude, longitude,
     * and other relevant geospatial information.
     * </p>
     *
     * @param ip The IP address to look up, as a String. This should be a valid IPv4 or IPv6 address.
     * @return An {@link IpGeoDO} object containing the geographical information
     *         associated with the given IP address. If the IP address is not found
     *         or cannot be geolocated, the returned object may contain default or
     *         null values for some fields.
     * @throws IllegalArgumentException if the provided IP address is null, empty, or not properly formatted.
     * @throws GeolocationException if there's an error in the geolocation service or database.
     */
    IpGeoDO getIpGeoInfoByIp(String ip);
}