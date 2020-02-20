package vn.com.heyzo.jwt.filtes;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import vn.com.heyzo.jwt.models.AccountCredentials;
import vn.com.heyzo.jwt.services.TokenAuthenticationService;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		AccountCredentials credentials = new AccountCredentials(request.getParameter("username"),
				request.getParameter("password"));
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
				credentials.getUsername(), credentials.getPassword(), java.util.Collections.emptyList())

		);
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
		TokenAuthenticationService.addAuthentication(response, authentication.getName());
	}

}
