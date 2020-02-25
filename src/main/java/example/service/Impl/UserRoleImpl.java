package example.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import example.converter.UserRoleConverter;
import example.entity.UserRole;
import example.model.UserRoleModel;
import example.repository.UserJpaRepository;
import example.service.UserRoleService;

@Service
public class UserRoleImpl implements UserRoleService {
	
	
	@Autowired
	@Qualifier("userJpaRepository")
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	@Qualifier("userRoleConverter")
	private UserRoleConverter userRoleConverter;

	@Override
	public List<UserRole> getListUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole addUsuario(UserRoleModel userRoleModel) {
		UserRole user = userRoleConverter.model2entity(userRoleModel);
		return userJpaRepository.save(user);
	}

}
