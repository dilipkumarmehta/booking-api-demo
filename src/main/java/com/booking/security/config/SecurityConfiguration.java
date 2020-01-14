package com.booking.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN").and()
				.withUser("user").password(encoder().encode("userPass")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		 httpSecurity.authorizeRequests()
		.antMatchers("/api/foos")
		.authenticated()
		.antMatchers("/api/admin/**")
		.hasRole("ADMIN").and().httpBasic();
		httpSecurity.csrf().disable();

	}

	@Bean
	public CustomFilter customFilter() {
		return new CustomFilter();
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}