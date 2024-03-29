package com.tienda;

import com.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
     @Autowired
     private UserService userDetailsService;
     
     @Bean
     public BCryptPasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
     }
     @Bean
     public UserService getUserService(){
         return new UserService();
     }
     
     @Bean
     DaoAuthenticationProvider authenticationProvider(){
         DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
         daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
         daoAuthenticationProvider.setUserDetailsService(getUserService());
         return daoAuthenticationProvider;
     }
     @Bean
     public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){
         return new AppAuthenticationSuccessHandler();
     }
     
     public SecurityConfig(UserService userPrincipalDetailService){
         this.userDetailsService = userPrincipalDetailService;
     }
     @Override
     protected void configure(AuthenticationManagerBuilder auth){
         auth.authenticationProvider(authenticationProvider());
    }
    //El siguiente metodo funciona para hacer la autenticacion del usuario
     @Override
     protected void configure(HttpSecurity http) throws Exception{
         http.authorizeRequests()
            .antMatchers("/persona","login")
            .hasRole("ADMIN")
            .antMatchers("/personasN", "/persona", "/","/login")
            .hasAnyRole("USER", "VENDEDOR", "ADMIN")
            .and()
            .formLogin()
            .loginPage("/login").permitAll().defaultSuccessUrl("/persona", true).and().logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/");
    }
     //El siguiente metodo funciona para realizar la autorizacion de accesos
     //i18n
}
