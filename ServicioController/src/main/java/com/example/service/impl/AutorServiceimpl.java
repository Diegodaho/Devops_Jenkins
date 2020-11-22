package com.example.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.AutorLectorDto;
import com.example.entity.Autor;
import com.example.entity.AutorLector;
import com.example.entity.Libro;
import com.example.exeption.ArgumentRequiredException;
import com.example.exeption.BusinessLogicException;
import com.example.exeption.ModelNotFoundException;
import com.example.exeption.NotFoundModelException;
import com.example.repository.IAutorDescrLibroRepo;
import com.example.repository.IAutorLector;
import com.example.repository.IAutorRepo;
import com.example.repository.ILectorRepo;
import com.example.service.Iimpl.AbstractFacade;
import com.example.service.Iimpl.IAutorService;
import com.example.view.AutorDescripcionLibro;





@Service
public class AutorServiceimpl implements IAutorService {

	@Autowired
	private IAutorRepo repo;
	
	@Autowired
	private IAutorDescrLibroRepo repoview;
	
	@Autowired
	private IAutorLector repoAutorLector;
	
	@Autowired
	private ILectorRepo repoLector;
	
	@Override
	public Page<Autor> listarPaginado(int page, int size) {
		Page<Autor> listaPaginaAutor = repo.findAll(PageRequest.of(page, size, Sort.by("nombre").ascending()));
		
		for (Autor autor : listaPaginaAutor.getContent()) {
			autor.setLibro(null);
			autor.setDireccion(null);
		}
		
		return listaPaginaAutor;
	}

	@Override
	public Autor listarPorId(Integer id) {
		Autor autor = repo.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Autor no encontrado"));	

		//autor.setLibro(null);
		return autor;
	}

	@Override
	public void guardar(Autor autor) {		
		if(autor.getLibro() != null) {
			for(Libro libro: autor.getLibro()) {
				libro.setAutor(autor);
			}		
		}
		repo.save(autor);
	}

	@Override
	public void editar(Autor obj) {
		
		if(obj.getId() == null)
			throw new ArgumentRequiredException("Id Autor es requerido");
		
		Autor autor = repo.findById(obj.getId()).orElseThrow(() 
				-> new ModelNotFoundException("Autor no encontrado"));	
		
		autor.setApellido(obj.getApellido());
		autor.setNombre(obj.getNombre());
		autor.setFechaNacimiento(obj.getFechaNacimiento());			
		repo.save(autor);		
	}

	@Override
	public void eliminar(Integer idAutor) {
		Autor autor = repo.findById(idAutor).orElseThrow(() 
				-> new ModelNotFoundException("Autor no encontrado"));	
		
		//throw new BusinessLogicException("Se debe eliminar primero todos los libros asociados al Autor");
		//repo.deleteById(idAutor);
		repo.delete(autor);
	}

	@Override
	public Page<Autor> autorNombrel(int page, int size,String nom) {
		
		
		
		
		return repo.autorNombrel(nom,PageRequest.of(page, size));
	}

	@Override
	public Page<Autor> autorLibroNombre(int page, int size,String nom) {
		
		Page<Autor> autor = repo.findByLibro_Nombre(nom,PageRequest.of(page, size));
		
		if (autor ==null) {
			
			new ModelNotFoundException("Libro y Autor no encontrado");
			
		}
		
		return autor;
	}

	@Override
	public void eliminarAutorLibro(Integer idAutor) {
		
		Autor autor = this.listarPorId(idAutor);
		if(autor.getLibro() != null && autor.getLibro().size() > 0) {
			throw new BusinessLogicException("El Autor tiene Libros (Porfavor eliminar los libros) " );
		}else {
			repo.deleteById(idAutor);
		}
		
	}

	@Override
	public void gusardarFacade(Autor clase) {
		if(clase.getLibro() != null) {
			for(Libro libro: clase.getLibro()) {
				libro.setAutor(clase);
			}		
		}
		
		if(clase.getDireccion()!= null) {
			clase.getDireccion().setAutor(clase);
					
		}
		repo.save(clase);
		
	}

	@Override
	public void editarFacade(Autor clase) {
		if(clase.getId() == null)
			throw new ArgumentRequiredException("Id Autor es requerido");
		
		Autor autor = repo.findById(clase.getId()).orElseThrow(() 
				-> new ModelNotFoundException("Autor no encontrado"));	
		
		autor.setApellido(clase.getApellido());
		autor.setNombre(clase.getNombre());
		autor.setFechaNacimiento(clase.getFechaNacimiento());			
		repo.save(autor);
		
	}

	@Override
	public void eliminarFacade(Integer id) {
		Autor autor = this.listarPorId(id);
		if(autor.getLibro() != null && autor.getLibro().size() > 0) {
			throw new BusinessLogicException("El Autor tiene Libros (Porfavor eliminar los libros) " );
		}else {
			repo.deleteById(id);
		}
		
	}

	@Override
	public Page<Autor> listarPaginadoFacade(boolean lazy, int page, int size) {
		 Page<Autor> listaPaginaAutor = repo.findAll(PageRequest.of(page, size, Sort.by("nombre").ascending()));;
		
		if(lazy) {
			for (Autor autor : listaPaginaAutor.getContent()) {
				autor.setLibro(null);
				autor.setDireccion(null);
			}
		}
		
		return listaPaginaAutor;
	}

	@Override
	public Autor listarPooIdFacede(boolean lazy, Integer id) {
			Autor autor = repo.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Autor no encontrado"));	

		if(lazy) {
			autor.setLibro(null);
			autor.setDireccion(null);
		}
		return autor;
	}

	@Override
	public Page<AutorDescripcionLibro> listarAutortotalLibro(int page, int size) {
		
		Page<AutorDescripcionLibro> listaPaginaAutor = repoview.findAll(PageRequest.of(page, size));
		
		
		return listaPaginaAutor;
		
		
	}

	@Override
	public AutorDescripcionLibro listarPorIdAutorTodo(Integer id) {
		AutorDescripcionLibro cantidad = repoview.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Autor no encontrado"));
		return cantidad;
	}

	@Override
	public void guardarAutorLector(AutorLectorDto dto) {
	
		
		repoAutorLector.guardar(
					dto.getAutor().getId(), dto.getLector().getId(), dto.getInfoAdicional());
			
	}
	
	@Transactional
	@Override
	public void guardarAutorLector(List<AutorLectorDto> dto) {
		
		for (AutorLectorDto obj : dto) {
			repoAutorLector.guardar(
					obj.getAutor().getId(), obj.getLector().getId(), obj.getInfoAdicional());
		}
	}	

	@Override
	public List<AutorLector> listarAutorLector(Integer idAutor) {
		
		
		List<AutorLector> lista= repoAutorLector.listarAutorLector(idAutor);
		
		
		
		for (AutorLector autorLector : lista) {
				autorLector.setAutor(null);
			
			
		}
		
		
		
		return lista;
	}
	

	
	

}
