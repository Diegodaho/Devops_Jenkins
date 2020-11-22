package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LibroDto;
import com.example.entity.Autor;
import com.example.entity.Libro;
import com.example.service.Iimpl.ILibroService;

@PreAuthorize("hasAuthority('Admin')" )
@RestController
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	private ILibroService service;
	
	@PreAuthorize("hasAuthority('Admin') OR hasAuthority('Invitado') " )
	@GetMapping("/listarPageable/{lazy}/{page}/{size}")
	public  ResponseEntity<Page<Libro>> rentorPageable(@PathVariable boolean lazy, @PathVariable int page, @PathVariable int size) {		
		Page<Libro> listarLibro = service.listarPaginado(lazy, page, size);
		return new ResponseEntity<Page<Libro>>(listarLibro, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('Admin') OR hasAuthority('Invitado') " )
	@GetMapping("/listar/{lazy}/{id}")
	public ResponseEntity<Libro> listarPorId(@PathVariable boolean lazy, @PathVariable int id)  {
		Libro libro = service.listarPorId(lazy, id);
			return new ResponseEntity<Libro>(libro, HttpStatus.OK);					
	}
	
	@PostMapping("/guardar1")
	public ResponseEntity<Object> guardar(@Valid @RequestBody LibroDto libro) {
		service.guardar(libro);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardarFacei(@Valid @RequestBody Libro libro) {
		service.gusardarFacade(libro);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{idLibro}")
	public ResponseEntity<Autor> eliminar(@PathVariable int idLibro)  {
			service.eliminarFacade(idLibro);
			return new ResponseEntity<Autor>(HttpStatus.NO_CONTENT);					
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody Libro libro) {
		service.editarFacade(libro);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAuthority('Admin') OR hasAuthority('Invitado') " )
	@GetMapping("/listarPageablel/{lazy}/{page}/{size}")
	public  ResponseEntity<Page<Libro>> rentorPageable2(@PathVariable boolean lazy, @PathVariable int page, @PathVariable int size) {		
		Page<Libro> listarLibro = service.listarPaginadoFacade(lazy, page, size);
		return new ResponseEntity<Page<Libro>>(listarLibro, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('Admin') OR hasAuthority('Invitado') " )
	@GetMapping("/listarl/{lazy}/{id}")
	public ResponseEntity<Libro> listarPorId1(@PathVariable boolean lazy, @PathVariable int id)  {
		Libro libro = service.listarPooIdFacede(lazy, id);
			return new ResponseEntity<Libro>(libro, HttpStatus.OK);					
	}

}
