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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Autor;
import com.example.entity.Usuario;
import com.example.service.Iimpl.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UserController {
	
	@Autowired
	private IUsuarioService service;
	
	
	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/listarPageable/{lazy}/{page}/{size}")
	public  ResponseEntity<Page<Usuario>> rentorPageable(@PathVariable boolean lazy ,@PathVariable int page, @PathVariable int size) {		
		Page<Usuario> listarUsuario = service.listarPaginadoFacade(lazy, page, size);
		return new ResponseEntity<Page<Usuario>>(listarUsuario, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@Valid @RequestBody Usuario obj) {
		service.gusardarFacade(obj);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	@PreAuthorize("hasAuthority('Admin')")
	@DeleteMapping("/eliminar/{idUsuario}")
	public ResponseEntity<Usuario> eliminar(@PathVariable int idUsuario)  {
			service.eliminarFacade(idUsuario);
			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);					
	}

}
