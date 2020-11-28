package by.daryazalevskaya.negotium.config;

import by.daryazalevskaya.negotium.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .authorizeRequests()
//                .antMatchers("/registration").permitAll()
//               // .antMatchers("/employee").hasAnyRole(Role.EMPLOYEE.name())
//             //   .antMatchers("/employer").hasAnyRole(Role.EMPLOYER.name())
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/homePage", true)
//                .permitAll();

                .authorizeRequests()
                .antMatchers("/", "/registration")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/homePage", true)
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("select username, password, active from usr where username=?") //find a user by username
//                .authoritiesByUsernameQuery("select u.username, a.authorities " +
//                        "from usr u join authority a on u.id = a.user_id_auth where username=?"); //find user's authority by username
                .usersByUsernameQuery("select username, password, is_active from usr where username=?") //find a user by username
                .authoritiesByUsernameQuery("select username, user_role " +
                        "from usr join user_role on usr.id=user_role.user_id_role where username=?"); //find user's authority by username
    }

}