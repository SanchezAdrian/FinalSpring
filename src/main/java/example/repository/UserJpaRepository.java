package example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import example.entity.UserRole;

public interface UserJpaRepository extends JpaRepository <UserRole, Serializable> {

}
