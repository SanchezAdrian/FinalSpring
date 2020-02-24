package example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import example.entity.Puerto;

public interface PuertoJpaRepository extends JpaRepository<Puerto, Serializable> {
	

}
