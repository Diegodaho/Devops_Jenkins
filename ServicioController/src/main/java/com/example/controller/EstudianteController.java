package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.Profesor;


import com.example.service.Iimpl.IEstudianteService1;
import com.example.service.Iimpl.IProfesorService;
import com.example.service.impl.EstudianteServiceimpl;




@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	
	
	/*@Autowired
	IEstudianteService1 servi;*/
	
	@Autowired
	IProfesorService servis;
	
	Profesor p = new Profesor();
	
	
	@GetMapping("/buscarpro")
	public ResponseEntity<List<Profesor>> obtener()  {
		
		
		List<Profesor> listarestudiantes = servis.listar();
		
		
		
		return new ResponseEntity<List<Profesor>>(listarestudiantes, HttpStatus.OK);
		
	}
	
	@PostMapping("/guardarProfesor")
	public ResponseEntity<Profesor> agregarProfesor(@Valid @RequestBody Profesor profesr){
		

		//service.guardarEstudiante(estudiante.getCodigo(),estudiante.getNombre(),estudiante.getCurso());
		servis.guardar(profesr);
		return new ResponseEntity<Profesor>( profesr, HttpStatus.CREATED);
		
	}
	
	@GetMapping(path ="/listarc/{cedula}")
	public ResponseEntity<Profesor> buscarEstudiante(@PathVariable String cedula){
		
		Profesor cedua = servis.listarced(cedula);
		
		
		
		
		return new ResponseEntity<Profesor>(cedua, HttpStatus.OK);
	};
	
	@PutMapping("/editar")
	public ResponseEntity<Profesor> editarProfesor(@Valid @RequestBody Profesor profesr){
		

		//service.guardarEstudiante(estudiante.getCodigo(),estudiante.getNombre(),estudiante.getCurso());
		servis.editar(profesr);
		return new ResponseEntity<Profesor>( profesr, HttpStatus.CREATED);
		
	}
	
	@GetMapping(path ="/listarcombre/{page}/{size}/{nombre}")
	public ResponseEntity<Page<Profesor>> buscarnombre(@PathVariable int page,@PathVariable int size,@PathVariable String nombre){
		
		
		Page<Profesor> nomb = servis.listarPornombre(page, size, nombre);
		
		
		return new ResponseEntity<Page<Profesor>>(nomb,HttpStatus.OK);
	};
	

	
	
	
	/*@GetMapping("/buscar")
	public ResponseEntity<List<EstudianteDto>> obtenerListaEstudiante() throws NotFoundModelException {
		
		
		List<EstudianteDto> listarestudiantes = servi.listarTodos();
		
		
		return new ResponseEntity<List<EstudianteDto>>(listarestudiantes, HttpStatus.OK);
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<EstudianteDto> agregarEstudiantes(@Valid @RequestBody EstudianteDto estudiante) throws FoundModelException, NotFoundModelException{
		

		//service.guardarEstudiante(estudiante.getCodigo(),estudiante.getNombre(),estudiante.getCurso());
		servi.guardarEstudiante(estudiante);
		return new ResponseEntity<EstudianteDto>( estudiante, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/editar")
	public ResponseEntity<EstudianteDto> editarEstudiante(@Valid @RequestBody EstudianteDto estudiante) throws NotFoundModelException{
		
		
		
		
		 
		
		servi.editarEstudiante(estudiante);
		
		return new ResponseEntity<EstudianteDto>( estudiante, HttpStatus.OK);
		
		
		
		
	}
	
	
	@GetMapping(path ="/buscarid")
	public ResponseEntity<EstudianteDto> buscarEstudiante(@RequestParam (value="codigo",required=true) int codigo) throws NotFoundModelException{
		
		EstudianteDto estu = servi.obtenerEstudiante(codigo);
		
		
		
		return new ResponseEntity<EstudianteDto>(estu, HttpStatus.OK);
	};
	
	@DeleteMapping(path ="/eliminar/{codigo}")
	public ResponseEntity<Object> eliminarEstudiante(@PathVariable Integer codigo) throws NotFoundModelException{
		
	
		
		
	
		
		 servi.eliminarEstudinate(codigo);
		  return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		 
		                   
		
		
	}
	
	@PostMapping("/guardarmas")
	public ResponseEntity<EstudianteDto> agregarUsuario(@RequestBody  EstudianteDto estudiante ){
		

		//service.guardarEstudiante(estudiante.getCodigo(),estudiante.getNombre(),estudiante.getCurso());
		
	
		
		servi.agregarEstusiante(estudiante);
		
		return new ResponseEntity<EstudianteDto>( estudiante, HttpStatus.CREATED);
		
		
		
	}
	
	@GetMapping("/buscarmas")
	public ResponseEntity<List<EstudianteDto>> obtenerusuario()  {
		
		
		List<EstudianteDto> listarestudiantes = servi.obtenerEstu();
		
		
		return new ResponseEntity<List<EstudianteDto>>(listarestudiantes, HttpStatus.OK);
		
	}
	

	
	
	*/
	
	

}
