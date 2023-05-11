package com.examportal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.configuration.JwtUtil;
import com.examportal.model.JwtRequest;
import com.examportal.model.JwtResponse;
import com.examportal.model.User;
import com.examportal.service.implement.UserDetailServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	@Autowired
	private JwtUtil jwtUtil;
	//generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try
		{
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("User not found ");
		}
		////////////////////////authenticate
	    UserDetails userDetails = this.userDetailServiceImpl.loadUserByUsername(jwtRequest.getUsername());
	    String token = this.jwtUtil.generateToken(userDetails);
	    return ResponseEntity.ok(new JwtResponse(token));
	}
    private void authenticate(String username,String password) throws Exception
    {
    	try
    	{
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    	}
    	catch(DisabledException e)
    	{
    		throw new Exception("USER DISABLE "+e.getMessage());
    	}
    	catch(BadCredentialsException e)
    	{
    		throw new Exception("Invalid Credentials "+e.getMessage());
    	}
    }
    //return the details of current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal)
    {
    	return (User)this.userDetailServiceImpl.loadUserByUsername(principal.getName());
    }
}
