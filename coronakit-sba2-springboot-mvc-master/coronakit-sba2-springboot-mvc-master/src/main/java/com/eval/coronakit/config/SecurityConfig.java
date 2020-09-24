package com.eval.coronakit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean 
	@Override
	protected UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		return super.userDetailsService();
	}
	@SuppressWarnings("deprecation")
	
	  @Override protected void configure(AuthenticationManagerBuilder auth) throws
	  Exception {
	  
	  UserBuilder builder = User.withDefaultPasswordEncoder();
	  auth.inMemoryAuthentication()
	  .withUser(builder.username("Admin").password("admin").roles("ADMIN"))
	  .withUser(builder.username("First").password("abc").roles("USER"))
	  .withUser(builder.username("Second").password("abc").roles("USER")); }
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").permitAll().and()
		  .authorizeRequests().antMatchers("/console/**").permitAll().and();
		  http.csrf().disable();
		  http.headers().frameOptions().disable();
		  http.authorizeRequests()
		  .antMatchers("/user/**").hasRole("USER")
		  .antMatchers("/admin/**").hasRole("ADMIN")
		  .and()
		  .formLogin()
		  .loginPage("/custom-login")
		  .loginProcessingUrl("/validate")
		  .defaultSuccessUrl("/home")
		  .permitAll()
		  .and().logout().permitAll()
		  .and()
		  .exceptionHandling()
		  .accessDeniedPage("/custom-error");
		 
		 
		// .formLogin().loginPage("/custom-login").loginProcessingUrl("/validate").permitAll().and()
		// .formLogin().loginPage("/custom-login").and()
		// .logout().permitAll().and()
		// .exceptionHandling().accessDeniedPage("/custom-error");

		/*
		 * http.csrf().disable(); http.headers().frameOptions().disable();
		 */

		/*
		 * http.authorizeRequests(). antMatchers("/index","/").permitAll()
		 * .antMatchers("/admin","/user").authenticated() .and() .formLogin() .and()
		 * .logout() .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		 */
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**",
		// "/js/**", "/images/**");
		super.configure(web);
	}
}
