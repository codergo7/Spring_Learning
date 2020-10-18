package com.aga.todosimplesecurity.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/*
WebSecurityConfigurerAdapter. Extending this class is one way to
override security because it allows you to override the methods that
you really need. In this case, the code overrides the configure(Authe
nticationManagerBuilder) signature.
 */
@Configuration
public class ToDoSecurityConfig extends WebSecurityConfigurerAdapter {


    /*
AuthenticationManagerBuilder. This class creates an
AuthenticationManager that allows you to easily build in memory,
LDAP, JDBC authentications, UserDetailsService and add
AutheticationProviders. In this case, you are building an in-
memory authentication. It’s necessary to add a PasswordEncoder
and a new and more secure way to use and encrypt/decrypt the
password.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("aga")
                .password(passwordEncoder().encode("springboot2"))
                .roles("ADMIN", "USER");
    }


    /*
    The new modification
show how HttpSecurity is being configured. First, its adding requestMatchers, which
point to common locations, such as the static resources (static/* ). This is where
CSS, JS, or any other simple HTML can live and doesn’t need any security. Then it uses
anyRequest, which should be fullyAuthenticated. this means that the /api/* will be.
Then, it uses formLogin to specify with loginPage("/login") that it is the endpoint
for finding the login page. Next, declare the logout and its endpoint ("/logout"); if the
logout is successful, it redirects to the "/login" endpoint/page.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(
                        PathRequest
                                .toStaticResources()
                                .atCommonLocations()).permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
                .httpBasic();
    }


    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .httpBasic();
    }

 */

    /*
    BCryptPasswordEncoder. In this code you are using the
BCryptPasswordEncoder (returns a PasswordEncoder
implementation) that uses the BCrypt strong hashing function.
You can use also Pbkdf2PasswordEncoder (uses PBKDF2 with a
configurable number of iterations and a random 8-byte random
salt value), or SCryptPasswordEncoder (uses the SCrypt hashing
function). Even better, use DelegatingPasswordEncoder, which
supports password upgrades.
     */

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
