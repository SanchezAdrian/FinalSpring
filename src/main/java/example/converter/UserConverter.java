package example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import example.entity.UserCredential;
import example.model.UserCredentialModel;
import example.repository.UserRepository;

@Component("userConverter")
public class UserConverter {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	//Entity --> Model
	public UserCredentialModel entity2model(UserCredential userCredential) {
	UserCredential saveUser = userRepository.save(userCredential);
	UserCredentialModel returnValue = modelMapper.map(saveUser, UserCredentialModel.class);
	return returnValue;
	
	
	}
	
	//Model 2 Entity
	public UserCredential model2entity(UserCredentialModel userCredentialModel) {
		UserCredential userCredential = modelMapper.map(userCredentialModel, UserCredential.class);
		return userCredential;
	}

}
