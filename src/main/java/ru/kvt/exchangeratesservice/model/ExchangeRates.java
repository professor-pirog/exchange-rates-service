package ru.kvt.exchangeratesservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@NoArgsConstructor
public class ExchangeRates {

    private String disclaimer;

    private String license;

    private Integer timestamp;

    private String base;

    private Map<String, BigDecimal> rates;

}
