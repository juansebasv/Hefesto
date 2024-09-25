package com.greek.hefesto.ports.output.gateway.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCountryProbabilityResponse {
    private String country_id;
    private double probability;
}
