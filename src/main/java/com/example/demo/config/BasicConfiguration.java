package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("anderson")
            .password("{noop}123456")
            .roles("USER")
            .and()
          .withUser("admin")
            .password("{noop}admin")
            .roles("USER", "ADMIN");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//          .authorizeRequests()
//          .antMatchers("/h2/**").permitAll()//allow h2 console access to admins only
//          .anyRequest()
//          .authenticated()
//          .and()
//          .csrf().disable()
//         // .and()
//          .httpBasic()
//          .and().sessionManagement()
//          .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
         // .and().csrf().disable();;
        
        http.authorizeRequests().antMatchers("/").permitAll()
        .and()
        .authorizeRequests().antMatchers("/h2-console/**").permitAll()
        .and()
        .headers().frameOptions().disable()
        .and()
       // .csrf().ignoringAntMatchers("/h2-console/**")
      //  .and()
	      .httpBasic()
	      .and().sessionManagement()
	      .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
       // .cors().disable()
        .csrf().disable();
    }
}
