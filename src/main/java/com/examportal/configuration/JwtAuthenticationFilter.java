package com.examportal.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.examportal.service.implement.UserDetailServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    @Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
    @Autowired
    private JwtUtil jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		    final String requestTokenHeader = request.getHeader("Authorization");
		    System.out.println(requestTokenHeader);
		    String username=null;
		    String jwtToken=null;
		    if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		    {
		    	//Yes
		    	jwtToken = requestTokenHeader.substring(7);
		    	try
		    	{
		    		username = this.jwtUtil.extractUsername(jwtToken);
		    	}
		    	catch(ExpiredJwtException ex)
		    	{
		    		ex.printStackTrace();
		    		System.out.println("Jwt token has expired ");
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    		System.out.println("Error ");
		    	}
		    }
		    else
		    {
		    	System.out.println("Invalid Token , not start with bearer String ");
		    }
		    if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		    {
		    	final UserDetails userDetails = this.userDetailServiceImpl.loadUserByUsername(username);
		    	if(this.jwtUtil.validateToken(jwtToken, userDetails))
		    	{
		    		//Token is Valid
		    		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
		    	    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		    	    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		    	}
		    }
		    else
		    {
		    	System.out.println("Token is not Vaild ");
		    }
		    filterChain.doFilter(request, response);
	}

}
