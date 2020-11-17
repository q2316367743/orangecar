package com.qsd.orange.config;

import com.qsd.orange.security.AccessFailureHandler;
import com.qsd.orange.security.LoginFailureHandler;
import com.qsd.orange.security.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author Esion
 * @Date 2020/9/14 18:33
 * @Version 1.0
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    private AccessFailureHandler accessFailureHandler;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //拦截规则
        http.authorizeRequests()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/image/**").permitAll()
                .antMatchers("/system/**").hasRole("1")
                .antMatchers("/statistics/**").hasRole("1")
                .anyRequest().authenticated();

        //登录配置
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler);

        //注销配置
        http.logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/login.html");

        //关闭csrf防护
        http.csrf().disable();

        //配置iframe请求
        http.headers().frameOptions().disable();

        //处理认证失败请求
        http.exceptionHandling().accessDeniedHandler(accessFailureHandler);

    }

    //认证配置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
