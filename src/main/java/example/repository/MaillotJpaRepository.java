package example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import example.entity.Maillot;

public interface MaillotJpaRepository extends JpaRepository<Maillot, Serializable> {
	

}
