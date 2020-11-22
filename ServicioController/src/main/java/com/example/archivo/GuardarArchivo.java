package com.example.archivo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.dto.EstudianteDto;

public class GuardarArchivo {
	
	 File f;        
     public void guardar(List<EstudianteDto> p){
     System.out.println("entro al guardar");
     ObjectOutputStream salida=null;
         try {
             f =new File("d.txt");
             salida = new ObjectOutputStream(new FileOutputStream(f));
             salida.writeObject(p);
         } catch (IOException ex) {
             Logger.getLogger(GuardarArchivo.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
             try {
                 salida.close();
             } catch (IOException ex) {
                 Logger.getLogger(GuardarArchivo.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     
}

}
