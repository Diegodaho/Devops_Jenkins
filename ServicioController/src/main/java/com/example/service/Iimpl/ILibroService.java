package com.example.service.Iimpl;

import org.springframework.data.domain.Page;

import com.example.dto.LibroDto;
import com.example.entity.Libro;



public interface ILibroService extends AbstractFacade<Libro, Integer>{
	
   public Page<Libro> listarPaginado(boolean lazy, int page, int size);
	
   public Libro listarPorId(boolean lazy, Integer id);
   public void guardar( LibroDto libroDto);
   

}
