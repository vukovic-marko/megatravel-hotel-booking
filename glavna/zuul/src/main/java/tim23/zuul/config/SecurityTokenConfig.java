package tim23.zuul.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;

@EnableWebSecurity
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtConfig jwtConfig;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
				
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
			.and()
				.addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
//				.antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll() 
//				.antMatchers(jwtConfig.getUri()).permitAll() // TODO proveriti
//				.antMatchers("/client/**").hasAuthority("ADMIN") // TODO izmeniti
//				.anyRequest().authenticated();
			.anyRequest().permitAll();
				
	}
	
	@Bean
	public JwtConfig jwtConfig() {
		return new JwtConfig();
	}
}
