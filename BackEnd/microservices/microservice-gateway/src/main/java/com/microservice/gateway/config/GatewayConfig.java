package com.microservice.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@CrossOrigin(origins = "*")
@EnableHystrix
public class GatewayConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("microservice-student", r -> r.path("/api/student/**")
                        .filters(f -> f.filter(filter).stripPrefix(2))
                        .uri("http://localhost:8081/"))
                .route("microservice-administrator", r -> r.path("/api/gestion/**")
                        .filters(f -> f.filter(filter).stripPrefix(2))
                        .uri("http://localhost:8082/"))
                .route("microservice-security", r -> r.path("/api/security/**")
                        .filters(f -> f.filter(filter).stripPrefix(2))
                        .uri("http://localhost:8084/"))
                .route("microservice-registration", r -> r.path("/api/registration/**")
                        .filters(f -> f.filter(filter).stripPrefix(2))
                        .uri("http://localhost:8085/"))
                        
               
                .build();
    }

}
