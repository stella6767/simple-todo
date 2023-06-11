package com.example.simpletodo.config


import com.example.simpletodo.config.security.OAuth2DetailsService
import com.example.simpletodo.util.logger
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import java.io.IOException


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val configuration: AuthenticationConfiguration,
    private val oAuth2DetailsService: OAuth2DetailsService,
) {



    @Bean
    fun authenticationManager(): AuthenticationManager {
        return configuration.authenticationManager
    }


    //@Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity ->
            web.ignoring().anyRequest() //모든 시큐리티 성문을 개방
        }
    }


    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        // @formatter:off
        http.csrf { csrf -> csrf.disable() }


        http
            .authorizeHttpRequests { authorizeHttpRequests ->
                authorizeHttpRequests
                    .requestMatchers(*AUTH_PASS_LIST)
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
//            .formLogin { form ->
//                form.loginPage("/login/modal")
//                    .loginProcessingUrl("/login")
//
//            }

            .logout{
                it.logoutUrl("/logout")
                it.logoutSuccessHandler(OauthLogoutSuccessHandler())
            }	// 로그아웃은 기본설정으로 (/logout으로 인증해제)
            .headers {
                it.frameOptions().sameOrigin()
            }
            .oauth2Login { oauth ->
                oauth
                    .authorizationEndpoint {
                        it.baseUri("/oauth2/authorization")
                            //.authorizationRequestRepository(authorizationRequestRepository()) //default session repository
                    }
                    .redirectionEndpoint {
                        it.baseUri("/oauth2/callback/*")
                    }
                    .userInfoEndpoint{
                        it.userService(oAuth2DetailsService)
                    }
                    .defaultSuccessUrl("/")
                    .successHandler(OauthLoginSuccessHandler())
                    //.failureHandler()
            }



        return http.build()

    }


    class OauthLogoutSuccessHandler : LogoutSuccessHandler {

        private val log = logger()
        override fun onLogoutSuccess(
            request: HttpServletRequest,
            response: HttpServletResponse,
            authentication: Authentication?
        ) {

            log.info("logout success")

            request.session.invalidate()

            response.sendRedirect("/")

        }

    }

    class OauthLoginSuccessHandler : AuthenticationSuccessHandler {

        override fun onAuthenticationSuccess(
            request: HttpServletRequest, response: HttpServletResponse,
            authentication: Authentication
        ) {
            val userDetails = authentication.principal as UserDetails
            val SESSION_TIMEOUT_IN_SECONDS = 60 * 120 //단위는 초, 2시간 간격으로 세션만료
            request.session.maxInactiveInterval = SESSION_TIMEOUT_IN_SECONDS //세션만료시간.

            response.sendRedirect("/")
        }
    }


    companion object {

        val AUTH_PASS_LIST = arrayOf(
            "/public/**", "/webjars/**", "/", "/logout", "/api/**", "/login", "/h2-console/**",
            "/error",
            "/logout",
            "/login/**",
            "/oauth2/authorization/**",
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