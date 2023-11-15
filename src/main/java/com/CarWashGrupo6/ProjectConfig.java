package com.CarWashGrupo6;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //si alguine va a la ruta / , devuelva la vista index(no tiene logica)
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        //registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }

    //metodo para saber a que tiene permiso cada cosa
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request //autorize los siguientes requests a cualquier user(autenticado o no)
                //requests con las rutas  
                .requestMatchers("/", "/index", "/errores/**", "/error", "/error/***",
                        "/carrito/**", "/pruebas/**", "/reportes/**",
                        "/registro/**", "/js/**", "/webjars/**")
                .permitAll()
                //estos requests solo para ADMIN role
                .requestMatchers(
                        "/cita/nuevo", "/cita/guardar",
                        "/cita/modificar/**", "/cita/eliminar/**",
                        "/cliente/nuevo", "/cliente/guardar",
                        "/cliente/modificar/**", "/cliente/eliminar/**",
                        "/usuario/nuevo", "/usuario/guardar",
                        "/usuario/modificar/**", "/usuario/eliminar/**",
                        "/reportes/**","/cliente/listado/**","/usuario/listado/**"
                ).hasRole("ADMIN")
                .requestMatchers(
                        "/cita/listado"
                ).hasAnyRole("ADMIN", "CLIENTE") //o un rol o otro
                /*.requestMatchers("/facturar/carrito")
                .hasRole("CLIENTE")*/
                )
                //Para el login utilize un form donde su loginPage va a ser la vista que esta en login(templates.login)
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

    /* El siguiente método se utiliza para completar la clase no es 
    realmente funcional, la próxima semana se reemplaza con usuarios de BD */
    
    @Bean //objeto manejado en memoria
    //sirve para manejar los users en memoria
    public UserDetailsService users() {
        //usuario admin
        
        UserDetails admin = User.builder()
        //utilizo la clase User con el metodo builder donde la informacion va a ser:
                .username("vivi")
                .password("{noop}123") //noop significa que la contrasena no se encripte
                .roles("CLIENTE","ADMIN")
                .build();
        //usurio sales
        UserDetails cliente = User.builder()
                .username("faby")
                .password("{noop}456")
                .roles("CLIENTE")
                .build();
        
        return new InMemoryUserDetailsManager(cliente, admin);
    }
}
