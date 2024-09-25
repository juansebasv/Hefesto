package com.greek.hefesto.ports.output.gateway.response;

import com.greek.hefesto.ports.input.response.CountryProbabilityResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetNameResponse {
    private int count;
    private String name;
    private List<CountryProbabilityResponse> country;
}
