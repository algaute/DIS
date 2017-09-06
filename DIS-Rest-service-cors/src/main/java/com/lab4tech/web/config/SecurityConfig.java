package com.lab4tech.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lab4tech.security.AppUserDetailsService;
import com.lab4tech.web.beans.CustomLogoutHandler;

@EnableAutoConfiguration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AppUserDetailsService appUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder registry) throws Exception {
		// l'authentification est faite par le bean [appUserDetailsService]
		// le mot de passe est crypté par l'algorithme de hachage BCrypt
		registry.userDetailsService(appUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* projet login applicatif  
		http.authorizeRequests()
				.antMatchers("/resources/**","/displayData/valid").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				//.successHandler(authenticationSuccessHandler)
				//.and()
				//.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
				//.and()
	        .logout() 
	        	.addLogoutHandler(customLogoutHandler()) // custom handler
	        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	            .permitAll();
		//http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		//http.formLogin().successHandler(authenticationSuccessHandler);
		//http.formLogin().failureHandler(authenticationFailureHandler);
        */
		
		// basic login
		// CSRF
		http.csrf().disable();
		// le mot de passe est transmis par le header Authorization: Basic xxxx
		http.httpBasic();
		// la méthode HTTP OPTIONS doit être autorisée pour tous
		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/", "/**")
			.permitAll();
		// seul le rôle ADMIN peut utiliser l'application
		http.authorizeRequests() //
				.antMatchers("/", "/**") // toutes les URL
				.hasRole("ADMIN");
		
		
	}
	
	@Bean
	public CustomLogoutHandler customLogoutHandler() {
	    return new CustomLogoutHandler();
	}
}
