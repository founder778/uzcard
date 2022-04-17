//package com.company.UzCard;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//   auth.inMemoryAuthentication().
//           withUser("admin").password("1234admin").roles("admin")
//           .and().withUser("userjon").password("123").roles("user");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.authorizeRequests()
//                .antMatchers("/card/**").permitAll()
//                .anyRequest().authenticated()
//                .and().httpBasic();
//        http.csrf().disable();
//    }
//}
