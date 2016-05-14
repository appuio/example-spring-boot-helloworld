package ch.appuio.techlab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.appuio.techlab.model.Hello;

public interface HelloRepository extends JpaRepository<Hello, Long>{
	
	List<Hello> findAllByOrderByIdDesc();

}
