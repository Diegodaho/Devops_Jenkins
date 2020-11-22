package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.Rol;
import com.example.entity.Usuario;
import com.example.exeption.ArgumentRequiredException;
import com.example.exeption.BusinessLogicException;
import com.example.exeption.ModelNotFoundException;
import com.example.repository.IUsuarioRepo;
import com.example.service.Iimpl.IUsuarioService;



@Service
public class UsuarioServiceimpl implements IUsuarioService,UserDetailsService  {
	

	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Override
	public Page<Usuario> listarPaginadoFacade(boolean lazy, int page, int size) {
		
		Page<Usuario> suario = repo.findAll(PageRequest.of(page, size));;
		if(lazy) {
			for (Usuario li : suario.getContent()) {
				
				li.setRol(null);;
				 
			}			
		}
		
		
		return suario;
	}

	@Override
	public Usuario listarPooIdFacede(boolean lazy, Integer id) {
		

		return null;
	}

	@Override
	public void gusardarFacade(Usuario clase) {
		if(clase.getRol().getIdRol()==null) {
			new ModelNotFoundException("tipo de rol no encontrado");
		}
		
		Usuario usuari= new Usuario();
		
		usuari.setDocumento(clase.getDocumento());
		usuari.setNombre(clase.getNombre());
		usuari.setApellido(clase.getApellido());
		usuari.setNick(clase.getNick());
		usuari.setClave(bcrypt.encode(clase.getClave()));
		usuari.setEstado(clase.isEstado());
		
		Rol rol = new Rol();
		
		rol.setIdRol(clase.getRol().getIdRol());
		usuari.setRol(rol);
		
		repo.save(usuari);
		
		
		
	  	}

	@Override
	public void editarFacade(Usuario clase) {
		if(clase.getIdUsuario() == null)
			throw new ArgumentRequiredException("Id Usuario  es requerido");
		
			
		
		Usuario usuari = repo.findById(clase.getIdUsuario()).orElseThrow(() 
				-> new ModelNotFoundException("Usuario no encontrada"));
		
       
		
		usuari.setDocumento(clase.getDocumento());
		usuari.setNombre(clase.getNombre());
		usuari.setApellido(clase.getApellido());
		usuari.setNick(clase.getNick());
		usuari.setClave(bcrypt.encode(clase.getClave()));
		usuari.setEstado(clase.isEstado());
		
		repo.save(usuari);
		
	}

	@Override
	public void eliminarFacade(Integer id) {
		
		boolean exis= repo.existsById(id);
				
		if(exis==false) {
			new ModelNotFoundException("Usuario no encontrado");
		}
	     repo.deleteById(id);	
	}

	@Override
	public UserDetails loadUserByUsername(String nick) throws UsernameNotFoundException {
		
		Usuario usuario = repo.findByNick(nick);
		if(usuario == null)
			throw new ModelNotFoundException("----Nick o password incorecto");
		if(usuario.isEstado() == false)
			throw new BusinessLogicException("----Usuario deshabilitado");
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
		
		UserDetails ud = new User(usuario.getNick(), usuario.getClave(), roles);		
		return ud;
	}

	

}
