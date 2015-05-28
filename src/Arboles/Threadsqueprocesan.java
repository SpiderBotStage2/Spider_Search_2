/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import Listas.NodoLUrl;
import logica.LectorPDF;

/**
 *
 * @author Gustavo
 */
public class Threadsqueprocesan implements Runnable {

    private Arbol_AVL KeywordsyRepeticiones = new Arbol_AVL();
    private String DireccionArchivoAProcesar;
    
    public Threadsqueprocesan( String Dirreccion,Arbol_AVL Keywords) {
        DireccionArchivoAProcesar = Dirreccion;
        KeywordsyRepeticiones=Keywords;
    }
    
    public Threadsqueprocesan( String Dirreccion) {
        DireccionArchivoAProcesar = Dirreccion;
    }
    
    public void run() {
        String parrafoAProcesar = null;
        LectorPDF pdf= new LectorPDF(DireccionArchivoAProcesar);
        System.out.println(pdf.ContenidoDelArchivo);
        String[] words = pdf.ContenidoDelArchivo.split("\\s+");
        NodoLUrl NodoUrl = new NodoLUrl (DireccionArchivoAProcesar,1);
        for (int i =0; i<words.length;i++){
            if (words[i].length()>2){
                try{
                    insert(new NodoKeyword(words[i], NodoUrl));
                }catch(StackOverflowError e){
                    System.out.println("Error: out of stack");
                }
            }
        }
    }
    
    public void insert(NodoKeyword pNodo){
        synchronized(this){
            KeywordsyRepeticiones.insert(pNodo);
        }
    }
}

   


