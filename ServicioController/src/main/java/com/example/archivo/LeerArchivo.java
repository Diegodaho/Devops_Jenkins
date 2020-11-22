package com.example.archivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.EstudianteDto;

public class LeerArchivo {
	
	List<EstudianteDto> p;
    File f;
    public List<EstudianteDto> leer(){
        p= new ArrayList<>();
        f=new File("d.txt");
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(f))) {
        p=(ArrayList<EstudianteDto>) entrada.readObject();
        }catch(Exception ex){
            System.out.println("Error al leer el archivo");
            System.err.println(ex.getMessage());
            System.err.println(ex.getStackTrace());
        }
        return p;
    }

}
