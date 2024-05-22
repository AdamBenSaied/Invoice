package com.example.Invoice.configuration;

import com.example.Invoice.repository.AdminRepository;
import com.example.Invoice.repository.CashierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ApplicationConfig {

    private final AdminRepository adminRepository;
    private final CashierRepository cashierRepository;

    @Autowired
    public ApplicationConfig(AdminRepository adminRepository, CashierRepository cashierRepository) {
        this.adminRepository = adminRepository;
        this.cashierRepository = cashierRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            if (adminRepository.existsByMail(username)) {
                return adminRepository.findByMail(username)
                        .map(admin -> (UserDetails) admin)
                        .orElseThrow(() -> new UsernameNotFoundException("Admin not found"));
            } else if (cashierRepository.existsByMail(username)) {
                return cashierRepository.findByMail(username)
                        .map(cashier -> (UserDetails) cashier)
                        .orElseThrow(() -> new UsernameNotFoundException("Cashier not found"));
            } else {
                throw new UsernameNotFoundException("User not found");
            }
        };
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }
}
