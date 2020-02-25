package example.service;

import java.util.List;

import example.entity.UserRole;
import example.model.UserRoleModel;

public interface UserRoleService {
	
	public abstract List<UserRole> getListUsuarios();
	public abstract UserRole addUsuario(UserRoleModel userRoleModel);

}
