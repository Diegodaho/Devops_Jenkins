package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Profesor;


@Repository
public interface IProfesorRepo extends JpaRepository<Profesor, Integer> {
	
	@Query("select p from Profesor p where p.cedula like %?1%")
	public Profesor listarCedula(String cedul) ;
	
	@Query("select p from Profesor p where p.id = ?1 and p.cedula = ?2")
	public Profesor listarCedulaId(Integer idva ,String cel) ;
	
	
	@Query("select p from Profesor p")
	public List<Profesor> buscar (Sort sort);
	
	
	public Page<Profesor> findByNombreIgnoreCase(String nombre, Pageable pageable);

	

	


}
