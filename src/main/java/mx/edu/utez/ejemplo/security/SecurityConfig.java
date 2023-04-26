package mx.edu.utez.ejemplo.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.ejemplo.model.Login;
import mx.edu.utez.ejemplo.service.LoginService;
import mx.edu.utez.ejemplo.service.StaticLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    private LoginService service;
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
        final String Administrador = "ADMINISTRADOR";
        final String Cliente = "CLIENTE";
        final String Capturista = "CAPTURISTA";
        final String Anonimo = "ANONYMOUS";

        http.authorizeHttpRequests().
                requestMatchers("/","assets/**","/bitacora").permitAll()
                .requestMatchers("/capturistas").hasAnyRole(Administrador)
                .requestMatchers("/productos").hasAnyRole(Cliente,Anonimo)
                .requestMatchers("/pedidos").hasAnyRole(Capturista,Administrador,Cliente)
                .requestMatchers("/clientes").hasAnyRole(Administrador,Capturista)
                .requestMatchers("/registro").hasAnyRole(Anonimo)
                .anyRequest().authenticated();

        http.formLogin()
                .permitAll()
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        Login login = new Login( authentication.getName(),request.getRemoteAddr());
                        service.save(login);
                        response.sendRedirect("/");
                    }
                })
        ;
        return http.build();
    }
}
