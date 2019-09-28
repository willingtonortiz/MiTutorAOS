package com.mitutor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mitutor.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/js/**", "/layer/**", "/assets/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(resources).permitAll()
			.antMatchers("/", "/dataGeneration/**", "/person/**", "/account/**").permitAll()
			//.antMatchers("/", "/index").permitAll()
			//.antMatchers("/admin*").access("hasRole('TUTOR')")
			//.antMatchers("/user*").access("hasRole('STUDENT') or hasRole('TUTOR')")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/person")
				.failureUrl("/account/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/account/login?logout");
	}
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		
		return bCryptPasswordEncoder;
	}
	
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
