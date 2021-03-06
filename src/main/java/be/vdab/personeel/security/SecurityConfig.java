package be.vdab.personeel.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource datasource;

    SecurityConfig(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.jdbcAuthentication().dataSource(datasource)
                .usersByUsernameQuery(
                        "select email as username, paswoord as password, true as enabled" +
                                " from werknemers where email = ?")
                      .authoritiesByUsernameQuery("select ?, 'gebruiker'");
    }
}