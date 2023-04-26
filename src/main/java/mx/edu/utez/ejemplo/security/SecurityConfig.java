package mx.edu.utez.ejemplo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("ADMINISTRADOR")// reciben un numero indeterminado de roles separados por comas y con comillas
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("capturista")
                .password("123")
                .roles("CAPTURISTA")
                .build();
        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("cliente")
                .password("123")
                .roles("CLIENTE")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,user3);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().
                requestMatchers("/","assets/**").permitAll()
                .requestMatchers("capturistas").hasAnyRole("ADMINISTRADOR")
                .requestMatchers("productos").hasAnyRole("CLIENTE","ANONYMOUS")
                .requestMatchers("pedidos").hasAnyRole("CAPTURISTA","ADMINISTRADOR","CLIENTE")
                .requestMatchers("clientes").hasAnyRole("ADMINISTRADOR","CAPTURISTA")
                .requestMatchers("registro").hasAnyRole("ANONYMOUS")
                .anyRequest().authenticated();

        http.formLogin().permitAll(); 
        return http.build();
    }
}
