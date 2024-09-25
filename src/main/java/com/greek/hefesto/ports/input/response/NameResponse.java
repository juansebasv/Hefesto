package com.greek.hefesto.ports.input.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameResponse {
    private int count;
    private String name;
    private List<CountryProbabilityResponse> country;
}
