package com.ApiGateway.APIGateway.Filter;


import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {



    // this are open for anyone
    public static final List<String> openApiEndPoints = List.of(
            "api/v1/auth/register",
            "api/v1/auth/token",
            "eureka"
    );


    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndPoints
                    .stream()
                    .noneMatch(uri -> request
                            .getURI()
                            .getPath()
                            .contains(uri));
}
