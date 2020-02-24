package example.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class UserCredential {
	
	@Id
	@Column(name="name",unique=true,nullable=false,length=45)
	private String name;
	
	@Column(name="password",nullable=false,length=60)
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="userCredential")
	private Set<UserRole> userRole=new HashSet<UserRole>();
	
	public UserCredential() {}

	public UserCredential(String name, String password, boolean enabled, Set<UserRole> userRole) {
		super();
		this.name = name;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	

}
