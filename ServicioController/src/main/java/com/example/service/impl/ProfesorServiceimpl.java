package com.example.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.dto.EstudianteDto;
import com.example.entity.Profesor;
import com.example.exeption.ArgumentRequiredException;
import com.example.exeption.BusinessLogicException;
import com.example.exeption.ModelNotFoundException;

import com.example.repository.IProfesorRepo;
import com.example.service.Iimpl.IProfesorService;





@Service
public class ProfesorServiceimpl implements IProfesorService {
	

	
	@Autowired
	private IProfesorRepo repo;
	

	

	@Override
	public List<Profesor> listar() {
		
		return repo.findAll();
	}


	@Override
	public void guardar(Profesor profesor) {
		
		//Profesor pr = this.listarced(profesor.getCedula());
		List<Profesor> pr = this.repo.buscar(Sort.by("cedula"));
		
		for(Profesor pro :pr) {
		
		if(profesor.getCedula().equals(pro.getCedula())) {
			
			throw new BusinessLogicException("La cedula ya existe");	
		}
	}
		repo.save(profesor);
		
	}


	@Override
	public Profesor listarced(String cedula) {
		
		return repo.listarCedula(cedula);
	}


	@Override
	public void editar(Profesor profesor) {
		
		List<Profesor> profe = this.listar();
		
		
		if(profesor.getId() == null ) {
			
			throw new ArgumentRequiredException("id profesor Requerido");	
			
		}
		
		
		for(Profesor pro :profe) {
			if(profesor.getId()!=pro.getId() && profesor.getCedula().equals(pro.getCedula())) {
				
				throw new BusinessLogicException("La cedula ya existe con otro registro");	
				
			}
		}
		
		 this.listarPorId(profesor.getId());
		 repo.save(profesor);
		
	
	}

	@Override
	public void eliminar(Integer id) {
		
     if(id ==null ) {
    	 
    	 throw new ModelNotFoundException("Profesor no encontrado");
    	 
     }
     
       repo.deleteById(id);
		
		
	}


	@Override
	public Profesor listarPorId(Integer id) {
		
			Profesor profesor = repo.findById(id).orElseThrow(() 
					-> new ModelNotFoundException("Profesor no encontrado"));
			
			return profesor;
		}


	@Override
	public Profesor buscar(Sort sort) {
		
		return null;
		
		
	}


	@Override
	public Page<Profesor> listarPornombre(int page, int size, String nombre) {
		
		return  repo.findByNombreIgnoreCase(nombre, PageRequest.of(page, size));
		
		
		
		
	}


	

	
	
	
	
	
	
	
	
	

}
