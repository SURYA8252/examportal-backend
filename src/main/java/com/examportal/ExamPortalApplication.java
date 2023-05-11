package com.examportal;

//import java.util.HashSet;
//import java.util.Set;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.examportal.model.Role;
//import com.examportal.model.User;
//import com.examportal.model.UserRole;
//import com.examportal.service.UserService;

@SpringBootApplication
public class ExamPortalApplication {
//	implements CommandLineRunner
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
		System.out.println("Exam Portal Project is running...........");
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Coading start......");
//		User user=new User();
//		user.setFirstName("Surya Jyoti");
//		user.setLastName("Ashirwad");
//		user.setEmail("suryajyoti8252@outlook.com");
//		user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
//		user.setUsername("admin");
//		user.setProfile("default.png");
//		
//		user.setPhone("8252470072");
//		Role role1=new Role();
//		role1.setRoleId(126L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		
//		userRole.setRole(role1);
//		
//		userRole.setUser(user);
//		
//		userRoleSet.add(userRole);
//		User user1=this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
//	}

}
