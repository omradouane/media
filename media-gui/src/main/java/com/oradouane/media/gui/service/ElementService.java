package com.oradouane.media.gui.service;

import com.oradouane.media.gui.model.FsElementVo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ElementService {

    private static final String MEDIAS_SERVICE_URL = "http://localhost:9090/media";

    private WebClient client = WebClient.create(MEDIAS_SERVICE_URL);

    public Flux<FsElementVo> finAll() {
        return client.get()
                .uri("/all")
                //.accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .flatMapMany(response -> response.bodyToFlux(FsElementVo.class));
    }
}
