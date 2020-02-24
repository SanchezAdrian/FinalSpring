package example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.entity.UserCredential;

@Repository("userRepository")
public interface UserRepository extends JpaRepository <UserCredential, Serializable> {
	
	public abstract  UserCredential findByName(String name);

}
