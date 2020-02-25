package example.model;

import example.entity.UserCredential;

public class UserRoleModel {

	private Integer userRoleId;
	private UserCredentialModel userCredential;
	private String role;
	
	public UserRoleModel() {}

	public UserRoleModel(Integer userRoleId, UserCredentialModel userCredential, String role) {
		super();
		this.userRoleId = userRoleId;
		this.userCredential = userCredential;
		this.role = role;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UserCredentialModel getUserCredential() {
		return userCredential;
	}

	public void setUserCredential(UserCredentialModel userCredential) {
		this.userCredential = userCredential;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
