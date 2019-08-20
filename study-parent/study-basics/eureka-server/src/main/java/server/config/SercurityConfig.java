package server.config;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/7/27 10:50
 */
//@EnableWebSecurity
/*
public class SercurityConfig extends WebSecurityConfigurerAdapter {

    // 自定义认证规则
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("123456").authorities("*");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
    }

   @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
*/



  /*  @Bean
    @Override
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("all").password("123456").roles("USER").build());
        return manager;
    }*/
public class SercurityConfig {
}
