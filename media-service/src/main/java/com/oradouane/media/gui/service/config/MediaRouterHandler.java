package com.oradouane.media.gui.service.config;

import com.oradouane.media.gui.service.model.FsElement;
import com.oradouane.media.gui.service.services.FsElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
public class MediaRouterHandler {

    private final FsElementService fsElementService;

    @Autowired
    public MediaRouterHandler(FsElementService fsElementService) {
        this.fsElementService = fsElementService;
    }

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        final Flux<FsElement> allElements = Flux.fromIterable(fsElementService.findAll())
                // simulate network latency
                .delayElements(Duration.ofMillis(1000));
        allElements.subscribe(System.out::println);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(fromPublisher(allElements, FsElement.class));
    }

    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        return ServerResponse.ok().body(BodyInserters.fromObject("Hello"));
    }
}
