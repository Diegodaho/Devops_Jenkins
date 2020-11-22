package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.view.AutorDescripcionLibro;

@Repository
public interface IAutorDescrLibroRepo extends JpaRepository<AutorDescripcionLibro, Integer>{

}
