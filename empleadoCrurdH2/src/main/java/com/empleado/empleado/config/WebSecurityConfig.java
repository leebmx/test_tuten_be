package com.empleado.empleado.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) 
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers(HttpMethod.POST, "/empleado/create").permitAll()
			.antMatchers(HttpMethod.DELETE, "/empleado/delete/{id}").permitAll()
			.antMatchers(HttpMethod.GET, "/empleado/get/all").permitAll()
			.antMatchers(HttpMethod.GET, "/empleado/get/{id}").permitAll()
			.antMatchers(HttpMethod.PUT, "/empleado/update").permitAll()
			.antMatchers(HttpMethod.POST, "/getHora").permitAll()
			.antMatchers(HttpMethod.POST, "/empleado/login").permitAll()
			.antMatchers(HttpMethod.POST, "/empleado/booking").permitAll()
            .antMatchers("/v2/api-docs",
                    "/configuration/ui",
                    "/swagger-resources/**",
                    "/configuration/security",
                    "/swagger-ui.html",
                    "/webjars/**").permitAll()
			.anyRequest().authenticated();
		http.headers().frameOptions().sameOrigin();
		http.cors();
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}
}
