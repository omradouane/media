package com.oradouane.media.gui.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class MediaRouter {

    @Bean
    public RouterFunction<ServerResponse> route(MediaRouterHandler mediaRouterHandler) {
        return RouterFunctions.route(GET("/media/all").and(accept(APPLICATION_JSON)), mediaRouterHandler::findAll)
                .andRoute(GET("/hello"), mediaRouterHandler::hello);
    }
}
