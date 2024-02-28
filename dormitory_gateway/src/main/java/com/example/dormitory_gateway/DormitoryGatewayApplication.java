package com.example.dormitory_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class DormitoryGatewayApplication {

	public static void main(String[] args) {
        SpringApplication.run(DormitoryGatewayApplication.class, args);
    }
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder,
                                     @Value("${dormitory.room.url}") String roomUrl,
                                     @Value("${dormitory.student.url}") String studentUrl,
                                     @Value("${dormitory.gateway.host}") String host

    ) {
        System.out.println("roomUrl: " + roomUrl);
        System.out.println("studentUrl: " + studentUrl);
        System.out.println("host: " + host);
        return builder.routes()
                .route("dormitory_room", r -> r
                        .host(host)
                        .and()
                        .path("/api/rooms/{roomId}")
                        .or()
                        .path("/api/rooms")
                        .uri(roomUrl)
                )
                .route("dormitory_student", r -> r
                        .host(host)
                        .and()
                        .path("/api/students")
                        .or()
                        .path("/api/students/**")
                        .uri(studentUrl)
                )
                .build();
    }
    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
	}
