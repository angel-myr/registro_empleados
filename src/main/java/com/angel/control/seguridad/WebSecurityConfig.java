package com.tuempresa.seguridad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.angel.control.entidades.Usuario;
import com.angel.control.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UsuarioRepository usuariorep; // Repositorio de la entidad Usuario

    /**
     * Bean para encriptar contraseñas con BCrypt
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Función que convierte un objeto Usuario de la BD
     * en un objeto UserDetails que Spring Security entiende
     */
    private final Function<Usuario, UserDetails> convUsuario = obj -> {
        return User
                .withUsername(obj.getUsername())
                .password(obj.getPassword())   // Debe estar encriptada con BCrypt
                .roles(obj.getRoles())         // Ejemplo: "USER" o "ADMIN"
                .build();
    };

    /**
     * Se cargan los usuarios desde la base de datos y se convierten en UserDetails
     */
    @Bean
    protected UserDetailsService userDetailsService() {
        List<Usuario> relacion = usuariorep.findAll();

        Collection<UserDetails> registrados = relacion.stream()
                .map(convUsuario)
                .collect(Collectors.toCollection(ArrayList::new));

        return new InMemoryUserDetailsManager(registrados);
    }

    /**
     * Configuración de rutas y accesos
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desactiva CSRF para pruebas, en producción mejor mantenerlo activo
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/about").permitAll()
                        .requestMatchers("/form/*", "/eliminar/*", "/admin/*").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
}
