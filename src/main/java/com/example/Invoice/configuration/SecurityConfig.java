    package com.example.Invoice.configuration;


    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.Customizer;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.web.SecurityFilterChain;

    import static com.example.Invoice.constants.ENDPOINTS.AUTH_ENDPOINT;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .cors(Customizer.withDefaults())
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(
                            (authorize) -> authorize.requestMatchers("/" + AUTH_ENDPOINT + "/**")
                                    .permitAll()
                                    .anyRequest()
                                    .authenticated())
                    .sessionManagement(
                            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            return http.build();


        }
    }
