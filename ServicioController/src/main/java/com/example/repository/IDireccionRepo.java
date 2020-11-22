package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Direccion;

@Repository
public interface IDireccionRepo extends JpaRepository<Direccion, Integer>{
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE direccion SET barrio = :barrio, descripcion = :descripcion WHERE autor_id= :autorid", nativeQuery = true)
	public void editarQuery(@Param("autorid")Integer idAutor,@Param("barrio") String barr,@Param("descripcion") String des);
	
	

}
