package example.service;

import java.util.List;

import example.entity.UserCredential;
import example.model.UserCredentialModel;

public interface UserService {

	public abstract List<UserCredential> getListUsuarios();
	public abstract UserCredential addUsuario(UserCredentialModel userCredentialModel);


}
