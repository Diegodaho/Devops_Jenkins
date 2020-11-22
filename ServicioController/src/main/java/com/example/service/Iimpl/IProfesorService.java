package com.example.service.Iimpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.entity.Profesor;




public interface IProfesorService {
	
	public List<Profesor> listar();
	
	public void guardar( Profesor profesor);
	
	public Profesor listarced(String cedula);
	
	public void editar( Profesor profesor);
	
	public void eliminar(Integer id);
	
	public Profesor listarPorId(Integer id);
	
	public Profesor buscar (Sort sort);
	
	public Page<Profesor> listarPornombre(int page,int size, String nombre); 
	


}
