package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.dto.DireccionDto;
import com.example.entity.Autor;
import com.example.entity.Direccion;
import com.example.entity.Libro;
import com.example.exeption.ArgumentRequiredException;
import com.example.exeption.ModelNotFoundException;
import com.example.repository.IDireccionRepo;
import com.example.repository.ILibroRepo;
import com.example.service.Iimpl.IDireccionService;


@Service
public class DireccionServiceimpl implements IDireccionService {
	
	@Autowired
	private IDireccionRepo repo;
	
	

	@Override
	public void editar(Direccion direccion) {
		
		
		if(direccion.getId() == null)
			throw new ArgumentRequiredException("Id Direccion es requerido");
		
			
		
		Direccion direc = repo.findById(direccion.getId()).orElseThrow(() 
				-> new ModelNotFoundException("Direccion no encontrada"));
		
		direc.setDescripcion(direccion.getDescripcion());
		direc.setBarrio(direccion.getBarrio());
		
		
		
		
				
		repo.save(direc);
		
	}


    
	@Override
	public void editarQuery(Direccion direccion) {
		
		if(direccion.getId() == null)
			throw new ArgumentRequiredException("Id Direccion es requerido");
		
		boolean exis= repo.existsById(direccion.getId());
		
		if(exis==false) {
			throw  new ModelNotFoundException("Libro no encontrado");
		}
		else {
			
			repo.editarQuery(direccion.getId(),direccion.getBarrio(),direccion.getDescripcion());
			
		}
		
		
		
		
		
		
	}



	



	



	

	
	

}
