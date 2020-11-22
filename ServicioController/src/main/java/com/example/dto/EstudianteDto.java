package com.example.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




public class EstudianteDto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	

	private Integer codigo;

	/**
	 * validacion para agregar campos correctos
	 */
	@NotNull(message = "nombre es un Campo Obligatorio")
	@Size(min=5, max=10, message = "Tiene que ser tipo letra Minimo= 5 Maximo= 10 caracteres")
	private String nombre;
	
	/**
	 * validacion para agregar campos correctos
	 */
	@NotNull(message = "curso es un Campo Obligatorio")
	@Min(3)
	private Integer curso;
	
	
	
	
    /**
     * costructor de la clase EstudianteDto
     * @param codigo 
     * @param nombre
     * @param curso
     */
	public EstudianteDto(Integer codigo, String nombre, Integer curso) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
	}
	
	
	
	public EstudianteDto() {
		
	}
	
	
    /**
     * returna codigo
     * @return codigo
     */
	public Integer getCodigo() {
		return codigo;
	}
	
	
    /**
     * parametro para crear codigo
     * @param codigo
     */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * retorna nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * parametro para crear
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
    /**
     * metodo retornar curso
     * @return curso
     */
	public Integer getCurso() {
		return curso;
	}
	
    /**
     * metodo de crear 
     * @param curso
     */
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	
	
	

}
