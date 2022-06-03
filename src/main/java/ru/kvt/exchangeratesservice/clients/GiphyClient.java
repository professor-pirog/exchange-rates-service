package ru.kvt.exchangeratesservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "giphy",
        url = "${properties.giphy-api-url}"
)
public interface GiphyClient {

    @GetMapping("/random?api_key=${GIPHY_API_KEY}&tag=rich")
    Object getRandomRichGif();

    @GetMapping("/random?api_key=${GIPHY_API_KEY}&tag=broke")
    Object getRandomBrokeGif();

}
