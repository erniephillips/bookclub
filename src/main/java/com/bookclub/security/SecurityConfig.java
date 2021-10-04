/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Baeldung. (n.d.). New Password Storage In Spring Security 5. Baeldung. Retrieved October 4, 2021, 
     from https://www.baeldung.com/spring-security-5-password-storage
    Modified By: Ernie Phillips III
    Created Date: 10/04/2021
    Modified Date: 10/04/2021
    Purpose: Security class for how user stored/retrieved. In this case, two users are created in-memory. (Likely to be changed to database store later)
*/

package com.bookclub.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//data annotations define this is a configuration file for web security
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override //override the config method in WebSecurityConfigurerAdapter for authentication building
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{ // AuthenticationManager allows for easily building in memory authentication, LDAP authentication, JDBC based authentication, adding UserDetailsService, and adding AuthenticationProvider's.
    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); //returns a configured instance of DelegationPasswordEncoder (Baeldung, n.d.)

    //creating two users in memory of type basic and administrator
    auth.inMemoryAuthentication()
        .withUser("user").password(encoder.encode("password")).roles("USER")
        .and()
        .withUser("admin").password(encoder.encode("admin123")).roles("USER", "ADMIN");
  }
  @Override //override the config method in WebSecurityConfigurerAdapter for the HTTP security module
  protected void configure(HttpSecurity httpSecurity) throws Exception{ //
    httpSecurity
      .authorizeRequests() //security policy for incoming requests
        .anyRequest() //ALL requests
        .authenticated() //user must be authenticated
        .and()
      .formLogin() //accessing the formlogin method to override the default page
        .loginPage("/login") //tell what page
        .defaultSuccessUrl("/", true) //give the login success a default page, or it navigates to the fist found static page
        .permitAll() //allow all users (authenticated or unauthenticated) (maybe better if we didn't allow authenticated users to view page???)
        .and()
      .logout() //tell method what to do for logout requests
        .logoutSuccessUrl("/login?logout=true") //inform what the logout url is
        .invalidateHttpSession(true) //clear server session for the user
        .permitAll(); //allow all users to access this page

  }
}
