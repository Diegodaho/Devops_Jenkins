package com.example.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Autor;


@Repository
public interface IAutorRepo extends JpaRepository<Autor, Integer> {
	
    @Query("SELECT a from Autor a  join a.libro l  where l.nombre =?1")
	public Page<Autor> autorNombrel(String nom,  Pageable pageable);
    
    public Page<Autor> findByLibro_Nombre(String nom , Pageable pageable);
    
    @Query(value = "SELECT count(a) FROM Autor a WHERE a.Id = :id")
	BigInteger validarExistenciaPorId(@Param("id") Integer id);
	
	

}
