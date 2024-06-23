package com.ApiGateway.APIGateway.Filter;


import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {




    public static final List<String> OPEN_ENDPOINTS = List.of(
            "api/v1/auth/register",
            "api/v1/auth/token",
            "eureka"
    );


    public Predicate<ServerHttpRequest> isSecured =
            request -> OPEN_ENDPOINTS
                    .stream()
                    .noneMatch(uri -> request
                            .getURI()
                            .getPath()
                            .contains(uri));
}
