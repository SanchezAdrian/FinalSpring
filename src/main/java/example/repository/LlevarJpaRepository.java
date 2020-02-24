package example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import example.entity.Llevar;

public interface LlevarJpaRepository extends JpaRepository<Llevar, Serializable> {
	

}
