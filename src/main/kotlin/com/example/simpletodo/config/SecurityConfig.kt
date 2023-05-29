package com.example.simpletodo.config

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val configuration: AuthenticationConfiguration,
) {


    @Bean
    fun authenticationManager(): AuthenticationManager {
        return configuration.authenticationManager
    }


    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity ->
            web.ignoring().anyRequest() //모든 시큐리티 성문을 개방
        }
    }


}