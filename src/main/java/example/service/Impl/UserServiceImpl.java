package example.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import example.converter.UserConverter;
import example.entity.UserCredential;
import example.entity.UserRole;
import example.model.UserCredentialModel;
import example.repository.UserRepository;


@Service
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){
		Set<GrantedAuthority> auths=new HashSet<GrantedAuthority>();
		
		for(UserRole userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}

	private User buildUser(UserCredential userCredential, List<GrantedAuthority> authorities) {
		return new User(userCredential.getname(),userCredential.getPassword(),userCredential.isEnabled(),true,true,true,authorities);
	}
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		UserCredential userCredential=userRepository.findByName(name);
		List<GrantedAuthority> authorities =buildAuthorities(userCredential.getUserRole());
		return buildUser(userCredential,authorities);
	}
	
	
	public UserCredential addUser(UserCredentialModel userCredentialModel) {
		UserCredential user = userConverter.model2entity(userCredentialModel);
		user.setEnabled(true);
		return userRepository.save(user);
	}

	

	
	

}
