package bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import bookstore.service.MyUserDetailsService;
import bookstore.repository.UserRepository;
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses=UserRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired 
	private MyUserDetailsService myUserDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService)
		.passwordEncoder(getPassword());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests().antMatchers("**").permitAll();
	    //** acces tt les requetes
	    http.csrf().disable();
		// dont authenticate this particular request
	    http.authorizeRequests().antMatchers("**/secured/**").authenticated().
		// all other requests need to be authenticated
		anyRequest().permitAll()
		.and().formLogin().permitAll();

}
	private PasswordEncoder getPassword() {
		return new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence charSequence, String s) {
				return true;
			}
			
			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}
		};
	}



}
