package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "direccion")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@NotNull(message = "la descripcion  es campo obligatorio")
	@Size(min = 3,  max = 50,  message = "descripcion debe ser entre 3 y 50")	
	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;
	
	@NotNull(message = "el barrio  es campo obligatorio")
	@Size(min = 3,  max = 12,  message = "barrio debe ser entre ")	
	@Column(name = "barrio", nullable = false, length = 12)
	private String barrio;
	
	@OneToOne
	@MapsId
	private Autor autor;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	
	@JsonIgnore
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	
	
	
	
	
	

}
