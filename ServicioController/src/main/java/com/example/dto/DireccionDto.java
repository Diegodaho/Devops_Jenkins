package com.example.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class DireccionDto {
	
	private Integer id;
	
	@NotNull(message = "la descripcion  es campo obligatorio")
	@Size(min = 3,  max = 50,  message = "descripcion debe ser entre 3 y 50")	
	private String barrio;
	
	@NotNull(message = "el barrio  es campo obligatorio")
	@Size(min = 3,  max = 12,  message = "barrio debe ser entre ")	
	private String descipcion;
	
	private AutorDto autor;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getDescipcion() {
		return descipcion;
	}
	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}
	public AutorDto getAutor() {
		return autor;
	}
	public void setAutor(AutorDto autor) {
		this.autor = autor;
	}
	
	

}
