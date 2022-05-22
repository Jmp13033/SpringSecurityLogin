package com.Java.loginreg.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Java.loginreg.models.Role;
import com.Java.loginreg.models.User;
import com.Java.loginreg.repositories.UserRepo;
import com.Java.loginreg.web.dto.UserRegisterationDTO;

@Service
public class UserServiceImpl implements UserService {

	
	
	
	@Autowired
	UserRepo userRepo;
	
	
	@Autowired 
	private BCryptPasswordEncoder pass;
	
	
	
	
	
	@Override
	public User save(UserRegisterationDTO registerationDTO) {
		User user = new User(registerationDTO.getFirstName(), registerationDTO.getLastName(), 
				registerationDTO.getEmail(), 
				pass.encode(registerationDTO.getPassword()),Arrays.asList(new Role("ROLE_USER")) );
	return userRepo.save(user);
	
	
	}




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException(" Invalid Username");
			
			
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
		
		
		
	}

}
