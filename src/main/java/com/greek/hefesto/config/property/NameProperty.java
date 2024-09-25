package com.greek.hefesto.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "hefesto")
public class NameProperty {

    private Discover discover = new Discover();

    @Data
    public class Discover {
        private String name;
    }
}
