package example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import example.entity.Equipo;

public interface EquipoJpaRepository extends JpaRepository<Equipo, Serializable> {
	

}



