package ru.kvt.exchangeratesservice.services;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kvt.exchangeratesservice.clients.GiphyClient;
import ru.kvt.exchangeratesservice.clients.OpenExchangeRatesClient;
import ru.kvt.exchangeratesservice.model.ExchangeRates;
import ru.kvt.exchangeratesservice.model.Rate;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final OpenExchangeRatesClient openExchangeRatesClient;

    private final GiphyClient giphyClient;

    @Override
    public Object checkRate(Rate rate) {
        Gson g = new Gson();
        BigDecimal latestRate = g.fromJson(openExchangeRatesClient.getLatest(), ExchangeRates.class).getRates().get(rate.toString());
        LocalDate yesterdayDate = LocalDate.now().minusDays(1);
        BigDecimal yesterdayRate = g.fromJson(openExchangeRatesClient.getYesterday(yesterdayDate.toString()), ExchangeRates.class).getRates().get(rate.toString());
        if (latestRate.compareTo(yesterdayRate) < 0) {
            return giphyClient.getRandomBrokeGif();
        }
        return giphyClient.getRandomRichGif();
    }

}
