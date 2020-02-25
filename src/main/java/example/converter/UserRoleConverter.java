package example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import example.entity.UserRole;
import example.model.UserRoleModel;
import example.repository.UserJpaRepository;

@Component("userRoleConverter")
public class UserRoleConverter {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	@Qualifier("userJpaRepository")
	private UserJpaRepository userJpaRepository;
	
	//Entity --> Model
	public UserRoleModel entity2model(UserRole userRole) {
	UserRole saveUser = userJpaRepository.save(userRole);
	UserRoleModel returnValue = modelMapper.map(saveUser, UserRoleModel.class);
	return returnValue;
	
	
	}
	
	//Model 2 Entity
	public UserRole model2entity(UserRoleModel userRoleModel) {
		UserRole userRole = modelMapper.map(userRoleModel, UserRole.class);
		return userRole;
	}

}
