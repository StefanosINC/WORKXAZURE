package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcu.business.EmployeeService;

@Configuration 
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
PasswordEncoder passwordEncoder;

@Autowired
EmployeeService service;

@Bean
BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
	// Test
	
	@Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
       .httpBasic()
        	.and()
        	.authorizeRequests()
        	.antMatchers("/service/**").authenticated()
        	.and()
        .authorizeRequests()
        	.antMatchers("/", "/images/**",  "/displayOauthCode").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .usernameParameter("username")
        .passwordParameter("password")
        .permitAll()
        
        .defaultSuccessUrl("/ViewEmployees", true)
       
        .defaultSuccessUrl("/RegForm", true)
        .defaultSuccessUrl("/display", true)
        .and()
       .logout()
         .logoutUrl("/logout")
        .invalidateHttpSession(true)
        .clearAuthentication(true)
        .permitAll()
        .logoutSuccessUrl("/");
    }
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		String password = new BCryptPasswordEncoder().encode("Sophocleous");
		
		auth.userDetailsService(service).passwordEncoder(passwordEncoder);
		
		
		System.out.println("Password" + password);
	}
	
}
