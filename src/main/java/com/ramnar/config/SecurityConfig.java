//package com.ramnar.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@Order(1)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
// 
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////    	http
////        .csrf().disable()
////        .anonymous().disable()
////        .authorizeRequests()
////        .antMatchers("/api-docs/**").permitAll();
////    }
//    
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
// 
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("ramnar")
//            .password(new BCryptPasswordEncoder().encode("ramnar"))
//            .roles("USER");
//    }
//     
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){ 
//        return new BCryptPasswordEncoder(); 
//    }
//}