package br.com.fiap.ibike.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        // rotas públicas (login, cadastro, Swagger, H2, recursos estáticos)
                        .requestMatchers("/login", "/logout", "/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**", "/css/**", "/js/**").permitAll()

                        // rotas que só ADMIN pode acessar
                        .requestMatchers("/administrador/**").hasRole("ADMIN")

                        // rotas que só USER pode acessar
                        .requestMatchers("/moto/**", "/patio/**").hasRole("USER")

                        // qualquer outra rota precisa estar autenticada
                        .anyRequest().authenticated()
                )
                // login com formulário do Thymeleaf
                .formLogin(form -> form
                        .loginPage("/login")          // URL do seu formulário de login (login.html no templates)
                        .defaultSuccessUrl("/home", true) // para onde redirecionar após login com sucesso
                        .permitAll()
                )
                // logout configurado
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                // desabilitar CSRF para H2 e permitir uso de iframe
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
