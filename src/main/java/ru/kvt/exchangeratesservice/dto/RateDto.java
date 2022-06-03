package ru.kvt.exchangeratesservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kvt.exchangeratesservice.model.Rate;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class RateDto {

    @NotNull
    private Rate rate;

}
