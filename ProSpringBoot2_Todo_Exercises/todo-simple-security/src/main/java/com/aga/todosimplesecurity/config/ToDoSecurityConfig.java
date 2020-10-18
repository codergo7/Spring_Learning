package com.aga.todosimplesecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


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
                .withUser("apress")
                .password(passwordEncoder().encode("springboot2"))
                .roles("ADMIN", "USER");
    }

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
