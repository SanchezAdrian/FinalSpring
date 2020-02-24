package example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import example.entity.News;

public interface NewsJpaRepository  extends JpaRepository<News, Serializable> {

}
