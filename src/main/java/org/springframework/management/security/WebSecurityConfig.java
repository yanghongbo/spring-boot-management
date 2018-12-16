package org.springframework.management.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAhthenticationFailureHandler myAhthenticationFailureHandler;

    @Bean //加密
    public PasswordEncoder passwordEncoder() {

        //如果系统本身有了其他的加密方式，此处就应该返回自己写的passwordencoder，再实现encoder和matches方法
        return new MyPasswordEncoder();
    }

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAhthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/login","/logout","/register","/me/userinfo").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
//        http.authorizeRequests().anyRequest().permitAll();
    }
}
