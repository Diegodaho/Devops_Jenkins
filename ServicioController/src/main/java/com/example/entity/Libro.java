package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer Id;
	
	@NotNull(message = "el nombre del libro es campo obligatorio")
	@Column(name = "nombre", nullable = false, length = 25)
	private String nombre;
	
	@NotNull(message = "el numero de paginas  del libro es requerido")
	@Column(name = "numero_paginas", nullable = false, length = 25)
	private Integer numeroPaginas;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "id_autor", nullable = false, foreignKey = @ForeignKey(name = "FK_Autor_Libro"))	
	private Autor autor;
	
	


	public Integer getId() {
		return Id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	@JsonIgnore
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}		


}
