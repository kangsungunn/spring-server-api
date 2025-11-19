package site.kroaddy.eureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * Eureka Server CORS 설정
 * Eureka 대시보드 접근을 위한 CORS 허용
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();

        // 허용할 Origin 설정
        corsConfig.setAllowedOrigins(Arrays.asList(
                "http://localhost:3000",
                "http://nextjs-ui-server:3000",
                "http://localhost:8080",
                "http://localhost:8761")); // Eureka 대시보드 자체

        // 허용할 HTTP 메서드
        corsConfig.setAllowedMethods(Arrays.asList(
                "GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));

        // 허용할 헤더
        corsConfig.setAllowedHeaders(Arrays.asList("*"));

        // Credentials 허용
        corsConfig.setAllowCredentials(true);

        // Preflight 요청 캐시 시간
        corsConfig.setMaxAge(3600L);

        // 모든 경로에 적용
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }
}

