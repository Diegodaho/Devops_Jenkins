package com.example.service.Iimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.dto.EstudianteDto;

import com.example.exeption.FoundModelException;
import com.example.exeption.NotFoundModelException;


@Component
public interface IEstudianteService1 {
	
 public boolean guardarEstudiante (EstudianteDto estudiante)throws FoundModelException, NotFoundModelException;
	 
	 public EstudianteDto obtenerEstudiante(int codi)throws NotFoundModelException;
	 
	 public boolean eliminarEstudinate(int cedu)throws NotFoundModelException;
	    
	 public void editarEstudiante (EstudianteDto estudiante)throws NotFoundModelException ;
	    
	 public List<EstudianteDto> listarTodos()throws NotFoundModelException;
	 
	 public List<EstudianteDto> obtenerEstu();
	 
	 public void agregarEstusiante(EstudianteDto datos );
	 
	 
	 
	
	 
	 
}
