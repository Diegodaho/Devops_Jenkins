package com.example.service.impl;

import java.math.BigInteger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dto.LibroDto;
import com.example.entity.Autor;
import com.example.entity.Libro;
import com.example.exeption.ArgumentRequiredException;
import com.example.exeption.ModelNotFoundException;
import com.example.repository.IAutorRepo;
import com.example.repository.ILibroRepo;
import com.example.service.Iimpl.ILibroService;


@Service
public class LibroServiceimpl implements ILibroService {
	
	@Autowired
	private ILibroRepo repo;
	
	@Autowired
	private IAutorRepo repoAutor;

	@Override
	public void gusardarFacade(Libro clase) {
		
		if(clase.getAutor() != null && clase.getAutor().getId() != null) {
			BigInteger contador = repoAutor.validarExistenciaPorId(clase.getAutor().getId());
			System.out.println(contador);
			if(contador.intValue() > 0) {
				
				Libro libro = new Libro();
				libro.setNombre(clase.getNombre());
				libro.setNumeroPaginas(clase.getNumeroPaginas());
				
				Autor autor = new Autor();
				autor.setId(clase.getAutor().getId());
				
				
				libro.setAutor(autor);
				repo.save(clase);
			} else {
				throw new ModelNotFoundException("Autor no encontrado");
			}
		} else {
			throw new ArgumentRequiredException("Id Autor es requerido");
		}
		
	}

	@Override
	public void editarFacade(Libro clase) {
		
		if(clase.getId() == null)
			throw new ArgumentRequiredException("Id Libro es requerido");
		
		Libro libros = repo.findById(clase.getId()).orElseThrow(() 
				-> new ModelNotFoundException("Libro no encontrado"));	
		
		libros.setNombre(clase.getNombre());
		libros.setNumeroPaginas(clase.getNumeroPaginas());
		
		
				
		repo.save(libros);
		
		
		
	}

	@Override
	public void eliminarFacade(Integer id) {
		
			boolean exis= repo.existsById(id);
			
			if(exis==false) {
				throw new EmptyResultDataAccessException("Libro no encontrado", 0);
			}
		     repo.deleteById(id);	
		
	}

	@Override
	public Page<Libro> listarPaginado(boolean lazy, int page, int size) {
		Page<Libro> listaPaginaLibro = repo.findAll(PageRequest.of(page, size, Sort.by("nombre").ascending()));;
		return listaPaginaLibro;
	}

	@Override
	public Libro listarPorId(boolean lazy, Integer id) {
		Libro libro = repo.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Libro no encontrado"));	

		return libro;
	}

	@Override
	public void guardar(LibroDto libroDto) {
		if(libroDto.getAutor() != null && libroDto.getAutor().getId() != null) {
			BigInteger contador = repoAutor.validarExistenciaPorId(libroDto.getAutor().getId());
			if(contador.intValue() > 0) {
				
				ModelMapper modelMapper = new ModelMapper();
				
				Libro libros = modelMapper.map(libroDto, Libro.class);
				
				repo.save(libros);
			} else {
				throw new ModelNotFoundException("Autor no encontrado");
			}
		} else {
			throw new ArgumentRequiredException("Id Autor es requerido");
		}
		
		
	}

	@Override
	public Page<Libro> listarPaginadoFacade(boolean lazy, int page, int size) {
		
		Page<Libro> listaPaginaLibro = repo.findAll(PageRequest.of(page, size, Sort.by("nombre").ascending()));;
		if(lazy) {
			for (Libro li : listaPaginaLibro.getContent()) {
				
				li.setAutor(null);
				 
			}			
		}
		return listaPaginaLibro;
	}

	@Override
	public Libro listarPooIdFacede(boolean lazy, Integer id) {
		Libro libro = repo.findById(id).orElseThrow(() 
				-> new ModelNotFoundException("Libro no encontrado"));
		
		if(lazy) {
			libro.setAutor(null);
		}
		return libro;
	}

	

}
