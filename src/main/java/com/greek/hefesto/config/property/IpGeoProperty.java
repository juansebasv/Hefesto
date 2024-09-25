package com.greek.hefesto.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "hefesto")
public class IpGeoProperty {

    private Geolocate geolocate = new Geolocate();

    @Data
    public class Geolocate {
        private String ip;
    }
}
