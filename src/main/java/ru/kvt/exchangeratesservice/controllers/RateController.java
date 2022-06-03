package ru.kvt.exchangeratesservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kvt.exchangeratesservice.dto.RateDto;
import ru.kvt.exchangeratesservice.services.RateService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/exchange-rates-service")
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;

    @PostMapping
    public Object checkRate(@RequestBody @Valid RateDto rateDto) {
        return rateService.checkRate(rateDto.getRate());
    }

}
