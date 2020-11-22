package com.example.view;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;



@Entity
@Table(name = "autor_direccion_total_libro")
@Immutable
public class AutorDescripcionLibro {
	
	@Id
	@Column(name = "autorid")
	private Integer Id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	
	@Column(name = "fecha")
	private LocalDate fechaNacimiento;
	
	
	@Column(name = "barrio")
	private String barrio;
	
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "numero_libros")
	private Integer numeroLibro;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getNumeroLibro() {
		return numeroLibro;
	}

	public void setNumeroLibro(Integer numeroLibro) {
		this.numeroLibro = numeroLibro;
	}
	
	
	

}
