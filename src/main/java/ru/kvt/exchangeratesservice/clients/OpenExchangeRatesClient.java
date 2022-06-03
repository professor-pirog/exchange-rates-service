package ru.kvt.exchangeratesservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "openexchangerates",
        url = "${properties.open-exchange-rates-api-url}"
)
public interface OpenExchangeRatesClient {

    @GetMapping("/latest.json?app_id=${OPEN_EXCHANGE_RATES_APP_ID}&base=${properties.compare-rate}")
    String getLatest();

    @GetMapping("/historical/{yesterdayDate}.json?app_id=${OPEN_EXCHANGE_RATES_APP_ID}&base=${properties.compare-rate}")
    String getYesterday(@PathVariable String yesterdayDate);

}
