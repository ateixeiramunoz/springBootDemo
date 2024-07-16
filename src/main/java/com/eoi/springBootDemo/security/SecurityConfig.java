package com.eoi.springBootDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    http.formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/")
                .permitAll()
        );
    //cierre de sesión
        http.logout(logout -> logout
            .logoutUrl("/usuarios/logout")
            .logoutSuccessUrl("/")
        );


    //Página de Acceso Denegado
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")

    //Desactivación de CSRF y CORS
                .and()
                .csrf().disable()
                .cors().disable()
                .authenticationProvider(authenticationProvider());

        return http.build();



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //Creamos la proteccion csrf
        http.csrf(
                Customizer.withDefaults()
                ).authorizeHttpRequests(
                     authorize -> authorize.anyRequest().authenticated()
                )
                .httpBasic(
                        Customizer.withDefaults()
                ).formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                );

        http.logout(logout -> logout
                .logoutUrl("/usuarios/logout")
                .logoutSuccessUrl("/")
        );

        // Autorización de Solicitudes
        http.authorizeHttpRequests()
                .requestMatchers("/js/**").permitAll()
                .requestMatchers("/img/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/fonts/**").permitAll()
                .requestMatchers("/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/**").permitAll()
                .anyRequest().authenticated();
        return http.build();
    }

    //Ejemplo 2 UserDetailsService Basico para ejemplo
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }





    //



}