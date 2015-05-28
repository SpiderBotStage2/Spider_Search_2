/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Arboles.Threadsqueprocesan;
import java.io.File;
import java.util.Arrays;

/**
 *
 * @author Gustavo
 */
public class CreaciondeHeapPorTamanoDeDocumentos {
    public String ubicacion = null;
    public CreaciondeHeapPorTamanoDeDocumentos
        (String[] ArregloConVariasUbicacionesDeDocumentos){
    Heap HeapDeDocumentos= new Heap();
    while(ArregloConVariasUbicacionesDeDocumentos != null) {
        File file =new File(ArregloConVariasUbicacionesDeDocumentos[0]);
        ubicacion =new String (ArregloConVariasUbicacionesDeDocumentos[0]);
        if (ArregloConVariasUbicacionesDeDocumentos.length>1){
            
            ArregloConVariasUbicacionesDeDocumentos = Arrays.copyOfRange(
                    ArregloConVariasUbicacionesDeDocumentos, 
                    1, 
                    ArregloConVariasUbicacionesDeDocumentos.length
            );
        }
        else{ArregloConVariasUbicacionesDeDocumentos = null;}
        
            if(file.exists()){
        	double kilobytes = file.length();
            	System.out.println("kilobytes : " + kilobytes/1024);
                String HeapInsert = Double.toString(kilobytes/1024);
                HeapDeDocumentos.insert(ubicacion);
                Threadsqueprocesan test1 = new Threadsqueprocesan (
                ubicacion);
		test1.run();
                
		}
            else{
			 System.out.println("File does not exists!");
                }
    }
    HeapDeDocumentos.print();
}
}
