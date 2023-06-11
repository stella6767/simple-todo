package com.example.simpletodo.config

import com.example.simpletodo.config.security.OAuth2DetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig(
    //private val configuration: AuthenticationConfiguration,
    private val oAuth2DetailsService: OAuth2DetailsService,
) {



//    @Bean
//    fun oAuth2DetailsService(): OAuth2DetailsService {
//
//        return OAuth2DetailsService(
//            userRepository, encode(), mapper
//        )
//    }


//    @Bean
//    fun authenticationManager(): AuthenticationManager {
//        return configuration.authenticationManager
//    }


    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity ->
            web.ignoring().anyRequest() //모든 시큐리티 성문을 개방
        }
    }


    @Bean
    fun inMemoryOAuth2AuthorizedClientService(clientRegistrationRepository:ClientRegistrationRepository): OAuth2AuthorizedClientService {

        return InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository)
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        // @formatter:off
        //http.csrf { csrf -> csrf.disable() }

        http
            .csrf()
            .disable()
            .authorizeHttpRequests()
            .anyRequest()
            .authenticated()
            .and()
            .oauth2Login()


//        http
//            .authorizeHttpRequests { authorizeHttpRequests ->
//                authorizeHttpRequests
//                    .requestMatchers(*AUTH_PASS_LIST)
//                    .permitAll()
//                    .anyRequest()
//                    .authenticated()
//            }
//            .formLogin { form ->
//                form.loginPage("/login/Modal")
//                    .loginProcessingUrl("/login")
//
//            }
//            .logout(withDefaults())	// 로그아웃은 기본설정으로 (/logout으로 인증해제)
//            .headers {
//                it.frameOptions().sameOrigin()
//            }
//            .oauth2Login { oauth ->
//                oauth
//                    .authorizationEndpoint {
//                        it.baseUri("/oauth2/authorize")
//                            //.authorizationRequestRepository(authorizationRequestRepository()) //default session repository
//                    }
//                    .redirectionEndpoint {
//                        it.baseUri("/oauth2/callback/*")
//                    }
//                    .userInfoEndpoint{
//                        it.userService(oAuth2DetailsService)
//                    }
//                    //.successHandler()
//                    //.failureHandler()
//            }



        return http.build()

    }




    companion object {

        val AUTH_PASS_LIST = arrayOf(
            "/public/**", "/webjars/**", "/", "/logout", "/api/**", "/login", "/h2-console/**",
            "/error",
            "/favicon.ico",
            "/**/*.png",
            "/**/*.gif",
            "/**/*.svg",
            "/**/*.jpg",
            "/**/*.html",
            "/**/*.css",
            "/**/*.js"

        )

    }




}