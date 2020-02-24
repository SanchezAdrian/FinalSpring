package example.model;

public class UserCredentialModel {
	private String name;
	private String password;
	
	public UserCredentialModel() {}

	public UserCredentialModel(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
