package org.ggyool.config;

import javax.sql.DataSource;

import org.ggyool.security.CustomLoginSuccessHandler;
import org.ggyool.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import lombok.extern.log4j.Log4j;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig 
extends
WebSecurityConfigurerAdapter
{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// ÇÑ±Û±úÁü ¶§¹®¿¡ ³ÖÀ½
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter,CsrfFilter.class);
        
		//http.authorizeRequests()
		//.antMatchers("/problem/*").access("hasRole('ROLE_MEMBER')");

		http.formLogin().loginPage("/customLogin").loginProcessingUrl("/login")
		.successHandler(loginSuccessHandler());
		
		http.logout()
		.logoutUrl("/customLogout")
		.invalidateHttpSession(true);
	}
	

	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("member").password("{noop}member").roles("MEMBER");
		auth.userDetailsService(customUserService())
		.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserDetailsService();
	}
}
