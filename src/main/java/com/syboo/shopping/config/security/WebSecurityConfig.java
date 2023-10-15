package com.syboo.shopping.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

/**
 * <pre>
 * PackageName : com.syboo.shopping.common.security
 * FileName : WebSecurityConfig
 * Description:
 * ================================================================
 * DATE              AUTHOR        NOTE
 * ----------------------------------------------------------------
 * 2023-10-01        부시연        최초 생성
 * 2023-10-03        부시연        cors 설정 ApplicationConfig 로 이동
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    /* 접근 권한 설정 */
    @Bean
    protected SecurityFilterChain webSecurityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(mvcMatcherBuilder.pattern("/public/**")).permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/api/v1/**")).hasAnyRole("USER", "ADMIN")
                        .requestMatchers(mvcMatcherBuilder.pattern("/api/admin")).hasRole("ADMIN")
                        .anyRequest().authenticated())
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                /* CSRF 설정 Disable */
                .csrf(CsrfConfigurer::disable)
                .cors(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
        ;


        return http.build();
    }

}
