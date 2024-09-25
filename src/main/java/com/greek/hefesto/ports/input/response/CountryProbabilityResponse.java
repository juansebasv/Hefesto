package com.greek.hefesto.ports.input.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryProbabilityResponse {
    private String country_id;
    private double probability;
}
