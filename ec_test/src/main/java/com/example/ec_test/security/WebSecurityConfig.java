package com.example.ec_test.security;


import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {

    /**
     * Configuración
     * deshabilitar > Cross Site Request Forgery (CSRF)-> falsificación de solicitudes entre sitios.
     *      ** .csrf().disable().
     * Todas las request requieren autenticación.
     *      ** .anyRequest().authenticated()
     * Permite autenticación básica Http, usuario / contraseña.
     *      ** .httpBasic()
     * Política de cesiones sin estado inicial (STATELESS).
     * STATELESS - Spring Security nunca creará una HttpSession y nunca la usará para obtener el
     *      ** .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
     */
    @Bean
    SecurityFilterChain filterChain(
            HttpSecurity http,
            AuthenticationManager authManager
    )
            throws Exception
    {
        return http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();
    }

    /**
     * Secuencia de autenticación.
     *   ** Requiere un método userDetailService.
     *   ** Codificación de contraseña.
     */
    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsServices())
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    /**
     * Secuencia para crear usuario.
     * @Return Un objeto UserDetailsService
     */
    @Bean
    UserDetailsService userDetailsServices(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles()
                .build()
        );
        return manager;
    }

    /**
     * Método de codificación (BCrypt).
     */
    @Bean
    PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
}