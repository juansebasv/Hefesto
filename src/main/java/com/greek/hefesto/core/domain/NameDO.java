package com.greek.hefesto.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NameDO {

    private int count;
    private String name;
    private List<CountryProbabilityDO> country;
}
