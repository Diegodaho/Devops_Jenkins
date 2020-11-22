package com.example.service.Iimpl;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.dto.AutorLectorDto;
import com.example.entity.Autor;
import com.example.entity.AutorLector;
import com.example.exeption.ModelNotFoundException;
import com.example.view.AutorDescripcionLibro;



public interface IAutorService extends AbstractFacade<Autor, Integer> {
	
public Page<Autor> listarPaginado(int page, int size);
	
	public Autor listarPorId(Integer id);
	
	public void guardar( Autor autor);
	
	public void editar( Autor autor);
	
	public void eliminar(Integer idAutor);
	
	public Page<Autor> autorNombrel(int page,int size,String nom);
	
	public Page<Autor> autorLibroNombre(int page,int size,String nom);
	
	public void eliminarAutorLibro(Integer idAutor);
	
	public Page<AutorDescripcionLibro> listarAutortotalLibro(int page, int size);
	
	public AutorDescripcionLibro listarPorIdAutorTodo(Integer id);
	
    public void guardarAutorLector(AutorLectorDto dto);
	
	public void guardarAutorLector(List<AutorLectorDto> dto);
	
	List<AutorLector> listarAutorLector(Integer idAutor);
	
   
	
	

}
