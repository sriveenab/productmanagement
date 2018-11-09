package com.sevya.tasks.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.sevya.tasks.security.jwt.JwtAuthFilter;
import com.sevya.tasks.security.jwt.JwtAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthFilter jwtAuthFilter;

	@Autowired
	private JwtAuthenticationProvider jwtAuthenticationProvider;

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(jwtAuthenticationProvider);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.antMatcher("/**").authorizeRequests().antMatchers("/signup").permitAll().and()
				.addFilterBefore(jwtAuthFilter, BasicAuthenticationFilter.class).exceptionHandling();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
