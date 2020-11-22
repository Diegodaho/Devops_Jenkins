package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "lector")
public class Lector {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer Id;
	
	@NotNull
	@Size(min = 7,max = 11, message = "La cédula debe ser entre 7 y 11 carácteres")	
	@Column(name = "cedula", nullable = false, length = 11)
	private String cedula;	
	
	@NotNull
	@Size(min = 5,max = 25, message = "El nombre debe ser entre 5 y 25 carácteres")	
	@Column(name = "nombre", nullable = false, length = 25)
	private String nombre;
	
	@NotNull
	@Size(min = 5,max = 25, message = "El apellido debe ser entre 5 y 25 carácteres")		
	@Column(name = "apellido", nullable = false, length = 25)
	private String apellido;
	
	public Integer getId() {
		return Id;
	}

	public String getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


}
