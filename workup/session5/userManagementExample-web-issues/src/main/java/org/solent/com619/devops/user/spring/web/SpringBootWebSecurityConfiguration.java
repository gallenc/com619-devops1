package org.solent.com619.devops.user.spring.web;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringBootWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/",
                        "/home",
                        "/contact",
                        "/about",
                        "/login",
                        "/error",
                        "/index.html",
                        "/resources/**",
                        "/images/**",
                        "/registration",
                        "/swagger-ui/**",
                        "/v3/api-docs"
                ).permitAll() 
                .antMatchers("/users").hasRole("ADMINISTRATOR") // ROLE_GLOBAL_ADMIN
                //.antMatchers("/rest/**") //.hasAnyRole("REST_USER","GLOBAL_ADMIN") // ROLE_GLOBAL_ADMIN
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/home", true)
//                .permitAll()
//				.and().logout().permitAll()
//				.logoutSuccessUrl("/login?logout")
                .and().csrf().ignoringAntMatchers("/**"); // prevents csrf checking on rest api
    }
}
