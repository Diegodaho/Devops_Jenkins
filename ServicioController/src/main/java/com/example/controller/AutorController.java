package com.example.controller;

import java.util.List;

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

import com.example.dto.AutorLectorDto;
import com.example.entity.Autor;
import com.example.entity.AutorLector;
import com.example.entity.Direccion;
import com.example.service.Iimpl.AbstractFacade;
import com.example.service.Iimpl.IAutorService;
import com.example.service.Iimpl.IDireccionService;
import com.example.view.AutorDescripcionLibro;




@PreAuthorize("hasAuthority('Admin')")
@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private IAutorService service;
	
	@Autowired
	private IDireccionService ser; 
	
	
	
	@PreAuthorize("hasAuthority('Admin') OR hasAuthority('Invitado') " )
	@GetMapping("/listarAutorLector/{idAutor}")
	public ResponseEntity<List<AutorLector>> listarAutorLector(@PathVariable int idAutor)  {
			List<AutorLector> listaAutorLector = service.listarAutorLector(idAutor);
			return new ResponseEntity<List<AutorLector>>(listaAutorLector, HttpStatus.OK);					
	}
	@GetMapping("/listarPageable/{page}/{size}")
	public  ResponseEntity<Page<Autor>> rentorPageable(@PathVariable int page, @PathVariable int size) {		
		Page<Autor> listarAutor = service.listarPaginado(page, size);
		return new ResponseEntity<Page<Autor>>(listarAutor, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Autor> listarPorId(@PathVariable int id)  {
			Autor autor = service.listarPorId(id);
			return new ResponseEntity<Autor>(autor, HttpStatus.OK);					
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@Valid @RequestBody Autor obj) {
		service.guardar(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Object> editar(@Valid @RequestBody Autor obj) {
		service.editar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/eliminar/{idAutor}")
	public ResponseEntity<Autor> eliminar(@PathVariable int idAutor)  {
			service.eliminar(idAutor);
			return new ResponseEntity<Autor>(HttpStatus.NO_CONTENT);					
	}
	@PreAuthorize("hasAuthority('Admin') OR hasAuthority('Invitado') " )
	@GetMapping("/autornom/{page}/{size}/{nombre}")
	public  ResponseEntity<Page<Autor>> rentorPageable(@PathVariable int page, @PathVariable int size,@PathVariable String nombre) {		
		Page<Autor> listarAutor = service.autorNombrel(page, size, nombre);
		return new ResponseEntity<Page<Autor>>(listarAutor, HttpStatus.OK);
	}
	@PreAuthorize("hasAuthority('Admin') OR hasAuthority('Invitado') " )
	@GetMapping("/nomblibro/{page}/{size}/{nombre}")
	public  ResponseEntity<Page<Autor>> nombreLibro(@PathVariable int page, @PathVariable int size,@PathVariable String nombre) {		
		Page<Autor> listarAutor = service.autorLibroNombre(page,size,nombre);
		return new ResponseEntity<Page<Autor>>(listarAutor, HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar2/{idAutor}")
	public ResponseEntity<Autor> eliminar2(@PathVariable int idAutor)  {
			service.eliminarAutorLibro(idAutor);
			return new ResponseEntity<Autor>(HttpStatus.NO_CONTENT);					
	}
	
	@PutMapping("/editardire")
	public ResponseEntity<Object> editarDireccion(@Valid @RequestBody Direccion obj) {
		ser.editar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PutMapping("/editardire2")
	public ResponseEntity<Object> editarDireccion2(@Valid @RequestBody Direccion obj) {
		ser.editarQuery(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('Admin') OR hasAuthority('Invitado') " )
	@GetMapping("/listarPageable1/{lazy}/{page}/{size}")
	public  ResponseEntity<Page<Autor>> rentorPageable1(@PathVariable boolean lazy,@PathVariable int page, @PathVariable int size) {		
		Page<Autor> listarAutor = service.listarPaginadoFacade(lazy, page, size);
		return new ResponseEntity<Page<Autor>>(listarAutor, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('Admin') OR hasAuthority('Invitado') " )
	@GetMapping("/listar1/{lazy}/{id}")
	public ResponseEntity<Autor> listarPorId1(@PathVariable boolean lazy ,@PathVariable  int id)  {
			Autor autor = service.listarPooIdFacede(lazy, id);
			return new ResponseEntity<Autor>(autor, HttpStatus.OK);					
	}
	
	@PostMapping("/guardarFacade")
	public ResponseEntity<Object> guardarFacade(@Valid @RequestBody Autor obj) {
		service.gusardarFacade(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@PostMapping("/edtitarFacade")
	public ResponseEntity<Object> editarFacade(@Valid @RequestBody Autor obj) {
		service.editarFacade(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminarFacade/{idAutor}")
	public ResponseEntity<Autor> eliminarFacade(@PathVariable int idAutor)  {
			service.eliminarFacade(idAutor);
			return new ResponseEntity<Autor>(HttpStatus.NO_CONTENT);					
	}
	
	@PreAuthorize("hasAuthority('Admin') OR hasAuthority('Invitado') " )
	@GetMapping("/listarCanatidadLibro/{id}")
	public ResponseEntity<AutorDescripcionLibro> listarPorIdAutorTotal(@PathVariable int id)  {
		AutorDescripcionLibro autor = service.listarPorIdAutorTodo(id);
			return new ResponseEntity<AutorDescripcionLibro>(autor, HttpStatus.OK);					
	}
	
	@PreAuthorize("hasAuthority('Admin') OR hasAuthority('Invitado') " )
	@GetMapping("/listartodo/{page}/{size}")
	public  ResponseEntity<Page<AutorDescripcionLibro>> listaAutorDesLibro(@PathVariable int page, @PathVariable int size) {		
		Page<AutorDescripcionLibro> listarAutor = service.listarAutortotalLibro(page, size);
		return new ResponseEntity<Page<AutorDescripcionLibro>>(listarAutor, HttpStatus.OK);
	}
	
	@PostMapping("/asociarLector")
	public ResponseEntity<Object> guardarAutorLector(@RequestBody AutorLectorDto obj) {
		service.guardarAutorLector(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@PostMapping("/asociarLectorLista")
	public ResponseEntity<Object> guardarAutorLectorLista(@RequestBody List<AutorLectorDto> obj) {
		service.guardarAutorLector(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	
	
	
	
	

}
