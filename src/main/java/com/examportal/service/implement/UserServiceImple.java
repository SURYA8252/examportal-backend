package com.examportal.service.implement;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.repository.RoleRepository;
import com.examportal.repository.UserRepository;
import com.examportal.service.UserService;
@Service
public class UserServiceImple implements UserService{
    @Autowired
	private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    //creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null)
		{
			System.out.println("User is already there !!");
			throw new Exception("User already present !!");
		}
		else
		{
			//user create
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(user);
		}
		return local;
	}
	//getting user by username
	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}
	//delete user by id
	@Override
	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);
	}

}
