/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import Listas.NodoLUrl;
import java.io.File;
import java.util.Arrays;
import logica.LectorPDF;

/**
 *
 * @author Gustavo
 */
public class Threadsqueprocesan implements Runnable {

    private Arbol_AVL KeywordsyRepeticiones = new Arbol_AVL();
    private String DireccionArchivoAProcesar;
    public Threadsqueprocesan( String Dirreccion) {
        DireccionArchivoAProcesar = Dirreccion;
    }

   
    public void run() {
    
    
    String parrafoAProcesar = null;
    LectorPDF pdf= new LectorPDF(DireccionArchivoAProcesar);
    System.out.println(pdf.ContenidoDelArchivo);
    
    
    String[] words = pdf.ContenidoDelArchivo.split("\\s+");
    for (int i = 0; i < words.length; i++) {
    // You may want to check for a non-word character before blindly
    // performing a replacement
    // It may also be necessary to adjust the character class
        
    }
    NodoLUrl NodoUrl = new NodoLUrl (
            DireccionArchivoAProcesar
            ,1
    );
    System.out.println(Arrays.toString(words));
    while(words != null) {
        File NodoAInsertar = new File(words[0]);
        System.out.println(words[0]);
        
        if (words.length>1){
            
            words = Arrays.copyOfRange(
                    words, 
                    1, 
                    words.length
            );
        }
       
           
                
                NodoKeyword Keywords = new NodoKeyword(words[0],NodoUrl);
                synchronized(KeywordsyRepeticiones){
                KeywordsyRepeticiones.insert(Keywords);
                }
                        }
        
            
                   
                        
                        }
		
    }

   


