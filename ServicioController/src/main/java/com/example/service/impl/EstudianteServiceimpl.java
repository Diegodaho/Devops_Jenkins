package com.example.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.archivo.GuardarArchivo;
import com.example.archivo.LeerArchivo;
import com.example.dto.EstudianteDto;
import com.example.entity.Profesor;
import com.example.exeption.FoundModelException;
import com.example.exeption.NotFoundModelException;
import com.example.repository.IProfesorRepo;
import com.example.service.Iimpl.IEstudianteService1;




@Service
public class EstudianteServiceimpl implements IEstudianteService1  {
	
	
	
	EstudianteDto p = new EstudianteDto();
    List<EstudianteDto> estudian;
    GuardarArchivo save = new GuardarArchivo();
    LeerArchivo read = new LeerArchivo();
    

    private  Connection connection = null;
	private Statement s = null;
	private ResultSet set = null;
	
	
	
	
	@Override
	public boolean guardarEstudiante(EstudianteDto estudiante) throws FoundModelException, NotFoundModelException{
		
		estudian = new ArrayList<>();
	     
		 estudian=read.leer();
		/* if( estudiante.getCodigo()==null) {
			 
			 throw new NotFoundModelException("campo obligatorio");
			 
		 }*/
	        for(EstudianteDto temp: estudian){
	        	
	            if(temp.getCodigo() == estudiante.getCodigo()){
	            	
	            	
	            	
	            	return false;
	            	
	         
	       	
	            	
	            }
	            	
	      	        
	 
	            
	        }
	        
	       
	        estudian.add(estudiante);
            save.guardar(estudian);
            return true;
   	    
		
	}
	
	

	@Override
	public EstudianteDto obtenerEstudiante(int codi) throws NotFoundModelException {
		
		 estudian = new ArrayList<>();
		 estudian=read.leer();
	
		
         for (EstudianteDto lp : estudian) {
         if(lp.getCodigo()==codi ){
             return lp;
         }
       
				
			            
      }
         
         throw new NotFoundModelException("Objeto persona no encontrado");
	}

	@Override
	public boolean eliminarEstudinate(int cedu)throws NotFoundModelException {
		
		estudian = new ArrayList<>();
	        //read = new LeerArchivo();
	
		estudian=read.leer();
	        for(EstudianteDto lp: estudian){
	            if(cedu==lp.getCodigo()){
	            	estudian.remove(lp);
	                save.guardar(estudian);
	               
	           return true;
	              
	               
	            }
	        }
	       
	        throw new NotFoundModelException("el codigo no se encuntra");
	        
	        
	        //save.guardar(persons);
	        
        
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarEstudiante(EstudianteDto estudiante) throws NotFoundModelException{
		
		estudian = new ArrayList<>();
		
	     estudian=read.leer();
	         for(EstudianteDto lp: estudian){
	            if(lp.getCodigo()==estudiante.getCodigo()){
	                lp.setNombre(estudiante.getNombre());
	                lp.setCurso(estudiante.getCurso());
	                
	               
	                save.guardar(estudian);
	                
	            
	        }
	        	 
	         
	         
	         }
	         
	        
	         

		
	}

	@Override
	public List<EstudianteDto> listarTodos()throws NotFoundModelException {
		estudian = new ArrayList<>();
		estudian = read.leer();
		System.out.println(estudian);
		return estudian;
		
		
	}
	
	public void conexion(){
		
		
		
		
	     String host="localhost";
	     String port="5432";
	     String db_name="test";
	     String username="postgres";
	     String password="123456";
	     try {
	         Class.forName("org.postgresql.Driver");
	         connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
	         if (connection != null) {
	             System.out.println("Connection OK");
	         } else {
	             System.out.println("Connection Failed");
	         }
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	}
	
	
	public void agregarEstusiante(EstudianteDto datos ) {
		
		
		
		
		conexion();
		
		try {
			
			
			
			
			s = connection.createStatement();
			
			int z = s.executeUpdate("INSERT INTO usuariosp (id, nombre, curso) VALUES ('"+ datos.getCodigo() +"','"+ datos.getNombre() +"','"+ datos.getCurso() +"')");
			
			
			
			if( z == 1 ) {
				
				System.out.println("se agregado el usuario");
			}else {
				
				System.out.println("ocurrio un problema al agregar");
			}
			
		}catch(Exception e) {
			
			System.out.println("Error de conexion");
			
		}
		
		
		
		
		
		
		
	}
	
	
	 public List<EstudianteDto> obtenerEstu(){
		  
		  conexion();
		  
		  List<EstudianteDto> usu= new ArrayList<>();
		  
		 
		  
		  try {
				

				
				s = connection.createStatement();
				
				 set = s.executeQuery("SELECT * FROM usuariosp");

				
				
			}catch(Exception e) {
				
				System.out.println("Error de conexion");
				
			}
		  
		
		  
		  
		  
		  try {
			  
			
		  
		  while (set.next()) {
			 
			
			  EstudianteDto est = new EstudianteDto();
			  est.setCodigo(set.getInt(1));
			  est.setNombre(set.getString(2));
			  est.setCurso(set.getInt(3));
			 
			
			  
			 usu.add(est);
			 System.out.println(usu);
			  
		
			  
			  
	
				 
			 }
		  
		 
		 
		  
		  
	       }catch(Exception e) {
				
				System.out.println("problema al imprimir");
				
			}
		  
		 
		  return usu;
		 
		  
	  }



	

}
