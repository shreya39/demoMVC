package com.lkm.ctrl;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	// to create the spring security filter chain
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	auth.inMemoryAuthentication().withUser("shreya").password("shreya39").roles("admin");
	}

   //password encoder is an interface to encode raw password; contains encode & matches method	
	
  @Bean	
  PasswordEncoder getpasswordEncoder() {
	  return new BCryptPasswordEncoder();
  }
	
}
