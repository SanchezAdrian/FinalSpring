package example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_role", uniqueConstraints=@UniqueConstraint(columnNames= {"role","name"}))
public class UserRole {

	@Id
	@GeneratedValue
	@Column(name="user_role_id", unique=true,nullable=false)
	private Integer userRoleId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="name",nullable=false)
	private UserCredential userCredential;
	
	@Column(name="role",nullable=false,length=45)
	private String role;

	public UserRole(Integer userRoleId, UserCredential userCredential, String role) {
		super();
		this.userRoleId = userRoleId;
		this.userCredential = userCredential;
		this.role = role;
	}
	
	public UserRole() {
		
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UserCredential getUserCredential() {
		return userCredential;
	}

	public void setUserCredential(UserCredential userCredential) {
		this.userCredential = userCredential;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
