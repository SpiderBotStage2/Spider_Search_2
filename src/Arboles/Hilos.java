package Arboles;

import logica.Heap;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Gustavo
 */
public class Hilos {

    private Arbol_AVL _KeywordsyRepeticiones;
    private Threadsqueprocesan[] _hilos;
    private Heap _heap;
    
    public Hilos(){
        this._KeywordsyRepeticiones= new Arbol_AVL();
        _hilos= new Threadsqueprocesan[2];
        _heap= new Heap();
    }
    public void RunAll(){
        Threadsqueprocesan test1 = new Threadsqueprocesan (
               "/home/osboxes/Desktop/archivo.pdf", _KeywordsyRepeticiones);
        Threadsqueprocesan test2 = new Threadsqueprocesan (
               "/home/osboxes/Desktop/README.txt", _KeywordsyRepeticiones);
        test2.run();
        test1.run();
    }
    
    public static void main(String[] args) throws InterruptedException {
        Hilos nuevo = new Hilos();
        nuevo.RunAll();
    }
}

   
   

