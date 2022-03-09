package com.example.appid;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login**", "/user", "/userInfo").authenticated()
                .and()
                .oauth2Login();
    }
}