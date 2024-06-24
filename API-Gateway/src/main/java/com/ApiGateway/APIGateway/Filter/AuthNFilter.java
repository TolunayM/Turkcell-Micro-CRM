package com.ApiGateway.APIGateway.Filter;


import com.ApiGateway.APIGateway.Util.JwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
public class AuthNFilter extends AbstractGatewayFilterFactory<AuthNFilter.Config> {

    private final RouteValidator routeValidator;
    private final JwtUtil jwtUtil;

    public AuthNFilter(RouteValidator routeValidator, JwtUtil jwtUtil) {
        super(Config.class);
        this.routeValidator = routeValidator;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {

            if(routeValidator.isSecured.test(exchange.getRequest())){
                if(!exchange.getRequest().getHeaders().containsKey("Authorization")) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    throw new RuntimeException("Authorization header is missing");
                }}

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).getFirst();

            if(authHeader != null && authHeader.startsWith("Bearer ")) {
                System.out.println("Auth Header: " + authHeader);
                authHeader = authHeader.substring(7);
            }

            try{
                jwtUtil.validateToken(authHeader);
            }catch (Exception e){
                throw new RuntimeException("Invalid Token");
            }

            
            return chain.filter(exchange);
        });
    }

    public static class Config {
    }
}
