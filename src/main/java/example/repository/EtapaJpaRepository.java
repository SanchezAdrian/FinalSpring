package example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import example.entity.Etapa;

public interface EtapaJpaRepository extends JpaRepository<Etapa, Serializable> {
	

}

