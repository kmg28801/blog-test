package tj.kmg.blog.test.config.auth;


import lombok.RequiredArgsConstructor;
import tj.kmg.blog.test.domain.Role;
import tj.kmg.blog.test.service.CustomOAuth2UserService;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   private final CustomOAuth2UserService customOAuth2UserService;

   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .headers().frameOptions().disable() 
               .and()
                   .authorizeRequests()
                   .antMatchers("/", "/css/**", "/images/**",
                           "/js/**", "/h2-console/**").permitAll()
                   .antMatchers("/api/v1/**").hasRole(Role.
                                                    USER.name())
                   .anyRequest().authenticated()
               .and()
                   .logout()
                       .logoutSuccessUrl("/")
               .and()
                   .oauth2Login()
                       .userInfoEndpoint()
                           .userService(customOAuth2UserService);
   }
}